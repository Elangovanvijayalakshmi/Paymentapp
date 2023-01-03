package com.cg.exception;

@SuppressWarnings("serial")
public class InsufficientFundException extends Exception{
	public InsufficientFundException() {

	}

	public InsufficientFundException(String message) {
		super(message);
	}

}
