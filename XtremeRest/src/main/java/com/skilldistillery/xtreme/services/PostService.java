package com.skilldistillery.xtreme.services;

import java.util.List;

import com.skilldistillery.xtreme.entities.Post;

public interface PostService {

	List<Post> findByCategoryId(int id);

	List<Post> findByPriceBetween(double min, double max);

	List<Post> searchForPost(String keyword);

}
