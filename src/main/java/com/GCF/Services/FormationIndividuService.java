package com.GCF.Services;

import java.time.LocalDate;
import java.util.List;

import com.GCF.Entities.FormationIndividu;

public interface FormationIndividuService {
	  List<FormationIndividu> getAllFormationsIndividu();
	    FormationIndividu getFormationIndividuById(Long id);
	    FormationIndividu createFormationIndividu(FormationIndividu formationIndividu);
	    FormationIndividu updateFormationIndividu( FormationIndividu updatedFormationIndividu);
	    void deleteFormationIndividu(Long id);
	    List<FormationIndividu> getFilteredFormations(String date, String categorie, String ville);
	    
}
