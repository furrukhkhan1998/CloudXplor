package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.clxpr.demo.model.db.HostSumByStatData;
public interface HostSumByStatDataRepository extends JpaRepository<HostSumByStatData, Long> { // interface for storing data in database
	@Query(value = "SELECT max(occurance) FROM host_sum_by_stat_data where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	int getLatestEntry(String machineId,String userId); 
	
	@Query(value = "SELECT * FROM host_sum_by_stat_data where machine_id = ?1 AND user_id = ?2", nativeQuery = true)
	List<HostSumByStatData> findByMachineIdAndUserId(String machineId, String userId);
	
	List<HostSumByStatData> findAllByOccurance(int occurance);


}

