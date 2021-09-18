package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.CpuData;
import com.clxpr.demo.repo.CpuDataRepository;
@Component("CpuDataService")
public class CpuDataService { // uses cpu repo class to save cpu stats object in database
	@Autowired
	private CpuDataRepository repo;
	
	public void save(CpuData res) {
		repo.save(res);
	}
}
