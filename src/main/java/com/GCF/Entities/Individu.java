package com.GCF.Entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Individu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String ville;
    private String email;
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "planification_id")
    
    private Planification planification;
    
    @ManyToOne
    @JoinColumn(name = "formation_id")
    
    private Formation formation;
    
    @OneToOne(mappedBy = "individu", cascade = CascadeType.ALL)
    @JsonIgnore 
    private Evaluation evaluation;
   
}

