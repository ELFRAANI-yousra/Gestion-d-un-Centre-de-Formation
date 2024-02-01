package com.GCF.Controllers;
import java.io.IOException;
import java.util.List;

import java.io.File;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.GCF.Entities.FormateurExterne;
import com.GCF.Services.FormateurExterneServiceImp;


import java.time.LocalDate;
@CrossOrigin(origins="*")
@RestController
public class FormateurExterneController {
	@Autowired
	private FormateurExterneServiceImp formateurExterneServ;
	
	@PostMapping("/postuler")
	public FormateurExterne addFormateurExterne(
	        @RequestParam String nom,
	        @RequestParam String prenom,
	        @RequestParam LocalDate dateNaissance,
	        @RequestParam String ville,
	        @RequestParam String email,
	        @RequestParam String telephone,
	        @RequestParam String motsCles,
	        @RequestParam MultipartFile file
	) throws IllegalStateException, IOException {
	    FormateurExterne formateurExterne = new FormateurExterne(null, nom, prenom, dateNaissance, ville, email, telephone, motsCles, null);
	    FormateurExterne f1 = formateurExterneServ.createFormateurExterne(formateurExterne);
	    String pathCv = "src/main/resources/static/CvFiles/" + f1.getId() + ".pdf";
	    file.transferTo(Path.of(pathCv));
	    String urlCV = "http://localhost:8080/cv/" + f1.getId();
	    f1.setCv(urlCV);
	    return formateurExterneServ.createFormateurExterne(f1);
	}
	 
    @DeleteMapping("/formateurExterne/{id}")
	 public void deleteclient(@PathVariable Long id) {
	 String path="src/main/resources/static/CvFiles/"+id+".pdf";
		File f=new File(path);
		if (f.exists())f.delete();
		 formateurExterneServ.deleteFormateurExterne(id);
		 
	 }
	 @GetMapping("/formateurExterne")
	 public List<FormateurExterne> getFormateurExternes() {
	 	return formateurExterneServ.getAllFormateurExternes();
	 }
	 @GetMapping("/cv/{id}")
	  public ResponseEntity<Resource> getPDF(@PathVariable String id) {
	        String path = "src/main/resources/static/CvFiles/" + id + ".pdf";
	        FileSystemResource file = new FileSystemResource(path);

	        if (!file.exists()) {
	            return ResponseEntity.notFound().build();
	        }

	        return ResponseEntity.ok()
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(file);
	    }

}
