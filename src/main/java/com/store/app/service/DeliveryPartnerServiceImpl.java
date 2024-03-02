package com.store.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.bean.DeliveryPartner;
import com.store.app.dao.DeliveryPartnerRepo;
@Service
public class DeliveryPartnerServiceImpl implements DeliveryPartnerService{
    @Autowired
    DeliveryPartnerRepo deliveryPartnerRepo;
	@Override
	public void registerDeliveryPartner(DeliveryPartner deliveryPartner) {
		
		deliveryPartnerRepo.save(deliveryPartner);
	}
	

}
