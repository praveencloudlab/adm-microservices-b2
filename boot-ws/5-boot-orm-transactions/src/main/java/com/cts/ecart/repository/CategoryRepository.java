package com.cts.ecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	// 31 methods
	
	// DSL
	
	// find all brands by category Title
	List<Category> findByCategoryTitle(String categoryTitle);
	// find all categories by brandTitle
	List<Category> findByBrands_brandTitleEquals(String brandTitle);
	
	
	
	
	
}