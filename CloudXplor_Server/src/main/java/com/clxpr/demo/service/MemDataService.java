package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.MemData;
import com.clxpr.demo.repo.MemDataRepository;

@Component("MemDataService")
public class MemDataService { // uses memory repo class to save memory stats object in database
	@Autowired
	private MemDataRepository repo;
	
	public void save(MemData res) {
		repo.save(res);
	}
}
