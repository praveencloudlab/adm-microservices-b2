package com.cts.ecart;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cts.ecart.entity.Order;
import com.cts.ecart.entity.OrderItem;
import com.cts.ecart.entity.Product;
import com.cts.ecart.entity.User;
import com.cts.ecart.repository.BrandRepository;
import com.cts.ecart.repository.CategoryRepository;
import com.cts.ecart.repository.OrderItemRepository;
import com.cts.ecart.repository.OrderRepository;
import com.cts.ecart.repository.ProductRepository;
import com.cts.ecart.repository.UserRepository;
import com.cts.ecart.service.OrderServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(Application.class, args);
		CategoryRepository catRepo = ac.getBean(CategoryRepository.class);
		BrandRepository br=ac.getBean(BrandRepository.class);
		
		UserRepository userRepo = ac.getBean(UserRepository.class);
		OrderRepository orderRepo = ac.getBean(OrderRepository.class);
		OrderItemRepository orderItemRepo = ac.getBean(OrderItemRepository.class);
		ProductRepository prodRepo = ac.getBean(ProductRepository.class);
		
		// find all records
		//catRepo.findAll().forEach(System.out::println);
		
		// find Category by ID
		//Category cat= catRepo.findById(53).orElse(null);
		//System.out.println(cat);
		
		// find all brands
		
		//br.findAll().forEach(System.out::println);
		
		// fetch all brands on a category ID
		//Category catObj = catRepo.findById(45).orElse(null);
		//System.out.println(catObj);
		//catObj.getBrands().forEach(System.out::println);
		
		//List<Category> cats = catRepo.findByCategoryTitle("Laptops");
		//System.out.println(cats);
		
		// fetch all categories by Brand Title
		//List<Category> cats = catRepo.findByBrands_brandTitleEquals("Apple");
		//System.out.println(cats);
		
		//cats.forEach(cat->{
		//	System.out.println("Category Name: "+cat.getCategoryTitle());
		//	System.out.println("-----------------------------------------");
		//	 cat.getBrands().stream().filter(brand->brand.getBrandTitle().equals("Apple")).collect(Collectors.toList()).forEach(System.out::println);
		//});
		
		
		
		
		// Place new order
		double totalAmount=0.0;
		
		User user = userRepo.findById("praveen").orElse(null);
		
		Product p1 = prodRepo.findById(1).orElse(null);
		Product p2 = prodRepo.findById(43).orElse(null);
		Product p3 = prodRepo.findById(48).orElse(null);
		Product p4 = prodRepo.findById(52).orElse(null);
		
		List<Product> products = Arrays.asList(p1,p2,p3,p4);
		
		
		
		Order order=new Order();
		order.setUser(user);
		order.setOrderDate(LocalDateTime.now());
		
		//products.si
		
		OrderItem item1=new OrderItem();
		OrderItem item2=new OrderItem();
		OrderItem item3=new OrderItem();
		OrderItem item4=new OrderItem();
		
		item1.setProduct(p1);
		item1.setPrice(p1.getPrice().getPrice());
		item1.setQuantity(2);
		item1.setOrder(order);
		totalAmount=totalAmount+(p1.getPrice().getPrice());
		
		item2.setProduct(p2);
		item2.setPrice(p2.getPrice().getPrice());
		item2.setQuantity(55);
		item2.setOrder(order);
		totalAmount=totalAmount+(p2.getPrice().getPrice())*5;
		
		item3.setProduct(p3);
		item3.setPrice(p3.getPrice().getPrice());
		item3.setQuantity(3);
		item3.setOrder(order);
		totalAmount=totalAmount+(p3.getPrice().getPrice())*3;
		
		item4.setProduct(p4);
		item4.setPrice(p4.getPrice().getPrice());
		item4.setQuantity(6);
		item4.setOrder(order);
		totalAmount=totalAmount+(p4.getPrice().getPrice())*6;
		
		order.getOrderItems().add(item1);
		order.getOrderItems().add(item2);
		order.getOrderItems().add(item3);
		order.getOrderItems().add(item4);
		
		
		System.out.println("Total Amount: "+totalAmount);
		
		order.setTatalAmount(totalAmount);
		
		
		// get orderservice object
		OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
		orderService.checkout(order);
		
		//orderRepo.save(order);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
