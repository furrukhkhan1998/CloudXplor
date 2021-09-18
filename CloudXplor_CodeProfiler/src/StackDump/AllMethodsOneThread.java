package StackDump;

import java.util.ArrayList;

class AllMethodsOneThread {

	
	private ArrayList <Method> methods;

	AllMethodsOneThread(Thread thread) {
		this.methods = new ArrayList <Method> ();
		StackTraceElement[] stack = Thread.getAllStackTraces().get(thread);
		for (int j = 0; j < stack.length; j++) {
			methods.add(new Method(stack[j].getMethodName(), stack[j].getLineNumber(), stack[j].getFileName(), stack[j].getClassName()));
		}
	}
	
	public ArrayList <Method> getMethods() {
		return this.methods;
	}
}
