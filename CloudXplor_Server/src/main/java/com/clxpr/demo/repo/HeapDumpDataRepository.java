package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clxpr.demo.model.db.HeapDumpData;



public interface HeapDumpDataRepository extends JpaRepository<HeapDumpData, Long> {
	@Query(value = "SELECT max(occurance) FROM HeapDumpData")
	int getLatestEntry(); 
	
	List<HeapDumpData> findAllByOccurance(int occurance);
}
