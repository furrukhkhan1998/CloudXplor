package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.clxpr.demo.model.db.IoData;
import com.clxpr.demo.model.json.DataIo;

public interface IoDataRepository extends JpaRepository<IoData, Long> {  // interface for storing io data in database 
	@Query(value = "SELECT max(occurance) FROM io_data where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	Integer getLatestEntry(String machineId,String userId); 
	
	@Query(value = "SELECT * FROM io_data where machine_id = ?1 AND user_id = ?2 and occurance = ?3", nativeQuery = true)
	List<IoData> findLatest(String machineId, String userId,Integer occurance);
	
	List<IoData> findAllByOccurance(Integer occurance);

}
