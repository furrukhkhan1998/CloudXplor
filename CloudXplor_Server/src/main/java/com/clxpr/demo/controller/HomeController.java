package com.clxpr.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clxpr.demo.controller.HeapDump.AC;
import com.clxpr.demo.controller.HeapDump.SI;
import com.clxpr.demo.controller.HeapDump.SM;
import com.clxpr.demo.controller.HeapDump.TC;
import com.clxpr.demo.controller.HeapDump.TI;
import com.clxpr.demo.controller.HeapDump.TM;
import com.clxpr.demo.controller.StackDump.AMC;
import com.clxpr.demo.controller.StackDump.AllThread;
import com.clxpr.demo.controller.StackDump.MC;
import com.clxpr.demo.controller.StackDump.SingleThread;
import com.clxpr.demo.controller.ThreadDump.BC;
import com.clxpr.demo.controller.ThreadDump.CT;
import com.clxpr.demo.controller.ThreadDump.LR;
import com.clxpr.demo.controller.ThreadDump.PnS;
import com.clxpr.demo.controller.ThreadDump.UT;
import com.clxpr.demo.controller.ThreadDump.WC;
import com.clxpr.demo.model.db.CpuData;
import com.clxpr.demo.model.db.DiskData;
import com.clxpr.demo.model.db.IoData;
import com.clxpr.demo.model.db.MemData;
import com.clxpr.demo.model.heapdumpmodel.AllClasses;
import com.clxpr.demo.model.heapdumpmodel.ClassInstance;
import com.clxpr.demo.model.heapdumpmodel.ClassMemory;
import com.clxpr.demo.model.heapdumpmodel.TotalClasses;
import com.clxpr.demo.model.heapdumpmodel.TotalInstances;
import com.clxpr.demo.model.heapdumpmodel.TotalMemoryUsed;
import com.clxpr.demo.model.json.Data;
import com.clxpr.demo.model.json.DataCpu;
import com.clxpr.demo.model.json.DataDisk;
import com.clxpr.demo.model.json.DataHeap;
import com.clxpr.demo.model.json.DataHeapDump;
import com.clxpr.demo.model.json.DataHostSumByStat;
import com.clxpr.demo.model.json.DataHostSummary;
import com.clxpr.demo.model.json.DataIo;
import com.clxpr.demo.model.json.DataMem;
import com.clxpr.demo.model.json.DataPid;
import com.clxpr.demo.model.json.DataPidSched;
import com.clxpr.demo.model.json.DataStack;
import com.clxpr.demo.model.json.DataStatementAnalysis;
import com.clxpr.demo.model.json.DataThread;
import com.clxpr.demo.model.json.HeapDataClass;
import com.clxpr.demo.model.json.HeapDumpDataClass;
import com.clxpr.demo.model.json.MachineData;
import com.clxpr.demo.repo.CpuDataRepository;
import com.clxpr.demo.repo.DiskDataRepository;
import com.clxpr.demo.repo.HostSumByStatDataRepository;
import com.clxpr.demo.repo.HostSummaryRepository;
import com.clxpr.demo.repo.IoDataRepository;
import com.clxpr.demo.repo.MemDataRepository;
import com.clxpr.demo.repo.PidDataRepository;
import com.clxpr.demo.repo.PidSchedDataRepository;
import com.clxpr.demo.repo.ResourceDataRepository;
import com.clxpr.demo.repo.StatementAnalysisRepository;
import com.clxpr.demo.repo.ThreadDataRepository;
import com.clxpr.demo.repo.StackDataRepository;
import com.clxpr.demo.repo.HeapDataRepository;
import com.clxpr.demo.repo.HeapDumpDataRepository;
import com.clxpr.demo.model.stackmodel.AllMethodsAllThread;
import com.clxpr.demo.model.stackmodel.AllMethodsCount;
import com.clxpr.demo.model.stackmodel.AllMethodsOneThread;
import com.clxpr.demo.model.stackmodel.MethodCount;
import com.clxpr.demo.model.threadmodel.BlockedCount;
import com.clxpr.demo.model.threadmodel.CpuTimeForThread;
import com.clxpr.demo.model.threadmodel.LockedResource;
import com.clxpr.demo.model.threadmodel.PriorityAndStateThread;
import com.clxpr.demo.model.threadmodel.UserTimeForThread;
import com.clxpr.demo.model.threadmodel.WaitCount;
import com.clxpr.demo.model.json.StackDumpDataClass;
import com.clxpr.demo.model.json.ThreadDataClass;
import com.google.gson.Gson;
import com.clxpr.demo.controller.Heap.JavaClass;




