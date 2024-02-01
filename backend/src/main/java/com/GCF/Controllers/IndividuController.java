package com.GCF.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GCF.Entities.Individu;
import com.GCF.Services.IndividuServiceImp;
@CrossOrigin(origins="*")
@RestController
public class IndividuController {
	@Autowired
	private IndividuServiceImp individuServ;
	
	 @PostMapping("/rejoindre")
	 public Individu addIndividu(@RequestBody Individu individu) {
		return individuServ.createIndividu(individu);
	 }
	 
	 @PostMapping("/individu")
	 public Individu addIndividuAdmin(@RequestBody Individu individu) {
		return individuServ.createIndividu(individu);
	 }
	 
	 @PostMapping("/individu/planification")
	 public Individu addIndividuPlanification(@RequestBody Individu individu) {
		return individuServ.createIndividuPlanification(individu);
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
	 @GetMapping("/individu/planification/{id}")
	 public List<Individu> getplanificationIndividus(@PathVariable Long id) {
	 	return individuServ.getIndividualsByPlanificatinoId(id);
	 }
	 
	 @GetMapping("/evaluer/{code}")
	 public Individu getformationIndividus(@PathVariable String code) {
	 	return individuServ.getIndividuByCodeAndEvaluer(code);
	 }
	
	 @PostMapping("/rejoindre/evaluer")
	 public Individu adIndividu(@RequestBody Long individuId) {
		 Individu i = individuServ.getIndividuById(individuId);
		 i.setEvaluer(true);
		return individuServ.updateIndividu(i);
	 }
}
