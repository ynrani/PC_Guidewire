package com.datacon.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil
{

	// List of all date formats that we want to parse.
	// Add your own format here.
	private static List<SimpleDateFormat> dateFormats = new ArrayList<SimpleDateFormat>()
	{
		private static final long serialVersionUID = 1L;
		{
			add(new SimpleDateFormat("M/dd/yyyy"));
			add(new SimpleDateFormat("dd.M.yyyy"));
			add(new SimpleDateFormat("M/dd/yyyy hh:mm:ss a"));
			add(new SimpleDateFormat("dd.M.yyyy hh:mm:ss a"));
			add(new SimpleDateFormat("yyyy-dd-MM hh:mm:ss a"));
			add(new SimpleDateFormat("dd.MMM.yyyy"));
			add(new SimpleDateFormat("dd-MMM-yyyy"));
		}
	};

	public static void main(String[] args) {

		String str = "2014-01-07 00:01:00.0000000";
		System.out.println("st " + str.substring(0, str.indexOf(".")));

		Date dt = convertToDate(str.substring(0, str.indexOf(".")));
		System.out.println("DT " + dt);
	}

	/**
	 * Convert String with various formats into java.util.Date
	 * 
	 * @param input
	 *            Date as a string
	 * @return java.util.Date object if input string is parsed successfully else returns null
	 */
	public static Date convertToDate(String input) {
		Date date = null;
		if (null == input) {
			return null;
		}
		for (SimpleDateFormat format : dateFormats) {
			try {
				format.setLenient(false);
				date = format.parse(input);
			} catch (ParseException e) {
				// Shhh.. try other formats
			}
			if (date != null) {
				break;
			}
		}

		return date;
	}

}