package com.dhl.blahblah.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhl.blahblah.model.Account;
import com.dhl.blahblah.service.IAccountService;

@RestController
@RequestMapping("/api/account")
public class AccountRESTController {
	
	@Autowired
	IAccountService accountService;
	
	@RequestMapping("/login")
	public ResponseEntity<Account> login(@RequestParam("username") String username, @RequestParam("password") String password){
		Account account = accountService.login(username,password);
		if (account == null) {
			return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@RequestMapping("/change-password")
	public ResponseEntity<Account> changePassword(@RequestParam("username") String username, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword){
		int result = accountService.changePassword(username, oldPassword, newPassword);
		if (result <= 0) {
			return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
	
	@RequestMapping("/register")
	public ResponseEntity<Account> register(@RequestParam("username") String username, @RequestParam("password") String password){
		Account accountResult = accountService.register(username, password);
		if (accountResult == null) {
			return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
}
