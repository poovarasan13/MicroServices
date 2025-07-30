package com.kce.icecream_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlavourDTO {
    private String id;
    private String name;
    private String description;
    private  double price;
}
