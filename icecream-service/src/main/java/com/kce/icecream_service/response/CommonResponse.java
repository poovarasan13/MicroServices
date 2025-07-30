package com.kce.icecream_service.response;

import com.kce.icecream_service.enumeration.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    private ResponseStatus status;
    private String message;
    private int statusCode;
  
	
	private Object data;

}
