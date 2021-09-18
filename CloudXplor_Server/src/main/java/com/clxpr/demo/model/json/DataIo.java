package com.clxpr.demo.model.json;

public class DataIo { //model class for io stats that is used to store data in json format for web application
	
	public DataIo(String userId,String machineId,int occurance, String device, String tps, String readSpeed, String writeSpeed, String read, String write, Long Id) {
		super();
		this.occurance = occurance;
		this.device_col = device;
		this.tps_col = tps;
		this.readSpeed_col = readSpeed;
		this.writeSpeed_col = writeSpeed;
		this.read_col = read;
		this.write_col = write;
		this.machineId = machineId;
		this.userId = userId;
	}
	private int occurance;
	private String device_col;
	private String tps_col;
	private String readSpeed_col;
	private String writeSpeed_col;
	private String machineId, userId;
	public int getOccurance() {
		return occurance;
	}
	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}
	private String read_col;
	private String write_col;
	private Long Id;
	

	
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
	public String getDevice_col() {
		return device_col;
	}
	public void setDevice_col(String device_col) {
		this.device_col = device_col;
	}
	public String getTps_col() {
		return tps_col;
	}
	public void setTps_col(String tps_col) {
		this.tps_col = tps_col;
	}
	public String getReadSpeed_col() {
		return readSpeed_col;
	}
	public void setReadSpeed_col(String readSpeed_col) {
		this.readSpeed_col = readSpeed_col;
	}
	public String getWriteSpeed_col() {
		return writeSpeed_col;
	}
	public void setWriteSpeed_col(String writeSpeed_col) {
		this.writeSpeed_col = writeSpeed_col;
	}
	public String getRead_col() {
		return read_col;
	}
	public void setRead_col(String read_col) {
		this.read_col = read_col;
	}
	public String getWrite_col() {
		return write_col;
	}
	public void setWrite_col(String write_col) {
		this.write_col = write_col;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	
	
}
