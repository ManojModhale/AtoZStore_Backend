package com.store.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.bean.CartProduct;
import com.store.app.bean.User;
import com.store.app.service.CartService;

@RestController
@RequestMapping("cart")
@CrossOrigin( "http://localhost:4200")
public class CartProductController {
	  
	@Autowired
	CartService cartService;
	
	@PostMapping("addToCart/{username}")
	public User addToCart(@PathVariable String username, @RequestBody CartProduct cartProduct) {
		System.out.println(username);
		System.out.println("###############"+cartProduct);
		return cartService.addToCart(cartProduct,username);
	}
	@GetMapping("getcartproducts/{username}")
	public List<CartProduct> getfromcart(@PathVariable String username) {
		System.out.println(username);
		return cartService.getCartProducts(username);
	}
	@PostMapping("deleteFromCart")
	public int deleteFromCart(@RequestParam String username,@RequestParam int cartproductid) {
	  System.out.println(username);
		return cartService.deleteFromCart(username,cartproductid);
	}
}
