package com.mazaiting.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.core.convert.converter.Converter;

/**
 * SpringMVC转换器
 * Converter<S, T>  S：source源数据类型，T：target目标数据类型
 * @author mazaiting
 */
public class DateConverter implements Converter<String, Date>{

	
	@Override
	public Date convert(String source) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		try {
			Date date = formatter.parse(source);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
