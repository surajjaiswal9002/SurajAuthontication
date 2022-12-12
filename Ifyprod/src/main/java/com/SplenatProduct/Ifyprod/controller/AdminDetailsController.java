package com.SplenatProduct.Ifyprod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SplenatProduct.Ifyprod.config.JwtUtil;
import com.SplenatProduct.Ifyprod.entity.AdminDetails;
import com.SplenatProduct.Ifyprod.entity.JwtResponse;
import com.SplenatProduct.Ifyprod.services.CustomUserDetailsService;

@RestController
public class AdminDetailsController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value="/token", method=RequestMethod.POST)
	//@PostMapping("/to")
	public ResponseEntity<?> generateToken(@RequestBody AdminDetails adminDetails) throws Exception
	{
		System.out.println(adminDetails);
		try
		{
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(adminDetails.getUserName(), adminDetails.getPassword())); 
			
		} catch (UsernameNotFoundException e)
		{
			e.printStackTrace();
			 throw new Exception("bad crediential");
		}
	
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(adminDetails.getUserName());
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT" +token);
		
		
		//{"token": "value"}
		return ResponseEntity.ok(new JwtResponse(token));
	}

}
