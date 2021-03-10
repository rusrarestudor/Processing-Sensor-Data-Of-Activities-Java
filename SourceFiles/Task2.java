package assignment5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class Task2 {
	ArrayList<MonitoredData> list;
	public Task2(ArrayList<MonitoredData> list){
		Set<String> setDates = list.stream().map(MonitoredData::onlyDateStart).collect(Collectors.toSet());	
		setDates = list.stream().map(MonitoredData::onlyDateEnd).collect(Collectors.toSet());	
		try{
			 FileWriter fstream = new FileWriter("C:\\Users\\User12\\eclipse-workspace\\Assignment5Project\\Task2.txt");
			 BufferedWriter out = new BufferedWriter(fstream);
			 out.write("   The number of distinct days that appear in the monitoring data is: " + setDates.size() + "!");
			 out.write("\n");
			out.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
}
