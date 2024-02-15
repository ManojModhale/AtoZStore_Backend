package com.store.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.app.bean.CartProduct;
import com.store.app.bean.User;

import jakarta.websocket.server.ServerEndpoint;
@Service
public interface CartService {
    public User addToCart(CartProduct cartProduct,String username);

	public List<CartProduct> getCartProducts(String username);

	public int deleteFromCart(String username, int cartproductid);
}
