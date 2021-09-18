package com.clxpr.demo;

import java.util.Date;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import com.clxpr.demo.model.db.CpuData;
import com.clxpr.demo.model.db.DiskData;
import com.clxpr.demo.model.db.HeapData;
import com.clxpr.demo.model.db.HeapDumpData;
import com.clxpr.demo.model.db.HostSumByStatData;
import com.clxpr.demo.model.db.HostSummaryData;
import com.clxpr.demo.model.db.IoData;
import com.clxpr.demo.model.db.MemData;
import com.clxpr.demo.model.db.PidData;
import com.clxpr.demo.model.db.PidSchedData;
import com.clxpr.demo.model.db.ProcessListData;
import com.clxpr.demo.model.db.Resource;
import com.clxpr.demo.model.db.ResourceData;
import com.clxpr.demo.model.db.StackData;
import com.clxpr.demo.model.db.StatementAnalysisData;
import com.clxpr.demo.model.db.ThreadData;
import com.clxpr.demo.service.CpuDataService;
import com.clxpr.demo.service.DiskDataService;
import com.clxpr.demo.service.HeapDataService;
import com.clxpr.demo.service.HeapDumpDataService;
import com.clxpr.demo.service.HostSumByStatDataService;
import com.clxpr.demo.service.HostSummaryService;
import com.clxpr.demo.service.IoDataService;
import com.clxpr.demo.service.MemDataService;
import com.clxpr.demo.service.PidDataService;
import com.clxpr.demo.service.PidSchedDataService;
import com.clxpr.demo.service.ProcessListService;
import com.clxpr.demo.service.ResourceDataService;
import com.clxpr.demo.service.ResourceService;
import com.clxpr.demo.service.StackDataService;
import com.clxpr.demo.service.StatementAnalysisService;
import com.clxpr.demo.service.ThreadDataService;

public class ClientHandler extends Thread {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ResourceService resourceServ;
	private ResourceDataService resourceDataServ;
	private CpuDataService cpuDataServ;
	private DiskDataService diskDataServ;
	private IoDataService ioDataServ;
	private MemDataService memDataServ;
	private PidDataService pidDataServ;
	private PidSchedDataService pidSchedDataServ;
	private HostSumByStatDataService hostSumByStatDataServ;
	private HostSummaryService hostSummaryServ;
	private ProcessListService processListServ;
	private StatementAnalysisService statementAnalysisServ;
	private HeapDataService heapDataServ;
	private HeapDumpDataService heapDumpDataServ;
	private StackDataService stackDataServ;
	private ThreadDataService threadDataServ;
	private String userId;
	private String machineId;
	private String userIdDB;
	private String machineIdDB;
	private int occurance;
	
	public ClientHandler(Socket s, DataInputStream in, DataOutputStream out, ResourceService rs, ResourceDataService rds, CpuDataService cds,
				DiskDataService dds, IoDataService ids, MemDataService mds, PidDataService pds, PidSchedDataService psds, 
				HostSumByStatDataService hsbss, HostSummaryService hss, ProcessListService pls, StatementAnalysisService sas, 
				HeapDataService hds, HeapDumpDataService hdds, StackDataService sds, ThreadDataService tds, int occurance) {
		
		this.socket = s;
		this.resourceServ = rs;
		this.resourceDataServ = rds;
		this.cpuDataServ = cds;
		this.diskDataServ = dds;
		this.ioDataServ = ids;
		this.memDataServ = mds;
		this.pidDataServ = pds;
		this.pidSchedDataServ = psds;
		this.hostSumByStatDataServ = hsbss;
		this.hostSummaryServ = hss;
		this.processListServ = pls;
		this.statementAnalysisServ = sas;
		this.heapDataServ = hds;
		this.heapDumpDataServ = hdds;
		this.stackDataServ = sds;
		this.threadDataServ = tds;
		this.occurance = occurance;
		this.in = in;
		this.out = out;
	}
	
