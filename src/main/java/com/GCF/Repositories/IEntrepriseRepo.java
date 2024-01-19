package com.GCF.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GCF.Entities.Entreprise;


public interface IEntrepriseRepo extends JpaRepository<Entreprise, Long> {

}
