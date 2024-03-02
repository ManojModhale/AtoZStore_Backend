package com.store.app.service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.bean.CartProduct;
import com.store.app.bean.Customer;
import com.store.app.bean.User;
import com.store.app.dao.CartProductRepository;
import com.store.app.dao.CustomerRepo;
import com.store.app.dao.UserRepository;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartProductRepository cartProductRepository;
     @Autowired
     CustomerRepo customerRepo;
    @Autowired
    UserRepository repository;
	@Override
	public CartProduct addToCart(CartProduct cartProduct,String username) {
		// TODO Auto-generated method stub
		Customer customer=customerRepo.findByUsername(username);
		
		if(customer!=null) {

			cartProduct.setCustomer(customer);
			cartProduct.setQuantity(1);
			
		return	cartProductRepository.save(cartProduct);
			
		}
		
		return null;
	}
	@Override
	public List<CartProduct> getCartProducts(String username) {
		// TODO Auto-generated method stub
		Customer customer=customerRepo.findByUsername(username);
		
		return cartProductRepository.findByCustomer(customer);
	}
	
	@Override
	public void deleteFromCart(String username, int cartproductid) {
		// TODO Auto-generated method stub
		
//	     cartProductRepository.deleteByCustomerUsernameAndCartproductId(username,cartproductid);
		 cartProductRepository.deleteById(cartproductid);
		
	}
//	@Override
	public boolean checkInCart(int cartProduct, String username) {
		// TODO Auto-generated method stub
		User user=repository.findByUsername(username);
//		if(user!=null) {
//			List<CartProduct> cartProducts=user.getCproducts();
//			for(CartProduct c:cartProducts) {
//				if(c.getProductid()==cartProduct) {
//					return true;
//				}
//			}
//		}
		return false;
	}
	@Override
	public boolean updateProductQuantity(String updateaction,String username, int cartproductId) {
		// TODO Auto-generated method stub
		
			System.out.println("in add"+cartproductId);
			Optional<CartProduct> cartProduct=cartProductRepository.findById(cartproductId);

			if(cartProduct.isPresent()) {
				CartProduct c=cartProduct.get();
				System.out.println("in update if");
				if(updateaction.equalsIgnoreCase("add")) {
				c.setQuantity(c.getQuantity()+1);
				System.out.println(c.getQuantity());}
				else if(updateaction.equalsIgnoreCase("subtract")) {
					c.setQuantity(c.getQuantity()-1);
					
			}
				cartProductRepository.save(c);
				return true;
		}
	
			
		
		return false;
	}

	


}
