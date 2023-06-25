package com.aurosoft.campusdiary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurosoft.campusdiary.entity.Staff;
import com.aurosoft.campusdiary.repository.StaffRepository;

@Controller
@RequestMapping("/staff")
public class StaffController {

    StaffRepository staffrepository;
  //StudentRepository set method

    public StaffController(StaffRepository staffrepository) {
        this.staffrepository = staffrepository;
    }
    
    //showentry page
    @RequestMapping("/entry")
    public String showentry(Staff staff) {
   	return "staffentry" ;
       }
    //insert
    @RequestMapping("/insert")
    public String insertstaff(@ModelAttribute("staff")Staff staff) {
	staffrepository.save(staff);
	return "redirect:/staff/list" ;
       }
    //show edit page
    @RequestMapping(value="/edit/{id}")
    public String showedit(@PathVariable int id,Model m) {
   	Optional<Staff> staff= staffrepository.findById(id);
   	Staff st1 =null;
   	if(staff.isPresent())
   	    st1=staff.get();
   	m.addAttribute("staff",st1);
	return "staffedit" ;
       }
    //update
    @RequestMapping("/update")
    public String upadetpage(@ModelAttribute("staff")Staff staff) {
	staffrepository.save(staff);
   	return "redirect:/staff/list" ;
       }
    //list page
    @RequestMapping("/list")
    public String listpage(Model m) {
	List<Staff> list=staffrepository.findAll();
	m.addAttribute("list",list);
   	return "stafflist" ;
       }
    //delete
    @RequestMapping(value="/delete/{id}")
    public String deletepage(@PathVariable int id, Model m) {
	staffrepository.deleteById(id);
   	return "redirect:/staff/list" ;
       }
    
}
