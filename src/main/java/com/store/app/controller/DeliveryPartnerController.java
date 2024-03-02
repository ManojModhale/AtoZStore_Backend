package com.store.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.bean.DeliveryPartner;
import com.store.app.service.DeliveryPartnerService;

@RestController
@RequestMapping("/delivery")
@CrossOrigin( "http://localhost:4200")
public class DeliveryPartnerController {
	
	@Autowired
	DeliveryPartnerService deliveryPartnerService;
    @PostMapping("/register")
	public void registerDeliveryPArtner(@RequestBody DeliveryPartner deliveryPartner) {
		deliveryPartnerService.registerDeliveryPartner(deliveryPartner);
	}
}
