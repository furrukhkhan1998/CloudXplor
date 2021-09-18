package com.clxpr.demo.model.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CpuData")
public class CpuData { // model class for cpu stats that is used to store data in database
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;
	private int occurance;
	private String machineId;
	private String userId;
	private String time;
	private String cpu;
	private String usr;
	private String nice;
	private String sys;
	private String ioWait;
	private String irq;
	private String soft;
	private String steal;
	private String guest;
	private String gnice;
	private String idle;
	private String anomaly;
	
	
	
	public CpuData() {}


	
	
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

	public String getCpu() {
		return cpu;
	}
	
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getUsr() {
		return usr;
	}



	public void setUsr(String usr) {
		this.usr = usr;
	}



	public String getNice() {
		return nice;
	}



	public void setNice(String nice) {
		this.nice = nice;
	}



	public String getSys() {
		return sys;
	}



	public void setSys(String sys) {
		this.sys = sys;
	}



	public String getIoWait() {
		return ioWait;
	}



	public void setIoWait(String ioWait) {
		this.ioWait = ioWait;
	}



	public String getIrq() {
		return irq;
	}



	public void setIrq(String irq) {
		this.irq = irq;
	}



	public String getSoft() {
		return soft;
	}



	public void setSoft(String soft) {
		this.soft = soft;
	}



	public String getSteal() {
		return steal;
	}



	public void setSteal(String steal) {
		this.steal = steal;
	}



	public String getGuest() {
		return guest;
	}



	public void setGuest(String guest) {
		this.guest = guest;
	}



	public String getGnice() {
		return gnice;
	}



	public void setGnice(String gnice) {
		this.gnice = gnice;
	}



	public String getIdle() {
		return idle;
	}



	public void setIdle(String idle) {
		this.idle = idle;
	}




	public String getAnomaly() {
		return anomaly;
	}




	public void setAnomaly(String anomaly) {
		this.anomaly = anomaly;
	}
	
	
	
	
}
