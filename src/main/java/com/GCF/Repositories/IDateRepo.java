package com.GCF.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GCF.Entities.Date;


public interface IDateRepo  extends JpaRepository<Date, Long>{
	List<Date> findByPlanificationId(Long planificationid);

}
