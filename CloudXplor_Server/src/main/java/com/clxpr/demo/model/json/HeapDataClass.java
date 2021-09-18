package com.clxpr.demo.model.json;

import com.clxpr.demo.model.heapmodel.Heap;

public class HeapDataClass {
	
	private Heap heap;
	
	public HeapDataClass() {}
	
	public HeapDataClass(Heap heap) {
		this.heap = heap;
	}

	public Heap getHeap() {
		return heap;
	}

	public void setHeap(Heap heap) {
		this.heap = heap;
	}
	
}
