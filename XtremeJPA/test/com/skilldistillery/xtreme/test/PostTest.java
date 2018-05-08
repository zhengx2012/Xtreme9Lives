package com.skilldistillery.xtreme.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.xtreme.entities.Post;

class PostTest {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Post post;

	@BeforeEach
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Xtreme9Lives");
		em = emf.createEntityManager();
		post = em.find(Post.class, 1);
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

	@Test
	@DisplayName("Test Post entity mapping")
	void test1() {
		assertEquals("Air Time", post.getBrand());
	}

	@Test
	@DisplayName("Test Post to Category Many to One Relationship")
	void test2() {
		assertEquals("skydiving", post.getCategory().getName());
	}

	@Test
	@DisplayName("Test Post to Comment One to Many Relationship")
	void test3() {
		assertEquals(1, post.getComments().get(0).getId());
	}

}
