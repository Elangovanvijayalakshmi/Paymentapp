package com.cg.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Bankaccount;
import com.cg.entity.Customer;
import com.cg.entity.Wallet;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {


}
