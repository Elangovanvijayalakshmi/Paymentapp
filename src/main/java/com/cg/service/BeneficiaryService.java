package com.cg.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Bankaccount;
import com.cg.entity.Beneficiary;
import com.cg.entity.Transaction;
import com.cg.repository.BankAccountRepo;
import com.cg.repository.BeneficiaryRepo;
import com.cg.repository.CustomerRepo;
import com.cg.repository.WalletRepo;

@Service
public class BeneficiaryService {

	@Autowired
	private BeneficiaryRepo benerepo;
	@Autowired
	private WalletRepo walletrepo;
	@Autowired
	private BankAccountRepo bankaccountrepo;
	@Autowired
	private CustomerRepo customerrepo;
	@Autowired
	private TransactionService transactionservice;
	

	/**
	 * 
	 * @param bene
	 * @return
	 */

	public List<Beneficiary> addBeneficiary(Beneficiary bene) {
		// TODO Auto-generated method stub
		benerepo.save(bene);
		return getbycustomerid(bene.getCustid());

	}

	/**
	 * 
	 * @return
	 */

	public List<Beneficiary> getall() {
		// TODO Auto-generated method stub
		return benerepo.findAll();

	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	public Beneficiary getbyid(int id) {
		// TODO Auto-generated method stub
		return benerepo.findById(id).get();
	}

	/**
	 * 
	 * @param name
	 * @param mobile
	 * @param accno
	 * @return
	 */

	public int isBeneficiaryExists(String name, BigInteger mobile, BigInteger accno) {
		return benerepo.isBeneficiaryExists(name, mobile, accno);
	}

	/**
	 * 
	 * @param custid
	 * @param accno
	 * @return
	 */

	public int isBenificiaryLinked(int custid, BigInteger accno) {
		return benerepo.isBenificiaryLinked(custid, accno);
	}

	/**
	 * 
	 * @param custid
	 * @return
	 */

	public List<Beneficiary> getbycustomerid(int custid) {
		// TODO Auto-generated method stub
		return benerepo.getbycustomerid(custid);
	}

	/**
	 * 
	 * @param bid
	 * @return
	 */

	public ResponseEntity<String> deletebeneficiary(int bid) {
		benerepo.deleteBeneficiary(bid);

		return new ResponseEntity<String>("Beneficiary deleted successfully", HttpStatus.OK);
	}

	
	
	public ResponseEntity<String> sendmoneytobeneficiary(Bankaccount b){
		int customer_id=b.getCustomer_id();
		int wallet_id=walletrepo.getWalletidfromcustid(customer_id);
		double walletbalance=walletrepo.getbalance(wallet_id);
		String type="Withdraw";
		String description="send money to beneficiary";
		LocalDate date=LocalDate.now();
		
		
		
		int bene_cust_id=bankaccountrepo.getcustomerid(b.getAccountno());
		if(bene_cust_id>0) {
		
		if(b.getBalance()<=walletbalance) {
			walletrepo.updatebalance(b.getBalance(), wallet_id);
			bankaccountrepo.updatebalance(b.getBalance(),b.getAccountno());
			Transaction t=transactionservice.addTransaction(new Transaction(0,type,date,wallet_id,b.getBalance(),description));
			
		}
		else {
			return new ResponseEntity<String>("insufficient balance",HttpStatus.OK);
		}
		
		}
		return new ResponseEntity<String>("Fund transfer successfull",HttpStatus.OK);
		
	}
	
	//send moneyto beneficiary
	//input bankacount obj send custid || beneficiary acc no balance
	//get bene custid from accno
	//wallet repo getbalance by custid
	//validation
	//bankacc service updatebalance bene acc,bene cust
	//transaction 
	//fund transfer successful
	
}
