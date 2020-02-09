/*
 * Object Name : TdgCustomDaoImp.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.dao.impl;

import java.io.File;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.dao.TdgCustomDao;
import com.tesda.dao.TdgOperationsDao;
import com.tesda.model.DO.TdgRequestListDO;
import com.tesda.model.DTO.TestDataGenerateDTO;
import com.tesda.util.GenerateRandom;
import com.tesda.util.TdgCentralConstant;
import com.tesda.util.TdgCoreConverter;
import com.tesda.util.ZipUtil;

@Component("tdgCustomDao")
public class TdgCustomDaoImp implements TdgCustomDao{
	private static Logger logger = Logger.getLogger(TdgCustomDaoImp.class);
	private static String strClassName = " [ TdgCustomDaoImp ] ";
	private String dbType = "";
	private String schemaName = "";
	private Map<String, List<String>> mapConditionValues = null;
	private StringBuffer strStatusDescription = null;
	
	//following is added fro flat file generation of excel and csv
	private StringBuffer strFlatFilesPaths = null;
	private String strTempPath = null;
	@Autowired
	TdgOperationsDao tdgOperationsDao;
	//the following parameter is added for sequence insert from data dictionary which is uploaded as manually
	List<Integer> lstSequence= new ArrayList<Integer>();
	/**
	 * This method is used to get the jdbc template of respective schema
	 */
	SingleConnectionDataSource dataSource = null;
	private Map<String, Vector<String>> mapDependentValues;
	
	List<String> lstGeneratedFiles = new ArrayList<String>();

	@Override
	public JdbcTemplate getTemplate(String strUrl, String strUsername, String strPassword){
		String strMethodName = " [ getTemplate() ] ";
		logger.info(strClassName + strMethodName + " inside saveSchemaDetails method");
		dataSource = new SingleConnectionDataSource(strUrl, strUsername, strPassword, true);
		dataSource.setAutoCommit(false);
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(
				dataSource);
		// dataSourceTransactionManager.commit(false);
		dataSourceTransactionManager.setRollbackOnCommitFailure(true);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceTransactionManager.getDataSource());
		if (strUrl != null) {
			if (strUrl.toLowerCase().contains("oracle")) {
				setDbType(TdgCentralConstant.DB_TYPE_ORACLE);
				setSchemaName("");
			} else if (strUrl.toLowerCase().contains("mysql")) {
				setDbType(TdgCentralConstant.DB_TYPE_MYSQL);
				String strArrays[] = strUrl.split("\\/");
				if (strArrays != null && strArrays.length > 0) {
					setSchemaName(strArrays[strArrays.length - 1].toUpperCase());
				} else {
					setSchemaName("TEST");// set for default now
				}
			} else if (strUrl.toLowerCase().contains("db2")) {
				setDbType(TdgCentralConstant.DB_TYPE_DB2);
				setSchemaName("");
			}
			else if (strUrl.toLowerCase().contains("sqlserver")) {
				setDbType(TdgCentralConstant.DB_TYPE_SQLSERVER);
				setSchemaName("");
			}
		}
		logger.info(strClassName + strMethodName + " return from saveSchemaDetails method");
		return jdbcTemplate;
	}

	/**
	 * This method is used to fetch all the tables are in sequence which are exist in respective
	 * schema of oracle
	 */
	@Override
	public List<Object> getTables(JdbcTemplate jdbcTemplate, String tableName){
		String strMethodName = " [ getTables() ] ";
		logger.info(strClassName + strMethodName + " inside getTables method");
		List<Object> listObject = new ArrayList<Object>();
		Vector<String> vct = new Vector<String>(getVectorVals());
		vct.add(tableName);
		List<Map<String, Object>> listValues = jdbcTemplate.queryForList(TdgCentralConstant
				.getSpecificDBQuery(getDbType(), TdgCentralConstant.GET_TABLES, vct));// generic
																						// solution
		logger.info(strClassName + strMethodName + " got foriegn key constraints of the table : "
				+ tableName);
		for (Map<String, Object> mapValues : listValues) {
			listObject.add(generateSequenceOfTables(jdbcTemplate, ((String) mapValues.entrySet()
					.iterator().next().getValue())
					+ tableName.substring(tableName.indexOf("#"), tableName.length())));
		}
		logger.info(strClassName + strMethodName + " return from getTables method");
		return listObject;
	}

	/**
	 * This method is used to fetch all the tables which are exist in respective schema of oracle
	 */
	@Override
	public List<String> getAllTables(String url, String username, String password){
		String strMethodName = " [ getAllTables() ] ";
		logger.info(strClassName + strMethodName + " inside getAllTables method");
		JdbcTemplate template = getTemplate(url, username, password);
		List<String> listTableNames = new ArrayList<String>();
		try {
			List<Map<String, Object>> listString = template.queryForList(TdgCentralConstant
					.getSpecificDBQuery(getDbType(), TdgCentralConstant.GET_ALL_TABLES,
							getVectorVals()));
			for (Map<String, Object> mapValues : listString) {
				listTableNames.add(mapValues.get("TABLE_NAME").toString().toUpperCase());
			}
			logger.info(strClassName + strMethodName + " got all tables list from passed schema");
			logger.info(strClassName + strMethodName + " return getAllTables method");
		} finally {
			cleanupDataSource(template);
		}
		return listTableNames;
	}

	/**
	 * This method is used to fetch all the columns which are exist in respective schema of oracle
	 */
	@Override
	public List<String> getAllCols(String url, String username, String password){
		String strMethodName = " [ getAllCols() ] ";
		logger.info(strClassName + strMethodName + " inside getAllCols method");
		List<String> listResult = getColsByTabs(url, username, password, null);
		return listResult;
	}

	@Override
	public List<String> getColsByTabs(String url, String username, String password,
			List<String> lstTabNames){
		List<String> listResult = new ArrayList<String>();
		List<String> listURLs = new ArrayList<String>();
		List<String> listUserNames = new ArrayList<String>();
		List<String> listPasswords = new ArrayList<String>();
		int iCount = 1;
		StringBuffer strBuffer = new StringBuffer();
		boolean bTabsPassed = false;
		if (lstTabNames != null && !lstTabNames.isEmpty()) {
			bTabsPassed = true;
			for (String string : lstTabNames) {				
				strBuffer.append('\'').append(string).append('\'');
				if (iCount != lstTabNames.size()) {
					strBuffer.append(',');
				}
				iCount++;
				
			}
		}
		if (url != null && url.contains("#")) {
			listURLs.addAll(Arrays.asList(url.split("#")));
		} else {
			listURLs.add(url);
		}
		if (username != null && username.contains("#")) {
			listUserNames.addAll(Arrays.asList(username.split("#")));
		} else {
			listUserNames.add(username);
		}
		if (password != null && password.contains("#")) {
			listPasswords.addAll(Arrays.asList(password.split("#")));
		} else {
			listPasswords.add(password);
		}
		if (!listURLs.isEmpty() && !listUserNames.isEmpty() && !listPasswords.isEmpty()) {
			for (int i = 0; i < listURLs.size(); i++) {
				String urlTemp = listURLs.get(i);
				String userNameTemp = listUserNames.get(i);
				String passTemp = listPasswords.get(i);
				if (bTabsPassed) {
					listResult.addAll(getSpecificAllColsByTabs(urlTemp, userNameTemp, password,
							strBuffer.toString()));
				} else {
					listResult.addAll(getSpecificAllCols(urlTemp, userNameTemp, passTemp));
				}
			}
		}
		return listResult;
	}

	private List<String> getSpecificAllCols(String url, String username, String password){
		String strMethodName = " [ getSpecificAllCols() ] ";
		JdbcTemplate template = getTemplate(url, username, password);
		List<String> listResult = new ArrayList<String>();
		try {
			List<Map<String, Object>> listString = template.queryForList(TdgCentralConstant
					.getSpecificDBQuery(getDbType(), TdgCentralConstant.GET_ALL_COLUMNS,
							getVectorVals()));
			for (Map<String, Object> map : listString) {
				listResult.add(String.valueOf(map.get("COLUMN_NAME")).toUpperCase());
			}
			logger.info(strClassName + strMethodName + " got all columns list from passed schema");
			logger.info(strClassName + strMethodName + " return getAllCols method");
		} finally {
			cleanupDataSource(template);
		}
		return listResult;
	}

	private List<String> getSpecificAllColsByTabs(String url, String username, String password,
			String tabs){
		String strMethodName = " [ getSpecificAllCols() ] ";
		JdbcTemplate template = getTemplate(url, username, password);
		List<String> listResult = new ArrayList<String>();
		try {
			Vector<String> vct = new Vector<String>(getVectorVals());
			vct.add(tabs);
			List<Map<String, Object>> listString = template
					.queryForList(TdgCentralConstant.getSpecificDBQuery(getDbType(),
							TdgCentralConstant.GET_ALL_COLUMNS_BY_TAB, vct));
			for (Map<String, Object> map : listString) {
				listResult.add(String.valueOf(map.get("COLUMN_NAME")).toUpperCase());
			}
			logger.info(strClassName + strMethodName + " got all columns list from passed schema");
			logger.info(strClassName + strMethodName + " return getAllCols method");
		} finally {
			cleanupDataSource(template);
		}
		return listResult;
	}

	/**
	 * This method is used to fetch all the constraints columns which refers to Foreign key and
	 * unique constraints in oracle
	 */
	@Override
	public List<Map<String, Object>> getAllConstraintCols(String url, String username,
			String password){
		String strMethodName = " [ getAllConstraintCols() ] ";
		logger.info(strClassName + strMethodName + " inside getAllConstraintCols method");
		JdbcTemplate template = getTemplate(url, username, password);
		List<Map<String, Object>> listString = null;
		try {
			listString = TdgCoreConverter.getConvertedResult(template, TdgCentralConstant
					.getSpecificDBQuery(getDbType(),
							TdgCentralConstant.GET_ALL_CONSTRAINTS_COLUMNS, getVectorVals()),
					getDbType());
			logger.info(strClassName + strMethodName + " return getAllConstraintCols method");
		} finally {
			cleanupDataSource(template);
		}
		return listString;
	}

	private Set<String> getTableNamesFromCols(JdbcTemplate jdbcTemplate, Map<String, Object> mapCols){
		String strMethodName = " [ getTableNamesFromCols() ] ";
		logger.info(strClassName + strMethodName + " inside getTableNamesFromCols method");
		Set<String> stTabs = new HashSet<String>();
		if (mapCols != null && !mapCols.isEmpty()) {
			List<String> listCols = new ArrayList<String>();
			for (String strKey : mapCols.keySet()) {
				listCols.add(strKey);
			}
			List<Map<String, Object>> lstResult = getTableNamesByColsName(jdbcTemplate, listCols);
			for (Map<String, Object> map : lstResult) {
				stTabs.add(String.valueOf(map.get("TABLE_NAME")).toUpperCase());
			}
		}
		logger.info(strClassName + strMethodName + " return getTableNamesFromCols method");
		return stTabs;
	}

	private Set<String> getTableNamesFromCols(JdbcTemplate jdbcTemplate, List<String> listCols){
		String strMethodName = " [ getTableNamesFromCols() ] ";
		logger.info(strClassName + strMethodName + " inside getTableNamesFromCols method");
		Set<String> stTabs = new HashSet<String>();
		if (listCols != null && !listCols.isEmpty()) {
			List<Map<String, Object>> lstResult = getTableNamesByColsName(jdbcTemplate, listCols);
			for (Map<String, Object> map : lstResult) {
				stTabs.add(String.valueOf(map.get("TABLE_NAME")).toUpperCase());
			}
		}
		logger.info(strClassName + strMethodName + " return getTableNamesFromCols method");
		return stTabs;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String generateTestData(TestDataGenerateDTO testDataGenenarteDTO,
			EntityManager managerentity){
		String strMethodName = " [ generateTestData() ] ";
		logger.info(strClassName + strMethodName + " inside generateTestData method");
		String strSuccess = TdgCentralConstant.FAILED_MESSAGE;
		strStatusDescription = new StringBuffer();
		lstGeneratedFiles = new ArrayList<String>();
		List<JdbcTemplate> listTemplates = new ArrayList<JdbcTemplate>();
		mapConditionValues = new HashMap<String, List<String>>();
		strFlatFilesPaths = new StringBuffer();
		/**
		 * Support multiple database inject for depends
		 */
		List<String> listURLs = new ArrayList<String>();
		List<String> listUserNames = new ArrayList<String>();
		List<String> listPasswords = new ArrayList<String>();
		List<String> listDateFormates = new ArrayList<String>();
		if (testDataGenenarteDTO.getUrl() != null && testDataGenenarteDTO.getUrl().contains("#")) {
			listURLs.addAll(Arrays.asList(testDataGenenarteDTO.getUrl().split("#")));
		} else {
			listURLs.add(testDataGenenarteDTO.getUrl());
		}
		if (testDataGenenarteDTO.getUsername() != null
				&& testDataGenenarteDTO.getUsername().contains("#")) {
			listUserNames.addAll(Arrays.asList(testDataGenenarteDTO.getUsername().split("#")));
		} else {
			listUserNames.add(testDataGenenarteDTO.getUsername());
		}
		if (testDataGenenarteDTO.getPassword() != null
				&& testDataGenenarteDTO.getPassword().contains("#")) {
			listPasswords.addAll(Arrays.asList(testDataGenenarteDTO.getPassword().split("#")));
		} else {
			listPasswords.add(testDataGenenarteDTO.getPassword());
		}
		if (testDataGenenarteDTO.getDateFormate() != null
				&& testDataGenenarteDTO.getDateFormate().contains("#")) {
			listDateFormates
					.addAll(Arrays.asList(testDataGenenarteDTO.getDateFormate().split("#")));
		} else {
			listDateFormates.add(testDataGenenarteDTO.getDateFormate());
		}
		/**
		 * Map dependent values for reverse engineering to fetch values
		 */
		Map<String, String> mapReverseDependents = new HashMap<String, String>();
		if (testDataGenenarteDTO.getColumnsdepends() != null
				&& testDataGenenarteDTO.getColumnsdepends().contains(";")) {
			String strArrays[] = testDataGenenarteDTO.getColumnsdepends().split(";");
			for (int i = 0; i < strArrays.length; i++) {
				if (strArrays[i] != null && strArrays[i].contains("#")) {
					String strColsArrays[] = strArrays[i].split("#");
					mapReverseDependents.put(strColsArrays[1], strColsArrays[0]);
				}
			}
		}
		if (!listURLs.isEmpty() && !listUserNames.isEmpty() && !listPasswords.isEmpty() ) {
			//added below code for zip file creation
			if(!testDataGenenarteDTO.getGenerationType().equalsIgnoreCase("DB")){
			File mkdir = new File(System.getProperty("java.io.tmpdir")+"/TestDataGenerate"+(new Random().nextInt(100000000)));
			if(mkdir.mkdir()){
				logger.info(strClassName + strMethodName + " temp file path is created....");
				strTempPath = mkdir.getAbsolutePath();
			}
			}
			//end
			
			Map<String, Vector<String>> mapDependsColumns = new HashMap<String, Vector<String>>();
			for (int i = 0; i < listURLs.size(); i++) {
				
				String urlTemp = listURLs.get(i);
				String userNameTemp = listUserNames.get(i);
				String passTemp = listPasswords.get(i);
				JdbcTemplate jdbcTemplate = getTemplate(urlTemp, userNameTemp, passTemp);
				listTemplates.add(jdbcTemplate);
				testDataGenenarteDTO.setDateFormate(listDateFormates.get(i));
				Map<String, Vector<String>> tmpDependsColumns = generateTestForMutlipleDatabasesData(
						testDataGenenarteDTO, managerentity, jdbcTemplate, i, mapDependsColumns,
						mapReverseDependents);
				if (tmpDependsColumns.containsKey(TdgCentralConstant.FAILED_MESSAGE)) {
					strSuccess = TdgCentralConstant.FAILED_MESSAGE;
					break;
				} else {
					mapDependsColumns.putAll(tmpDependsColumns);
				}
				if (i == listURLs.size() - 1
						&& !tmpDependsColumns.containsKey(TdgCentralConstant.FAILED_MESSAGE)) {
					strSuccess = TdgCentralConstant.SUCCESS_MESSAGE;
				}
			}
			
			// final insert for trace purpose of the tdg history
			TdgRequestListDO tdgRequestListDO = new TdgRequestListDO();
			tdgRequestListDO.setReqschemaid(testDataGenenarteDTO.getSchemaId());
			tdgRequestListDO.setUserid(testDataGenenarteDTO.getUserId());
			tdgRequestListDO.setSchemaname(testDataGenenarteDTO.getSchemaname());
			tdgRequestListDO.setUserid(testDataGenenarteDTO.getUserId());
			tdgRequestListDO.setGenerationType(testDataGenenarteDTO.getGenerationType());
			if(strFlatFilesPaths != null){
				tdgRequestListDO.setFlatFilesPath(strFlatFilesPaths.toString());
			}
			if (testDataGenenarteDTO.isDataConditional()) {
				tdgOperationsDao.doDeleteDataConditionalValues(
						testDataGenenarteDTO.getDataConditionalTabNames(),
						testDataGenenarteDTO.getGenerateRecordsCount(), managerentity);
				Map<String, List<String>> mapInput = testDataGenenarteDTO
						.getMapDictionaryVals();
				if (mapInput != null && !mapInput.isEmpty()) {
					if (mapConditionValues.isEmpty()) {
						mapConditionValues = new HashMap<String, List<String>>();
					}
					for (Map.Entry<String, List<String>> mapEntry : mapInput.entrySet()) {
						if (!mapConditionValues.containsKey(mapEntry.getKey())) {
							List<String> listParams = new ArrayList<String>();
							for (int i = 0; i < testDataGenenarteDTO.getGenerateRecordsCount(); i++) {
								listParams.add(mapEntry.getValue().get(i));
							}
							mapConditionValues.put(mapEntry.getKey(), listParams);
						}
					}
				}
			}
			StringBuffer strBuffer = new StringBuffer();
			if(testDataGenenarteDTO.getRequiredSequenceColumns() != null && !testDataGenenarteDTO.getRequiredSequenceColumns().isEmpty()){
				int iCount = 1;
				for (String strValue : testDataGenenarteDTO.getRequiredSequenceColumns()) {
					strBuffer.append(strValue);
					if (iCount != testDataGenenarteDTO.getRequiredSequenceColumns().size()) {
						strBuffer.append('#');
					}
					iCount++;
				}
			}else{			
			if (!mapConditionValues.isEmpty()) {
				int iCount = 1;
				for (Map.Entry<String, List<String>> mapentry : mapConditionValues.entrySet()) {
					strBuffer.append(mapentry.getKey());
					if (iCount != mapConditionValues.size()) {
						strBuffer.append('#');
					}
					iCount++;
				}
			}			
			}
			tdgRequestListDO.setConditions(strBuffer.toString());
			
			if (TdgCentralConstant.SUCCESS_MESSAGE.equals(strSuccess)) {				
			    tdgRequestListDO.setRequestCount(testDataGenenarteDTO.getGenerateRecordsCount());
			    if(lstGeneratedFiles.isEmpty()){
			    @SuppressWarnings("rawtypes")
				Vector vct = new Vector();
			    vct.add(testDataGenenarteDTO.getGenerateRecordsCount());
			    vct.addElement(strStatusDescription);
			    
			    tdgRequestListDO.setStatusdescription(TdgCentralConstant.getReplacedValue(TdgCentralConstant.TDG_GENERATE_SUCCESS_MESSAGE, vct));
			    }else{
			    	tdgRequestListDO.setStatusdescription(strStatusDescription.toString());
			    }
			    
			    if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_CSV.equalsIgnoreCase(testDataGenenarteDTO.getGenerationType()) || TdgCentralConstant.SCHEMA_GENERATION_TYPE_XLS.equalsIgnoreCase(testDataGenenarteDTO.getGenerationType())){
			 // going to generate the zip file of generated flat files
			    String strDestinationFolder = System.getProperty("user.home")+("/Downloads/GeneratedFiles")+(new Random().nextInt(10000000))+".zip";
			    
				ZipUtil zipUtil = new ZipUtil(strTempPath,strDestinationFolder);
				zipUtil.generateZipFile(zipUtil);
				tdgRequestListDO.setStatusdescription(strDestinationFolder);
			    }
			    tdgRequestListDO.setStatus(TdgCentralConstant.TDG_GENERATE_SUCCESS);
			    
			}else{
				tdgRequestListDO.setRequestCount(0);
				tdgRequestListDO.setStatusdescription(strStatusDescription.toString());
				tdgRequestListDO.setStatus(TdgCentralConstant.TDG_GENERATE_FAILED);
				try{
					for(String strFileNames : lstGeneratedFiles){
						File file = new File(strFileNames);
						if(file.exists() && file.delete())
							logger.info(strClassName + strMethodName
									+ " generated file is deleted ");
					}
				}catch(Exception e){
					logger.error(strClassName + strMethodName
							+ " error occured while delete the files ::  ", e);
				}
				
			}
			
			
			
			//strSuccess = TdgCentralConstant.FAILED_MESSAGE;setStatus<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Status</th><th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Status</th><td align="left">${tdgRequestListDTOs.status}</td><td align="left">${tdgRequestListDTOs.status}</td>
			String response = tdgOperationsDao.saveDashBoardDetails(tdgRequestListDO,
					mapConditionValues, managerentity);
			strSuccess = strSuccess+"#"+response;
			
			
			try {
				for (JdbcTemplate template : listTemplates) {
					if (!strSuccess.contains(TdgCentralConstant.SUCCESS_MESSAGE)) {
						template.getDataSource().getConnection().rollback();
					} else {
						template.getDataSource().getConnection().commit();
					}
					cleanupDataSource(template);
				}
			} catch (SQLException e1) {
				logger.error(strClassName + strMethodName
						+ " error occured while rollback the transaction ::  ", e1);
			}finally{
				if(strTempPath != null){
					File file = new File(strTempPath);
					if(file.exists() && file.delete()){
						logger.info(strClassName + strMethodName
								+ " tmp path of files are deleted");
					}
				}
			}
		}
		return strSuccess;
	}

	public Map<String, Vector<String>> generateTestForMutlipleDatabasesData(
			TestDataGenerateDTO testDataGenenarteDTO, EntityManager managerentity,
			JdbcTemplate jdbcTemplate, int iCurrentSchema,
			Map<String, Vector<String>> mapInputDepends, Map<String, String> mapReverseDependents){
		String strMethodName = " [ generateTestForMutlipleDatabasesData() ] ";
		String strSuccess = TdgCentralConstant.FAILED_MESSAGE;
		Map<String, Vector<String>> mapDependsColumns = new HashMap<String, Vector<String>>();
		try {
			Map<String, Object> mapObjects = testDataGenenarteDTO.getMapinputData();
			List<String> listColumnNames = new ArrayList<String>();
			/**
			 * The following code is added for multiple databases columns dependent values in
			 * dictionary
			 */
			if (testDataGenenarteDTO.getColumnsdepends() != null
					&& testDataGenenarteDTO.getColumnsdepends().contains(";")) {
				String strArrays[] = testDataGenenarteDTO.getColumnsdepends().split(";");
				for (int i = 0; i < strArrays.length; i++) {
					if (strArrays[i] != null && strArrays[i].contains("#")) {
						String strColsArrays[] = strArrays[i].split("#");
						if (!testDataGenenarteDTO.getMapinputData().containsKey(
								strColsArrays[iCurrentSchema])) {
							mapObjects.put(strColsArrays[iCurrentSchema], "");
						}
						listColumnNames.add(strColsArrays[iCurrentSchema]);
					}
					testDataGenenarteDTO.setMapinputData(mapObjects);
				}
			}
			/**
			 * End the support
			 */
			List<String> listTabNames = new ArrayList<String>();
			if (testDataGenenarteDTO.getDataConditionalTabNames() != null
					&& !testDataGenenarteDTO.getDataConditionalTabNames().isEmpty()) {
				listTabNames.addAll(testDataGenenarteDTO.getDataConditionalTabNames());
			} else {
				listTabNames.addAll(getTableNamesFromCols(jdbcTemplate,
						testDataGenenarteDTO.getMapinputData()));
				if (testDataGenenarteDTO.getMapinputData() != null
						&& testDataGenenarteDTO.getMapinputData().isEmpty()) {
					listTabNames.addAll(getTableNamesFromCols(jdbcTemplate,
							testDataGenenarteDTO.getGUIDictionaryColumns()));
				}
			}
			List<List<List<Object>>> listR = new ArrayList<List<List<Object>>>();
			List<List<Object>> listResultVal = new ArrayList<List<Object>>();
			List<String> mapOnetoOnerelation = new ArrayList<String>();
			List<String> listExistVals = new ArrayList<String>();
			for (String strTableName : listTabNames) {
				if (!listExistVals.contains(strTableName)) {
					List<Object> listResult = generateSequenceOfTables(jdbcTemplate, strTableName);
					List<Object> listResultValTemp = toCheckrelations(listResult, null);
					listResultVal.add(listResultValTemp);
					List<List<Object>> listRTemp = toCheckrelations(listResultValTemp);
					listR.add(listRTemp);
					for (List<Object> listobj : listRTemp) {
						Collections.reverse(listobj);
						StringBuffer strBuffer = new StringBuffer();
						int i = 0;
						for (Object obj : listobj) {
							i++;
							listExistVals.add(String.valueOf(obj).substring(0,
									String.valueOf(obj).indexOf("#")));
							strBuffer
									.append('\'')
									.append(String.valueOf(obj).substring(0,
											String.valueOf(obj).indexOf("#"))).append('\'');
							if (i != listobj.size()) {
								strBuffer.append(',');
							}
						}
						List<Map<String, Object>> listMapping = getOntToOneTableInformation(
								jdbcTemplate, strBuffer.toString());
						for (Map<String, Object> mapValues : listMapping) {
							String strValue = String.valueOf(mapValues.get("CONSTRAINT_NAME"));
							String strTable = String.valueOf(mapValues.get("TABLE_NAME"));
							List<Map<String, Object>> listMappingValues = getConstraintRelationTable(
									jdbcTemplate, strValue, strTable);
							for (Map<String, Object> mapValuesTemp : listMappingValues) {
								mapOnetoOnerelation.add(String.valueOf(
										mapValuesTemp.get("TABLE_NAME")).toUpperCase()
										+ "#" + strTable.toUpperCase());
							}
						}
					}
				}
			}
			if (logger.isDebugEnabled())
				logger.debug(strClassName + strMethodName + " relation found map is "
						+ mapOnetoOnerelation);
			/**
			 * Going to get the master tables list
			 */
			List<String> listMasterTabs = new ArrayList<String>();
			if (testDataGenenarteDTO.getSchemamastertables() != null
					&& testDataGenenarteDTO.getSchemamastertables().contains(";")) {
				String strArrays[] = testDataGenenarteDTO.getSchemamastertables().split(";");
				if (strArrays.length >= 1) {
					if (strArrays[0].contains(",")) {
						String[] strMasterTabs = strArrays[0].split(",");
						for (String strVal : strMasterTabs) {
							listMasterTabs.add(strVal.toUpperCase().trim());
						}
					} else {
						listMasterTabs.add(strArrays[0].toUpperCase().trim());
					}
				}
			}
			Map<String, Object> mapConditions = testDataGenenarteDTO.getMapinputData();
			Map<String, Object> mapConditionsPassed = new HashMap<String, Object>();
			if (mapConditions != null && !mapConditions.isEmpty()) {
				for (Map.Entry<String, Object> mapValue : mapConditions.entrySet()) {
					if (null != mapValue.getValue() && !"".equals(mapValue.getValue())
							&& !"".equals(mapValue.getValue().toString().trim())) {
						if (mapValue.getKey().contains("#")) {
							String strArray[] = mapValue.getKey().split("#");
							for (int ii = 0; ii < strArray.length; ii++) {
								if (mapValue.getValue().toString().contains("#")) {
									String strArrays[] = mapValue.getValue().toString().split("#");
									List<Object> lst = new ArrayList<Object>();
									for (int i2 = 0; i2 < strArrays.length; i2++) {
										lst.add(strArray[i2]);
									}
									mapConditionsPassed.put(mapValue.getKey(), lst);
								}else {
									mapConditionsPassed.put(strArray[ii], mapValue.getValue());
								}
							}
						} else {
							if (mapValue.getValue().toString().contains("#")) {
								String strArray[] = mapValue.getValue().toString().split("#");
								List<Object> lst = new ArrayList<Object>();
								for (int ii = 0; ii < strArray.length; ii++) {
									lst.add(strArray[ii]);
								}
								mapConditionsPassed.put(mapValue.getKey(), lst);
							}else {
								mapConditionsPassed.put(mapValue.getKey(), mapValue.getValue());
							}
						}
					}
				}
			}
			/**
			 * Going for fetching sequence names with tables
			 * later modified for prefix support for other columns also based on constraints types
			 */
			// Map<String, Map<String, String>> mapTableWithSequence = new HashMap<String,
			// Map<String, String>>();
			Map<String, Map<String, Map<String, String>>> mapTableWithSequence = new HashMap<String, Map<String, Map<String, String>>>();
			String str = testDataGenenarteDTO.getSeqtableprefix();
			if (str != null && str.contains(";")) {
				String strArray[] = str.split(";");
				if (strArray != null && strArray.length > 0) {
					for (int i = 0; i < strArray.length; i++) {
						if (strArray[i].contains(",")) {
							// the pattern of the splitting is
							// TableName1,column1,Prefix1,Sequence1;TableName2,column2,Prefix2,Sequence2;
							String strSequenceArray[] = strArray[i].split(",");
							if (strSequenceArray != null && strSequenceArray.length > 0) {
								Map<String, String> map = new HashMap<String, String>();
								Map<String, Map<String, String>> mapColumnWise = new HashMap<String, Map<String, String>>();
								map.put(strSequenceArray[2], strSequenceArray[3]);
								mapColumnWise.put(strSequenceArray[1], map);
								mapTableWithSequence.put(strSequenceArray[0], mapColumnWise);
							}
						}
					}
				}
			}
			Map<String, Vector<String>> tmpDependsColumns = generateQueriesAndDumping(
					jdbcTemplate,
					listR,
					mapOnetoOnerelation,
					mapConditionsPassed,
					listResultVal,
					testDataGenenarteDTO.getGenerateRecordsCount(),
					listTabNames,
					listMasterTabs,
					mapTableWithSequence,
					listColumnNames,
					mapInputDepends,
					mapReverseDependents,
					testDataGenenarteDTO.getMapDictionaryVals(),
					testDataGenenarteDTO.isDataConditional(),
					testDataGenenarteDTO.isDataConditional() ? testDataGenenarteDTO
							.getDataConditionalTabNames() : null, testDataGenenarteDTO);
			if (!mapDependsColumns.containsKey(TdgCentralConstant.FAILED_MESSAGE)) {
				mapDependsColumns.putAll(tmpDependsColumns);
			} else {
				Vector<String> vctVals = new Vector<String>();
				mapDependsColumns.put(strSuccess, vctVals);
			}
		} catch (SQLException e) {
			Vector<String> vctVals = new Vector<String>();
			mapDependsColumns.put(TdgCentralConstant.FAILED_MESSAGE, vctVals);
			strStatusDescription = new StringBuffer();
			strStatusDescription.append(e.getErrorCode()).append(" :: ").append(e.getSQLState()).append(" ==> ").append(e.getMessage().substring(0, e.getMessage().length() > 99 ?  100 : e.getMessage().length()));
			logger.error(strClassName + strMethodName
					+ " error occured while dumping the data into server is Sql Exception ::  ", e);
		}catch(StackOverflowError se){
			Vector<String> vctVals = new Vector<String>();
			mapDependsColumns.put(TdgCentralConstant.FAILED_MESSAGE, vctVals);
			strStatusDescription = new StringBuffer();
			strStatusDescription.append(" Caused by ==> ").append(se.getMessage().substring(0, se.getMessage().length() > 99 ?  100 : se.getMessage().length()));
			logger.error(strClassName + strMethodName
					+ " error occured while dumping the data into server  ", se);
		} catch (Exception e2) {
			Vector<String> vctVals = new Vector<String>();
			strStatusDescription = new StringBuffer();
			strStatusDescription.append(" Caused by ==> ").append(e2 != null ? e2.getMessage().substring(0, e2.getMessage().length() > 99 ?  100 : e2.getMessage().length()) : "Passed values not sufficient...");
			mapDependsColumns.put(TdgCentralConstant.FAILED_MESSAGE, vctVals);
			logger.error(strClassName + strMethodName
					+ " error occured while dumping the data into server  ", e2);
		}
		logger.info(strClassName + strMethodName + " return from generateTestData method");
		return mapDependsColumns;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Vector<String>> generateQueriesAndDumping(JdbcTemplate jdbcTemplate,
			List<List<List<Object>>> listResultTabs, List<String> listRelations,
			Map<String, Object> mapConditions, List<List<Object>> listResultVal,
			long iRequiredRecordCount, List<String> lstTabsNames, List<String> listMasterTabs,
			Map<String, Map<String, Map<String, String>>> mapTableWithSequence,
			List<String> listConditionColNames, Map<String, Vector<String>> mapInputDepends,
			Map<String, String> mapReverseDependents,
			Map<String, List<String>> mapDataDictionaryVals, boolean isDataConditional,
			List<String> listDataDictionaryTabNames, TestDataGenerateDTO testDataGenenarteDTO)
			throws SQLException{
		String strMethodName = " [ generateQueriesAndDumping() ] ";
		logger.info(strClassName + strMethodName + " inside generateQueriesAndDumping method");
		String strMessage = TdgCentralConstant.SUCCESS_MESSAGE;
		Map<String, String> mapTables = new HashMap<String, String>();
		Map<String, Map<String, String>> mapPkWithTables = new HashMap<String, Map<String, String>>();
		Map<String, Map<String, String>> mapUkWithTables = new HashMap<String, Map<String, String>>();
		Map<String, Map<String, String>> mapFkWithTables = new HashMap<String, Map<String, String>>();
		Map<String, Map<String, String>> mapNNKWithTables = new HashMap<String, Map<String, String>>();
		Map<String, Map<String, String>> mapFetchPkWithTables = new HashMap<String, Map<String, String>>();
		Map<String, Map<Integer, String>> hmapValues = new HashMap<String, Map<Integer, String>>();
		Map<String, String> mapTableWithPk = new HashMap<String, String>();
		Map<String, Vector<String>> mapPks = new HashMap<String, Vector<String>>();
		Map<String, Vector<String>> mapDepends = new HashMap<String, Vector<String>>();
		Map<String, String> mapConditionWithPKs = new HashMap<String, String>();
		
		//Following parameter is used to arrange columns in sequence which given from datadictionary
		List<String> lstSequenceColsAndRequired = testDataGenenarteDTO.getRequiredSequenceColumns();
		//end
		
		boolean isBreaked = false;
		
		//check excel and csv file generation
		/*boolean isCSV_OR_EXCEL = false;
		if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_XLS.equals(testDataGenenarteDTO.getGenerationType()) || TdgCentralConstant.SCHEMA_GENERATION_TYPE_XLS.equals(testDataGenenarteDTO.getGenerationType()))
			isCSV_OR_EXCEL = true;*/
		int iIteratorCount = 0;
		if (logger.isDebugEnabled())
			logger.debug(strClassName + strMethodName + " total table to dump the data is :: "
					+ listResultTabs);
		if (listResultTabs == null || listResultTabs.isEmpty()) {
			strMessage = TdgCentralConstant.FAILED_MESSAGE;
			Vector<String> vctVals = new Vector<String>();
			mapDepends.put(strMessage, vctVals);
		}
		if (testDataGenenarteDTO != null && testDataGenenarteDTO.getGUIDictionaryColumns() != null
				&& !testDataGenenarteDTO.getGUIDictionaryColumns().isEmpty()) {
			for (String strColName : testDataGenenarteDTO.getGUIDictionaryColumns()) {
				if (!mapConditionValues.containsKey(strColName)) {
					List<String> lstValues = new ArrayList<String>();
					mapConditionValues.put(strColName, lstValues);
				}
			}
		}
		//for condition check of not empty passed tables from dictionary
		boolean isConditiontableExist = false;
		for (List<List<Object>> listResultTables : listResultTabs) {
			for (List<Object> listChildTabs : listResultTables) {
				
				for (Object obj : listChildTabs) {
					isBreaked = false;
					int i = 0;
					Map<Integer, String> mapPositions = new HashMap<Integer, String>();
					List<String> listUkCheck = new ArrayList<String>();
					String strTableName = String.valueOf(obj)
							.substring(0, String.valueOf(obj).indexOf("#")).toUpperCase();
					if (logger.isDebugEnabled())
						logger.debug(strClassName + strMethodName + " current table is  :: "
								+ strTableName);
					/**
					 * Break the loop if data conditional dictionary not contains the table name
					 */
					if (isDataConditional && !listDataDictionaryTabNames.contains(strTableName)) {
						isBreaked = true;
					}
					/**
					 * Need to check for master table names for escape the insert values
					 * 18/9/2015 added passed tables filter
					 */
					if( testDataGenenarteDTO.getDataConditionalTabNames() == null && !mapPks.containsKey(strTableName)){
						isConditiontableExist = true;
						List<String> listTemp = new ArrayList<String>();
						listTemp.add(strTableName);
						testDataGenenarteDTO.setDataConditionalTabNames(listTemp);
					}
					if(isConditiontableExist){
						List<String> listTemp = testDataGenenarteDTO.getDataConditionalTabNames();
						listTemp.add(strTableName);
						testDataGenenarteDTO.setDataConditionalTabNames(listTemp);
					}
					if (!mapPks.containsKey(strTableName) && !listMasterTabs.contains(strTableName)
							&& !isBreaked && testDataGenenarteDTO.getDataConditionalTabNames().contains(strTableName) && !mapTables.containsKey(strTableName)) {
						StringBuffer strInsertQuery = new StringBuffer("INSERT INTO "
								+ strTableName + "(");
						List<Map<String, Object>> listValues = getConstraintsOfTable(jdbcTemplate,
								strTableName);
						List<Map<String, Object>> listPKValues = new ArrayList<Map<String, Object>>();
						List<Map<String, Object>> listUKValues = new ArrayList<Map<String, Object>>();
						List<Map<String, Object>> listNNKValues = new ArrayList<Map<String, Object>>();
						List<Map<String, Object>> listFKValues = new ArrayList<Map<String, Object>>();
						for (Map<String, Object> mapResult : listValues) {
							String strPkContraintName = String.valueOf(mapResult
									.get("CONSTRAINT_NAME"));
							if ("P".equals(mapResult.get("CONSTRAINT_TYPE"))) {
								listPKValues.addAll(getPkColumnType(jdbcTemplate,
										strPkContraintName, strTableName));
								/**
								 * This map is used to composite primary key values
								 */
							} else if ("U".equals(mapResult.get("CONSTRAINT_TYPE"))) {
								listUKValues.addAll(getPkColumnType(jdbcTemplate,
										strPkContraintName, strTableName));
							} else if ("R".equals(mapResult.get("CONSTRAINT_TYPE"))) {
								listFKValues.addAll(getPkColumnType(jdbcTemplate,
										strPkContraintName, strTableName));
							} else if ("C".equals(mapResult.get("CONSTRAINT_TYPE"))) {
								listNNKValues.addAll(getPkColumnType(jdbcTemplate,
										strPkContraintName, strTableName));
							}
						}
						// Going for getting not null constraints apart for
						// mysql support
						List<Map<String, Object>> listNNValues = getNotNullConstraintsOfTable(
								jdbcTemplate, strTableName);
						if (listNNValues != null && !listNNValues.isEmpty()) {
							List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
							for (Map<String, Object> mapResult : listNNValues) {
								if (TdgCentralConstant.IS_NULLABLE.equals(mapResult
										.get("IS_NULLABLE"))) {
									listMap.add(mapResult);
								}
							}
							if (!listMap.isEmpty())
								listNNKValues.addAll(listMap);
						}
						
						/**
						 * Going for getting the Primary key values
						 */
						boolean bDuplicateCheck = false;
						for (Map<String, Object> mapResult : listPKValues) {
							// if (!mapConditions.isEmpty()) {
							// listUkCheck.add(String.valueOf(mapResult.get("COLUMN_NAME")));
							if (!listUkCheck.contains(String.valueOf(mapResult.get("COLUMN_NAME")))) {
								listUkCheck.add(String.valueOf(mapResult.get("COLUMN_NAME")));
								
								//added for sequence
								if(lstSequenceColsAndRequired != null && !lstSequenceColsAndRequired.isEmpty()){
									if(lstSequenceColsAndRequired.contains(String.valueOf(mapResult.get("COLUMN_NAME")))){
								    mapPositions.put(++i, String.valueOf(mapResult.get("COLUMN_NAME")));
								  strInsertQuery.append(' ')
									.append(String.valueOf(mapResult.get("COLUMN_NAME")))
									.append(' ');
									}
								}else{
									mapPositions.put(++i, String.valueOf(mapResult.get("COLUMN_NAME")));
									strInsertQuery.append(' ')
									.append(String.valueOf(mapResult.get("COLUMN_NAME")))
									.append(' ');
								}
								/**
								 * Check is table contains primary key or not
								 */
								if (String.valueOf(mapResult.get("COLUMN_NAME")) != null
										&& "".equals(String.valueOf(mapResult.get("COLUMN_NAME")))) {
									--i;
								}
								mapTableWithPk.put(
										strTableName,
										String.valueOf(mapResult.get("DATA_TYPE")) + "#"
												+ String.valueOf(mapResult.get("DATA_LENGTH")));
								if (i != listPKValues.size()) {
									strInsertQuery.append(" , ");
								}
								if (i > 0) {
									mapConditionWithPKs.put(strTableName,
											String.valueOf(mapResult.get("COLUMN_NAME")));
								}
							} else {
								bDuplicateCheck = true;
							}
						}
						if (bDuplicateCheck) {
							String strValue = strInsertQuery.toString().substring(0,
									strInsertQuery.toString().lastIndexOf(','));
							strInsertQuery = new StringBuffer(strValue);
						}
						/**
						 * Added for composite primary key values
						 */
						Map<String, String> mapUkValues = new HashMap<String, String>();
						int iRecurseCount = 0;
						for (Map<String, Object> mapResult : listPKValues) {
							if (!listUkCheck.contains((mapResult.get("COLUMN_NAME")))
									&& listPKValues.size() > 1 && iRecurseCount > 0) {
								mapUkValues.put(
										String.valueOf(mapResult.get("COLUMN_NAME")),
										String.valueOf(mapResult.get("DATA_TYPE")) + "#"
												+ String.valueOf(mapResult.get("DATA_LENGTH")));
							}
							iRecurseCount++;
						}
						/**
						 * Going for getting the foreign key values
						 */
						Map<String, String> mapFkValues = new HashMap<String, String>();
						for (Map<String, Object> mapResult : listFKValues) {
							mapFkValues.put(
									String.valueOf(mapResult.get("COLUMN_NAME")),
									String.valueOf(mapResult.get("DATA_TYPE")) + "#"
											+ String.valueOf(mapResult.get("DATA_LENGTH")));
							listUkCheck.add(String.valueOf(mapResult.get("COLUMN_NAME")));
							
							//added for sequence
							if(lstSequenceColsAndRequired != null && !lstSequenceColsAndRequired.isEmpty()){
								if(lstSequenceColsAndRequired.contains(String.valueOf(mapResult.get("COLUMN_NAME")))){
							  mapPositions.put(++i, String.valueOf(mapResult.get("COLUMN_NAME")));
							  if (i > 0) {
									strInsertQuery.append(" , ");
								}
								strInsertQuery.append(' ')
										.append(String.valueOf(mapResult.get("COLUMN_NAME")))
										.append(' ');
								}
							}else{
								mapPositions.put(++i, String.valueOf(mapResult.get("COLUMN_NAME")));
								if (i > 0) {
									strInsertQuery.append(" , ");
								}
								strInsertQuery.append(' ')
										.append(String.valueOf(mapResult.get("COLUMN_NAME")))
										.append(' ');
							}
							//mapPositions.put(++i, String.valueOf(mapResult.get("COLUMN_NAME")));
						}
						/**
						 * Going for getting the unique key values
						 */
						for (Map<String, Object> mapResult : listUKValues) {
							if (!listUkCheck.contains((mapResult.get("COLUMN_NAME")))) {
								mapUkValues.put(
										String.valueOf(mapResult.get("COLUMN_NAME")),
										String.valueOf(mapResult.get("DATA_TYPE")) + "#"
												+ String.valueOf(mapResult.get("DATA_LENGTH")));
								listUkCheck.add(String.valueOf(mapResult.get("COLUMN_NAME")));
								
								//added for sequence
								if(lstSequenceColsAndRequired != null && !lstSequenceColsAndRequired.isEmpty()){
									if(lstSequenceColsAndRequired.contains(String.valueOf(mapResult.get("COLUMN_NAME")))){
								  mapPositions.put(++i, String.valueOf(mapResult.get("COLUMN_NAME")));
								  if (i > 0) {
										strInsertQuery.append(" , ");
									}
									strInsertQuery.append(' ')
											.append(String.valueOf(mapResult.get("COLUMN_NAME")))
											.append(' ');
									}
								}else{
									mapPositions.put(++i, String.valueOf(mapResult.get("COLUMN_NAME")));
									if (i > 0) {
										strInsertQuery.append(" , ");
									}
									strInsertQuery.append(' ')
											.append(String.valueOf(mapResult.get("COLUMN_NAME")))
											.append(' ');
								}
								//mapPositions.put(++i, String.valueOf(mapResult.get("COLUMN_NAME")));
							}
						}
						/**
						 * Going for getting the Not null key values
						 */
						Map<String, String> mapNNkValues = new HashMap<String, String>();
						for (Map<String, Object> mapResult : listNNKValues) {
							if (!mapConditions.containsKey(mapResult.get("COLUMN_NAME"))
									&& !listUkCheck.contains((mapResult.get("COLUMN_NAME")))) {
								mapNNkValues.put(
										String.valueOf(mapResult.get("COLUMN_NAME")),
										String.valueOf(mapResult.get("DATA_TYPE")).contains(
												"TIMESTAMP")
												|| String.valueOf(mapResult.get("DATA_TYPE"))
														.contains("DATE") ? "DATE" : String
												.valueOf(mapResult.get("DATA_TYPE"))
												+ "#"
												+ String.valueOf(mapResult.get("DATA_LENGTH")));
								listUkCheck.add(String.valueOf(mapResult.get("COLUMN_NAME")));
								
								//added for sequence
								if(lstSequenceColsAndRequired != null && !lstSequenceColsAndRequired.isEmpty()){
									if(lstSequenceColsAndRequired.contains(String.valueOf(mapResult.get("COLUMN_NAME")))){
								  mapPositions.put(++i, String.valueOf(mapResult.get("COLUMN_NAME")));
								  if (i > 0) {
										strInsertQuery.append(" , ");
									}
									strInsertQuery.append(' ')
											.append(String.valueOf(mapResult.get("COLUMN_NAME")))
											.append(' ');
									}
								}else{
									mapPositions.put(++i, String.valueOf(mapResult.get("COLUMN_NAME")));
									if (i > 0) {
										strInsertQuery.append(" , ");
									}
									strInsertQuery.append(' ')
											.append(String.valueOf(mapResult.get("COLUMN_NAME")))
											.append(' ');
								}
								//mapPositions.put(++i, String.valueOf(mapResult.get("COLUMN_NAME")));
							}
						}
						/**
						 * Going for adding the condition query values
						 */
						List<Map<String, Object>> mapColumnsOfTab = getSequenceColsByTableName(
								jdbcTemplate, strTableName, null);
						/* 1.Check the input values which is passed from GUI level */
						if (mapConditions != null && !mapConditions.isEmpty()) {
							for (Map<String, Object> mapValues : mapColumnsOfTab) {
								for (Map.Entry<String, Object> mapEntryVals : mapConditions
										.entrySet()) {
									if (!mapConditionValues.containsKey(mapEntryVals.getKey())) {
										List<String> lstValues = new ArrayList<String>();
										mapConditionValues.put(mapEntryVals.getKey(), lstValues);
									}
									if (!listUkCheck.contains(mapValues.get("COLUMN_NAME")
											.toString().toUpperCase())) {
										if (mapValues.get("COLUMN_NAME").toString().toUpperCase()
												.equals(mapEntryVals.getKey())) {
											listUkCheck.add(String.valueOf(mapValues
													.get("COLUMN_NAME").toString().toUpperCase()));
											/**
											 * going for check date formate
											 */
											if (String.valueOf(mapValues.get("DATA_TYPE"))
													.contains("TIMESTAMP")
													|| String.valueOf(mapValues.get("DATA_TYPE"))
															.contains("DATE")) {
												try {
													DateFormat dateFormat = new SimpleDateFormat(
															"d/M/yy");
													Date date = dateFormat.parse(mapEntryVals
															.getValue() + "");
													dateFormat = new SimpleDateFormat(
															testDataGenenarteDTO.getDateFormate());
													String strDate = dateFormat.format(date) + "";
													mapEntryVals.setValue(strDate);
												} catch (ParseException pe) {
													/*mapEntryVals.setValue(new SimpleDateFormat(testDataGenenarteDTO.getDateFormate()).format(mapEntryVals
															.getValue() + ""));*/
													logger.info(strClassName + strMethodName
															+ " Date formate issue was raised...");
												}
											}
											
											//added for sequence
											if(lstSequenceColsAndRequired != null && !lstSequenceColsAndRequired.isEmpty()){
												if(lstSequenceColsAndRequired.contains(String.valueOf(mapValues.get("COLUMN_NAME")))){
											  
											  if (i > 0) {
													strInsertQuery.append(" , ");
												}
												strInsertQuery
														.append(' ')
														.append(String.valueOf(mapValues
																.get("COLUMN_NAME"))).append(' ');
												}												
											}else{
												if (i > 0) {
													strInsertQuery.append(" , ");
												}
												strInsertQuery
														.append(' ')
														.append(String.valueOf(mapValues
																.get("COLUMN_NAME"))).append(' ');
											}
											mapPositions.put(++i, String.valueOf(mapValues.get("COLUMN_NAME")));
											//mapPositions.put(++i,
													//String.valueOf(mapValues.get("COLUMN_NAME")));
										}
									}
								}
							}
						}
						/* 2. Check for dictionary contains columns which is being related table
						 * then add also */
						if (!mapDataDictionaryVals.isEmpty()) {
							for (Map<String, Object> mapValues : mapColumnsOfTab) {
								for (Map.Entry<String, List<String>> mapEntryVals : mapDataDictionaryVals
										.entrySet()) {
									if (!listUkCheck.contains(mapValues.get("COLUMN_NAME")
											.toString().toUpperCase())) {
										if (mapValues.get("COLUMN_NAME").toString().toUpperCase()
												.equals(mapEntryVals.getKey())) {
											
											//added for sequence
											if(lstSequenceColsAndRequired != null && !lstSequenceColsAndRequired.isEmpty()){
												if(lstSequenceColsAndRequired.contains(String.valueOf(mapValues.get("COLUMN_NAME")))){
											  mapPositions.put(++i, String.valueOf(mapValues.get("COLUMN_NAME")));
											  if (i > 0) {
													strInsertQuery.append(" , ");
												}
												strInsertQuery
														.append(' ')
														.append(String.valueOf(mapValues
																.get("COLUMN_NAME"))).append(' ');
												}
											}else{
												mapPositions.put(++i, String.valueOf(mapValues.get("COLUMN_NAME")));
												if (i > 0) {
													strInsertQuery.append(" , ");
												}
												strInsertQuery
														.append(' ')
														.append(String.valueOf(mapValues
																.get("COLUMN_NAME"))).append(' ');
											}
											/*mapPositions.put(++i,
													String.valueOf(mapValues.get("COLUMN_NAME")));*/
										}
									}
								}
							}
						}
						/**
						 * Added for multiple databases inject of the columns based on
						 * dictionary details
						 */
						for (String strColunmName : listConditionColNames) {
							if (!strInsertQuery.toString().contains(" " + strColunmName + " ")
									&& !listUkCheck.contains(strColunmName)) {
								for (Map<String, Object> mapValues : mapColumnsOfTab) {
									if (mapValues.get("COLUMN_NAME").toString().toUpperCase()
											.equals(strColunmName)) {
										
										mapNNkValues.put(
												String.valueOf(mapValues.get("COLUMN_NAME")),
												String.valueOf(mapValues.get("DATA_TYPE"))
														.contains("TIMESTAMP")
														|| String.valueOf(
																mapValues.get("DATA_TYPE"))
																.contains("DATE") ? "DATE" : String
														.valueOf(mapValues.get("DATA_TYPE"))
														+ "#"
														+ String.valueOf(mapValues
																.get("DATA_LENGTH")));
										listUkCheck
												.add(String.valueOf(mapValues.get("COLUMN_NAME")));
										
										//added for sequence
										if(lstSequenceColsAndRequired != null && !lstSequenceColsAndRequired.isEmpty()){
											if(lstSequenceColsAndRequired.contains(String.valueOf(mapValues.get("COLUMN_NAME")))){
										  mapPositions.put(++i, String.valueOf(mapValues.get("COLUMN_NAME")));
										  if (i > 0) {
												strInsertQuery.append(" , ");
											}
											strInsertQuery
													.append(' ')
													.append(String.valueOf(mapValues.get("COLUMN_NAME")))
													.append(' ');
											}
										}else{
											mapPositions.put(++i, String.valueOf(mapValues.get("COLUMN_NAME")));
											if (i > 0) {
												strInsertQuery.append(" , ");
											}
											strInsertQuery
													.append(' ')
													.append(String.valueOf(mapValues.get("COLUMN_NAME")))
													.append(' ');
										}
										/*mapPositions.put(++i,
												String.valueOf(mapValues.get("COLUMN_NAME")));*/
									}
								}
							}
						}
						if (strInsertQuery.toString().endsWith(" , ")) {
							String strVal = strInsertQuery.toString();
							strInsertQuery = new StringBuffer(strInsertQuery.toString().substring(
									0, strVal.lastIndexOf(" , "))).append(' ');
						}
						strInsertQuery.append(") VALUES (");
						for (int j = 1; j <= mapPositions.size(); j++) {
							strInsertQuery.append('?');
							if (j != mapPositions.size()) {
								strInsertQuery.append(',');
							} else if (j == mapPositions.size()) {
								strInsertQuery.append(')');
							}
						}
						mapTables.put(strTableName, strInsertQuery.toString());
						mapPkWithTables.put(strTableName, mapTableWithPk);
						mapUkWithTables.put(strTableName, mapUkValues);
						mapFkWithTables.put(strTableName, mapFkValues);
						mapNNKWithTables.put(strTableName, mapNNkValues);
						hmapValues.put(strTableName, mapPositions);
						if (strInsertQuery.toString().contains("(?)")) {
							Map<String, String> mapDummyVal = new HashMap<String, String>();
							List<Map<String, Object>> listString = getSequenceColsByTableName(
									jdbcTemplate,
									strTableName,
									strInsertQuery.substring(strInsertQuery.indexOf("(") + 1,
											strInsertQuery.indexOf(")")).trim());
							for (Map<String, Object> map : listString) {
								mapDummyVal.put(
										String.valueOf(map.get("COLUMN_NAME")),
										String.valueOf(map.get("DATA_TYPE")).contains("TIMESTAMP")
												|| String.valueOf(map.get("DATA_TYPE")).contains(
														"DATE") ? "DATE" : String.valueOf(map
												.get("DATA_TYPE"))
												+ "#"
												+ String.valueOf(map.get("DATA_LENGTH")));
								if (!map.isEmpty()) {
									String columnName = String.valueOf(map.get("COLUMN_NAME"));
									if (columnName != null) {
										StringBuffer strBuffer = new StringBuffer(
												strInsertQuery.substring(0,
														strInsertQuery.indexOf("(")));
										StringBuffer strSubQueryInsert = new StringBuffer(
												strInsertQuery.substring(
														strInsertQuery.indexOf("("),
														strInsertQuery.indexOf(")")));
										strSubQueryInsert.append(' ').append(" , ")
												.append(columnName).append(") ");
										strBuffer
												.append(strSubQueryInsert)
												.append(strInsertQuery.substring(
														strInsertQuery.indexOf(" VALUES ("),
														strInsertQuery.length() - 1).replaceAll(
														"\\?", "?,?")).append(')');
										strInsertQuery = new StringBuffer(strBuffer);
										mapPositions = hmapValues.get(strTableName);
										mapPositions.put(2, String.valueOf(map.get("COLUMN_NAME")));
										mapTables.put(strTableName, strInsertQuery.toString());
										break;
									}
								}
							}
							mapFetchPkWithTables.put(strTableName, mapDummyVal);
						}
						hmapValues.put(strTableName, mapPositions);
						if (logger.isDebugEnabled()) {
							logger.debug(strClassName + strMethodName + " generated query is  :: "
									+ strInsertQuery.toString());
						}
						
						
					}
				}
			}
			if (!isBreaked) {
				int iHashValue = getHighestHashValue(listResultVal.get(iIteratorCount));
				if (iHashValue <= 0) {
					strMessage = TdgCentralConstant.FAILED_MESSAGE;
				}
				List<String> listColumnsName = new ArrayList<String>();
				if (mapConditions != null) {
					for (String strKey : mapConditions.keySet()) {
						if (!strKey.contains("DEPENDS_ON"))
							listColumnsName.add(strKey);
					}
				}
				List<Map<String, Object>> listColumnsNameWthTable = getTableNamesByColsName(
						jdbcTemplate, listColumnsName);
				/**
				 * Going for making transaction
				 */
				logger.info(strClassName + strMethodName
						+ " going to insert the data into server in sequence.....");
				for (int i = iHashValue; i >= 1; i--) {
					Set<String> listFinalSequence = getTableNameInsert(
							listResultVal.get(iIteratorCount), i);
					
					for (String tbName : listFinalSequence) {
						//added below if condition to filter the passed tables
						if(listFinalSequence != null && testDataGenenarteDTO.getDataConditionalTabNames().contains(tbName)){
						boolean bUniqCheck = false;
						boolean bDataConditional = false;
						/**
						 * Need to check for master table names for escape the insert values
						 */
						if (listDataDictionaryTabNames != null
								&& !listDataDictionaryTabNames.contains(tbName)
								&& isDataConditional) {
							bDataConditional = true;
						}
						if (!mapPks.containsKey(tbName) && !listMasterTabs.contains(tbName)
								&& !bDataConditional) {
							Map<Integer, String> mapPositions = hmapValues.get(tbName);
							Map<String, String> mapPkNames = mapPkWithTables.get(tbName);
							Map<String, String> mapUkNames = mapUkWithTables.get(tbName);
							Map<String, String> mapNNkNames = mapNNKWithTables.get(tbName);
							Map<String, String> mapDummyNames = mapFetchPkWithTables.get(tbName);
							Map<String, String> mapFkNames = mapFkWithTables.get(tbName);
							Map<String, String> mpFkValues = new HashMap<String, String>();
							Map<String, String> mpTabConditions = new HashMap<String, String>();
							if (listColumnsNameWthTable != null
									&& !listColumnsNameWthTable.isEmpty()) {
								for (Map<String, Object> mapResult : listColumnsNameWthTable) {
									if (tbName.equals(mapResult.get("TABLE_NAME"))) {
										if(mapConditions
												.get(mapResult.get("COLUMN_NAME")) instanceof List){
											StringBuffer strBuffer = new StringBuffer();
											int iCount = 0;
											List<Object> lst = (List<Object>)mapConditions.get(mapResult.get("COLUMN_NAME"));
											for(Object obj: lst){
												iCount++;
												if(obj != null && !"".equalsIgnoreCase(obj+""))
												strBuffer.append(obj);
												if(iCount != lst.size()){
													strBuffer.append("#");
												}
											}
											mpTabConditions.put(String.valueOf(mapResult
													.get("COLUMN_NAME")), strBuffer.toString());
										}else{
										mpTabConditions.put(String.valueOf(mapResult
												.get("COLUMN_NAME")), (String) mapConditions
												.get(mapResult.get("COLUMN_NAME")));
										}
									}
								}
							}
							/**
							 * going for get foreign key column table
							 */
							if (mapFkNames != null && !mapFkNames.isEmpty()) {
								mpFkValues = getTableNameByFkName(jdbcTemplate, tbName, mapFkNames);
							}
							Vector<String> vct = new Vector<String>();
							if (!mapPkNames.isEmpty()) {
								vct.add(mapPositions.get(1));
								vct.add(tbName);
							}
							Map<String, List<String>> mpUkValues = new HashMap<String, List<String>>();
							Map<String, List<String>> mpNNkValues = new HashMap<String, List<String>>();
							Map<String, String> mpDummyValues = new HashMap<String, String>();
							Entry<String, String> entryPks = null;
							if (mapPkNames != null && !mapPkNames.isEmpty()) {
								entryPks = mapPkNames.entrySet().iterator().next();
							}
							/**
							 * Going for batch operations
							 */
							String strQuery = mapTables.get(tbName);
							long lRecordsCount = iRequiredRecordCount;
							if (lstTabsNames.contains(tbName)) {
								lRecordsCount = iRequiredRecordCount;
							} else {
								for (String strValue : listRelations) {
									String strTabName = strValue
											.substring(0, strValue.indexOf("#"));
									if (strTabName.equals(tbName)) {
										bUniqCheck = true;
										break;
									}
								}
								if (!bUniqCheck) {
									lRecordsCount = 1;
								}
							}
							
							/**
							 * Going to generate values based on constraint types which TDG Engine rectifiers
							 */
							GenerateRandom generateRandom = null;
							if (mapUkNames != null && !mapUkNames.isEmpty()) {
								for (Map.Entry<String, String> mapEntry : mapUkNames.entrySet()) {
									String strValue = mapEntry.getValue();
									String strKey = mapEntry.getKey();
									List<String> listGenValues = new ArrayList<String>();
									if ("DATE".equals(strValue) || "TIMESTAMP".equals(strValue)) {
										DateFormat dateFormat = new SimpleDateFormat(
												StringUtils.isEmpty(testDataGenenarteDTO
														.getDateFormate()) ? "dd/MMM/yyyy hh:mm:ss"
														: testDataGenenarteDTO.getDateFormate());
										Date date = new Date();
										String strDate = dateFormat.format(date) + "";
										for (int ii = 1; ii <= iRequiredRecordCount; ii++) {
											listGenValues.add(strDate);
										}
									} else if (mapDataDictionaryVals.containsKey(mapEntry.getKey())) {
										if (isDataConditional) {
											listGenValues.addAll(mapDataDictionaryVals.get(mapEntry
													.getKey()));
										} else {
											List<String> lstValues = new ArrayList<String>();
											if (mapConditions != null
													&& mapConditions.containsKey(mapEntry.getKey())) {
												lstValues.add(mapConditions.get(mapEntry.getKey())
														+ "");
											} else {
												lstValues.addAll(mapDataDictionaryVals.get(mapEntry
														.getKey()));
											}
											//bifurcate the request based on sequence on random
											if(testDataGenenarteDTO.isSequenceOrder()){
											listGenValues.addAll(getSequenceValueFromList(lstValues,
													Integer.parseInt(strValue.substring(strValue
															.indexOf("#") + 1)),
													iRequiredRecordCount,false));
											}else{
												listGenValues.addAll(getRandomValueFromList(lstValues,
														Integer.parseInt(strValue.substring(strValue
																.indexOf("#") + 1)),
														iRequiredRecordCount,false));
											}
										}
									} else {
										Map<String, Map<String, String>> mapResult = mapTableWithSequence
												.get(tbName);
										if (mapUkNames != null && mapResult != null
												&& mapResult.containsKey(strKey)) {
											Map<String, String> mapSequences = mapResult
													.get(strKey);
											Map<String, Map<String, String>> mapRes = new HashMap<String, Map<String, String>>();
											mapRes.put(tbName, mapSequences);
											listGenValues.addAll(generatePkValues(jdbcTemplate,
													null, mapRes, lRecordsCount, tbName));
										} else {
											generateRandom = new GenerateRandom(strValue.substring(
													0, strValue.indexOf("#")),
													Integer.parseInt(strValue.substring(strValue
															.indexOf("#") + 1)),
													iRequiredRecordCount);
											listGenValues = generateRandom.generateRandomString();
										}
									}
									mpUkValues.put(mapEntry.getKey(), listGenValues);
									if (logger.isDebugEnabled())
										logger.debug(strClassName + strMethodName
												+ "generated unique constraint values :: "
												+ listGenValues);
								}
							}
							if (mapNNkNames != null && !mapNNkNames.isEmpty()) {
								int iSequnceCount = 0;
								for (Map.Entry<String, String> mapEntry : mapNNkNames.entrySet()) {
									String strValue = mapEntry.getValue();
									String strKey = mapEntry.getKey();
									List<String> listGenValues = new ArrayList<String>();
									if ("DATE".equals(strValue) || "TIMESTAMP".equals(strValue)) {
										DateFormat dateFormat = new SimpleDateFormat(
												StringUtils.isEmpty(testDataGenenarteDTO
														.getDateFormate()) ? "dd/MMM/yyyy hh:mm:ss"
														: testDataGenenarteDTO.getDateFormate());
										Date date = new Date();
										String strDate = dateFormat.format(date) + "";
										//Not null constraint not required generate the all values
										/*for (int ii = 1; ii <= iRequiredRecordCount; ii++) {
											listGenValues.add(strDate);
										}*/								
										listGenValues.add(strDate);
									} else if (mapDataDictionaryVals.containsKey(mapEntry.getKey())) {
										if (isDataConditional) {
											listGenValues.addAll(mapDataDictionaryVals.get(mapEntry
													.getKey()));
										} else {
											List<String> lstValues = new ArrayList<String>();
											if (mapConditions != null
													&& mapConditions.containsKey(mapEntry.getKey())) {
												/**
												 * Going to fetch random values from dictionary
												 */
												if(mapConditions.get(mapEntry.getKey()) instanceof List){
													List<Object> lst = (List<Object>) mapConditions.get(mapEntry.getKey());
													//bifurcate the request based on sequence on random
													if(testDataGenenarteDTO.isSequenceOrder()){
														if(lstSequence.isEmpty()){
															lstValues.add(lst.get(iSequnceCount)+"");
															iSequnceCount++;
														}else{
															int iIndex = (int)(Math.random() * lst.size());
															lstSequence.add(iIndex);
															lstValues.add(lst.get(iIndex)+"");
														}
													}else{
														lstValues.add(lst.get((int)(Math.random() * lst.size()))
																+ "");
													}
													
												}else{
													lstValues.add(mapConditions.get(mapEntry.getKey())
															+ "");
												}
												
											} else {
												lstValues.addAll(mapDataDictionaryVals.get(mapEntry
														.getKey()));
											}
											
											listGenValues.addAll(lstValues);
											//bifurcate the request based on sequence on random
											/*if(testDataGenenarteDTO.isSequenceOrder()){
											listGenValues.addAll(getSequenceValueFromList(lstValues,
													Integer.parseInt(strValue.substring(strValue
															.indexOf("#") + 1)),
													iRequiredRecordCount,false));
											}else{
												listGenValues.addAll(getRandomValueFromList(lstValues,
														Integer.parseInt(strValue.substring(strValue
																.indexOf("#") + 1)),
														iRequiredRecordCount,false));
											}*/
										}
									} else {
										Map<String, Map<String, String>> mapResult = mapTableWithSequence
												.get(tbName);
										if (mapUkNames != null && mapResult != null
												&& mapResult.containsKey(strKey)) {
											Map<String, String> mapSequences = mapResult
													.get(strKey);
											Map<String, Map<String, String>> mapRes = new HashMap<String, Map<String, String>>();
											mapRes.put(tbName, mapSequences);
											/*listGenValues.addAll(generatePkValues(jdbcTemplate,
													null, mapRes, lRecordsCount, tbName));*/
											listGenValues.addAll(generatePkValues(jdbcTemplate,
													null, mapRes, 1, tbName));
										} else {
											/*generateRandom = new GenerateRandom(strValue.substring(
													0, strValue.indexOf("#")),
													Integer.parseInt(strValue.substring(strValue
															.indexOf("#") + 1) != null && !"null".equals(strValue.substring(strValue
															.indexOf("#") + 1)) ? strValue.substring(strValue
																	.indexOf("#") + 1) : "20"),
													iRequiredRecordCount);
											listGenValues = generateRandom.generateRandomString();*/
											listGenValues.add(TdgCentralConstant.TDG_NOT_NULL_CONSTRAINT);
										}
									}
									mpNNkValues.put(mapEntry.getKey(), listGenValues);
									if (logger.isDebugEnabled())
										logger.debug(strClassName + strMethodName
												+ "generated unique constraint values :: "
												+ listGenValues);									
								}
								
							}
							if (mapDummyNames != null && !mapDummyNames.isEmpty()) {
								Entry<String, String> entryVals = mapDummyNames.entrySet()
										.iterator().next();
								String strValue = entryVals.getValue();
								String strKeyValue = entryVals.getKey();
								if ("DATE".equals(strValue) || "TIMESTAMP".equals(strValue)) {
									DateFormat dateFormat = new SimpleDateFormat(
											StringUtils.isEmpty(testDataGenenarteDTO
													.getDateFormate()) ? "dd/MMM/yyyy hh:mm:ss"
													: testDataGenenarteDTO.getDateFormate());
									Date date = new Date();
									String strDate = dateFormat.format(date) + "";
									mpDummyValues.put((entryVals.getKey()), strDate);
								} else if (mapDataDictionaryVals.containsKey(strKeyValue)) {
									if (isDataConditional) {
										mpDummyValues.put(entryVals.getKey(), mapDataDictionaryVals
												.get(strKeyValue).get(0));
									} else {
										Map<String, Map<String, String>> mapResult = mapTableWithSequence
												.get(tbName);
										if (mapUkNames != null && mapResult != null
												&& mapResult.containsKey(strKeyValue)) {
											Map<String, String> mapSequences = mapResult
													.get(strKeyValue);
											Map<String, Map<String, String>> mapRes = new HashMap<String, Map<String, String>>();
											mapRes.put(tbName, mapSequences);
											mpDummyValues.put(
													entryVals.getKey(),
													generatePkValues(jdbcTemplate, null, mapRes,
															lRecordsCount, tbName).get(0)
															+ "");
										} else {
											generateRandom = new GenerateRandom(strValue.substring(
													0, strValue.indexOf("#")),
													Integer.parseInt(strValue.substring(strValue
															.indexOf("#") + 1)), 1);
											List<String> listGenValues = generateRandom
													.generateRandomString();
											mpDummyValues.put((entryVals.getKey()),
													listGenValues.get(0));
										}
									}
								}else {
									generateRandom = new GenerateRandom(strValue.substring(
											0, strValue.indexOf("#")),
											Integer.parseInt(strValue.substring(strValue
													.indexOf("#") + 1)), 1);
									List<String> listGenValues = generateRandom
											.generateRandomString();
									mpDummyValues.put((entryVals.getKey()),
											listGenValues.get(0));
								}
							}
							
							//End of constraint related values
							/**
							 * Going to generate primary key value if sequence don't know
							 */
							String strPrimaryKey = "";
							if (!mapTableWithSequence.containsKey(tbName) && !vct.isEmpty()) {
								/*strPrimaryKey = TdgCentralConstant.getSpecificDBQuery(getDbType(),
										TdgCentralConstant.PRIMARY_KEY, vct);*/
								strPrimaryKey = TdgCentralConstant.getSpecificDBQuery(getDbType(),
										TdgCentralConstant.PRIMARY_KEY_FINAL, vct);
							}
							@SuppressWarnings("rawtypes")
							Vector vctValues = new Vector();
							if (mapConditions.containsKey(mapConditionWithPKs.get(tbName))) {
								vctValues.addAll(generatePkByConditionValues(
										mapConditions.get(mapConditionWithPKs.get(tbName))
												.toString().trim(), lRecordsCount));
							} else if (mapDataDictionaryVals != null && entryPks != null
									&& mapDataDictionaryVals.containsKey(vct.get(0))) {
								vctValues.addAll(mapDataDictionaryVals.get(vct.get(0)));
							} else if (StringUtils.isNotEmpty(strPrimaryKey)) {
								Map<String, Map<String, String>> mapPkWithCol = mapTableWithSequence
										.get(tbName);
								if (mapPkWithCol != null && !mapPkWithCol.isEmpty()) {
									Map<String, String> mapSequeces = mapPkWithCol.get(mapPositions
											.get(1));
									Map<String, Map<String, String>> mapFinalSequence = new HashMap<String, Map<String, String>>();
									mapFinalSequence.put(tbName, mapSequeces);
								} else {
									vctValues.addAll(generatePkValues(jdbcTemplate, strPrimaryKey,
											null, lRecordsCount, tbName));
								}
							}
							//End of generation of primary key values
							
							/**
							 * Going to push the data into DB in chunk wise
							 */
							
							long iLoop = 1;
							long iMod = 0;
							int iElement = 0;
							if(lRecordsCount > TdgCentralConstant.BATCH_CHUNK_LIMIT){
		                    iLoop = (lRecordsCount / TdgCentralConstant.BATCH_CHUNK_LIMIT);
                            iMod = (lRecordsCount % TdgCentralConstant.BATCH_CHUNK_LIMIT);
							}
							long iNoOfTimes = 0;
                            if(iMod > 0){
                                iLoop++;
                            }
                           // List<Object[]> listParameters = null;
                            for(long i2 = 0;i2 < iLoop;i2++){
                                if(iMod > 0 && i2 == iLoop - 1){
                                    iNoOfTimes = iMod;
                                }else{
                                	if(lRecordsCount > TdgCentralConstant.BATCH_CHUNK_LIMIT){
                                    iNoOfTimes = TdgCentralConstant.BATCH_CHUNK_LIMIT;
                                	}else{
                                		iNoOfTimes = lRecordsCount;
                                	}
                                }
                                List<Object[]> listParameters  = new ArrayList<Object[]>();
                                for(int iRecord = 0;iRecord < iNoOfTimes;iRecord++){
                                	
        							//for (int iRecords = 0; iRecords < lRecordsCount; iRecords++) {
        								//introduced for sync values of each row from manual dictionary
        								int iDictionaryPickedRowId = 0;
        								if (listRelations != null) {
        									Object[] obj = new Object[mapPositions.size()];
        									for (int k = 0; k < mapPositions.size(); k++) {
        										if (k == 0 && !vctValues.isEmpty()) {
        											obj[k] = vctValues.get(iElement);
        										} else if (mpFkValues != null
        												&& mpFkValues.containsKey(mapPositions.get(k + 1))) {
        											List<String> listFks = mapPks.get(mpFkValues
        													.get(mapPositions.get(k + 1)));
        											if (listFks != null && !listFks.isEmpty()) {
        												if (listFks.size() == 1) {
        													obj[k] = listFks.get(0);
        												} else {
        													obj[k] = listFks.get(iElement);
        												}
        											} else if (mapDataDictionaryVals != null
        													&& mapDataDictionaryVals
        															.containsKey(mapPositions.get(k + 1))
        													&& isDataConditional) {
        												obj[k] = mapDataDictionaryVals.get(
        														mapPositions.get(k + 1)).get(iElement);
        											}else{
        												obj[k] = null;
        											}
        										} else if (mapInputDepends != null
        												&& !mapInputDepends.isEmpty()
        												&& mapInputDepends.containsKey(mapPositions
        														.get(k + 1))) {
        											Vector<String> vctDepends = mapInputDepends
        													.get(mapPositions.get(k + 1));
        											if (vctDepends != null && !vctDepends.isEmpty()) {
        												if (vctDepends.size() == 1) {
        													obj[k] = vctDepends.get(0);
        												} else {
        													obj[k] = vctDepends.get(iElement);
        												}
        											}// mapReverseDependents
        										} else if (mapReverseDependents != null
        												&& !mapReverseDependents.isEmpty()
        												&& mapReverseDependents.containsKey(mapPositions
        														.get(k + 1))) {
        											Vector<String> vctDepends = mapInputDepends
        													.get(mapReverseDependents.get(mapPositions
        															.get(k + 1)));
        											if (vctDepends != null && !vctDepends.isEmpty()) {
        												if (vctDepends.size() == 1) {
        													obj[k] = vctDepends.get(0);
        												} else {
        													obj[k] = vctDepends.get(iElement);
        												}
        											}// mapReverseDependents
        										} else if (mapDummyNames != null
        												&& mapDummyNames.containsKey(mapPositions
        														.get(k + 1))) {
        											obj[k] = mpDummyValues.get(mapPositions.get(k + 1));
        										} else if (mpUkValues != null
        												&& mpUkValues.containsKey(mapPositions.get(k + 1))) {
        											if(mpUkValues.get(mapPositions.get(k + 1)) != null && mpUkValues.get(mapPositions.get(k + 1)).size() ==1){
        												obj[k] = mpUkValues.get(mapPositions.get(k + 1)).get(
        														0);
        											}else{
        											obj[k] = mpUkValues.get(mapPositions.get(k + 1)).get(
        													iElement);
        											}
        										} else if (mpNNkValues != null
        												&& mpNNkValues.containsKey(mapPositions.get(k + 1))) {
        											//System.out.println(mapPositions.get(k + 1));
        											if(mpNNkValues.get(mapPositions.get(k + 1)) != null && mpNNkValues.get(mapPositions.get(k + 1)).size() ==1){
        												obj[k] = mpNNkValues.get(mapPositions.get(k + 1)).get(
        														0);
        											}else{
        												if(mpNNkValues != null && mapNNkNames.size() != lRecordsCount){
        													obj[k] = mpNNkValues.get(mapPositions.get(k + 1)).get((int)(Math.random() * mapNNkNames.size()));
        												}else{
        											obj[k] = mpNNkValues.get(mapPositions.get(k + 1)).get(
        													iElement);
        												}
        											}
        										} else if (mapConditions != null
        												&& mapConditions.containsKey(mapPositions
        														.get(k + 1))) {
        											if(mapConditions.get(mapPositions.get(k + 1)) instanceof List){
        												/**
        												 * Going to fetch random values from dictionary
        												 */
        												List<Object> lst = (List<Object>) mapConditions.get(mapPositions.get(k + 1));
        												if (!testDataGenenarteDTO.isSequenceOrder()) {
        													obj[k] = lst.get((int) (Math.random() * lst
        															.size()));
        												}else{
        													if(iDictionaryPickedRowId == 0)
        													iDictionaryPickedRowId = !lstSequence.isEmpty() ?lstSequence.get(iElement):(int)(Math.random() * lst.size());
        													obj[k] = lst.get(iDictionaryPickedRowId);
        												}
        												
        											}else{
        												obj[k] = mapConditions.get(mapPositions.get(k + 1));
        											}
        										} else if (mapDataDictionaryVals != null
        												&& mapDataDictionaryVals.containsKey(mapPositions
        														.get(k + 1))) {
        											if (isDataConditional) {
        												obj[k] = mapDataDictionaryVals.get(
        														mapPositions.get(k + 1)).get(iElement);
        											} else {
        												if(iDictionaryPickedRowId == 0 && !mapDataDictionaryVals.isEmpty())
        													iDictionaryPickedRowId = !lstSequence.isEmpty() ?lstSequence.get(iElement):(int)(Math.random() * mapDataDictionaryVals
        															.get(mapPositions.get(k + 1))
        															.size());
        												/**
        												 * Going to fetch random values from dictionary
        												 */
        												obj[k] = mapDataDictionaryVals
        														.get(mapPositions.get(k + 1))
        														.get(iDictionaryPickedRowId);
        											}
        										} else {
        											if (mapDataDictionaryVals != null
        													&& !mapDataDictionaryVals.isEmpty()) {
        												if(iDictionaryPickedRowId == 0)
        													iDictionaryPickedRowId = !lstSequence.isEmpty() ?lstSequence.get(iElement):(int)(Math.random() * mapDataDictionaryVals
        															.get(mapPositions.get(k + 1))
        															.size());
        												/**
        												 * Going to fetch random values from dictionary
        												 */
        												obj[k] = mapDataDictionaryVals
        														.get(mapPositions.get(k + 1))
        														.get(iDictionaryPickedRowId);
        											}
        										}
        										/**
        										 * Going for save condition values
        										 */
        										if (listConditionColNames.contains(mapPositions.get(k + 1))) {
        											if (mapDepends.get(mapPositions.get(k + 1)) != null) {
        												Vector<String> vctDependentValues = mapDepends
        														.get(mapPositions.get(k + 1));
        												if (lRecordsCount >= vctDependentValues.size()) {
        													vctDependentValues.add(obj[k] + "");
        												}
        											} else {
        												Vector<String> vctDependentValues = new Vector<String>();
        												vctDependentValues.add(obj[k] + "");
        												mapDepends.put(mapPositions.get(k + 1),
        														vctDependentValues);
        											}
        										}
        										if (mapConditionValues.containsKey(mapPositions.get(k + 1))) {
        											List<String> lstValues = mapConditionValues
        													.get(mapPositions.get(k + 1));
        											lstValues.add(obj[k] + "");
        										}
        									}									
        									// here need to check the conditional values for concatenation or suffix or prefix the values of generated column values at dynamically
        									for (int k = 0; k < mapPositions.size(); k++) {
        										String strFindValue = obj[k] != null ? obj[k].toString() : "";
        										if(strFindValue.contains("$")){
        											StringBuffer strBuffer = new StringBuffer();
        											String[] splitsvalues = strFindValue.split("\\$");
        											for(int iSize=0;iSize<splitsvalues.length;iSize++){
        												// need to check the validation of column name based on position
        												//splitsvalues[iSize] is nothing but column name basically here(assumption)
        												String strCondition = splitsvalues[iSize].contains("{") ? splitsvalues[iSize].substring(0,splitsvalues[iSize].indexOf("{")) : splitsvalues[iSize];
        												if(mapPositions.containsValue(strCondition)){
        													for (Map.Entry<Integer, String> mapEntry : mapPositions.entrySet()) {
        														if(mapEntry.getValue().equals(strCondition)){
        															String strTemp = obj[mapEntry.getKey()-1].toString();
        															strBuffer.append(splitsvalues[iSize].contains("{") ? strTemp.substring(Integer.parseInt(splitsvalues[iSize].substring(splitsvalues[iSize].indexOf("{")+1,splitsvalues[iSize].indexOf(",")) != null ? splitsvalues[iSize].substring(splitsvalues[iSize].indexOf("{")+1,splitsvalues[iSize].indexOf(",")).trim() : "0"),Integer.parseInt(splitsvalues[iSize].substring(splitsvalues[iSize].indexOf(",")+1,splitsvalues[iSize].indexOf("}")) != null ? splitsvalues[iSize].substring(splitsvalues[iSize].indexOf(",")+1,splitsvalues[iSize].indexOf("}")).trim() : "0")) : strTemp);
        															//need to verify the break statement of map position values
        															break;
        														}
        													}
        												}else{
        													strBuffer.append(splitsvalues[iSize]);
        												}
        												//strBuffer.append(splitsvalues[iSize]);												
        											}
        											//finally set the result to obj parameter which is going to insert the data
        											//obj[k] = strBuffer.toString();
        											
        											//Going to check the dashboard related stuff values			
        										if(mapConditionValues.containsKey(mapPositions.get(k+1))){
        											List<String> lstValues = mapConditionValues.get(mapPositions.get(k+1));
        											if(lstValues.contains(obj[k].toString())){
        												lstValues.remove(strFindValue);
        												lstValues.add(strBuffer.toString());												
        												}
        											mapConditionValues.put(mapPositions.get(k+1), lstValues);
        											}
        										obj[k] = strBuffer.toString();
        										}
        									}									
        									listParameters.add(obj);
        								}
        							//}
        							bUniqCheck = false;
        							if (logger.isDebugEnabled()) {
        								logger.debug(strClassName + strMethodName
        										+ " Query going to be fire is  :: " + strQuery);
        								logger.debug(strClassName + strMethodName
        										+ "parameters for batch update are  :: " + listParameters);
        							}
        							
        							iElement++;
                                }
                                
                                /**
    							 * Going to check the generation type of test data
    							 */
    							if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_DB.equals(testDataGenenarteDTO.getGenerationType())){
    							/**
    							 * Going to fire the result
    							 */
    							int[] iBatchResult = jdbcTemplate.batchUpdate(strQuery, listParameters);
    							logger.info(strClassName + strMethodName
    									+ " batch updation is done and its result is :: "
    									+ iBatchResult.length+" and table name is --> "+tbName);
    							}
    							
    							if(strStatusDescription != null && strStatusDescription.length() > 0){
    								strStatusDescription.append(',');
    							}
    							strStatusDescription.append(tbName);
                            }
                            
                            
                            
							
							
							/**
							 * Going to batch update in
							 */
							/**
							 * Going to fetch the primary key values
							 * 
							 */
							// 1. check from dummy name insert
							// if (i != 1) {
							StringBuffer strBuffer = new StringBuffer(
									TdgCentralConstant.getReplacedValue(
											TdgCentralConstant.SELECT_FOR_PK_VALUES, vct));
							String strType = mapTableWithPk.get(tbName);
							Vector<String> listPKs = new Vector<String>();
							if (StringUtils.isNotEmpty(strType) && strType.contains("#")) {
								if (vctValues != null && vctValues.isEmpty()) {
									if (mapDummyNames != null && !mapDummyNames.isEmpty()) {
										String strkey = mapDummyNames.entrySet().iterator().next()
												.getKey();
										List<String> listVals = new ArrayList<String>();
										listVals.add(mapDummyNames.get(strkey));
										strBuffer.append(TdgCentralConstant.generateString(
												strType.substring(0, strType.indexOf("#")), strkey,
												listVals));
										Object[] obj = new Object[listVals.size()];
										for (int k = 0; k < listVals.size(); k++) {
											obj[k] = mpDummyValues.get(strkey);
										}
										List<Map<String, Object>> listResult = jdbcTemplate
												.queryForList(strBuffer.toString(), obj);
										for (Map<String, Object> map : listResult) {
											listPKs.add(String.valueOf(map.get(mapPositions.get(1))));
										}
										mapPks.put(tbName, listPKs);
									} else if (mpTabConditions != null
											&& !mpTabConditions.isEmpty()) {
										int iCount = 0;
										List<List<String>> lstListVals = new ArrayList<List<String>>();
										for (Entry<String, String> strMapKey : mpTabConditions
												.entrySet()) {
											List<String> listVals = new ArrayList<String>();
											listVals.add(String.valueOf(mpTabConditions
													.get(strMapKey.getKey())));
											strBuffer.append(TdgCentralConstant.generateString(
													strType.substring(0, strType.indexOf("#")),
													strMapKey.getKey(), listVals));
											lstListVals.add(listVals);
											iCount++;
										}
										Object[] obj = new Object[iCount];
										for (int k = 0; k < lstListVals.size(); k++) {
											for (int j = 0; j < lstListVals.get(k).size(); j++) {
												obj[k] = lstListVals.get(k).get(j);
											}
										}
										List<Map<String, Object>> listResult = jdbcTemplate
												.queryForList(strBuffer.toString(), obj);
										for (Map<String, Object> map : listResult) {
											listPKs.add(String.valueOf(map.get(mapPositions.get(1))));
										}
										mapPks.put(tbName, listPKs);
									} else if (mpFkValues != null && !mpFkValues.isEmpty()) {
										for (Entry<String, String> strMapKey : mpFkValues
												.entrySet()) {
											List<String> lstFkKeys = mapPks.get(mpFkValues
													.get(strMapKey));
											strBuffer.append(TdgCentralConstant.generateString("",
													strMapKey.getKey(), lstFkKeys));
											Object[] obj = new Object[lstFkKeys.size()];
											for (int j = 0; j < lstFkKeys.size(); j++) {
												obj[j] = lstFkKeys.get(j);
											}
											List<Map<String, Object>> listResult = jdbcTemplate
													.queryForList(strBuffer.toString(), obj);
											for (Map<String, Object> map : listResult) {
												listPKs.add(String.valueOf(map.get(mapPositions
														.get(1))));
											}
											mapPks.put(tbName, listPKs);
											break;
										}
									} else if (mpUkValues != null && !mpUkValues.isEmpty()) {
										for (Entry<String, List<String>> strMapKey : mpUkValues
												.entrySet()) {
											List<String> lstFkKeys = mpUkValues.get(mpFkValues
													.get(strMapKey));
											strBuffer.append(TdgCentralConstant.generateString("",
													strMapKey.getKey(), lstFkKeys));
											Object[] obj = new Object[lstFkKeys.size()];
											for (int j = 0; j < lstFkKeys.size(); j++) {
												obj[j] = lstFkKeys.get(j);
											}
											List<Map<String, Object>> listResult = jdbcTemplate
													.queryForList(strBuffer.toString(), obj);
											for (Map<String, Object> map : listResult) {
												listPKs.add(String.valueOf(map.get(mapPositions
														.get(1))));
											}
											mapPks.put(tbName, listPKs);
											break;
										}
									}
								} else {
									mapPks.put(tbName, vctValues);
								}
							} else {
								mapPks.put(tbName, vctValues);
							}
							if (logger.isDebugEnabled())
								logger.debug(strClassName + strMethodName
										+ " inserted records primary keys are :: "
										+ mapPks.get(tbName));
							// }
						}
					}//end of filter closer
					}
				}
				iIteratorCount++;
			}
			
			/*if(!isConditiontableExist){
				testDataGenenarteDTO.setDataConditionalTabNames(null);
			}*/
		}
		logger.debug(strClassName + strMethodName + " return from generateQueriesAndDumping");
		return mapDepends;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Vector generatePkByConditionValues(String trim, long lRecordsCount){
		Vector vct = new Vector();
		for (int i = 1; i <= lRecordsCount; i++) {
			vct.add(trim + i);
		}
		return vct;
	}

	private List<Map<String, Object>> getSequenceColsByTableName(JdbcTemplate jdbcTemplate,
			String strTBName, String strPKColumnName){
		List<Map<String, Object>> listString = null;
		Vector<String> vct = new Vector<String>(getVectorVals());
		vct.add(strTBName);
		if (strPKColumnName != null) {
			vct.add(strPKColumnName);
			listString = TdgCoreConverter.getConvertedResult(jdbcTemplate, TdgCentralConstant
					.getSpecificDBQuery(getDbType(), TdgCentralConstant.GET_SEQUENCE_OF_COLUMNS2,
							vct), getDbType());
		} else {
			listString = TdgCoreConverter.getConvertedResult(jdbcTemplate, TdgCentralConstant
					.getSpecificDBQuery(getDbType(), TdgCentralConstant.GET_SEQUENCE_OF_COLUMNS1,
							vct), getDbType());
		}
		return listString;
	}

	private List<Map<String, Object>> getPrimaryKeyValue(JdbcTemplate jdbcTemplate, String strquery){
		List<Map<String, Object>> listString = jdbcTemplate.queryForList(strquery);
		return listString;
	}


	@Override
	public List<Map<String, Object>> getTableNamesByColsName(JdbcTemplate jdbcTemplate,
			List<String> listcolumnsName){
		String strMethodName = " [ getTableNamesByColsName() ] ";
		logger.info(strClassName + strMethodName + " inside getTableNamesByColsName method");
		List<Map<String, Object>> listString = null;
		StringBuffer strBuffer = new StringBuffer(TdgCentralConstant.getSpecificDBQuery(
				getDbType(), TdgCentralConstant.GET_TABLES_BY_COLUMNS, getVectorVals()))
				.append("( ");
		if (listcolumnsName != null && !listcolumnsName.isEmpty()) {
			int iCount = 0;
			for (String strColsName : listcolumnsName) {
				iCount++;
				/**
				 * checking for multiple column names check
				 */
				if (strColsName.contains("#")) {
					String[] strArray = strColsName.split("#");
					for (int i = 0; i < strArray.length; i++) {
						strBuffer.append(" '").append(strArray[i].toUpperCase()).append('\'');
						if (i != strArray.length - 1) {
							strBuffer.append(',');
						}
					}
					if (strArray != null && strArray.length > 0) {
						strBuffer.append(',');
					}
				} else {
					strBuffer.append(" '").append(strColsName.toUpperCase()).append('\'');
					if (iCount != listcolumnsName.size()) {
						strBuffer.append(',');
					}
				}
				if (iCount == listcolumnsName.size()) {
					strBuffer.append(')');
				}
			}
			listString = TdgCoreConverter.getConvertedResult(jdbcTemplate, strBuffer.toString(),
					getDbType());
		}
		logger.info(strClassName + strMethodName + " return from getTableNamesByColsName method");
		return listString;
	}

	private Map<String, String> getTableNameByFkName(JdbcTemplate jdbcTemplate, String strTBName,
			Map<String, String> mapFkColumns){
		Map<String, String> mapValues = new HashMap<String, String>();
		StringBuffer strQuery = null;
		Vector<String> vct = null;
		for (Map.Entry<String, String> val : mapFkColumns.entrySet()) {
			vct = new Vector<String>(getVectorVals());
			vct.add(strTBName);
			vct.add(val.getKey());
			strQuery = new StringBuffer(TdgCentralConstant.getSpecificDBQuery(getDbType(),
					TdgCentralConstant.GET_TABLE_NAME_BY_FK, vct));
			List<Map<String, Object>> listString = jdbcTemplate.queryForList(strQuery.toString());
			mapValues.put(val.getKey(), String.valueOf(listString.get(0).get("TABLE_NAME"))
					.toUpperCase());
		}
		return mapValues;
	}

	/**
	 * This method is used to fetch tables in sequence order to dump the data into respective tables
	 */
	@Override
	public List<Object> generateSequenceOfTables(JdbcTemplate jdbcTemplate, String tableName){
		List<Object> listObject = new ArrayList<Object>();
		tableName += "#";
		listObject.add(tableName.toUpperCase());
		String temptableName = tableName.substring(0, tableName.indexOf("#"));
		Vector<String> vct = new Vector<String>(getVectorVals());
		vct.add(temptableName);
		logger.info(" Going for table " + temptableName);
		List<Map<String, Object>> listValues = jdbcTemplate.queryForList(TdgCentralConstant
				.getSpecificDBQuery(getDbType(), TdgCentralConstant.GET_SEQUENCE_TABLES, vct));
		for (Map<String, Object> mapValues : listValues) {
			listObject
					.add(generateSequenceOfTables(jdbcTemplate, ((String) mapValues.entrySet()
							.iterator().next().getValue())
							+ tableName.substring(tableName.indexOf("#"), tableName.length())
									.toUpperCase()));
		}
		return listObject;
	}

	private List<Map<String, Object>> getConstraintsOfTable(JdbcTemplate jdbcTemplate,
			String tableName){
		Vector<String> vct = new Vector<String>(getVectorVals());
		vct.add(tableName);
		List<Map<String, Object>> listValues = TdgCoreConverter.getConvertedResult(jdbcTemplate,
				TdgCentralConstant.getSpecificDBQuery(getDbType(),
						TdgCentralConstant.GET_CONSTRAINTS_OF_TABLES, vct), getDbType());
		return listValues;
	}

	private List<Map<String, Object>> getNotNullConstraintsOfTable(JdbcTemplate jdbcTemplate,
			String tableName){
		Vector<String> vct = new Vector<String>(getVectorVals());
		vct.add(tableName);
		String strQuery = TdgCentralConstant.getSpecificDBQuery(getDbType(),
				TdgCentralConstant.GET_NOT_NULL_CONSTRAINTS_OF_TABLES, vct);
		List<Map<String, Object>> listValues = new ArrayList<Map<String, Object>>();
		if (strQuery != null && !"".equals(strQuery)) {
			listValues.addAll(TdgCoreConverter.getConvertedResult(jdbcTemplate, strQuery,
					getDbType()));
		}
		return listValues;
	}

	private List<Map<String, Object>> getPkColumnType(JdbcTemplate jdbcTemplate,
			String constraint_name, String tableName){
		Vector<String> vct = new Vector<String>(getVectorVals());
		vct.add(constraint_name);
		vct.add(tableName);
		List<Map<String, Object>> listValues = TdgCoreConverter.getConvertedResult(jdbcTemplate,
				TdgCentralConstant.getSpecificDBQuery(getDbType(),
						TdgCentralConstant.GET_PK_COLUMN_TYPE, vct), getDbType());
		return listValues;
	}

	private List<Map<String, Object>> getOntToOneTableInformation(JdbcTemplate jdbcTemplate,
			String tableName){
		Vector<String> vct = new Vector<String>(getVectorVals());
		vct.add(tableName);
		List<Map<String, Object>> listValues = jdbcTemplate.queryForList(TdgCentralConstant
				.getSpecificDBQuery(getDbType(),
						TdgCentralConstant.ONE_TO_ONE_RELATIONS_FIND_TABLES, vct));
		return listValues;
	}

	private List<Map<String, Object>> getConstraintRelationTable(JdbcTemplate jdbcTemplate,
			String strConstraintName, String strTableName){
		Vector<String> vct = new Vector<String>(getVectorVals());
		vct.add(strConstraintName);
		vct.add(strTableName);
		List<Map<String, Object>> listValues = jdbcTemplate.queryForList(TdgCentralConstant
				.getSpecificDBQuery(getDbType(), TdgCentralConstant.CONSTRAINTS_RELATIONS_TABLES,
						vct));
		return listValues;
	}

	@SuppressWarnings("unchecked")
	private List<Object> toCheckrelations(List<Object> listObject, List<Object> listResult){
		if (listResult == null) {
			listResult = new ArrayList<Object>();
		}
		for (Object obj : listObject) {
			if (obj instanceof List) {
				toCheckrelations((List<Object>) obj, listResult);
			} else {
				listResult.add(obj);
			}
		}
		return listResult;
	}

	private List<List<Object>> toCheckrelations(List<Object> listObject){
		List<List<Object>> listObjectFinal = new ArrayList<List<Object>>();
		List<Object> listObj = new ArrayList<Object>();
		for (Object obj : listObject) {
			List<Object> listTemp = new ArrayList<Object>(listObj);
			List<Object> duplicateCheck = containsCheck(listObj, String.valueOf(obj));
			if (duplicateCheck != null) {
				if (!containsAllCheck(listObjectFinal, listTemp)) {
					listObjectFinal.add(listTemp);
					listObjectFinal = chechSublist(listObjectFinal, listTemp);
				}
				listObj = duplicateCheck;
				List<Object> listTmp = new ArrayList<Object>(listObj);
				listTmp.add(obj);
				listObj.add(obj);
				if (!containsAllCheck(listObjectFinal, listTmp)) {
					listObjectFinal.add(listTmp);
					listObjectFinal = chechSublist(listObjectFinal, listTemp);
				}
			} else {
				listObj.add(obj);
			}
		}
		// if()
		listObjectFinal = chechSublist(listObjectFinal, listObj);
		return listObjectFinal;
	}

	private List<List<Object>> chechSublist(List<List<Object>> listObjectFinal,
			List<Object> listTemp){
		List<List<Object>> listResult = new ArrayList<List<Object>>();
		if (listObjectFinal != null) {
			listResult.addAll(listObjectFinal);
			for (List<Object> listObj : listObjectFinal) {
				if (listTemp.containsAll(listObj) && listTemp.size() != listObj.size()) {
					listResult.remove(listObj);
					if (!containsAllCheck(listResult, listTemp))
						listResult.add(listTemp);
				}
			}
		}
		if (listObjectFinal == null || listObjectFinal.isEmpty()) {
			listResult.add(listTemp);
		}
		return listResult;
	}

	private boolean containsAllCheck(List<List<Object>> listObjectFinal, List<Object> listTemp){
		for (List<Object> listObj : listObjectFinal) {
			if (listObj.containsAll(listTemp)) {
				return true;
			}
		}
		return false;
	}

	private List<Object> containsCheck(List<Object> listObj, String strValue){
		List<Object> listResult = null;
		for (Object obj : listObj) {
			String strValueList = String.valueOf(obj);
			if (strValueList.substring(strValueList.indexOf("#")).length() == strValue.substring(
					strValue.indexOf("#")).length()) {
				listResult = listObj.subList(0, listObj.indexOf(obj));
				return listResult;
			}
		}
		return listResult;
	}

	private Set<String> getTableNameInsert(List<Object> listTableNamewithHash, int iHashCount){
		Set<String> setTableNames = new HashSet<String>();
		for (Object objTbName : listTableNamewithHash) {
			String strTbName = String.valueOf(objTbName);
			if (strTbName.substring(strTbName.indexOf("#"), strTbName.length()).length() == iHashCount) {
				setTableNames.add(strTbName.substring(0, strTbName.indexOf("#")));
			}
		}
		return setTableNames;
	}

	private int getHighestHashValue(List<Object> listTableNamewithHash){
		int i = 0;
		for (Object objTbName : listTableNamewithHash) {
			String strTbName = String.valueOf(objTbName);
			int j = strTbName.substring(strTbName.indexOf("#"), strTbName.length()).length();
			if (j > i) {
				i = j;
			}
		}
		return i;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector generatePkValues(JdbcTemplate template, String query,
			Map<String, Map<String, String>> mapSequences, long iRecords, String strTableName){
		Vector vct = new Vector();
		if (mapSequences == null || !mapSequences.containsKey(strTableName)) {
			List<Map<String, Object>> listPkVal = null;
			String strPrefix = "";
			long lPkValue = 0L;
			long lLength = 1L;
			try {
				/*listPkVal = getPrimaryKeyValue(template, query);
				lPkValue = Long.parseLong(listPkVal.get(0).get("IDGEN") + "");*/
				//one going fire with all prefixes set 
				listPkVal = getPrimaryKeyValue(template, query.replaceAll("#", ""));
				lPkValue = Long.parseLong(listPkVal.get(0).get("IDGEN") + "");
			} catch (Exception se) {
				logger.error(se.getMessage());
				if (listPkVal != null && !listPkVal.isEmpty()) {
					String strPk = listPkVal.get(0).get("IDGEN") + "";
					Pattern pt = Pattern.compile("[A-Za-z]");
					if (pt.matcher(strPk).find()) {
						String str = strPk.replaceAll("[A-Za-z]", "#");
						strPrefix = strPk.substring(0, str.lastIndexOf("#") + 1);
						lLength = strPk.substring(str.lastIndexOf("#") + 1, str.length()).length();
						if (str.contains("#")) {
							listPkVal = getPrimaryKeyValue(template, query.replaceAll("#", "strPrefix"));
							lPkValue = Long.parseLong(listPkVal.get(0).get("IDGEN") + "");
							str = strPk.replaceAll("[A-Za-z]", "#");
							strPrefix = strPk.substring(0, str.lastIndexOf("#") + 1);
							lLength = strPk.substring(str.lastIndexOf("#") + 1, str.length()).length();
							lPkValue = Long.parseLong("".equalsIgnoreCase(strPk.substring(
									str.lastIndexOf("#") + 1, str.length())) ? "0" : strPk
									.substring(str.lastIndexOf("#") + 1, str.length())) + 1;
						} else {
							lPkValue = Long.parseLong(strPk) + 1;
						}
					} else {
					}
				}
			}
			//need to check for replace varchar or char types in db			
			if (lLength == 1) {
				lPkValue++;
			}
			vct.add(strPrefix + String.format("%0" + lLength + "d", lPkValue));
			for (int i = 1; i < iRecords; i++) {
				vct.add(strPrefix + (String.format("%0" + lLength + "d", ++lPkValue)));
			}
		} else {
			// need to implement for sequence
			for (Map.Entry<String, Map<String, String>> mapEntry : mapSequences.entrySet()) {
				if (strTableName.toUpperCase().equals(mapEntry.getKey().toUpperCase())) {
					Vector<String> vctTemp = new Vector<String>(getVectorVals());
					vctTemp.add(mapEntry.getValue().entrySet().iterator().next().getValue());
					String strPrefix = mapEntry.getValue().entrySet().iterator().next().getKey();
					for (int i = 1; i <= iRecords; i++) {
						vct.add(strPrefix
								+ template.queryForLong(TdgCentralConstant.getSpecificDBQuery(
										getDbType(), TdgCentralConstant.SEQUENCE_VALUE, vctTemp)));
					}
					break;
				}
			}
		}
		return vct;
	}

	public String getDbType(){
		return dbType;
	}

	public void setDbType(String dbType){
		this.dbType = dbType;
	}

	public String getSchemaName(){
		return schemaName;
	}

	public void setSchemaName(String schemaName){
		this.schemaName = schemaName;
	}

	public void cleanupDataSource(JdbcTemplate template){
		try {
			if (template != null && !template.getDataSource().getConnection().isClosed()) {
				// dataSource.destroy();
				template.getDataSource().getConnection().close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Vector<String> getVectorVals(){
		Vector<String> vct = new Vector<String>();
		if (getSchemaName() != null && !"".equals(getSchemaName())) {
			vct.add(getSchemaName());
		}
		return vct;
	}

	public Map<String, Vector<String>> getMapDependentValues(){
		return mapDependentValues;
	}

	public void setMapDependentValues(Map<String, Vector<String>> mapDependentValues){
		this.mapDependentValues = mapDependentValues;
	}

	/**
	 * This method is used to get random values from list
	 * @param listPassedVals
	 * @param iRequiredCount
	 * @return
	 */
	private List<String> getRandomValueFromList(List<String> listPassedVals, int length,
			long iRequiredCount, boolean isUniqueConstraint){
		List<String> lstResult = new ArrayList<String>();
		if (listPassedVals != null && !listPassedVals.isEmpty()) {
			int iListSize = listPassedVals.size();
			GenerateRandom generateRandom = new GenerateRandom(TdgCentralConstant.ORACLE_NUMBER,
					length, 1);
			int iPassedValueLength = length;
			String strVal = "";
			for (int i = 0; i < iRequiredCount; i++) {
				if (isUniqueConstraint) {
					Random r = new Random();
					strVal = listPassedVals.get(r.nextInt(iListSize));
					iPassedValueLength = length - strVal.length();
					if (iPassedValueLength > TdgCentralConstant.UNIQUE_RANDOMN_LENGTH) {
						generateRandom.setiLength(TdgCentralConstant.UNIQUE_RANDOMN_LENGTH);
					} else {
						generateRandom.setiLength(iPassedValueLength);
					}
					lstResult.add(listPassedVals.get((int) ThreadLocalRandom.current().nextInt(
							iListSize))
							+ gen(generateRandom));
				} else {
					lstResult.add(listPassedVals.get((int) ThreadLocalRandom.current().nextInt(
							iListSize)));
				}
			}
		}
		return lstResult;
	}

	
	/**
	 * This method is used to fetch sequence values form passed dictionary or generated values
	 * @param listPassedVals
	 * @param length
	 * @param iRequiredCount
	 * @param isUniqueConstraint
	 * @return
	 */
	private List<String> getSequenceValueFromList(List<String> listPassedVals, int length,
			long iRequiredCount, boolean isUniqueConstraint){
		List<String> lstResult = new ArrayList<String>();
		if (listPassedVals != null && !listPassedVals.isEmpty()) {
			int iListSize = listPassedVals.size();
			GenerateRandom generateRandom = new GenerateRandom(TdgCentralConstant.ORACLE_NUMBER,
					length, 1);
			int iPassedValueLength = length;
			String strVal = "";
			List<Integer> lstSequeceVals = new ArrayList<Integer>(lstSequence);
			for (int i = 0; i < iRequiredCount; i++) {
				if (isUniqueConstraint) {
					Random r = new Random();
					strVal = listPassedVals.get(r.nextInt(iListSize));
					iPassedValueLength = length - strVal.length();
					if (iPassedValueLength > TdgCentralConstant.UNIQUE_RANDOMN_LENGTH) {
						generateRandom.setiLength(TdgCentralConstant.UNIQUE_RANDOMN_LENGTH);
					} else {
						generateRandom.setiLength(iPassedValueLength);
					}
					if (lstSequeceVals.isEmpty()) {
						int iSequence = ThreadLocalRandom.current().nextInt(iListSize);
						lstSequence.add(iSequence);
						lstResult.add(listPassedVals.get(iSequence) + gen(generateRandom));
					} else {
						lstResult.add(listPassedVals.get(lstSequence.get(i)) + gen(generateRandom));
					}
				} else {
					if (lstSequeceVals.isEmpty()) {
						int iSequence = ThreadLocalRandom.current().nextInt(iListSize);
						lstSequence.add(iSequence);
						lstResult.add(listPassedVals.get(iSequence));
					} else {
						lstResult.add(listPassedVals.get(lstSequence.get(i)));
					}
				}
			}
		}
		return lstResult;
	}
	/*private List<String> getSequenceValueFromList(List<String> listPassedVals, int length,
			long iRequiredCount, boolean isUniqueConstraint){
		List<String> lstResult = new ArrayList<String>();
		if (listPassedVals != null && !listPassedVals.isEmpty()) {
			int iListSize = listPassedVals.size();
			GenerateRandom generateRandom = new GenerateRandom(TdgCentralConstant.ORACLE_NUMBER,
					length, 1);
			int iPassedValueLength = length;
			String strVal = "";
			if(lstSequence.isEmpty())
			for (int i = 0; i < iRequiredCount; i++) {
				lstSequence.add(ThreadLocalRandom.current().nextInt(iListSize));
			}
			for(int j=0;j<lstSequence.size();j++){
				// strVal = listPassedVals.get(ThreadLocalRandom.current().nextInt(iListSize));
				// strVal = listPassedVals.get((int) (Math.random() * iListSize));
				if (isUniqueConstraint) {
					Random r = new Random();
					strVal = listPassedVals.get(r.nextInt(iListSize));
					iPassedValueLength = length - strVal.length();
					if (iPassedValueLength > TdgCentralConstant.UNIQUE_RANDOMN_LENGTH) {
						generateRandom.setiLength(TdgCentralConstant.UNIQUE_RANDOMN_LENGTH);
					} else {
						generateRandom.setiLength(iPassedValueLength);
					}
					lstResult.add(listPassedVals
							.get(lstSequence.get(j))
							+ gen(generateRandom));
				} else {
					lstResult.add(listPassedVals
							.get(lstSequence.get(j)));
				}
			}
		}
		return lstResult;
	}*/
	private String gen(GenerateRandom generateRandom){
		List<String> listGenValues = generateRandom.generateRandomString();
		return listGenValues != null && !listGenValues.isEmpty() ? listGenValues.get(0) : "";
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Map<String,Map<String,List<Object[]>>> generateFlatTestData(TestDataGenerateDTO testDataGenenarteDTO,
			EntityManager managerentity){
		String strMethodName = " [ generateTestData() ] ";
		logger.info(strClassName + strMethodName + " inside generateTestData method");
		String strSuccess = TdgCentralConstant.FAILED_MESSAGE;
		Map<String,Map<String,List<Object[]>>> mapResponse = new HashMap<String, Map<String,List<Object[]>>>();
		strStatusDescription = new StringBuffer();
		lstGeneratedFiles = new ArrayList<String>();
		List<JdbcTemplate> listTemplates = new ArrayList<JdbcTemplate>();
		mapConditionValues = new HashMap<String, List<String>>();
		Map<String, List<Object[]>> mapResultOfFlatFile = new HashMap<String, List<Object[]>>();
		/**
		 * Support multiple database inject for depends
		 */
		List<String> listURLs = new ArrayList<String>();
		List<String> listUserNames = new ArrayList<String>();
		List<String> listPasswords = new ArrayList<String>();
		List<String> listDateFormates = new ArrayList<String>();
		if (testDataGenenarteDTO.getUrl() != null && testDataGenenarteDTO.getUrl().contains("#")) {
			listURLs.addAll(Arrays.asList(testDataGenenarteDTO.getUrl().split("#")));
		} else {
			listURLs.add(testDataGenenarteDTO.getUrl());
		}
		if (testDataGenenarteDTO.getUsername() != null
				&& testDataGenenarteDTO.getUsername().contains("#")) {
			listUserNames.addAll(Arrays.asList(testDataGenenarteDTO.getUsername().split("#")));
		} else {
			listUserNames.add(testDataGenenarteDTO.getUsername());
		}
		if (testDataGenenarteDTO.getPassword() != null
				&& testDataGenenarteDTO.getPassword().contains("#")) {
			listPasswords.addAll(Arrays.asList(testDataGenenarteDTO.getPassword().split("#")));
		} else {
			listPasswords.add(testDataGenenarteDTO.getPassword());
		}
		if (testDataGenenarteDTO.getDateFormate() != null
				&& testDataGenenarteDTO.getDateFormate().contains("#")) {
			listDateFormates
					.addAll(Arrays.asList(testDataGenenarteDTO.getDateFormate().split("#")));
		} else {
			listDateFormates.add(testDataGenenarteDTO.getDateFormate());
		}
		/**
		 * Map dependent values for reverse engineering to fetch values
		 */
		Map<String, String> mapReverseDependents = new HashMap<String, String>();
		if (testDataGenenarteDTO.getColumnsdepends() != null
				&& testDataGenenarteDTO.getColumnsdepends().contains(";")) {
			String strArrays[] = testDataGenenarteDTO.getColumnsdepends().split(";");
			for (int i = 0; i < strArrays.length; i++) {
				if (strArrays[i] != null && strArrays[i].contains("#")) {
					String strColsArrays[] = strArrays[i].split("#");
					mapReverseDependents.put(strColsArrays[1], strColsArrays[0]);
				}
			}
		}
		if (!listURLs.isEmpty() && !listUserNames.isEmpty() && !listPasswords.isEmpty()) {
			Map<String, Vector<String>> mapDependsColumns = new HashMap<String, Vector<String>>();
			for (int i = 0; i < listURLs.size(); i++) {
				String urlTemp = listURLs.get(i);
				String userNameTemp = listUserNames.get(i);
				String passTemp = listPasswords.get(i);
				JdbcTemplate jdbcTemplate = getTemplate(urlTemp, userNameTemp, passTemp);
				listTemplates.add(jdbcTemplate);
				testDataGenenarteDTO.setDateFormate(listDateFormates.get(i));
				Map<String, Vector<String>> tmpDependsColumns = generateTestForMutlipleDatabasesData(
						testDataGenenarteDTO, managerentity, jdbcTemplate, i, mapDependsColumns,
						mapReverseDependents);
				if (tmpDependsColumns.containsKey(TdgCentralConstant.FAILED_MESSAGE)) {
					strSuccess = TdgCentralConstant.FAILED_MESSAGE;
					break;
				} else {
					mapDependsColumns.putAll(tmpDependsColumns);
				}
				if (i == listURLs.size() - 1
						&& !tmpDependsColumns.containsKey(TdgCentralConstant.FAILED_MESSAGE)) {
					strSuccess = TdgCentralConstant.SUCCESS_MESSAGE;
				}
			}
			
			// final insert for trace purpose of the tdg history
			TdgRequestListDO tdgRequestListDO = new TdgRequestListDO();
			tdgRequestListDO.setReqschemaid(testDataGenenarteDTO.getSchemaId());
			tdgRequestListDO.setUserid(testDataGenenarteDTO.getUserId());
			tdgRequestListDO.setSchemaname(testDataGenenarteDTO.getSchemaname());
			tdgRequestListDO.setUserid(testDataGenenarteDTO.getUserId());
			

			if (testDataGenenarteDTO.isDataConditional()) {
				tdgOperationsDao.doDeleteDataConditionalValues(
						testDataGenenarteDTO.getDataConditionalTabNames(),
						testDataGenenarteDTO.getGenerateRecordsCount(), managerentity);
				Map<String, List<String>> mapInput = testDataGenenarteDTO
						.getMapDictionaryVals();
				if (mapInput != null && !mapInput.isEmpty()) {
					if (mapConditionValues.isEmpty()) {
						mapConditionValues = new HashMap<String, List<String>>();
					}
					for (Map.Entry<String, List<String>> mapEntry : mapInput.entrySet()) {
						if (!mapConditionValues.containsKey(mapEntry.getKey())) {
							List<String> listParams = new ArrayList<String>();
							for (int i = 0; i < testDataGenenarteDTO.getGenerateRecordsCount(); i++) {
								listParams.add(mapEntry.getValue().get(i));
							}
							mapConditionValues.put(mapEntry.getKey(), listParams);
						}
					}
				}
			}
			StringBuffer strBuffer = new StringBuffer();
			if (!mapConditionValues.isEmpty()) {
				int iCount = 1;
				for (Map.Entry<String, List<String>> mapentry : mapConditionValues.entrySet()) {
					strBuffer.append(mapentry.getKey());
					if (iCount != mapConditionValues.size()) {
						strBuffer.append('#');
					}
					iCount++;
				}
			}			
			
			tdgRequestListDO.setConditions(strBuffer.toString());
			
			if (TdgCentralConstant.SUCCESS_MESSAGE.equals(strSuccess)) {				
			    tdgRequestListDO.setRequestCount(testDataGenenarteDTO.getGenerateRecordsCount());
			    if(lstGeneratedFiles.isEmpty()){
			    @SuppressWarnings("rawtypes")
				Vector vct = new Vector();
			    vct.add(testDataGenenarteDTO.getGenerateRecordsCount());
			    vct.addElement(strStatusDescription);
			    
			    tdgRequestListDO.setStatusdescription(TdgCentralConstant.getReplacedValue(TdgCentralConstant.TDG_GENERATE_SUCCESS_MESSAGE, vct));
			    }else{
			    	tdgRequestListDO.setStatusdescription(strStatusDescription.toString());
			    }
			    tdgRequestListDO.setStatus(TdgCentralConstant.TDG_GENERATE_SUCCESS);
			    
			    //for success message of flat files
			    mapResponse.put(TdgCentralConstant.TDG_GENERATE_SUCCESS, mapResultOfFlatFile);
			}else{
				tdgRequestListDO.setRequestCount(0);
				tdgRequestListDO.setStatusdescription(strStatusDescription.toString());
				tdgRequestListDO.setStatus(TdgCentralConstant.TDG_GENERATE_FAILED);
				//for failed message of flat files
			    mapResponse.put(TdgCentralConstant.TDG_GENERATE_FAILED, mapResultOfFlatFile);
				try{
					for(String strFileNames : lstGeneratedFiles){
						File file = new File(strFileNames);
						if(file.exists() && file.delete())
							logger.info(strClassName + strMethodName
									+ " generated file is deleted ");
					}
				}catch(Exception e){
					logger.error(strClassName + strMethodName
							+ " error occured while delete the files ::  ", e);
				}
				
			}
			//strSuccess = TdgCentralConstant.FAILED_MESSAGE;setStatus<th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Status</th><th align="center"  bgcolor="#E3EFFB" scope="col" class="whitefont">Status</th><td align="left">${tdgRequestListDTOs.status}</td><td align="left">${tdgRequestListDTOs.status}</td>
			tdgOperationsDao.saveDashBoardDetails(tdgRequestListDO,
					mapConditionValues, managerentity);
			try {
				for (JdbcTemplate template : listTemplates) {
					if (!TdgCentralConstant.SUCCESS_MESSAGE.equals(strSuccess)) {
						template.getDataSource().getConnection().rollback();
					} else {
						template.getDataSource().getConnection().commit();
					}
					cleanupDataSource(template);
				}
			} catch (SQLException e1) {
				logger.error(strClassName + strMethodName
						+ " error occured while rollback the transaction ::  ", e1);
			}
		}
		return mapResponse;
	}
}
