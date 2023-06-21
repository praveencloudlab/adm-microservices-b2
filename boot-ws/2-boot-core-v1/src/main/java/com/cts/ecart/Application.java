package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.ecart.repository.ProductRepositoryImpl;
import com.cts.ecart.service.ProductServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(Application.class, args);
		ProductServiceImpl ps = ac.getBean(ProductServiceImpl.class);
		//ProductRepositoryImpl prodRepo = ac.getBean(ProductRepositoryImpl.class);
		ps.save();
		//prodRepo.save();
		
		
	}

}
