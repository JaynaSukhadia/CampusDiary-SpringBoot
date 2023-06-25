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

import com.aurosoft.campusdiary.entity.Notification;
import com.aurosoft.campusdiary.repository.NotificationRepository;
@RequestMapping("/notification")
@Controller

public class NotificationController {

	NotificationRepository repository;
	
	public NotificationController(NotificationRepository notificationRepository) 
	{
		this.repository = notificationRepository;
	}

		@GetMapping("/list")
		public String listNotifications(Model m)
		{
			List<Notification> list = repository.findAll();
			m.addAttribute("list",list);
			return "notification_list";
		}
		
		@GetMapping("/newnotification")
		public String showForm(Notification notification)
		{
			return "notification_entry";
		}
		@PostMapping("/insert")
		public String insertNotification(@ModelAttribute("notification") Notification notification)
		{
			repository.save(notification);
			return "redirect:/notification/list";
		}
		
		@GetMapping(value="/edit/{id}")
		public String editNotification(@PathVariable int id, Model m)
		{
			Optional<Notification> notification= repository.findById(id);
			Notification nf = null;
			if(notification.isPresent())
				nf = notification.get();
			
			m.addAttribute("notification",nf);
			return "notification_edit";
		}
		
		@PostMapping(value="/update")
		public String updateNotification(@ModelAttribute("notification") Notification notification)
		{
			repository.save(notification);
			return "redirect:/notification/list";
		}
		
		@GetMapping(value="/delete/{id}")
		public String deleteNotification(@PathVariable int id,Model m)
		{
			repository.deleteById(id);
			return "redirect:/notification/list";
		}
}
