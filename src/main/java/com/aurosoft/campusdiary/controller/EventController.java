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

import com.aurosoft.campusdiary.entity.Event;
import com.aurosoft.campusdiary.repository.EventRepository;

@Controller
@RequestMapping("/event")
public class EventController {
	
	EventRepository repository;
	@Autowired
	public EventController(EventRepository feRepository) {
		this.repository= feRepository;
	}

	@GetMapping("/list")
	public String listEvent(Model m) {
		List <Event> list = repository.findAll();
		m.addAttribute("list",list);
		return"event_list";
	}
	@GetMapping("/newEvent")
	public String showForm(Event event) {
		return "event_entry";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id ,Model m) {
		Optional<Event> event = repository.findById(id);
		Event e =null;
		if(event.isPresent())
			e = event.get();
		m.addAttribute("event",e);
		return "event_edit";
	}
	@PostMapping("/insert")
	public String insertEvent(@ModelAttribute("event") Event event) {
		
		repository.save(event);
		return "redirect:/event/list";
	}
	@PostMapping("/update")
	public String updateEvent(@ModelAttribute("event") Event event) {
		repository.save(event);
		return "redirect:/event/list";
	}
	@GetMapping("/delete/{id}")
	public String deleteEvent(@PathVariable int id) {
		repository.deleteById(id);
		return "redirect:/event/list";
	}

}
