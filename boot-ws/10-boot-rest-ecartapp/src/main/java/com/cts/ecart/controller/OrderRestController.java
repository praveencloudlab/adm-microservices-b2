package com.cts.ecart.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Order;
import com.cts.ecart.entity.OrderItem;
import com.cts.ecart.entity.Product;
import com.cts.ecart.service.OrderServiceImpl;
import com.cts.ecart.service.ProductServiceImpl;

@RestController
@RequestMapping("api/orders")
@CrossOrigin
public class OrderRestController {
	
	@Autowired
	private OrderServiceImpl orderService;
	@Autowired
	private ProductServiceImpl productService;
	
	@PostMapping
	public Order placeOrder(@RequestBody Integer[] products ) {
		List<Integer> productIds = Arrays.asList(products);
		
	    List<Product> prods = productService.findAllProductsById(productIds);
		
	    Order order=new Order();
	    	// Place new order
	 		double totalAmount=0.0;
	    for(Product product:prods) {
	    	OrderItem orderItem=new OrderItem();
	    	orderItem.setProduct(product);
	    	orderItem.setPrice(product.getPrice().getPrice());
	    	orderItem.setQuantity(2);
	    	orderItem.setOrder(order);
			totalAmount=totalAmount+(product.getPrice().getPrice());
	    	order.getOrderItems().add(orderItem);
	    }
	    
	    order.setTatalAmount(totalAmount);
		
		
		// get orderservice object
		orderService.checkout(order);
	   
		return order;
	}
	
	
	
	
	
	
	
	
	

}
