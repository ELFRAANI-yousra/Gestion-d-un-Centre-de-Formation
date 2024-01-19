package com.GCF.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GCF.Entities.Evaluation;
import com.GCF.Services.EvaluationServiceImp;

@RestController
public class EvaluationController {
	@Autowired
	private EvaluationServiceImp evaluationServ;
	
	 @PostMapping("/evaluation")
	 public Evaluation addEvaluation(@RequestBody Evaluation evaluation) {
		return evaluationServ.createEvaluation(evaluation);
	 }
	 

	 @PutMapping("/evaluation")
	 public Evaluation updateEvaluation( @RequestBody Evaluation evaluation) {
		 return evaluationServ.updateEvaluation(evaluation);
	 }
	 
	 @DeleteMapping("/evaluation/{id}")
	 public void deleteclient(@PathVariable Long id) {
		 evaluationServ.deleteEvaluation(id);
		 
	 }
	 @GetMapping("/evaluation")
	 public List<Evaluation> getEvaluations() {
	 	return evaluationServ.getAllEvaluations();
	 }

}
