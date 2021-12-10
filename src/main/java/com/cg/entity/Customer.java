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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_customer")
	@SequenceGenerator(name = "seq_customer", sequenceName = "seq_customer", allocationSize = 1)
	protected int custid;

	@Column
	protected String name;
	@Column
	protected BigInteger mobile;
	@Column
	protected int wallet_id;
	@Column
	protected String password;

	public Customer() {

	}

	public Customer(int custid, String name, BigInteger mobile, int wallet_id, String password) {
		super();
		this.custid = custid;
		this.name = name;
		this.mobile = mobile;
		this.wallet_id = wallet_id;
		this.password = password;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

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

	public int getWallet_id() {
		return wallet_id;
	}

	public void setWallet_id(int wallet_id) {
		this.wallet_id = wallet_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", name=" + name + ", mobile=" + mobile + ", wallet_id=" + wallet_id
				+ ", password=" + password + "]";
	}

}
