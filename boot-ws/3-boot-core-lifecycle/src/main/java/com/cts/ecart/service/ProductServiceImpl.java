package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
@Lazy(value = false)
@Scope("singleton")
public class ProductServiceImpl {
	
	//@Value("${application.name}")
	//private String appTitle;
	
	@Autowired
	private Environment env;
	
	//@Autowired
	//private ProductRepositoryImpl prodRepo;
	
	public ProductServiceImpl() {
		System.out.println(">>> 1.constructor on "+this.hashCode());
	}
	
	@PostConstruct
	public void f1() {
	System.out.println(">>> 2.PostConstruct :: f1 on "+this.hashCode());	
	System.out.println(">>> 2.PostConstruct :: app name: " + env.getProperty("application.name"));

	}
	
	
	@Bean // never works for lazy init beans
	public void f3() {
		System.out.println(">>> 3.Bean :: f3 method on "+this.hashCode());
	}
	
	@Bean // never works for lazy init beans
	public void f4() {
		System.out.println(">>> 3.Bean :: f4 method on "+this.hashCode());
	}
	
	
	@PreDestroy
	public void f5() { // never works for prototype scope
		System.out.println(">>> LAST <<< PreDestroy :: f5 method on "+this.hashCode());

	}
	
	
	
	//----------------------------------------------------
	public void save() {
		System.out.println(">>> 5 <<< :: SERVICE:: ProductServiceImpl :: save method on "+this.hashCode());
		//prodRepo.save();
	}

}
