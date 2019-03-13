package com.fan1111.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {
	private String datapatten;
	
	public StringToDateConverter(String datapatten){
		this.datapatten = datapatten;
	}
	@Override
	public Date convert(String str) {
		Date date = null;
		try {
			date = new SimpleDateFormat(datapatten).parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
