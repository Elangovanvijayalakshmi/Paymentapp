package com.cg.exception;

@SuppressWarnings("serial")
public class AccountNotFoundException extends Exception {
	
	public AccountNotFoundException() {

	}

	public AccountNotFoundException(String message) {
		super(message);
	}

}
