package com.store.app.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.store.app.bean.Products;

public interface ProductService 
{
	public ResponseEntity<Products> saveNewProduct(Products product, MultipartFile file) throws IOException;

	public Products saveProduct(Products product);

	public List<Products> getAllProducts();

	public Optional<Products> getProductById(int productId);

	public void deleteProduct(int productId);

	public List<String> getColorsByProductId(int productId);

	public List<String> getProductSizes(int productId);

	public List<Products> getCategorizedProducts(String category);

	public List<Products> getProductByName(String productname);

	public List<Products> getByPriceRange(double min, double max);
	
	public ResponseEntity<Products> uploadImage(int productId,MultipartFile file) throws IOException;
	    
	public byte[] downloadImage(int productId) throws IOException;
	    
}