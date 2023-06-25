package com.aurosoft.campusdiary.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurosoft.campusdiary.entity.Suggestion;
import com.aurosoft.campusdiary.repository.SuggestionRepository;

@Controller
@RequestMapping("/suggestion")
public class SuggestionController {

	
	SuggestionRepository repository;
	 
	 
	public SuggestionController(SuggestionRepository sp)
	{
		this.repository = sp;
	}

		@GetMapping("/list")
		public String listSuggestion(Model m)
		{
			List<Suggestion> list = repository.findAll();
			m.addAttribute("list",list);
			return "suggestion_list";
		}
		
		@GetMapping("/newsuggestion")
		public String showForm(Suggestion suggestion)
		{
			return "suggestion_entry";
		}
		@PostMapping("/insert")
		public String insertSuggestion(@ModelAttribute("suggestion") Suggestion s)
		{
			repository.save(s);
			return "redirect:/suggestion/list";
		}
		
		@GetMapping(value="/edit/{id}")
		public String editSuggestion(@PathVariable int id, Model m)
		{
			Optional<Suggestion> suggestion= repository.findById(id);
			Suggestion s = null;
			if(suggestion.isPresent())
				s = suggestion.get();
			
			m.addAttribute("suggestion",s);
			return "suggestion_edit";
		}
		
		@PostMapping(value="/update")
		public String updateSuggestion(@ModelAttribute("suggestion") Suggestion suggestion)
		{
			repository.save(suggestion);
			return "redirect:/suggestion/list";
		}
		
		@GetMapping(value="/delete/{id}")
		public String deleteSuggestion(@PathVariable int id,Model m)
		{
			repository.deleteById(id);
			return "redirect:/suggestion/list";
		}
}
