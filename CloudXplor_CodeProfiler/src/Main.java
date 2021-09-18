import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.*;
import java.util.stream.Collectors;




public class Main {

	public static void main(String arg[]) throws Exception {
		//dumpHeap(true);
		
		
		String value = ManagementFactory.getRuntimeMXBean().getName();
		String pid = "";
		for (int i = 0; i < value.length(); i++) {
			if (Character.isDigit(value.charAt(i)))
				pid = pid + value.charAt(i);
			else 
				break;
		}
		
		//Scanner input = new Scanner(System.in);
        //input.next();
		boolean isWindows = System.getProperty("os.name")
				  .toLowerCase().startsWith("windows");
		
		ProcessBuilder builder = new ProcessBuilder();
		if (isWindows) {
		    builder.command("cmd.exe", "/c", "jmap", "-histo",pid);
		} else {
		    builder.command("sh", "-c", "ls");
		}
		builder.directory(new File(System.getProperty("user.home")));
		Process process = builder.start();
		InputStream inputStream = process.getInputStream();
		String result = new BufferedReader(new InputStreamReader(inputStream))
				   .lines().collect(Collectors.joining("\n"));
		System.out.println(result);
		//int exitCode = process.waitFor();
		//if (exitCode == 0)
			//System.exit(0);
		//StackTraceElement[] arr = StackTraceAllThreads.getStackTrace(Thread.currentThread());
		
	}
	
	
	


/*	@SuppressWarnings("restriction")
	public static void dumpHeap(boolean live) throws IOException {
		File file = new File("heap.hprof");
	    MBeanServer server = ManagementFactory.getPlatformMBeanServer();
	    HotSpotDiagnosticMXBean mxBean = (HotSpotDiagnosticMXBean) ManagementFactory.newPlatformMXBeanProxy(
	      server, "com.sun.management:type=HotSpotDiagnostic", HotSpotDiagnosticMXBean.class);
	    mxBean.dumpHeap(file.getName(), live); 

	}*/

	


}
