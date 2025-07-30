package com.kce.icecream_service.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flavour {

    @Id
    private String id;
    private String name;
    private String description;
    private double price;

    
}
