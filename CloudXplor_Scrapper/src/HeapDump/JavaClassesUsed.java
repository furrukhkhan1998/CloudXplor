package HeapDump;

import java.io.IOException;
import java.util.ArrayList;

class JavaClassesUsed {
	
	private ArrayList <String> libs;
	
	public ArrayList <String> getJavaClassesUsed(FormatHeap heap) throws IOException, ClassNotFoundException {
		if (heap == null)
			heap = new FormatHeap();
		this.libs = new ArrayList <String> ();
		for (int i = 0; i < heap.getHeap().size(); i++) {
			if (heap.getHeap().get(i).getName().contains("java") || heap.getHeap().get(i).getName().contains("jdk")) { 
				if (this.libs.contains(heap.getHeap().get(i).getName()) == false)
					this.libs.add(heap.getHeap().get(i).getName());
			}
		}
		return this.libs;
	}

}
