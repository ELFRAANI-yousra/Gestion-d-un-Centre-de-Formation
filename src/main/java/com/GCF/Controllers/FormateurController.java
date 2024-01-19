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

import com.GCF.Entities.Formateur;
import com.GCF.Services.FormateurServiceImp;

@RestController
public class FormateurController {
	@Autowired
	private FormateurServiceImp formateurServ;
	
	 @PostMapping("/formateur")
	 public Formateur addFormateur(@RequestBody Formateur formateur) {
		return formateurServ.createFormateur(formateur);
	 }
	 

	 @PutMapping("/formateur")
	 public Formateur updateFormateur( @RequestBody Formateur formateur) {
		 return formateurServ.updateFormateur(formateur);
	 }
	 
	 @DeleteMapping("/formateur/{id}")
	 public void deleteclient(@PathVariable Long id) {
		 formateurServ.deleteFormateur(id);
		 
	 }
	 @GetMapping("/formateur")
	 public List<Formateur> getFormateurs() {
	 	return formateurServ.getAllFormateurs();
	 }

}

