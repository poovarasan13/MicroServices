package com.kce.order_service.dto;

import org.springframework.stereotype.Component;

@Component
public class Flavour {
   private String name;
   private String descrption;
   private int price;
   public Flavour() {
	super();
}
   public Flavour(String name, String descrption, int price) {
	super();
	this.name = name;
	this.descrption = descrption;
	this.price = price;
}
   public String getName() {
	return name;
   }
   public void setName(String name) {
	this.name = name;
   }
   public String getDescrption() {
	return descrption;
   }
   public void setDescrption(String descrption) {
	this.descrption = descrption;
   }
   public int getPrice() {
	return price;
   }
   public void setPrice(int price) {
	this.price = price;
   }
   
}
