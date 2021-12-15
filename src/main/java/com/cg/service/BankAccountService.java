package com.cg.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Bankaccount;
import com.cg.entity.Billpayment;
import com.cg.entity.Transaction;
import com.cg.exception.AccountNotFoundException;
import com.cg.exception.InsufficientFundException;
import com.cg.repository.BankAccountRepo;
import com.cg.repository.WalletRepo;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountRepo baRepo;
	@Autowired
	private WalletRepo wRepo;
	@Autowired
	private TransactionService transactionservice;

	/**
	 * 
	 * @param ba
	 * @return
	 */
	public Bankaccount addBankAccount(Bankaccount ba) {
		return baRepo.save(ba);

	}

	/**
	 * 
	 * @return
	 */

	public List<Bankaccount> getall() {
		// TODO Auto-generated method stub
		return baRepo.findAll();

	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	public Bankaccount getbyid(int id) {
		// TODO Auto-generated method stub
		return baRepo.findById(id).get();
	}

	/**
	 * 
	 * @param cu_id
	 * @param acc_no
	 * @return
	 * @throws AccountNotFoundException 
	 */

	public double viewbalance(int cu_id, BigInteger acc_no) throws AccountNotFoundException {
		if(baRepo.isValidBankAccount(acc_no) == 0) {
			throw new AccountNotFoundException("Account not Found");
		}
		return baRepo.viewBalance(cu_id, acc_no);}

	/**
	 * 
	 * @param bal
	 * @param acc_no
	 * @param custid
	 * @return
	 */

	public List<Bankaccount> updatebalance(double bal, BigInteger acc_no, int custid) {
		baRepo.updatebalance(bal, acc_no);
		return baRepo.getAccountByCustId(custid);
	}

	/**
	 * 
	 * @param custid
	 * @return
	 * @throws AccountNotFoundException 
	 */

	public ResponseEntity<String> deletebankaccount(int custid) throws AccountNotFoundException {
		if(baRepo.getAccountByCustId(custid).size()<=0) {
			throw new  AccountNotFoundException("Account not Found");
		}
		baRepo.deletebankaccount(custid);
		return new ResponseEntity<String>("Bank account is deleted", HttpStatus.OK);

	}

	/**
	 * 
	 * @param b
	 * @return
	 * @throws JSONException
	 * @throws InsufficientFundException 
	 */

	public ResponseEntity<String> addmoneytowallet(Bankaccount b) throws JSONException, InsufficientFundException {

		BigInteger acc_no = b.getAccountno();
		int cust_id = b.getCustomer_id();
		int wallet_id = wRepo.getWalletidfromcustid(cust_id);
		double amount = b.getBalance();
		double balance = baRepo.viewBalance(cust_id, acc_no);
		String type="Wallet deposit";
		LocalDate date=LocalDate.now();
		String description="Transfer money to wallet from bankaccount";

		if (amount <= balance) {
			baRepo.withdrawmoney(amount, acc_no, cust_id);
			wRepo.addmoneytowallet(wallet_id, amount);
		Transaction t=transactionservice.addTransaction(new Transaction(0,type,date,wallet_id,amount,description));
			
		} else {
			throw new InsufficientFundException("Insufficient funds");
		}
		return new ResponseEntity<String>("Added money to the wallet", HttpStatus.OK);

	}

	public List<Bankaccount> getbycustomerid(int id) throws AccountNotFoundException {

		if(baRepo.getAccountByCustId(id).size()<=0 ) {
			throw new AccountNotFoundException("Account not Found");
		}
		return baRepo.getAccountByCustId(id);}
	}


