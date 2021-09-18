package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clxpr.demo.model.db.ThreadData;

public interface ThreadDataRepository extends JpaRepository<ThreadData, Long> {  // interface for storing cpu data in database 
	@Query(value = "SELECT max(occurance) FROM ThreadData")
	int getLatestEntry(); 
	
	List<ThreadData> findAllByOccurance(int occurance);
}
