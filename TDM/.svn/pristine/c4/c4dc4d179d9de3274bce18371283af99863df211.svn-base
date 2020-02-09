package com.datacon.util;

public class DataConSqlServerConstant extends SepcQueryUtil
{

	public static final String PRIMARY = "P";
	public static final String FOREIGN = "R";
	public static final String UNIQUE = "U";
	public static final String PRI = "P";
	public static final String P = "PRI";
	public static final String MUL = "R";
	public static final String UNI = "U";
	public static final String PRIMARY_KEY = "PRIMARY KEY";
	public static final String FOREIGN_KEY = "FOREIGN KEY";
	public static final String NUMERIC_PRECISION = "NUMERIC_PRECISION";
	public static final String CHARACTER_MAXIMUM_LENGTH = "CHARACTER_MAXIMUM_LENGTH";
	public static final String DATETIME_PRECISION = "DATETIME_PRECISION";
	public static final String SQLSERVER_SEQUENCE_VALUE = " SELECT NEXT VALUE FOR {0} AS IDGEN FROM SYSIBM.DUAL";
	public static final String UNIQUE_KEY = "UNIQUE";
	public static final String IS_NULLABLE = "NO";
	public static final String SQLSERVER_DATE_FORMATE = "select VARIABLE_VALUE AS VALUE From information_schema.session_variables where variable_name='DATE_FORMAT'";
	public static final String SQLSERVER_PRIMARY_KEY = "( SELECT ISNULL(MAX({0}),0) AS IDGEN from {1} )";
	public static final String SQLSERVER_GET_ALL_TABLES = "select table_name from information_schema.tables";
	public static final String SQLSERVER_GET_ALL_COLUMNS = "select column_name,table_name from information_schema.columns";
	public static final String SQLSERVER_GET_ALL_COLUMNS_BY_TAB = "select column_name,table_name from information_schema.columns where table_name in ({0})";
	public static final String SQLSERVER_GET_PK_COLUMN_TYPE = "select distinct(iku.column_name),ic.data_type,ic.character_maximum_length,ic.numeric_precision,ic.datetime_Precision,iku.table_name from information_schema.key_column_usage iku,information_schema.columns ic where iku.column_name=ic.column_name and iku.constraint_name='{0}' and iku.table_name='{1}'";
	public static final String SQLSERVER_GET_ALL_CONSTRAINTS_COLUMNS = "select distinct(cc.column_name),cc.data_type,cc.character_maximum_length,cc.numeric_precision,cc.datetime_Precision,cc.table_name,cc.is_nullable from information_schema.columns cc,information_schema.table_constraints tc where (tc.constraint_type in ('PRIMARY KEY','FOREIGN KEY') or cc.is_nullable='NO')";
	public static final String SQLSERVER_GET_SEQUENCE_OF_COLUMNS1 = "select column_name,data_type,character_maximum_length,numeric_precision,datetime_Precision,table_name from information_schema.columns where  table_name='{0}' order by ordinal_position ";
	public static final String SQLSERVER_GET_SEQUENCE_OF_COLUMNS2 = "select column_name,data_type,character_maximum_length,numeric_precision,datetime_Precision,table_name from information_schema.columns where table_name='{0}'  and column_name != '{1}' order by ordinal_position ";
	public static final String SQLSERVER_GET_TABLES_BY_COLUMNS = "select column_name,data_type,character_maximum_length,numeric_precision,datetime_Precision,table_name from information_schema.columns where column_name in ";

	public static final String SQLSERVER_GET_TABLE_NAME_BY_FK = "select table_name from information_schema.table_constraints where constraint_name in (select unique_constraint_name from information_schema.referential_constraints where constraint_name in (select constraint_name from information_schema.key_column_usage where table_name='{0}' and column_name='{1}'))";
	public static final String SQLSERVER_GET_SEQUENCE_TABLES = "select table_name from information_schema.table_constraints where CONSTRAINT_NAME in (select unique_constraint_name From information_schema.referential_constraints where constraint_name in (select constraint_name From information_schema.table_constraints where table_name='{0}' and CONSTRAINT_TYPE='FOREIGN KEY'))";
	public static final String SQLSERVER_GET_CONSTRAINTS_OF_TABLES = "select constraint_name,constraint_type From information_schema.table_constraints where table_name='{0}'";
	public static final String SQLSERVER_ONE_TO_ONE_RELATIONS_FIND_TABLES = "select * from (select column_name,table_name,Constraint_name from information_schema.key_column_usage where constraint_name in (select constraint_name from information_schema.table_constraints where constraint_type='UNIQUE')) "
			+ "tt join (select column_name,table_name,Constraint_name from information_schema.key_column_usage where constraint_name in (select constraint_name from information_schema.table_constraints where constraint_type='FOREIGN KEY')) ttt on tt.column_name=ttt.column_name";
	public static final String SQLSERVER_CONSTRAINTS_RELATIONS_TABLES = "select table_name from information_schema.table_constraints where constraint_name in (select rc.unique_constraint_name from information_schema.table_constraints tc,information_schema.referential_constraints rc where rc.constraint_name=tc.constraint_name and tc.constraint_name='{0}' and tc.table_name='{1}')";
	// Specific case we had included this constant
	public static final String SQLSERVER_GET_NOT_NULL_CONSTRAINTS_OF_TABLES = "select distinct(cc.column_name),cc.data_type,cc.character_maximum_length,cc.numeric_precision,cc.datetime_Precision,cc.table_name,cc.is_nullable from information_schema.columns cc,information_schema.table_constraints tc where cc.table_name='{0}' and (tc.constraint_type in ('UNIQUE','FOREIGN KEY') or cc.is_nullable='NO') and tc.constraint_type !='PRIMERY KEY'";
	public static final String SQLSERVER_GET_COLUMNS_OF_TABS_APART_CONSTRAINTS = "select distinct(column_name),data_type,character_maximum_length,numeric_precision,datetime_Precision,table_name,is_nullable from information_schema.columns where column_name not in(select distinct(cc.column_name) from information_schema.columns cc,information_schema.table_constraints tc where cc.table_name = '{0}' and (tc.constraint_type in ('PRIMARY KEY','FOREIGN KEY') or cc.is_nullable='NO')) and table_name='{0}'";

}
