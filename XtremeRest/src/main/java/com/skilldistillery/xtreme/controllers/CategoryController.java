package com.skilldistillery.xtreme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.xtreme.entities.Category;
import com.skilldistillery.xtreme.services.CategoryService;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(path = "/categories", method = RequestMethod.GET)
	public List<Category> index() {
		return categoryService.index();
	}

}
