package com.cts.ecart;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.ecart.entity.Category;
import com.cts.ecart.repository.CategoryRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(Application.class, args);
		CategoryRepository catRepo = ac.getBean(CategoryRepository.class);
		
		// find all records
		//catRepo.findAll().forEach(System.out::println);
		
		// find Category by ID
		Category cat= catRepo.findById(53).orElse(null);
		System.out.println(cat);
		
	
	}

}
