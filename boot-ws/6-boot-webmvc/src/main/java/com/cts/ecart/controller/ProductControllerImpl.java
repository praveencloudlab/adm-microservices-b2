package com.cts.ecart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.ecart.model.Product;

@Controller
public class ProductControllerImpl {
	
	@RequestMapping(value = "/s1")
	public String f1() {
		System.out.println(">>> f1 method <<<");
		System.out.println("test");
		return "one";
	}
	
	@RequestMapping(value = "/s2")
	public String f2(Model model) {
		
		model.addAttribute("user", "Praveen");
		
		return "display";
	}
	
	
	// load product form
	@RequestMapping(value = "/loadProductForm")
	public String loadProductForm() {
		return "productform";
	}
	
	@RequestMapping(value = "/saveProduct")
	public String saveProduct(	@RequestParam int productId,
								@RequestParam String productName,
								@RequestParam double price,
								@RequestParam String description) {
		
		System.out.println("ID: "+productId);
		System.out.println("Name: "+productName);
		System.out.println("Price: "+price);
		System.out.println("Description: "+description);
		
		
		
		return "productform";
	}
	
	@RequestMapping(value = "/saveProductV1")
	public String saveProductV1(@ModelAttribute Product prod) {
		
		System.out.println(prod);

		
		return "productform";
	}
	
	

}
