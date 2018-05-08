package com.skilldistillery.xtreme.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	/* attributes */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@OneToMany(mappedBy = "category")
	private List<Post> posts;

	/* constructors */
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/* gets and sets */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	/* helpers */
	public void addPost(Post post) {
		if (posts == null) {
			posts = new ArrayList<>();
		}
		if (!posts.contains(post)) {
			if (post.getCategory() != null) {
				post.getCategory().getPosts().remove(post);
			}
			post.setCategory(this);

		}
	}

	public void removePost(Post post) {
		post.setCategory(null);
		if (posts != null) {
			posts.remove(post);
		}
	}

}
