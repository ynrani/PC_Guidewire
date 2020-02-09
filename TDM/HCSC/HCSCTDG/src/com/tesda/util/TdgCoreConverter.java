/*
 * Object Name : TdgCoreConverter.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class TdgCoreConverter extends TdgCentralConstant{
	public static List<Map<String, Object>> getConvertedResult(JdbcTemplate template,
			String strQuery, String dbType){
		List<Map<String, Object>> lstResult = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> listRes = template.queryForList(strQuery);

			if (dbType != null && (TdgCentralConstant.DB_TYPE_ORACLE.equals(dbType))) {
				for (Map<String, Object> mapRs : listRes) {
					if (mapRs.containsKey(TdgOracleConstant.CHARACTER_LENGTH)
							&& (mapRs.get(TdgOracleConstant.CHARACTER_LENGTH) != null && !"0"
									.equals(mapRs.get(TdgOracleConstant.CHARACTER_LENGTH) + ""))) {
						mapRs.put(TdgCentralConstant.DATA_LENGTH,
								mapRs.get(TdgOracleConstant.CHARACTER_LENGTH));
						if (!mapRs.containsKey(TdgCentralConstant.DATA_TYPE)
								&& !"DATE".equalsIgnoreCase(mapRs.get(TdgCentralConstant.DATA_TYPE)
										+ ""))
							mapRs.put(TdgCentralConstant.DATA_TYPE,
									TdgCentralConstant.ORACLE_VARCHAR);
					} else if (mapRs.containsKey(TdgOracleConstant.DATA_PRECISION)
							&& (mapRs.get(TdgOracleConstant.DATA_PRECISION) != null && !"0"
									.equals(mapRs.get(TdgOracleConstant.DATA_PRECISION) + ""))) {
						mapRs.put(TdgCentralConstant.DATA_LENGTH,
								mapRs.get(TdgOracleConstant.DATA_PRECISION));
						mapRs.put(TdgCentralConstant.DATA_TYPE, TdgMySQLConstant.ORACLE_NUMBER);
					} else if (mapRs.containsKey(TdgMySQLConstant.DATETIME_PRECISION)
							&& (mapRs.get(TdgMySQLConstant.DATETIME_PRECISION) != null && !"0"
									.equals(mapRs.get(TdgMySQLConstant.DATETIME_PRECISION) + ""))) {
						mapRs.put(TdgCentralConstant.DATA_LENGTH,
								mapRs.get(TdgMySQLConstant.DATETIME_PRECISION));
						mapRs.put(TdgCentralConstant.DATA_TYPE, TdgCentralConstant.ORACLE_DATE);
					}
					lstResult.add(mapRs);
				}
			} else {
				lstResult.addAll(listRes);
			}
		
		return lstResult;
	}

	public static List<Map<String, Object>> getConvertInputResult(JdbcTemplate template,
			String strQuery, String dbType){
		String strTemp = "";
		List<Map<String, Object>> lstResult = null;
		if (dbType != null && TdgCentralConstant.DB_TYPE_MYSQL.equals(dbType)) {
			strTemp = "";
		} else {
			strTemp = strQuery;
		}
		lstResult = getConvertedResult(template, strTemp, dbType);
		return lstResult;
	}
}
