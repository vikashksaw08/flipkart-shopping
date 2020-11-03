package com.flipkart.shopping.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flipkart.shopping.dao.CartDao;
import com.flipkart.shopping.dao.OrderDao;
import com.flipkart.shopping.dao.ProductDao;
import com.flipkart.shopping.model.Cart;
import com.flipkart.shopping.model.LineItem;
import com.flipkart.shopping.model.Order;
import com.flipkart.shopping.model.Product;
import com.flipkart.shopping.model.Order.BuilderOrder;
import com.flipkart.shopping.utils.OrderStatus;


@Service
@Transactional
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDao cartDao;

	@Autowired
	ProductDao productDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Override
	public Long save(Cart cart) {
		return cartDao.save(cart);
	}

	@Override
	public void add(Long idCart, Long idProduct, Integer quantity) {
		Cart cart = cartDao.findBy(idCart);
		Product product = productDao.findBy(idProduct);
		cart.getLinesItems().add(new LineItem(cart, product, quantity, product.getPrice()));
		cartDao.update(cart);
	}

	@Override
	public Long ordered(Long idCart) {
		Cart cart = cartDao.findBy(idCart);
		Order order = new BuilderOrder()
				.setCustomer(cart.getCustomer())
				.setOrdered(new Date())
				.setStatus(OrderStatus.NEW.toString())
				.setTotal(cart.calculateTotal())
				.setLinesItems(cart.getLinesItems())
				.build();
		return orderDao.save(order);
	}

	 
}
