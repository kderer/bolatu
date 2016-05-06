package com.bolatu.util;

import java.util.Locale;

import org.springframework.context.support.ResourceBundleMessageSource;

public class I18NUtil {
	
	private static Locale defaultLocale = new Locale("en");

	private static ResourceBundleMessageSource i18nSource;
	
	public static String getMessage(String key) {
		return i18nSource.getMessage(key, null, defaultLocale);
	}

	public static ResourceBundleMessageSource getI18nSource() {
		return i18nSource;
	}

	public static void setI18nSource(ResourceBundleMessageSource i18nSource) {
		I18NUtil.i18nSource = i18nSource;
	}
			

}
