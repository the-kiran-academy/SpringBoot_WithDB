package com.jbk.model;

public class Charges {
	private double gstAmount;
	private double deliveryCharge;
	
	
	public Charges() {
		// TODO Auto-generated constructor stub
	}


	public Charges(double gstAmount, double deliveryCharge) {
		super();
		this.gstAmount = gstAmount;
		this.deliveryCharge = deliveryCharge;
	}


	public double getGstAmount() {
		return gstAmount;
	}


	public double getDeliveryCharge() {
		return deliveryCharge;
	}


	public void setGstAmount(double gstAmount) {
		this.gstAmount = gstAmount;
	}


	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	
	

}
