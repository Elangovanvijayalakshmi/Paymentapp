package com.cg.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class DemoException {
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler({CustomerNotFoundException.class})
	public ErrorMapper handleConflict(CustomerNotFoundException ex, HttpServletRequest req) {
		String msg = ex.getMessage();
		String uri = req.getRequestURI().toString();
		return new ErrorMapper(uri,msg,new Date());
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler({InsufficientFundException.class})
	public ErrorMapper handleConflict(InsufficientFundException ex, HttpServletRequest req) {
		String msg = ex.getMessage();
		String uri = req.getRequestURI().toString();
		return new ErrorMapper(uri,msg,new Date());
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler({BillNotFoundException.class})
	public ErrorMapper handleConflict(BillNotFoundException ex, HttpServletRequest req) {
		String msg = ex.getMessage();
		String uri = req.getRequestURI().toString();
		return new ErrorMapper(uri,msg,new Date());
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler({AccountNotFoundException.class})
	public ErrorMapper handleConflict(AccountNotFoundException ex, HttpServletRequest req) {
		String msg = ex.getMessage();
		String uri = req.getRequestURI().toString();
		return new ErrorMapper(uri,msg,new Date());
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler({UserAlreadyExistsException.class})
	public ErrorMapper handleConflict(UserAlreadyExistsException ex, HttpServletRequest req) {
		String msg = ex.getMessage();
		String uri = req.getRequestURI().toString();
		return new ErrorMapper(uri,msg,new Date());
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler({UserNotFoundException.class})
	public ErrorMapper handleConflict(UserNotFoundException ex, HttpServletRequest req) {
		String msg = ex.getMessage();
		String uri = req.getRequestURI().toString();
		return new ErrorMapper(uri,msg,new Date());
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler({WalletNotFoundException.class})
	public ErrorMapper handleConflict(WalletNotFoundException ex, HttpServletRequest req) {
		String msg = ex.getMessage();
		String uri = req.getRequestURI().toString();
		return new ErrorMapper(uri,msg,new Date());
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler({InvalidBenefeciaryException.class})
	public ErrorMapper handleConflict(InvalidBenefeciaryException ex, HttpServletRequest req) {
		String msg = ex.getMessage();
		String uri = req.getRequestURI().toString();
		return new ErrorMapper(uri,msg,new Date());
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler({BeneficiaryNotFoundException.class})
	public ErrorMapper handleConflict(BeneficiaryNotFoundException ex, HttpServletRequest req) {
		String msg = ex.getMessage();
		String uri = req.getRequestURI().toString();
		return new ErrorMapper(uri,msg,new Date());
	}
	
	
}
