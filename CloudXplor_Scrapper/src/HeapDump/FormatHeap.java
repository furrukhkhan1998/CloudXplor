package HeapDump;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
//import java.net.URL;
import java.util.ArrayList;
//import java.util.List;
//import java.util.Enumeration;
import java.util.stream.Collectors;


class FormatHeap {
	private long totalMemoryUsed;
	private long totalInstances;
	private int totalUniqueClasses;
	private ArrayList <HeapInstance> heap;
	
	public FormatHeap() throws IOException, ClassNotFoundException {
		
		/*ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Package[] packages = Package.getPackages();
		//for (int i = 0; i < packages.length; i++)
			//System.out.println(packages[i].getName());
		String packageName = "com.clxpr.demo.model.db";
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class> classes = new ArrayList<Class>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		Class[] arr2 = classes.toArray(new Class[classes.size()]);
		ArrayList <String> names = new ArrayList <String> ();
		for (int i = 0; i < arr2.length; i++)
			names.add(arr2[i].getSimpleName());
		
		//for (int i = 0; i < names.size(); i++)
			//System.out.println(names.get(i));
		
		System.out.println();*/
		
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
						if (instance.getName().contains("java.") == false && instance.getName().contains("jdk.") == false
						&& instance.getName().contains("sun.") == false && instance.getName().contains("org.") == false
						&& instance.getName().contains("com.") == false && instance.getName().charAt(0) != '[')
						this.heap.add(instance);
				}
			}
			values.clear();
		}
		for (int i = 0; i < this.heap.size(); i++)
			System.out.println(heap.get(i).getName());
	}
	
	public boolean find(String name, ArrayList <String> names) {
		for (int i = 0; i < names.size(); i++) {
			if (name.contains(names.get(i))) {
				return true;
			}
		}
		return false;
	}

	/*private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
		List<Class> classes = new ArrayList<Class>();
	    if (!directory.exists()) {
	        return classes;
	    }
	    File[] files = directory.listFiles();
	    for (File file : files) {
	        if (file.isDirectory()) {
	            assert !file.getName().contains(".");
	            classes.addAll(findClasses(file, packageName + "." + file.getName()));
	        } else if (file.getName().endsWith(".class")) {
	            classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
	        }
	    }
	    return classes;
	}*/
	
	
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
