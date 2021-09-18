package HeapDump;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class OperationContainer {

	public void getAllClasses(BufferedWriter bw, FormatHeap heap) throws IOException {
		
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			bw = new BufferedWriter(new FileWriter (new File("HeapDump-" + formatter.format(date) + ".txt"), true));
		}
		ArrayList <String> arr = new GetAllClasses(heap).getAllClasses();
		bw.write("=============================== All Classes ==================================\n");
		for (int i = 0; i < arr.size(); i++) {
			bw.write(arr.get(i) + "\n");
		}
		bw.write("=============================== All Classes ==================================\n");
	}
	
	public void getAllInstances(BufferedWriter bw, FormatHeap heap) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			bw = new BufferedWriter(new FileWriter (new File("HeapDump-" + formatter.format(date) + ".txt"), true));
		}
		bw.write("=============================== All Instances ==================================\n");
		bw.write(Long.toString(new GetAllInstances().getAllInstances(heap)) + "\n");
		bw.write("=============================== All Instances ==================================\n");
	}
	
	public void getInstanceOfClass(String name, BufferedWriter bw, FormatHeap heap) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			bw = new BufferedWriter(new FileWriter (new File("HeapDump-" + formatter.format(date) + ".txt"), true));
		}
		bw.write("=============================== " + name + " Instances ==================================\n");
		bw.write(Long.toString(new GetInstanceOfClass().getInstanceOfClass(name, heap)) + "\n");
		bw.write("=============================== " + name + " Instances ==================================\n");
	}
	
	public void getNumberOfClasses(BufferedWriter bw, FormatHeap heap) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			bw = new BufferedWriter(new FileWriter (new File("HeapDump-" + formatter.format(date) + ".txt"), true));
		}
		bw.write("=============================== Total Number Of Classes ==================================\n");
		bw.write(new GetNumberOfClasses().getNumberOfClasses(heap) + "\n");
		bw.write("=============================== Total Number Of Classes ==================================\n");
	}
	
	public void getJavaClassesUsed(BufferedWriter bw, FormatHeap heap) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			bw = new BufferedWriter(new FileWriter (new File("HeapDump-" + formatter.format(date) + ".txt"), true));
		}
		ArrayList <String> arr = new JavaClassesUsed().getJavaClassesUsed(heap);
		bw.write("=============================== Java Classes Used ==================================\n");
		for (int i = 0; i < arr.size(); i++) {
			bw.write(arr.get(i) + "\n");
		}
		bw.write("=============================== Java Classes Used ==================================\n");
	}
	
	public void getMemUsedAll(BufferedWriter bw, FormatHeap heap) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			bw = new BufferedWriter(new FileWriter (new File("HeapDump-" + formatter.format(date) + ".txt"), true));
		}
		bw.write("=============================== Total Memory Used (Bytes) ==================================\n");
		bw.write(new MemUsedAll().getMemUsedAll(heap) + "\n");
		bw.write("=============================== Total Memory Used (Bytes) ==================================\n");
	}
	
	public void getMemUsedAll(String name, BufferedWriter bw, FormatHeap heap) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			bw = new BufferedWriter(new FileWriter (new File("HeapDump-" + formatter.format(date) + ".txt"), true));
		}
		bw.write("=============================== Memory Used By " + name + " (Bytes) ==================================\n");
		bw.write(new MemUsedByClass().GetMemUsedByClass(name, heap) + "\n");
		bw.write("=============================== Memory Used By " + name + " (Bytes) ==================================\n");
	}
	
	public void writeHeapToFile() throws IOException {
		ArrayList<HeapInstance> heap = new FormatHeap().getHeap();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date = new Date(System.currentTimeMillis());
		BufferedWriter bw = new BufferedWriter(new FileWriter (new File("Heap-" + formatter.format(date) + ".txt")));
		ArrayList <String> temp = new ArrayList <String> ();
		for (int i = 0; i < heap.size(); i++) {
			if (temp.contains(heap.get(i).toString()) == false) {
				bw.write(heap.get(i).toString() + "\n");
				temp.add(heap.get(i).toString());
			}
		}
		bw.close();
	}
	
	public void getAll(String classInstance, String classMemory) throws IOException {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date = new Date(System.currentTimeMillis());
		BufferedWriter bw = new BufferedWriter(new FileWriter (new File("HeapDump-" + formatter.format(date) + ".txt"), true));
		FormatHeap heap = new FormatHeap();
		class GAC implements Runnable {
			@Override
			public void run() {
				try {
					new OperationContainer().getAllClasses(bw, heap);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		class GAI implements Runnable {
			
			@Override
			public void run() {
				try {
					new OperationContainer().getAllInstances(bw, heap);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		class GIOC implements Runnable {
			
			@Override
			public void run() {
				try {
					new OperationContainer().getInstanceOfClass(classInstance, bw, heap);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		class GNOC implements Runnable {
					
					@Override
					public void run() {
						try {
							new OperationContainer().getNumberOfClasses(bw, heap);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
		
		class JCU implements Runnable {
			
			@Override
			public void run() {
				try {
					new OperationContainer().getJavaClassesUsed(bw, heap);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		class MUA implements Runnable {
			
			@Override
			public void run() {
				try {
					new OperationContainer().getMemUsedAll(bw, heap);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		class MUBC implements Runnable {
			
			@Override
			public void run() {
				try {
					new OperationContainer().getMemUsedAll(classMemory, bw, heap);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		ArrayList <Thread> threads = new ArrayList <Thread> ();
		threads.add(new Thread(new GAC()));
		threads.add(new Thread(new GAI()));
		threads.add(new Thread(new GIOC()));
		threads.add(new Thread(new GNOC()));
		threads.add(new Thread(new JCU()));
		threads.add(new Thread(new MUA()));
		threads.add(new Thread(new MUBC()));
		
		for (int i = 0; i < threads.size(); i++)
			threads.get(i).run();
		
		bw.close();
	}
	
	
	public static void main(String arg[]) throws IOException {
		new OperationContainer().getAll("long", "String");
		new OperationContainer().writeHeapToFile();
	}
	
}
