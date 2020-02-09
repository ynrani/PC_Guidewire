package com.datacon.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class POC
{

	public static void main(String[] args) {

		// will be the sum of the numbers in the array.

		int n = 100;
		int a[] = new int[n];

		// XOR of all numbers from 1 to n
		// n%4 == 0 ---> n
		// n%4 == 1 ---> 1
		// n%4 == 2 ---> n + 1
		// n%4 == 3 ---> 0

		long xor = (n % 4 == 0) ? n : (n % 4 == 1) ? 1 : (n % 4 == 2) ? n + 1 : 0;

		for (int i = 1; i < n; i++) {
			xor = xor ^ a[i];
		}
		// Missing number
		System.out.println("sdfjsdfsjdfjsdf  " + xor);

		int count = 0;

		// prep for question
		List<Integer> ints = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			ints.add(i);
		}

		// find the missing number
		for (Integer i : ints) {
			if (i != count) {
				System.out.println(count);
				count++;
			}
			count++;
		}

		// int[] arr = { 10, 9, 3, 6, 4, 5, 8, 1, 2, 0 };
		// int length = arr.length;

		// int indexes = arr.length;
		// int values = 0;

		// for (int i = 0; i < length; i++) {
		// indexes += i;
		// values += arr[i];
		// }

		// int result = indexes - values;

		// System.out.println("Missing number is: " + result);

		// String str = "selectedColumns3";

		// System.out.println("  " + str.substring("selectedColumns".length(), str.length()));

		/*
		 * String str = "Oracle_23";
		 * 
		 * System.out.println("str   " + str.substring(str.lastIndexOf('_') + 1, str.length()));
		 * 
		 * String tabName = "A,B,C,D"; String[] split = tabName.split(","); for (String string :
		 * split) { System.out.println("!!!!!!!!!!!!  " + string); }
		 * 
		 * String finleName = "exportRev.csv";
		 * 
		 * System.out.println("Last Index of . " + finleName.lastIndexOf('.'));
		 * System.out.println("length " + finleName.length());
		 * 
		 * String exten = finleName.substring(finleName.lastIndexOf('.'), finleName.length());
		 * System.out.println("exten  " + exten);
		 */

		/*
		 * File file = new File("D://Users//sechowda//Chowdary//DataCon//Script//reserv.txt");
		 * 
		 * String delim; try { delim = getDelimiter(file); System.out.println("Delim is " + delim +
		 * " (" + (int) delim.charAt(0) + ")"); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
	}

	private static final String[] DELIMS = new String[] { "\t", ",", " " };

	private static String getDelimiter(File file) throws IOException {
		for (String delim : DELIMS) {

			BufferedReader br = new BufferedReader(new FileReader(file));
			String[] line0 = br.readLine().split(delim);
			String[] line1 = br.readLine().split(delim);
			br.close();
			if (line0.length == line1.length && line0.length > 1) {
				return delim;
			}

		}
		throw new IllegalStateException("Failed to find delimiter for file " + file);
	}

}
