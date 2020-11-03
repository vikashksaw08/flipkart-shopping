package com.flipkart.shopping.service;

import com.flipkart.shopping.model.Cart;

public interface CartService {

	Long save(Cart cart);
	void add(Long idCart, Long idProduct, Integer quantity);
	Long ordered(Long idCart);
}
