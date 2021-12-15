package com.cg.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Bankaccount;
import com.cg.exception.AccountNotFoundException;
import com.cg.exception.InsufficientFundException;
import com.cg.service.BankAccountService;

@RestController
@RequestMapping("app/bankaccount")
public class BankAccountController {

	@Autowired
	private BankAccountService baccountservice;

	/**
	 * 
	 * @param ba
	 * @return
	 */

	@PostMapping("/add")
	public Bankaccount addBankAccount(@RequestBody Bankaccount ba) {
		return baccountservice.addBankAccount(ba);

	}

	/**
	 * 
	 * @return
	 */

	@GetMapping("/getall")
	public List<Bankaccount> getAll() {
		return baccountservice.getall();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/getbyid/{id}")
	public Bankaccount getbyid(@PathVariable("id") int id) {
		return baccountservice.getbyid(id);
	}

	/**
	 * 
	 * @param b
	 * @return
	 * @throws AccountNotFoundException 
	 */

	@PostMapping("/getbalance")
	public double getbalance(@RequestBody Bankaccount b) throws AccountNotFoundException {
		return baccountservice.viewbalance(b.getCustomer_id(), b.getAccountno());
	}

	/**
	 * 
	 * @param b
	 * @return
	 */

	@PostMapping("/updatebalance")
	public List<Bankaccount> updatebalance(@RequestBody Bankaccount b) {
		return baccountservice.updatebalance(b.getBalance(), b.getAccountno(), b.getCustomer_id());
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws AccountNotFoundException 
	 */

	@PostMapping("/deletebankaccount")
	public ResponseEntity<String> deletebankaccount(@RequestBody Bankaccount b) throws AccountNotFoundException {
		int	cust_id=b.getCustomer_id();
		return baccountservice.deletebankaccount(cust_id);
		
	}

	/**
	 * 
	 * @param b
	 * @return
	 * @throws JSONException
	 * @throws InsufficientFundException 
	 */

	@PostMapping("/addmoneytowallet")
	public ResponseEntity<String> addMoneytoWallet(@RequestBody Bankaccount b) throws JSONException, InsufficientFundException {
		System.out.println(b.toString());
		return baccountservice.addmoneytowallet(b);

		
		
	}
	@GetMapping("/getbycustomer/{id}")
	public List<Bankaccount> getbycustomerid(@PathVariable("id") int id) throws AccountNotFoundException {
		return baccountservice.getbycustomerid(id);
	}

}
