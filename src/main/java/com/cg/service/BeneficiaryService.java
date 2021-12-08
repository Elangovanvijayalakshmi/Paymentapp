package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Bankaccount;
import com.cg.entity.Beneficiary;
import com.cg.repository.BankAccountRepo;
import com.cg.repository.BeneficiaryRepo;

@Service
public class BeneficiaryService {

	@Autowired
	private BeneficiaryRepo benerepo;

	

	public ResponseEntity<String> addBeneficiary(Beneficiary bene) {
		// TODO Auto-generated method stub
		benerepo.save(bene);
		return new ResponseEntity("Added beneficiary successfully",HttpStatus.OK);
	}
	
	public List<Beneficiary> getall() {
		// TODO Auto-generated method stub
		return benerepo.findAll();
		
	}

	public Beneficiary getbyid(int id) {
		// TODO Auto-generated method stub
		return benerepo.findById(id).get();
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
