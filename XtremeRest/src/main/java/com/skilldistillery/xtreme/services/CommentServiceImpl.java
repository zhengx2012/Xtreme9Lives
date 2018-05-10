package com.skilldistillery.xtreme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.xtreme.entities.Comment;
import com.skilldistillery.xtreme.repositories.CommentRepository;
import com.skilldistillery.xtreme.repositories.PostRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private PostRepository postRepo;

	@Override
	public List<Comment> getCommentsForPostById(int postId) {
		return commentRepo.queryForPostsWithComments(postId);
	}

	@Override
	public Comment createNewCommentForPostById(int postId, Comment newComment) {
		newComment.setPost(postRepo.findById(postId).get());
		commentRepo.saveAndFlush(newComment);
		return newComment;
	}

	@Override
	public Boolean deleteCommentById(int postId, int commentId) {
		try {
			commentRepo.deleteById(commentId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
