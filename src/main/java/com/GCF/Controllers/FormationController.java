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
import com.GCF.Entities.Formation;
import com.GCF.Services.FormationServiceImp;

@RestController
public class FormationController {
	
	@Autowired
	private FormationServiceImp formationServ;
	
	 @PostMapping("/formation")
	 public Formation addFormation(@RequestBody Formation formation) {
		return formationServ.createFormation(formation);
	 }
	 

	 @PutMapping("/formation")
	 public Formation updateFormation( @RequestBody Formation formation) {
		 return formationServ.updateFormation(formation);
	 }
	 
	 @DeleteMapping("/formation/{id}")
	 public void deleteclient(@PathVariable Long id) {
		 formationServ.deleteFormation(id);
		 
	 }
	 @GetMapping("/formation")
	 public List<Formation> getFormations() {
	 	return formationServ.getAllFormations();
	 }
	 
	 @GetMapping("/formation/filter")
	 public List<Formation> getFilteredFormations(
	        @RequestParam(required = false) String date,
	        @RequestParam(required = false) String categorie,
	        @RequestParam(required = false) String ville) {
	    return formationServ.getFilteredFormations(date, categorie, ville);
	}
}
