package com.GCF.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GCF.Entities.Planification;



public interface IPlanificationRepo extends JpaRepository<Planification, Long>{

}
