package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.HostSummaryData;
import com.clxpr.demo.repo.HostSummaryRepository;

@Component("HostSummaryService")
public class HostSummaryService { // uses the repo class to save data object in database
	@Autowired
	private HostSummaryRepository repo;
	
	public void save(HostSummaryData res) {
		repo.save(res);
	}
}
