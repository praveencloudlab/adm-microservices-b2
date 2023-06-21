package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ecart.repository.ProductRepositoryImpl;

@Service
public class ProductServiceImpl {
	
	@Autowired
	private ProductRepositoryImpl prodRepo;
	
	public void save() {
		System.out.println("SERVICE:: ProductServiceImpl :: save method");
		prodRepo.save();
	}

}
