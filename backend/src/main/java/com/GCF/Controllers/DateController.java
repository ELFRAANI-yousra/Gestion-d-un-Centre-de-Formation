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

import com.GCF.Entities.Date;
import com.GCF.Services.DateServiceImp;

@RestController
@CrossOrigin(origins="*")
public class DateController {
	@Autowired
	private DateServiceImp dateServ;
	
	 @PostMapping("/date")
	 public Date addDate(@RequestBody Date date) {
		return dateServ.createDate(date);
	 }
	 
	 @PutMapping("/date")
	 public Date updateDate( @RequestBody Date date) {
		 return dateServ.updateDate(date);
	 }
	 
	 @DeleteMapping("/date/{id}")
	 public void deleteDate(@PathVariable Long id) {
		 dateServ.deleteDate(id);
		 
	 }
	 @GetMapping("/date")
	 public List<Date> getDates() {
	 	return dateServ.getAllDates();
	 }
	 
	 @GetMapping("/date/{id}")
	 public List<Date> getDatesPlanification(@PathVariable Long id) {
	 	return dateServ.getPlanificationDates(id);
	 }

}
