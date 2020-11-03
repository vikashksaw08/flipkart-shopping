package com.flipkart.shopping.dao;

import com.flipkart.shopping.model.Cart;

public interface CartDao {

	Cart findBy(Long idCart);
	Long save(Cart cart);
	void update(Cart cart);
}
