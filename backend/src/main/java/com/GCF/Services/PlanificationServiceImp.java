package com.GCF.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GCF.Entities.Individu;
import com.GCF.Entities.Planification;
import com.GCF.Repositories.IPlanificationRepo;

@Service
public class PlanificationServiceImp implements PlanificationService{
	@Autowired
	private  IPlanificationRepo planificationRepository;
	@Autowired
	private  IndividuServiceImp individuServiceImp;
    @Override
    public List<Planification> getAllPlanification() {
        return planificationRepository.findAll();
    }

    @Override
    public Planification getPlanificationById(Long id) {
      return planificationRepository.findById(id).get();
    }

    @Override
    public Planification createPlanification(Planification planification) {
        return planificationRepository.save(planification);
    }

    @Override
    public Planification updatePlanification( Planification updatedFormation) {
     
            return planificationRepository.save(updatedFormation);
        
    }

    @Override
    public void deletePlanification(Long id) {
        planificationRepository.deleteById(id);
    }
    @Override
    public Planification savePlanificationWithIndividu(Planification planification, List<Long> individuIdList) {
        for (Long individuId : individuIdList) {
            Individu existingIndividu = individuServiceImp.getIndividuById(individuId);
            String code= existingIndividu.getId()+"@1234"+planification.getId();
            existingIndividu.setPlanification(planification);
            existingIndividu.setFormation(null);
            existingIndividu.setCode(code);
            individuServiceImp.updateIndividu(existingIndividu);
        }

        return planificationRepository.save(planification);
    }

	@Override
	public List<Planification> getFormateurPlanifications(Long id) {
		return planificationRepository.findByFormateurId(id);
	}
}
