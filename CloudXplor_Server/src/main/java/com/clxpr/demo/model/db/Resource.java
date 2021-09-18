package com.clxpr.demo.model.db;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="resource")
public class Resource { // model class for resource that is used to store data in database
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int occurance;
	private String machineId;
	private String userId;
	@OneToMany(mappedBy="resource")
	private List<ResourceData> resources;
	private LocalDate timestamp;
	public String getMachineId() {
		return machineId;
	}


	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public Resource() {}
	

	public int getOccurance() {
		return occurance;
	}


	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<ResourceData> getResources() {
		return resources;
	}
	public void setResources(List<ResourceData> resources) {
		this.resources = resources;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	
}
