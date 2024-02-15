package com.store.app.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.bean.CartProduct;
import com.store.app.bean.User;
import com.store.app.dao.CartProductRepository;
import com.store.app.dao.UserRepository;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartProductRepository cartProductRepository;

    @Autowired
    UserRepository repository;
	@Override
	public User addToCart(CartProduct cartProduct,String username) {
		// TODO Auto-generated method stub
		User user=repository.findByUsername(username);
		
		if(user!=null) {
			System.out.println("in if");
			List<CartProduct> cartProducts=user.getCproducts();
			cartProducts.add(cartProduct);
			user.setCproducts(cartProducts);
			return repository.save(user);
			
		}
		
		return null;
	}
	@Override
	public List<CartProduct> getCartProducts(String username) {
		// TODO Auto-generated method stub
		List<CartProduct> cartproducts=new ArrayList<>();
		User user=repository.findByUsername(username);
		if(user!=null) {
			cartproducts=user.getCproducts();
			return cartproducts;
		}
		return null;
	}

}
