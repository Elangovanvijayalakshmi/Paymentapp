package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Bankaccount;
import com.cg.entity.Billpayment;
import com.cg.repository.BankAccountRepo;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountRepo baRepo;

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
	
	/*
	 * public List<Book> getAll(){ return bRepo.findAll(); }
	 * 
	 * public Book getBook(int bid){ return bRepo.findById(bid).get(); }
	 * 
	 * public List<Book> getByBname(String name) {
	 * System.out.println(bRepo.getByBname(name)); return bRepo.getByBname(name); }
	 * 
	 * public Book updateBook(Book b) { bRepo.updatebyId(b.getBname(),b.getId());
	 * return bRepo.findById(b.getId()).get(); }
	 */
	

}
