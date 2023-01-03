package com.cg.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Billpayment;
import com.cg.entity.Customer;
import com.cg.entity.Transaction;
import com.cg.entity.Wallet;
import com.cg.exception.BillNotFoundException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.InsufficientFundException;
import com.cg.repository.BillpaymentRepo;
import com.cg.repository.CustomerRepo;
import com.cg.repository.WalletRepo;

@Service
public class BillpaymentService {
	@Autowired
	private BillpaymentRepo billpaymentrepo;
	@Autowired
	private WalletRepo wRepo;
	@Autowired
	private CustomerRepo customerrepo;
	@Autowired
	private TransactionService transactionservice;
	@Autowired
	private WalletRepo walletrepo;

	/**
	 * 
	 * @param b
	 * @return
	 */

	public Billpayment addBill(Billpayment b) throws InsufficientFundException, CustomerNotFoundException {
		
		int walletid=walletrepo.getWalletidfromcustid(b.getCustomer_id());
	    if(walletid<0) {
	    	throw new CustomerNotFoundException("Customer not found");
	    }
	    else {
		
			double walletBalance = wRepo.getbalance(walletid);
			String type = b.getBtype();
			String description = "Pay bill amount from wallet";
			LocalDate date = LocalDate.now();
			if (b.getAmount() <= walletBalance) {
				wRepo.payBill(b.getAmount(), walletid);
				Transaction t = transactionservice
						.addTransaction(new Transaction(0, type, date, walletid, b.getAmount(), description));
				b.setDdate(date);
				return billpaymentrepo.save(b);
				}
			else {
				throw new InsufficientFundException("Insufficient fund");
			}
	    }
	}
			

	/**
	 * 
	 * @return
	 */

	public List<Billpayment> getall() {
		// TODO Auto-generated method stub
		return billpaymentrepo.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws BillNotFoundException 
	 */

		// TODO Auto-generated method stub
	public List<Billpayment> getbycustomerid(int id) throws BillNotFoundException {
		if(billpaymentrepo.getbycustomerid(id)==null) {
			throw new BillNotFoundException("No Bill found for the customer");
		}
		else {
			return billpaymentrepo.getbycustomerid(id);
		}
		
	}

}
