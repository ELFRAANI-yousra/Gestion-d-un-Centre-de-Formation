package com.GCF.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GCF.Entities.Individu;
import com.GCF.Entities.Planification;
import com.GCF.Services.PlanificationServiceImp;
@RestController
public class PlanificationController {

	@Autowired
	private PlanificationServiceImp planificationServ;
	
	 @PostMapping("/planification")
	 public Planification addPlanification(@RequestBody Planification planification) {
		return planificationServ.createPlanification(planification);
	 }
	 
	 @PutMapping("/planification/individuals/{idPlanification}")
	 public Planification createPlanificationAndAssignIndividuals(@PathVariable Long idPlanification, @RequestBody List<Long> individusId) {
	     Planification p = planificationServ.getPlanificationById(idPlanification);
	     return planificationServ.savePlanificationWithIndividu(p, individusId);
	 }

	 
	 @PutMapping("/planification")
	 public Planification updatePlanification( @RequestBody Planification planification) {
		 return planificationServ.updatePlanification(planification);
	 }
	 
	 @DeleteMapping("/planification/{id}")
	 public void planificationById(@PathVariable Long id) {
		 planificationServ.deletePlanification(id);
		 
	 }
	 @GetMapping("/planification")
	 public List<Planification> getPlanifications() {
	 	return planificationServ.getAllPlanification();
	 }
}
