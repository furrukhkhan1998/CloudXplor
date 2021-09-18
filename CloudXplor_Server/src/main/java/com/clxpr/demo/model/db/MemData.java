package com.clxpr.demo.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MemData")
public class MemData { // model class for memory stats that is used to store data in database
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="logno_col")
	private Long LogNo;
	@Column(name="occurance")
	private int occurance;
	@Column(name="machineId")
	private String machineId;
	@Column(name="userId")
	private String userId;
	@Column(name="r_col")
	private String r;
	@Column(name="b_col")
	private String b;
	@Column(name="swpd_col")
	private String swpd;
	@Column(name="free_col")
	private String free;
	@Column(name="inact_col")
	private String inact;
	@Column(name="active_col")
	private String active;
	@Column(name="si_col")
	private String si;
	@Column(name="so_col")
	private String so;
	@Column(name="bi_col")
	private String bi;



	@Column(name="bo_col")
	private String bo;
	@Column(name="in_col")
	private String in;
	@Column(name="cs_col")
	private String cs;
	@Column(name="us_col")
	private String us;
	@Column(name="sy_col")
	private String sy;
	@Column(name="id_col")
	private String id;
	@Column(name="wa_col")
	private String wa;
	@Column(name="st_col")
	private String st;
	@Column(name = "time")
	private String time;
	@Column(name="anomaly")
	private Integer anomaly;
	public Long getLogNo() {
		return LogNo;
	}
	public void setLogNo(Long logNo) {
		LogNo = logNo;
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
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getSwpd() {
		return swpd;
	}
	public void setSwpd(String swpd) {
		this.swpd = swpd;
	}
	public String getFree() {
		return free;
	}
	public void setFree(String free) {
		this.free = free;
	}
	public String getInact() {
		return inact;
	}
	public void setInact(String inact) {
		this.inact = inact;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getSi() {
		return si;
	}
	public void setSi(String si) {
		this.si = si;
	}
	public String getSo() {
		return so;
	}
	public void setSo(String so) {
		this.so = so;
	}
	public String getBi() {
		return bi;
	}
	public void setBi(String bi) {
		this.bi = bi;
	}
	public String getBo() {
		return bo;
	}
	public void setBo(String bo) {
		this.bo = bo;
	}
	public String getIn() {
		return in;
	}
	public void setIn(String in) {
		this.in = in;
	}
	public String getCs() {
		return cs;
	}
	public void setCs(String cs) {
		this.cs = cs;
	}
	public String getUs() {
		return us;
	}
	public void setUs(String us) {
		this.us = us;
	}
	public String getSy() {
		return sy;
	}
	public void setSy(String sy) {
		this.sy = sy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWa() {
		return wa;
	}
	public void setWa(String wa) {
		this.wa = wa;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	public Integer getAnomaly() {
		return anomaly;
	}
	public void setAnomaly(Integer i) {
		this.anomaly = i;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

    public MemData() {}


	
	
	
	
}
