package com.dhl.blahblah.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhl.blahblah.service.ITestService;
import com.dhl.blahblah.service.IUserService;

@RestController
@RequestMapping("/api")
public class TestRESTController {
	@Autowired
	ITestService testService;
	
	@Autowired
	IUserService userService;
	
	@RequestMapping("/test")
	public void test(){
		testService.test();
	}
}
