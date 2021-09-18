package com.clxpr.demo.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clxpr.demo.model.db.Resource;
public interface ResourceRepository extends JpaRepository<Resource, Long>{
	@Query(value = "SELECT max(occurance) FROM resource where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	int getLatestEntry(String machineId,String userId); 
	
	@Query(value = "SELECT * FROM resource where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	List<Resource> findByMachineIdAndUserId(String machineId, String userId);
	
	List<Resource> findAllByOccurance(int occurance);


}
