package com.jbk.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jbk.entity.Product;


public interface ProductService {

	public boolean saveProduct(Product product);
	public Product getProductById(String productId);
	public List<Product> getAllProduct();
	public boolean deleteProductById(String productId);
	public boolean updateProduct(Product product);
	
	public List<Product> sortProductsById_ASC();
	public List<Product> sortProductsByName_DESC();
	public Product getMaxPriceProducts();
	public double countSumOfProductPrice();
	public int getTotalCountOfProducts();


}
