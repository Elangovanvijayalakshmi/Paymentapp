package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table
@Entity
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE1")
	@SequenceGenerator(name = "SEQUENCE1", sequenceName = "SEQUENCE1", allocationSize = 1)
	protected int walletid;

	@Column
	protected double balance;

	public Wallet() {

	}

	public Wallet(int walletid, double balance) {
		super();
		this.walletid = walletid;
		this.balance = balance;
	}

	public int getWalletid() {
		return walletid;
	}

	public void setWalletid(int walletid) {
		this.walletid = walletid;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Wallet [walletid=" + walletid + ", balance=" + balance + "]";
	}

}
