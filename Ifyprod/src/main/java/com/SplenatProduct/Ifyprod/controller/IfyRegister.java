package com.SplenatProduct.Ifyprod.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IfyRegister {
	
	
	@GetMapping("/welcomepage")
	public String register()
	{
		String message = "This is private page ";
		return message;
	}

}
