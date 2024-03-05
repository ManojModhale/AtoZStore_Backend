package com.store.app.service;

import com.store.app.bean.DeliveryPartner;

public interface DeliveryPartnerService {
	public void registerDeliveryPartner(DeliveryPartner deliveryPartner);

	public DeliveryPartner Login(String username, String password);

	public DeliveryPartner getUserByUsername(String username);

	public int update(DeliveryPartner deliveryPartner);

	public int getByEmail(String username, String email);
	public boolean changePassword(String username, String password) ;
}
