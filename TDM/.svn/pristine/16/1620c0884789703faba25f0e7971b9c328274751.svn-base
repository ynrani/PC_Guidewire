/*
 * Object Name : TdgOracleConstant.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.util;

public class TdgOracleConstant extends TdgCentralConstant{
	public static final String ORACLE_DATE_FORMATE = "SELECT VALUE FROM NLS_SESSION_PARAMETERS WHERE PARAMETER='NLS_DATE_FORMAT'";
	public static final String ORACLE_SEQUENCE_VALUE = " SELECT {0}.NEXTVAL AS IDGEN FROM DUAL ";
	public static final String ORACLE_PRIMARY_KEY = " (SELECT NVL(MAX({0}),0) AS IDGEN FROM {1} )";
	public static final String ORACLE_PRIMARY_KEY_FINAL = " (SELECT NVL(MAX(TO_NUMBER(REPLACE({0},'{#}',''))),0) AS IDGEN FROM {1} )";
	public static final String ORACLE_MAX_COLUMN_VALUE = "( SELECT ISNULL(MAX({0}),0) AS IDGEN from {1} )";
	public static final String ORACLE_GET_TABLES = "select table_name from USER_CONSTRAINTS where CONSTRAINT_NAME=(select constraint_name From user_constraints where table_name='{0}' and CONSTRAINT_TYPE='R') ";
	public static final String ORACLE_GET_ALL_TABLES = "select TABLE_NAME from USER_ALL_TABLES ";
	public static final String ORACLE_GET_ALL_COLUMNS = "select COLUMN_NAME,TABLE_NAME from COLS ";
	public static final String ORACLE_GET_ALL_COLUMNS_BY_TAB = "select COLUMN_NAME,TABLE_NAME from COLS WHERE TABLE_NAME in ({0})";
	public static final String ORACLE_GET_PK_COLUMN_TYPE = "select cols.column_name,cols.data_type,cols.DATA_PRECISION,cols.CHAR_LENGTH from cols,USER_CONS_COLUMNS where cols.COLUMN_NAME= USER_CONS_COLUMNS.COLUMN_NAME and USER_CONS_COLUMNS.CONSTRAINT_NAME='{0}' AND cols.TABLE_NAME='{1}'";
	public static final String ORACLE_GET_ALL_CONSTRAINTS_COLUMNS = "select table_name,column_name,data_type,DATA_PRECISION,CHAR_LENGTH from user_tab_cols where COLUMN_NAME in (select column_name from USER_CONS_COLUMNS where constraint_name in (select constraint_name From user_constraints where CONSTRAINT_TYPE in ('R','U','C'))) ";
	public static final String ORACLE_GET_SEQUENCE_OF_COLUMNS1 = "select Column_name,DATA_TYPE,DATA_PRECISION,CHAR_LENGTH from USER_TAB_COLS where table_name='{0}' order by COLUMN_ID";
	public static final String ORACLE_GET_SEQUENCE_OF_COLUMNS2 = "select Column_name,DATA_TYPE,DATA_PRECISION,CHAR_LENGTH from USER_TAB_COLS where table_name='{0}'  and column_name != '{1}' order by COLUMN_ID";
	public static final String ORACLE_GET_TABLES_BY_COLUMNS = "select Column_name,DATA_TYPE,DATA_PRECISION,CHAR_LENGTH,table_name from USER_TAB_COLS where column_name in ";
	public static final String ORACLE_GET_TABLE_NAME_BY_FK = "select table_name from user_constraints where CONSTRAINT_NAME in (select r_constraint_name From USER_CONSTRAINTS where CONSTRAINT_NAME in (select CONSTRAINT_NAME from USER_CONS_COLUMNS where TABLE_NAME='{0}'  AND COLUMN_NAME='{1}' )) ";
	public static final String ORACLE_GET_SEQUENCE_TABLES = "select table_name from USER_CONSTRAINTS where CONSTRAINT_NAME in (select R_constraint_name From user_constraints where table_name='{0}' and CONSTRAINT_TYPE='R') ";
	public static final String ORACLE_GET_CONSTRAINTS_OF_TABLES = "select constraint_name,constraint_type From user_constraints where CONSTRAINT_TYPE in ('R','U','P','C') and table_name='{0}' ";
	public static final String ORACLE_ONE_TO_ONE_RELATIONS_FIND_TABLES = "select *from (select column_name,table_name,constraint_name from (select column_name,table_name,constraint_name from ALL_CONS_COLUMNS where CONSTRAINT_NAME in (select constraint_name From user_constraints"
			+ " where table_name in ({0}) and CONSTRAINT_TYPE IN('U','C')))) tt join "
			+ " (select *From (select column_name,table_name,constraint_name from (select column_name,table_name,constraint_name from ALL_CONS_COLUMNS where CONSTRAINT_NAME in (select constraint_name From user_constraints "
			+ " where table_name in ({0}) and CONSTRAINT_TYPE='R')))) ttt on tt.Column_name = ttt.column_name";
	public static final String ORACLE_CONSTRAINTS_RELATIONS_TABLES = "select table_name from user_constraints where constraint_name in (select R_CONSTRAINT_NAME from USER_CONSTRAINTS where CONSTRAINT_NAME='{0}' AND TABLE_NAME='{1}') ";
	public static final String ORACLE_GET_COLUMNS_OF_TABS_APART_CONSTRAINTS = "select Column_name,DATA_TYPE,DATA_PRECISION,CHAR_LENGTH From USER_TAB_COLS where column_name not in(select column_name From USER_CONS_COLUMNS where TABLE_NAME ='{0}') and table_name='{0}'";
	public static final String CHARACTER_LENGTH = "CHAR_LENGTH";
	public static final String DATA_PRECISION = "DATA_PRECISION";
}
