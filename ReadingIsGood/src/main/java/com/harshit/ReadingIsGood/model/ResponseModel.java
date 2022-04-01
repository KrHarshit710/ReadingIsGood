package com.harshit.ReadingIsGood.model;

import org.springframework.http.HttpStatus;

public class ResponseModel {
	
	private HttpStatus status;
	
	private String message;

	public ResponseModel(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HttpStatus getStatusCode() {
		return status;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.status = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
