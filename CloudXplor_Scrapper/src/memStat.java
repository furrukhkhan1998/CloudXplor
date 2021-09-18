import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class memStat {
	
	private ArrayList <String> rows;
	
	memStat() {
		this.rows = new ArrayList <String> ();
	}
	
	public void add(String row) {
		this.rows.add(row);
	}
	
	public void write(String filename) throws IOException { // writes memory stats to file
		File file = new File(filename);
		BufferedWriter bw;
		if(file.isFile()) {
			bw = new BufferedWriter (new FileWriter (file, true));
		}
		else {
			bw = new BufferedWriter (new FileWriter (new File (filename)));
		}
		bw.write("memstat\n");
		for (int i = 0; i < this.rows.size(); i++) {
			bw.write(this.rows.get(i));
			bw.write("\n");
		}
		bw.close();
	}
	
	

}
