package com.automation.eservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automation.eservices.model.WorkflowStep;

public interface WorkflowStepRepository extends JpaRepository<WorkflowStep, Long> {

}
