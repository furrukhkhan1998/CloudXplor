package com.clxpr.demo.model.json;

import com.clxpr.demo.model.stackmodel.AllMethodsAllThread;
import com.clxpr.demo.model.stackmodel.AllMethodsCount;
import com.clxpr.demo.model.stackmodel.AllMethodsOneThread;
import com.clxpr.demo.model.stackmodel.MethodCount;

public class StackDumpDataClass {
	private AllMethodsAllThread amat;
	private AllMethodsCount amc;
	private AllMethodsOneThread amot;
	private MethodCount mc;
	
	public StackDumpDataClass(){
		
	}

	public StackDumpDataClass(AllMethodsAllThread amat, AllMethodsCount amc, AllMethodsOneThread amot,
			MethodCount mc) {
		// TODO Auto-generated constructor stub
	this.amat=amat;
	this.amc=amc;
	this.amot=amot;
	this.mc =mc;
	}

	public AllMethodsAllThread getAmat() {
		return amat;
	}

	public void setAmat(AllMethodsAllThread amat) {
		this.amat = amat;
	}

	public AllMethodsCount getAmc() {
		return amc;
	}

	public void setAmc(AllMethodsCount amc) {
		this.amc = amc;
	}

	public AllMethodsOneThread getAmot() {
		return amot;
	}

	public void setAmot(AllMethodsOneThread amot) {
		this.amot = amot;
	}

	public MethodCount getMc() {
		return mc;
	}

	public void setMc(MethodCount mc) {
		this.mc = mc;
	}

	
	
}
