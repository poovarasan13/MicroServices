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
    public ResponseStatus getStatus() {
		return status;
	}
	public CommonResponse() {
		super();
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
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public CommonResponse(ResponseStatus status, String message, int statusCode, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.data = data;
	}
	private Object data;

}
