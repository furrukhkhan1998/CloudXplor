package com.clxpr.demo.model.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ResourceData")
public class ResourceData { // model class for process stats that is used to store data in database
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private int occurance;
	private String time;
	private Integer uid;
	private Integer pid;
	private Double rd;
	private Double wr;
	private Double ccwr;
	private Double iodelay;
	private String command;
	private String machineId;
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

	private String userId;
	
	@ManyToOne
	@JoinColumn(name="resource_id")
	Resource resource;
	
	public ResourceData() {}
	

	
	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Double getRd() {
		return rd;
	}

	public void setRd(Double rd) {
		this.rd = rd;
	}

	public Double getWr() {
		return wr;
	}

	public void setWr(Double wr) {
		this.wr = wr;
	}

	public Double getCcwr() {
		return ccwr;
	}

	public void setCcwr(Double ccwr) {
		this.ccwr = ccwr;
	}

	public Double getIodelay() {
		return iodelay;
	}

	public void setIodelay(Double iodelay) {
		this.iodelay = iodelay;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public int getOccurance() {
		// TODO Auto-generated method stub
		return this.occurance;
	}
	
	
}
