package com.cg.repository;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Bankaccount;
import com.cg.entity.Wallet;

@Repository
public interface BankAccountRepo extends JpaRepository<Bankaccount, Integer> {

	@Query(value = "select balance from bankaccount where customer_id=?1 and accountno=?2", nativeQuery = true)
	Bankaccount viewBalance(int custid, BigInteger accountno);

	@Transactional
	@Modifying
	@Query(value = "update bankaccount set balance=?1 where accountno=?2 and customer_id=?3", nativeQuery = true)
	void updatebalance(double bal, BigInteger acc_no);// 1 pqar

	@Query(value = "delete from bankaccount where customer_id=?1", nativeQuery = true)
	void deletebankaccount(int custid);

	/*
	 * @Query(
	 * value="update bankaccount set balance=balance-?3 where customer_is=?1 and accountno=?2"
	 * ) void deductmoneyfrombank(int custid,BigInteger accno,double balance);
	 */

}
