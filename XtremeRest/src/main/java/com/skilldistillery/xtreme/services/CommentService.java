package com.skilldistillery.xtreme.services;

import java.util.List;

import com.skilldistillery.xtreme.entities.Comment;

public interface CommentService {
	
	List<Comment> getCommentsForPostById(int postId);
	Comment createNewCommentForPostById(int postId, Comment newComment);
	Boolean deleteCommentById(int postId, int commentId);


}
