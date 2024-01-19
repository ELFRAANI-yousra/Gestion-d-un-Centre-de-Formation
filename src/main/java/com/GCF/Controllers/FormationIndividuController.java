package com.GCF.Controllers;

import java.time.LocalDate;
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

import com.GCF.Entities.FormationIndividu;
import com.GCF.Services.FormationIndividuServiceImp;
@RestController
public class FormationIndividuController {

	@Autowired
	private FormationIndividuServiceImp formationIndividuServ;
	
	 @PostMapping("/formationIndividu")
	 public FormationIndividu addFormationIndividu(@RequestBody FormationIndividu formationIndividu) {
		return formationIndividuServ.createFormationIndividu(formationIndividu);
	 }
	 

	 @PutMapping("/formationIndividu")
	 public FormationIndividu updateFormationIndividu( @RequestBody FormationIndividu formationIndividu) {
		 return formationIndividuServ.updateFormationIndividu(formationIndividu);
	 }
	 
	 @DeleteMapping("/formationIndividu/{id}")
	 public void deleteclient(@PathVariable Long id) {
		 formationIndividuServ.deleteFormationIndividu(id);
		 
	 }
	 @GetMapping("/formationIndividu")
	 public List<FormationIndividu> getFormationIndividus() {
	 	return formationIndividuServ.getAllFormationsIndividu();
	 }
	   @GetMapping("/formationIndividu/filter")
	    public List<FormationIndividu> getFilteredFormations(
	            @RequestParam(required = false) String date,
	            @RequestParam(required = false) String categorie,
	            @RequestParam(required = false) String ville) {
	        return formationIndividuServ.getFilteredFormations(date, categorie, ville);
	    }
}
