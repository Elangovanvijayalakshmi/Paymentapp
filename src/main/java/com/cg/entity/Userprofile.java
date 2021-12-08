package com.cg.entity;

import java.beans.JavaBean;
import java.math.BigInteger;

@JavaBean
public class Userprofile {

	private String name;
	private BigInteger mobile;
	private String password;
	private String ifsccode;
	private BigInteger accountno;
	private String bankName;
	private int balance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigInteger getMobile() {
		return mobile;
	}
	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIfsccode() {
		return ifsccode;
	}
	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}
	public BigInteger getAccountno() {
		return accountno;
	}
	public void setAccountno(BigInteger accountno) {
		this.accountno = accountno;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Userprofile [name=" + name + ", mobile=" + mobile + ", password=" + password + ", ifsccode=" + ifsccode
				+ ", accountno=" + accountno + ", bankName=" + bankName + ", balance=" + balance + "]";
	}
	
	
	
	
	
}
