package com.GCF.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GCF.Entities.Planification;



public interface IPlanificationRepo extends JpaRepository<Planification, Long>{
	List<Planification> findByFormateurId(Long formatuer_id);

}
