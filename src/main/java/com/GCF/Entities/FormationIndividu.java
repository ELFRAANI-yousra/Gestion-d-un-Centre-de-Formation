package com.GCF.Entities;

import java.util.ArrayList;
import java.util.List;

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
public class FormationIndividu {
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
    
    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;
   
    @OneToMany(mappedBy = "formationIndividu", cascade = CascadeType.ALL)
    private List<Individu> individus = new ArrayList<>(); 
    
    @OneToMany(mappedBy = "formationIndividu", cascade = CascadeType.ALL)
    private List<Date> dates = new ArrayList<>();
    
    @OneToOne(mappedBy = "formationIndividu", cascade = CascadeType.ALL)
    private Evaluation evaluation;
}
