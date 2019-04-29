package assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.*;

public class CalendarDate {

	Date now = new Date();
	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMddhhmm");

	public String getNowTime() {
		return dateFormatter.format(now);
	}

	public int getDayofWeek(String datetoconvert) throws ParseException {

		int dayofweek;

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");

		Date date = format.parse(datetoconvert);

		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		calendar.setTime(date);
		dayofweek = calendar.get(Calendar.DAY_OF_WEEK);// 1 is Sun, 2 is Mon ...
														// 7 is sat

		return dayofweek;
	}

	public boolean isValidDate(String datetovalidate) {

		String formatString = "dd/MM/yy";

		try {
			SimpleDateFormat format = new SimpleDateFormat(formatString);
			format.setLenient(false);
			format.parse(datetovalidate);
		} catch (ParseException e) {
			return false;
		} catch (IllegalArgumentException e) {
			return false;
		}

		return true;
	}

}