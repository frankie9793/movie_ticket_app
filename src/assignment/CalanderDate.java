package assignment;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalanderDate {
	/*
	private int date;
	private int month;
	private int year;
	private int day;
	private int hour;
	private int minute;
	private int DayOfWeek;
	private boolean PublicHoliday;

	Calendar cal = Calendar.getInstance();

	public CalanderDate(int incre) {
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH); // 0 to 11
		day = cal.get(Calendar.DAY_OF_MONTH);
		DayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		hour = cal.get(Calendar.HOUR_OF_DAY);
		minute = cal.get(Calendar.MINUTE);
	}
*/
	Date now = new Date();
	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMddhhmm");
	public String getNowTime()
	{
		return dateFormatter.format(now);
	}
	
}
