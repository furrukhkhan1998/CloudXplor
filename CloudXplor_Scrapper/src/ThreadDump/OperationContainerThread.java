package ThreadDump;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ThreadInfo;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class OperationContainerThread {
	
	private CreateDump dump;
	private String filename;
	
	public OperationContainerThread() {
		this.dump = new CreateDump();
	}
	
	public void getBlockedCount(BufferedWriter bw) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			this.filename = "ThreadDump-" + formatter.format(date) + ".txt";
			bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		}
		bw.write("===================================== Blocked Count ===========================================\n");
		for (int i = 0; i < this.dump.getThreadInfos().size(); i++) {
			bw.write(this.dump.getThreadInfos().get(i).getThreadId() + ": " + this.dump.getThreadInfos().get(i).getBlockedCount() + "\n");
		}
		bw.write("===================================== Blocked Count ===========================================\n");
	}
	
	public void getWaitCount(BufferedWriter bw) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			this.filename = "ThreadDump-" + formatter.format(date) + ".txt";
			bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		}
		bw.write("===================================== Wait Count ===========================================\n");
		for (int i = 0; i < this.dump.getThreadInfos().size(); i++) {
			bw.write(this.dump.getThreadInfos().get(i).getThreadId() + ": " + this.dump.getThreadInfos().get(i).getWaitedCount() + "\n");
		}
		bw.write("===================================== Wait Count ===========================================\n");
	}
	
	public void getBlockedTime(BufferedWriter bw) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			this.filename = "ThreadDump-" + formatter.format(date) + ".txt";
			bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		}
		bw.write("===================================== Blocked Time ===========================================\n");
		for (int i = 0; i < this.dump.getThreadInfos().size(); i++) {
			bw.write(this.dump.getThreadInfos().get(i).getThreadId() + ": " + this.dump.getThreadInfos().get(i).getBlockedTime() + "\n");
		}
		bw.write("===================================== Blocked Time ===========================================\n");
	}
	
	public void getWaitTime(BufferedWriter bw) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			this.filename = "ThreadDump-" + formatter.format(date) + ".txt";
			bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		}
		bw.write("===================================== Wait Time ===========================================");
		for (int i = 0; i < this.dump.getThreadInfos().size(); i++) {
			bw.write(this.dump.getThreadInfos().get(i).getThreadId() + ": " + this.dump.getThreadInfos().get(i).getWaitedTime() + "\n");
		}
		bw.write("===================================== Wait Time ===========================================");
	}
	
	public void getBlockerThreadId(BufferedWriter bw, Long id) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			this.filename = "ThreadDump-" + formatter.format(date) + ".txt";
			bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		}
		bw.write("===================================== Thread " + id + " blocker ===========================================\n");
		for (int i = 0; i < this.dump.getThreadInfos().size(); i++) {
			if (this.dump.getThreadInfos().get(i).getThreadId() == id) {
				if (this.dump.getThreadInfos().get(i).getLockOwnerId() != -1) {
					bw.write("Thread " + this.dump.getThreadInfos().get(i).getLockOwnerId() + " is blocking this thread.\n");
				} else {
					bw.write("The thread is not blocked.\n");
				}
			}
		}
		bw.write("===================================== Thread " + id + " blocker ===========================================\n");
	}
	
	public void getCpuTimeOnethread(BufferedWriter bw, Long id) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			this.filename = "ThreadDump-" + formatter.format(date) + ".txt";
			bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		}
		bw.write("===================================== Cpu Time For Thread " + id + " ===========================================\n");
		for (int i = 0; i < this.dump.getThreadInfos().size(); i++) {
			if (this.dump.getThreadInfos().get(i).getThreadId() == id) {
				bw.write(Long.toString(this.dump.getCpuTime().get(i)) + " nanoseconds.\n");
			}
		}
		bw.write("===================================== Cpu Time For Thread " + id + " ===========================================\n");
	}
	
	public void getUserTimeOnethread(BufferedWriter bw, Long id) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			this.filename = "ThreadDump-" + formatter.format(date) + ".txt";
			bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		}
		bw.write("===================================== User Time For Thread " + id + " ===========================================\n");
		for (int i = 0; i < this.dump.getThreadInfos().size(); i++) {
			if (this.dump.getThreadInfos().get(i).getThreadId() == id) {
				bw.write(Long.toString(this.dump.getUserTime().get(i)) + " nanoseconds.\n");
			}
		}
		bw.write("===================================== User Time For Thread " + id + " ===========================================\n");
	}
	
	public void getAllThreads(BufferedWriter bw) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			this.filename = "ThreadDump-" + formatter.format(date) + ".txt";
			bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		}
		bw.write("===================================== All Thread Ids ===========================================\n");
		for (int i = 0; i < this.dump.getThreadInfos().size(); i++)
			bw.write("[" + this.dump.getThreadInfos().get(i).getThreadId() + "] ");
		bw.write("\n===================================== All Thread Ids ===========================================\n");
	}
	
	public void getLockedResources(BufferedWriter bw) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			this.filename = "ThreadDump-" + formatter.format(date) + ".txt";
			bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		}
		bw.write("===================================== Locked Resources ===========================================\n");
		for (int i = 0; i < this.dump.getThreadInfos().size(); i++) {
			bw.write("Thread " + this.dump.getThreadInfos().get(i).getThreadId() + "\n" + "             ");
			if (this.dump.getThreadInfos().get(i).getLockedMonitors().length == 0) {
				bw.write("None\n");
			} else {
				for (int j = 0; j < this.dump.getThreadInfos().get(i).getLockedMonitors().length; j++) {
					bw.write(this.dump.getThreadInfos().get(i).getLockedMonitors()[j].getClassName() + " ");
				}
				bw.write("\n");
			}
		}
		bw.write("===================================== Locked Resources ===========================================\n");
	}
	
	public void getPriorityAndStates(BufferedWriter bw) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			this.filename = "ThreadDump-" + formatter.format(date) + ".txt";
			bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		}
		bw.write("===================================== Priority and State ===========================================\n");
		for (int i = 0; i < this.dump.getThreadInfos().size(); i++) {
			ThreadInfo info = this.dump.getThreadInfos().get(i);
			bw.write("Thread ID: " + info.getThreadId() + " State: " + info.getThreadState().name() + " Priority: " + info.getPriority() + "\n");
		}
		bw.write("===================================== Priority and State ===========================================\n");
	}
	
	public void getAll() throws IOException {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date = new Date(System.currentTimeMillis());
		this.filename = "ThreadDump-" + formatter.format(date) + ".txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		//this.getAllThreads(bw);
		this.getPriorityAndStates(bw);
		for (int i = 0; i < this.dump.getThreadInfos().size(); i++)
			this.getCpuTimeOnethread(bw, this.dump.getThreadInfos().get(i).getThreadId());
		for (int i = 0; i < this.dump.getThreadInfos().size(); i++)
			this.getUserTimeOnethread(bw, this.dump.getThreadInfos().get(i).getThreadId());
		this.getLockedResources(bw);
		this.getBlockedCount(bw);
		//this.getBlockedTime(bw);
		//for (int i = 0; i < this.dump.getThreadInfos().size(); i++)
		//	this.getBlockerThreadId(bw, this.dump.getThreadInfos().get(i).getThreadId());
		this.getWaitCount(bw);
		//this.getWaitTime(bw);
		bw.close();
		
	}
	
	public String getFileName() {
		return this.filename;
	}
	
}
