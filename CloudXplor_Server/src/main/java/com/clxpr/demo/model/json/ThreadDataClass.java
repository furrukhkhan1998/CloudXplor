package com.clxpr.demo.model.json;

import com.clxpr.demo.model.threadmodel.BlockedCount;
import com.clxpr.demo.model.threadmodel.CpuTimeForThread;
import com.clxpr.demo.model.threadmodel.LockedResource;
import com.clxpr.demo.model.threadmodel.PriorityAndStateThread;
import com.clxpr.demo.model.threadmodel.UserTimeForThread;
import com.clxpr.demo.model.threadmodel.WaitCount;

public class ThreadDataClass {
	
	private BlockedCount bc;
	private CpuTimeForThread cpu;
	private LockedResource lr;
	private PriorityAndStateThread ps;
	private UserTimeForThread usr;
	private WaitCount wc;
	
	ThreadDataClass() {}
	
	public ThreadDataClass(BlockedCount bc, CpuTimeForThread cpu, LockedResource lr, PriorityAndStateThread ps, UserTimeForThread usr, WaitCount wc) {
		this.bc = bc;
		this.cpu = cpu;
		this.lr = lr;
		this.ps = ps;
		this.usr = usr;
		this.wc = wc;
	}

	public BlockedCount getBc() {
		return bc;
	}

	public void setBc(BlockedCount bc) {
		this.bc = bc;
	}

	public CpuTimeForThread getCpu() {
		return cpu;
	}

	public void setCpu(CpuTimeForThread cpu) {
		this.cpu = cpu;
	}

	public LockedResource getLr() {
		return lr;
	}

	public void setLr(LockedResource lr) {
		this.lr = lr;
	}

	public PriorityAndStateThread getPs() {
		return ps;
	}

	public void setPs(PriorityAndStateThread ps) {
		this.ps = ps;
	}

	public UserTimeForThread getUsr() {
		return usr;
	}

	public void setUsr(UserTimeForThread usr) {
		this.usr = usr;
	}

	public WaitCount getWc() {
		return wc;
	}

	public void setWc(WaitCount wc) {
		this.wc = wc;
	}

}
