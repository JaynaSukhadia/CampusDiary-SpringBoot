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

import com.aurosoft.campusdiary.entity.Post;
import com.aurosoft.campusdiary.repository.PostRepository;

@Controller
@RequestMapping("/post")
public class PostController {
	
	PostRepository repository;
	 
	 
	public PostController(PostRepository postRepository)
	{
		this.repository = postRepository;
	}

		@GetMapping("/list")
		public String listPosts(Model m)
		{
			List<Post> list = repository.findAll();
			m.addAttribute("list",list);
			return "post_list";
		}
		
		@GetMapping("/newaddpost")
		public String showForm(Post post)
		{
			return "post_entry";
		}
		@PostMapping("/insert")
		public String insertPost(@ModelAttribute("post") Post post)
		{
			repository.save(post);
			return "redirect:/post/list";
		}
		
		@GetMapping(value="/edit/{id}")
		public String editPost(@PathVariable int id, Model m)
		{
			Optional<Post> post= repository.findById(id);
			Post p = null;
			if(post.isPresent())
				p = post.get();
			
			m.addAttribute("post",p);
			return "post_edit";
		}
		
		@PostMapping(value="/update")
		public String updatepost(@ModelAttribute("post") Post post)
		{
			repository.save(post);
			return "redirect:/post/list";
		}
		
		@GetMapping(value="/delete/{id}")
		public String deletePost(@PathVariable int id,Model m)
		{
			repository.deleteById(id);
			return "redirect:/post/list";
		}

}
