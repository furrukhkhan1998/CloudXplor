package com.clxpr.demo.model.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HeapData")
public class HeapData { // model class for heap data that is used to store data in database
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;
	private String usrId;
	private int occurance;
	private String instances;
	private String memory;
	private String className;
	private String machineId;
	
	
	
	public HeapData() {}



	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
	}



	public String getUsrId() {
		return usrId;
	}



	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}



	public int getOccurance() {
		return occurance;
	}



	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}



	public String getInstances() {
		return instances;
	}



	public void setInstances(String instances) {
		this.instances = instances;
	}



	public String getMemory() {
		return memory;
	}



	public void setMemory(String memory) {
		this.memory = memory;
	}



	public String getClassName() {
		return className;
	}



	public void setClassName(String className) {
		this.className = className;
	}

	public void setMachineId(String machineId2) {
		this.machineId = machineId2;
	}

	public String getMachineId() {
		return this.machineId;
	}
	
	
	
	
}
