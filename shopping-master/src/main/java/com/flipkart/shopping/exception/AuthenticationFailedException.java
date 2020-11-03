package com.flipkart.shopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Authentication failed: Invalid username or password")
public class AuthenticationFailedException  extends Exception {
	
	 
	private static final long serialVersionUID = 1L;

	public AuthenticationFailedException() {
		super();
	}

	public AuthenticationFailedException(String message) {
		super(message);
	}

}
