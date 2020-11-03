package com.flipkart.shopping.dao;

import com.flipkart.shopping.model.Customer;

public interface CustomerDao {
	
	Customer findBy(String username);
	Long save(Customer customer);

}
