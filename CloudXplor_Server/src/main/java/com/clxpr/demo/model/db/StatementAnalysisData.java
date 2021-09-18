package com.clxpr.demo.model.db;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StatementAnalysis")
public class StatementAnalysisData { // database monitoring stats class used to store in database
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;
	private int occurance;
	private String query, db, full_scan, exec_count, err_count, warn_count, total_lat, max_lat, avg_lat, lock_lat, rows_sent, rows_sent_avg,
	rows_examined, rows_examined_avg, rows_affected, rows_affected_avg, tmp_tables, tmp_disk_tables, rows_sorted, sort_merge_passes,
	digest, first_seen, last_seen, machineId, userId;
	public Long getId() {
		return Id;
	}
	public int getOccurance() {
		return occurance;
	}
	public void setOccurance(int occurance) {
		this.occurance = occurance;
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
	public String getFull_scan() {
		return full_scan;
	}
	public void setFull_scan(String full_scan) {
		this.full_scan = full_scan;
	}
	public String getExec_count() {
		return exec_count;
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
	public void setExec_count(String exec_count) {
		this.exec_count = exec_count;
	}
	public String getErr_count() {
		return err_count;
	}
	public void setErr_count(String err_count) {
		this.err_count = err_count;
	}
	public String getWarn_count() {
		return warn_count;
	}
	public void setWarn_count(String warn_count) {
		this.warn_count = warn_count;
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
	public String getRows_sent_avg() {
		return rows_sent_avg;
	}
	public void setRows_sent_avg(String rows_sent_avg) {
		this.rows_sent_avg = rows_sent_avg;
	}
	public String getRows_examined() {
		return rows_examined;
	}
	public void setRows_examined(String rows_examined) {
		this.rows_examined = rows_examined;
	}
	public String getRows_examined_avg() {
		return rows_examined_avg;
	}
	public void setRows_examined_avg(String rows_examined_avg) {
		this.rows_examined_avg = rows_examined_avg;
	}
	public String getRows_affected() {
		return rows_affected;
	}
	public void setRows_affected(String rows_affected) {
		this.rows_affected = rows_affected;
	}
	public String getRows_affected_avg() {
		return rows_affected_avg;
	}
	public void setRows_affected_avg(String rows_affected_avg) {
		this.rows_affected_avg = rows_affected_avg;
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
	public String getRows_sorted() {
		return rows_sorted;
	}
	public void setRows_sorted(String rows_roted) {
		this.rows_sorted = rows_roted;
	}
	public String getSort_merge_passes() {
		return sort_merge_passes;
	}
	public void setSort_merge_passes(String sort_merge_passes) {
		this.sort_merge_passes = sort_merge_passes;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
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
