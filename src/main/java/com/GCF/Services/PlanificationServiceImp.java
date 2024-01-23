package com.GCF.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GCF.Entities.Planification;
import com.GCF.Repositories.IPlanificationRepo;

@Service
public class PlanificationServiceImp implements PlanificationService{
	@Autowired
	private  IPlanificationRepo formationEntrepriseRepository;

    @Override
    public List<Planification> getAllPlanification() {
        return formationEntrepriseRepository.findAll();
    }

    @Override
    public Planification getPlanificationById(Long id) {
      return formationEntrepriseRepository.findById(id).get();
    }

    @Override
    public Planification createPlanification(Planification formationEntreprise) {
        return formationEntrepriseRepository.save(formationEntreprise);
    }

    @Override
    public Planification updatePlanification( Planification updatedFormation) {
     
            return formationEntrepriseRepository.save(updatedFormation);
        
    }

    @Override
    public void deletePlanification(Long id) {
        formationEntrepriseRepository.deleteById(id);
    }
}
