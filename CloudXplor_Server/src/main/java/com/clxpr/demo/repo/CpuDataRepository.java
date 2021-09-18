package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clxpr.demo.model.db.CpuData;


public interface CpuDataRepository extends JpaRepository<CpuData, Long> {  // interface for storing cpu data in database 
	
	@Query(value = "SELECT max(occurance) FROM cpu_data where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	Integer getLatestEntry(String machineId,String userId); 
	
	@Query(value = "SELECT * FROM cpu_data where machine_id = ?1 AND user_id = ?2 and occurance =?3", nativeQuery = true)
	List<CpuData> findLatest(String machineId, String userId,Integer occurance);
	
	List<CpuData> findAllByOccurance(Integer occurance);
	
}
