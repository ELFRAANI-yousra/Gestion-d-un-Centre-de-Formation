package com.GCF.Services;

import java.util.List;

import com.GCF.Entities.Individu;

public interface IndividuService {
	  List<Individu> getAllIndividus();
	    Individu getIndividuById(Long id);
	    Individu createIndividu(Individu individu);
	    Individu updateIndividu(Individu individu);
	    void deleteIndividu(Long id);
}
