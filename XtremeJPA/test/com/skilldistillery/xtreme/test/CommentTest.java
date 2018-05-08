package com.skilldistillery.xtreme.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.xtreme.entities.Comment;


class CommentTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Comment comment;

	@BeforeEach
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Xtreme9Lives");
		em = emf.createEntityManager();
		comment = em.find(Comment.class, 1);
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

	@Test
	@DisplayName("Test Comment entity mapping")
	void test1() {
		assertEquals("Augustus Gibbons", comment.getName());
	}
	
	@Test
	@DisplayName("Test Comment to Post Many to One Relationship mapping")
	void test2() {
		assertEquals("Air Time", comment.getPost().getBrand());
	}

}
