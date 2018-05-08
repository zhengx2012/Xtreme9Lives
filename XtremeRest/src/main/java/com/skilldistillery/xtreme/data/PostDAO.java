package com.skilldistillery.xtreme.data;

import java.util.List;

import com.skilldistillery.xtreme.entities.Post;

public interface PostDAO {
	List<Post> index();
	Post show(int postId);
	Post create(String jsonPost);
	Post replaceById(int postId, Post postUpdates);
	Post updateById(int postId, Post postUpdates);
	Boolean destroy(int postId); 

}
