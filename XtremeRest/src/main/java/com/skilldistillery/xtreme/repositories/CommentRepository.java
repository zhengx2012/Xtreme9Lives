package com.skilldistillery.xtreme.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.xtreme.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	List<Comment> findByPostId(int id);
//	/* custom queries*/
//	@Query("SELECT c FROM Comment c WHERE c.post.id =:id")
//	List<Comment> queryForPostsWithComments(@Param("id") int id);

}
