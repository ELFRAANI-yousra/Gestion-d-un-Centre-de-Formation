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

import com.GCF.Entities.Assistant;
import com.GCF.Services.AssistantServiceImp;


@RestController
public class AssistantController {
	@Autowired
	private AssistantServiceImp assistantServ;
	
	 @PostMapping("/assistant")
	 public Assistant addAssistant(@RequestBody Assistant assistant) {
		return assistantServ.createAssistant(assistant);
	 }
	 

	 @PutMapping("/assistant")
	 public Assistant updateAssistant( @RequestBody Assistant assistant) {
		 return assistantServ.updateAssistant(assistant);
	 }
	 
	 @DeleteMapping("/assistant/{id}")
	 public void deleteclient(@PathVariable Long id) {
		 assistantServ.deleteAssistant(id);
		 
	 }
	 @GetMapping("/assistant")
	 public List<Assistant> getAssistants() {
	 	return assistantServ.getAllAssistants();
	 }

}
