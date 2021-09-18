package com.clxpr.demo.model.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StatementAnalysis")
public class TableLockWaitsData {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;
	private int occurance;
	private String object_schema, object_name, waiting_thread_id, waiting_pid, waiting_account, waiting_lock_type, waiting_lock_duration, waiting_query,
	waiting_query_secs, waiting_query_rows_affected, waiting_query_rows_examined, blocking, thread_id, blocking_pid, blocking_account,
	blocking_lock_type, blocking_lock_duration, sql_kill_blocking_query, sql_kill_blocking_connection, machineId, userId;
	public Long getId() {
		return Id;
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
	public void setId(Long id) {
		Id = id;
	}
	public String getObject_schema() {
		return object_schema;
	}
	public void setObject_schema(String object_schema) {
		this.object_schema = object_schema;
	}
	public String getObject_name() {
		return object_name;
	}
	public void setObject_name(String object_name) {
		this.object_name = object_name;
	}
	public String getWaiting_thread_id() {
		return waiting_thread_id;
	}
	public void setWaiting_thread_id(String waiting_thread_id) {
		this.waiting_thread_id = waiting_thread_id;
	}
	public String getWaiting_pid() {
		return waiting_pid;
	}
	public void setWaiting_pid(String waiting_pid) {
		this.waiting_pid = waiting_pid;
	}
	public String getWaiting_account() {
		return waiting_account;
	}
	public void setWaiting_account(String waiting_account) {
		this.waiting_account = waiting_account;
	}
	public String getWaiting_lock_type() {
		return waiting_lock_type;
	}
	public void setWaiting_lock_type(String waiting_lock_type) {
		this.waiting_lock_type = waiting_lock_type;
	}
	public String getWaiting_lock_duration() {
		return waiting_lock_duration;
	}
	public void setWaiting_lock_duration(String waiting_lock_duration) {
		this.waiting_lock_duration = waiting_lock_duration;
	}
	public String getWaiting_query() {
		return waiting_query;
	}
	public void setWaiting_query(String waiting_query) {
		this.waiting_query = waiting_query;
	}
	public String getWaiting_query_secs() {
		return waiting_query_secs;
	}
	public void setWaiting_query_secs(String waiting_query_secs) {
		this.waiting_query_secs = waiting_query_secs;
	}
	public String getWaiting_query_rows_affected() {
		return waiting_query_rows_affected;
	}
	public void setWaiting_query_rows_affected(String waiting_query_rows_affected) {
		this.waiting_query_rows_affected = waiting_query_rows_affected;
	}
	public String getWaiting_query_rows_examined() {
		return waiting_query_rows_examined;
	}
	public void setWaiting_query_rows_examined(String waiting_query_rows_examined) {
		this.waiting_query_rows_examined = waiting_query_rows_examined;
	}
	public String getBlocking() {
		return blocking;
	}
	public void setBlocking(String blocking) {
		this.blocking = blocking;
	}
	public String getThread_id() {
		return thread_id;
	}
	public void setThread_id(String thread_id) {
		this.thread_id = thread_id;
	}
	public String getBlocking_pid() {
		return blocking_pid;
	}
	public void setBlocking_pid(String blocking_pid) {
		this.blocking_pid = blocking_pid;
	}
	public String getBlocking_account() {
		return blocking_account;
	}
	public void setBlocking_account(String blocking_account) {
		this.blocking_account = blocking_account;
	}
	public String getBlocking_lock_type() {
		return blocking_lock_type;
	}
	public void setBlocking_lock_type(String blocking_lock_type) {
		this.blocking_lock_type = blocking_lock_type;
	}
	public String getBlocking_lock_duration() {
		return blocking_lock_duration;
	}
	public void setBlocking_lock_duration(String blocking_lock_duration) {
		this.blocking_lock_duration = blocking_lock_duration;
	}
	public String getSql_kill_blocking_query() {
		return sql_kill_blocking_query;
	}
	public void setSql_kill_blocking_query(String sql_kill_blocking_query) {
		this.sql_kill_blocking_query = sql_kill_blocking_query;
	}
	public String getSql_kill_blocking_connection() {
		return sql_kill_blocking_connection;
	}
	public void setSql_kill_blocking_connection(String sql_kill_blocking_connection) {
		this.sql_kill_blocking_connection = sql_kill_blocking_connection;
	}

}
