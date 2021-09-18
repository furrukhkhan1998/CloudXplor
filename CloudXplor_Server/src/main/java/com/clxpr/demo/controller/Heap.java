package com.clxpr.demo.controller;

import java.util.ArrayList;

import com.clxpr.demo.model.json.DataHeap;

public class Heap {
	
	public class JavaClass {
		public String instances;
		public String memory;
		public String name;
		
		public JavaClass(String i, String m, String n){
			this.name = n;
			this.instances = i;
			this.memory = m;
		}
	}
	
	public ArrayList <JavaClass> getHeapObjects(ArrayList <DataHeap> data) {
		ArrayList <JavaClass> objects = new ArrayList <JavaClass> ();
		
		for (int i = 0; i < data.size(); i++) {
			objects.add(new JavaClass(data.get(i).getInstance(), data.get(i).getMemory(), data.get(i).getClassName()));
		}
		
		return objects;
	}

}
