package com.GCF.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GCF.Entities.FormationEntreprise;
import com.GCF.Repositories.IFormationEntrepriseRepo;

@Service
public class FormationEntrepriseServiceImp implements FormationEntrepriseService{
	@Autowired
	private  IFormationEntrepriseRepo formationEntrepriseRepository;

    @Override
    public List<FormationEntreprise> getAllFormationsEntreprise() {
        return formationEntrepriseRepository.findAll();
    }

    @Override
    public FormationEntreprise getFormationEntrepriseById(Long id) {
      return formationEntrepriseRepository.findById(id).get();
    }

    @Override
    public FormationEntreprise createFormationEntreprise(FormationEntreprise formationEntreprise) {
        return formationEntrepriseRepository.save(formationEntreprise);
    }

    @Override
    public FormationEntreprise updateFormationEntreprise( FormationEntreprise updatedFormation) {
     
            return formationEntrepriseRepository.save(updatedFormation);
        
    }

    @Override
    public void deleteFormationEntreprise(Long id) {
        formationEntrepriseRepository.deleteById(id);
    }
}
