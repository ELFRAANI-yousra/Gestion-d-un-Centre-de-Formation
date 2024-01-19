package com.GCF.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GCF.Entities.Assistant;
import com.GCF.Repositories.IAssistantRepo;
@Service
public class AssistantServiceImp implements AssistantService{
	   @Autowired
	   private  IAssistantRepo assistantRepository;

	    @Override
	    public List<Assistant> getAllAssistants() {
	        return assistantRepository.findAll();
	    }

	    @Override
	    public Assistant getAssistantById(Long id) {
	        return  assistantRepository.findById(id).get() ;
	    }

	    @Override
	    public Assistant createAssistant(Assistant assistant) {
	        return assistantRepository.save(assistant);
	    }

	    @Override
	    public Assistant updateAssistant(Assistant assistant) {
	            return assistantRepository.save(assistant);
	    }

	    @Override
	    public void deleteAssistant(Long id) {
	        assistantRepository.deleteById(id);
	    }
	}

