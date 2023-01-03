package com.cg.exception;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends Exception {
	
	public UserAlreadyExistsException() {

	}

	public UserAlreadyExistsException(String message) {
		super(message);
	}

}
