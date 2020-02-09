package com.tdm.util;

import java.math.BigDecimal;

public class POC
{

	public static void main(String[] args) {
		String str = "009923758";
		int in = Integer.parseInt(str);

		Long lng = Long.valueOf(str);
		long ln1g = Long.parseLong(str);

		System.out.println("int  : " + in);
		System.out.println("long  : " + ln1g);
		System.out.println("Long  : " + lng);
		System.out.println("BigDecimal  : " + new BigDecimal(str));

	}

}
