package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.clxpr.demo.model.db.PidSchedData;

public interface PidSchedDataRepository extends JpaRepository<PidSchedData, Long> { // interface for storing pid sched data in database
	@Query(value = "SELECT max(occurance) FROM pid_sched_data where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	int getLatestEntry(String machineId,String userId); 
	
	@Query(value = "SELECT * FROM pid_sched_data where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	List<PidSchedData> findByMachineIdAndUserId(String machineId, String userId);
	
	List<PidSchedData> findAllByOccurance(int occurance);



}
