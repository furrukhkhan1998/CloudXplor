package ThreadDump;

import java.lang.management.ThreadInfo;

class GetBlockedCount {
	
	public long getCount(ThreadInfo info) {
		return info.getBlockedCount();
	}

}
