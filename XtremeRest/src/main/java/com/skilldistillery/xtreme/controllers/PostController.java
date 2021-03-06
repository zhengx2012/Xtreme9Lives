package com.skilldistillery.xtreme.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.xtreme.data.PostDAO;
import com.skilldistillery.xtreme.entities.Post;
import com.skilldistillery.xtreme.services.PostService;

@RestController
@RequestMapping(path = "/api")
public class PostController {

	@Autowired
	private PostDAO postDAO;

	@Autowired
	private PostService postService;

	@RequestMapping(path = "/ping", method = RequestMethod.GET)
	public String ping(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(202);
		response.setHeader("Location", "http://localhost:8080/ping");
		return "pong";
	}

	@RequestMapping(path = "/posts", method = RequestMethod.GET)
	public List<Post> index() {
		return postDAO.index();
	}

	@RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
	public Post show(@PathVariable int id) {
		return postDAO.show(id);
	}

	@RequestMapping(path = "/posts", method = RequestMethod.POST)
	public Post create(@RequestBody String jsonPost, HttpServletResponse response) {
		Post created = postDAO.create(jsonPost);
		if (created == null) {
			response.setStatus(500);
			return null;
		}
		response.setStatus(201);
		return created;
	}

	@RequestMapping(path = "/posts/{id}", method = RequestMethod.PUT)
	public Post replace(@PathVariable int id, @RequestBody Post post) {
		return postDAO.replaceById(id, post);
	}

	@RequestMapping(path = "/posts/{id}", method = RequestMethod.PATCH)
	public Post update(@PathVariable int id, @RequestBody Post post) {
		return postDAO.updateById(id, post);
	}

	@RequestMapping(path = "posts/{id}", method = RequestMethod.DELETE)
	public Boolean destroy(@PathVariable int id) {
		return postDAO.destroy(id);
	}

	@RequestMapping(path = "/categories/{id}/posts", method = RequestMethod.GET)
	public List<Post> indexForCategories(@PathVariable int id) {
		return postService.findByCategoryId(id);
	}

	@RequestMapping(path = "/posts/search/{keyword}", method = RequestMethod.GET)
	public List<Post> indexForSearch(@PathVariable String keyword) {
		return postService.searchForPost("%" + keyword + "%");
	}

	@RequestMapping(path = "/posts/search/price/{low}/{high}", method = RequestMethod.GET)
	public List<Post> indexForPrice(@PathVariable double low, @PathVariable double high) {
		return postService.findByPriceBetween(low, high);
	}

}
