package com.datacon.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a sequence of first N natural numbers one number is missing. Find the number ?
 */
public class MissingNumberTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int totalNum = 10;

		Integer[] nums = { 1, 2, 3, 4, 6, 7, 8, 9, 10 };
		System.out.println("Missing number in " + Arrays.asList(nums) + " is "
				+ getMissingNumber(nums, totalNum));

		nums = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 9, 10 };
		System.out.println("Missing number in " + Arrays.asList(nums) + " is "
				+ getMissingNumber(nums, totalNum));

	}

	/**
	 * Gets the missing number in array.
	 * 
	 * @param nums
	 * @return
	 */
	private static int getMissingNumber(Integer[] nums, int totalNum) {
		List<Integer> mynums = new ArrayList<Integer>(Arrays.asList(nums));
		List<Integer> actualNums = new ArrayList<Integer>();

		for (int i = 1; i <= totalNum; i++) {
			actualNums.add(i);
		}

		actualNums.removeAll(mynums);

		if (actualNums.size() == 1) {
			return actualNums.get(0);
		}

		return -1;
	}

}
