package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.StatementAnalysisData;
import com.clxpr.demo.repo.StatementAnalysisRepository;

@Component("StatementAnalysisService")
public class StatementAnalysisService { // uses the repo class to save data object in database
	@Autowired
	private StatementAnalysisRepository repo;
	
	public void save(StatementAnalysisData res) {
		repo.save(res);
	}
}
