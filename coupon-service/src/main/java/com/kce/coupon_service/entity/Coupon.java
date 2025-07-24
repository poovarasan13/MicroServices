package com.kce.coupon_service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Coupon {
        
	@Id
	private String id;
	private String couponCode;
	private double discount;

	
	
	
	
}
