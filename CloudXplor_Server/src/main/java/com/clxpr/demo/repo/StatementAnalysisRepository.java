package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clxpr.demo.model.db.StatementAnalysisData;


public interface StatementAnalysisRepository extends JpaRepository<StatementAnalysisData, Long> { // interface for storing data in database
	@Query(value = "SELECT max(occurance) FROM statement_analysis where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	int getLatestEntry(String machineId,String userId); 
	
	@Query(value = "SELECT * FROM statement_analysis where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	List<StatementAnalysisData> findByMachineIdAndUserId(String machineId, String userId);
	
	List<StatementAnalysisData> findAllByOccurance(int occurance);

	
}

