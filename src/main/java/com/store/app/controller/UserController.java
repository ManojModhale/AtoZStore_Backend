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

import com.store.app.bean.Customer;
import com.store.app.bean.User;

import com.store.app.service.UserServiceImpl;
import com.store.app.service.CustomerService;
import com.store.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin( "http://localhost:4200")
public class UserController 
{
	
	@Autowired
	private UserService userService1;
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/newuser")
	public void registerUser(@RequestBody Customer customer)
	{
		System.out.println("inside registration "+customer);
		customerService.registerUser(customer);
	}
	
	@PostMapping("/loginuser")

	public Customer loginAuthenticate(@RequestBody Customer customer)
	{
//		System.out.println("inside login "+user.getUsername()+","+user.getPassword());

		return customerService.loginUser(customer.getUsername(), customer.getPassword());
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
	
	
	@PostMapping("/update")
	  public int update(@RequestBody Customer customer) {
			return customerService.update(customer);
		}
	
	@GetMapping("/getuser/{username}")
	public Customer getUser(@PathVariable String username) {
		return customerService.getUserByUsername(username);
	}		
		
		
		
	
}
