package com.clxpr.demo.model.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HostSummary")
public class HostSummaryData { // database monitoring stats class used to store in database
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;
	private int occurance;
	private String host, statement, statement_latency, statement_avg_lat, table_scans, file_ios, file_io_lat,
	current_connect, total_connect, unique_users, current_memory, total_memory_allocated, machineId, userId, anomaly;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
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
	public String getStatement_latency() {
		return statement_latency;
	}
	public void setStatement_latency(String statement_latency) {
		this.statement_latency = statement_latency;
	}
	public String getStatement_avg_lat() {
		return statement_avg_lat;
	}
	public void setStatement_avg_lat(String statement_avg_lat) {
		this.statement_avg_lat = statement_avg_lat;
	}
	public String getTable_scans() {
		return table_scans;
	}
	public void setTable_scans(String table_scans) {
		this.table_scans = table_scans;
	}
	public String getFile_ios() {
		return file_ios;
	}
	public void setFile_ios(String file_ios) {
		this.file_ios = file_ios;
	}
	public String getFile_io_lat() {
		return file_io_lat;
	}
	public void setFile_io_lat(String file_io_lat) {
		this.file_io_lat = file_io_lat;
	}
	public String getCurrent_connect() {
		return current_connect;
	}
	public void setCurrent_connect(String current_connect) {
		this.current_connect = current_connect;
	}
	public String getTotal_connect() {
		return total_connect;
	}
	public void setTotal_connect(String total_connect) {
		this.total_connect = total_connect;
	}
	public String getUnique_users() {
		return unique_users;
	}
	public void setUnique_users(String unique_users) {
		this.unique_users = unique_users;
	}
	public String getCurrent_memory() {
		return current_memory;
	}
	public void setCurrent_memory(String current_memory) {
		this.current_memory = current_memory;
	}
	public String getTotal_memory_allocated() {
		return total_memory_allocated;
	}
	public void setTotal_memory_allocated(String total_memory_allocated) {
		this.total_memory_allocated = total_memory_allocated;
	}
	public String getAnomaly() {
		return anomaly;
	}
	public void setAnomaly(String anomaly) {
		this.anomaly = anomaly;
	}
}
