package ThreadDump;

import java.lang.management.ThreadInfo;

class GetBlockedTime {
	
	public long getBlockedTime(ThreadInfo info) {
		return info.getBlockedTime();
	}

}
