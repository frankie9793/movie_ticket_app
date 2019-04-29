package assignment;

import java.io.IOException;
import assignment.TableProcessor;

public class MovieSchedule {
	
	private String date;
	private String day;
	private String time; 
	
	public MovieSchedule(){}
	
	public void setDate(String date){
		this.date = date;	
	}
	
	public void setDay(String day){
		this.day = day;
	}
	
	public void setTime(String time){
		this.time = time;
	}
	public String ConvertToRecord () throws IOException {
		
		String record;
		int serialno;
		serialno = TableProcessor.NoOfRecords("MovieScheduleTable.txt")+1;
	
		record = serialno + "|" + date+ "|" + day + "|" + time;
		return record;
	}
}
