package com.GCF.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GCF.Entities.Admin;
import com.GCF.Entities.Formateur;
import com.GCF.Entities.Role;
import com.GCF.Services.AdminServiceImp;
import com.GCF.Services.FormateurServiceImp;
@CrossOrigin(origins="*")
@RestController
@CrossOrigin(origins="*")
public class FormateurController {
	@Autowired
	private FormateurServiceImp formateurServ;
	@Autowired
	private AdminServiceImp adminServ;
	
	 @PostMapping("/formateur")
	 public Formateur addFormateur(@RequestBody Formateur formateur) {
		Formateur a= formateurServ.createFormateur(formateur);
		Admin b=new Admin();
		b.setId(a.getId());
		b.setRole(Role.FORMATEUR);
		b.setNomUtilisateur(a.getEmail());
		b.setMotDePasse(a.getMotDePasse());
		adminServ.creatAdmin(b);
		return a;
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

