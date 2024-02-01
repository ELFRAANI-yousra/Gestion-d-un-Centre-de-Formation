package com.GCF.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GCF.Entities.Entreprise;
import com.GCF.Repositories.IEntrepriseRepo;

@Service
public class EntrepriseServiceImp implements EntrepriseService{
	@Autowired
	private  IEntrepriseRepo entrepriseRepository;

    
    @Override
    public List<Entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    @Override
    public Entreprise getEntrepriseById(Long id) {
      return entrepriseRepository.findById(id).get();
    }

    @Override
    public Entreprise createEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public Entreprise updateEntreprise( Entreprise updatedFormation) {
     
            return entrepriseRepository.save(updatedFormation);
        
    }

    @Override
    public void deleteEntreprise(Long id) {
        entrepriseRepository.deleteById(id);
    }
}
