package com.store.app.service;

import org.springframework.stereotype.Service;

import com.store.app.bean.Address;
import com.store.app.bean.Customer;


@Service
public interface CustomerService 
{
	public Customer loginUser(String username, String password);
	
	public void registerUser(Customer user);
	
	public int getByEmail(String username, String email);
	
	public boolean changePassword(String username,String password);
	
	public Customer getUser(String username);
	
	public void updateUser(Customer user);

	public Customer getUserByUsername(String username);

	public int update(Customer g);

	public void addAddress(String username, Address address);
	
	
}
