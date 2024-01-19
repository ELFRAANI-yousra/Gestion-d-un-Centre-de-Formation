package com.GCF.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GCF.Entities.FormationIndividu;

public interface IFormationIndividuRepo extends JpaRepository<FormationIndividu, Long>{

	List<FormationIndividu> findByCategorieAndVilleAndDates_Date(String date, String categorie, String ville);

    List<FormationIndividu> findByCategorieAndDates_Date(String date, String categorie);

    List<FormationIndividu> findByVilleAndDates_Date(String date, String ville);

    List<FormationIndividu> findByDates_Date(String date);

    List<FormationIndividu> findByCategorie(String categorie);

    List<FormationIndividu> findByVille(String ville);
}
