package ThreadDump;

import java.lang.management.ThreadInfo;

class GetWaitCount {

	
	public long getCount(ThreadInfo info) {
		return info.getWaitedCount();
	}
}
