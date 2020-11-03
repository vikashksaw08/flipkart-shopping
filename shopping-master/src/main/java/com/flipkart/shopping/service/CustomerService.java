package com.flipkart.shopping.service;
import java.security.NoSuchAlgorithmException;

import com.flipkart.shopping.exception.AuthenticationFailedException;
import com.flipkart.shopping.model.Customer;

public interface CustomerService {
	

	Customer authentication(String username, String password) 
			throws NoSuchAlgorithmException, AuthenticationFailedException;
	Long addCustomer(Customer customer) throws NoSuchAlgorithmException;

}
