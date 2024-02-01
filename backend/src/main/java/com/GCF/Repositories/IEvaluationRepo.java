package com.GCF.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GCF.Entities.Evaluation;

public interface IEvaluationRepo extends JpaRepository<Evaluation, Long> {

}
