package ThreadDump;

class GetCpuTimeOneThread {
	
	public long getCpuTimeOneThread(CreateDump dump, Long id) {
		return dump.getCpuTime().get(dump.indexOfThreadID(id));
	}

}
