package com.GCF.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GCF.Entities.Date;
import com.GCF.Repositories.IDateRepo;
@Service
public class DateServiceImp implements DateService{
	   @Autowired
	   private  IDateRepo dateRepository;

	    @Override
	    public List<Date> getAllDates() {
	        return dateRepository.findAll();
	    }

	    @Override
	    public Date getDateById(Long id) {
	        return  dateRepository.findById(id).get() ;
	    }

	    @Override
	    public Date createDate(Date date) {
	        return dateRepository.save(date);
	    }

	    @Override
	    public Date updateDate(Date date) {
	            return dateRepository.save(date);
	    }

	    @Override
	    public void deleteDate(Long id) {
	        dateRepository.deleteById(id);
	    }
	}

