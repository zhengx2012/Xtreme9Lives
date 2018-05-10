package com.skilldistillery.xtreme.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.xtreme.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByCategoryId(int id);

	List<Post> findByPriceBetween(double min, double max);

	/* custom queries */
	@Query("SELECT p FROM Post p WHERE p.title LIKE :keyword OR p.name LIKE :keyword")
	List<Post> queryByKeywordLikeIgnoreCase(@Param("keyword")String keyword);

}
