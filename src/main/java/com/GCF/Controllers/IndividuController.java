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

import com.GCF.Entities.Individu;
import com.GCF.Services.IndividuServiceImp;

@RestController
public class IndividuController {
	@Autowired
	private IndividuServiceImp individuServ;
	
	 @PostMapping("/individu")
	 public Individu addIndividu(@RequestBody Individu individu) {
		return individuServ.createIndividu(individu);
	 }
	 

	 @PutMapping("/individu")
	 public Individu updateIndividu( @RequestBody Individu individu) {
		 return individuServ.updateIndividu(individu);
	 }
	 
	 @DeleteMapping("/individu/{id}")
	 public void deleteclient(@PathVariable Long id) {
		 individuServ.deleteIndividu(id);
		 
	 }
	 @GetMapping("/individu")
	 public List<Individu> getIndividus() {
	 	return individuServ.getAllIndividus();
	 }
	 @GetMapping("/individu/formation/{id}")
	 public List<Individu> getformationIndividus(@PathVariable Long id) {
	 	return individuServ.getIndividualsByFormationId(id);
	 }

}
