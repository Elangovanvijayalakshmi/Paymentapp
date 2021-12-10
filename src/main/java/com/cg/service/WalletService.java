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

	public Wallet addWallet(Wallet w) {
		return wRepo.save(w);

	}

	public List<Wallet> getall() {
		// TODO Auto-generated method stub
		return wRepo.findAll();

	}

	public Wallet getbyid(int id) {
		// TODO Auto-generated method stub
		return wRepo.findById(id).get();
	}

	public Wallet updateBalance(double bal, int walletid) {
		wRepo.updatebalance(bal, walletid);
		return wRepo.findById(walletid).get();
	}


}
