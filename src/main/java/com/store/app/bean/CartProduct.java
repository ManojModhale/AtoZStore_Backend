package com.store.app.bean;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="CartProducts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartProduct {
	
	@Id
	@GeneratedValue
   private int cartproductId;
	private int productid;
	  private String productname;
	  private String category;
	  private double price;
	  
	    private String description;
	    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "image_file_id")
	    private CartImageFile cartimageFile;
	    private String offer;
	    
	    private String size;
	    private String color;
	    
	    
	   
	
	
}
