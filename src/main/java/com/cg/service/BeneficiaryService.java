package com.cg.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Beneficiary;
import com.cg.repository.BeneficiaryRepo;

@Service
public class BeneficiaryService {

	@Autowired
	private BeneficiaryRepo benerepo;

	

	public List<Beneficiary> addBeneficiary(Beneficiary bene) {
		// TODO Auto-generated method stub
		 benerepo.save(bene);
		 return getbycustomerid(bene.getCustid());
		
	}
	
	public List<Beneficiary> getall() {
		// TODO Auto-generated method stub
		return benerepo.findAll();
		
	}

	public Beneficiary getbyid(int id) {
		// TODO Auto-generated method stub
		return benerepo.findById(id).get();
	}
	
	public int isBeneficiaryExists(String name,BigInteger mobile,BigInteger accno) {
		return benerepo.isBeneficiaryExists(name, mobile, accno);
	}
	
	public int isBenificiaryLinked(int custid,BigInteger accno) {
		return benerepo.isBenificiaryLinked(custid, accno);
	}

	public List<Beneficiary> getbycustomerid(int custid) {
		// TODO Auto-generated method stub
		return benerepo.getbycustomerid(custid);
	}

}
