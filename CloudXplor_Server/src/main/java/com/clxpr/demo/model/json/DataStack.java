package com.clxpr.demo.model.json;

public class DataStack {

	public DataStack(String userId, String mId, int o, String t, String to, int part, Long Id) {
		super();
		this.userId = userId;
		this.type = t;
		this.typeOutput = to;
		this.occurance = o;
		this.part = part;
		this.Id = Id;
		this.machineId = mId;
	}
	
	private Long Id;
	private String userId;
	private String type;
	private String typeOutput;
	private int part;
	private int occurance;
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
	public void setUsrId(String usrId) {
		this.userId = usrId;
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
	public int getOccurance() {
		return occurance;
	}
	public void setOccurance(int occurance) {
		this.occurance = occurance;
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
