package com.GCF.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GCF.Entities.Formation;

public interface IFormationRepo extends JpaRepository<Formation, Long>{

	List<Formation> findByCategorieAndVille(String categorie, String ville);

    List<Formation> findByCategorie(String categorie);

    List<Formation> findByVille(String ville);
}
