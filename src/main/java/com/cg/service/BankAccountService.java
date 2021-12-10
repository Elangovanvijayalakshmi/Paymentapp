package com.cg.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Bankaccount;
import com.cg.entity.Billpayment;
import com.cg.repository.BankAccountRepo;
import com.cg.repository.WalletRepo;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountRepo baRepo;
	@Autowired
	private WalletRepo wRepo;

	public Bankaccount addBankAccount(Bankaccount ba) {
		return baRepo.save(ba);

	}

	public List<Bankaccount> getall() {
		// TODO Auto-generated method stub
		return baRepo.findAll();

	}

	public Bankaccount getbyid(int id) {
		// TODO Auto-generated method stub
		return baRepo.findById(id).get();
	}

	public Bankaccount viewbalance(int cu_id, BigInteger acc_no) {
		return baRepo.viewBalance(cu_id, acc_no);
	}

	public List<Bankaccount> updatebalance(double bal, BigInteger acc_no) {
		baRepo.updatebalance(bal, acc_no);
		return baRepo.findAll();
	}

	public ResponseEntity<String> deletebankaccount(int custid) {
		baRepo.deletebankaccount(custid);
		return new ResponseEntity<String>("beneficiary of " + custid + " is deleted", HttpStatus.OK);

	}

	/*
	 * public ResponseEntity<String> addmoneytowallet(Bankaccount b) { double
	 * bal=b.getBalance(); double amount=b.getAmount(); int
	 * cust_id=b.getCustomer_id();
	 * 
	 * if(bal<=amount) { baRepo.addmoneytowallet(b); wRepo.addmoneytowallet(b);
	 * 
	 * } return null; }
	 */

}
