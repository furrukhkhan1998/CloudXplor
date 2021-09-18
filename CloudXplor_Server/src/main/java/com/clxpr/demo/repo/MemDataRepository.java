package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.clxpr.demo.model.db.MemData;


public interface MemDataRepository extends JpaRepository<MemData, Long> { // interface for storing memory data in database 
	@Query(value = "SELECT max(occurance) FROM mem_data where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	int getLatestEntry(String machineId,String userId); 
	
	@Query(value = "SELECT * FROM mem_data where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	List<MemData> findByMachineIdAndUserId(String machineId, String userId);
	
	List<MemData> findAllByOccurance(int occurance);

	@Query(value = "Select * from mem_data where machine_id = ?1 and anomaly >-99 order by occurance desc limit 50 ", nativeQuery = true)
    List<MemData> findAllByMachineId(String machineId);
	
	@Query(value = "Select * from mem_data where machine_id =?1 and anomaly = -1 ", nativeQuery = true)
    List<MemData> findTotalAnomalies(String machineId);

}
