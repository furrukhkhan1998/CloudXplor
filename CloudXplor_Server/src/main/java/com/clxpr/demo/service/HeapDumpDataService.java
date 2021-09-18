package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.HeapDumpData;
import com.clxpr.demo.repo.HeapDumpDataRepository;

@Component("HeapDumpDataService")
public class HeapDumpDataService { // uses cpu repo class to save cpu stats object in database
	@Autowired
	private HeapDumpDataRepository repo;
	
	public void save(HeapDumpData res) {
		repo.save(res);
	}
}
