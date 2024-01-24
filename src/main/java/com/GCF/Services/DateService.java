package com.GCF.Services;

import java.util.List;

import com.GCF.Entities.Date;

public interface DateService {
	 List<Date> getAllDates();
	    Date getDateById(Long id);
	    Date createDate(Date date);
	    Date updateDate(Date date);
	    void deleteDate(Long id);
}
