package com.GCF.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.GCF.Entities.Formateur;
import com.GCF.Repositories.IFormateurRepo;

@Service
public class FormateurServiceImp implements FormateurService{
	   @Autowired
	   private  IFormateurRepo formateurRepository;

	    @Override
	    public List<Formateur> getAllFormateurs() {
	        return formateurRepository.findAll();
	    }

	    @Override
	    public Formateur getFormateurById(Long id) {
	        return  formateurRepository.findById(id).get() ;
	    }

	    @Override
	    public Formateur createFormateur(Formateur formateur) {
	    	BCryptPasswordEncoder p=new BCryptPasswordEncoder();
	    	formateur.setMotDePasse(p.encode(formateur.getMotDePasse()));
	        return formateurRepository.save(formateur);
	    }

	    @Override
	    public Formateur updateFormateur(Formateur formateur) {
	            return formateurRepository.save(formateur);
	    }

	    @Override
	    public void deleteFormateur(Long id) {
	        formateurRepository.deleteById(id);
	    }
	}
