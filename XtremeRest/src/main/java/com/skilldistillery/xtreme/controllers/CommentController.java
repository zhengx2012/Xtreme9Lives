package com.skilldistillery.xtreme.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.xtreme.entities.Comment;
import com.skilldistillery.xtreme.services.CommentService;

@RestController
@RequestMapping(path = "/api")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping(path = "/posts/{id}/comments", method = RequestMethod.GET)
	public List<Comment> index(@PathVariable int id, HttpServletResponse response) {
		List<Comment> comments = commentService.getCommentsForPostById(id);
		if (comments == null) {
			response.setStatus(500);
			return null;
		}

		response.setStatus(200);
		return comments;
	}

	@RequestMapping(path = "/posts/{id}/comments", method = RequestMethod.POST)
	public Comment create(@PathVariable int id, @RequestBody Comment newComment, HttpServletResponse response) {
		Comment created = commentService.createNewCommentForPostById(id, newComment);
		if (created == null) {
			response.setStatus(500);
			return null;
		}

		response.setStatus(201);
		return created;

	}

	@RequestMapping(path = "/posts/{id}/comments/{cid}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable int id, @PathVariable int cid) {
		return commentService.deleteCommentById(id, cid);
	}

}
