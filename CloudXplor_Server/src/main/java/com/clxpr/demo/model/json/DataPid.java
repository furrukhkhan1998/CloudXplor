package com.clxpr.demo.model.json;

public class DataPid { //model class for pid stats that is used to store data in json format for web application
	
	public DataPid(String userId,String machineId,int occurance, String time, String uid, String pid, String usr, String system, String guest, String wait,
			String cpu, String cpuNo, String cmd, Long Id) {
		super();
		this.occurance = occurance;
		this.time = time;
		this.uid = uid;
		this.pid = pid;
		this.usr = usr;
		this.system = system;
		this.guest = guest;
		this.wait = wait;
		this.cpu = cpu;
		this.cpuNo = cpuNo;
		this.cmd = cmd;
		this.Id = Id;
	}
	private int occurance;
	private String time;
	private String uid;
	private String pid;
	private String usr;
	private String system;
	private String guest;
	private String wait;
	private String cpu;
	private String cpuNo;
	private String cmd;
	private Long Id;
	private String machineId;
	private String userId;
	

	
	public int getOccurance() {
		return occurance;
	}

	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}

	public Long getId() {
		return Id;
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

	public void setId(Long id) {
		this.Id = id;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public String getWait() {
		return wait;
	}

	public void setWait(String wait) {
		this.wait = wait;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getCpuNo() {
		return cpuNo;
	}

	public void setCpuNo(String cpuNo) {
		this.cpuNo = cpuNo;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

}
