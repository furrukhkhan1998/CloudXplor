package com.clxpr.demo.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IoData")
public class IoData { // model class for io stats that is used to store data in database
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Id")
	private Long Id;
	@Column(name="occurance")
	private int occurance;
	@Column(name="machineId")
	private String machineId;
	@Column(name="userId")
	private String userId;
	@Column(name="device_col")
	private String device;
	@Column(name="tps_col")
	private String tps;
	@Column(name="read_speed_col")
	private String readSpeed;
	@Column(name="write_speed_col")
	private String writeSpeed;
	@Column(name="read_col")
	private String read;
	@Column(name="write_col")
	private String write;
	
	public IoData() {}


	
	
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




	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}
	
	
	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getTps() {
		return tps;
	}

	public void setTps(String tps) {
		this.tps = tps;
	}

	public String getReadSpeed() {
		return readSpeed;
	}

	public void setReadSpeed(String readSpeed) {
		this.readSpeed = readSpeed;
	}

	public String getWriteSpeed() {
		return writeSpeed;
	}

	public void setWriteSpeed(String writeSpeed) {
		this.writeSpeed = writeSpeed;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	
	
	

	
}
