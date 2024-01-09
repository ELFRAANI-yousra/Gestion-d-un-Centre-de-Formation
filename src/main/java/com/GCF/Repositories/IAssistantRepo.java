package com.GCF.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GCF.Entities.Assistant;

public interface IAssistantRepo  extends JpaRepository<Assistant, Long>{

}
