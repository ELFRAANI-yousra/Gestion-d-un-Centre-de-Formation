package com.GCF.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GCF.Entities.FormationIndividu;
import com.GCF.Repositories.IFormationIndividuRepo;

@Service
public class FormationIndividuServiceImp implements FormationIndividuService{
	@Autowired
	private  IFormationIndividuRepo formationIndividuRepository;

    
    @Override
    public List<FormationIndividu> getAllFormationsIndividu() {
        return formationIndividuRepository.findAll();
    }

    @Override
    public FormationIndividu getFormationIndividuById(Long id) {
      return formationIndividuRepository.findById(id).get();
    }

    @Override
    public FormationIndividu createFormationIndividu(FormationIndividu formationIndividu) {
        return formationIndividuRepository.save(formationIndividu);
    }

    @Override
    public FormationIndividu updateFormationIndividu( FormationIndividu updatedFormation) {
     
            return formationIndividuRepository.save(updatedFormation);
        
    }

    @Override
    public void deleteFormationIndividu(Long id) {
        formationIndividuRepository.deleteById(id);
    }
    @Override
    public List<FormationIndividu> getFilteredFormations(String date, String categorie, String ville) {
    	 if (date != null && categorie != null && ville != null) {
             return formationIndividuRepository.findByCategorieAndVilleAndDates_Date(date, categorie, ville);
         } else if (date != null && categorie != null) {
             return formationIndividuRepository.findByCategorieAndDates_Date(date, categorie);
         } else if (date != null && ville != null) {
             return formationIndividuRepository.findByVilleAndDates_Date(date, ville);
         } else if (date != null) {
             return formationIndividuRepository.findByDates_Date(date);
         } else if (categorie != null) {
             return formationIndividuRepository.findByCategorie(categorie);
         } else if (ville != null) {
             return formationIndividuRepository.findByVille(ville);
         } else {
             return formationIndividuRepository.findAll();
         }
    }
}
