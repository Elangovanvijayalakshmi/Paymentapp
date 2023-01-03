package com.cg.exception;

@SuppressWarnings("serial")
public class WalletNotFoundException extends Exception{
	public WalletNotFoundException() {
		
	}
	
	public WalletNotFoundException(String message) {
		super(message);
	}
		
}
