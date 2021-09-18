package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.clxpr.demo.model.db.ResourceData;
public interface ResourceDataRepository extends JpaRepository<ResourceData, Long> { // interface for storing process data in database
	@Query(value = "SELECT max(occurance) FROM resource_data where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	int getLatestEntry(String machineId,String userId); 
	
	@Query(value = "SELECT * FROM resource_data where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	List<ResourceData> findByMachineIdAndUserId(String machineId, String userId);
	
	List<ResourceData> findAllByOccurance(int occurance);



}
