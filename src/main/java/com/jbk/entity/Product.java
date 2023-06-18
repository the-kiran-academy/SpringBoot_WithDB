package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Product {
	
	@Id
	@Column(unique = true,nullable = false)
	private String productId;
	
	@Column(unique = true,nullable = false)
	private String productName;
	
	@OneToOne
	@JoinColumn(name = "supplierId")
	private Supplier supplierId;
	
	@OneToOne
	@JoinColumn(name = "categoryId")
	private Category categoryId;
	
	@Column(nullable = false)
	private int productQty;
	
	@Column(nullable = false)
	private double productPrice;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(String productId, String productName, Supplier supplierId, Category categoryId, int productQty,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.productQty = productQty;
		this.productPrice = productPrice;
	}


	public String getProductId() {
		return productId;
	}


	public String getProductName() {
		return productName;
	}


	public Supplier getSupplierId() {
		return supplierId;
	}


	public Category getCategoryId() {
		return categoryId;
	}


	public int getProductQty() {
		return productQty;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public void setSupplierId(Supplier supplierId) {
		this.supplierId = supplierId;
	}


	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}


	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
	
}
