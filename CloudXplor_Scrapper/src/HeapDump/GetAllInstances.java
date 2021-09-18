package HeapDump;

import java.io.IOException;

class GetAllInstances {
	
	public long getAllInstances(FormatHeap heap) throws IOException, ClassNotFoundException {
		if (heap == null)
			heap = new FormatHeap();
		return heap.getTotalInstances();
	}
}
