package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.DiskData;
import com.clxpr.demo.repo.DiskDataRepository;

@Component("DiskDataService")
public class DiskDataService { // uses disk repo class to save disk stats object in database
	@Autowired
	private DiskDataRepository repo;
	
	public void save(DiskData res) {
		repo.save(res);
	}
}
