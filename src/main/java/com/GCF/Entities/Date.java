package com.GCF.Entities;


import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Date {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private LocalDate date;

@ManyToOne
@JoinColumn(name = "planification_id")
private Planification planification;

}
