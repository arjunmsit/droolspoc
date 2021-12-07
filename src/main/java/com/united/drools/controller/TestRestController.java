package com.united.drools.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
	
	@RequestMapping(value = "/getname")
	public String getProducts() { 
		
		return "Bhanumurthi Tellapati";
	}

}
