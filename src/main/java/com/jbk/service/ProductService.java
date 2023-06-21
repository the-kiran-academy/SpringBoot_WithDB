package com.jbk.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jbk.entity.Product;

public interface ProductService {

	public Boolean addProduct(Product product);

	public Product getProductById(Long id);

	public Product getProductByName(String productName);

	public List<Product> getAllProducts();

	public Boolean deleteProduct(Long id);

	public Boolean updateProduct(Product product);

	public List<Product> sortProducts(String sortBy, String fielsName);

	public List<Product> getMaxPriceProducts();

	public Double countSumOfProductPrice();

	public Long getTotalCountOfProducts();
	
	public String uploadSheet(MultipartFile file);


}
