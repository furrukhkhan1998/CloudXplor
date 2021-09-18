package StackDump;

class MethodCountOneThread {

	int count;
	
	public MethodCountOneThread(Thread thread, String name) {
		
		this.count = 0;
		StackTraceElement[] stack = thread.getStackTrace();
		for (int i = 0; i < stack.length; i++) {
			if (stack[i].getMethodName().contains(name)) {
				this.count++;
			}
		}
	}
	
	public int getCount() {
		return this.count;
	}
	
}
