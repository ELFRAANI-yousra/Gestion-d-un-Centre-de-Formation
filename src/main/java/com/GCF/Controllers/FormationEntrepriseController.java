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
import com.GCF.Entities.FormationEntreprise;
import com.GCF.Services.FormationEntrepriseServiceImp;

@RestController
public class FormationEntrepriseController {
	
	@Autowired
	private FormationEntrepriseServiceImp formationEntrepriseServ;
	
	 @PostMapping("/formationEntreprise")
	 public FormationEntreprise addFormationEntreprise(@RequestBody FormationEntreprise formationEntreprise) {
		return formationEntrepriseServ.createFormationEntreprise(formationEntreprise);
	 }
	 

	 @PutMapping("/formationEntreprise")
	 public FormationEntreprise updateFormationEntreprise( @RequestBody FormationEntreprise formationEntreprise) {
		 return formationEntrepriseServ.updateFormationEntreprise(formationEntreprise);
	 }
	 
	 @DeleteMapping("/formationEntreprise/{id}")
	 public void deleteclient(@PathVariable Long id) {
		 formationEntrepriseServ.deleteFormationEntreprise(id);
		 
	 }
	 @GetMapping("/formationEntreprise")
	 public List<FormationEntreprise> getFormationEntreprises() {
	 	return formationEntrepriseServ.getAllFormationsEntreprise();
	 }
}
