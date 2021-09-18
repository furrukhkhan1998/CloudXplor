package com.clxpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clxpr.demo.model.db.Resource;
import com.clxpr.demo.repo.ResourceRepository;
@Component("ResourceService")
public class ResourceService {
	@Autowired
	private ResourceRepository repo;
	
	public void save(Resource res) {
		repo.save(res);
	}
}
