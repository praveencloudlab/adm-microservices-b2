package com.cts.ecart.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Order;
import com.cts.ecart.service.OrderServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("api/orders")
public class OrderServiceResource {
	
	@Autowired
	private OrderServiceImpl orderService;
	
	@GetMapping("/{user}")
	public List<Order> placeOrder(@PathVariable String user) {
		
		return orderService.placeOrder(user);
		
	}

}
