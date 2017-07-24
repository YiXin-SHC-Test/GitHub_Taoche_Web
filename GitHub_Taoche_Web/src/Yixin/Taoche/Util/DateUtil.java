package Yixin.Taoche.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author maguanglu
 * 返回年/月/日/时/分/秒 信息
 */
public class DateUtil {
	// 格式化输出日期 返回字符型日期
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				DateFormat df = new SimpleDateFormat();
				result = df.format(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 返回年份
	public static int getYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	// 返回月份
	public static int getMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	// 返回在月份中的第几天
	public static int getDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	// 返回小时
	public static int getHour(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}

	// 返回分钟
	public static int getMinute(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}

	// 返回秒
	public static int getSecond(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}
}