@RestController
@RequestMapping("/api/v1/") // the MAIN path 
public class HomeController {  // auto wiring the repo classes for spring to instantiate the objects of these classes
@Autowired
ResourceDataRepository RDrepo;
@Autowired
CpuDataRepository CpuDrepo;
@Autowired
DiskDataRepository DiskDrepo;
@Autowired
IoDataRepository IoDrepo;
@Autowired
MemDataRepository MemDrepo;
@Autowired
PidDataRepository PidDrepo;
@Autowired
PidSchedDataRepository PidSchedDrepo;
@Autowired
HostSummaryRepository HostSummaryrepo;
@Autowired
HostSumByStatDataRepository HostSumByStatDrepo;
@Autowired
StatementAnalysisRepository StatementAnalysisDrepo;
@Autowired
HeapDumpDataRepository HeapDumpDrepo;
@Autowired
HeapDataRepository HeapDrepo;
@Autowired
StackDataRepository StackDrepo;
@Autowired
ThreadDataRepository ThreadDrepo; 




String machineId = "";
String userId =  "";
private Integer prevCpuOccurance = 0;
private Integer prevIoOccurance;
private Integer prevDiskOccurance;
		

	@GetMapping( 
	        path = "/resourceData", // process stats extracted from database for web application 
	        produces = "application/json") 
	public Collection<Data> getRD(){
		Collection<Data> data = new ArrayList<Data>();
		RDrepo.findAll().forEach(d->{
			data.add(new Data(d.getUserId(),d.getMachineId(),d.getOccurance(), d.getId(), d.getTime(), d.getUid(), d.getPid(), d.getRd(), d.getWr(), d.getCcwr(), d.getIodelay(), d.getCommand()));
		});
		
		return data;
	}
	
	@GetMapping( 
	        path = "/cpuData",  // cpu stats extracted from database for web application 
	        produces = "application/json")
	public List<CpuData> findLatest(){
		Integer occurance =  CpuDrepo.getLatestEntry(machineId,userId);
		List<CpuData> random = new ArrayList<CpuData>();
		if(this.prevCpuOccurance != occurance)
		{
			random = CpuDrepo.findLatest(machineId, userId, occurance);
			this.prevCpuOccurance  = occurance;
		}
		return random;
	}
	
	
	
	
	@GetMapping( 
	        path = "/diskData",  // disk stats extracted from database for web application 
	        produces = "application/json") 
	public List<DiskData> findLatestDisk(){
		Integer occurance =  DiskDrepo.getLatestEntry(machineId,userId);
		List<DiskData> random = new ArrayList<DiskData>();
		if(this.prevDiskOccurance != occurance)
		{
			random = DiskDrepo.findLatestRows(machineId, userId, occurance);
			this.prevDiskOccurance  = occurance;
		}
		return random;
	
	}
	
	@GetMapping( 
	        path = "/ioData",  // io stats extracted from database for web application 
	        produces = "application/json") 
			public List<IoData> findIoLatest(){
		Integer occurance =  IoDrepo.getLatestEntry(machineId,userId);
		System.out.println(occurance);
		List<IoData> random = new ArrayList<IoData>();
		if(this.prevIoOccurance != occurance)
		{
			random = IoDrepo.findLatest(machineId, userId, occurance);
			this.prevIoOccurance  = occurance;
		}
		return random;
	}
	
