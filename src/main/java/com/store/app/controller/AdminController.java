package com.store.app.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.bean.Admin;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AdminController 
{
	@Value("${usernm}")
	private String adUsername;
	
	@Value("${userpsd}")
	private String adPassword;

	  @PostMapping("/adminAuthentication")
	   public ResponseEntity<?> adminLogin(@RequestBody Admin admin)  
	  {
	        System.out.println(admin.getUsername() + " && " + admin.getPassword());
	        System.out.println(adUsername+" :&: "+adPassword);
	        // Perform authentication logic here
	        if (adUsername.equals(admin.getUsername()) && adPassword.equals(admin.getPassword())) {
	            return ResponseEntity.ok().body("{\"success\": true}");
	        } else {
	            return ResponseEntity.ok().body("{\"success\": false}");
	        }
	   
	  }
	  
	  
	  
}
