package com.GCF.Entities;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Assistant implements UserDetails{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nom;
	    private String prenom;
	    private String nomUtilisateur;
	    private String motDePasse;
	    private String adresse;
	    private String telephone;
	    @Enumerated(EnumType.STRING)
	    private Role role;
	    
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return List.of(new SimpleGrantedAuthority(role.name()));
		}
		
		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return motDePasse;
		}
		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return nomUtilisateur;
		}
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
}
