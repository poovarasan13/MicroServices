package com.kce.order_service.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
    private String id;
    private String userName;
//    private String flavorId;
    private String flavourName;
    private String couponCode;
    private int quantity;
    private double price;
    private double totalPrice;
    private LocalDateTime orderDate;

	
}
