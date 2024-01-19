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
import com.GCF.Entities.Entreprise;
import com.GCF.Services.EntrepriseServiceImp;

@RestController
public class EntrepriseController {
	@Autowired
	private EntrepriseServiceImp entrepriseServ;
	
	 @PostMapping("/entreprise")
	 public Entreprise addEntreprise(@RequestBody Entreprise entreprise) {
		return entrepriseServ.createEntreprise(entreprise);
	 }
	 

	 @PutMapping("/entreprise")
	 public Entreprise updateEntreprise( @RequestBody Entreprise entreprise) {
		 return entrepriseServ.updateEntreprise(entreprise);
	 }
	 
	 @DeleteMapping("/entreprise/{id}")
	 public void deleteclient(@PathVariable Long id) {
		 entrepriseServ.deleteEntreprise(id);
		 
	 }
	 @GetMapping("/entreprise")
	 public List<Entreprise> getEntreprises() {
	 	return entrepriseServ.getAllEntreprises();
	 }
}
