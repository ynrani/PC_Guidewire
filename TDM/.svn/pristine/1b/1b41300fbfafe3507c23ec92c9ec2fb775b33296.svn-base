/*
 * Object Name : GenerateRandom.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

enum dataType {
	NUMBER, VARCHAR, VARCHAR2, DATE;
}

public final class GenerateRandom{
	private static final String CHAR_NUMERIC_LIST = "1234567890";
	private static final String CHAR_ALPHABETIC_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String strCharType = "";
	private int iLength = 0;
	long iRequiredCount = 0L;

	public GenerateRandom() {
	}

	public GenerateRandom(String strType, int iLength, long iRequiredCount) {
		this.strCharType = CHAR_NUMERIC_LIST;
		this.setiLength(iLength);
		this.iRequiredCount = iRequiredCount;
		if (String.valueOf(dataType.VARCHAR).equals(strType)
				|| String.valueOf(dataType.VARCHAR2).equals(strType)) {
			strCharType = CHAR_ALPHABETIC_LIST;
		} else if (String.valueOf(dataType.DATE).equals(strType)) {
			// this.strCharType = CHAR_NUMERIC_LIST;
		}
	}

	public List<String> generateRandomString(){
		List<String> listGenValues = new LinkedList<String>();
		try {
			StringBuffer randStr = null;
			for (int j = 1; j <= this.iRequiredCount; j++) {
				randStr = new StringBuffer();
				for (int i = 0; i < getiLength(); i++) {
					int number = getRandomNumber(this.strCharType);
					char ch = strCharType.charAt(number);
					randStr.append(ch);
				}
				listGenValues.add(randStr.toString());
			}
		} catch (NoSuchAlgorithmException ne) {
			ne.printStackTrace();
		}
		return listGenValues;
	}

	/**
	 * This method generates random numbers
	 * @return int
	 * @throws NoSuchAlgorithmException
	 */
	@SuppressWarnings("static-access")
	private int getRandomNumber(String strCharType) throws NoSuchAlgorithmException{
		int randomInt = 0;
		SecureRandom randomGenerator = new SecureRandom().getInstance("SHA1PRNG");
		randomInt = randomGenerator.nextInt(strCharType.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	public int getiLength(){
		return iLength;
	}

	public void setiLength(int iLength){
		this.iLength = iLength;
	}
}
