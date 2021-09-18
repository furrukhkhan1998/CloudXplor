package com.clxpr.demo.model.json;

public class DataPidSched { //model class for pid sched stats that is used to store data in json format for web application
	
	public DataPidSched(String userId,String machineId,int occurance, String uid, String pid, String priority, String policy, String cmd, String time, Long Id) {
		super();
		this.occurance = occurance;
		this.uid = uid;
		this.pid = pid;
		this.priority = priority;
		this.policy = policy;
		this.cmd = cmd;
		this.time = time;
		this.Id = Id;
		this.machineId = machineId;
		this.userId = userId;
		
	}
	private int occurance;
	private String uid;
	private String pid;
	private String priority;
	private String policy;
	private String cmd;
	private String time;
	private Long Id;
	private String machineId, userId;
	

	
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

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
}
