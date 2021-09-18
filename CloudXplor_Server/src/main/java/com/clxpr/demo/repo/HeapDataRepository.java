package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clxpr.demo.model.db.HeapData;

public interface HeapDataRepository extends JpaRepository<HeapData, Long>{
	@Query(value = "SELECT max(occurance) FROM HeapData")
	int getLatestEntry(); 
	
	List<HeapData> findAllByOccurance(int occurance);
}
