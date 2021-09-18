package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.clxpr.demo.model.db.HostSummaryData;
public interface HostSummaryRepository extends JpaRepository<HostSummaryData, Long> {  // interface for storing data in database
	@Query(value = "SELECT max(occurance) FROM host_summary where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	int getLatestEntry(String machineId,String userId); 
	
	@Query(value = "SELECT * FROM host_summary where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	List<HostSummaryData> findByMachineIdAndUserId(String machineId, String userId);
	
	List<HostSummaryData> findAllByOccurance(int occurance);

}

