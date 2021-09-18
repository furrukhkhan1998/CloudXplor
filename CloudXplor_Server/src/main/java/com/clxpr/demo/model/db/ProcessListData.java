package com.clxpr.demo.model.db;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProcessList")
public class ProcessListData { // database monitoring stats class used to store in database
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;
	private int occurance;
	private String thid_id, conn_id, user, db, command, state, time, current_stat, stat_lat, progress, lock_lat, rows_examined, rows_sent,
	rows_affected, tmp_tables, tmp_disk_tables, full_scan, last_statement, last_stat_lat, curr_mem, last_wait, last_wait_lat,
	source, trx_lat, trx_state, trx_autocommit, pid, program_name, machineId, userId;
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
		Id = id;
	}
	public int getOccurance() {
		return occurance;
	}
	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}
	public String getThid_id() {
		return thid_id;
	}
	public void setThid_id(String thid_id) {
		this.thid_id = thid_id;
	}
	public String getConn_id() {
		return conn_id;
	}
	public void setConn_id(String conn_id) {
		this.conn_id = conn_id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDb() {
		return db;
	}
	public void setDb(String db) {
		this.db = db;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCurrent_stat() {
		return current_stat;
	}
	public void setCurrent_stat(String current_stat) {
		this.current_stat = current_stat;
	}
	public String getStat_lat() {
		return stat_lat;
	}
	public void setStat_lat(String stat_lat) {
		this.stat_lat = stat_lat;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getLock_lat() {
		return lock_lat;
	}
	public void setLock_lat(String lock_lat) {
		this.lock_lat = lock_lat;
	}
	public String getRows_examined() {
		return rows_examined;
	}
	public void setRows_examined(String rows_examined) {
		this.rows_examined = rows_examined;
	}
	public String getRows_sent() {
		return rows_sent;
	}
	public void setRows_sent(String rows_sent) {
		this.rows_sent = rows_sent;
	}
	public String getRows_affected() {
		return rows_affected;
	}
	public void setRows_affected(String rows_affected) {
		this.rows_affected = rows_affected;
	}
	public String getTmp_tables() {
		return tmp_tables;
	}
	public void setTmp_tables(String tmp_tables) {
		this.tmp_tables = tmp_tables;
	}
	public String getTmp_disk_tables() {
		return tmp_disk_tables;
	}
	public void setTmp_disk_tables(String tmp_disk_tables) {
		this.tmp_disk_tables = tmp_disk_tables;
	}
	public String getFull_scan() {
		return full_scan;
	}
	public void setFull_scan(String full_scan) {
		this.full_scan = full_scan;
	}
	public String getLast_statement() {
		return last_statement;
	}
	public void setLast_statement(String last_statement) {
		this.last_statement = last_statement;
	}
	public String getLast_stat_lat() {
		return last_stat_lat;
	}
	public void setLast_stat_lat(String last_stat_lat) {
		this.last_stat_lat = last_stat_lat;
	}
	public String getCurr_mem() {
		return curr_mem;
	}
	public void setCurr_mem(String curr_mem) {
		this.curr_mem = curr_mem;
	}
	public String getLast_wait() {
		return last_wait;
	}
	public void setLast_wait(String last_wait) {
		this.last_wait = last_wait;
	}
	public String getLast_wait_lat() {
		return last_wait_lat;
	}
	public void setLast_wait_lat(String last_wait_lat) {
		this.last_wait_lat = last_wait_lat;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTrx_lat() {
		return trx_lat;
	}
	public void setTrx_lat(String trx_lat) {
		this.trx_lat = trx_lat;
	}
	public String getTrx_state() {
		return trx_state;
	}
	public void setTrx_state(String trx_state) {
		this.trx_state = trx_state;
	}
	public String getTrx_autocommit() {
		return trx_autocommit;
	}
	public void setTrx_autocommit(String trx_autocommit) {
		this.trx_autocommit = trx_autocommit;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getProgram_name() {
		return program_name;
	}
	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}
}
