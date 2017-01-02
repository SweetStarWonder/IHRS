package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtility {
	public static String getDateStr() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		return format.format(date);
	}
	
	public static String getTimeStr() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return format.format(date);
	}
}
