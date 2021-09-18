package HeapDump;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.stream.Collectors;

class FormatHeap {
	private long totalMemoryUsed;
	private long totalInstances;
	private int totalUniqueClasses;
	private ArrayList <HeapInstance> heap;
	
	public FormatHeap() throws IOException {
		String value = ManagementFactory.getRuntimeMXBean().getName();
		this.heap = new ArrayList <HeapInstance> ();
		String pid = "";
		for (int i = 0; i < value.length(); i++) {
			if (Character.isDigit(value.charAt(i)))
				pid = pid + value.charAt(i);
			else 
				break;
		}
		
		boolean isWindows = System.getProperty("os.name")
				  .toLowerCase().startsWith("windows");
		
		ProcessBuilder builder = new ProcessBuilder();
		if (isWindows) {
		    builder.command("cmd.exe", "/c", "jmap", "-histo",pid);
		} else {
			//builder.command("sh", "-c", "ls");
			//builder.command("sh", "-c", "java", "-version");
		    builder.command("sh", "-c", "jmap -histo " + pid);
		}
		builder.directory(new File(System.getProperty("user.home")));
		Process process = builder.start();
		InputStream inputStream = process.getInputStream();
		String result = new BufferedReader(new InputStreamReader(inputStream))
				   .lines().collect(Collectors.joining("\n"));
		
		//System.out.println(result.length());
		//System.out.println("..." + result);
		String[] arr = result.split("\n");
		ArrayList <String> values = new ArrayList <String> ();
		
		
		
		for (int i = 3; i < arr.length; i++) {
			String[] row = arr[i].split(" ");
			for (int j = 0; j < row.length; j++) {
				row[j] = row[j].replaceAll(" ", "");
				if (row[j].length() != 0) {
					if (values.contains(row[j]) == false)
						values.add(row[j]);
				}
			}
			
			if (arr[i].contains("Total")) {
				this.totalInstances = Integer.parseInt(values.get(1));
				this.totalMemoryUsed = Integer.parseInt(values.get(2));
				this.totalUniqueClasses = this.heap.size();
			} else {
				for (int j = 0; j < values.size(); j++) {
					HeapInstance instance = new HeapInstance(Integer.parseInt(values.get(1)), Integer.parseInt(values.get(2)), values.get(3));
					if (this.heap.contains(instance) == false)
						this.heap.add(instance);
				}
			}
			values.clear();
		}
	}
	
	
	public long getTotalInstances() {
		return this.totalInstances;
	}
	
	public long getTotalMemoryUsed() {
		return this.totalMemoryUsed;
	}
	
	public int getTotalUniqueClasses() {
		return this.totalUniqueClasses;
	}
	
	public ArrayList <HeapInstance> getHeap() {
		return this.heap;
	}
	
	

}
