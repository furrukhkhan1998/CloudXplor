import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
	dbHandler db;
	public BufferedWriter br;

	void makeConnection(){
		db = new dbHandler();
		db.createConnection("aps123", "furrukh");
	}

	void executeStatementAnalysis() throws SQLException, IOException{
		 /*String quotes = "\"";
		 dbName = quotes + dbName + quotes;
         */

		String command = "SELECT * FROM sys.statement_analysis";
		prepCommand(db.executeStatement(command), "StatementAnalysis");

	}

	void executeHostSummary() throws SQLException, IOException{



		String command = "SELECT * FROM sys.host_summary";
		prepCommand(db.executeStatement(command), "HostSummary");

	}
	void executeHostSuByStatement() throws SQLException, IOException{



		String command = "SELECT * FROM sys.host_summary_by_statement_type";
		prepCommand(db.executeStatement(command), "HostSummaryByStatement");

	}
	void executeProcessList() throws SQLException, IOException{



		String command = "SELECT * FROM sys.processlist";
		prepCommand(db.executeStatement(command), "ProcessList");

	}
	void executeTableLock() throws SQLException, IOException{



		String command = "SELECT * FROM sys.schema_table_lock_waits";
		prepCommand(db.executeStatement(command), "TableLockWaits");

	}


	void prepCommand(ResultSet rs,String commandName) throws SQLException, IOException{

		String header = "";
	    ResultSetMetaData metadata= rs.getMetaData();
	    for(int x = 1;x<=metadata.getColumnCount();x++)
	    {
	    	header = header + metadata.getColumnName(x) + " ";
		}
		ArrayList <String> rows = new ArrayList <String> ();
		String singleRow = "";
		while (rs.next()){
			for(int x = 1;x<=metadata.getColumnCount();x++){
				singleRow = singleRow + rs.getString(x);
				singleRow = singleRow + " ";

			}
			rows.add(singleRow);
			singleRow = "";
		}



		WriteToFile(rows,header,commandName);
	}

	void openFile() throws IOException{
		BufferedReader bw = new BufferedReader(new FileReader(new File("src//config.txt")));
		String userId = bw.readLine();
		String machineId = bw.readLine();
		br = new BufferedWriter(new FileWriter(new File("dbData.txt")));
		br.write(userId + "\n");
		br.write(machineId + "\n");
	}
	void closeFile() throws IOException{
		br.write("Over2");
		br.close();
	}

	void WriteToFile(ArrayList<String> rows, String header,String command) throws IOException{

		br.write(command);
		br.write("\n");
		br.write(header);
		for(int x = 0;x<rows.size();x++){
		br.write("\n");
			br.write(rows.get(x));

		}
		br.write("\n");



	}

}
