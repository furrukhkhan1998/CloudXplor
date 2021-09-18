package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.PidSchedData;
import com.clxpr.demo.repo.PidSchedDataRepository;

@Component("PidSchedDataService")
public class PidSchedDataService { // uses pid sched repo class to save pid sched stats object in database
	@Autowired
	private PidSchedDataRepository repo;
	
	public void save(PidSchedData res) {
		repo.save(res);
	}
}
