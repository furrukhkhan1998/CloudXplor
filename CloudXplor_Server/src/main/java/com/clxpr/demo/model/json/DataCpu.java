package com.clxpr.demo.model.json;



public class DataCpu { //model class for cpu stats that is used to store data in json format for web application

	
		
		public DataCpu(String userId,String machineId,int occurance, String time, String cpu, String usr, String nice, String sys, String ioWait, String irq, String soft,
			String steal, String guest, String gnice, String idle, String anomaly, Long Id) {
			super();
			this.occurance = occurance;
			this.time = time;
			this.cpu = cpu;
			this.usr = usr;
			this.nice = nice;
			this.sys = sys;
			this.ioWait = ioWait;
			this.irq = irq;
			this.soft = soft;
			this.steal = steal;
			this.guest = guest;
			this.gnice = gnice;
			this.idle = idle;
			this.Id = Id;
			this.machineId = machineId;
			this.userId = userId;
			this.setAnomaly(anomaly);
		}


		private int occurance;
		private String time;
		private String cpu;
		private String usr;
		private String nice;
		private String sys;
		private String ioWait;
		private String irq;
		private String soft;
		private String machineId;
		private String userId;
		private String anomaly;
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


		private String steal;
		private String guest;
		private String gnice;
		private String idle;
		private Long Id;
		

		
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

