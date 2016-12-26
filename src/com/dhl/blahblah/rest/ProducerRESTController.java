package com.dhl.blahblah.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhl.blahblah.model.Producer;
import com.dhl.blahblah.service.IProducerService;

@RestController
@RequestMapping("/api")
public class ProducerRESTController {
	
	@Autowired
	IProducerService producerService;
	
	@GetMapping("/producers")
	public List<Producer>  getProducts(){
		return producerService.getAll();
	}
}
