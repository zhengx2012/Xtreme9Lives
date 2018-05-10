package com.skilldistillery.xtreme;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.xtreme.entities.Comment;
import com.skilldistillery.xtreme.repositories.CommentRepository;
import com.skilldistillery.xtreme.repositories.PostRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTest {
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	PostRepository postRepo;
	
	@Test
	public void test_comment_findBy_id() {
		assertEquals("Augustus Gibbons", commentRepo.findById(1).get().getName());
	}
	
//	@Test
//	public void test_comment_create() {
//		Comment newComment = new Comment();
//		newComment.setName("Xian Zheng");
//		newComment.setContent("Cool stuff");
//		newComment.setPost(postRepo.findById(1).get());
//		assertEquals(4, commentRepo.saveAndFlush(newComment).getId());
//	}
	
//	@Test
//	public void test_comment_replace() {
//		Comment managedComment = commentRepo.findById(4).get();
//		managedComment.setName("Diddly Duff");
//		managedComment.setContent("Noiiiice");
//		managedComment.setPost(postRepo.findById(1).get());
//		assertEquals(4, commentRepo.saveAndFlush(managedComment).getId());
//	}
	
//	@Test
//	public void test_comment_update() {
//		Comment managedComment = commentRepo.findById(5).get();
//		managedComment.setName("Xian Zheng");
//		assertEquals(5, commentRepo.saveAndFlush(managedComment).getId());
//	}
	
//	@Test
//	public void test_comment_delete() {
//		commentRepo.deleteById(6);
//		try {
//			commentRepo.findById(6).get();
//			fail("Comment not deleted");
//		} catch (Exception e) {
//		}
//		
//	}
	


}
