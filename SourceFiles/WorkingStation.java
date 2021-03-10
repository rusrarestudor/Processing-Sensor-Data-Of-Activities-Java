package assignment5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingStation {
	
	public static ArrayList<MonitoredData> fromTxtToList() {
		ArrayList<MonitoredData> listMonitoredData = new ArrayList<MonitoredData>();
		
		Function<String[],MonitoredData> fn = date->{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try{
			    return new MonitoredData(date[2], format.parse(date[0]), format.parse(date[1]));  
			}catch(Exception ex){
				throw new IllegalArgumentException(ex);
			}	
		};	
		Path filePath = Paths.get("C:\\Users\\User12\\eclipse-workspace\\Assignment5Project\\Activities.txt");	
		try (Stream<String> lini = Files.lines(filePath)) {
			listMonitoredData = lini.map(linie -> linie.split("\\t\\t")).map(fn::apply)  
		             .collect(Collectors.toCollection(ArrayList::new));
		} 
		catch (IOException e) {	 
		    e.printStackTrace();
		}	
		return listMonitoredData;
	}
	
	public static void main(String[] args){
		ArrayList<MonitoredData> listMonitoredData = fromTxtToList(); //task1
		new Task1(listMonitoredData);    //demo task1
		new Task2(listMonitoredData);   //demo task2
		new Task3(listMonitoredData);  //demo task3 + return in the class
		new Task4(listMonitoredData); //demo task4 				
	}
}