	@Override
	public void run() {
		String line = ""; 
        ArrayList <String> list = new ArrayList <String> ();
        Resource resource= new Resource();
        resource.setTimestamp(LocalDate.now());
        resourceServ.save(resource);
        if(resource.getResources()==null)resource.setResources(new ArrayList<ResourceData>());
        try {
			while (true) {
				

				    while (!line.contains("Over"))  // read data from client side 
				    { 
				    	
				        try
				        { 
	
				        	
				        	this.userId = in.readUTF();
				        	this.machineId = in.readUTF();
				        	System.out.println("User ID:" + this.userId);
				        	System.out.println("Machine ID: " + this.machineId);
				            line = in.readUTF(); 
				            System.out.println("=====>" + line);
				            if (line.contains("processstat")) {
				            	System.out.println("Inside process stat");
				            	line = in.readUTF();
				            	line = in.readUTF();
				            	line = in.readUTF();
				            	line = in.readUTF();
				            	while (!line.contains("memstat")) {    // reading process stats
				            		String[] feat = line.split(" ");
				            		for (int i = 0; i < feat.length; i++) {
				            			if (feat[i].length() != 0) {
				            				list.add(feat[i]);
				            			}
				            		}
				            		ResourceData resourceD= new ResourceData(); // storing one row of process stats
				            		resourceD.setUserId(this.userId);
				            		resourceD.setMachineId(this.machineId);
				            		resourceD.setOccurance(this.occurance);
				                    resourceD.setTime(list.get(0));
				                    resourceD.setUid(Integer.parseInt(list.get(1)));
				                    resourceD.setPid(Integer.parseInt(list.get(2)));
				                    resourceD.setRd(Double.parseDouble(list.get(3)));
				                    resourceD.setWr(Double.parseDouble(list.get(4)));
				                    resourceD.setCcwr(Double.parseDouble(list.get(5)));
				                    resourceD.setIodelay(Double.parseDouble(list.get(6)));
				                    resourceD.setCommand(list.get(7));
				                    resourceD.setResource(resource);
				     			    resourceDataServ.save(resourceD); 
				    	            // pushing row onto the database 
				    	            list.clear();
				    	            line = in.readUTF();
				            	}
				            	System.out.println("<=======>" + line);
				            	line = in.readUTF();
				            	line = in.readUTF();
				            	line = in.readUTF(); // reading memory stats
				            	String[] feat = line.split(" ");
				            	list.clear();
				            	for (int i = 0; i < feat.length; i++) {
				        			if (feat[i].length() != 0) {
				        				list.add(feat[i]);
				        			}
				        		}
				            	MemData memD = new MemData(); // storing one row of memory stats
				            	memD.setUserId(this.userId);
				            	memD.setMachineId(this.machineId);
				            	memD.setOccurance(this.occurance);
				            	memD.setR(list.get(0));
				            	memD.setB(list.get(1));
				            	memD.setSwpd(list.get(2));
				            	memD.setFree(list.get(3));
				            	memD.setInact(list.get(4));
				            	memD.setActive(list.get(5));
				            	memD.setSi(list.get(6));
				            	memD.setSo(list.get(7));
				            	memD.setBi(list.get(8));
				            	memD.setBo(list.get(9));
				            	memD.setIn(list.get(10));
				            	memD.setCs(list.get(11));
				            	memD.setUs(list.get(12));
				            	memD.setSy(list.get(13));
				            	memD.setId(list.get(14));
				            	memD.setWa(list.get(15));
				            	memD.setSt(list.get(16));
				            	memD.setAnomaly(-99);
				            	String time = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").format(new Date());
				            	memD.setTime(time);
				            	this.memDataServ.save(memD); // pushing row onto the database
				            	for (int i = 0; i < 4; i++) {
				            		line = in.readUTF();
				            	}
				            	list.clear();
				            	line = in.readUTF();
				            	while (!line.contains("pidstat")) { // reading cpu stats
				            		
				            		feat = line.split(" ");
				            		for (int i = 0; i < feat.length; i++) {
				            			if (feat[i].length() != 0) {
				            				list.add(feat[i]);
				            			}
				            		}
				            		CpuData cpuD = new CpuData(); // storing one row of cpu stats
				            		cpuD.setUserId(this.userId);
				            		cpuD.setMachineId(this.machineId);
				            		cpuD.setOccurance(this.occurance);
				            		cpuD.setTime(list.get(0));
				            		cpuD.setCpu(list.get(1));
				            		cpuD.setUsr(list.get(2));
				            		cpuD.setNice(list.get(3));
				            		cpuD.setSys(list.get(4));
				            		cpuD.setIoWait(list.get(5));
				            		cpuD.setIrq(list.get(6));
				            		cpuD.setSoft(list.get(7));
				            		cpuD.setSteal(list.get(8));
				            		cpuD.setGuest(list.get(9));
				            		cpuD.setGnice(list.get(10));
				            		cpuD.setIdle(list.get(11));
				            		cpuD.setAnomaly("0");
				            		this.cpuDataServ.save(cpuD); // pushing row onto the database
				            		list.clear();
				            		line = in.readUTF();
				            	}
				            	System.out.println("<=======>" + line);
				            	for (int i = 0; i < 3; i++) {
				            		line = in.readUTF();
				            	}
				            	list.clear();
				            	line = in.readUTF();
				            	while (!line.contains("pidschedstat")) { // reading pid stats
				            		
				            		feat = line.split(" ");
				            		for (int i = 0; i < feat.length; i++) {
				            			if (feat[i].length() != 0) {
				            				list.add(feat[i]);
				            			}
				            		}
				            		PidData pidD = new PidData(); // storing one row of pid stats
				            		pidD.setUserId(this.userId);
				            		pidD.setMachineId(this.machineId);
				            		pidD.setOccurance(this.occurance);
				            		pidD.setTime(list.get(0));
				            		pidD.setUid(list.get(1));
				            		pidD.setPid(list.get(2));
				            		pidD.setUsr(list.get(3));
				            		pidD.setSystem(list.get(4));
				            		pidD.setGuest(list.get(5));
				            		pidD.setWait(list.get(6));
				            		pidD.setCpu(list.get(7));
				            		pidD.setCpuNo(list.get(8));
				            		pidD.setCmd(list.get(9));
				            		this.pidDataServ.save(pidD); // pushing row onto the database
				            		list.clear();
				            		line = in.readUTF();
				            	}
				            	System.out.println("<=======>" + line);
				            	for (int i = 0; i < 3; i++) {
				            		line = in.readUTF();
				            	}
				            	list.clear();
				            	line = in.readUTF();
				            	while (!line.contains("diskstat")) { // reading pid sched stats
				            		
				            		feat = line.split(" ");
				            		for (int i = 0; i < feat.length; i++) {
				            			if (feat[i].length() != 0) {
				            				list.add(feat[i]);
				            			}
				            		}
				            		PidSchedData pidSchedD = new PidSchedData(); // storing one row of pid sched stats
				            		pidSchedD.setUserId(this.userId);
				            		pidSchedD.setMachineId(this.machineId);
				            		pidSchedD.setOccurance(this.occurance);
				            		pidSchedD.setTime(list.get(0));
				            		pidSchedD.setUid(list.get(1));
				            		pidSchedD.setPid(list.get(2));
				            		pidSchedD.setPriority(list.get(3));
				            		pidSchedD.setPolicy(list.get(4));
				            		pidSchedD.setCmd(list.get(5));
				            		this.pidSchedDataServ.save(pidSchedD); // pushing one row onto the database
				            		list.clear();
				            		line = in.readUTF();
				            	}
				            	System.out.println("<=======>" + line);
				            	for (int i = 0; i < 2; i++) {
				            		line = in.readUTF();
				            	}
				            	list.clear();
				            	line = in.readUTF();
				            	while (!line.contains("iostat")) { // reading disk stats
				            		
				            		feat = line.split(" ");
				            		for (int i = 0; i < feat.length; i++) {
				            			if (feat[i].length() != 0) {
				            				list.add(feat[i]);
				            			}
				            		}
				            		DiskData diskD = new DiskData(); // storing one row of disk stats
				            		diskD.setUserId(this.userId);
				            		diskD.setMachineId(this.machineId);
				            		diskD.setOccurance(this.occurance);
				            		diskD.setLoop(list.get(0));
				            		diskD.setTotal(list.get(1));
				            		diskD.setMerged(list.get(2));
				            		diskD.setSectors(list.get(3));
				            		diskD.setMs(list.get(4));
				            		diskD.setTota(list.get(5));
				            		diskD.setMerged2(list.get(6));
				            		diskD.setSectors2(list.get(7));
				            		diskD.setMs2(list.get(8));
				            		diskD.setCur(list.get(9));
				            		diskD.setSec(list.get(10));
				            		this.diskDataServ.save(diskD); // pushing one row onto the database
				            		list.clear();
				            		line = in.readUTF();
				            	}
				            	System.out.println("<=======>" + line);
				            	for (int i = 0; i < 2; i++) {
				            		line = in.readUTF();
				            	}
				            	list.clear();
				            	line = in.readUTF();
				            	line = in.readUTF();
				            	while (line.length() != 0) { // reading io stats
				            		
				            		feat = line.split(" ");
				            		for (int i = 0; i < feat.length; i++) {
				            			if (feat[i].length() != 0) {
				            				list.add(feat[i]);
				            			}
				            		}
				            		IoData ioD = new IoData(); // storing one row of io stats
				            		ioD.setUserId(this.userId);
				            		ioD.setMachineId(this.machineId);
				            		ioD.setOccurance(this.occurance);
				            		ioD.setDevice(list.get(0));
				            		ioD.setTps(list.get(1));
				            		ioD.setReadSpeed(list.get(2));
				            		ioD.setWriteSpeed(list.get(3));
				            		ioD.setRead(list.get(4));
				            		ioD.setWrite(list.get(5));
				            		this.ioDataServ.save(ioD); // pushing one row onto the database
				            		list.clear();
				            		line = in.readUTF();
				            	}
				            	line = in.readUTF();
				            	System.out.println("<=======>" + line);
				            }
				            
				        } 
				        catch(IOException i) 
				        { 
				            System.out.println(i); 
				        } 
				        
				    }
				    
				    this.userIdDB = in.readUTF();
				    this.machineIdDB = in.readUTF();
				    System.out.println("User ID DB:" + this.userIdDB);
		        	System.out.println("Machine ID DB: " + this.machineIdDB);
				    
				    while (!line.contains("Over2")) { 
					    line = in.readUTF();
					    line = in.readUTF();
					    String[] feat = line.split(" ");
					    while(feat.length > 1) {  // reading host summary by stats
					    	HostSumByStatData hsbsD = new HostSumByStatData(); // creating object to store one row of these stats
					    	for (int i = 0; i < feat.length; i++) {
					    		list.add(feat[i]);
					    	}
					    	hsbsD.setHost(list.get(0));
					    	hsbsD.setUserId(this.userId);
					    	hsbsD.setMachineId(this.machineId);
					    	hsbsD.setOccurance(this.occurance);
					    	hsbsD.setStatement(list.get(1));
					    	hsbsD.setTotal(list.get(2));
					    	hsbsD.setTotal_latency(list.get(3));
					    	hsbsD.setMax_latency(list.get(4));
					    	hsbsD.setLock_latency(list.get(5));
					    	hsbsD.setRows_sent(list.get(6));
					    	hsbsD.setRows_examined(list.get(7));
					    	hsbsD.setRows_affected(list.get(8));
					    	hsbsD.setFull_scans(list.get(9));
					    	line = in.readUTF();
					    	this.hostSumByStatDataServ.save(hsbsD); // pushing the object unto the database
					    	feat = line.split(" ");
					    	list.clear();
					    }
					    line = in.readUTF();
					    line = in.readUTF();
					    feat = line.split(" ");
					    while(feat.length > 1) { // reading host summary 
					    	HostSummaryData hsD = new HostSummaryData(); // creating object to store one row of these stats
					    	for (int i = 0; i < feat.length; i++) {
					    		list.add(feat[i]);
					    	}
					    	hsD.setUserId(this.userId);
					    	hsD.setMachineId(this.machineId);
					    	hsD.setOccurance(this.occurance);
					    	hsD.setHost(list.get(0));
					    	hsD.setStatement(list.get(1));
					    	hsD.setStatement_latency(list.get(2));
					    	hsD.setStatement_avg_lat(list.get(4));
					    	hsD.setTable_scans(list.get(6));
					    	hsD.setFile_ios(list.get(7));
					    	hsD.setFile_io_lat(list.get(8));
					    	hsD.setCurrent_connect(list.get(10));
					    	hsD.setTotal_connect(list.get(11));
					    	hsD.setUnique_users(list.get(12));
					    	hsD.setCurrent_memory(list.get(13));
					    	hsD.setTotal_memory_allocated(list.get(15));
					    	hsD.setAnomaly("0");
					    	line = in.readUTF();
					    	this.hostSummaryServ.save(hsD); // pushing the object unto the database
					    	feat = line.split(" ");
					    	list.clear();
					    }
					    
					    line = in.readUTF();
					    line = in.readUTF();
					    feat = line.split(" ");
					    while (feat.length > 1) { // reading process list 
					    	ProcessListData plD = new ProcessListData(); // creating an object to store one row of process list
					    	for (int i = 0; i < feat.length; i++) {
					    		list.add(feat[i]);
					    	}
					    	plD.setUser(this.userId);
					    	plD.setMachineId(this.machineId);
					    	plD.setOccurance(this.occurance);
					    	plD.setThid_id(list.get(0));
					    	plD.setConn_id(list.get(1));
					    	plD.setUser(list.get(2));
					    	plD.setDb(list.get(3));
					    	plD.setCommand(list.get(4));
					    	plD.setState(list.get(5));
					    	plD.setTime(list.get(6));
					    	plD.setCurrent_stat(list.get(7));
					    	plD.setStat_lat(list.get(8));
					    	plD.setProgress(list.get(9));
					    	plD.setLock_lat(list.get(10));
					    	plD.setRows_examined(list.get(11));
					    	plD.setRows_sent(list.get(12));
					    	plD.setRows_affected(list.get(13));
					    	plD.setTmp_tables(list.get(14));
					    	plD.setTmp_disk_tables(list.get(15));
					    	plD.setFull_scan(list.get(16));
					    	plD.setLast_statement(list.get(17));
					    	plD.setLast_stat_lat(list.get(18));
					    	plD.setCurr_mem(list.get(19));
					    	plD.setLast_wait(list.get(20));
					    	plD.setLast_wait_lat(list.get(21));
					    	plD.setSource(list.get(22));
					    	plD.setTrx_lat(list.get(23));
					    	plD.setTrx_state(list.get(24));
					    	plD.setTrx_autocommit(list.get(25));
					    	plD.setPid(list.get(26));
					    	plD.setProgram_name(list.get(27));
					    	line = in.readUTF();
					    	this.processListServ.save(plD); // pushing the object unto the database
					    	feat = line.split(" ");
					    	list.clear();
					    }
					    
					    line = in.readUTF();
					    line = in.readUTF();
					    feat = line.split(" ");
					    while (feat.length > 1) { // reading statement analysis stats
					    	int length = feat.length;
					    	for (int i = 0; i < feat.length; i++) {
					    		list.add(feat[i]);
					    	}
					    	StatementAnalysisData saD = new StatementAnalysisData(); // creating object ot store one row of statement analysis
					    	saD.setLast_seen(list.get(length - 1) + " " + list.get(length - 2));
					    	saD.setUserId(this.userId);
					    	saD.setMachineId(this.machineId);
					    	saD.setOccurance(this.occurance);
					    	saD.setFirst_seen(list.get(length - 4) + " " + list.get(length - 3));
					    	saD.setDigest(list.get(length - 5));
					    	saD.setSort_merge_passes(list.get(length - 6));
					    	saD.setRows_sorted(list.get(length - 7));
					    	saD.setTmp_disk_tables(list.get(length - 8));
					    	saD.setTmp_tables(list.get(length - 9));
					    	saD.setRows_affected_avg(list.get(length - 10));
					    	saD.setRows_affected(list.get(length - 11));
					    	saD.setRows_examined_avg(list.get(length - 12));
					    	saD.setRows_examined(list.get(length - 13));
					    	saD.setRows_sent_avg(list.get(length - 14));
					    	saD.setRows_sent(list.get(length - 15));
					    	saD.setLock_lat(list.get(length - 17));
					    	saD.setAvg_lat(list.get(length - 19));
					    	saD.setMax_lat(list.get(length - 21));
					    	saD.setTotal_lat(list.get(length - 23));
					    	saD.setWarn_count(list.get(length - 24));
					    	saD.setErr_count(list.get(length - 25));
					    	saD.setExec_count(list.get(length - 26));
					    	saD.setFull_scan(list.get(length - 27));
					    	saD.setDb(list.get(length - 28));
					    	String query = "";
					    	for (int j = 0; j < length - 28; j++) {
					    		query = query + list.get(j) + " ";
					    	}
					    	
					    	saD.setQuery(query);
					    	line = in.readUTF();
					    	this.statementAnalysisServ.save(saD); // pushes the object unto the database
					    	feat = line.split(" ");
					    	list.clear();
					    }
				    }
				    while (!line.contains("Over3")) {
				    	line = in.readUTF();
				    	if (line.contains("Instances: ")) {
				    		while (!line.contains("All Classes")) {
				    			String[] arr = line.split(" ");
					    		HeapData hD = new HeapData();
					    		hD.setInstances(arr[1]);
					    		hD.setMemory(arr[4]);
					    		hD.setClassName(arr[6]);
					    		hD.setUsrId(this.userId);
					    		hD.setOccurance(this.occurance);
					    		this.heapDataServ.save(hD);
					    		line = in.readUTF();
				    		}
				    	}
				    	System.out.println("Heap Data Saved...");
				    	if (line.contains("All Classes")) {
				    		line = in.readUTF();
				    		int part = 0;
				    		while (!line.contains("All Classes")) {
				    			HeapDumpData hdD = new HeapDumpData();
				    			hdD.setOccurance(this.occurance);
					    		hdD.setUserId(this.userId);
					    		hdD.setType("All Classes");
					    		hdD.setTypeOutput(line);
					    		hdD.setPart(part);
					    		part++;
					    		this.heapDumpDataServ.save(hdD);
				    			line = in.readUTF();
				    			
				    		}
				    		
				    		
				    	}
				    	line = in.readUTF();
				    	line = in.readUTF();
				    	HeapDumpData hdD = new HeapDumpData();
				    	hdD.setOccurance(this.occurance);
			    		hdD.setUserId(this.userId);
			    		hdD.setType("Total Instances");
			    		hdD.setTypeOutput(line);
			    		this.heapDumpDataServ.save(hdD);
				    	line = in.readUTF();
				    	line = in.readUTF();
				    	String[] arr = line.split(" ");
				    	line = in.readUTF();
				    	hdD = new HeapDumpData();
				    	hdD.setOccurance(this.occurance);
			    		hdD.setUserId(this.userId);
			    		hdD.setType(arr[1] + " Instances");
			    		hdD.setTypeOutput(line);
			    		this.heapDumpDataServ.save(hdD);
				    	line = in.readUTF();
				    	line = in.readUTF();
				    	line = in.readUTF();
				    	hdD = new HeapDumpData();
				    	hdD.setOccurance(this.occurance);
			    		hdD.setUserId(this.userId);
			    		hdD.setType("Total Classes");
			    		hdD.setTypeOutput(line);
			    		this.heapDumpDataServ.save(hdD);
				    	line = in.readUTF();
				    	line = in.readUTF();
				    	System.out.println(line);
				    	line = in.readUTF();
				    	hdD = new HeapDumpData();
				    	hdD.setOccurance(this.occurance);
			    		hdD.setUserId(this.userId);
			    		hdD.setType("Total Memory Used (Bytes)");
			    		hdD.setTypeOutput(line);
			    		this.heapDumpDataServ.save(hdD);
				    	line = in.readUTF();
				    	line = in.readUTF();
				    	arr = line.split(" ");
				    	line = in.readUTF();
				    	hdD = new HeapDumpData();
				    	hdD.setOccurance(this.occurance);
			    		hdD.setUserId(this.userId);
			    		hdD.setType("Memory Used By " + arr[4] + "(Bytes)");
			    		hdD.setTypeOutput(line);
			    		this.heapDumpDataServ.save(hdD);
				    	line = in.readUTF();
				    	line = in.readUTF();
				    	System.out.println("Heap Dump Data Saved...");
				    	if (line.contains("All Methods for thread ")) {
				    		arr = line.split(" ");
				    		line = in.readUTF();
				    		line = in.readUTF();
				    		int part = 0;
				    		while (!line.contains("All Methods for thread")) {
				    			if (line.length() > 2) {
				    				StackData sD = new StackData();
						    		sD.setOccurance(this.occurance);
						    		sD.setUsrId(this.userId);
						    		sD.setType(arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " + arr[5]);
				    				sD.setTypeOutput(line);
				    				sD.setPart(part);
				    				this.stackDataServ.save(sD);
				    				part++;
				    			}
				    			line = in.readUTF();
				    		}
				    		
				    	}
				    	line = in.readUTF();
				    	line = in.readUTF();
				    	StackData sD = new StackData();
				    	sD.setOccurance(this.occurance);
				    	sD.setUsrId(this.userId);
				    	sD.setType("All Methods Count");
				    	sD.setTypeOutput(line);
				    	this.stackDataServ.save(sD);
				    	line = in.readUTF();
				    	line = in.readUTF();
				    	arr = line.split(" ");
				    	line = in.readUTF();
				    	sD = new StackData();
				    	sD.setOccurance(this.occurance);
				    	sD.setUsrId(this.userId);
				    	sD.setType(arr[1]);
				    	sD.setTypeOutput(line);
				    	this.stackDataServ.save(sD);
				    	line = in.readUTF();
				    	line = in.readUTF();
				    	if (line.contains("All Methods All Threads")) {
				    		line = in.readUTF();
				    		int part = 0;
				    		while (!line.contains("All Methods All Threads")) {
				    			if (line.length() > 2) {
				    				sD = new StackData();
							    	sD.setOccurance(this.occurance);
							    	sD.setUsrId(this.userId);
							    	sD.setType("All Methods All Threads");
							    	sD.setTypeOutput(line);
							    	sD.setPart(part);
							    	part++;
							    	this.stackDataServ.save(sD);
				    			}
				    			line = in.readUTF();
				    		}
				    		
				    	}
				    	System.out.println("Stack Data Saved...");
				    	line = in.readUTF();
				    	if (line.contains("Priority and State")) {
				    		line = in.readUTF();
				    		int part = 0;
				    		while (!line.contains("Priority and State")) {
				    			ThreadData tD = new ThreadData();
					    		tD.setOccurance(this.occurance);
						    	tD.setUsrId(this.userId);
						    	tD.setType("Priority And State");
						    	tD.setTypeOutput(line);
						    	tD.setPart(part);
						    	this.threadDataServ.save(tD);
				    			line = in.readUTF();
				    			part++;
				    		}
				    	}
				    	line = in.readUTF();
				    	
				    	while (line.contains("Time")) {
				    		ThreadData tD = new ThreadData();
				    		tD.setOccurance(this.occurance);
					    	tD.setUsrId(this.userId);
					    	arr = line.split(" ");
					    	tD.setType(arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " + arr[5]);
				    		line = in.readUTF();
				    		tD.setTypeOutput(line);
					    	this.threadDataServ.save(tD);
				    		line = in.readUTF();
				    		line = in.readUTF();
				    	}
				    	
				    	
				    	if (line.contains("Locked Resources")) {
				    		line = in.readUTF();
				    		int part = 0;
				    		
					    	
				    		while (!line.contains("Locked Resources")) {
				    			String output = "";
				    			output = line;
				    			line = in.readUTF();
				    			arr = line.split(" ");
				    			for (int i = 0; i < arr.length; i++) {
				    				if (arr[i].length() != 0) {
				    					output = output + ", " + arr[i];
				    				}
				    			}
				    			ThreadData tD = new ThreadData();
					    		tD.setOccurance(this.occurance);
						    	tD.setUsrId(this.userId);
						    	tD.setType("Locked Resources");
						    	tD.setPart(part);
						    	tD.setTypeOutput(output);
						    	this.threadDataServ.save(tD);
						    	part++;
						    	line = in.readUTF();
				    		}
				    	}
				    	line = in.readUTF();
				    	if (line.contains("Blocked Count")) {
				    		line = in.readUTF();
				    		int part = 0;
				    		while (!line.contains("Blocked Count")) {
				    			ThreadData tD = new ThreadData();
					    		tD.setOccurance(this.occurance);
						    	tD.setUsrId(this.userId);
						    	tD.setType("Blocked Count");
						    	tD.setTypeOutput(line);
						    	tD.setPart(part);
						    	this.threadDataServ.save(tD);
						    	line = in.readUTF();
						    	part++;
				    		}
				    		
				    	}
				    	line = in.readUTF();
				    	if (line.contains("Wait Count")) {
				    		line = in.readUTF();
				    		int part = 0;
				    		while (!line.contains("Wait Count")) {
				    			ThreadData tD = new ThreadData();
					    		tD.setOccurance(this.occurance);
						    	tD.setUsrId(this.userId);
						    	tD.setType("Wait Count");
						    	tD.setTypeOutput(line);
						    	tD.setPart(part);
						    	this.threadDataServ.save(tD);
				    			line = in.readUTF();
				    			part++;
				    		}
				    		
				    	}
				    	line = in.readUTF();
				    	System.out.println("Thread Data Saved...");
				    	System.out.println("Saving Data Onto Database Completed Successfully!");
				    	break;
				    }
				    
				    
				    break;
					
				
			}
		} catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        System.out.println("Closing connection"); 

        // close connection 
        try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        try {
			in.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
}
