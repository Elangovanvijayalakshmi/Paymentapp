package com.cg.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table
@Entity
public class Bankaccount {
	@Id
	protected BigInteger accountno;
	@Column
	protected String ifsccode;
	@Column
	protected String bankname;
	@Column
	protected int customer_id;
	@Column
	protected double balance;

	public Bankaccount() {

	}

	public Bankaccount(BigInteger accountno, String ifsccode, String bankname, int customer_id, double balance) {
		super();
		this.accountno = accountno;
		this.ifsccode = ifsccode;
		this.bankname = bankname;
		this.customer_id = customer_id;
		this.balance = balance;
	}

	public BigInteger getAccountno() {
		return accountno;
	}

	public void setAccountno(BigInteger accountno) {
		this.accountno = accountno;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Bankaccount [accountno=" + accountno + ", ifsccode=" + ifsccode + ", bankname=" + bankname
				+ ", customer_id=" + customer_id + ", balance=" + balance + "]";
	}

	


}
