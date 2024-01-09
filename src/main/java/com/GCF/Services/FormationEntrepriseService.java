package com.GCF.Services;

import java.util.List;

import com.GCF.Entities.FormationEntreprise;

public interface FormationEntrepriseService {
	    List<FormationEntreprise> getAllFormations();
	    FormationEntreprise getFormationById(Long id);
	    FormationEntreprise createFormation(FormationEntreprise formationEntreprise);
	    FormationEntreprise updateFormation(Long id, FormationEntreprise updatedFormation);
	    void deleteFormation(Long id);
	}

