package com.flipkart.shopping.dao;

import java.util.List;

import com.flipkart.shopping.model.Product;

public interface ProductDao {
	
	Product findBy(Long idProduct);
	Product findBy(String description);
	List<Product> findByCategory(String category);
	List<Product> findAll();

}
