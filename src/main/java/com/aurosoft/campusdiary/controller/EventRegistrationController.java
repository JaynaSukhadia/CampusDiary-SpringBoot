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

import com.aurosoft.campusdiary.entity.EventRegistration;
import com.aurosoft.campusdiary.repository.EventRegistrationRepository;

@Controller
@RequestMapping("/eventregistration")
public class EventRegistrationController {
	
	EventRegistrationRepository repository;
	@Autowired
	public EventRegistrationController(EventRegistrationRepository repository) {
		this.repository =repository;
	}
	
	@GetMapping("/list")
	public String listEventRegistration(Model m) {
		List<EventRegistration> list = repository.findAll();
		m.addAttribute("list",list);
		return"eventRegistration_list";
	}
	@GetMapping("/neweventRegistration")
	public String showForm(EventRegistration eventRegistration) {
		return "eventRegistration_entry";
	}
	@GetMapping("/edit/{id}")
	public String editEventRegistration(@PathVariable int id ,Model m) {
		Optional<EventRegistration> eventRegistration = repository.findById(id);
		EventRegistration e =null;
		if(eventRegistration.isPresent())
			e = eventRegistration.get();
		m.addAttribute("eventRegistration",e);
		return "eventRegistration_edit";
	}
	@PostMapping("/insert")
	public String insertEventRegistration(@ModelAttribute("eventRegistration") EventRegistration eventRegistration) {
		
		repository.save(eventRegistration);
		return "redirect:/eventregistration/list";
	}
	@PostMapping("/update")
	public String updateEventRegistration(@ModelAttribute("eventRegistration") EventRegistration eventRegistration) {
		repository.save(eventRegistration);
		return "redirect:/eventregistration/list";
	}
	@GetMapping("/delete/{id}")
	public String deleteEventRegistration(@PathVariable int id) {
		repository.deleteById(id);
		return "redirect:/eventregistration/list";
	}

}
