package com.bolatu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	
	private static final SimpleDateFormat CHINESE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	private static final SimpleDateFormat GLOBAL_FORMAT = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss.SSSZ");
	private static final SimpleDateFormat DISPLAY_FORMAT_ZH = new SimpleDateFormat("yyyy年  MM月 dd号");
	private static final String DEFAULT_TIME_ZONE = "GMT+8";
	
	public static Date convertToChinaDate(final String dateString) {
		try {
			return CHINESE_FORMAT.parse(dateString);
		} catch (ParseException e) {
			LogUtil.printExceptionLog(LogUtil.UTILLOGGER, e);
		}
		
		return null;
	}
		
	public static Date convertToGlobalDate(final String dateString) {
		try {
			return GLOBAL_FORMAT.parse(dateString);
		} catch (ParseException e) {
			LogUtil.printExceptionLog(LogUtil.UTILLOGGER, e);
		}
		
		return null;
	}
	
	
	public static String convertToChinaDateString(final Date date) {
		try {
			return CHINESE_FORMAT.format(date);
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.UTILLOGGER, e);
		}
		
		return null;
	}
		
	public static String convertToGlobalDateString(final Date date) {
		try {
			return GLOBAL_FORMAT.format(date);
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.UTILLOGGER, e);
		}
		
		return null;
	}
	
	public static String convertToChinaDateString(final long timestamp) {
		try {
			return CHINESE_FORMAT.format(new Date(timestamp));
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.UTILLOGGER, e);
		}
		
		return null;
	}
		
	public static String convertToGlobalDateString(final long timestamp) {
		try {
			return GLOBAL_FORMAT.format(new Date(timestamp));
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.UTILLOGGER, e);
		}
		
		return null;
	}
	
	public static String getDisplayString(Date date) {
		try {
			return DISPLAY_FORMAT_ZH.format(date);
		} catch (Exception e) {
			LogUtil.printExceptionLog(LogUtil.UTILLOGGER, e);
		}
		
		return null;
	}
	
	
//	@Deprecated
//	public static String getAge(final Date date){
//		return null;
//	}
//	
//	
//	@Deprecated
//	public static String getAge(final long timestamp){
//		return null;
//	}
	
	
	public static int getAge(final Date date){	
		return Period.between(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), 
				              LocalDate.now()).getYears();
	}
	
	public static int getAge(final long timestamp){
		return Period.between(Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate(), 
	              LocalDate.now()).getYears();
	}
	
	public static Date getDateForAge(int age) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DEFAULT_TIME_ZONE));
		calendar.add(Calendar.YEAR, -1 * age);
		return calendar.getTime();
	}
	
	public static Date getCurrentTime() {
		return Calendar.getInstance(TimeZone.getTimeZone(DEFAULT_TIME_ZONE)).getTime();
	}
	
	public static long getCurrentTimeInMillis() {
		return Calendar.getInstance(TimeZone.getTimeZone(DEFAULT_TIME_ZONE)).getTimeInMillis();
	}
	
	public static long getElapsedTimeInMinutes(long timeInMillis) {
		return (getCurrentTimeInMillis() - timeInMillis) / (1000 * 60); 
	}

}
