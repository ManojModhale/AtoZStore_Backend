package com.store.app.service;

import com.store.app.bean.Customer;
import com.store.app.bean.User;

public interface CustomerService {
	public void registerUser(Customer customer);
	
	public Customer loginUser(String username, String password) ;
	public int update(Customer u);
	
	public Customer getUserByUsername(String username);

	public int getByEmail(String username, String email);
	
	public boolean changePassword(String username,String password);

}
