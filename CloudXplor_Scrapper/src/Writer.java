import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import HeapDump.OperationContainerHeap;
import StackDump.OperationContainerStack;
import ThreadDump.OperationContainerThread;


public class Writer { // container to hold all the stats
	
	private pidStat pidstat;
	private pidSchedStat pidSched;
	private processStats process;
	private diskStat disk;
	private ioStat io;
	private cpuStat cpu;
	private memStat mem;
	private OperationContainerStack stack;
	private OperationContainerHeap heap;
	private OperationContainerThread thread;
	
	Writer() {
		this.pidSched = new pidSchedStat();
		this.pidstat = new pidStat();
		this.cpu = new cpuStat();
		this.io = new ioStat();
		this.mem = new memStat();
		this.disk = new diskStat();
		this.process = new processStats();
		this.stack = new OperationContainerStack();
		this.heap = new OperationContainerHeap();
		this.thread = new OperationContainerThread();
	}
	
	public void writePidStat() throws IOException {
		this.pidstat.write("resourceStat.txt");
	}
	
	public void writePidSched() throws IOException {
		this.pidSched.write("resourceStat.txt");
	}
	public void writeProcess() throws IOException {
		this.process.write("resourceStat.txt");
	}
	public void writeDisk() throws IOException {
		this.disk.write("resourceStat.txt");
	}
	public void writeIO() throws IOException {
		this.io.write("resourceStat.txt");
	}
	public void writeCPU() throws IOException {
		this.cpu.write("resourceStat.txt");
	}
	public void writeMem() throws IOException {
		this.mem.write("resourceStat.txt");
	}
	public void writeHeap() throws IOException, ClassNotFoundException {
		this.heap.writeHeapToFile();
	}
	public void writeStackDump() throws IOException {
		this.stack.getAll();
	}
	public void writeThreadDump() throws IOException {
		this.thread.getAll();
	}
	public void writeHeapDump() throws IOException, ClassNotFoundException {
		this.heap.getAll("String", "String");
	}
	
	public void transferStats(DataOutputStream out) throws IOException { // sends data to output stream of socket for back end server
		BufferedWriter bw = new BufferedWriter (new FileWriter (new File("resourceStat.txt"), true));
		bw.write("Over");
		bw.close();
		BufferedReader br = new BufferedReader (new FileReader (new File("resourceStat.txt")));
		String line;
		while ( (line = br.readLine()) != null) {
			out.writeUTF(line);
			System.out.println(line);
		}
		br.close();
		br = new BufferedReader (new FileReader (new File("dbData.txt")));
		while ( (line = br.readLine()) != null) {
			out.writeUTF(line);
		}
		br.close();
		System.out.println("Checking...");
		if (this.heap.getFileName() != null && new File(this.heap.getFileName2()).isFile() == true) {
			System.out.println("File exists");
			br = new BufferedReader (new FileReader (new File(this.heap.getFileName2())));
			while ( (line = br.readLine()) != null) {
				
				out.writeUTF(line);
			}
			br.close();
		}
		System.out.println("Checking...");
		if (this.heap.getFileName2() != null && new File(this.heap.getFileName()).isFile() == true) {
			System.out.println("File exists");
			br = new BufferedReader (new FileReader (new File(this.heap.getFileName())));
			while ( (line = br.readLine()) != null) {
				out.writeUTF(line);
			}
			br.close();
		}
		System.out.println("Checking...");
		if (this.stack.getFileName() != null && new File(this.stack.getFileName()).isFile() == true) {
			System.out.println("File exists");
			br = new BufferedReader (new FileReader (new File(this.stack.getFileName())));
			while ( (line = br.readLine()) != null) {
				out.writeUTF(line);
			}
			br.close();
		}
		System.out.println("Checking...");
		if (this.thread.getFileName() != null && new File(this.thread.getFileName()).isFile() == true) {
			System.out.println("File exists");
			br = new BufferedReader (new FileReader (new File(this.thread.getFileName())));
			while ( (line = br.readLine()) != null) {
				System.out.println(line);
				out.writeUTF(line);
			}
			br.close();
		}
		out.writeUTF("Over3");
		
	}

	
	public void setPidstat(pidStat pidstat) {
		this.pidstat = pidstat;
	}

	

	public void setPidSched(pidSchedStat pidSched) {
		this.pidSched = pidSched;
	}

	
	public void setProcess(processStats process) {
		this.process = process;
	}

	public void setDisk(diskStat disk) {
		this.disk = disk;
	}


	public void setIo(ioStat io) {
		this.io = io;
	}

	public void setCpu(cpuStat cpu) {
		this.cpu = cpu;
	}


	public void setMem(memStat mem) {
		this.mem = mem;
	}


}
