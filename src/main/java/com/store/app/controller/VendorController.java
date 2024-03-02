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
import com.store.app.bean.User;
import com.store.app.bean.Vendor;
import com.store.app.service.VendorService;

@RestController
@RequestMapping("/vendor")
@CrossOrigin("http://localhost:4200")
public class VendorController {
	
	@Autowired
	VendorService vendorService;
	@PostMapping("vendorlogin")
	public Vendor loginAuthenticate(@RequestBody Vendor user)
	{
		System.out.println("inside login "+user.getUsername()+","+user.getPassword());
		System.out.println(vendorService.vendorLogin(user.getUsername(), user.getPassword()));

		return vendorService.vendorLogin(user.getUsername(), user.getPassword());
	}
@PostMapping("vendorRegister")
public Vendor vendorRegister(@RequestBody Vendor vendor) {
	
	
	return vendorService.addVendor(vendor);
}
@GetMapping("/getuser/{username}")
public Vendor getUser(@PathVariable String username) {
	return vendorService.getUserByUsername(username);
}
@PostMapping("/update")
public int update(@RequestBody Vendor vendor) {
		return vendorService.update(vendor);
	}

} 
