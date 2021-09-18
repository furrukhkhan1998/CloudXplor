package HeapDump;

import java.io.IOException;

class MemUsedByClass {
	
	public long GetMemUsedByClass(String name, FormatHeap heap) throws IOException, ClassNotFoundException {
		if (heap == null)
			heap = new FormatHeap();
		for (int i = 0; i < heap.getHeap().size(); i++) {
			if (heap.getHeap().get(i).getName().contains(name))
				return heap.getHeap().get(i).getMemory();
		}
		return -1;
	}

}
