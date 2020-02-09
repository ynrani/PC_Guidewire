/*
 * Object Name : TdgCustomDao.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.dao;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.persistence.EntityManager;

import org.springframework.jdbc.core.JdbcTemplate;

import com.tesda.model.DTO.TestDataGenerateDTO;

/**
 *
 */
public interface TdgCustomDao{
	/**
	 * This method is used to get all the table names in sequence based on their relation
	 * @param jdbcTemplate
	 * @param tableName
	 * @return
	 */
	public List<Object> generateSequenceOfTables(JdbcTemplate jdbcTemplate, String tableName);

	/**
	 * This method is used to get all table names
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 */
	public List<String> getAllTables(String url, String username, String password);

	/**
	 * This is used to get all the column names from the database
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 */
	public List<String> getAllCols(String url, String username, String password);

	/**
	 * This method is used to get all the constraint column names,table names,it's data type and
	 * length
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 */
	public List<Map<String, Object>> getAllConstraintCols(String url, String username,
			String password);

	/**
	 * This method is used to get all the table names based on its related schema
	 * @param jdbcTemplate
	 * @param tableName
	 * @return
	 */
	List<Object> getTables(JdbcTemplate jdbcTemplate, String tableName);

	/**
	 * This method is used to get all the constraint column names,table names,it's data type and
	 * length based on passed column names
	 * @param jdbcTemplate
	 * @param listcolumnsName
	 * @return
	 */
	List<Map<String, Object>> getTableNamesByColsName(JdbcTemplate jdbcTemplate,
			List<String> listcolumnsName);

	/**
	 * This method is used to dump the data into DB
	 * @param jdbcTemplate
	 * @param listResultTabs
	 * @param listRelations
	 * @param mapConditions
	 * @param listResultVal
	 * @param iRequiredRecordCount
	 * @param lstTabsNames
	 * @param listMasterTabs
	 * @param mapTableWithSequence
	 * @param listColumnNames
	 * @param mapInputDepends
	 * @param mapReverseDependents
	 * @param mapDataDictionaryVals
	 *            (all the dictionary values in column_name and its related list of data)
	 * @param isDataConditional
	 *            (data conditional boolean value)
	 * @param listDataDictionaryTabNames
	 * @return
	 * @throws Exception
	 */
	Map<String, Vector<String>> generateQueriesAndDumping(JdbcTemplate jdbcTemplate,
			List<List<List<Object>>> listResultTabs, List<String> listRelations,
			Map<String, Object> mapConditions, List<List<Object>> listResultVal,
			long iRequiredRecordCount, List<String> lstTabsNames, List<String> listMasterTabs,
			Map<String, Map<String, Map<String, String>>> mapTableWithSequence,
			List<String> listColumnNames, Map<String, Vector<String>> mapInputDepends,
			Map<String, String> mapReverseDependents,
			Map<String, List<String>> mapDataDictionaryVals, boolean isDataConditional,
			List<String> listDataDictionaryTabNames, TestDataGenerateDTO testDataGenenarteDTO)
			throws Exception;

	/**
	 * This is used to get all the input data of the form from input and generates the required
	 * input data for database to inject.
	 * @param testDataGenenarteDTO
	 * @param managerentity
	 * @return
	 */
	String generateTestData(TestDataGenerateDTO testDataGenenarteDTO, EntityManager managerentity);

	/**
	 * This method is used to get jdbc template
	 * @param strUrl
	 * @param strUsername
	 * @param strPassword
	 * @return
	 */
	JdbcTemplate getTemplate(String strUrl, String strUsername, String strPassword);

	public List<String> getColsByTabs(String strUrl, String strName, String strPass,
			List<String> listPassedTabs);

	Map<String, Map<String, List<Object[]>>> generateFlatTestData(
			TestDataGenerateDTO testDataGenenarteDTO,
			EntityManager managerentity);
}
