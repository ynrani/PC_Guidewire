package com.tesda.util;

import java.util.HashMap;
import java.util.Map;

public class ResultCheckUtil
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, String> setResult = new HashMap<String, String>();

		setResult.put("AAA000012", "ID");
		setResult.put("AAA000013", "IDM");
		setResult.put("AAA000014", "IDA");
		setResult.put("AAA000015", "IDB");
		setResult.put("AAA000016", "IDC");
		setResult.put("AAA000017", "IDE");

		if (setResult.containsKey("AAA000012")) {
			System.out.println("Yes " + setResult.get("AAA000012"));
		} else {
			System.out.println("NA");
		}

	}

}
