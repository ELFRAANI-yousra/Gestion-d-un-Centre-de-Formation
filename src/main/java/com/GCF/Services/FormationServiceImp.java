package com.GCF.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GCF.Entities.Formation;
import com.GCF.Repositories.IFormationRepo;

@Service
public class FormationServiceImp implements FormationService{
	@Autowired
	private  IFormationRepo formationIndividuRepository;

    
    @Override
    public List<Formation> getAllFormations() {
        return formationIndividuRepository.findAll();
    }

    @Override
    public Formation getFormationById(Long id) {
      return formationIndividuRepository.findById(id).get();
    }

    @Override
    public Formation createFormation(Formation formationIndividu) {
        return formationIndividuRepository.save(formationIndividu);
    }

    @Override
    public Formation updateFormation( Formation updatedFormation) {
     
            return formationIndividuRepository.save(updatedFormation);
        
    }

    @Override
    public void deleteFormation(Long id) {
        formationIndividuRepository.deleteById(id);
    }
    @Override
    public List<Formation> getFilteredFormations(String date, String categorie, String ville) {
    	 if (categorie != null) {
             return formationIndividuRepository.findByCategorie(categorie);
         } else if (ville != null) {
             return formationIndividuRepository.findByVille(ville);
         } else {
             return formationIndividuRepository.findAll();
         }
    }
}
