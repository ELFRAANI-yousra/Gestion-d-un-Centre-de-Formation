package com.GCF.Services;

import java.util.List;

import com.GCF.Entities.Formation;

public interface FormationService {
	  List<Formation> getAllFormations();
	    Formation getFormationById(Long id);
	    Formation createFormation(Formation formation);
	    Formation updateFormation( Formation updatedFormation);
	    void deleteFormation(Long id);
	    List<Formation> getFilteredFormations(String date, String categorie, String ville);
	    
}
