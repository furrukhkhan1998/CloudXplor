package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.ThreadData;
import com.clxpr.demo.repo.ThreadDataRepository;

@Component("ThreadDataService")
public class ThreadDataService { // uses cpu repo class to save cpu stats object in database
	@Autowired
	private ThreadDataRepository repo;
	
	public void save(ThreadData res) {
		repo.save(res);
	}
}
