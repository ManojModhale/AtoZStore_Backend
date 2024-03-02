package com.store.app.service;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.bean.CartProduct;
import com.store.app.bean.Customer;
import com.store.app.dao.CartProductRepository;
import com.store.app.dao.CustomerRepository;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartProductRepository cartProductRepository;
     @Autowired
     private CustomerRepository customerRepository;
 
	@Override
	public CartProduct addToCart(CartProduct cartProduct,String username) {
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findByUsername(username);
		
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
		Customer customer=customerRepository.findByUsername(username);
		
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
		Customer user=customerRepository.findByUsername(username);
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
		
//			System.out.println("in add");
//			User user=repository.findByUsername(username);
//			if(user!=null) {
////				List<CartProduct> cartProducts=user.getCproducts();
//				for(CartProduct c:cartProducts) {
//					if(c.getProductid()==cartproductId) {
//						System.out.println("in update if");
//						if(updateaction.equalsIgnoreCase("add")) {
//						c.setQuantity(c.getQuantity()+1);
//						System.out.println(c.getQuantity());}
//						else if(updateaction.equalsIgnoreCase("subtract")) {
//							c.setQuantity(c.getQuantity()-1);
//					}
//				}
////				user.setCproducts(cartProducts);
////				repository.save(user);
//			}
//		}
	
			
		
		return false;
	}
	@Override
	public void makeCartEmpty(List<Integer> cartproductIds) 
	{
		// TODO Auto-generated method stub
		//cartProductRepository.deleteAllByCartproductIdIn(cartproductIds);
		for (Integer ids : cartproductIds) {
			cartProductRepository.deleteById(ids);
		}
	}

	


}