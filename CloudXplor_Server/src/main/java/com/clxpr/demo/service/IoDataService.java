package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.IoData;
import com.clxpr.demo.repo.IoDataRepository;

@Component("IoDataService")
public class IoDataService { // uses io repo class to save io stats object in database
	@Autowired
	private IoDataRepository repo;
	
	public void save(IoData res) {
		repo.save(res);
	}
}
