package com.flipkart.shopping.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flipkart.shopping.dao.CustomerDao;
import com.flipkart.shopping.exception.AuthenticationFailedException;
import com.flipkart.shopping.model.Customer;
import com.flipkart.shopping.utils.ShaHashing;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public Customer authentication(String username, String password) 
			throws NoSuchAlgorithmException, AuthenticationFailedException {
		Customer customer = customerDao.findBy(username);
		if(customer.getPassword().equals(ShaHashing.encrypted(password)))
			return customer;
		else
			throw new AuthenticationFailedException();
	}

	@Override
	public Long addCustomer(Customer customer) throws NoSuchAlgorithmException {
		customer.setPassword(ShaHashing.encrypted(customer.getPassword()));
		return customerDao.save(customer);
	}


}
