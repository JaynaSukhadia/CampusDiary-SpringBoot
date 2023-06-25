package com.aurosoft.campusdiary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurosoft.campusdiary.entity.CommentPost;
import com.aurosoft.campusdiary.repository.CommentPostRepository;

@Controller
@RequestMapping("/comment")
public class CommentPostController {
	
	CommentPostRepository repository;
	@Autowired
	public CommentPostController(CommentPostRepository commentPostRepository) {
		this.repository=commentPostRepository;
	}
	@GetMapping("/list")
	public String listcommentpost (Model m) {
		List<CommentPost> list = repository.findAll();		
		m.addAttribute("list", list);
		return "commentpost_list";
	}
	
	@GetMapping("/newcommentpost")
	public String showForm(CommentPost commentPost)
	{
		return "commentpost_entry";
	}
	
	@PostMapping("/insert")
	public String insertcommentpost(@ModelAttribute("commentpost") CommentPost commentPost) 
	{
		repository.save(commentPost);
		return "redirect:/comment/list";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editcommentpost(@PathVariable int id, Model m)
	{
		Optional<CommentPost>commentpost=repository.findById(id);
		CommentPost cp = null;
		if(commentpost.isPresent())
			cp = commentpost.get();
		
		m.addAttribute("commentpost", cp);
		return "commentpost_edit";
			
	}
	
	@PostMapping(value="/update")
	public String updateCommentpost(@ModelAttribute("commentpost") CommentPost commentPost)
	{
		repository.save(commentPost);
		return "redirect:/comment/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String deletecommentpost(@PathVariable int id,Model m) 
	{
		repository.deleteById(id);
		return "redirect:/comment/list";
	}


}
