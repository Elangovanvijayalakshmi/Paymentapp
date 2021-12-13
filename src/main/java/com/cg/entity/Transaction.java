package com.cg.entity;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * 
 * @author eelangov
 *
 */


@Table
@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transaction")
	@SequenceGenerator(name = "seq_transaction", sequenceName = "seq_transaction", allocationSize = 1)
	protected int transaction_id;

	@Column
	protected String transaction_type;
	@Column
	protected LocalDate transaction_date;
	@Column
	protected int wallet_id;
	@Column
	protected double amount;
	@Column
	protected String description;

	public Transaction() {

	}
	/**
	 * 
	 * @param transaction_id
	 * @param transaction_type
	 * @param transaction_date
	 * @param wallet_id
	 * @param amount
	 * @param description
	 */

	public Transaction(int transaction_id, String transaction_type, LocalDate transaction_date, int wallet_id, double amount,
			String description) {
		super();
		this.transaction_id = transaction_id;
		this.transaction_type = transaction_type;
		this.transaction_date = transaction_date;
		this.wallet_id = wallet_id;
		this.amount = amount;
		this.description = description;
	}

	/**
	 * 
	 * @return
	 */
	public int getTransaction_id() {
		return transaction_id;
	}
	/**
	 * 
	 * @param transaction_id
	 */

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	/**
	 * 
	 * @return
	 */

	public String getTransaction_type() {
		return transaction_type;
	}
	/**
	 * 
	 * @param transaction_type
	 */

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	/**
	 * 
	 * @return
	 */

	public LocalDate getTransaction_date() {
		return transaction_date;
	}
	/**
	 * 
	 * @param transaction_date
	 */

	public void setTransaction_date(LocalDate transaction_date) {
		this.transaction_date = transaction_date;
	}
	/**
	 * 
	 * @return
	 */

	public int getWallet_id() {
		return wallet_id;
	}
	/**
	 * 
	 * @param wallet_id
	 */

	public void setWallet_id(int wallet_id) {
		this.wallet_id = wallet_id;
	}
	/**
	 * 
	 * @return
	 */

	public double getAmount() {
		return amount;
	}
	/**
	 * 
	 * @param amount
	 */

	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * 
	 * @return
	 */

	public String getDescription() {
		return description;
	}
	/**
	 * 
	 * @param description
	 */

	public void setDescription(String description) {
		this.description = description;
	}
	

	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", transaction_type=" + transaction_type
				+ ", transaction_date=" + transaction_date + ", wallet_id=" + wallet_id + ", amount=" + amount
				+ ", description=" + description + "]";
	}
	
}
