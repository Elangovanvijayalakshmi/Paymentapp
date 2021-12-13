package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Bankaccount;
import com.cg.entity.Beneficiary;
import com.cg.entity.Billpayment;
import com.cg.entity.Customer;
import com.cg.entity.Transaction;
import com.cg.entity.Wallet;
import com.cg.service.BankAccountService;
import com.cg.service.BeneficiaryService;
import com.cg.service.BillpaymentService;
import com.cg.service.CustomerService;
import com.cg.service.TransactionService;
import com.cg.service.WalletService;

@RestController
@RequestMapping("app/wallet/transaction")
public class TransactionController {

	@Autowired
	private TransactionService tservice;
	/*
	 * @Autowired private WalletService wservice;
	 */

	/**
	 * 
	 * @param t
	 * @return
	 */
	@PostMapping("/addtransaction")
	public Transaction addTransaction(@RequestBody Transaction t) {
		return tservice.addTransaction(t);

	}

//	/**
//	 * 
//	 * @return
//	 */
//
//	@GetMapping("/getall")
//	public List<Wallet> getAll() {
//		return wservice.getall();
//	}
//
//	/**
//	 * 
//	 * @param id
//	 * @return
//	 */
//
//	@GetMapping("/getbyid/{id}")
//	public Wallet getbyid(@PathVariable("id") int id) {
//		return wservice.getbyid(id);
//	}
//
//	/**
//	 * 
//	 * @param w
//	 * @return
//	 */
//
//	@PostMapping("/updatebal")
//	public Wallet updatebal(@RequestBody Wallet w) {
//		return wservice.updateBalance(w.getBalance(), w.getWalletid());
//	}

}
