package com.cg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Bankaccount;
import com.cg.service.BankAccountService;

@RestController
@RequestMapping("app/bankaccount")
public class BankAccountController {

	@Autowired
	private BankAccountService baccountservice;

	@PostMapping("/add")
	public ResponseEntity<String> addBankAccount(@RequestBody Bankaccount ba) {
		return baccountservice.addBankAccount(ba);
	}

	@GetMapping("/getall")
	public List<Bankaccount> getAll() {
		return baccountservice.getall();
	}

	@GetMapping("/getbyid/{id}")
	public Bankaccount getbyid(@PathVariable("id") int id) {
		return baccountservice.getbyid(id);
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
