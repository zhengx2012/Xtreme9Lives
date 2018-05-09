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
	public Post replaceById(int postId, Post postUpdates) {
		Post managedPost = em.find(Post.class, postId);
		managedPost.setTitle(postUpdates.getTitle());
		managedPost.setName(postUpdates.getName());
		managedPost.setEmail(postUpdates.getEmail());
		managedPost.setDescription(postUpdates.getDescription());
		managedPost.setPrice(postUpdates.getPrice());
//		managedPost.setImageUrl(postUpdates.getImageUrl());
		managedPost.setBrand(postUpdates.getBrand());
//		managedPost.setCategory(postUpdates.getCategory());
// persist is only for creating an object
		return managedPost;
	}

	@Override
	public Post updateById(int postId, Post postUpdates) {
		Post managedPost = em.find(Post.class, postId);
		if (postUpdates.getTitle()!= null && !postUpdates.getTitle().equals("")) {
			managedPost.setTitle(postUpdates.getTitle());
		}
		if (postUpdates.getName() != null && !postUpdates.getName().equals("")) {
			managedPost.setName(postUpdates.getName());
		}
		if (postUpdates.getEmail() != null && !postUpdates.getEmail().equals("")) {
			managedPost.setEmail(postUpdates.getEmail());
		}
		if (postUpdates.getDescription() != null && !postUpdates.getDescription().equals("")) {
			managedPost.setDescription(postUpdates.getDescription());
		}
		if (postUpdates.getPrice() > 0.0) {
			managedPost.setPrice(postUpdates.getPrice());
		}
		if (postUpdates.getImageUrl() != null && !postUpdates.getImageUrl().equals("")) {
			managedPost.setImageUrl(postUpdates.getImageUrl());
		}
		if (postUpdates.getBrand() != null && !postUpdates.getBrand().equals("")) {
			managedPost.setBrand(postUpdates.getBrand());
		}
//		if (postUpdates.getCategory() != null) {
//			managedPost.setCategory(postUpdates.getCategory());
//		}
		return managedPost;
	}

	@Override
	public Boolean destroy(int postId) {
		Boolean deleted = false;
		Post delete = em.find(Post.class, postId);
		if (delete != null) {

			try {
				em.remove(delete);
				deleted = true;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return deleted;
	}

}
