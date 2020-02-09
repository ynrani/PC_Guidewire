package com.datacon.util;

public class DataConMySQLConstant extends SepcQueryUtil
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
	public static final String UNIQUE_KEY = "UNIQUE";
	public static final String IS_NULLABLE = "NO";

	public static final String MYSQL_DATE_FORMATE = "select VARIABLE_VALUE AS VALUE From information_schema.session_variables where variable_name='DATE_FORMAT'";
	public static final String MYSQL_PRIMARY_KEY = "( SELECT IFNULL(MAX({0}),0) AS IDGEN from {1} )";
	public static final String MYSQL_GET_ALL_TABLES = "select table_name from information_schema.tables where table_schema='{0}'";
	public static final String MYSQL_GET_ALL_COLUMNS = "select column_name,table_name from information_schema.columns where table_schema='{0}'";
	public static final String MYSQL_GET_PK_COLUMN_TYPE = "select distinct(iku.column_name),ic.data_type,ic.character_maximum_length,ic.numeric_precision,ic.datetime_Precision,iku.table_name from information_schema.key_column_usage iku,information_schema.columns ic where iku.column_name=ic.column_name and iku.table_schema='{0}' and iku.constraint_name='{1}' and iku.table_name='{2}'";

	public static final String MYSQL_GET_ALL_CONSTRAINTS_COLUMNS = "select distinct(column_name),data_type,character_maximum_length,numeric_precision,datetime_Precision,table_name,is_nullable from information_schema.columns where table_schema='{0}' and (column_key in ('MUL','UNI') or is_nullable='NO')";
	public static final String MYSQL_GET_SEQUENCE_OF_COLUMNS1 = "select column_name,data_type,character_maximum_length,numeric_precision,datetime_Precision,table_name from information_schema.columns where table_schema='{0}' and table_name='{1}' order by ordinal_position ";
	public static final String MYSQL_GET_SEQUENCE_OF_COLUMNS2 = "select column_name,data_type,character_maximum_length,numeric_precision,datetime_Precision,table_name from information_schema.columns where table_schema='{0}' and table_name='{1}'  and column_name != '{2}' order by ordinal_position ";
	public static final String MYSQL_GET_TABLES_BY_COLUMNS = "select column_name,data_type,character_maximum_length,numeric_precision,datetime_Precision,table_name from information_schema.columns where table_schema='{0}' and column_name in ";
	public static final String MYSQL_GET_TABLE_NAME_BY_FK = "select referenced_table_name as table_name from information_schema.key_column_usage where table_schema='{0}' and table_name='{1}' and column_name='{2}' and referenced_table_name is not null";
	public static final String MYSQL_GET_SEQUENCE_TABLES = "select rc.referenced_table_name as table_name from information_schema.table_constraints tc,information_schema.referential_constraints rc where rc.constraint_name=tc.constraint_name and tc.TABLE_SCHEMA='{0}' and tc.table_name='{1}' ";
	public static final String MYSQL_GET_CONSTRAINTS_OF_TABLES = "select constraint_name,constraint_type From information_schema.table_constraints where table_schema='{0}' and table_name='{1}'";
	public static final String MYSQL_ONE_TO_ONE_RELATIONS_FIND_TABLES = "select * from (select column_name,table_name,Constraint_name from information_schema.key_column_usage where constraint_name in (select constraint_name from information_schema.table_constraints where table_schema='{0}' and constraint_type='UNIQUE')) "
			+ "tt join (select column_name,table_name,Constraint_name from information_schema.key_column_usage where constraint_name in (select constraint_name from information_schema.table_constraints where table_schema='{0}' and constraint_type='FOREIGN KEY')) ttt on tt.column_name=ttt.column_name";
	public static final String MYSQL_CONSTRAINTS_RELATIONS_TABLES = "select rc.referenced_table_name as table_name from information_schema.table_constraints tc,information_schema.referential_constraints rc where rc.constraint_name=tc.constraint_name and tc.TABLE_SCHEMA='{0}' and tc.constraint_name='{1}' and tc.table_name='{2}'";

	// Specific case we had included this constant
	public static final String MYSQL_GET_NOT_NULL_CONSTRAINTS_OF_TABLES = "select distinct(column_name),data_type,character_maximum_length,numeric_precision,datetime_Precision,table_name,is_nullable from information_schema.columns where table_schema='{0}' and table_name='{1}' and (column_key in ('MUL','UNI') or is_nullable='NO') and column_key !='PRI'";

}
