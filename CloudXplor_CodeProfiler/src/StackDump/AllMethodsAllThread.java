package StackDump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class AllMethodsAllThread {
	
	private HashMap <Thread, ArrayList <Method> > map;
	
	public AllMethodsAllThread() {
		this.map = new HashMap <Thread, ArrayList <Method>> ();
		Map<Thread, StackTraceElement[]> all = (HashMap <Thread, StackTraceElement[]>)Thread.getAllStackTraces();
		Object[] keys = all.keySet().toArray();
		for (int i = 0; i < keys.length; i++) {
			StackTraceElement[] stack = all.get(keys[i]);
			ArrayList <Method> methods = new ArrayList <Method> ();
			for (int j = 0; j < stack.length; j++) {
				methods.add(new Method(stack[j].getMethodName(), stack[j].getLineNumber(), stack[j].getFileName(), stack[j].getClassName()));
			}
			map.put((Thread) keys[i], methods);
		}
	}
	
	public HashMap <Thread, ArrayList <Method>> getMap() {
		return this.map;
	}

}
