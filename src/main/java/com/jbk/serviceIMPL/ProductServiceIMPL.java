package com.jbk.serviceIMPL;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Product;
import com.jbk.service.ProductService;


@Service
public class ProductServiceIMPL implements ProductService {
	
	
	@Autowired
	private ProductDao dao;

	@Override
	public boolean saveProduct(Product product) {
		
		String productId = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		product.setProductId(productId);

		
		boolean isAdded = dao.saveProduct(product);

		return isAdded;
	}

	@Override
	public Product getProductById(String productId) {
		
		Product product = dao.getProductById(productId);

		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		return null;
	}

	@Override
	public boolean deleteProductById(String productId) {
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		return false;
	}

	@Override
	public List<Product> sortProductsById_ASC() {
		
		return null;
	}

	@Override
	public List<Product> sortProductsByName_DESC() {
		
		return null;
	}

	@Override
	public Product getMaxPriceProducts() {

		
		
		return null;
	}

	@Override
	public double countSumOfProductPrice() {
		
		return 0;
	}

	@Override
	public int getTotalCountOfProducts() {
		
		return 0;
	}

}
