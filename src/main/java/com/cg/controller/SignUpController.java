package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Customer;
import com.cg.entity.Userprofile;
import com.cg.service.SignupService;

@RestController
@RequestMapping("app/")
public class SignUpController {

	@Autowired
	private SignupService signupservice;

	@PostMapping("/signin")
	public Customer getUserprofile(@RequestBody Userprofile up) {
		System.out.println("Sign in controller called");
		return signupservice.getUserprofile(up);
	}

	@PostMapping("/signup")
	public ResponseEntity<String> addUserProfile(@RequestBody Userprofile up) {
		return signupservice.addUserProfile(up);
	}

}