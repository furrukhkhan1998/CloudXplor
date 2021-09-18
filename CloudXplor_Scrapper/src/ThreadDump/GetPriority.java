package ThreadDump;

import java.lang.management.ThreadInfo;

class GetPriority {
	
	public int getPriority(ThreadInfo info) {
		return info.getPriority();
	}

}
