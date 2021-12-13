package com.cg.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Transaction;
import com.cg.repository.TransactionRepo;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepo transactionrepo;

	public Transaction addTransaction(Transaction t) {
		
		return transactionrepo.save(t);
	}

	
	
	

}
