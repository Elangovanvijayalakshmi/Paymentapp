package com.cg.exception;

@SuppressWarnings("serial")
public class  BillNotFoundException extends Exception{
	
	public BillNotFoundException() {

	}

	public BillNotFoundException(String message) {
		super(message);
	}


}
