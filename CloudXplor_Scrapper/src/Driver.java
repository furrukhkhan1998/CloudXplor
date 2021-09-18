import java.io.*;
import java.sql.SQLException;



public class Driver { //will communicate with server and call functions to execute unix systat processes
	
	
	
	public void getAll(rScrapper scrapper) throws IOException, InterruptedException, SQLException, ClassNotFoundException {
		scrapper.processStat(); // scrape process stats
		scrapper.memoryStat(); // scrape memory stats
		scrapper.cpuStat(); // scrape cpu stats
		scrapper.pidStat(); // scrape pid stats
		scrapper.pidSchedStat(); // scrape pid sched stats
		scrapper.diskStat(); // scrape disk stats
		scrapper.ioStat(); // scrape io stats
		scrapper.dbStat(); // scrape db stats
		scrapper.heap();
		scrapper.heapDump();
		scrapper.stack();
		scrapper.thread();
	}
	
	public void getProcess(rScrapper scrapper) throws IOException, InterruptedException {
		scrapper.processStat();
	}
	
	public void getMemory(rScrapper scrapper) throws IOException, InterruptedException {
		scrapper.memoryStat();
	}
	
	public void getCpu(rScrapper scrapper) throws IOException, InterruptedException {
		scrapper.cpuStat();
	}
	
	public void getPid(rScrapper scrapper) throws IOException, InterruptedException {
		scrapper.pidStat();
	}
	
	public void getPidSched(rScrapper scrapper) throws IOException, InterruptedException {
		scrapper.pidSchedStat();
	}
	
	public void getDisk(rScrapper scrapper) throws IOException, InterruptedException {
		scrapper.diskStat();
	}
	
	public void getIo(rScrapper scrapper) throws IOException, InterruptedException {
		scrapper.ioStat();
	}
	
	public void getDb(rScrapper scrapper) throws SQLException, IOException {
		scrapper.dbStat();
	}
	
	public boolean runScrapper(rScrapper scrapper, String command) throws IOException, InterruptedException, SQLException, ClassNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(new File("src//config.txt")));
		String id = br.readLine();
		String mId = br.readLine();
		System.out.println(id + "\n" + mId);
		br.close();
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("resourceStat.txt")));
		bw.write(id + "\n" + mId + "\n");
		bw.close();
		br = new BufferedReader(new FileReader(new File("resourceStat.txt")));
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		if (command.contains("all")) {
			getAll(scrapper);
		}
		else if (command.contains("cpu")) {
			getCpu(scrapper);
		}
		else if (command.contains("process")) {
			getProcess(scrapper);
		}
		else if (command.contains("memory")) {
			getMemory(scrapper);
		}
		else if (command.contains("pid")) {
			getPid(scrapper);
		}
		else if (command.contains("pidsched")) {
			getPidSched(scrapper);
		}
		else if (command.contains("disk")) {
			getDisk(scrapper);
		}
		else if (command.contains("io")) {
			getIo(scrapper);
		}
		else if (command.contains("db")) {
			getDb(scrapper);
		}
		else if (command.contains("exit")) {
			return true;
		}
		return false;
		
	}
	
	
	public static void main(String args[]) throws IOException, InterruptedException, SQLException, ClassNotFoundException
	{
		Driver driver = new Driver();
		rScrapper scrapper = new rScrapper(); // instantiate scrapper
		Client client = new Client(scrapper.getWriter()); // instantiate client class
		boolean exitStatus = false;
		while (exitStatus == false) {
			String command = "all";
			exitStatus = driver.runScrapper(scrapper, command);
			client.connectToServer(); // connect client to our back end server 
			Thread.sleep(5000, 0);
		}
		

	}

}
