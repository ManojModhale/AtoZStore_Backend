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

import com.store.app.bean.User;
import com.store.app.service.UserService;
import com.store.app.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin( "http://localhost:4200")
public class UserController 
{
	@Autowired
	private UserService userService1;
	
	@PostMapping("/newuser")
	public void registerUser(@RequestBody User user)
	{
		System.out.println("inside registration "+user);
		userService1.registerUser(user);
	}
	
	@PostMapping("/loginuser")
	//public User loginAuthenticate(@RequestParam String username,@RequestParam String password)
	public User loginAuthenticate(@RequestBody User user)
	{
		System.out.println("inside login "+user.getUsername()+","+user.getPassword());

		return userService1.loginUser(user.getUsername(), user.getPassword());
	}
	
	@PostMapping("/forgotpass")
	public int forgotpassword(@RequestParam String username, @RequestParam String email)
	{
		return userService1.getByEmail(username, email);
	}
	
	@PostMapping("/changepass")
	public boolean changePassword(@RequestParam String username, @RequestParam String password)
	{
		return userService1.changePassword(username, password);
	}
<<<<<<< HEAD
	
	@GetMapping("/getuser/{username}")
	public User getUserDetails(@PathVariable("username") String username)
	{
		return userService1.getUser(username);
	}
	
	@PostMapping("/updateuser")
	public void updateUserDetails(@RequestBody User user)
	{
		userService1.updateUser(user);
=======
	@PostMapping("/update")
	  public int update(@RequestBody User g) {
			return userService1.update(g);
		}
	@GetMapping("/getuser/{username}")
	public User getUser(@PathVariable String username) {
		return userService1.getUserByUsername(username);
>>>>>>> cf3bd3dd23743d6ba538f6a43e692d298f7dbbc1
	}

}
