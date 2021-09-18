package com.clxpr.demo.model.json;

import com.clxpr.demo.model.heapdumpmodel.AllClasses;
import com.clxpr.demo.model.heapdumpmodel.ClassInstance;
import com.clxpr.demo.model.heapdumpmodel.ClassMemory;
import com.clxpr.demo.model.heapdumpmodel.TotalClasses;
import com.clxpr.demo.model.heapdumpmodel.TotalInstances;
import com.clxpr.demo.model.heapdumpmodel.TotalMemoryUsed;

public class HeapDumpDataClass {
	
	private AllClasses ac;
	private ClassInstance ci;
	private ClassMemory cm;
	private TotalClasses tc;
	private TotalInstances ti;
	private TotalMemoryUsed tmu;
	
	public HeapDumpDataClass() {}
	
	public HeapDumpDataClass(AllClasses ac, ClassInstance ci, ClassMemory cm, TotalClasses tc, TotalInstances ti, TotalMemoryUsed tmu) {
		this.ac = ac;
		this.ci = ci;
		this.cm = cm;
		this.tc = tc;
		this.ti = ti;
		this.tmu = tmu;
	}

	public AllClasses getAc() {
		return ac;
	}

	public void setAc(AllClasses ac) {
		this.ac = ac;
	}

	public ClassInstance getCi() {
		return ci;
	}

	public void setCi(ClassInstance ci) {
		this.ci = ci;
	}

	public ClassMemory getCm() {
		return cm;
	}

	public void setCm(ClassMemory cm) {
		this.cm = cm;
	}

	public TotalClasses getTc() {
		return tc;
	}

	public void setTc(TotalClasses tc) {
		this.tc = tc;
	}

	public TotalInstances getTi() {
		return ti;
	}

	public void setTi(TotalInstances ti) {
		this.ti = ti;
	}

	public TotalMemoryUsed getTmu() {
		return tmu;
	}

	public void setTmu(TotalMemoryUsed tmu) {
		this.tmu = tmu;
	}

}
