package com.kce.order_service.response;

import com.kce.order_service.enumeration.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
  private ResponseStatus status;
  private String message;
  private Object data;
  private int statusCode;

  
}
