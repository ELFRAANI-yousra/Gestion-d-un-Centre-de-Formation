package com.GCF.Services;

import java.util.List;

import com.GCF.Entities.FormationEntreprise;

public interface FormationEntrepriseService {
	    List<FormationEntreprise> getAllFormationsEntreprise();
	    FormationEntreprise getFormationEntrepriseById(Long id);
	    FormationEntreprise createFormationEntreprise(FormationEntreprise formationEntreprise);
	    FormationEntreprise updateFormationEntreprise( FormationEntreprise updatedFormation);
	    void deleteFormationEntreprise(Long id);
	}

