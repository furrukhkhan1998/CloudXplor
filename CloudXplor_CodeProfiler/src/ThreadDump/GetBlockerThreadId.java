package ThreadDump;

import java.lang.management.ThreadInfo;

class GetBlockerThreadId {
	
	public long getBlockerThreadId(ThreadInfo info) {
		return info.getLockOwnerId();
	}

}
