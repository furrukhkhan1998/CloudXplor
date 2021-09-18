package HeapDump;

import java.io.IOException;

class GetNumberOfClasses {
	
	public int getNumberOfClasses(FormatHeap heap) throws IOException, ClassNotFoundException {
		if (heap == null)
			heap = new FormatHeap();
		return heap.getTotalUniqueClasses();
	}

}
