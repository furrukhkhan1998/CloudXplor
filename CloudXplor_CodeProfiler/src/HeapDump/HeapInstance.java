package HeapDump;

class HeapInstance {

	private int instances;
	private long memory;
	private String className;
	
	
	public HeapInstance(int i, int m, String n) {
		this.instances = i;
		this.memory = m;
		this.className = n;
	}
	
	public int getInstances() {
		return this.instances;
	}
	
	public long getMemory() {
		return this.memory;
	}
	
	public String getName() {
		return this.className;
	}
	
	public String toString() {
		return "Instances: " + this.instances + " Memory Used: " + this.memory + " Class: " + this.className;
	}

	public boolean equals(HeapInstance i) {
		return i.className == this.className;
	}
	
}
