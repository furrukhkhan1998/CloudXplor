package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.StackData;
import com.clxpr.demo.repo.StackDataRepository;

@Component("StackDataService")
public class StackDataService { // uses cpu repo class to save cpu stats object in database
	@Autowired
	private StackDataRepository repo;
	
	public void save(StackData res) {
		repo.save(res);
	}
}
