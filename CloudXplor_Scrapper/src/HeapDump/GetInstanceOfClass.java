package HeapDump;

import java.io.IOException;

class GetInstanceOfClass {

	public long getInstanceOfClass(String name, FormatHeap heap) throws IOException, ClassNotFoundException {
		if (heap == null)
			heap = new FormatHeap();
		
		for (int i = 0; i < heap.getHeap().size(); i++) {
			if (heap.getHeap().get(i).getName().contains(name)) {
				return heap.getHeap().get(i).getInstances();
			}
		}
		return -1;
	}
	
}
