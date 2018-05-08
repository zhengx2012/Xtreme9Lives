package com.skilldistillery.xtreme.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.xtreme.entities.Category;

class CategoryTest {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Category category;

	@BeforeEach
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Xtreme9Lives");
		em = emf.createEntityManager();
		category = em.find(Category.class, 1);
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

	@Test
	@DisplayName("Test Category Entity mapping")
	void test1() {
		assertEquals("skydiving", category.getName());
	}

	@Test
	@DisplayName("Test Category and Post with One to Many Relationship")
	void test2() {
		assertEquals(1, category.getPosts().get(0).getId());
	}

}
