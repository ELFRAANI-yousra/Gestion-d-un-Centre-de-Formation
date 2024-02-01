package com.GCF.Services;

import java.util.List;

import com.GCF.Entities.Formateur;

public interface FormateurService {
	  List<Formateur> getAllFormateurs();
	    Formateur getFormateurById(Long id);
	    Formateur createFormateur(Formateur formateur);
	    Formateur updateFormateur(Formateur formateur);
	    void deleteFormateur(Long id);
}
