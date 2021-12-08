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
public class Beneficiary {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_beneficiary")
	@SequenceGenerator(name="seq_beneficiary", sequenceName="seq_beneficiary", allocationSize=1)
	protected int bid;
	
	

	@Column
	protected String name;
	@Column
	protected BigInteger mobilenumber;
	@Column 
	protected int custid;
	@Column 
	protected BigInteger accountno;
	

	public Beneficiary() {

	}


	public Beneficiary(int bid, String name, BigInteger mobilenumber, int custid, BigInteger accountno) {
		super();
		this.bid = bid;
		this.name = name;
		this.mobilenumber = mobilenumber;
		this.custid = custid;
		this.accountno = accountno;
	}


	public BigInteger getAccountno() {
		return accountno;
	}


	public void setAccountno(BigInteger accountno) {
		this.accountno = accountno;
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigInteger getMobilenumber() {
		return mobilenumber;
	}


	public void setMobilenumber(BigInteger mobilenumber) {
		this.mobilenumber = mobilenumber;
	}


	public int getCustid() {
		return custid;
	}


	public void setCustid(int custid) {
		this.custid = custid;
	}


	@Override
	public String toString() {
		return "Beneficiary [bid=" + bid + ", name=" + name + ", mobilenumber=" + mobilenumber + ", custid=" + custid
				+ ", accountno=" + accountno + "]";
	}


	


	
	

}
