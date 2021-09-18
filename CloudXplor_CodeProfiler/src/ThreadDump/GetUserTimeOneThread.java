package ThreadDump;

class GetUserTimeOneThread {

	public long getUserTimeOneThread(CreateDump dump, Long id) {
		return dump.getUserTime().get(dump.indexOfThreadID(id));
	}
	
}
