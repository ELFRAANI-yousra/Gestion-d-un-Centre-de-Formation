package com.GCF.Entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categorie;
    private String titre;
    private int nombreHeures;
    private double cout;
    private String objectifs;
    private String programmeDetaille;
    private String ville;
    
    @OneToMany(mappedBy="formation", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Individu> individu=new ArrayList<>();
    
    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL)
    @JsonManagedReference 
    private List<Planification> planification = new ArrayList<>();
    
    
  
}
