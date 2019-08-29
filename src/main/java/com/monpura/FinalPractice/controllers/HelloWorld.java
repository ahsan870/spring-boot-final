package com.monpura.FinalPractice.controllers;

import java.time.LocalDateTime;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@RequestMapping("/")
	public String Hello() {
		
	return "Hello world!! this is local time ---" + LocalDateTime.now();
	}
	

}
