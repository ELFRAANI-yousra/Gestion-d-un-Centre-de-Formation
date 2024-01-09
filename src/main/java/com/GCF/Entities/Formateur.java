package com.GCF.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Formateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String motDePasse;
    private String nom;
    private String prenom;
    private List<String> MotsCles;
    private String remarques;

    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
     private List<FormationEntreprise> formationsEntreprise = new ArrayList<>();
    
    
    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    private List<FormationEntreprise> formationsIndinidu = new ArrayList<>();
}

