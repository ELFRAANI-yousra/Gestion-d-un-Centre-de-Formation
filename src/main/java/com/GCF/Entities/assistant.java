package com.GCF.Entities;


import jakarta.persistence.Entity;
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
public class Assistant {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String nomUtilisateur;
	    private String motDePasse;
	    private String ville;
}
