package com.cg.exception;

@SuppressWarnings("serial")
public class BeneficiaryNotFoundException extends Exception{
	
	public BeneficiaryNotFoundException() {

	}

	public BeneficiaryNotFoundException(String message) {
		super(message);
	}


}