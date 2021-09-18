package com.clxpr.demo.model.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HeapDumpData")
public class HeapDumpData { // model class for heap data that is used to store data in database
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;
	private String userId;
	private int occurance;
	private String type;
	private String typeOutput;
	private int part = 0;
	private String machineId;
	
	
	public HeapDumpData() {}



	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
	}


	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getTypeOutput() {
		return typeOutput;
	}



	public void setTypeOutput(String typeOutput) {
		this.typeOutput = typeOutput;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId2) {
		this.userId = userId2;
	}



	public int getOccurance() {
		return occurance;
	}



	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}



	public int getPart() {
		return part;
	}



	public void setPart(int part) {
		this.part = part;
	}

	public void setMachineId(String id) {
		this.machineId = id;
	}

	public String getMachineId() {
		return this.machineId;
	}



	
	
	
	
}
