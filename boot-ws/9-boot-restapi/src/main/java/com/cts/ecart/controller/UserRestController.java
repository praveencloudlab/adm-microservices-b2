package com.cts.ecart.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	@GetMapping
	public String f1() {
		System.out.println(">> GET :: f1 method");
		return ">> GET-USERS :: f1 method";
	}
	
	@PostMapping
	public String f2() {
		System.out.println(">> POST :: f2 method");
		return ">> POST :: f2 method";
	}
	
	@PutMapping
	public String f3() {
		System.out.println(">> PUT :: f3 method");
		return ">> PUT :: f3 method";
	}
	
	@PatchMapping
	public String f4() {
		System.out.println(">> PATCH :: f4 method");
		return ">> PATCH :: f4 method";
	}
	
	@DeleteMapping
	public String f5() {
		System.out.println(">> DELETE :: f5 method");
		return ">> DELETE :: f5 method";
	}
	
	

}
