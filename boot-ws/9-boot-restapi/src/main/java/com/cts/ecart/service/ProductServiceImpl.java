package com.cts.ecart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cts.ecart.model.Product;

@Service
public class ProductServiceImpl {
	static List<Product> products = null;
	
	static {
		products=new ArrayList<Product>();
		products.add(new Product(11, "Laptop", 76543, "Dell"));
		products.add(new Product(12, "Mobile", 54543, "Samsung"));
		products.add(new Product(13, "Tablet", 94772, "Google"));
		products.add(new Product(14, "Keyboard", 2444, "Wireless"));
		products.add(new Product(15, "Mouse", 1023, "Wired"));
		
	}

	public List<Product> loadProducts() {
		return products;
	}
	
	public Product save(Product product) {
		if(products==null)
			products=new ArrayList<Product>();
		products.add(product);
		return product;
	}
	
	public Product findById(int id) {
		if(products==null){
			return null;
		}
		System.out.println(products);
		
		
		Product product = products.stream().filter(prod->prod.getId()==id).findAny().get();
		System.out.println(product);
		return product;
	}
	
	public Product update(Product newObj) {
		ListIterator<Product> li=products.listIterator();
		while(li.hasNext()) {
			Product prod=li.next();
			if(prod.getId()==newObj.getId()) {
				li.set(newObj);
				return newObj;
			}
		}
		return null;
	}
	
	public void deleteById(int id) {
		products=products.stream().filter(prod->prod.getId()!=id).collect(Collectors.toList());
		System.out.println(products);
	}
	
	

}
