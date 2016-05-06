package com.bolatu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogUtil {
	
	private static final String DB_LOGGER = "dbLogger";
	private static final String SERVICE_LOGGER = "serviceLogger";
	private static final String REST_LOGGER = "restLogger";
	private static final String UTIL_LOGGER = "utilLogger";
	private static final String WEB_MOBILE_LOGGER = "webMobileLogger";
	
	public static final Logger DBLOGGER = LoggerFactory.getLogger(DB_LOGGER);
	public static final Logger SERVICELOGGER = LoggerFactory.getLogger(SERVICE_LOGGER);
	public static final Logger RESTLOGGER = LoggerFactory.getLogger(REST_LOGGER);
	public static final Logger UTILLOGGER = LoggerFactory.getLogger(UTIL_LOGGER);
	public static final Logger WEBMOBILELOGGER = LoggerFactory.getLogger(WEB_MOBILE_LOGGER);
	
	public static void printExceptionLog(Logger logger, Exception e) {		
		StackTraceElement stackTraceElement = e.getStackTrace()[0];
		String exceptionMessage = e.getMessage();
		String className = e.getClass().getName();
		
		if(!StringUtil.isNullOrEmpty(exceptionMessage)) {
			logger.error("{} exception occured at {}.{}[{}]: {}", className, 
					stackTraceElement.getClassName(), stackTraceElement.getMethodName(),
					stackTraceElement.getLineNumber(), exceptionMessage);
		} else {
			logger.error("{} exception occured at {}.{}[{}].", className,
					stackTraceElement.getClassName(), stackTraceElement.getMethodName(),
					stackTraceElement.getLineNumber());
		}
	}

}
