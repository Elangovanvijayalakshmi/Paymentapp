package com.cg.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Wallet;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Integer> {
	@Transactional
	@Modifying
	@Query(value = "update wallet set balance=?1 where walletid=?2", nativeQuery = true)
	void updatebalance(double bal, int walletid);

	@Query(value = "select balance from wallet where walletid=?1", nativeQuery = true)
	double getbalance(int cid);
	
	@Transactional
	@Modifying
	@Query(value="update wallet set balance=(balance+?2) where walletid=?1",nativeQuery=true)
	void addmoneytowallet(int cid,double amount);

	@Query(value="SELECT Wallet_id FROM CUSTOMER c WHERE c.CUSTID =?1",nativeQuery=true)
	int getWalletidfromcustid(int cust_id);
	
	/*
	 * @Query(value="update wallet set balance=balance+?1 where walletid=?2"
	 * ,nativeQuery=true) void addmoneytowallet(double balance,int wallet_id);
	 */
	/*
	 * @Query(
	 * value="UPDATE WALLET SET BALANCE =BALANCE +bal INNER JOIN CUSTOMER c WHERE WALLETID =c.WALLET_ID "
	 * ) void addmoneytowallet(int custid,double bal);
	 */
	
}
