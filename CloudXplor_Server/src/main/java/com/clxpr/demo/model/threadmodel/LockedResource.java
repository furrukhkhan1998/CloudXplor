package com.clxpr.demo.model.threadmodel;

import java.util.ArrayList;

public class LockedResource {
	
	private ArrayList <String> thread;
	private ArrayList <ArrayList <String>> monitors;
	public ArrayList<String> getThread() {
		return thread;
	}
	public void setThread(ArrayList<String> thread) {
		this.thread = thread;
	}
	public ArrayList<ArrayList<String>> getMonitors() {
		return monitors;
	}
	public void setMonitors(ArrayList<ArrayList<String>> monitors) {
		this.monitors = monitors;
	}
	

	
}
