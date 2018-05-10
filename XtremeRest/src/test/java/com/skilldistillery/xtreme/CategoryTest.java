package com.skilldistillery.xtreme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.xtreme.repositories.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Test
	public void test_category_findBy_id() {
		assertEquals("skydiving", categoryRepo.findById(1).get().getName());
	}
	
	/* web integration tests */
	
	@Test
	public void test_category() {
		assertEquals("skydiving", categoryRepo.findById(1).get().getName());
	}
}
