package com.tesda.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		try
		{
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date date = new Date();
			
		    String[] dates=	dateFormat.format(date).split(" ");
			System.out.println( dates[0] +"   " +dates[1]);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
}
