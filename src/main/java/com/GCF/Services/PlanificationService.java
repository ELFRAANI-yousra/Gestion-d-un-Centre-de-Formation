package com.GCF.Services;

import java.util.List;

import com.GCF.Entities.Planification;

public interface PlanificationService {
	    List<Planification> getAllPlanification();
	    Planification getPlanificationById(Long id);
	    Planification createPlanification(Planification planification);
	    Planification updatePlanification( Planification updatedPlanification);
	    void deletePlanification(Long id);
	}

