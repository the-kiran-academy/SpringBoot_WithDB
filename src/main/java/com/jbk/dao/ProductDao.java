package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Product;

public interface ProductDao {
	
	public boolean saveProduct(Product product);
	public Product getProductById(String productId);
	public List<Product> getAllProduct();
	public boolean deleteProductById(String productId);
	public boolean updateProduct(Product product);
	
	


}
