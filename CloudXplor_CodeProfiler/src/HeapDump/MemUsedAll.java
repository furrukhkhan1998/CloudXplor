package HeapDump;

import java.io.IOException;

class MemUsedAll {

	public long getMemUsedAll(FormatHeap heap) throws IOException {
		if (heap == null)
			heap = new FormatHeap();
		return heap.getTotalMemoryUsed();
	}
	
}
