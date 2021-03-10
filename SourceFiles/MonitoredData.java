package assignment5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MonitoredData {
	private String activity;
	private Date startTime;
	private Date endTime;
	
	public MonitoredData(String activity, Date start_time, Date end_time) {
		this.activity = activity;
		this.startTime= start_time;
		this.endTime = end_time;
	}
	
	public String getActivity() {
		return activity;
	}


	public void setActivity(String activity) {
		this.activity = activity;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStarTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
		return this.startTime + "   " + this.endTime + "   " + this.activity.toString();	
	}
	
	public String onlyDateStart(){
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		return format2.format(getStartTime());
	}
	public String onlyDateEnd(){
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		return format2.format(getEndTime());
	}
	
}
