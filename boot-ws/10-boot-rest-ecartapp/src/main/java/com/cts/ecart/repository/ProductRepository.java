package com.cts.ecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Price;
import com.cts.ecart.entity.Product;
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	
	// filter by product title
	List<Product> findByProductTitleLike(String productName);
	//filter products by low price
	List<Product> findByPrice_priceLessThanEqual(double price);
	//filter products by high price
	
	List<Product> findByPrice_priceGreaterThanEqual(double price);
	//filter products by price low and high
	List<Product> findByPrice_priceBetween(double lowPrice,double highPrice);
	
	
	
	
	
	
	
	
	
}
