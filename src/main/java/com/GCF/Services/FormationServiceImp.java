package com.GCF.Services;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GCF.Entities.Formation;
import com.GCF.Repositories.IFormationRepo;

@Service
public class FormationServiceImp implements FormationService{
	@Autowired
	private  IFormationRepo formationRepository;

    
    @Override
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    @Override
    public Formation getFormationById(Long id) {
      return formationRepository.findById(id).get();
    }

    @Override
    public Formation createFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public Formation updateFormation( Formation updatedFormation) {
     
            return formationRepository.save(updatedFormation);
        
    }

    @Override
    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }
    @Override
    public List<Formation> getFilteredFormations(
            Double minCout, Double maxCout, Integer minNombreHeures, Integer maxNombreHeures, List<String> categories) {
        return formationRepository.findByCoutAndNombreHeuresAndCategories(minCout, maxCout, minNombreHeures, maxNombreHeures, categories);
    }
    public List<String> getAllCategories() {
        List<Formation> allFormations = formationRepository.findAll();
        Set<String> uniqueCategories = allFormations.stream()
                .map(Formation::getCategorie)
                .collect(Collectors.toSet());

        return List.copyOf(uniqueCategories);
    }

}
