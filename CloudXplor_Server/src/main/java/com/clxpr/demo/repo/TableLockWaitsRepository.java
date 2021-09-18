package com.clxpr.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clxpr.demo.model.db.TableLockWaitsData;
public interface TableLockWaitsRepository extends JpaRepository<TableLockWaitsData, Long> { // interface for storing data in database
	
}

