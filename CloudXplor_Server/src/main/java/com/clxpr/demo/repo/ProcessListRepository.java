package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clxpr.demo.model.db.ProcessListData;
public interface ProcessListRepository extends JpaRepository<ProcessListData, Long> { // interface for storing data in database
	@Query(value = "SELECT max(occurance) FROM process_list where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	int getLatestEntry(String machineId,String userId); 
	
	@Query(value = "SELECT * FROM process_list where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	List<ProcessListData> findByMachineIdAndUserId(String machineId, String userId);
	
	List<ProcessListData> findAllByOccurance(int occurance);


	
}

