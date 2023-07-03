package com.cts.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Brand;
import com.cts.ecart.entity.Category;
import com.cts.ecart.entity.Product;
import com.cts.ecart.service.CartServiceImpl;
import com.cts.ecart.service.OrderServiceImpl;
import com.cts.ecart.service.ProductServiceImpl;

@RestController
@RequestMapping("api/products")
public class ProductRestController {
	@Autowired
	private ProductServiceImpl productService;
	@Autowired
	private OrderServiceImpl orderService;
	@Autowired
	private CartServiceImpl caerCartService;
	
	//Read only operations
		// list all products
		@GetMapping
		public List<Product> listAllProducts() {
			return productService.listAllProducts();
		}

		// find product by ID
		@GetMapping("/{productId}")
		public Product findById(@PathVariable int productId) {
			return productService.findById(productId);
		}

		// filter products by product title
		@GetMapping("/name/{productName}")
		public List<Product> filterProductsByTitle(@PathVariable String productName) {
			return productService.findByProductTitleEquals("%"+productName+"%");
		}

		// list all brands
		@GetMapping("/brands")
		public List<Brand> listAllBrands(){
			return productService.listAllBrands();
		}
		
		// list all categories
		@GetMapping("/categories")
		public List<Category> listAllcategories(){
			return productService.listAllcategories();
		}
		// find all brands by category Title
		@GetMapping("/categories/{categoryTitle}")
		public List<Category> findByCategoryTitle(@PathVariable String categoryTitle) {
			return productService.findByCategoryTitle(categoryTitle);
		}

		// find all categories by brandTitle
		@GetMapping("/categories/brands/{brandTitle}")
		public List<Category> findByBrands_brandTitleEquals(@PathVariable String brandTitle) {
			return productService.findByBrands_brandTitleEquals(brandTitle);
		}

		// filter products by low price
		@GetMapping("/price/low/{price}")
		public List<Product> findByPrice_priceLessThanEqual(@PathVariable double price){
			return productService.findByPrice_priceLessThanEqual(price);
		}
		
		// find Price by Product ID
		@GetMapping("/price/{productId}")
		public double getPriceByProductId(@PathVariable int productId) {
			return productService.findById(productId).getPrice().getPrice();
		}

		// filter products by high price
		 @GetMapping("/price/high/{price}")
		public List<Product> findByPrice_priceGreaterThanEqual(@PathVariable double price){
			return productService.findByPrice_priceGreaterThanEqual(price);
		}

		// filter products by price low and high
		@GetMapping("/price/{lowPrice}/{highPrice}")
		public List<Product> findByPrice_priceBetween(@PathVariable double lowPrice,@PathVariable double highPrice){
			return productService.findByPrice_priceBetween(lowPrice, highPrice);
		}
		
		// DML operations
		// save/edit product
		@PostMapping
		public Product save(@RequestBody Product product) {
			return productService.save(product);
		}
		
		// save List of products
		@PostMapping("/saveAll")
		public List<Product> saveAllProducts(@RequestBody List<Product> products){
			return productService.saveAllProducts(products);
		}
		
		// delete product
		@DeleteMapping("/{productId}")
		public void deleteProduct(@PathVariable int productId) {
			productService.deleteProduct(productId);
		}
		
		// add/edit new category
		@PostMapping("/addCategory")
		public Category saveCategory(@RequestBody Category category) {
			return productService.saveCategory(category);
			
		}
		
		// delete by category ID
		@DeleteMapping("/category/{categoryId}")
		public void deleteCategory(@PathVariable int categoryId) {
			productService.deleteCategory(categoryId);
		}
		
		// add/edit new brand 
		@PostMapping("/addBrand")
		public Brand saveBrand(@RequestBody Brand brand) {
			return productService.saveBrand(brand);
		}
		
		//delete brand by brand ID
		@DeleteMapping("/brand/{brandId}")
		public void deleteByBrandId(@PathVariable int brandId) {
			productService.deleteByBrandId(brandId);
		}
	
	
	
	
	
	
	
	
	
	
	

}
