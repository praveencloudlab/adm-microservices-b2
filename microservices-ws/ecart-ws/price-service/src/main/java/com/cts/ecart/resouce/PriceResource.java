package com.cts.ecart.resouce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Price;
import com.cts.ecart.service.PriceService;

@RestController
@RequestMapping("/api/price")
@CrossOrigin
public class PriceResource {
	
	@Autowired
	private PriceService priceService;
	
	
	// find price by price ID
	@GetMapping("/{priceId}")
	public Price findByPriceId(@PathVariable int priceId) {
		return priceService.findPriceById(priceId);
	}
	
	@GetMapping("/product/{productId}")
	public double findPriceByProductId(@PathVariable int productId) {
		return priceService.findByProductId(productId).getPrice();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
