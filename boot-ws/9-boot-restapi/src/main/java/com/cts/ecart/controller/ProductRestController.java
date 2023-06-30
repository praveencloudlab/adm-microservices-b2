package com.cts.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.model.Product;
import com.cts.ecart.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
	
	@Autowired
	private ProductServiceImpl ps;

	
	@GetMapping
	public List<Product> f1() {
		System.out.println(">> GET :: f1 method");
		return ps.loadProducts();
	}
	
	
	@GetMapping(value = "/{id}")
	public Product f111(@PathVariable int id) {
		return ps.findById(id);	
	}
	
	@GetMapping(value = "/byName/{name}")
	public String f1111(@PathVariable String name) {
		System.out.println(">> GET :: f1111 method :: "+name);
		return ">> GET-PRODUCTS :: f1111 method :: "+name;
	}
	
	
	
	@GetMapping(value = "/op1")
	public String f11() {
		System.out.println(">> GET :: f11 method");
		return ">> GET-PRODUCTS :: f11 method";
	}
	
	@PostMapping
	public Product f2(@RequestBody Product prod) {
		System.out.println(">> POST :: f2 method");
		return ps.save(prod);
	}
	
	@PutMapping
	public Product f3(@RequestBody Product newObj) {
		System.out.println(">> PUT :: f3 method");
		return ps.update(newObj);
	}
	
	@PatchMapping
	public String f4() {
		System.out.println(">> PATCH :: f4 method");
		return ">> PATCH :: f4 method";
	}
	
	@DeleteMapping("/{id}")
	public void f5(@PathVariable int id) {
		ps.deleteById(id);
	}
	
	

}
