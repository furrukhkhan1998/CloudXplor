package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.TableLockWaitsData;
import com.clxpr.demo.repo.TableLockWaitsRepository;
@Component("TableLockWaitsService")
public class TableLockWaitsService { // uses the repo class to save data object in database
	@Autowired
	private TableLockWaitsRepository repo;
	
	public void save(TableLockWaitsData res) {
		repo.save(res);
	}
}
