package com.skilldistillery.xtreme.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilldistillery.xtreme.entities.Post;

@Transactional
@Service
public class PostDAOImpl implements PostDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Post> index() {
		String query = "SELECT p FROM Post p";
		return em.createQuery(query, Post.class).getResultList();
	}

	@Override
	public Post show(int postId) {
		return em.find(Post.class, postId);
	}

	@Override
	public Post create(String jsonPost) {
		Post newPost = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			newPost = mapper.readValue(jsonPost, Post.class);
			em.persist(newPost);
			em.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newPost;
	}

	@Override
	public Post replaceById(int postId, String jsonBody) {
		Post oldPost = em.find(Post.class, postId);
		return null;
	}

	@Override
	public Post updateById(int postId, String jsonBody) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean destroy(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

}
