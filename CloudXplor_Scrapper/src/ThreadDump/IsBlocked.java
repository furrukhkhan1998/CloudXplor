package ThreadDump;

import java.lang.management.ThreadInfo;

class IsBlocked {
	
	public boolean isBlocked(ThreadInfo info) {
		return info.getBlockedCount() == 0;
	}

}
