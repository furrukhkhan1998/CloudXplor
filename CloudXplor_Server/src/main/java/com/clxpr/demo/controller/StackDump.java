package com.clxpr.demo.controller;

import java.util.ArrayList;

import com.clxpr.demo.model.json.DataStack;

public class StackDump {
	
	
	public class SingleThread {
		public String id;
		public String className;
		public String methodName;
		public String line;
		public String fileName;
		
		public SingleThread(String type) {
			String[] arr = type.split(" ");
			this.id = arr[4];
		}
		
		public SingleThread() {}
		public void addOutput(String output) {
			String[] arr = output.split(" ");
			ArrayList <String> arr2 = new ArrayList <String> ();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].length() != 0)
					arr2.add(arr[i]);
			}
			if (arr2.size() == 9) {
				this.line = "N/A";
				this.methodName = arr2.get(0);
				this.className = arr2.get(5);
				this.fileName = arr2.get(8);
			} else {
				this.methodName = arr2.get(0);
				this.className = arr2.get(5);
				this.line = arr2.get(9);
				this.fileName = arr2.get(12);
			}
		}
		
	}
	
	public class AllThread {
		public ArrayList <String> ids;
		public ArrayList <String> methods;
		public ArrayList <String> caller;
		public ArrayList <String> line;
		public ArrayList <String> file;
		
		public AllThread(ArrayList <String> outputs) {
			SingleThread st = new SingleThread();
			ids = new ArrayList <String> ();
			methods = new ArrayList <String> ();
			caller = new ArrayList <String> ();
			line = new ArrayList <String> ();
			file = new ArrayList <String> ();
			String id = "";
			for (int i = 0; i < outputs.size(); i++) {
				if (outputs.get(i).contains("Thread ID: ")) {
					String[] arr = outputs.get(i).split(" ");
					id = arr[2];
				} else {
					st.addOutput(outputs.get(i));
					ids.add(id);
					methods.add(st.methodName);
					caller.add(st.className);
					line.add(st.line);
					file.add(st.fileName);
				}
			}
		}
	}
	
	
	public class AMC {
		public String count;
		public String type;
		public AMC(String type, String output) {
			this.count = output;
			this.type = type;
		}
	}
	
	public class MC {
		public String name;
		public String count;
		public String type;
		
		public MC(String type, String output) {
			this.type = "Method Count";
			this.count = output;
			this.name = type;
		}
	}
	
	
	public ArrayList <Object> getStackObjects(ArrayList <DataStack> data) {
		ArrayList <Object> objects = new ArrayList <Object> ();
		ArrayList <String> outputs = new ArrayList <String> ();
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getType().contains("All Methods for thread")) {
				SingleThread st = new SingleThread(data.get(i).getType());
				st.addOutput(data.get(i).getTypeOutput());
				objects.add(st);
			} else if (data.get(i).getType().contains("All Methods All Threads")) {
				outputs.add(data.get(i).getTypeOutput());
			} else if (data.get(i).getType().contains("All Methods Count")) {
				objects.add(new AMC(data.get(i).getType(), data.get(i).getTypeOutput()));
			} else if (data.get(i).getType().split(" ").length == 1) {
				objects.add(new MC(data.get(i).getType(), data.get(i).getTypeOutput()));
			}
		}
		AllThread at = new AllThread(outputs);
		objects.add(at);
		return objects;
	}
	
	
	

}
