import java.io.*;
import java.sql.SQLException;



public class rScrapper {
	private Writer writer;
	private dbScrapper db;
	
	rScrapper() {
		writer = new Writer();
		db = new dbScrapper();
	}
	
	public String getOsName()
	{
		return System.getProperty("os.name") + " " + System.getProperty("os.version");
	}
	
	public Writer getWriter() {
		return this.writer;
	}
	
	public void processStat() throws IOException, InterruptedException  
	{
		ProcessBuilder builder = new ProcessBuilder();
		builder.command("pidstat", "-d"); // gets process stats
		Process process = builder.start();
		InputStream in = process.getInputStream();
		processStats pro = new processStats();
		BufferedReader br = new BufferedReader (new InputStreamReader (in));
		String line;
		while ( (line = br.readLine()) != null) {
			pro.add(line);
		}
		this.writer.setProcess(pro);
		this.writer.writeProcess(); // writes process stats to file 
		
		int exitCode = process.waitFor();
		assert exitCode == 0;
	}
	public void cpuStat() throws IOException, InterruptedException
	{
		ProcessBuilder builder = new ProcessBuilder();
		builder.command("mpstat", "-P","ALL"); // gets cpu stats
		Process process = builder.start();
		InputStream in = process.getInputStream();
		cpuStat pro = new cpuStat();
		BufferedReader br = new BufferedReader (new InputStreamReader (in));
		String line;
		while ( (line = br.readLine()) != null) {
			pro.add(line);
		}
		this.writer.setCpu(pro);
		this.writer.writeCPU(); // writes cpu stats to file
		
		int exitCode = process.waitFor();
		assert exitCode == 0;
	}
	public void pidStat() throws IOException, InterruptedException
	{
		ProcessBuilder builder = new ProcessBuilder();
		builder.command("pidstat"); // gets pid stats
		Process process = builder.start();
		InputStream in = process.getInputStream();
		pidStat pro = new pidStat();
		BufferedReader br = new BufferedReader (new InputStreamReader (in));
		String line;
		while ( (line = br.readLine()) != null) {
			pro.add(line);
		}
		this.writer.setPidstat(pro);
		this.writer.writePidStat(); // writes pid stats to file 
		int exitCode = process.waitFor();
		assert exitCode == 0;
	}
	
	public void pidSchedStat() throws IOException, InterruptedException
	{
		ProcessBuilder builder = new ProcessBuilder();
		builder.command("pidstat","-R"); // gets pid sched stats
		Process process = builder.start();
		InputStream in = process.getInputStream();
		pidSchedStat pro = new pidSchedStat();
		BufferedReader br = new BufferedReader (new InputStreamReader (in));
		String line;
		while ( (line = br.readLine()) != null) {
			pro.add(line);
		}
		this.writer.setPidSched(pro);
		this.writer.writePidSched(); // writes pid sched stats to file
		int exitCode = process.waitFor();
		assert exitCode == 0;
	}
	
	public void memoryStat() throws IOException, InterruptedException
	{
		ProcessBuilder builder = new ProcessBuilder();
		builder.command("vmstat","-a"); // gets memory stats
		Process process = builder.start();
		InputStream in = process.getInputStream();
		memStat pro = new memStat();
		BufferedReader br = new BufferedReader (new InputStreamReader (in));
		String line;
		while ( (line = br.readLine()) != null) {
			pro.add(line);
		}
		this.writer.setMem(pro);
		this.writer.writeMem(); // writes memory stats to file 
		
		int exitCode = process.waitFor();
		assert exitCode == 0;
	}
	public void diskStat() throws IOException, InterruptedException
	{
		ProcessBuilder builder = new ProcessBuilder();
		builder.command("vmstat","-d"); // gets disk stats
		Process process = builder.start();
		InputStream in = process.getInputStream();
		diskStat pro = new diskStat();
		BufferedReader br = new BufferedReader (new InputStreamReader (in));
		String line;
		while ( (line = br.readLine()) != null) {
			pro.add(line);
		}
		this.writer.setDisk(pro);
		this.writer.writeDisk(); // writes disk stats to file
		int exitCode = process.waitFor();
		assert exitCode == 0;
	}
	public void ioStat() throws IOException, InterruptedException
	{
		ProcessBuilder builder = new ProcessBuilder();
		builder.command("iostat","-d"); // gets io stats
		Process process = builder.start();
		InputStream in = process.getInputStream();
		ioStat pro = new ioStat();
		BufferedReader br = new BufferedReader (new InputStreamReader (in));
		String line;
		while ( (line = br.readLine()) != null) {
			pro.add(line);
		}
		this.writer.setIo(pro);
		this.writer.writeIO(); // writes io stats to file
		
		int exitCode = process.waitFor();
		assert exitCode == 0;
	}
	
	public void dbStat() throws SQLException, IOException {
		db.runScrapper();
	}
	
	public void heapDump() throws IOException, ClassNotFoundException {
		this.writer.writeHeapDump();
	}
	
	public void heap() throws IOException, ClassNotFoundException {
		this.writer.writeHeap();
	}
	
	public void stack() throws IOException {
		this.writer.writeStackDump();
	}
	
	public void thread() throws IOException {
		this.writer.writeThreadDump();
	}
}
	
