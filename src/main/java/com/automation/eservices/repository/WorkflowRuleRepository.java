package com.automation.eservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automation.eservices.model.WorkflowRule;

public interface WorkflowRuleRepository extends JpaRepository<WorkflowRule, Long> {

}
