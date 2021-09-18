package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.clxpr.demo.model.db.DiskData;

public interface DiskDataRepository extends JpaRepository<DiskData, Long> { // interface for storing disk data in database 
	@Query(value = "SELECT max(occurance) FROM disk_data where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	Integer getLatestEntry(String machineId,String userId); 
	
	@Query(value = "SELECT * FROM disk_data where machine_id = ?1 AND user_id = ?2 and occurance = ?3", nativeQuery = true)
	List<DiskData> findLatestRows(String machineId, String userId, Integer occurance);
	
	List<DiskData> findAllByOccurance(int occurance);


}
