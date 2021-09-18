package ThreadDump;

import java.lang.management.ThreadInfo;

class GetID {
	
	public long getId(ThreadInfo info) {
		return info.getThreadId();
	}

}
