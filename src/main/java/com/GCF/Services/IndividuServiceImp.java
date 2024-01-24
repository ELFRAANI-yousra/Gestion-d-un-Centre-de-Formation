package com.GCF.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GCF.Entities.Individu;
import com.GCF.Repositories.IIndividuRepo;

@Service
public class IndividuServiceImp implements IndividuService{
	   @Autowired
	   private  IIndividuRepo individuRepository;

	    @Override
	    public List<Individu> getAllIndividus() {
	        return individuRepository.findAll();
	    }

	    @Override
	    public Individu getIndividuById(Long id) {
	        return  individuRepository.findById(id).get() ;
	    }

	    @Override
	    public Individu createIndividu(Individu individu) {
	        return individuRepository.save(individu);
	    }

	    @Override
	    public Individu updateIndividu(Individu individu) {
	            return individuRepository.save(individu);
	    }

	    @Override
	    public void deleteIndividu(Long id) {
	        individuRepository.deleteById(id);
	    }
	    @Override
	    public List<Individu> getIndividualsByFormationId(Long formationId) {
	        return individuRepository.findByFormationId(formationId);
	    }
	    @Override
	    public List<Individu> getIndividuListByIds(List<Long> individuIds) {
	        return individuRepository.findAllById(individuIds);
	    }
	}

