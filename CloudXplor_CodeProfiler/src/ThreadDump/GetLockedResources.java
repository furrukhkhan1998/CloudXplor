package ThreadDump;

import java.lang.management.MonitorInfo;
import java.lang.management.ThreadInfo;
import java.util.ArrayList;

class GetLockedResources {
	
	public ArrayList <MonitorInfo> getLockedResources(ThreadInfo info) {
		MonitorInfo[] monitors = info.getLockedMonitors();
		ArrayList <MonitorInfo> arr = new ArrayList <MonitorInfo> ();
		for (int i = 0; i < monitors.length; i++) {
			arr.add(monitors[i]);
		}
		return arr;
	}

}
