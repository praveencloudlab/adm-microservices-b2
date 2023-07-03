package com.cts.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ecart.entity.Brand;
import com.cts.ecart.entity.Category;
import com.cts.ecart.entity.Price;
import com.cts.ecart.entity.Product;
import com.cts.ecart.repository.BrandRepository;
import com.cts.ecart.repository.CategoryRepository;
import com.cts.ecart.repository.ProductRepository;

@Service
public class ProductServiceImpl {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BrandRepository brandRepository;
	
	
	//Read only operations

	// list all products
	public List<Product> listAllProducts() {
		return productRepository.findAll();
	}

	// find product by ID
	public Product findById(int productId) {
		return productRepository.findById(productId).orElse(null);
	}
	
	
	// find all brands by category Title
	public List<Category> findByCategoryTitle(String categoryTitle) {
		return categoryRepository.findByCategoryTitle(categoryTitle);
	}

	// find all categories by brandTitle
	public List<Category> findByBrands_brandTitleEquals(String brandTitle) {
		return categoryRepository.findByBrands_brandTitleEquals(brandTitle);
	}
	
	// list all brands
	public List<Brand> listAllBrands(){
		return brandRepository.findAll();
	}
	
	// list all categories
	public List<Category> listAllcategories(){
		return categoryRepository.findAll();
	}

	// filter by product title
	public List<Product> findByProductTitleEquals(String productName){
		return productRepository.findByProductTitleLike(productName);
	}

	// filter products by low price
	public List<Product> findByPrice_priceLessThanEqual(double price){
		return productRepository.findByPrice_priceLessThanEqual(price);
	}

	// filter products by high price
	public List<Product> findByPrice_priceGreaterThanEqual(double price){
		return productRepository.findByPrice_priceGreaterThanEqual(price);
	}

	// filter products by price low and high
	public List<Product> findByPrice_priceBetween(double lowPrice, double highPrice){
		return productRepository.findByPrice_priceBetween(lowPrice, highPrice);
	}
	
	// DML operations
	// save/edit product
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	// save List of products
	public List<Product> saveAllProducts(List<Product> products){
		return productRepository.saveAll(products);
	}
	
	// delete product
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}
	
	// add/edit new category
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
		
	}
	
	// delete by category ID
	public void deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
	}
	
	// add/edit new brand 
	public Brand saveBrand(Brand brand) {
		return brandRepository.save(brand);
	}
	
	//delete brand by brand ID
	public void deleteByBrandId(int brandId) {
		brandRepository.deleteById(brandId);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
