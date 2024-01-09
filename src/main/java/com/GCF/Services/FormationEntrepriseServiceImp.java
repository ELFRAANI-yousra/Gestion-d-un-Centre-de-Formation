package com.GCF.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.GCF.Entities.FormationEntreprise;
import com.GCF.Repositories.IFormationEntrepriseRepo;

public class FormationEntrepriseServiceImp implements FormationEntrepriseService{
	private final IFormationEntrepriseRepo formationEntrepriseRepository;

    @Autowired
    public FormationEntrepriseServiceImp(IFormationEntrepriseRepo formationEntrepriseRepository) {
        this.formationEntrepriseRepository = formationEntrepriseRepository;
    }

    @Override
    public List<FormationEntreprise> getAllFormations() {
        return formationEntrepriseRepository.findAll();
    }

    @Override
    public FormationEntreprise getFormationById(Long id) {
      return formationEntrepriseRepository.findById(id).get();
    }

    @Override
    public FormationEntreprise createFormation(FormationEntreprise formationEntreprise) {
        return formationEntrepriseRepository.save(formationEntreprise);
    }

    @Override
    public FormationEntreprise updateFormation(Long id, FormationEntreprise updatedFormation) {
        if (formationEntrepriseRepository.existsById(id)) {
            updatedFormation.setId(id);
            return formationEntrepriseRepository.save(updatedFormation);
        }
        return null;
    }

    @Override
    public void deleteFormation(Long id) {
        formationEntrepriseRepository.deleteById(id);
    }
}
