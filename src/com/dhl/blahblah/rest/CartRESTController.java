package com.dhl.blahblah.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhl.blahblah.model.Cart;
import com.dhl.blahblah.service.ICartService;

@RestController
@RequestMapping("/api")
public class CartRESTController {
	
	@Autowired
	ICartService cartService;
	
	@GetMapping("/cart/{id}")
	public ResponseEntity<Cart> getCart(@PathVariable int id) {
		Cart cart = cartService.get(id);
		
		if (cart == null) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@PostMapping("/cart/{id}")
	public ResponseEntity<Cart> save(@PathVariable int id, @RequestBody Cart cart) {
		cartService.delete(cart);
		Cart cartResult = cartService.insert(cart);
		
		if (cartResult == null) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Cart>(cartResult, HttpStatus.OK);
	}
	
	@PostMapping("/cart")
	public ResponseEntity<Cart> save(@RequestBody Cart cart) {
		Cart cartResult = cartService.insert(cart);
		
		if (cartResult == null) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Cart>(cartResult, HttpStatus.OK);
	}
	
	@PutMapping("/cart/{id}")
	public ResponseEntity<Cart> update(@PathVariable int id, @RequestBody Cart cart) {
		Cart cartResult = cartService.update(cart);
		
		if (cartResult == null) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Cart>(cartResult, HttpStatus.OK);
	}
}
