package com.clxpr.demo.model.json;



public class DataHeapDump { //model class for cpu stats that is used to store data in json format for web application

	
		
		public DataHeapDump(String userId, String machineId, int occurance, Long Id, int part, String type, String output) {
			super();
			this.userId = userId;
			this.occurance = occurance;
			this.machineId = machineId;
			this.type = type;
			this.typeOutput = output;
			this.part = part;
			this.Id = Id;
		}


		

		private Long Id;
		private String userId;
		private int occurance;
		private int part;
		private String type;
		private String typeOutput;
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
		public void setUserId(String userId) {
			this.userId = userId;
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

