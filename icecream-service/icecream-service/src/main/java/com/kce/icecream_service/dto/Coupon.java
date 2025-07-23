package com.kce.icecream_service.dto;

public class Coupon {
	private String couponCode;
	private double discount;
	public Coupon(String couponCode, double discount) {
		super();
		this.couponCode = couponCode;
		this.discount = discount;
	}
	public Coupon() {
		super();
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
