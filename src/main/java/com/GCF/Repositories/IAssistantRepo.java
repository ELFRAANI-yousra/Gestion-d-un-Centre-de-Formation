package com.GCF.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GCF.Entities.Assistant;

public interface IAssistantRepo  extends JpaRepository<Assistant, Long>{
	
	Optional<Assistant> findByNomUtilisateur(String nomUtulisateur);


}
