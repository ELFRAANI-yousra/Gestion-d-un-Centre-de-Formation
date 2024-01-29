package com.GCF.Entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Planification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ville;
    @ManyToOne
    @JoinColumn(name="formation_id")
    private Formation formation;
    
    @ManyToOne
    @JoinColumn(name = "formateur_id")   
    private Formateur formateur;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;
    
    @OneToMany(mappedBy="planification", cascade = CascadeType.ALL)
    @JsonIgnore   
    private List<Individu> individu=new ArrayList<>();
    
    @OneToMany(mappedBy = "planification", cascade = CascadeType.ALL)
    @JsonIgnore  
    private List<Date> dates = new ArrayList<>();
    
    @OneToMany(mappedBy = "planification", cascade = CascadeType.ALL)
    @JsonIgnore  
    private List<Evaluation> evaluation;
    
    
}

