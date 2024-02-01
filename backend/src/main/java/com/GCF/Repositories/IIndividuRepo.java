package com.GCF.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GCF.Entities.Individu;

public interface IIndividuRepo extends JpaRepository<Individu, Long>{
	List<Individu> findByFormationId(Long formationId);
	List<Individu> findByPlanificationId(Long formationId);
	
	Individu findByCodeAndEvaluer (String code, Boolean evaluer);
}
