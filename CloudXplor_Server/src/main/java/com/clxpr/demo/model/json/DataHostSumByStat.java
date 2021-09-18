package com.clxpr.demo.model.json;

public class DataHostSumByStat { // database monitoring stats class used to store in json format

	
	public DataHostSumByStat(String userId,String machineId,int occurance,Long Id, String host, String statement, String total, String total_latency, String max_latency, 
			String lock_latency, String rows_sent, String rows_examined, String rows_affected, String full_scans) {
		this.Id = Id;
		this.occurance = occurance;
		this.host = host;
		this.statement = statement;
		this.total_latency = total_latency;
		this.total = total;
		this.max_latency = max_latency;
		this.lock_latency = lock_latency;
		this.rows_affected = rows_affected;
		this.rows_examined = rows_examined;
		this.rows_sent = rows_sent;
		this.full_scans = full_scans;
		this.machineId = machineId;
		this.userId = userId;
		
		
	}
	
	public int getOccurance() {
		return occurance;
	}
	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}

	private Long Id;
	private int occurance;
	private String host, statement, total, total_latency,
	max_latency, lock_latency, rows_sent, rows_examined, rows_affected, full_scans, machineId, userId;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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

	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getTotal_latency() {
		return total_latency;
	}
	public void setTotal_latency(String total_latency) {
		this.total_latency = total_latency;
	}
	public String getMax_latency() {
		return max_latency;
	}
	public void setMax_latency(String max_latency) {
		this.max_latency = max_latency;
	}
	public String getLock_latency() {
		return lock_latency;
	}
	public void setLock_latency(String lock_latency) {
		this.lock_latency = lock_latency;
	}
	public String getRows_sent() {
		return rows_sent;
	}
	public void setRows_sent(String rows_sent) {
		this.rows_sent = rows_sent;
	}
	public String getRows_examined() {
		return rows_examined;
	}
	public void setRows_examined(String rows_examined) {
		this.rows_examined = rows_examined;
	}
	public String getRows_affected() {
		return rows_affected;
	}
	public void setRows_affected(String rows_affected) {
		this.rows_affected = rows_affected;
	}
	public String getFull_scans() {
		return full_scans;
	}
	public void setFull_scans(String full_scans) {
		this.full_scans = full_scans;
	}
	
	
	
}
