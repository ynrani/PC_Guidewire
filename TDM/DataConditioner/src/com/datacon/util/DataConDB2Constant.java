package com.datacon.util;

public class DataConDB2Constant extends SepcQueryUtil
{

	public static final String NULLABLE = "N";

	public static final String DB2_SEQUENCE_VALUE = " SELECT NEXT VALUE FOR {0} AS IDGEN FROM SYSIBM.DUAL";
	public static final String DB2_PRIMARY_KEY = "SELECT NVL(MAX({0}),0) AS IDGEN FROM {1}";

	public static final String DB2_GET_ALL_TABLES = "SELECT TABLE_NAME FROM USER_ALL_TABLES";
	public static final String DB2_GET_ALL_COLUMNS = "SELECT COLUMN_NAME,TABLE_NAME FROM USER_TAB_COLUMNS ";
	public static final String DB2_GET_PK_COLUMN_TYPE = "select cols.column_name,cols.data_type,cols.DATA_LENGTH from USER_TAB_COLUMNS cols,USER_CONS_COLUMNS where cols.COLUMN_NAME= USER_CONS_COLUMNS.COLUMN_NAME and USER_CONS_COLUMNS.CONSTRAINT_NAME='{0}' AND cols.TABLE_NAME='{1}'";
	public static final String DB2_GET_ALL_CONSTRAINTS_COLUMNS = "select table_name,column_name,data_type,data_length from USER_TAB_COLUMNS where COLUMN_NAME in (select column_name from USER_CONS_COLUMNS where constraint_name in (select constraint_name From user_constraints where CONSTRAINT_TYPE in ('R','U','C')))";
	public static final String DB2_GET_SEQUENCE_OF_COLUMNS1 = "select Column_name,DATA_TYPE,DATA_LENGTH from USER_TAB_COLUMNS where table_name='{0}' order by COLUMN_ID";
	public static final String DB2_GET_SEQUENCE_OF_COLUMNS2 = "select Column_name,DATA_TYPE,DATA_LENGTH from USER_TAB_COLUMNS where table_name='{0}'  and column_name != '{1}' order by COLUMN_ID";
	public static final String DB2_GET_TABLES_BY_COLUMNS = "select Column_name,DATA_TYPE,DATA_LENGTH,table_name from USER_TAB_COLUMNS where column_name in ";
	public static final String DB2_GET_TABLE_NAME_BY_FK = "select table_name from user_constraints where CONSTRAINT_NAME in (select r_constraint_name From USER_CONSTRAINTS where CONSTRAINT_NAME in (select CONSTRAINT_NAME from USER_CONS_COLUMNS where TABLE_NAME='{0}'  AND COLUMN_NAME='{1}' )) ";
	public static final String DB2_GET_SEQUENCE_TABLES = "select table_name from USER_CONSTRAINTS where CONSTRAINT_NAME in (select R_constraint_name From user_constraints where table_name='{0}' and CONSTRAINT_TYPE='R') ";
	public static final String DB2_GET_CONSTRAINTS_OF_TABLES = "select constraint_name,constraint_type From user_constraints where CONSTRAINT_TYPE in ('R','U','P','C') and table_name='{0}' ";
	public static final String DB2_ONE_TO_ONE_RELATIONS_FIND_TABLES = "select *from (select column_name,table_name,constraint_name from (select column_name,table_name,constraint_name from ALL_CONS_COLUMNS where CONSTRAINT_NAME in (select constraint_name From user_constraints"
			+ " where table_name in ({0}) and CONSTRAINT_TYPE IN('U','C')))) tt join "
			+ " (select *From (select column_name,table_name,constraint_name from (select column_name,table_name,constraint_name from ALL_CONS_COLUMNS where CONSTRAINT_NAME in (select constraint_name From user_constraints "
			+ " where table_name in ({0}) and CONSTRAINT_TYPE='R')))) ttt on tt.Column_name = ttt.column_name";
	public static final String DB2_CONSTRAINTS_RELATIONS_TABLES = "select table_name from user_constraints where constraint_name in (select R_CONSTRAINT_NAME from USER_CONSTRAINTS where CONSTRAINT_NAME='{0}' AND TABLE_NAME='{1}') ";

	public static final String DB2_GET_NOT_NULL_CONSTRAINTS_OF_TABLES = "select column_name,data_type,data_length,table_name,nullable from USER_TAB_COLUMNS where table_name='{0}' and nullable='N' and Column_name not in ( select column_name from USER_CONS_COLUMNS where table_name='{0}') ";
}
