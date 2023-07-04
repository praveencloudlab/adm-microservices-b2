package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.ecart.entity.Order;
import com.cts.ecart.entity.OrderItem;
import com.cts.ecart.entity.Product;
import com.cts.ecart.repository.OrderRepository;
import com.cts.ecart.repository.ProductRepository;

@Service
public class OrderServiceImpl {


	@Autowired
	private ProductRepository prodRepo;
	@Autowired
	private OrderRepository orderRepo;
	
	@Transactional(propagation = Propagation.REQUIRED) // default
	public void checkout(Order order) {
		
		//updateInventory
		updateProductQuantity(order);
		//createOrder
		createOrder(order);
		//createShipmentDetails
	}
	
	//updateInventory
	public void updateProductQuantity(Order order){
		for(OrderItem item:order.getOrderItems()) {	
			Product product = prodRepo.findById(item.getProduct().getProductId()).orElse(null);
			if(product.getStock().getStock()>=1)
			product.getStock().setStock(product.getStock().getStock() - item.getQuantity());
			prodRepo.save(product);	
		}
	}
	
	//create order
	public void createOrder(Order order) {
		// save the order if provided product quantity available in database
		boolean flag=true;
		for(OrderItem item:order.getOrderItems()) {	
			Product product = prodRepo.findById(item.getProduct().getProductId()).orElse(null);
			if(product.getStock().getStock()>=item.getQuantity()) {
				//  add product to the order table if condition is true
				flag=false;
			}else {
				// do not save this product to the order if condition is true: hint ==> use batch processing
			}
			
			if(flag) {
				orderRepo.save(order);
			}
			
		}
		
	}
	

}
