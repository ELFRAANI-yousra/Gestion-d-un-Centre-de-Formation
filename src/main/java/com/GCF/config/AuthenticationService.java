package com.GCF.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.GCF.Entities.Admin;
import com.GCF.Repositories.IAdminRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService 
{
	private final IAdminRepo repo;
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
	public AuthenticationResponse register(Admin request) 
	{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNomUtilisateur(), request.getMotDePasse()));
		var user =repo.findByNomUtilisateur(request.getNomUtilisateur())
				.orElseThrow();
		var jwtToken=jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).Role(user.getRole()).build();

	}
	
}
