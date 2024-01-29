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

import com.GCF.Entities.FormateurExterne;
import com.GCF.Services.FormateurExterneServiceImp;
@CrossOrigin(origins="*")
@RestController
public class FormateurExterneController {
	@Autowired
	private FormateurExterneServiceImp formateurExterneServ;
	
	 @PostMapping("/postuler")
	 public FormateurExterne addFormateurExterne(@RequestBody FormateurExterne formateurExterne) {
		return formateurExterneServ.createFormateurExterne(formateurExterne);
	 }
	 
	 @PutMapping("/formateurExterne")
	 public FormateurExterne updateFormateurExterne( @RequestBody FormateurExterne formateurExterne) {
		 return formateurExterneServ.updateFormateurExterne(formateurExterne);
	 }
	 
 @DeleteMapping("/formateurExterne/{id}")
	 public void deleteclient(@PathVariable Long id) {
		 formateurExterneServ.deleteFormateurExterne(id);
		 
	 }
	 @GetMapping("/formateurExterne")
	 public List<FormateurExterne> getFormateurExternes() {
	 	return formateurExterneServ.getAllFormateurExternes();
	 }

}
