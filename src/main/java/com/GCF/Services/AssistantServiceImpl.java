package com.GCF.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.GCF.Entities.Assistant;
import com.GCF.Repositories.IAssistantRepo;

public class AssistantServiceImpl implements AssistantService{

	   private final IAssistantRepo assistantRepository;

	    @Autowired
	    public AssistantServiceImpl(IAssistantRepo assistantRepository) {
	        this.assistantRepository = assistantRepository;
	    }

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
	    public Assistant updateAssistant(Long id, Assistant assistant) {
	        if (assistantRepository.existsById(id)) {
	            assistant.setId(id);
	            return assistantRepository.save(assistant);
	        }
	        return null;
	    }

	    @Override
	    public void deleteAssistant(Long id) {
	        assistantRepository.deleteById(id);
	    }
	}

