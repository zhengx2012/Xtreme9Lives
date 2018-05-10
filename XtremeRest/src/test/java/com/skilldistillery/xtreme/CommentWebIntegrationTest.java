package com.skilldistillery.xtreme;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilldistillery.xtreme.entities.Comment;
import com.skilldistillery.xtreme.repositories.CommentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentWebIntegrationTest {

	@Autowired
	private CommentRepository commentRepo;

	@Test
	public void test_comments_for_post() throws JsonParseException, JsonMappingException, IOException {
		// configure TestRestTemplate to get our film index route
		TestRestTemplate restTest = new TestRestTemplate();
		ResponseEntity<String> response = restTest.getForEntity("http://localhost:8080/api/posts/1/comments", String.class);

		// map to a Collection of Film objects
		ObjectMapper mapper = new ObjectMapper();

		List<Comment> comments = mapper.readValue(response.getBody(),
				mapper.getTypeFactory().constructCollectionLikeType(List.class, Comment.class));

		assertEquals("Billy Bobbs", comments.get(0).getName());
	}
	
	@Test
	public void test_comment_creation_for_post() throws JsonParseException, JsonMappingException, IOException {
		// configure TestRestTemplate to get our film index route
		TestRestTemplate restTest = new TestRestTemplate();
		ResponseEntity<String> response = restTest.getForEntity("http://localhost:8080/api/posts/1/comments", String.class);
		
		// map to a Collection of Film objects
		ObjectMapper mapper = new ObjectMapper();
		
		List<Comment> comments = mapper.readValue(response.getBody(),
				mapper.getTypeFactory().constructCollectionLikeType(List.class, Comment.class));
		
		assertEquals("Billy Bobbs", comments.get(0).getName());
	}

}
