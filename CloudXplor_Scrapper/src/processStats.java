import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class processStats {
	
	private ArrayList <String> rows;
	
	processStats() {
		this.rows = new ArrayList <String> ();
	}
	
	public void add(String row) {
		this.rows.add(row);
	}
	
	public void write(String filename) throws IOException { // writes process stats to file
		BufferedWriter bw;
		bw = new BufferedWriter (new FileWriter (new File (filename), true));
		bw.write("processstat\n");
		for (int i = 0; i < this.rows.size(); i++) {
			bw.write(this.rows.get(i));
			bw.write("\n");
		}
		bw.close();
	}
	

}
