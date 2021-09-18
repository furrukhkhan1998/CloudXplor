package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.ProcessListData;
import com.clxpr.demo.repo.ProcessListRepository;

@Component("ProcessListService")
public class ProcessListService { // uses the repo class to save data object in database
	@Autowired
	private ProcessListRepository repo;
	
	public void save(ProcessListData res) {
		repo.save(res);
	}
}
