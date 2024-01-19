package com.GCF.Services;

import java.util.List;

import com.GCF.Entities.Evaluation;

public interface EvaluationService {
	  List<Evaluation> getAllEvaluations();
	    Evaluation getEvaluationById(Long id);
	    Evaluation createEvaluation(Evaluation evaluation);
	    Evaluation updateEvaluation(Evaluation evaluation);
	    void deleteEvaluation(Long id);
}
