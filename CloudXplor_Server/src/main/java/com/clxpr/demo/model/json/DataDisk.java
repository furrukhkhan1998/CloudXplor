package com.clxpr.demo.model.json;

public class DataDisk { //model class for disk stats that is used to store data in json format for web application
	
	public DataDisk(String userId,String machineId,int occurance, String loop, String total, String merged, String sectors, String ms, String total2, String merged2,
			String sectors2, String ms2, String cur, String sec, Long Id) {
		super();
		this.occurance = occurance;
		this.loop = loop;
		this.total = total;
		this.merged = merged;
		this.sectors = sectors;
		this.ms = ms;
		this.total2 = total2;
		this.merged2 = merged2;
		this.sectors2 = sectors2;
		this.ms2 = ms2;
		this.cur = cur;
		this.sec = sec;
		this.Id = Id;
		this.machineId = machineId;
		this.userId = userId;
		
	}
	private int occurance;
	private String machineId;
	private String userId;
	private String loop;
	private String total;
	private String merged;
	private String sectors;
	private String ms;
	private String total2;
	private String merged2;
	private String sectors2;
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

	public String getTotal2() {
		return total2;
	}

	public void setTotal2(String total2) {
		this.total2 = total2;
	}
	private String ms2;
	private String cur;
	private String sec;
	private Long Id;
	

	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getLoop() {
		return loop;
	}

	public void setLoop(String loop) {
		this.loop = loop;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getMerged() {
		return merged;
	}

	public void setMerged(String merged) {
		this.merged = merged;
	}

	public String getSectors() {
		return sectors;
	}

	public void setSectors(String sectors) {
		this.sectors = sectors;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getTota() {
		return total2;
	}

	public void setTota(String tota) {
		this.total2 = tota;
	}

	public String getMerged2() {
		return merged2;
	}

	public void setMerged2(String merged2) {
		this.merged2 = merged2;
	}

	public String getSectors2() {
		return sectors2;
	}

	public void setSectors2(String sectors2) {
		this.sectors2 = sectors2;
	}

	public String getMs2() {
		return ms2;
	}

	public void setMs2(String ms2) {
		this.ms2 = ms2;
	}

	public String getCur() {
		return cur;
	}

	public void setCur(String cur) {
		this.cur = cur;
	}

	public String getSec() {
		return sec;
	}

	public void setSec(String sec) {
		this.sec = sec;
	}

}
