package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PublicHolidays {
	
	private String Name;
	private String Date;
	
	public PublicHolidays(){}
	
	public void setName(String name){
		this.Name = name;
	}
	
	public void setDate(String date){
		this.Date = date;
	}
	public boolean isHoliday(String date) throws IOException
	{
		File inputFile = new File("PublicHolidayTable.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String currentLine;
		String temp[];
		while ((currentLine = reader.readLine()) != null) {

			temp = currentLine.split("\\|");
				if(date.equalsIgnoreCase(temp[1]))
				{
					reader.close();
					return true;
				}
		}
		reader.close();
		return false;
	}
	
	public String ConvertToRecord() throws IOException{
		String record;
		int serialno;
		serialno = TableProcessor.NoOfRecords("PublicHolidayTable.txt")+1;
	
		record = serialno + "|" +Name+ "|" + Date;
		return record;
	}
	
}
