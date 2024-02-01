package com.GCF.Services;

import java.util.List;

import com.GCF.Entities.Entreprise;

public interface EntrepriseService {
	  List<Entreprise> getAllEntreprises();
	    Entreprise getEntrepriseById(Long id);
	    Entreprise createEntreprise(Entreprise entreprise);
	    Entreprise updateEntreprise( Entreprise updatedEntreprise);
	    void deleteEntreprise(Long id);
}
