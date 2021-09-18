package com.clxpr.demo.model.json;

public class Data { // model class for process stats that is used to store data in json format for web application
	private int occurance;
	private String machineId;
	private String userId;
	private Long id;
	private String time;
	private Integer uid;
	private Integer pid;
	private Double rd;
	private Double wr;
	private Double ccwr;
	private Double iodelay;
	private String command;
	
	public Data(String userId,String machineId,int occurance, Long id, String time, Integer uid, Integer pid, Double rd, Double wr, Double ccwr, Double iodelay,
			String command) {
		super();
		this.occurance = occurance;
		this.id = id;
		this.time = time;
		this.uid = uid;
		this.pid = pid;
		this.rd = rd;
		this.wr = wr;
		this.ccwr = ccwr;
		this.iodelay = iodelay;
		this.command = command;
		this.machineId = machineId;
		this.userId = userId;
	}
	

	public int getOccurance() {
		return occurance;
	}


	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}


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


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	
}
