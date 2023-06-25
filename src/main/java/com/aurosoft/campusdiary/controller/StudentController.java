package com.aurosoft.campusdiary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurosoft.campusdiary.entity.Student;
import com.aurosoft.campusdiary.repository.StudentRepository;

@Controller
@RequestMapping("/student")
public class StudentController {

    StudentRepository studentrepository;
    //StudentRepository set method
    public StudentController(StudentRepository studentrepository) {
        this.studentrepository = studentrepository;
    }
    //showform page
    @RequestMapping("/entry")
    public String showentry(Student student) {
	return "studententry" ;
    }
    //insert
    @RequestMapping("/insert")
    public String insert(@ModelAttribute("student")Student student) {
	studentrepository.save(student);
	return "redirect:/student/list";
    }
    //showedit page
    @RequestMapping(value="/edit/{id}")
    public String showedit(@PathVariable int id,Model m) {
	Optional<Student> student =studentrepository.findById(id);
	Student std =null;
	if(student.isPresent())
	    std= student.get();
	m.addAttribute("student",std);
	return "studentedit";
    }
    //update
    @RequestMapping("/update")
    public String update(@ModelAttribute("student")Student student){
	studentrepository.save(student);
	return "redirect:/student/list";
    }
    //list page
    @RequestMapping("/list")
    public String listpage(Model m) {
	List<Student> list =studentrepository.findAll();
	m.addAttribute("list",list);
	return "Studentlist";
    }
    //delete
    @RequestMapping(value="/delete/{id}")
    public String deletepage(@PathVariable int id,Model m) {
	studentrepository.deleteById(id);
	return "redirect:/student/list";
    }
}
