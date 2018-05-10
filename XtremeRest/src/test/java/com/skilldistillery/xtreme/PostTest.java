package com.skilldistillery.xtreme;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.xtreme.repositories.PostRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostTest {
	
	@Autowired
	private PostRepository postRepo;
	
	@Test
	public void test_post_findbyId() {
		assertEquals("Air Time", postRepo.findById(1).get().getBrand());
	}

}
