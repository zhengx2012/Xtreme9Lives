package com.skilldistillery.xtreme.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {

	/* attributes */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String name;
	private String email;
	private String description;
	private double price;

	@Column(name = "image_url")
	private String imageUrl;

	private String brand;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany(mappedBy = "post")
	private List<Comment> comments;

	/* constructors */
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(int id, String title, String name, String email, String description, double price, String imageUrl,
			String brand, Date createdAt, Date updatedAt, Category category, List<Comment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.email = email;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
		this.brand = brand;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.category = category;
		this.comments = comments;
	}

	/* gets and sets */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	/* helpers */
	public void addComment(Comment comment) {
		if (comments == null) {
			comments = new ArrayList<>();
		}
		if (!comments.contains(comment)) {
			if (comment.getPost() != null) {
				comment.getPost().getComments().remove(comment);
			}
			comment.setPost(this);

		}
	}

	public void removeComment(Comment comment) {
		comment.setPost(null);
		if (comments != null) {
			comments.remove(comment);
		}
	}

}
