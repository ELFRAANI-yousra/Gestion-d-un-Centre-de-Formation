package com.GCF.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GCF.Entities.Formation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface IFormationRepo extends JpaRepository<Formation, Long>{

	
	@Query("SELECT f FROM Formation f WHERE "
            + "(:minCout IS NULL OR f.cout >= :minCout) AND "
            + "(:maxCout IS NULL OR f.cout <= :maxCout) AND "
            + "(:minNombreHeures IS NULL OR f.nombreHeures >= :minNombreHeures) AND "
            + "(:maxNombreHeures IS NULL OR f.nombreHeures <= :maxNombreHeures) AND "
            + "(:categories IS NULL OR f.categorie IN :categories)")
    List<Formation> findByCoutAndNombreHeuresAndCategories(
            @Param("minCout") Double minCout,
            @Param("maxCout") Double maxCout,
            @Param("minNombreHeures") Integer minNombreHeures,
            @Param("maxNombreHeures") Integer maxNombreHeures,
            @Param("categories") List<String> categories
    );
	
}