	@GetMapping( 
	        path = "/memData",  // mem stats extracted from database for web application 
	        produces = "application/json") 
	public Collection<DataMem> getMemD(){
		Collection<DataMem> data = new ArrayList<DataMem>();
		MemDrepo.findByMachineIdAndUserId(machineId, userId).forEach(d->{
			if(MemDrepo.getLatestEntry(machineId, userId) == d.getOccurance())
			{
				data.add(new DataMem(d.getUserId(),d.getMachineId(),d.getOccurance(),d.getR(), d.getB(), d.getSwpd(), d.getFree(), d.getInact(), d.getActive(), d.getSi(), d.getSo(), d.getBi(), d.getBo(), d.getIn(), d.getCs(), d.getUs(),d.getSy(),d.getId(),d.getWa(),d.getSt(), d.getAnomaly(), d.getLogNo(), d.getTime()));
			}
			});
		return data;
	}
	
	@GetMapping( 
	        path = "/pidData",  // pid stats extracted from database for web application 
	        produces = "application/json") 
	public Collection<DataPid> getPidD(){
		Collection<DataPid> data = new ArrayList<DataPid>();
		PidDrepo.findByMachineIdAndUserId(machineId, userId).forEach(d->{
			if(PidDrepo.getLatestEntry(machineId, userId) == d.getOccurance())
			{
				data.add(new DataPid(d.getUserId(),d.getMachineId(),d.getOccurance(),d.getTime(),d.getUid(),d.getPid(),d.getUsr(),d.getSystem(),d.getGuest(),d.getWait(),d.getCpu(),d.getCpuNo(),d.getCmd(), d.getId()));
				
			}
			});
		return data;
	}
	
	@GetMapping( 
	        path = "/pidSchedData",  // pid sched stats extracted from database for web application 
	        produces = "application/json") 
	public Collection<DataPidSched> getPidSchedD(){
		Collection<DataPidSched> data = new ArrayList<DataPidSched>();
		PidSchedDrepo.findByMachineIdAndUserId(machineId, userId).forEach(d->{
			if(PidSchedDrepo.getLatestEntry(machineId, userId) == d.getOccurance())
			{
				data.add(new DataPidSched(d.getUserId(),d.getMachineId(),d.getOccurance(),d.getTime(), d.getUid(), d.getPid(), d.getPriority(), d.getPolicy(), d.getCmd(), d.getId()));
				
			}
			});
		return data;
	}
	@GetMapping( 
	        path = "/HostSummary",  // pid sched stats extracted from database for web application 
	        produces = "application/json") 
	public Collection<DataHostSummary> getHostSummaryD(){
		Collection<DataHostSummary> data = new ArrayList<DataHostSummary>();
		HostSummaryrepo.findByMachineIdAndUserId(machineId, userId).forEach(d->{
			if(HostSummaryrepo.getLatestEntry(machineId, userId) == d.getOccurance())
			{
				data.add(new DataHostSummary(d.getUserId(),d.getMachineId(),d.getOccurance(),d.getId(), d.getHost(), d.getStatement(), d.getStatement_latency(), d.getStatement_avg_lat(), d.getTable_scans(),
						d.getFile_ios(), d.getFile_io_lat(), d.getCurrent_connect(), d.getTotal_connect(), d.getUnique_users(), d.getCurrent_memory(),
						d.getTotal_memory_allocated(), d.getAnomaly()));
			}
			});
		return data;
	}
	
	@GetMapping(
			path = "/HostSummaryByStatement",
			produces = "application/json")
	public Collection<DataHostSumByStat> getHostSummByStatD() {
		Collection<DataHostSumByStat> data = new ArrayList<DataHostSumByStat>();
		HostSumByStatDrepo.findByMachineIdAndUserId(machineId, userId).forEach(d-> {
			if(HostSumByStatDrepo.getLatestEntry(machineId, userId) == d.getOccurance())
			{
				data.add(new DataHostSumByStat(d.getUserId(),d.getMachineId(),d.getOccurance(),d.getId(), d.getHost(), d.getStatement(), d.getTotal(), d.getTotal_latency(), d.getMax_latency(),
						d.getLock_latency(), d.getRows_sent(), d.getRows_affected(), d.getRows_examined(), d.getFull_scans()));
			}
			});
		return data;
	}
	
