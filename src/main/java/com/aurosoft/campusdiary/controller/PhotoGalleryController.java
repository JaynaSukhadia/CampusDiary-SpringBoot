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

import com.aurosoft.campusdiary.entity.PhotoGallery;
import com.aurosoft.campusdiary.repository.PhotoGalleryRepository;

@Controller
@RequestMapping("/photogallery")
public class PhotoGalleryController {
	
	PhotoGalleryRepository photoGalleryRepository;
	@Autowired
	public PhotoGalleryController(PhotoGalleryRepository photoGalleryRepository) {
		this.photoGalleryRepository=photoGalleryRepository;
	}

	@GetMapping("/list")
	public String listphotoGallery(Model m) {
		List<PhotoGallery> list = photoGalleryRepository.findAll();
		m.addAttribute("list",list);
		return"photoGallery_list";
	}
	@GetMapping("/newphotoGallery")
	public String showForm(PhotoGallery photoGallery) {
		return "photoGallery_entry";
	}
	@GetMapping("/edit/{id}")
	public String editphotoGallery(@PathVariable int id ,Model m) {
		Optional<PhotoGallery> photoGallery = photoGalleryRepository.findById(id);
		PhotoGallery pg =null;
		if(photoGallery.isPresent())
			pg = photoGallery.get();
		m.addAttribute("photoGallery",pg);
		return "photoGallery_edit";
	}
	@PostMapping("/insert")
	public String insertphotoGallery(@ModelAttribute("photoGallery") PhotoGallery photoGallery) {
		
		photoGalleryRepository.save(photoGallery);
		return "redirect:/photogallery/list";
	}
	@PostMapping("/update")
	public String updatephotoGallery(@ModelAttribute("photoGallery") PhotoGallery photoGallery) {
		photoGalleryRepository.save(photoGallery);
		return "redirect:/photogallery/list";
	}
	@GetMapping("/delete/{id}")
	public String deletephotoGallery(@PathVariable int id) {
		photoGalleryRepository.deleteById(id);
		return "redirect:/photogallery/list";
	}
}
