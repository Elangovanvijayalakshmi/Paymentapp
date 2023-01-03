package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Transaction;
import com.cg.repository.TransactionRepo;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepo transactionrepo;
	@Autowired
	private WalletService walletservice;

	public Transaction addTransaction(Transaction t) {
		
		return transactionrepo.save(t);
	}

	public List<Transaction> gettransactionbycustid(int id) {
		// TODO Auto-generated method stub
		int wallet_id=walletservice.getwalletidbycustid(id);
		return transactionrepo.getbycustomerid(wallet_id);
		
	}

	
	
	

}
