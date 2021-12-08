package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Bankaccount;
import com.cg.entity.Customer;
import com.cg.entity.Wallet;
import com.cg.repository.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	CustomerRepo customerrepo;
	
	public ResponseEntity<String> addCustomer(Customer c) {
		customerrepo.save(c);
		return new ResponseEntity("Added customer sucessfully",HttpStatus.OK);
	}
	public List<Customer> getall() {
		// TODO Auto-generated method stub
		return customerrepo.findAll();
		
	}

	public Customer getbyid(int id) {
		// TODO Auto-generated method stub
		return customerrepo.findById(id).get();
	}

}
