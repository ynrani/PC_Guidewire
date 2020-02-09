package com.datacon.util;

import java.util.ArrayList;
import java.util.List;

public class MissingNumber
{

	public static void main(String[] args) {
		int a[] = { 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 18, 20, 21, 23 };
		List<Integer> list = findMissingNumbers(a, 0);
		if (null != list && !list.isEmpty()) {
			list.size();
			for (Integer integer : list) {
				System.out.println("abt  " + integer);
			}
		}
	}

	public static List<Integer> findMissingNumbers(int[] a, int first) {
		List<Integer> missigArray = new ArrayList<Integer>();
		// assign first element of an array to largest and smallest
		int last = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > last)
				last = a[i];
		}
		// before the array: numbers between first and a[0]-1
		for (int i = first; i < a[0]; i++) {
			missigArray.add(i);
		}
		// inside the array: at index i, a number is missing if it is between a[i-1]+1 and a[i]-1
		for (int i = 1; i < a.length; i++) {
			for (int j = 1 + a[i - 1]; j < a[i]; j++) {
				missigArray.add(j);
			}
		}
		// after the array: numbers between a[a.length-1] and last
		for (int i = 1 + a[a.length - 1]; i <= last; i++) {
			missigArray.add(i);
		}

		return missigArray;

	}

}
