package com.automation.eservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automation.eservices.model.MCCOrder;

public interface MCCOrderRepository extends JpaRepository<MCCOrder, Long> {

}
