package com.jbk.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.jbk.entity.Category;
import com.jbk.entity.Supplier;

public class FinalProduct{
	
	private Long productId;
	private String productName;
	private Supplier supplierId;
	private Category categoryId;
	private Integer productQTY;
	private Double productPrice;
	private Charges charges;
	private Double discountAmount;
	private Double finalProductPrice;
	
	public FinalProduct() {
		// TODO Auto-generated constructor stub
	}
	
	public FinalProduct(Long productId, String productName, Supplier supplierId, Category categoryId,
			Integer productQTY, Double productPrice, Charges charges, Double discountAmount, Double finalProductPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.productQTY = productQTY;
		this.productPrice = productPrice;
		this.charges = charges;
		this.discountAmount = discountAmount;
		this.finalProductPrice = finalProductPrice;
	}

	public Long getProductId() {
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

	public Integer getProductQTY() {
		return productQTY;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public Charges getCharges() {
		return charges;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public Double getFinalProductPrice() {
		return finalProductPrice;
	}

	public void setProductId(Long productId) {
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

	public void setProductQTY(Integer productQTY) {
		this.productQTY = productQTY;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public void setCharges(Charges charges) {
		this.charges = charges;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public void setFinalProductPrice(Double finalProductPrice) {
		this.finalProductPrice = finalProductPrice;
	}
	
	

}
