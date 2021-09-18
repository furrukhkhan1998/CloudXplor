package com.clxpr.demo.controller;

import java.util.ArrayList;

import com.clxpr.demo.model.json.DataThread;


public class ThreadDump {
	
	public class PnS {
		
		public class Thread {
			public String id;
			public String priority;
			public String state;
			
			public Thread(String id, String s, String p) {
				this.id = id;
				this.priority = p;
				this.state = s;
			}
			
			
		}
		
		public String type;
		ArrayList <Thread> threads;
		
		PnS(String type) {
			this.type = type;
			this.threads = new ArrayList <Thread> ();
		}
		
		void add(String output) {
			String[] arr = output.split(" ");
			this.threads.add(new Thread(arr[2], arr[4], arr[6]));
		}
	}
	
	public class CT {
		
		public class Thread {
			public String id;
			public String time;
			
			Thread(String id, String time) {
				this.id = id;
				this.time = time;
			}
		}
		
		public String type;
		ArrayList <Thread> threads;
		
		public CT(String type) {
			this.type = type;
			this.threads = new ArrayList <Thread> ();
		}
		
		public void add(String type, String output) {
			String[] arr = type.split(" ");
			String[] arr2 = output.split(" ");
			this.threads.add(new Thread(arr[4], arr2[0]));
		}
		
		
	}
	
	public class UT {
		
		public class Thread {
			public String id;
			public String time;
			
			public Thread(String id, String time) {
				this.id = id;
				this.time = time;
			}
		}
		
		public String type;
		ArrayList <Thread> threads;
		
		public UT(String type) {
			this.type = type;
			this.threads = new ArrayList <Thread> ();
		}
		
		public void add(String type, String output) {
			String[] arr = type.split(" ");
			String[] arr2 = output.split(" ");
			this.threads.add(new Thread(arr[4], arr2[0]));
		}
		
	}
	
	public class LR {
		
		public class Thread {
			public String id;
			public ArrayList <String> monitors;
			
			public Thread(String output) {
				this.monitors = new ArrayList <String> ();
				System.out.println(output);
				String[] arr = output.split(", ");
				String[] arr2 = arr[0].split(" ");
				this.id = arr2[1];
				if (arr[1].contains("None")) {
					this.monitors.add("None");
				} else {
					arr2 = arr[1].split(" ");
					for (int i = 0; i < arr2.length; i++)
						this.monitors.add(arr2[i]);
				}
			}
		}
		
		public String type;
		public ArrayList <Thread> threads;
		
		public LR(String type) {
			this.type = type;
			this.threads = new ArrayList <Thread> ();
		}
		
		public void add(String output) {
			this.threads.add(new Thread(output));
		}
		
	}
	
	class BC {
		
		class Thread {
			public String id;
			public String count;
			
			Thread(String output) {
				String[] arr = output.split(": ");
				this.id = arr[0];
				this.count = arr[1];
			}
		}
		
		public String type;
		public ArrayList <Thread> threads;
		
		public BC(String type) {
			this.type = type;
			this.threads = new ArrayList <Thread> ();
		}
		
		public void add(String output) {
			this.threads.add(new Thread(output));
		}
		
	}
	
	class WC {
		
		class Thread {
			public String id;
			public String count;
			
			public Thread(String output) {
				String[] arr = output.split(": ");
				this.id = arr[0];
				this.count = arr[1];
			}
		}
		
		public String type;
		public ArrayList <Thread> threads;
		
		public WC(String type) {
			this.type = type;
			this.threads = new ArrayList <Thread> ();
		}
		
		public void add(String output) {
			this.threads.add(new Thread(output));
		}
	}
	
	public ArrayList <Object> getThreadObjects(ArrayList <DataThread> data) {
		ArrayList <Object> objects = new ArrayList <Object> ();
		PnS p = null;
		CT c = null;
		UT u = null;
		LR l = null;
		BC b = null;
		WC w = null;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getType().contains("Priority")) {
				if (p == null) {
					p = new PnS(data.get(i).getType());
				}
				p.add(data.get(i).getTypeOutput());
			} else if (data.get(i).getType().contains("Cpu")) {
				if (c == null) {
					c = new CT(data.get(i).getType());
				}
				c.add(data.get(i).getType(), data.get(i).getTypeOutput());
			} else if (data.get(i).getType().contains("User Time")) {
				if (u == null) {
					u = new UT(data.get(i).getType());
				}
				u.add(data.get(i).getType(), data.get(i).getTypeOutput());
			} else if (data.get(i).getType().contains("Locked")) {
				if (l == null) {
					l = new LR(data.get(i).getType());
				}
				l.add(data.get(i).getTypeOutput());
			} else if (data.get(i).getType().contains("Blocked")) {
				if (b == null) {
					b = new BC(data.get(i).getType());
				}
				b.add(data.get(i).getTypeOutput()	);
			} else if (data.get(i).getType().contains("Wait")) {
				if (w == null) {
					w = new WC(data.get(i).getType());
				}
				w.add(data.get(i).getTypeOutput());
			}
		}
		if (p != null) 
			objects.add(p);
		if (c != null) 
			objects.add(c);
		if (u != null) 
			objects.add(u);
		if (l != null) 
			objects.add(l);
		if (b != null) 
			objects.add(b);
		if (w != null) 
			objects.add(w);
		
		return objects;
	}
	
	
	
	
	
}
