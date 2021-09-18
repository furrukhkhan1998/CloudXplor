package com.clxpr.demo.model.json;



public class DataHeap { //model class for cpu stats that is used to store data in json format for web application

	
		
		public DataHeap(String userId, int occurance, String machineId, String instance, String memory, String className, Long Id) {
			super();
			this.userId = userId;
			this.occurance = occurance;
			this.instance = instance;
			this.memory = memory;
			this.className = className;
			this.machineId = machineId;
			this.Id = Id;
		}


		private String userId;
		private int occurance;
		private String instance;
		private String memory;
		private String className;
		private Long Id;
		private String machineId;
		
		public String getUserID() {
			return this.userId;
		}
		
		public void setUserId(String id) {
			this.userId = id;
		}
		
		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			this.Id = id;
		}

		public int getOccurance() {
			return occurance;
		}

		public void setOccurance(int occurance) {
			this.occurance = occurance;
		}

		public String getInstance() {
			return instance;
		}

		public void setInstance(String instance) {
			this.instance = instance;
		}

		public String getMemory() {
			return memory;
		}

		public void setMemory(String memory) {
			this.memory = memory;
		}

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}

		public String getUserId() {
			return userId;
		}

		
		public void setMachineId(String id) {
			this.machineId = id;
		}

		public String getMachineId() {
			return this.machineId;
		}

		
		
		
	}

