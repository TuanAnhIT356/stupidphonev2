package com.dhl.blahblah.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhl.blahblah.model.Product;
import com.dhl.blahblah.service.ICartService;
import com.dhl.blahblah.service.IProductService;

@RestController
@RequestMapping("/api")
public class ProductRESTController {
	
	@Autowired
	IProductService productService;
	
	@Autowired
	ICartService cartService;
	
	@GetMapping("/products")
	public List<Product>  getProducts(){
		return productService.getAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product>  getProduct(@PathVariable("id") int id){
		Product theProduct = productService.getById(id);
		if (theProduct == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Product>(theProduct, HttpStatus.OK);
	}
	
	@GetMapping("/products/top")
	public List<Product>  getTopProduct(@RequestParam("type") String type, @RequestParam("num") int num){
		return productService.getTopProducts(type, num);
	}	
	
	@GetMapping("/products/brand")
	public List<Product>  getTopProduct(@RequestParam("brandName") String brandName){
		return productService.getProductByBrand(brandName);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product>  updateProduct(@PathVariable("id") int id, @RequestBody Product product){
		Product productResult = productService.update(product);
		if (productResult == null) {
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Product>(productResult, HttpStatus.OK);
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product>  insertProduct(@RequestBody Product product){
		Product theProduct = productService.insert(product);
		if (theProduct == null) {
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Product>(theProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product>  deleteProduct(@PathVariable("id") int id){
		boolean inCart = cartService.findByProduct(id);
		if (inCart) {
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Product theProduct = productService.getById(id);
		if (theProduct == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		
		productService.delete(theProduct);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
}
