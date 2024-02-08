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

import com.store.app.bean.User;
import com.store.app.service.UserServiceImpl;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserServiceImpl service;
	
	@PostMapping("/adduser")
	public User adduser(@RequestBody User u)
	{
		System.out.println("in register");
		return service.addregister(u);
	}
	@PostMapping("/loginuser")
	public User loginuser(@RequestBody User u)
	{
		System.out.println("in login");
		return service.loginuser(u.getUsername(), u.getPassword());
		
		
		
	}
	@DeleteMapping("/delete")
	public void delete(@RequestParam String username) {
		service.delete(username);
	}
	
	@PostMapping("/update")
	  public int update(@RequestBody User g) {
			return service.update(g);
		}
	
	@GetMapping("/getuser/{username}")
	public User getUser(@PathVariable String username) {
		return service.getUserByUsername(username);
	}
		
		@GetMapping("/display")
		public List<User> getbyUser(){
			return service.getUser();         
			
		}
		
		@PostMapping("/forgotpass")
		public User forgetpassword(@RequestBody User u) {
			System.out.println("in forget: "+u);
			return service.forgetpassword(u.getUsername(),u.getEmail());
			
		}
	

}
