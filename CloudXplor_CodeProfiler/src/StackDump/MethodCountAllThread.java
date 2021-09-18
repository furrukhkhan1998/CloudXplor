package StackDump;

import java.util.Map;

class MethodCountAllThread {
	
	private int count;
	
	public MethodCountAllThread() {
		this.count = 0;
		Map<Thread, StackTraceElement[]> all = Thread.getAllStackTraces();
		for (Thread key : all.keySet()) {
			this.count = this.count + all.get(key).length;
		}
	}
	
	public int getCount() {
		return this.count;
	}

}
