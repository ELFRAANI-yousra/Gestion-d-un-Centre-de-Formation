package com.GCF.Services;

import java.util.List;

import com.GCF.Entities.FormateurExterne;

public interface FormateurExterneService {
	  List<FormateurExterne> getAllFormateurExternes();
	    FormateurExterne getFormateurExterneById(Long id);
	    FormateurExterne createFormateurExterne(FormateurExterne formateurExterne);
	    FormateurExterne updateFormateurExterne(FormateurExterne formateurExterne);
	    void deleteFormateurExterne(Long id);
}
