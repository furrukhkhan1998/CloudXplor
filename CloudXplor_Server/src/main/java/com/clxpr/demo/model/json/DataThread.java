package com.clxpr.demo.model.json;

public class DataThread {

	public DataThread(String userId, int occurance, String mId, String type, String output, int part, Long Id) {
		super();
		this.userId = userId;
		this.occurance = occurance;
		this.type = type;
		this.typeOutput = output;
		this.Id = Id;
		this.machineId = mId;
		this.part = part;
	}
	
	private Long Id;
	private String userId;
	private int occurance;
	private String type;
	private String typeOutput;
	private int part;
	private String machineId;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String usrId) {
		this.userId = usrId;
	}
	public int getOccurance() {
		return occurance;
	}
	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeOutput() {
		return typeOutput;
	}
	public void setTypeOutput(String typeOutput) {
		this.typeOutput = typeOutput;
	}
	public int getPart() {
		return part;
	}
	public void setPart(int part) {
		this.part = part;
	}
	public void setMachineId(String id) {
		this.machineId = id;
	}

	public String getMachineId() {
		return this.machineId;
	}

	
}
