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
import com.aurosoft.campusdiary.entity.ReplayComment;
import com.aurosoft.campusdiary.repository.ReplayCommentRepository;


@Controller
@RequestMapping("/replay")
public class ReplayCommentController {

    ReplayCommentRepository repository;
 
    public ReplayCommentController(ReplayCommentRepository replayrepository) {
        this.repository = replayrepository;
    }
    
    
  //list page
    @GetMapping("/list")
	public String listReplay(Model m) {
		List<ReplayComment> list = repository.findAll();
		m.addAttribute("list",list);
		return"replaylist";
	}
    
  //show reply comment
    @GetMapping("/newreplay")
	public String showForm(ReplayComment replaycomment) {
		return "replayaddpage";
	}
    //insert page
    @PostMapping("/insert")
	public String insertreplay(@ModelAttribute("replaycomment") ReplayComment replaycomment) {
		
		repository.save(replaycomment);
		return "redirect:/replay/list";
	}
    
    
    
    //show reply comment edit
    @RequestMapping(value="/edit/{id}")
    public String showedit(@PathVariable int id,Model m) {
	Optional<ReplayComment> replaycomment =repository.findById(id);
	ReplayComment rc1 =null;
	if(replaycomment.isPresent())
	    rc1 = replaycomment.get();
	m.addAttribute("replaycomment",rc1);
	return "replayedit";
    }
    //update
    @RequestMapping("/update")
    public String update(@ModelAttribute("replay")ReplayComment replayComment){
	repository.save(replayComment);
	return "redirect:/replay/list";
    }
   
    //delete
    @RequestMapping(value="/delete/{id}")
    public String deletepage(@PathVariable int id,Model m) {
	repository.deleteById(id);
	return "redirect:/replay/list";
    }
}
