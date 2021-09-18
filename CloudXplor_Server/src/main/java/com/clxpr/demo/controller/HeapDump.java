package com.clxpr.demo.controller;

import java.util.ArrayList;
import java.util.Collection;

import com.clxpr.demo.model.json.DataHeapDump;


public class HeapDump {
	
	public class AC {
		public String type;
		public ArrayList <String> classes;
		
		public AC(String type) {
			this.type = type;
			this.classes = new ArrayList <String> ();
		}
		
		void add(String output) {
			this.classes.add(output);
		}
	}
	
	public class TI {
		public String type;
		public String totalInstances;
		
		public TI(String type, String output) {
			this.totalInstances = output;
			this.type = type;
		}
	}
	
	public class SI {
		public String type;
		public String instances;
		
		public SI(String type, String output) {
			this.type = type;
			this.instances = output;
		}
	}
	
	public class TC {
		public String type;
		public String total;
		
		public TC(String type, String output) {
			this.total = output;
			this.type = type;
		}
	}
	
	public class TM {
		public String type;
		public String memory;
		
		public TM(String type, String output) {
			this.type = type;
			this.memory = output;
		}
	}
	
	public class SM {
		public String type;
		public String memory;
		
		public SM(String type, String output) {
			this.type = type;
			this.memory = output;
		}
	}
	
	public ArrayList <Object> getHeapDumpObjects(ArrayList <DataHeapDump> data) {
		ArrayList <Object> objects = new ArrayList <Object> ();
		ArrayList <String> allClasses = new ArrayList <String> ();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getType().contains("All Classes")) {
				allClasses.add(data.get(i).getTypeOutput());
			} else if (data.get(i).getType().contains("Total Instances")) {
				objects.add(new TI(data.get(i).getType(), data.get(i).getTypeOutput()));
			} else if (data.get(i).getType().contains("Instances") == true && data.get(i).getType().contains("Total") == false) {
				objects.add(new SI(data.get(i).getType(), data.get(i).getTypeOutput()));
			} else if (data.get(i).getType().contains("Total Classes")) {
				objects.add(new TC(data.get(i).getType(), data.get(i).getTypeOutput()));
			} else if (data.get(i).getType().contains("Total Memory Used (Bytes)")) {
				objects.add(new TM(data.get(i).getType(), data.get(i).getTypeOutput()));
			} else if (data.get(i).getType().contains("Memory") == true && data.get(i).getType().contains("Total Memory Used (Bytes)") == false) {
				objects.add(new SM(data.get(i).getType(), data.get(i).getTypeOutput()));
			}
		}
		AC ac = new AC("All Classes");
		for (int i = 0; i < allClasses.size(); i++) {
			ac.add(allClasses.get(i));
		}
		if (ac.classes.size() != 0) {
			objects.add(ac);
		}
		return objects;
	}

}
