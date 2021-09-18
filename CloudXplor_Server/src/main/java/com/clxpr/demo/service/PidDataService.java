package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.PidData;
import com.clxpr.demo.repo.PidDataRepository;

@Component("PidDataService")
public class PidDataService { // uses pid repo class to save pid sched stats object in database
	@Autowired
	private PidDataRepository repo;
	
	public void save(PidData res) {
		repo.save(res);
	}
}
