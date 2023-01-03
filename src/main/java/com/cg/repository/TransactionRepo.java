package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entity.Transaction;


public interface TransactionRepo extends JpaRepository<Transaction, Integer>  {

	
	
	
	@Query(value="SELECT * FROM TRANSACTION WHERE wallet_id=?1",nativeQuery=true)
	List<Transaction> getbycustomerid(int wallet_id);
	

}
