package com.kce.order_service.response;

import com.kce.order_service.enumeration.ResponseStatus;

public class CommonResponse {
  private ResponseStatus status;
  private String message;
  private Object data;
  private int statusCode;
  public ResponseStatus getStatus() {
	return status;
  }
  public void setStatus(ResponseStatus status) {
	this.status = status;
  }
  public String getMessage() {
	return message;
  }
  public void setMessage(String message) {
	this.message = message;
  }
  public Object getData() {
	return data;
  }
  public void setData(Object data) {
	this.data = data;
  }
  public int getStatusCode() {
	return statusCode;
  }
  public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
  }
  public CommonResponse(ResponseStatus status, String message, Object data, int statusCode) {
	super();
	this.status = status;
	this.message = message;
	this.data = data;
	this.statusCode = statusCode;
  }
  public CommonResponse() {
	super();
  }
  
}
