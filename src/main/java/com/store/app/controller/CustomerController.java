package com.store.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.bean.Customer;
import com.store.app.service.CustomerService;

@RestController
@RequestMapping("/user")
@CrossOrigin( "http://localhost:4200")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/newuser")
	public void registerUser(@RequestBody Customer user)
	{
		System.out.println("inside registration "+user);
		customerService.registerUser(user);
	}
	
	@PostMapping("/loginuser")
	//public User loginAuthenticate(@RequestParam String username,@RequestParam String password)
	public Customer loginAuthenticate(@RequestBody Customer user)
	{
		System.out.println("inside login "+user.getUsername()+","+user.getPassword());

		return customerService.loginUser(user.getUsername(), user.getPassword());
	}
	
	@PostMapping("/forgotpass")
	public int forgotpassword(@RequestParam String username, @RequestParam String email)
	{
		return customerService.getByEmail(username, email);
	}
	
	@PostMapping("/changepass")
	public boolean changePassword(@RequestParam String username, @RequestParam String password)
	{
		return customerService.changePassword(username, password);
	}
	
	@GetMapping("/getuser/{username}")
	public Customer getUserDetails(@PathVariable("username") String username)
	{
		return customerService.getUser(username);
	}
	
	@PostMapping("/updateuser")
	public void updateUserDetails(@RequestBody Customer user)
	{
		customerService.updateUser(user);
	}
	
	@PostMapping("/update")
	public int update(@RequestBody Customer g) 
	{
		return customerService.update(g);
	}
	/*
	@GetMapping("/getuser/{username}")
	public Customer getUser(@PathVariable String username) 
	{
		return customerService.getUserByUsername(username);

	}*/

}