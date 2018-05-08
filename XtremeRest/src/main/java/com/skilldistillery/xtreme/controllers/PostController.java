package com.skilldistillery.xtreme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.xtreme.data.PostDAO;
import com.skilldistillery.xtreme.entities.Post;

@RestController
@RequestMapping(path = "/api")
public class PostController {
	
	@Autowired
	private PostDAO postDAO;
	
	@RequestMapping(path="/ping", method=RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path="/posts", method=RequestMethod.GET)
	public List<Post> index() {
		return postDAO.index();
	}
	
	@RequestMapping(path="/posts/{id}", method=RequestMethod.GET)
	public Post show(@PathVariable int id) {
		return postDAO.show(id);
	}
	
	@RequestMapping(path="/posts", method=RequestMethod.POST)
	public Post create(@RequestBody String jsonPost) {
		return postDAO.create(jsonPost);
	}
	
}
 