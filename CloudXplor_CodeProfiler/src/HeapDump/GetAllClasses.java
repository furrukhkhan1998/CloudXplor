package HeapDump;

import java.io.IOException;
import java.util.ArrayList;

class GetAllClasses {
	
	private ArrayList <String> classes;
	
	public GetAllClasses(FormatHeap heap) throws IOException {
		
		if (heap == null)
			heap = new FormatHeap();
		this.classes = new ArrayList <String> ();
		for (int i = 0; i < heap.getHeap().size(); i++) {
			if (this.classes.contains(heap.getHeap().get(i).getName()) == false)
				this.classes.add(heap.getHeap().get(i).getName());
		}
	}
	
	public ArrayList <String> getAllClasses() {
		return this.classes;
	}

}
