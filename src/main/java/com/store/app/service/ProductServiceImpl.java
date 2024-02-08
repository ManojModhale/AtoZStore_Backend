package com.store.app.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.store.app.bean.ImageFile;
import com.store.app.bean.Products;
import com.store.app.dao.ProductsRepository;

@Service
public class ProductServiceImpl implements ProductService 
{
	
	@Autowired
	private ProductsRepository productsRepository1;

	private final String uploadDirectory = "F:\\SpringBoot Programming 27_10_23\\Product_Backend\\src\\main\\resources";

	@Override
	public ResponseEntity<Products> saveNewProduct(Products product, MultipartFile file) throws IOException 
	{
		// TODO Auto-generated method stub
		String currentCategory = product.getCategory();
		String folderPath = Paths.get(uploadDirectory, currentCategory).toString();

		File directory = new File(folderPath);
		if (!directory.exists()) {
			directory.mkdirs();
		}

		String filePath = Paths.get(folderPath, file.getOriginalFilename()).toString();
		try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
			fileOutputStream.write(file.getBytes());
		}

		product.setImageFile(ImageFile.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.filePath(filePath).build());

		Products prod = saveProduct(product);
		if (prod != null) {
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@Override
	public Products saveProduct(Products product) 
	{
		// TODO Auto-generated method stub
		return productsRepository1.save(product);
	}

	@Override
	public List<Products> getAllProducts() 
	{
		// TODO Auto-generated method stub
		return productsRepository1.findAll();
	}

	@Override
	public Optional<Products> getProductById(int productId) {
	    System.out.println("Product Id:" + productId);

	    Optional<Products> optionalProduct = productsRepository1.findById(productId);
	    if (optionalProduct.isPresent()) {
	        Products product = optionalProduct.get();
	        System.out.println(product);
	    }
	    return optionalProduct;
	}

	@Override
	public void deleteProduct(int productId) 
	{
    	productsRepository1.deleteById(productId);
    }

	@Override
	 public List<String> getColorsByProductId(int productId) {
	     return productsRepository1.findColorsByProductid(productId);
	 }


	@Override
    public List<String> getProductSizes(int productId) {
        return productsRepository1.findSizesByProductid(productId);
    }

	@Override
	public List<Products> getCategorizedProducts(String category) {
		// TODO Auto-generated method stub
		return productsRepository1.findByCategory(category);
	}
	
	
	@Override
	public List<Products> getProductByName(String productname) 
	{
		// TODO Auto-generated method stub
		return productsRepository1.findByProductname(productname);
	}

	@Override
	public List<Products> getByPriceRange(double min, double max) {
		// TODO Auto-generated method stub
		return productsRepository1.findByPriceRange(min, max);
	}

	 //image upload
    public ResponseEntity<Products> uploadImage(int productId,MultipartFile file) throws IOException 
	{
    	Optional<Products> optionalProduct = productsRepository1.findById(productId);
        if (optionalProduct.isPresent()) {
            Products product = optionalProduct.get();
            
            String currentCategory=product.getCategory();
            String folderPath= Paths.get(uploadDirectory,currentCategory).toString();
            
            File directory = new File(folderPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            
            String filePath = Paths.get(folderPath, file.getOriginalFilename()).toString();
            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                fileOutputStream.write(file.getBytes());
            }
            
            product.setImageFile(ImageFile.builder()
			        .name(file.getOriginalFilename())
			        .type(file.getContentType())
			        .filePath(filePath)
			        .build());
            	
			saveProduct(product);
			return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    		
	}
    
    //image download
    public byte[] downloadImage(int productId) throws IOException
	{
    	Optional<Products> optionalProduct = productsRepository1.findById(productId);
        if (optionalProduct.isPresent()) 
        {
        	Products product = optionalProduct.get();
        	
        	String imagepath=product.getImageFile().getFilePath();
        	return Files.readAllBytes(new File(imagepath).toPath());
  
        }
		return null;	
	}

	

}
