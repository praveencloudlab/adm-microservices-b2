package com.cts.ecart;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.ecart.entity.Brand;
import com.cts.ecart.entity.Category;
import com.cts.ecart.repository.BrandRepository;
import com.cts.ecart.repository.CategoryRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(Application.class, args);
		CategoryRepository catRepo = ac.getBean(CategoryRepository.class);
		BrandRepository br=ac.getBean(BrandRepository.class);
		// find all records
		//catRepo.findAll().forEach(System.out::println);
		
		// find Category by ID
		//Category cat= catRepo.findById(53).orElse(null);
		//System.out.println(cat);
		
		// find all brands
		
		//br.findAll().forEach(System.out::println);
		
		// fetch all brands on a category ID
		//Category catObj = catRepo.findById(45).orElse(null);
		//System.out.println(catObj);
		//catObj.getBrands().forEach(System.out::println);
		
		//List<Category> cats = catRepo.findByCategoryTitle("Laptops");
		//System.out.println(cats);
		
		// fetch all categories by Brand Title
		//List<Category> cats = catRepo.findByBrands_brandTitleEquals("Apple");
		//System.out.println(cats);
		
		//cats.forEach(cat->{
		//	System.out.println("Category Name: "+cat.getCategoryTitle());
		//	System.out.println("-----------------------------------------");
		//	 cat.getBrands().stream().filter(brand->brand.getBrandTitle().equals("Apple")).collect(Collectors.toList()).forEach(System.out::println);
		//});
		
	}

}
