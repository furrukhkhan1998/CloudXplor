package StackDump;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class OperationContainerStack {
	
	private String filename; 
	
	public void getAllMethodsAllThreads(BufferedWriter bw, ArrayList <Long> ids) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			this.filename = "StackDump-" + formatter.format(date) + ".txt";
			bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		}
		bw.write("==================================== All Methods All Threads =========================================\n");
		HashMap<Thread, ArrayList<Method>> map = new AllMethodsAllThread().getMap();
		for (Thread key : map.keySet()) {
			if (map.get(key).size() != 0) {
				if (!ids.contains(key.getId())) {
					bw.write("Thread ID: " + key.getId() + "\n");
					ArrayList<Method> arr = map.get(key);
					for (int i = 0; i < arr.size(); i++) {
						bw.write("         " + arr.get(i).toString() + "\n");
					}
					bw.write("\n");
				}
			}
		}
		bw.write("==================================== All Methods All Threads =========================================\n");
	}
	
	public void getAllMethodsOneThread(Thread thread, BufferedWriter bw) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			this.filename = "StackDump-" + formatter.format(date) + ".txt";
			bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		}
		bw.write("==================================== All Methods for thread " + thread.getId() +" =========================================\n\n");
		ArrayList<Method> arr = new AllMethodsOneThread(thread).getMethods();
		for (int i = 0; i < arr.size(); i++) {
			bw.write("         " + arr.get(i).toString() + "\n");
		}
		bw.write("\n==================================== All Methods for thread " + thread.getId() +" =========================================\n");
	}
	
	public void MethodCountAllThread(BufferedWriter bw) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			this.filename = "StackDump-" + formatter.format(date) + ".txt";
			bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		}
		bw.write("==================================== All Methods Count =========================================\n");
		bw.write(Integer.toString(new MethodCountAllThread().getCount()) + "\n");
		bw.write("==================================== All Methods Count =========================================\n");
	}
	
	public void MethodCountOneThread(Thread thread, String method, BufferedWriter bw) throws IOException {
		if (bw == null) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date(System.currentTimeMillis());
			this.filename = "StackDump-" + formatter.format(date) + ".txt";
			bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		}
		bw.write("==================================== " + method + " count for thread " + thread.getId() + " =========================================\n");
		bw.write(Integer.toString(new MethodCountOneThread(thread, method).getCount()) + "\n");
		bw.write("==================================== " + method + " count for thread " + thread.getId() + " =========================================\n");
		
	}
	
	public void getAll() throws IOException {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date = new Date(System.currentTimeMillis());
		this.filename = "StackDump-" + formatter.format(date) + ".txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter (new File(this.filename), true));
		
		class AMAT implements Runnable {
			
			private ArrayList <Long> arr;
			
			public AMAT(ArrayList <Long> arr) {
				this.arr = arr;
				this.arr.add(Thread.currentThread().getId());
			}
			
			@Override
			public void run() {
				try {
					new OperationContainerStack().getAllMethodsAllThreads(bw, this.arr);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		class AMOT implements Runnable {
			@Override
			public void run() {
				try {
					new OperationContainerStack().getAllMethodsOneThread(Thread.currentThread(), bw);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		class MCAT implements Runnable {
			@Override
			public void run() {
				try {
					new OperationContainerStack().MethodCountAllThread(bw);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		class MCOT implements Runnable {
			@Override
			public void run() {
				try {
					new OperationContainerStack().MethodCountOneThread(Thread.currentThread(), "run", bw);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		Thread thread1 = new Thread(new AMOT());
		Thread thread2 = new Thread(new MCAT());
		Thread thread3 = new Thread(new MCOT());
		
		ArrayList <Long> ids = new ArrayList <Long> ();
		ids.add(thread1.getId());
		ids.add(thread2.getId());
		ids.add(thread3.getId());
		
		Thread thread4 = new Thread(new AMAT(ids));
		
		thread1.run();
		thread2.run();
		thread3.run();
		thread4.run();
		bw.close();
	}
	
	public String getFileName() {
		return this.filename;
	}
	
}
