package com.GCF.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GCF.Entities.Admin;
import com.GCF.config.AuthenticationResponse;
import com.GCF.config.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class AdminController 
{
	
	private final AuthenticationService service;
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> register(
			@RequestBody Admin request
			)
	{
		return ResponseEntity.ok(service.register(request));
	}
	
	
}
