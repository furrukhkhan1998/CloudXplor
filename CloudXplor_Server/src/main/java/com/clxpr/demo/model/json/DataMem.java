package com.clxpr.demo.model.json;

public class DataMem { //model class for memory stats that is used to store data in json format for web application
	
	public DataMem(String userId,String machineId,int occurance,String r, String b, String swpd, String free, String inact, String active, String si, String so,
			String bi, String bo, String in, String cs, String us, String sy, String id, String wa, String st, Integer long1, Long Id, String time) {
		super();
		this.occurance = occurance;
		this.r = r;
		this.b = b;
		this.swpd = swpd;
		this.free = free;
		this.inact = inact;
		this.active = active;
		this.si = si;
		this.so = so;
		this.bi = bi;
		this.bo = bo;
		this.in = in;
		this.cs = cs;
		this.us = us;
		this.sy = sy;
		this.id = id;
		this.wa = wa;
		this.st = st;
		this.Id = Id;
		this.time = time;
		this.machineId = machineId;
		this.userId = userId;
		this.setAnomaly(long1);
	}
	private int occurance;
	private Long Id;
	private String r;
	private String b;
	private String swpd;
	private String free;
	private String inact;
	private String active;
	private String si;
	private String so;
	private String bi;
	private String bo;
	private String in;
	private String cs;
	private String us;
	private String sy;
	private String id;
	private String wa;
	private String st;
	private String machineId;
	private String userId;
	private Integer anomaly;
	private String time;
	public int getOccurance() {
		return occurance;
	}


	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
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

	public Long getId() {
		return Id;
	}
    
	public String getIdChotiWali() {
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


	public void setAnomaly(Integer anomaly) {
		this.anomaly = anomaly;
	}


}
