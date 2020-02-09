package com.datacon.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;

import com.datacon.constant.AppConstant;

public class SepcQueryUtil
{

	public static String getReplacedValue(String strValue, Vector<String> vector) {
		if (vector != null && !vector.isEmpty()) {
			String[] strRep = new String[vector.size()];
			String[] strRepVal = new String[vector.size()];
			for (int i = 0; i < strRep.length; i++) {
				strRep[i] = "{" + i + "}";
				strRepVal[i] = String.valueOf(vector.get(i));
			}
			return StringUtils.replaceEach(strValue, strRep, strRepVal);
		} else {
			return strValue;
		}
	}

	public static String generateString(String strType, String strColumnName,
			List<String> listValues) {
		StringBuffer strBuffer = new StringBuffer(" AND ").append(strColumnName);
		if (listValues != null) {
			if (!listValues.isEmpty() && listValues.size() == 1) {
				strBuffer.append(" = ").append("?");
			} else {
				strBuffer.append("IN (");
				for (int i = 0; i < listValues.size(); i++) {
					strBuffer.append("?");
					if (i != 0 && i != listValues.size()) {
						strBuffer.append(",");
					}
					if (i == listValues.size()) {
						strBuffer.append(")");
					}
				}
			}
		}
		return strBuffer.toString();
	}

	public static String getSpecificDBQuery(String strDBType, String strSuffixConstant,
			Vector<String> vctValues) {
		String strResponse = "";
		if (AppConstant.DB_TYPE_ORACLE.equals(strDBType)) {
			Vector<String> vct = new Vector<String>();
			vct.add(AppConstant.DB_TYPE_ORACLE);
			strResponse = getResponse(vct, AppConstant.ORACLE, vctValues, strSuffixConstant);
		} else if (AppConstant.DB_TYPE_MYSQL.equals(strDBType)) {
			Vector<String> vct = new Vector<String>();
			vct.add(AppConstant.DB_TYPE_MYSQL);
			strResponse = getResponse(vct, AppConstant.MYSQL, vctValues, strSuffixConstant);
		} else if (AppConstant.DB_TYPE_DB2.equals(strDBType)) {
			Vector<String> vct = new Vector<String>();
			vct.add(AppConstant.DB_TYPE_DB2);
			strResponse = getResponse(vct, AppConstant.DB2, vctValues, strSuffixConstant);
		} else if (AppConstant.DB_TYPE_SQLSERVER.equals(strDBType)) {
			Vector<String> vct = new Vector<String>();
			vct.add(AppConstant.DB_TYPE_SQLSERVER);
			strResponse = getResponse(vct, AppConstant.SQLSERVER, vctValues, strSuffixConstant);
		}
		return strResponse;
	}

	private static String getResponse(Vector<String> vct, String strDBValue,
			Vector<String> vctValues, String strSuffixConstant) {
		String strResponse = "";
		String className = "com.datacon.util." + getReplacedValue(AppConstant.CLASS_NAME, vct);
		@SuppressWarnings("rawtypes")
		Class clas = null;
		try {
			clas = Class.forName(className);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		if (clas != null) {
			Field[] fieldsArrays = clas.getDeclaredFields();
			if (fieldsArrays != null && fieldsArrays.length > 0) {
				for (int i = 0; i < fieldsArrays.length; i++) {
					try {
						String strFieldName = fieldsArrays[i].getName().toString();
						if (strFieldName != null
								&& strFieldName.equals(strDBValue + "_" + strSuffixConstant)) {
							strResponse = getReplacedValue(
									fieldsArrays[i].get(fieldsArrays[i].getName()).toString(),
									vctValues);
							break;
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return strResponse;
	}
}
