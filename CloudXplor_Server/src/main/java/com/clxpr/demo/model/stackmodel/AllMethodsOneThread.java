package com.clxpr.demo.model.stackmodel;

import java.util.ArrayList;

public class AllMethodsOneThread {

	private int id;
	private ArrayList <String> method;
	private ArrayList <String> className;
	private ArrayList <String> fileName;
	private ArrayList <String> lineNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<String> getMethod() {
		return method;
	}
	public void setMethod(ArrayList<String> method) {
		this.method = method;
	}
	public ArrayList<String> getClassName() {
		return className;
	}
	public void setClassName(ArrayList<String> className) {
		this.className = className;
	}
	public ArrayList<String> getFileName() {
		return fileName;
	}
	public void setFileName(ArrayList<String> fileName) {
		this.fileName = fileName;
	}
	public ArrayList<String> getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(ArrayList<String> lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	
}
