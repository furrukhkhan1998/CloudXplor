package ThreadDump;

import java.lang.management.ThreadInfo;

class GetWaitTime {

	
	public long getWaitedtime(ThreadInfo info) {
		return info.getWaitedTime();
	}
}
