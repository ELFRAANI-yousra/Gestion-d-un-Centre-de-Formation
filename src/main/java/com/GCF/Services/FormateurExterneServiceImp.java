package com.GCF.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GCF.Entities.FormateurExterne;
import com.GCF.Repositories.IFormateurExterneRepo;

@Service
public class FormateurExterneServiceImp implements FormateurExterneService{
	   @Autowired
	   private  IFormateurExterneRepo formateurExterneRepository;

	    @Override
	    public List<FormateurExterne> getAllFormateurExternes() {
	        return formateurExterneRepository.findAll();
	    }

	    @Override
	    public FormateurExterne getFormateurExterneById(Long id) {
	        return  formateurExterneRepository.findById(id).get() ;
	    }

	    @Override
	    public FormateurExterne createFormateurExterne(FormateurExterne formateurExterne) {
	        return formateurExterneRepository.save(formateurExterne);
	    }

	    @Override
	    public FormateurExterne updateFormateurExterne(FormateurExterne formateurExterne) {
	            return formateurExterneRepository.save(formateurExterne);
	    }

	    @Override
	    public void deleteFormateurExterne(Long id) {
	        formateurExterneRepository.deleteById(id);
	    }
	}

