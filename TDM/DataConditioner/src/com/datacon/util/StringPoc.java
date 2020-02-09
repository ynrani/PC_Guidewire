package com.datacon.util;

public class StringPoc
{

	public static void main(String[] args) {
		String myName = "VARCHAR2(50), VARCHAR2(50), NUM)";

		StringBuffer buf = new StringBuffer(myName);

		buf.replace(myName.lastIndexOf(")"), myName.length(), " VARCHAR2(50))");

		System.out.println("myName " + myName);
		System.out.println("buf " + buf);
	}
}
