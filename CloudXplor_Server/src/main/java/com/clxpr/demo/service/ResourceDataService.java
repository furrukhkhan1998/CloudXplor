package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.ResourceData;
import com.clxpr.demo.repo.ResourceDataRepository;
@Component("ResourceDataService")
public class ResourceDataService { // uses process repo class to save process stats object in database
	@Autowired 
	private ResourceDataRepository repo;
	
	public void save(ResourceData res) {
		repo.save(res);
	}
}