	@GetMapping(
			path = "/StatementAnalysis",
			produces = "application/json")
	public Collection<DataStatementAnalysis> getStatementAnalysisD() {
		Collection <DataStatementAnalysis> data = new ArrayList <DataStatementAnalysis> ();
		StatementAnalysisDrepo.findByMachineIdAndUserId(machineId, userId).forEach(d-> {
			if(StatementAnalysisDrepo.getLatestEntry(machineId, userId) == d.getOccurance())
			{
				data.add(new DataStatementAnalysis(d.getUserId(),d.getMachineId(),d.getOccurance(),d.getId(), d.getQuery(), d.getDb(), d.getExec_count(), d.getErr_count(), d.getTotal_lat(), d.getMax_lat(),
						d.getAvg_lat(), d.getLock_lat(), d.getRows_affected(), d.getRows_examined(), d.getRows_sent(), d.getFirst_seen(), d.getLast_seen()));
			
			}
			});
		return data;
	}
	
	@GetMapping(
			path = "/HeapDump",
			produces = "application/json")
	public HeapDumpDataClass getHeapDumpD() {
		ArrayList <DataHeapDump> data = new ArrayList <DataHeapDump> ();
		HeapDumpDrepo.findAllByOccurance(HeapDumpDrepo.getLatestEntry()).forEach(d-> {
			data.add(new DataHeapDump(d.getUserId(),d.getMachineId(),d.getOccurance(),d.getId(),d.getPart(),d.getType(),d.getTypeOutput()));
		});
		ArrayList <Object> objects = new HeapDump().getHeapDumpObjects(data);
		
		AllClasses ac = new AllClasses();
		ClassInstance ci = new ClassInstance();
		ClassMemory cm = new ClassMemory();
		TotalClasses tc = new TotalClasses();
		TotalInstances ti = new TotalInstances();
		TotalMemoryUsed tmu = new TotalMemoryUsed();
		
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i) instanceof AC) {
				AC temp = (AC) objects.get(i);
				ac.setClasses(temp.classes);
			} else if (objects.get(i) instanceof TI) {
				TI temp = (TI) objects.get(i);
				ti.setInstances(Integer.parseInt(temp.totalInstances));
			} else if (objects.get(i) instanceof SI) {
				SI temp = (SI) objects.get(i);
				ci.setName(temp.type);
				ci.setInstances(Integer.parseInt(temp.instances));
			} else if (objects.get(i) instanceof TC) {
				TC temp = (TC) objects.get(i);
				tc.setClasses(Integer.parseInt(temp.total));
			} else if (objects.get(i) instanceof TM) {
				TM temp = (TM) objects.get(i);
				tmu.setMemory(Long.parseLong(temp.memory));
			} else if (objects.get(i) instanceof SM) {
				SM temp = (SM) objects.get(i);
				cm.setName(temp.type);
				cm.setMemory(Long.parseLong(temp.memory));
			} 
		}
		
		return new HeapDumpDataClass(ac, ci, cm, tc, ti, tmu);
	}
	
	@GetMapping(
			path = "/Heap",
			produces = "application/json")
	public HeapDataClass getHeapD() {
		ArrayList <DataHeap> data = new ArrayList <DataHeap> ();
		HeapDrepo.findAllByOccurance(HeapDumpDrepo.getLatestEntry()).forEach(d-> {
			data.add(new DataHeap(d.getUsrId(), d.getOccurance(), d.getMachineId(), d.getInstances(), d.getMemory(), d.getClassName(), d.getId()));
		});
		ArrayList <JavaClass> objects = new Heap().getHeapObjects(data);
		
		com.clxpr.demo.model.heapmodel.Heap heap = new com.clxpr.demo.model.heapmodel.Heap();
		ArrayList <String> instances = new ArrayList <String> ();
		ArrayList <String> memory = new ArrayList <String> ();
		ArrayList <String> name = new ArrayList <String> ();
		for (int i = 0; i < objects.size(); i++) {
			name.add(objects.get(i).name);
			memory.add(objects.get(i).memory);
			instances.add(objects.get(i).instances);
		}
		heap.setInstances(instances);
		heap.setMemory(memory);
		heap.setName(name);
		return new HeapDataClass(heap);
	}
	
	
	
	

	
	@GetMapping(
			path = "/StackDump",
			produces = "application/json")
	public StackDumpDataClass getStackD() {
		System.out.println("Hittt");
		ArrayList <DataStack> data = new ArrayList <DataStack> ();
		StackDrepo.findAllByOccurance(StackDrepo.getLatestEntry()).forEach(d-> {
			data.add(new DataStack(d.getUsrId(), d.getMachineId(), d.getOccurance(), d.getType(), d.getTypeOutput(), d.getPart(), d.getId()));
		});
		ArrayList <Object> objects = new StackDump().getStackObjects(data);
		ArrayList <String> s11 = new ArrayList <String> ();
		ArrayList <String> s22 = new ArrayList <String> ();
		ArrayList <String> s33 = new ArrayList <String> ();
		ArrayList <String> s44 = new ArrayList <String> ();
		AllMethodsAllThread amat = new AllMethodsAllThread();
		AllMethodsCount amc = new AllMethodsCount();
		AllMethodsOneThread amot = new AllMethodsOneThread();
		AllMethodsOneThread amot1 = new AllMethodsOneThread();
		MethodCount mc = new MethodCount();
		System.out.println(objects.size());
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i) instanceof AllThread) {
				AllThread temp = (AllThread) objects.get(i);
				ArrayList<AllMethodsOneThread> amotList = new ArrayList<AllMethodsOneThread> ();
				amot.setId(Integer.parseInt(temp.ids.get(0)));
				ArrayList <String> s1 = new ArrayList <String> ();
				ArrayList <String> s2 = new ArrayList <String> ();
				ArrayList <String> s3 = new ArrayList <String> ();
				ArrayList <String> s4 = new ArrayList <String> ();
				s1.add(temp.methods.get(0));
				s2.add(temp.caller.get(0));
				s3.add(temp.line.get(0));
				s4.add(temp.file.get(0));
				for (int j = 1; j < temp.ids.size(); j++) {
					if (temp.ids.get(j).equals(temp.ids.get(j - 1))) {
						s1.add(temp.methods.get(j));
						s2.add(temp.caller.get(j));
						s3.add(temp.line.get(j));
						s4.add(temp.file.get(j));
					} else {
						amot.setMethod(s1);
						amot.setClassName(s2);
						amot.setLineNumber(s3);
						amot.setFileName(s4);
						amotList.add(amot);
						s1 = new ArrayList <String> ();
						s2 = new ArrayList <String> ();
						s3 = new ArrayList <String> ();
						s4 = new ArrayList <String> ();
						amot = new AllMethodsOneThread();
						amot.setId(Integer.parseInt(temp.ids.get(j)));
						s1.add(temp.methods.get(j));
						s2.add(temp.caller.get(j));
						s3.add(temp.line.get(j));
						s4.add(temp.file.get(j));
					}
				}
				amat.setArr(amotList);
				s1 = new ArrayList <String> ();
				s2 = new ArrayList <String> ();
				s3 = new ArrayList <String> ();
				s4 = new ArrayList <String> ();
			} else if (objects.get(i) instanceof AMC) {
				AMC temp = (AMC) objects.get(i);
				amc.setCount(Integer.parseInt(temp.count));
			} else if (objects.get(i) instanceof MC) {
				MC temp = (MC) objects.get(i);
				mc.setCount(Integer.parseInt(temp.count));
				mc.setName(temp.name);
			} else if (objects.get(i) instanceof SingleThread) {
				SingleThread temp = (SingleThread) objects.get(i);
				amot1.setId(Integer.parseInt(temp.id));
				s11.add(temp.methodName);
				s22.add(temp.className);
				s33.add(temp.line);
				s44.add(temp.fileName);
			}
		}
		
		amot1.setMethod(s11);
		amot1.setClassName(s22);
		amot1.setLineNumber(s33);
		amot1.setFileName(s44);
		
		return new StackDumpDataClass(amat,amc,amot1,mc);
	}
	
	@GetMapping(
			path = "/ThreadDump",
			produces = "application/json")
	public ThreadDataClass getThreadD() {
		ArrayList <DataThread> data = new ArrayList <DataThread> ();
		ThreadDrepo.findAllByOccurance(ThreadDrepo.getLatestEntry()).forEach(d-> {
			data.add(new DataThread(d.getUsrId(), d.getOccurance(), d.getMachineId(), d.getType(), d.getTypeOutput(), d.getPart(), d.getId()));
		});
		ArrayList <Object> objects = new ThreadDump().getThreadObjects(data);
		
		BlockedCount bc = new BlockedCount();
		CpuTimeForThread cpu = new CpuTimeForThread();
		LockedResource lr = new LockedResource();
		PriorityAndStateThread ps = new PriorityAndStateThread();
		UserTimeForThread usr = new UserTimeForThread();
		WaitCount wc = new WaitCount();
		ArrayList <String> s1 = new ArrayList <String> ();
		ArrayList <String> s2 = new ArrayList <String> ();
		ArrayList <String> s3 = new ArrayList <String> ();
		ArrayList <ArrayList <String>> s4 = new ArrayList <ArrayList <String>> ();
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i) instanceof PnS) {
				PnS temp = (PnS) objects.get(i);
				for (int j = 0; j < temp.threads.size(); j++) {
					s1.add(temp.threads.get(j).id);
					s2.add(temp.threads.get(j).priority);
					s3.add(temp.threads.get(j).state);
				}
				ps.setId(s1);
				ps.setPriority(s2);
				ps.setState(s3);
				s1 = new ArrayList <String> ();
				s2 = new ArrayList <String> ();
				s3 = new ArrayList <String> ();
			} else if (objects.get(i) instanceof CT) {
				CT temp = (CT) objects.get(i);
				for (int j = 0; j < temp.threads.size(); j++) {
					s1.add(temp.threads.get(j).id);
					s2.add(temp.threads.get(j).time);
				}
				cpu.setId(s1);
				cpu.setTime(s2);
				s1 = new ArrayList <String> ();
				s2 = new ArrayList <String> ();
			} else if (objects.get(i) instanceof UT) {
				UT temp = (UT) objects.get(i);
				for (int j = 0; j < temp.threads.size(); j++) {
					s1.add(temp.threads.get(j).id);
					s2.add(temp.threads.get(j).time);
				}
				usr.setId(s1);
				usr.setTime(s2);
				s1 = new ArrayList <String> ();
				s2 = new ArrayList <String> ();
			} else if (objects.get(i) instanceof LR) {
				LR temp = (LR) objects.get(i);
				for (int j = 0; j < temp.threads.size(); j++) {
					s1.add(temp.threads.get(j).id);
					s4.add(temp.threads.get(j).monitors);
				}
				lr.setThread(s1);
				lr.setMonitors(s4);
				s1 = new ArrayList <String> ();
			} else if (objects.get(i) instanceof BC) {
				BC temp = (BC) objects.get(i);
				for (int j = 0; j < temp.threads.size(); j++) {
					s1.add(temp.threads.get(j).id);
					s2.add(temp.threads.get(j).count);
				}
				bc.setId(s1);
				bc.setCount(s2);
				s1 = new ArrayList <String> ();
				s2 = new ArrayList <String> ();
			} else if (objects.get(i) instanceof WC) {
				WC temp = (WC) objects.get(i);
				for (int j = 0; j < temp.threads.size(); j++) {
					s1.add(temp.threads.get(j).id);
					s2.add(temp.threads.get(j).count);
				}
				wc.setId(s1);
				wc.setCount(s2);
				s1 = new ArrayList <String> ();
				s2 = new ArrayList <String> ();
			}
		}
		
		return new ThreadDataClass(bc, cpu, lr, ps, usr, wc);
	}
	
	
	@PostMapping(
			path = "/machineID",
			produces = "application/json"
		)
		public String getMachineIdandUserId(@RequestBody String json) throws InterruptedException {
			Gson gson = new Gson();
			
			MachineData data = gson.fromJson(json,MachineData.class);
			this.machineId = data.getId();
			this.userId = data.getUserId();
			System.out.println(machineId);
			return "true";
		}
	
	@GetMapping(
			path = "/getMemCluster",
			produces = "application/json"
			)
	public List<MemData> getMemCluster() {
		List<MemData> random = MemDrepo.findAllByMachineId(machineId);
		return random;
	}
	
	@GetMapping(
			path = "/getTotalAnomalies",
			produces = "application/json"
			)
	public List<MemData> getTotalAnomalies() {
		List<MemData> random = MemDrepo.findTotalAnomalies(machineId);
		return random;
	}
	
}
