package com.store.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.app.bean.CartProduct;
@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {

}
