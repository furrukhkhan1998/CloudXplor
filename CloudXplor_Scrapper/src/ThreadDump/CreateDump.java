package ThreadDump;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.HashMap;

class CreateDump {
	
	private HashMap <Long, ThreadInfo> info;
	private ArrayList <Long> cpuTime;
	private ArrayList <Long> userTime;
	private ArrayList <ThreadInfo> threads;
	
	public CreateDump() {
		this.info = new HashMap <Long, ThreadInfo> ();
		ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] all = threadBean.dumpAllThreads(true, true);
		this.cpuTime = new ArrayList <Long> ();
		this.userTime = new ArrayList <Long> ();
		this.threads = new ArrayList <ThreadInfo> ();
		for (int i = 0; i < all.length; i++) {
			this.info.put(all[i].getThreadId(), all[i]);
			this.cpuTime.add(threadBean.getThreadCpuTime(all[i].getThreadId()));
			this.userTime.add(threadBean.getThreadUserTime(all[i].getThreadId()));
			this.threads.add(all[i]);
		}
	}
	
	public ThreadInfo getThreadInfo(long id) {
		return this.info.get(id);
	}
	
	public ArrayList <Long> getCpuTime() {
		return this.cpuTime;
	}
	
	public ArrayList <Long> getUserTime() {
		return this.userTime;
	}
	
	public ArrayList <ThreadInfo> getThreadInfos() {
		return this.threads;
	}

	public int indexOfThreadID(Long id) {
		for (int i = 0; i < this.threads.size(); i++)
			if (this.threads.get(i).getThreadId() == id)
				return i;
		return -1;
	}

}
