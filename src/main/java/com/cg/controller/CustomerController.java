package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Bankaccount;
import com.cg.entity.Beneficiary;
import com.cg.entity.Billpayment;
import com.cg.entity.Customer;
import com.cg.entity.Wallet;
import com.cg.service.BankAccountService;
import com.cg.service.BeneficiaryService;
import com.cg.service.BillpaymentService;
import com.cg.service.CustomerService;
import com.cg.service.WalletService;

@RestController
@RequestMapping("app/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerservice;

	@PostMapping("/add_customer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer cust) {
		return customerservice.addCustomer(cust);
	}

	@GetMapping("/getall")
	public List<Customer> getAll() {
		return customerservice.getall();
	}

	@GetMapping("/getbyid/{id}")
	public Customer getbyid(@PathVariable("id") int id) {
		return customerservice.getbyid(id);
	}

	/*
	 * @GetMapping("/getAll") public List<Book> getAll() { return bservice.getAll();
	 * }
	 * 
	 * @GetMapping("/getB/{id}") public Book getBook(@PathVariable("id") int bid) {
	 * return bservice.getBook(bid);
	 * 
	 * }
	 * 
	 * @GetMapping("/getByBname/{nm}") public List<Book>
	 * getByBname(@PathVariable("nm") String name) { System.out.println(name);
	 * return bservice.getByBname(name); }
	 * 
	 * @PostMapping("/updateB") public Book updateBook(@RequestBody Book b) { return
	 * bservice.updateBook(b); // return bservice.getAll(); }
	 */

}
