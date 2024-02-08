package com.store.app.bean;

import java.sql.Blob;
import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")

public class Product {
 
	@Id
	@GeneratedValue
	private int productid;
	private String category;
	private String colors[]=new String[4];                                                
	private String description;
	private Blob image;
	private String offer;
	private double price;
	private String productname;
	
	private int quantity;
	private String size[]=new String[4];
	
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Product(int productid, String category, String[] colors, String description, Blob image, String offer,
			double price, String productname, int quantity, String[] size) {
		super();
		this.productid = productid;
		this.category = category;
		this.colors = colors;
		this.description = description;
		this.image = image;
		this.offer = offer;
		this.price = price;
		this.productname = productname;
		this.quantity = quantity;
		this.size = size;
	}




	public int getProductid() {
		return productid;
	}




	public void setProductid(int productid) {
		this.productid = productid;
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public String[] getColors() {
		return colors;
	}




	public void setColors(String[] colors) {
		this.colors = colors;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Blob getImage() {
		return image;
	}




	public void setImage(Blob image) {
		this.image = image;
	}




	public String getOffer() {
		return offer;
	}




	public void setOffer(String offer) {
		this.offer = offer;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public String getProductname() {
		return productname;
	}




	public void setProductname(String productname) {
		this.productname = productname;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public String[] getSize() {
		return size;
	}




	public void setSize(String[] size) {
		this.size = size;
	}




	@Override
	public String toString() {
		return "Product [productid=" + productid + ", category=" + category + ", colors=" + Arrays.toString(colors)
				+ ", description=" + description + ", image=" + image + ", offer=" + offer + ", price=" + price
				+ ", productname=" + productname + ", quantity=" + quantity + ", size=" + Arrays.toString(size) + "]";
	}
	
	

	
	
}
