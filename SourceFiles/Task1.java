package assignment5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Task1 {
	ArrayList<MonitoredData> list;
	
	public Task1(ArrayList<MonitoredData> list){
		try{
			 FileWriter fstream = new FileWriter("C:\\Users\\User12\\eclipse-workspace\\Assignment5Project\\Task1.txt");
			 BufferedWriter out = new BufferedWriter(fstream);
			 for(MonitoredData linie : list){
				 out.write(linie.toString());
			  	 out.write("\n");
			}
			out.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
}
