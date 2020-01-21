package com.utils;



import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {

	public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
	public static final String FULL_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss.SSS";
	public static final String FORWARD_DATE_FORMAT = "yyyyMMddHH";
	public static final String BUILD_FILE_DATE_FORMAT = "yyyyMMdd";
	public static final String MYSQL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String URL_DATE_FORMAT = "yyyyMMdd'T'HHmmssZ";
	public static final String XFILES_DATE_FORMAT = "ddMMyyyyHH'0000'";


	private static final ThreadLocal<Map<String, SimpleDateFormat>> dateFormattersCache = new ThreadLocal<Map<String, SimpleDateFormat>>();


	/**
	 * Get cached date formatter according to the passed pattern and UTC timeZone. If there is no
	 * existed appropriated formatter a new one will be created.
	 *
	 * @return the relevant instance according to the passed pattern and TimeZone  UTC
	 */
	public static final SimpleDateFormat getFormatter(String dateFormatter) {
		return getFormatter(TimeZone.getTimeZone("UTC"), dateFormatter);
	}

	/**
	 * Get cached date formatter according to the  pattern (dd/MM/yyyy HH:mm:ss) and UTC timeZone. If there is no
	 * existed appropriated formatter a new one will be created.
	 *
	 * @return the relevant instance according to the pattern (dd/MM/yyyy HH:mm:ss)  and TimeZone  UTC
	 */
	public static final SimpleDateFormat getFormatter() {
		return getFormatter(TimeZone.getTimeZone("UTC"), null);
	}

	/**
	 * Get cached date formatter according to the pattern (dd/MM/yyyy HH:mm:ss) and passed timeZone. If there is no
	 * existed appropriated formatter a new one will be created.
	 *
	 * @param timeZone
	 * @return the relevant instance according to the pattern (dd/MM/yyyy HH:mm:ss)  and passed TimeZone
	 */
	public static final SimpleDateFormat getFormatter(TimeZone timeZone) {
		return getFormatter(timeZone, null);
	}

	/**
	 * Get cached date formatter according to the passed pattern and timeZone. If there is no
	 * existed appropriated formatter a new one will be created.
	 *
	 * @param timeZone
	 * @param dateFormatter
	 * @return the relevant instance according to the passed pattern and timeZone
	 */
	public static final SimpleDateFormat getFormatter(TimeZone timeZone, String dateFormatter) {

		String pattern = dateFormatter != null ? dateFormatter : DEFAULT_DATE_FORMAT;

		if (dateFormattersCache.get() == null || !dateFormattersCache.get().containsKey(timeZone.getID() + pattern)) {

			if (dateFormattersCache.get() == null) {
				dateFormattersCache.set(new HashMap<String, SimpleDateFormat>());
			}
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			formatter.setTimeZone(timeZone);
			dateFormattersCache.get().put(timeZone.getID() + pattern, formatter);
		}
		return dateFormattersCache.get().get(timeZone.getID() + pattern);
	}


	/**
	 * @return instance of Calenedr with UTC timeZobe
	 */
	public static final Calendar getCalendar() {
		return getCalendar(TimeZone.getTimeZone("UTC"));
	}

	/**
	 * @param timeZone
	 * @return instance of Calenedr with passed timeZobe
	 */
	public static final Calendar getCalendar(TimeZone timeZone) {
		return Calendar.getInstance(timeZone);

	}

	/**
	 * @param date
	 * @return instance of Calenedr set by the passed Date and UTC timeZone
	 */
	public static final Calendar getCalendar(Date date) {
		return getCalendar(date, TimeZone.getTimeZone("UTC"));
	}

	/**
	 * @param date
	 * @param timeZone
	 * @return instance of Calenedr set by the passed Date and passed timeZone
	 */
	public static final Calendar getCalendar(Date date, TimeZone timeZone) {
		Calendar cal = getCalendar(timeZone);
		cal.setTime(date);
		return cal;
	}


	public static final Calendar clearDate(Calendar cal) {
		cal.clear(Calendar.MILLISECOND);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MINUTE);
		return cal;
	}

	public static final Date clearDate(Date date, TimeZone timeZone) {
		Calendar calendar = getCalendar(date, timeZone);
		return clearDate(calendar).getTime();
	}


	public Range<Integer>[] getTimeRange(String tradeHours) {
		Range<Integer> result[] = new Range[7];
		// parse date
		String days[] = tradeHours.split(";");
		for (int i = 0; i < days.length; i++) {
			String hoursStr = days[i].split(":")[1];
			if (result[i] == null)
				result[i] = new Range<>();
			if (hoursStr.equals("CLOSED")) {
				continue;
			} else {
				String[] hours = hoursStr.split("-");
				int from = Integer.parseInt(hours[0]), to = Integer.parseInt(hours[1]);
				if (from > to) {
					result[i].addPeriod(from, 2400);
					if (result[(i + 1) % 7] == null) {
						result[(i + 1) % 7] = new Range<>();
					}
					result[(i + 1) % 7].addPeriod(0000, to);
				} else {
					result[i].addPeriod(from, to);
				}
			}
		}
		return result;
	}

	public boolean isTrading(Date date , Range<Integer>[] tradeHours ) {
		if (date == null) {
			date = new Date();
		}
		Calendar cal = getCalendar(date);
		boolean isRange = tradeHours[cal.get(Calendar.DAY_OF_WEEK) - 1].inRange(cal.get(Calendar.HOUR_OF_DAY) * 100 + cal.get(Calendar.MINUTE));
		return isRange;
	}


}



