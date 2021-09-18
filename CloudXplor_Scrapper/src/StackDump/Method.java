package StackDump;

class Method {
	
	String name;
	int lineNum;
	String fileName;
	String caller;
	
	Method(String n, int l, String f, String c) {
		this.name = n;
		this.lineNum = l;
		this.fileName = f;
		this.caller = c;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLine() {
		return this.lineNum;
	}
	
	public String getFile() {
		return this.fileName;
	}
	
	public String getCaller() {
		return this.caller;
	}
	
	public String toString() {
		if (this.lineNum < 1) {
			return this.name + " called by the class: " + this.caller + " of file: " + this.fileName;
		}
		return this.name + " called by the class: " + this.caller + " on line number: " + this.lineNum + " of file: " + this.fileName;
	}
	
	

}
