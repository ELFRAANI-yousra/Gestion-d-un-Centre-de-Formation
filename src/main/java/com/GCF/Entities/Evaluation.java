package com.GCF.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int notePedagogique;
    private int noteRythme;
    private int noteSupportCoursTP;
    private int noteMaitriseSujet;
    
    @ManyToOne
    @JoinColumn(name = "planification_id")
    @JsonBackReference
    private Planification planification;
    
    @OneToOne
    @JoinColumn(name = "individu_id")
    @JsonBackReference
    private Individu individu ;
   
}
