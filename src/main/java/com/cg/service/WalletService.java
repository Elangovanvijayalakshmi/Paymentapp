package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Wallet;
import com.cg.repository.WalletRepo;

@Service
public class WalletService {

	@Autowired
	private WalletRepo wRepo;

	/**
	 * 
	 * @param w
	 * @return
	 */
	public Wallet addWallet(Wallet w) {
		return wRepo.save(w);

	}

	/**
	 * 
	 * @return
	 */

	public List<Wallet> getall() {
		// TODO Auto-generated method stub
		return wRepo.findAll();

	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	public Wallet getbyid(int id) {
		// TODO Auto-generated method stub
		return wRepo.findById(id).get();
	}

	/**
	 * 
	 * @param bal
	 * @param walletid
	 * @return
	 */

	public Wallet updateBalance(double bal, int walletid) {
		wRepo.updatebalance(bal, walletid);
		return wRepo.findById(walletid).get();
	}

	public double showbalance(int walletid) {
		// TODO Auto-generated method stub
		return wRepo.getbalance(walletid);
	}

	public int getwalletidbycustid(int id) {
		// TODO Auto-generated method stub
		return wRepo.getWalletidfromcustid(id);
	}

	public List<Wallet> getwalletbycustomerid(int id) {
		return wRepo.getwalletbycustomerid(id);
	}
	
	

}
