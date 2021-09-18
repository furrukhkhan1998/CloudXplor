package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.HeapData;
import com.clxpr.demo.repo.HeapDataRepository;
@Component("HeapDataService")
public class HeapDataService { // uses cpu repo class to save cpu stats object in database
	@Autowired
	private HeapDataRepository repo;
	
	public void save(HeapData res) {
		repo.save(res);
	}
}
