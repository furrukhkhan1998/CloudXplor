package com.clxpr.demo.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PidData")
public class PidData { // model class for pid stats that is used to store data in database
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;
	@Column(name="occurance")
	private int occurance;
	@Column(name="machineId")
	private String machineId;
	@Column(name="userId")
	private String userId;
	@Column(name="time_col")
	private String time;
	@Column(name="uid_col")
	private String uid;
	@Column(name="pid_col")
	private String pid;
	@Column(name="usr_col")
	private String usr;
	@Column(name="system_col")
	private String system;
	@Column(name="guest_col")
	private String guest;
	@Column(name="wait_col")
	private String wait;
	@Column(name="cput_col")
	private String cpu;
	@Column(name="cpuNo_col")
	private String cpuNo;
	@Column(name="cmd_col")
	private String cmd;

	
	public PidData() {}


	
	
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




	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}
	
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public String getWait() {
		return wait;
	}

	public void setWait(String wait) {
		this.wait = wait;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getCpuNo() {
		return cpuNo;
	}

	public void setCpuNo(String cpuNo) {
		this.cpuNo = cpuNo;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	
}
