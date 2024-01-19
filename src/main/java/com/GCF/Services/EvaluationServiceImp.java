package com.GCF.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GCF.Entities.Evaluation;
import com.GCF.Repositories.IEvaluationRepo;

@Service
public class EvaluationServiceImp implements EvaluationService{
	   @Autowired
	   private  IEvaluationRepo evaluationRepository;

	    @Override
	    public List<Evaluation> getAllEvaluations() {
	        return evaluationRepository.findAll();
	    }

	    @Override
	    public Evaluation getEvaluationById(Long id) {
	        return  evaluationRepository.findById(id).get() ;
	    }

	    @Override
	    public Evaluation createEvaluation(Evaluation evaluation) {
	        return evaluationRepository.save(evaluation);
	    }

	    @Override
	    public Evaluation updateEvaluation(Evaluation evaluation) {
	            return evaluationRepository.save(evaluation);
	    }

	    @Override
	    public void deleteEvaluation(Long id) {
	        evaluationRepository.deleteById(id);
	    }
	}

