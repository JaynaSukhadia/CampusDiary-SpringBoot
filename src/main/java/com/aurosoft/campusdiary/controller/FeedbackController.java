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

import com.aurosoft.campusdiary.entity.Feedback;
import com.aurosoft.campusdiary.repository.FeedbackRepository;
@Controller
@RequestMapping("/feedback")
public class FeedbackController {
	
	FeedbackRepository feedbackRepository;
	
	public FeedbackController(FeedbackRepository feedbackRepository) {
		this.feedbackRepository =feedbackRepository;
	}
	
	@GetMapping("/list")
	public String listFeedback(Model m) {
		List<Feedback> list = feedbackRepository.findAll();
		m.addAttribute("list",list);
		return"feedback_list";
	}
	@GetMapping("/newfeedback")
	public String showForm(Feedback feedback) {
		return "feedback_entry";
	}
	@GetMapping("/edit/{id}")
	public String editFeedback(@PathVariable int id ,Model m) {
		Optional<Feedback> feedback = feedbackRepository.findById(id);
		Feedback fb =null;
		if(feedback.isPresent())
			fb = feedback.get();
		m.addAttribute("feedback",fb);
		return "feedback_edit";
	}
	@PostMapping("/insert")
	public String insertFeedback(@ModelAttribute("feedback") Feedback feedback) {
		
		feedbackRepository.save(feedback);
		return "redirect:/feedback/list";
	}
	@PostMapping("/update")
	public String updateFeedback(@ModelAttribute("feedback") Feedback feedback) {
		feedbackRepository.save(feedback);
		return "redirect:/feedback/list";
	}
	@GetMapping("/delete/{id}")
	public String deleteFeedback(@PathVariable int id) {
		feedbackRepository.deleteById(id);
		return "redirect:/feedback/list";
	}
}
