package com.dhl.blahblah.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhl.blahblah.model.User;
import com.dhl.blahblah.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserRESTController {

	@Autowired
	IUserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> update(@RequestBody User user) {
		User userResult = userService.insert(user);
		
		return new ResponseEntity<User>(userResult, HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user) {
		User userResult = userService.update(user);
		
		if (userResult == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<User>(userResult, HttpStatus.OK);
	}
}
