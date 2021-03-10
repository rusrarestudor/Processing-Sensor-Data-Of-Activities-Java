package assignment5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Task3 {
	
	ArrayList<MonitoredData> list;
	
	public Task3(ArrayList<MonitoredData> list){
		Map<String, Long> result = return4task3(list);
		try{
			 FileWriter fstream = new FileWriter("C:\\Users\\User12\\eclipse-workspace\\Assignment5Project\\Task3.txt");
			 BufferedWriter out = new BufferedWriter(fstream);
			 for (Entry<String, Long> entry : result.entrySet()) {
				    out.write(entry.getKey()  + "  " +entry.getValue().toString());
				    out.write("\n");
				}
			out.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}	
	}
	
	public Map<String, Long> return4task3(ArrayList<MonitoredData> list) {
		ArrayList<String> activities = (ArrayList<String>) list.stream().map(x -> x.getActivity()).collect(Collectors.toList());
		Map<String, Long> result = activities.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		return result;
		
	}
	
}
