import java.io.IOException;
import java.sql.SQLException;


public class dbScrapper {

	dbScrapper() {

	}
	public void runScrapper() throws SQLException, IOException { // runs the db scrapper 
		Controller c = new Controller();
		c.makeConnection();
		c.openFile();
		c.executeHostSuByStatement();
		c.executeHostSummary();
		c.executeProcessList();
		c.executeStatementAnalysis();
		c.closeFile();
	}
	


}


