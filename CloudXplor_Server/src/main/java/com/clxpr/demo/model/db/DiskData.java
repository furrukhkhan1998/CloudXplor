package com.clxpr.demo.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DiskData { // model class for disk stats that is used to store data in database
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;
	@Column(name="occurance")
	private int occurance;
	@Column(name="machineId")
	private String machineId;
	@Column(name="userId")
	private String userId;
	@Column(name="loop_col")
	private String loop;
	@Column(name="total_col")
	private String total;
	@Column(name="merged_col")
	private String merged;
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


	@Column(name="sectors_col")
	private String sectors;
	@Column(name="ms_col")
	private String ms_col;
	@Column(name="tota_col")
	private String tota;
	@Column(name="merged2_col")
	private String merged2;
	@Column(name="sectors2_col")
	private String sectors2;
	@Column(name="ms2_col")
	private String ms2;
	@Column(name="cur_col")
	private String cur;
	@Column(name="sec_col")
	private String sec;
	
	public DiskData() {}


	
	public int getOccurance() {
		return occurance;
	}



	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}



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
		return ms_col;
	}

	public void setMs(String ms) {
		this.ms_col = ms;
	}

	public String getTota() {
		return tota;
	}

	public void setTota(String tota) {
		this.tota = tota;
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


	public String getMs_col() {
		return ms_col;
	}


	public void setMs_col(String ms_col) {
		this.ms_col = ms_col;
	}

	
	

	
}
