package com.flipkart.shopping.service;

import java.util.List;

import com.flipkart.shopping.exception.ProductNotFoundException;
import com.flipkart.shopping.model.Product;

public interface ProductService {
	
	Product findBy(Long idProduct) throws ProductNotFoundException;
	Product findBy(String description) throws ProductNotFoundException;
	List<Product> findByCategory(String category) throws ProductNotFoundException;
	List<Product> findAll() throws ProductNotFoundException;

}
