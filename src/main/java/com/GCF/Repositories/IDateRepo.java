package com.GCF.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GCF.Entities.Date;

public interface IDateRepo  extends JpaRepository<Date, Long>{

}
