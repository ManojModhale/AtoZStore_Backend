package com.store.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.bean.Vendor;
import com.store.app.service.VendorService;

@RestController
@RequestMapping("/vendor")
@CrossOrigin("http://localhost:4200")
public class VendorController {
	
	@Autowired
	VendorService vendorService;
@PostMapping("vendorLogin")
public Vendor vendorLogin(@RequestParam String username,@RequestParam String password) {
	
	
	return vendorService.vendorLogin(username, password);
}
} 
