package com.kce.order_service.dto;

import org.springframework.stereotype.Component;

@Component
public class OrderRequest {
	 private String userName;
	    private String flavorId;
	    private String couponCode;
	    private int quantity;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getFlavorId() {
			return flavorId;
		}
		public void setFlavorId(String flavorId) {
			this.flavorId = flavorId;
		}
		public String getCouponCode() {
			return couponCode;
		}
		public void setCouponCode(String couponCode) {
			this.couponCode = couponCode;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public OrderRequest(String userName, String flavorId, String couponCode, int quantity) {
			super();
			this.userName = userName;
			this.flavorId = flavorId;
			this.couponCode = couponCode;
			this.quantity = quantity;
		}
		public OrderRequest() {
			super();
		}
	    
}
