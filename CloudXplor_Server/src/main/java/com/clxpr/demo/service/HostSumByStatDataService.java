package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.HostSumByStatData;
import com.clxpr.demo.repo.HostSumByStatDataRepository;
@Component("HostSumByStatDataService")
public class HostSumByStatDataService { // uses the repo class to save data object in database
	@Autowired
	private HostSumByStatDataRepository repo;
	
	public void save(HostSumByStatData res) {
		repo.save(res);
	}
}
