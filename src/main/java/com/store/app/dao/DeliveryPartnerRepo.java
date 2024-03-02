package com.store.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.app.bean.DeliveryPartner;
@Repository
public interface DeliveryPartnerRepo extends JpaRepository<DeliveryPartner, String> {

}
