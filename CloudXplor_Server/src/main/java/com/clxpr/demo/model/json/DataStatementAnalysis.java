package com.clxpr.demo.model.json;

public class DataStatementAnalysis {
	
	
	public DataStatementAnalysis(String userId,String machineId,int occurance,Long Id, String query, String db, String exec_c, String err_c, String total_l, String max_l, String avg_l,
			String lock_l, String rows_sent, String rows_e, String rows_a, String first, String last) {
		this.Id = Id;
		this.occurance = occurance;
		this.query = query;
		this.db = db;
		this.exec_count = exec_c;
		this.err_count = err_c;
		this.total_lat = total_l;
		this.max_lat = max_l;
		this.avg_lat = avg_l;
		this.lock_lat = lock_l;
		this.rows_sent = rows_sent;
		this.rows_examined = rows_e;
		this.rows_affected = rows_a;
		this.first_seen = first;
		this.last_seen = last;
		this.machineId = machineId;
		this.userId = userId;
		
		
	}
	
	private Long Id;
	private int occurance;
	private String query, db, exec_count, err_count, total_lat, max_lat, avg_lat, lock_lat, rows_sent,
	rows_examined, rows_affected, first_seen, last_seen, machineId, userId;
	
	
	public int getOccurance() {
		return occurance;
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


	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getDb() {
		return db;
	}
	public void setDb(String db) {
		this.db = db;
	}
	public String getExec_count() {
		return exec_count;
	}
	public void setExec_count(String exec_count) {
		this.exec_count = exec_count;
	}
	public String getErr_count() {
		return err_count;
	}
	public void setErr_count(String err_count) {
		this.err_count = err_count;
	}
	public String getTotal_lat() {
		return total_lat;
	}
	public void setTotal_lat(String total_lat) {
		this.total_lat = total_lat;
	}
	public String getMax_lat() {
		return max_lat;
	}
	public void setMax_lat(String max_lat) {
		this.max_lat = max_lat;
	}
	public String getAvg_lat() {
		return avg_lat;
	}
	public void setAvg_lat(String avg_lat) {
		this.avg_lat = avg_lat;
	}
	public String getLock_lat() {
		return lock_lat;
	}
	public void setLock_lat(String lock_lat) {
		this.lock_lat = lock_lat;
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
	public String getFirst_seen() {
		return first_seen;
	}
	public void setFirst_seen(String first_seen) {
		this.first_seen = first_seen;
	}
	public String getLast_seen() {
		return last_seen;
	}
	public void setLast_seen(String last_seen) {
		this.last_seen = last_seen;
	}

}
