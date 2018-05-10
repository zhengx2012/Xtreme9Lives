package com.skilldistillery.xtreme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.xtreme.entities.Post;
import com.skilldistillery.xtreme.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepo;

	@Override
	public List<Post> findByCategoryId(int id) {
		return postRepo.findByCategoryId(id);
	}

	@Override
	public List<Post> findByPriceBetween(double min, double max) {
		return postRepo.findByPriceBetween(min, max);
	}

	@Override
	public List<Post> searchForPost(String keyword) {
		// return postRepo.queryByKeywordLikeIgnoreCase(keyword);
		return postRepo.findByTitleContainingOrNameContaining(keyword, keyword);
	}

}
