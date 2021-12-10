package com.cg.service;

import java.math.BigInteger;
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

	public Customer addCustomer(Customer c) {
		return customerrepo.save(c);

	}

	public List<Customer> getall() {
		return customerrepo.findAll();

	}

	public Customer getbyid(int id) {
		return customerrepo.findById(id).get();
	}

	public Customer getbylogin(BigInteger mobile, String password) {
		return customerrepo.findBymobile(mobile, password);
	}

}
