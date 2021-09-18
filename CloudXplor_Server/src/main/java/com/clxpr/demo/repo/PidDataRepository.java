package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clxpr.demo.model.db.PidData;

public interface PidDataRepository extends JpaRepository<PidData, Long> { // interface for storing pid data in database
	@Query(value = "SELECT max(occurance) FROM pid_data where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	int getLatestEntry(String machineId,String userId); 
	
	@Query(value = "SELECT * FROM pid_data where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	List<PidData> findByMachineIdAndUserId(String machineId, String userId);
	
	List<PidData> findAllByOccurance(int occurance);



}
