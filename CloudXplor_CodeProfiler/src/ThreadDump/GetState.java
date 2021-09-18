package ThreadDump;

import java.lang.Thread.State;
import java.lang.management.ThreadInfo;

class GetState {

	public State getState(ThreadInfo info) {
		return info.getThreadState();
	}
	
}
