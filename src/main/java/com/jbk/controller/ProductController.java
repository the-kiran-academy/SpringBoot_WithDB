package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Product;
import com.jbk.service.ProductService;
import com.jbk.serviceIMPL.ProductServiceIMPL;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/save-product")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {

		System.out.println(11);
		
		boolean isAdded = service.saveProduct(product);

		if (isAdded) {

			return new ResponseEntity<String>("Saved !", HttpStatus.CREATED);

		} else {

			return ResponseEntity.ok("Product Not Saved !");
		}

	}

	@GetMapping("/get-product-by-id/{id}")
	public Object getProduct(@PathVariable("id") String id) {
		
		Product product = service.getProductById(id);
		if (product != null) {
			return product;
		} else {
			return "Not Found";
		}

	}

	@GetMapping("/get-all-product")
	public List<Product> getProduct() {
		return service.getAllProduct();

	}

	@DeleteMapping("/delete-product")
	public String deleteProductById(@RequestParam("id") String id) {
		boolean isDeleted = service.deleteProductById(id);
		if (isDeleted) {
			return "deleted";
		} else {
			return "product not found to delete id= " + id;
		}
	}

	@PutMapping("/update-product")
	public String updateProduct(@RequestBody Product product) {
		boolean isUpdated = service.updateProduct(product);
		if (isUpdated) {
			return "updated";
		} else {
			return "product not found to update id= " + product.getProductId();
		}
	}

}
