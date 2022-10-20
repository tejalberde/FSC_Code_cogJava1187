package com.example.EstockExchangeCogJava1187.entity;

import org.springframework.stereotype.Component;

@Component
public class ResponseData {

	int code;
	String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
