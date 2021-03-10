package assignment5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task4 {
	ArrayList<MonitoredData> list;
	public Task4(ArrayList<MonitoredData> list){
		Map<Object, Map<Object, Long>> result = list.stream().collect(Collectors.groupingBy(x -> x.getStartTime().getDate(),Collectors.groupingBy(x->x.getActivity(),Collectors.counting())));	
		try{
			 FileWriter fstream = new FileWriter("C:\\Users\\User12\\eclipse-workspace\\Assignment5Project\\Task4.txt");
			 BufferedWriter out = new BufferedWriter(fstream);
			 for (Object entry : result.keySet()) {
				 String key = entry.toString();
		            String value = result.get(entry).toString();  
		            out.write(key + " " + value); 
		            out.write("\n");
				}
			out.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static  Map<String, Long> activitiesInDay(Date day, ArrayList<MonitoredData> list) {
		  @SuppressWarnings("deprecation")
		  ArrayList<String> activities = (ArrayList<String>) list.stream().filter(x -> x.getStartTime().getDate() == day.getDate()).map(x -> x.getActivity()).collect(Collectors.toList());		
		  Map<String, Long> rez = activities.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		  return rez;
	}
	
}
