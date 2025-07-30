package com.kce.order_service.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flavour {
   private String name;
   private String descrption;
   private int price;
   
   
}
