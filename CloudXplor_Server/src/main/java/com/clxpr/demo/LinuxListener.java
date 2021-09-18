package com.clxpr.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.ConfigurableApplicationContext;

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

public class LinuxListener implements Runnable {

	private ConfigurableApplicationContext springContext;
	private ServerSocket server;
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
	private DataInputStream in;
	private DataOutputStream out;
	

	// Constructor to get objects of services managed by java spring 
	public LinuxListener(ConfigurableApplicationContext springContext) throws IOException {
		// TODO Auto-generated constructor stub
		this.springContext=springContext;
		this.resourceServ=springContext.getBean("ResourceService",ResourceService.class);
		this.resourceDataServ=springContext.getBean("ResourceDataService",ResourceDataService.class);
		this.cpuDataServ = springContext.getBean("CpuDataService",CpuDataService.class);
		this.diskDataServ = springContext.getBean("DiskDataService",DiskDataService.class);
		this.ioDataServ = springContext.getBean("IoDataService",IoDataService.class);
		this.pidDataServ = springContext.getBean("PidDataService",PidDataService.class);
		this.pidSchedDataServ = springContext.getBean("PidSchedDataService",PidSchedDataService.class);
		this.memDataServ = springContext.getBean("MemDataService",MemDataService.class);
		this.hostSumByStatDataServ = springContext.getBean("HostSumByStatDataService",HostSumByStatDataService.class);
		this.hostSummaryServ = springContext.getBean("HostSummaryService",HostSummaryService.class);
		this.processListServ = springContext.getBean("ProcessListService",ProcessListService.class);
		this.statementAnalysisServ = springContext.getBean("StatementAnalysisService", StatementAnalysisService.class);
		this.heapDataServ = springContext.getBean("HeapDataService", HeapDataService.class);
		this.heapDumpDataServ = springContext.getBean("HeapDumpDataService", HeapDumpDataService.class);
		this.stackDataServ = springContext.getBean("StackDataService", StackDataService.class);
		this.threadDataServ = springContext.getBean("ThreadDataService", ThreadDataService.class);
		server = new ServerSocket(4003);    // create server socket for client to connect to
		
	}
	
	public ConfigurableApplicationContext getContext() {
		return this.springContext;
	}
	
	

	@Override
	public void run() {
		int usrId = 1;
		
		while(true) {
			try { 
		            
		            System.out.println("Server started"); 
		  
		            System.out.println("Waiting for a client ..."); 
		  
		            Socket socket = server.accept(); 
		            System.out.println("Client accepted"); 
		            out = new DataOutputStream(
							new BufferedOutputStream(socket.getOutputStream()));
					in = new DataInputStream( 
			                new BufferedInputStream(socket.getInputStream())); 
		         
		            // handles each client in a thread 
		            Thread t = new ClientHandler(socket,in,out,this.resourceServ,this.resourceDataServ,this.cpuDataServ,this.diskDataServ,
		            		this.ioDataServ,this.memDataServ,this.pidDataServ,this.pidSchedDataServ, this.hostSumByStatDataServ, 
		            		this.hostSummaryServ, this.processListServ, this.statementAnalysisServ, this.heapDataServ,
		            		this.heapDumpDataServ, this.stackDataServ, this.threadDataServ, usrId);
		            t.start();
		           
		    } 
	        catch(IOException i) 
	        { 
	            System.out.println(i); 
	        }
			usrId++;
		}
	}
	

}
