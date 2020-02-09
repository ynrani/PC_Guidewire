/*
 * Object Name : TdgOperationsDaoImp.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Component;

import com.tesda.dao.TdgOperationsDao;
import com.tesda.model.DO.TdgDataConditionalDO;
import com.tesda.model.DO.TdgGeneratedRequestDO;
import com.tesda.model.DO.TdgGuiDetailsDO;
import com.tesda.model.DO.TdgRequestListDO;
import com.tesda.model.DO.TdgSchemaDO;
import com.tesda.model.DTO.TdgDataConditionDTO;
import com.tesda.util.TdgCentralConstant;

@Component("tdgOperationsDao")
public class TdgOperationsDaoImp implements TdgOperationsDao{
	private static Logger logger = Logger.getLogger(TdgOperationsDaoImp.class);
	private static String strClassName = " [ TdgOperationsDaoImp ] ";
	SingleConnectionDataSource dataSource = null;

	@Override
	public String saveSchemaDetails(TdgSchemaDO tdgSchemaDO, EntityManager managerEntity){
		String strMethodName = " [ saveSchemaDetails() ] ";
		logger.info(strClassName + strMethodName + " inside saveSchemaDetails method");
		String strMessage = TdgCentralConstant.FAILED_MESSAGE;
		try {
			Set<TdgGuiDetailsDO> settdgGuiDetailsDO = tdgSchemaDO.getTdgGuiDetailsDOs();
			managerEntity.getTransaction().begin();
			List<TdgSchemaDO> listTdgSchemaDao = managerEntity
					.createNamedQuery("TdgSchemaDO.findBySchemaName", TdgSchemaDO.class)
					.setParameter("schemaname", tdgSchemaDO.getSchemaname()).getResultList();
			if (listTdgSchemaDao != null && !listTdgSchemaDao.isEmpty()) {
				logger.info(strClassName
						+ strMethodName
						+ " upload dicitionary details is already exist. So going to remove the schema details");
				for (TdgSchemaDO tdgSchemado : listTdgSchemaDao) {
					if(StringUtils.isNotEmpty(tdgSchemado.getManualdictionary())){
						tdgSchemaDO.setManualdictionary(tdgSchemado.getManualdictionary());
					}
					managerEntity.remove(tdgSchemado);
				}
			}
			Long no = (Long) managerEntity.createQuery(
					"SELECT NVL(MAX(p.reqschemaid),0)  from TdgSchemaDO p").getSingleResult();
			long nooId = (null != no ? no : 0) + 1;
			tdgSchemaDO.setReqschemaid(nooId);
			Long noGui = (Long) managerEntity.createQuery(
					"SELECT NVL(MAX(p.reqguiid),0)  from TdgGuiDetailsDO p").getSingleResult();
			long noo = (null != noGui ? noGui : 0) + 1;
			//String strSchemaName = "Dictionary-" + noo;
			for (TdgGuiDetailsDO tdgGuiDetailsDO : settdgGuiDetailsDO) {
				tdgGuiDetailsDO.setReqguiid(noo);
				tdgGuiDetailsDO.setTdgSchemaDO(tdgSchemaDO);
				noo++;
			}
			//tdgSchemaDO.setSchemaname(strSchemaName);
			managerEntity.merge(tdgSchemaDO);
			logger.info(strClassName + strMethodName + " merged the schema details in server");
			managerEntity.getTransaction().commit();
			strMessage = TdgCentralConstant.SUCCESS_MESSAGE;
		} catch (Exception e) {
			if (managerEntity != null) {
				managerEntity.getTransaction().rollback();
			}
			logger.error(strClassName + strMethodName
					+ " got error while save the schema details  ", e);
		}
		logger.info(strClassName + strMethodName + " return from saveSchemaDetails method");
		return strMessage;
	}

	@Override
	public List<TdgSchemaDO> fetchSchemaDetailsAll(EntityManager managerEntity){
		String strMethodName = " [ fetchSchemaDetailsAll() ] ";
		logger.info(strClassName + strMethodName + " inside fetchSchemaDetailsAll method");
		List<TdgSchemaDO> listTdgSchemaDao = new ArrayList<TdgSchemaDO>();
		JdbcTemplate template = null;
		try {
			if (managerEntity != null) {
				List<TdgSchemaDO> tempTdgSchemaDao = new ArrayList<TdgSchemaDO>();
				tempTdgSchemaDao.addAll(managerEntity.createNamedQuery("TdgSchemaDO.findAll",
						TdgSchemaDO.class).getResultList());
				for (TdgSchemaDO tdgSchemaDO : tempTdgSchemaDao) {
					template = getTemplate(tdgSchemaDO.getUrl(), tdgSchemaDO.getUsername(),
							tdgSchemaDO.getPassword());
					TdgSchemaDO tempTdgSchemaDO = new TdgSchemaDO();
					BeanUtils.copyProperties(tdgSchemaDO, tempTdgSchemaDO);
					Set<TdgGuiDetailsDO> listDOs = tdgSchemaDO.getTdgGuiDetailsDOs();
					Set<TdgGuiDetailsDO> finallistDOs = new HashSet<TdgGuiDetailsDO>();
					for (TdgGuiDetailsDO tdgGuiDetailsDO : listDOs) {
						TdgGuiDetailsDO tempTdgGuiDetailsDO = new TdgGuiDetailsDO();
						BeanUtils.copyProperties(tdgGuiDetailsDO, tempTdgGuiDetailsDO);
						if (tdgGuiDetailsDO.getColumnValues() != null
								&& !"".equals(tdgGuiDetailsDO.getColumnValues())
								&& tdgGuiDetailsDO.getColumnValues().toUpperCase()
										.contains("SELECT ")
								&& !tdgGuiDetailsDO.getColumnValues().toUpperCase()
										.contains("DEPENDS_ON")) {
							if (template != null) {
								try{
								List<Map<String, Object>> listValues = template
										.queryForList(tdgGuiDetailsDO.getColumnValues());
								StringBuffer strBuffer = new StringBuffer("");
								strBuffer.append(generateValue(listValues, ""));
								tempTdgGuiDetailsDO.setColumnValues(strBuffer.toString());
								}catch(Exception se){//This should return SQLException
									logger.debug("not able to connect the target data base ==> "+se.getMessage());
									finallistDOs.clear();
									break;
								}
							}
						}
						finallistDOs.add(tempTdgGuiDetailsDO);
					}
					tempTdgSchemaDO.setTdgGuiDetailsDOs(finallistDOs);
					listTdgSchemaDao.add(tempTdgSchemaDO);
				}
				logger.info(strClassName + strMethodName
						+ " got the schema details, which size is : " + listTdgSchemaDao.size());
			}
		} finally {
			cleanupDataSource(template);
		}
		logger.info(strClassName + strMethodName + " return from fetchSchemaDetailsAll method");
		return listTdgSchemaDao;
	}

	@Override
	public List<TdgSchemaDO> fetchSchemaDetailsById(Long schemaId, EntityManager managerEntity){
		String strMethodName = " [ fetchSchemaDetailsById() ] ";
		logger.info(strClassName + strMethodName + " inside fetchSchemaDetailsById method");
		List<TdgSchemaDO> listTdgSchemaDao = new ArrayList<TdgSchemaDO>();
		if (managerEntity != null) {
			listTdgSchemaDao.addAll(managerEntity
					.createNamedQuery("TdgSchemaDO.findBySchemaId", TdgSchemaDO.class)
					.setParameter("reqschemaid", schemaId).getResultList());
			logger.info(strClassName + strMethodName + " got the schema details, which size is : "
					+ listTdgSchemaDao.size());
		}
		logger.info(strClassName + strMethodName + " return from fetchSchemaDetailsById method");
		return listTdgSchemaDao;
	}

	@Override
	public List<TdgRequestListDO> fetchRequestListAll(EntityManager managerEntity){
		String strMethodName = " [ fetchRequestListAll() ] ";
		logger.info(strClassName + strMethodName + " inside fetchRequestListAll method");
		List<TdgRequestListDO> listTdgRequestListDO = new ArrayList<TdgRequestListDO>();
		if (managerEntity != null) {
			listTdgRequestListDO.addAll(managerEntity.createNamedQuery("TdgRequestListDO.findAll",
					TdgRequestListDO.class).getResultList());
			logger.info(strClassName + strMethodName
					+ " got the dashboard details, which size is : " + listTdgRequestListDO.size());
		}
		logger.info(strClassName + strMethodName + " return from fetchRequestListAll method");
		return listTdgRequestListDO;
	}

	@Override
	public String saveDashBoardDetails(TdgRequestListDO tdgRequestListDO,
			Map<String, List<String>> mapConditions, EntityManager managerEntity){
		String strMethodName = " [ saveDashBoardDetails() ] ";
		logger.info(strClassName + strMethodName + " inside saveDashBoardDetails method");
		String strMessage = TdgCentralConstant.FAILED_MESSAGE;
		try {
			if (managerEntity != null) {
				managerEntity.getTransaction().begin();
				Long no = (Long) managerEntity.createQuery(
						"SELECT NVL(MAX(p.requestid),0)  from TdgRequestListDO p")
						.getSingleResult();
				tdgRequestListDO.setRequestid(no + 1);
				managerEntity.persist(tdgRequestListDO);
				/* This case is very specific for generate the request data */
				if(tdgRequestListDO.getRequestCount() > 0){
				managerEntity.getTransaction().commit();				
				managerEntity.getTransaction().begin();
				doSaveDashBoardValues(no + 1, TdgCentralConstant.TDG_REQUEST_GEN_LIST,
						mapConditions, managerEntity);
				}
				//strMessage = TdgCentralConstant.SUCCESS_MESSAGE+"#"+tdgRequestListDO.getRequestid();
				strMessage = tdgRequestListDO.getRequestid()+"";
				managerEntity.getTransaction().commit();
				logger.info(strClassName + strMethodName + " saved the dashboard details ");
			}
		} catch (Exception e) {
			logger.error(strClassName + strMethodName
					+ " got error while saving the dashboard details : ", e);
		}
		logger.info(strClassName + strMethodName + " return from saveDashBoardDetails method");
		return strMessage;
	}

	private void doSaveDashBoardValues(final long requestId, String strTabName,
			Map<String, List<String>> mapExcelValues, EntityManager entityManager){
		String strMethodName = " [ doSaveDashBoardValues() ] ";
		logger.info(strClassName + strMethodName + " inside doSaveDashBoardValues method");
		if (!StringUtils.isEmpty(strTabName) && mapExcelValues != null && !mapExcelValues.isEmpty()) {
			StringBuffer strBufInsertQuery = new StringBuffer("INSERT INTO ").append(strTabName)
					.append('(').append("REQGENID,REQUESTID,");
			final Long no = (Long) entityManager.createQuery(
					"SELECT NVL(MAX(p.reqgenid),0)  from TdgGeneratedRequestDO p")
					.getSingleResult();
			StringBuffer strSuffix = new StringBuffer();
			strSuffix.append('?').append(',').append('?').append(',');
			int iCount = 1;
			int iSize = mapExcelValues.size();
			int iMaxSize = 0;
			List<List<String>> lstString = new ArrayList<List<String>>();
			for (Map.Entry<String, List<String>> entryKeys : mapExcelValues.entrySet()) {
				strBufInsertQuery.append("COLUMN" + iCount);
				lstString.add(entryKeys.getValue());
				if (iMaxSize < entryKeys.getValue().size()) {
					iMaxSize = entryKeys.getValue().size();
				}
				if (iCount != iSize) {
					strBufInsertQuery.append(',');
					strSuffix.append('?').append(',');
				}
				iCount++;
			}
			if (iCount != 1) {
				strBufInsertQuery.append(')');
				strSuffix.append('?').append(')');
			}
			strBufInsertQuery.append(" VALUES (");
			strBufInsertQuery.append(strSuffix);
			final String strFinalQuery = strBufInsertQuery.toString();
			if(iMaxSize > 1000){
				iMaxSize = 1000;
			}
			final int maxSize = iMaxSize;
			final List<List<String>> lstListString = lstString;
			entityManager.unwrap(Session.class).doWork(new Work(){
				@Override
				public void execute(Connection connection) throws SQLException{
					PreparedStatement ps = connection.prepareStatement(strFinalQuery);
					for (int j = 0; j < maxSize; j++) {
						ps.setLong(1, no + (j + 1));
						ps.setLong(2, requestId);
						for (int k = 0; k < lstListString.size(); k++) {
							if (lstListString.get(k).size() > j) {
								ps.setString(k + 3, lstListString.get(k).get(j));
							} else {
								ps.setString(k + 3, "");
							}
						}
						ps.executeUpdate();
					}
				}
			});
			logger.info(strClassName + strMethodName + " return doSaveDashBoardValues method");
		}
	}

	@Override
	public List<TdgRequestListDO> fetchDashBoardListDetails(long lRequestId,
			EntityManager managerEntity){
		String strMethodName = " [ fetchDashBoardListDetails() ] ";
		logger.info(strClassName + strMethodName + " inside fetchDashBoardListDetails method");
		List<TdgRequestListDO> listTdgRequestListDO = new ArrayList<TdgRequestListDO>();
		if (lRequestId != 0) {
			if (managerEntity != null) {
				listTdgRequestListDO.addAll(managerEntity
						.createNamedQuery("TdgRequestListDO.findById", TdgRequestListDO.class)
						.setParameter("requestid", lRequestId).getResultList());
				logger.info(strClassName + strMethodName
						+ " got the dashboard details, which size is : "
						+ listTdgRequestListDO.size());
			}
		} else {
			listTdgRequestListDO.addAll(fetchDashBoardListDetails(managerEntity));
		}
		logger.info(strClassName + strMethodName + " return from fetchDashBoardListDetails method");
		return listTdgRequestListDO;
	}

	@Override
	public List<TdgRequestListDO> fetchDashBoardListDetails(EntityManager managerEntity){
		String strMethodName = " [ fetchDashBoardListDetails() ] ";
		logger.info(strClassName + strMethodName + " inside fetchDashBoardListDetails method");
		List<TdgRequestListDO> listTdgRequestListDO = new ArrayList<TdgRequestListDO>();
		if (managerEntity != null) {
			listTdgRequestListDO.addAll(managerEntity.createNamedQuery("TdgRequestListDO.findAll",
					TdgRequestListDO.class).getResultList());
			logger.info(strClassName + strMethodName
					+ " got the dashboard details, which size is : " + listTdgRequestListDO.size());
		}
		logger.info(strClassName + strMethodName + " return from fetchDashBoardListDetails method");
		return listTdgRequestListDO;
	}

	@Override
	public Long getDashBoardRecordsCount(long lRequestId, EntityManager managerEntity){
		String strMethodName = " [ getDashBoardRecordsCount() ] ";
		logger.info(strClassName + strMethodName + " inside getDashBoardRecordsCount method");
		Long lResult = 0L;
		if (managerEntity != null) {
			if (lRequestId != 0) {
				lResult = (Long) managerEntity.createQuery(
						"SELECT COUNT(*) FROM TdgRequestListDO p WHERE p.requestid=" + lRequestId)
						.getSingleResult();
			} else {
				lResult = (Long) managerEntity.createQuery(
						"SELECT COUNT(*) FROM TdgRequestListDO p ").getSingleResult();
			}
			logger.info(strClassName + strMethodName
					+ " get records count from server, which value is : " + lResult);
		}
		logger.info(strClassName + strMethodName + " return getDashBoardRecordsCount method");
		return lResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TdgRequestListDO> getDashBoardDetails(long requestid, int offSet,
			int recordsperpage, boolean b, EntityManager managerentity){
		String strMethodName = " [ getDashBoardDetails() ] ";
		logger.info(strClassName + strMethodName + " inside getDashBoardDetails method");
		List<TdgRequestListDO> lResult = null;
		if (requestid != 0) {
			lResult = managerentity
					.createQuery(
							"SELECT p FROM TdgRequestListDO p WHERE p.requestid=" + requestid
									+ " order by p.requestid desc ").setFirstResult(offSet)
					.setMaxResults(recordsperpage).getResultList();
		} else {
			lResult = managerentity
					.createQuery("SELECT r FROM TdgRequestListDO r Order By r.requestid desc ")
					.setFirstResult(offSet).setMaxResults(recordsperpage).getResultList();
		}
		logger.info(strClassName + strMethodName + " got the dashboard details, which size is : "
				+ lResult.size());
		logger.info(strClassName + strMethodName + " return getDashBoardDetails method");
		return lResult;
	}

	private JdbcTemplate getTemplate(String strUrl, String strUsername, String strPassword){
		String strMethodName = " [ getTemplate() ] ";
		logger.info(strClassName + strMethodName + " inside getTemplate method");
		DataSourceTransactionManager dataSourceTransactionManager = null;
		dataSource = new SingleConnectionDataSource(strUrl, strUsername, strPassword, true);
		dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
		dataSourceTransactionManager.setRollbackOnCommitFailure(true);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceTransactionManager.getDataSource());
		logger.info(strClassName + strMethodName + " return from getTemplate method");
		return jdbcTemplate;
	}

	private String generateValue(List<Map<String, Object>> listValues, String strInitVal){
		StringBuffer strBuffer = new StringBuffer(strInitVal);
		int iCount = 1;
		for (Map<String, Object> map : listValues) {
			int jCount = 1;
			for (Map.Entry<String, Object> mapentry : map.entrySet()) {
				strBuffer.append(mapentry.getValue());
				if (jCount != map.size()) {
					strBuffer.append(':');
				}
				jCount++;
			}
			if (iCount != listValues.size()) {
				strBuffer.append(',');
			}
			iCount++;
		}
		return strBuffer.toString();
	}

	@Override
	public String getDynamicDependentValues(long lSelectedSchemaId, String strComponentName,
			String strConditionvalue, EntityManager managerentity){
		List<TdgSchemaDO> lstTdgSchemaDO = fetchSchemaDetailsById(lSelectedSchemaId, managerentity);
		StringBuffer strResponse = new StringBuffer("");
		JdbcTemplate template = null;
		try {
			for (TdgSchemaDO tdgSchemaDO : lstTdgSchemaDO) {
				Set<TdgGuiDetailsDO> setGuiDos = tdgSchemaDO.getTdgGuiDetailsDOs();
				if (setGuiDos != null && !setGuiDos.isEmpty()) {
					template = getTemplate(tdgSchemaDO.getUrl(), tdgSchemaDO.getUsername(),
							tdgSchemaDO.getPassword());
					if (template != null) {
						for (TdgGuiDetailsDO tdgGuiDetailsDO : setGuiDos) {
							if (tdgGuiDetailsDO.getColumnValues() != null
									&& !"".equals(tdgGuiDetailsDO.getColumnValues())
									&& tdgGuiDetailsDO.getColumnValues().contains("DEPENDS_ON")
									&& tdgGuiDetailsDO.getColumnValues().contains(
											"#" + strComponentName)) {
								String[] strArrays = tdgGuiDetailsDO.getColumnValues().split("=");
								StringBuffer strBuffer = new StringBuffer(strArrays[0]);
								if (strArrays.length == 2) {
									if (strArrays[1].contains("'")) {
										strBuffer.append('=').append('\'')
												.append(strConditionvalue).append('\'');
									} else {
										strBuffer.append('=').append(strConditionvalue);
									}
									List<Map<String, Object>> listValues = template
											.queryForList(strBuffer.toString());
									if (!"".equals(strResponse.toString())) {
										strResponse.append('*');
									}
									strResponse.append(tdgGuiDetailsDO.getColumnname()).append('#')
											.append(generateValue(listValues, ""));
								}
							}
						}
					}
				}
			}
		} finally {
			cleanupDataSource(template);
		}
		return strResponse.toString();
	}

	private void cleanupDataSource(JdbcTemplate template){
		try {
			if (template != null && !template.getDataSource().getConnection().isClosed())
				template.getDataSource().getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public TdgRequestListDO getDashBoardRequestedRecords(long lRequestId,
			EntityManager managerEntity){
		String strMethodName = " [ getDashBoardRequestedRecords() ] ";
		logger.info(strClassName + strMethodName + " inside getDashBoardRequestedRecords method");
		TdgRequestListDO tdgRequestListDO = null;
		if (managerEntity != null) {
			if (lRequestId != 0) {
				tdgRequestListDO = (TdgRequestListDO) managerEntity.createQuery(
						"SELECT p FROM TdgRequestListDO p WHERE p.requestid=" + lRequestId)
						.getSingleResult();
			}
			logger.info(strClassName + strMethodName
					+ " get Requested Records from server, which value is : " + tdgRequestListDO);
		}
		logger.info(strClassName + strMethodName + " return getDashBoardRecordsCount method");
		return tdgRequestListDO;
	}

	@Override
	public Long getTdgDataDictionaryRecordsCount(EntityManager managerEntity){
		String strMethodName = " [ getTdgDataDictionaryRecordsCount() ] ";
		logger.info(strClassName + strMethodName + " inside getDashBoardRecordsCount method");
		Long lResult = 0L;
		if (managerEntity != null) {
			lResult = (Long) managerEntity.createQuery("SELECT COUNT(*) FROM TdgSchemaDO p")
					.getSingleResult();
		}
		logger.info(strClassName + strMethodName
				+ " return getTdgDataDictionaryRecordsCount method");
		return lResult;
	}

	@Override
	public List<TdgSchemaDO> getTdgMasterDictionaryRecordsForPagination(
			EntityManager managerEntity, int offSet, int recordsperpage, boolean b){
		List<TdgSchemaDO> tempTdgSchemaDao = null;
		if (managerEntity != null) {
			tempTdgSchemaDao = new ArrayList<TdgSchemaDO>();
			tempTdgSchemaDao.addAll(managerEntity.createNamedQuery("TdgSchemaDO.findAll",
					TdgSchemaDO.class).getResultList());
		}
		return tempTdgSchemaDao;
	}

	@Override
	public String saveManualDictionaryDetails(String strTabName,
			Map<String, List<String>> mapExcelValues, EntityManager managerEntity,
			String reqSchemaId){
		String strMethodName = " [ saveManualDictionaryDetails() ] ";
		String strResponse = TdgCentralConstant.FAILED_MESSAGE;
		logger.info(strClassName + strMethodName + " inside saveManualDictionaryDetails method");
		StringBuffer strCreateQuery = new StringBuffer(" CREATE TABLE ");
		String tabName = strTabName.toUpperCase();
		if (strTabName.toUpperCase().contains(".")) {
			tabName = strTabName.substring(0, strTabName.indexOf(".")).toUpperCase();
		}
		if (mapExcelValues != null && !mapExcelValues.isEmpty()) {
			/* Going to drop table if already exist in system */
			strCreateQuery.append(tabName).append('(');
			int iCount = 1;
			int iSize = mapExcelValues.size();
			for (Map.Entry<String, List<String>> entryKeys : mapExcelValues.entrySet()) {
				strCreateQuery.append(entryKeys.getKey());
				strCreateQuery.append(' ').append(TdgCentralConstant.ORACLE_VARCHAR)
						.append("(100)");
				if (iCount != iSize) {
					strCreateQuery.append(',');
				}
				iCount++;
			}
			if (iCount != 1) {
				strCreateQuery.append(')');
				managerEntity.getTransaction().begin();
				TdgSchemaDO tdgSchemaDO = (TdgSchemaDO) managerEntity
						.createNamedQuery("TdgSchemaDO.findBySchemaId")
						.setParameter("reqschemaid", Long.parseLong(reqSchemaId)).getSingleResult();
				tdgSchemaDO.setManualdictionary(tabName);
				managerEntity.merge(tdgSchemaDO);
				// dropManualDictionaryDetails(tabName, managerEntity);
				managerEntity.createNativeQuery(strCreateQuery.toString()).executeUpdate();
				managerEntity.getTransaction().commit();
				strResponse = TdgCentralConstant.SUCCESS_MESSAGE;
			}
		}
		logger.info(strClassName + strMethodName + " return saveManualDictionaryDetails method");
		return strResponse;
	}

	@Override
	public String saveDataConditionalDetails(TdgDataConditionDTO tdgDataConditionDTO,
			EntityManager managerEntity){
		String strMethodName = " [ saveDataConditionalDetails() ] ";
		String strResponse = TdgCentralConstant.FAILED_MESSAGE;
		logger.info(strClassName + strMethodName + " inside saveDataConditionalDetails method");
		StringBuffer strCreateQuery = new StringBuffer(" CREATE TABLE ");
		String tabName = tdgDataConditionDTO.getTablename().toUpperCase();
		if (tabName.toUpperCase().contains(".")) {
			tabName = tabName.substring(0, tabName.indexOf(".")).toUpperCase();
		}
		if (tdgDataConditionDTO.getMapDictionaryVals() != null
				&& !tdgDataConditionDTO.getMapDictionaryVals().isEmpty()) {
			/* Going to drop table if already exist in system */
			strCreateQuery.append(tabName).append('(');
			int iCount = 1;
			int iSize = tdgDataConditionDTO.getMapDictionaryVals().size();
			for (Map.Entry<String, List<String>> entryKeys : tdgDataConditionDTO
					.getMapDictionaryVals().entrySet()) {
				strCreateQuery.append(entryKeys.getKey());
				strCreateQuery.append(' ').append(TdgCentralConstant.ORACLE_VARCHAR)
						.append("(100)");
				if (iCount != iSize) {
					strCreateQuery.append(',');
				}
				iCount++;
			}
			if (iCount != 1) {
				strCreateQuery.append(')');
				managerEntity.getTransaction().begin();
				TdgDataConditionalDO tdgDataConditionalDO = new TdgDataConditionalDO();
				Long no = (Long) managerEntity.createQuery(
						"SELECT NVL(MAX(p.id),0)  from TdgDataConditionalDO p").getSingleResult();
				long nooId = (null != no ? no : 0) + 1;
				tdgDataConditionalDO.setId(nooId);
				tdgDataConditionalDO.setUrl(tdgDataConditionDTO.getUrl());
				tdgDataConditionalDO.setUsername(tdgDataConditionDTO.getUsername());
				tdgDataConditionalDO.setPassword(tdgDataConditionDTO.getPassword());
				tdgDataConditionalDO.setTablename(tabName);
				tdgDataConditionalDO.setUserid(tdgDataConditionDTO.getUserid());
				managerEntity.persist(tdgDataConditionalDO);
				managerEntity.createNativeQuery(strCreateQuery.toString()).executeUpdate();
				doDumpManualDictionaryValues(tabName, tdgDataConditionDTO.getMapDictionaryVals(),
						managerEntity);
				managerEntity.getTransaction().commit();
				strResponse = TdgCentralConstant.SUCCESS_MESSAGE;
			}
		}
		logger.info(strClassName + strMethodName + " return saveManualDictionaryDetails method");
		return strResponse;
	}

	@Override
	public void doDumpManualDictionaryValues(String strTabName,
			Map<String, List<String>> mapExcelValues, EntityManager entityManager){
		String strMethodName = " [ doDumpManualDictionaryValues() ] ";
		logger.info(strClassName + strMethodName + " inside doDumpManualDictionaryValues method");
		if (!StringUtils.isEmpty(strTabName) && mapExcelValues != null && !mapExcelValues.isEmpty()) {
			StringBuffer strBufInsertQuery = new StringBuffer("INSERT INTO ").append(strTabName)
					.append('(');
			StringBuffer strSuffix = new StringBuffer();
			int iCount = 1;
			int iSize = mapExcelValues.size();
			/* Going to find max list size in map for future render */
			int iMaxSize = 0;
			/* Get create a List object of List from map for batch update */
			List<List<String>> lstString = new ArrayList<List<String>>();
			for (Map.Entry<String, List<String>> entryKeys : mapExcelValues.entrySet()) {
				strBufInsertQuery.append(entryKeys.getKey());
				lstString.add(entryKeys.getValue());
				if (iMaxSize < entryKeys.getValue().size()) {
					iMaxSize = entryKeys.getValue().size();
				}
				if (iCount != iSize) {
					strBufInsertQuery.append(',');
					strSuffix.append('?').append(',');
				}
				iCount++;
			}
			if (iCount != 1) {
				strBufInsertQuery.append(')');
				strSuffix.append('?').append(')');
			}
			strBufInsertQuery.append(" VALUES (");
			strBufInsertQuery.append(strSuffix);
			/* Going for get jdbc template */
			final String strFinalQuery = strBufInsertQuery.toString();
			final int maxSize = iMaxSize;
			final List<List<String>> lstListString = lstString;
			entityManager.unwrap(Session.class).doWork(new Work(){
				@Override
				public void execute(Connection connection) throws SQLException{
					PreparedStatement ps = connection.prepareStatement(strFinalQuery);
					for (int j = 0; j < maxSize; j++) {
						for (int k = 0; k < lstListString.size(); k++) {
							if (lstListString.get(k).size() > j) {
								ps.setString(k + 1, lstListString.get(k).get(j));
							} else {
								ps.setString(k + 1, "");
							}
						}
						ps.executeUpdate();
					}
				}
			});
			logger.info(strClassName + strMethodName
					+ " return doDumpManualDictionaryValues method");
		}
	}

	@Override
	public Map<String, List<String>> retrieveManualDictionaryValues(final String strTabName,
			EntityManager entityManager){
		String strMethodName = " [ retrieveManualDictionaryValues() ] ";
		logger.info(strClassName + strMethodName + " inside retrieveManualDictionaryValues method");
		final Map<String, List<String>> mapResult = new HashMap<String, List<String>>();
		if (!StringUtils.isEmpty(strTabName) && entityManager != null) {
			entityManager.unwrap(Session.class).doWork(new Work(){
				@Override
				public void execute(Connection connection) throws SQLException{
					PreparedStatement preparedStatement = connection
							.prepareStatement("SELECT *FROM " + strTabName);
					ResultSet resultSet = preparedStatement.executeQuery();
					ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
					List<List<String>> listResult = new ArrayList<List<String>>();
					for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
						List<String> listColumnValues = new ArrayList<String>();
						listResult.add(listColumnValues);
						mapResult.put(resultSetMetaData.getColumnLabel(i), listColumnValues);
					}
					while (resultSet.next()) {
						for (int k = 0; k < mapResult.size(); k++) {
							List<String> listValues = listResult.get(k);
							listValues.add(listValues.size(),resultSet.getString(k + 1));
						}
					}
				}
			});
			logger.info(strClassName + strMethodName
					+ " return retrieveManualDictionaryValues method " + mapResult.size());
		}
		return mapResult;
	}

	@Override
	public List<String> retrieveManualDictionaryColumns(final String strTabName,
			EntityManager entityManager){
		String strMethodName = " [ retrieveManualDictionaryValues() ] ";
		logger.info(strClassName + strMethodName + " inside retrieveManualDictionaryValues method");
		final List<String> listColumnValues = new ArrayList<String>();
		if (!StringUtils.isEmpty(strTabName) && entityManager != null) {
			entityManager.unwrap(Session.class).doWork(new Work(){
				@Override
				public void execute(Connection connection) throws SQLException{
					PreparedStatement preparedStatement = connection
							.prepareStatement("SELECT *FROM " + strTabName);
					ResultSet resultSet = preparedStatement.executeQuery();
					ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
					for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
						listColumnValues.add(resultSetMetaData.getColumnLabel(i));
					}
				}
			});
			logger.info(strClassName + strMethodName
					+ " return retrieveManualDictionaryValues method " + listColumnValues.size());
		}
		return listColumnValues;
	}

	@Override
	public String dropManualDictionaryDetails(String strTabName, EntityManager managerEntity){
		String strMethodName = " [ dropManualDictionaryDetails() ] ";
		logger.info(strClassName + strMethodName + " inside dropManualDictionaryDetails method");
		String strResponse = TdgCentralConstant.FAILED_MESSAGE;
		StringBuffer strCreateQuery = new StringBuffer(" DROP TABLE ");
		if (!StringUtils.isEmpty(strTabName)) {
			strCreateQuery.append(strTabName);
			managerEntity.createNativeQuery(strCreateQuery.toString()).executeUpdate();
			strResponse = TdgCentralConstant.SUCCESS_MESSAGE;
		}
		logger.info(strClassName + strMethodName + " return dropManualDictionaryDetails method");
		return strResponse;
	}

	@Override
	public List<TdgDataConditionalDO> fetchDataConditionalDetailsAll(EntityManager managerEntity){
		String strMethodName = " [ fetchDataConditionalDetailsAll() ] ";
		logger.info(strClassName + strMethodName + " inside fetchDataConditionalDetailsAll method");
		List<TdgDataConditionalDO> tempTdgDataConditionalDO = new ArrayList<TdgDataConditionalDO>();
		if (managerEntity != null) {
			tempTdgDataConditionalDO.addAll(managerEntity.createNamedQuery(
					"TdgDataConditionalDO.findAll", TdgDataConditionalDO.class).getResultList());
			logger.info(strClassName + strMethodName + " got the schema details, which size is : "
					+ tempTdgDataConditionalDO.size());
		}
		logger.info(strClassName + strMethodName
				+ " return from fetchDataConditionalDetailsAll method");
		return tempTdgDataConditionalDO;
	}

	@Override
	public Long totalDataConditionalDetailsAll(EntityManager managerEntity){
		String strMethodName = " [ totalDataConditionalDetailsAll() ] ";
		logger.info(strClassName + strMethodName + " inside totalDataConditionalDetailsAll method");
		long lCount = 0L;
		if (managerEntity != null) {
			lCount = (Long) managerEntity
					.createQuery("SELECT Count(*) FROM TdgDataConditionalDO p").getSingleResult();
			logger.info(strClassName + strMethodName
					+ " got the total data conditional details, which size is : " + lCount);
		}
		logger.info(strClassName + strMethodName
				+ " return from totalDataConditionalDetailsAll method");
		return lCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TdgDataConditionalDO> fetchDataConditionalDetailsAll(long requestid, int offSet,
			int recordsperpage, boolean b, EntityManager managerentity){
		String strMethodName = " [ fetchDataConditionalDetailsAll() ] ";
		logger.info(strClassName + strMethodName + " inside fetchDataConditionalDetailsAll method");
		List<TdgDataConditionalDO> lResult = null;
		if (requestid != 0) {
			lResult = managerentity
					.createQuery(
							"SELECT p FROM TdgDataConditionalDO p WHERE p.id=" + requestid
									+ " order by p.requestid desc ").setFirstResult(offSet)
					.setMaxResults(recordsperpage).getResultList();
		} else {
			lResult = managerentity
					.createQuery("SELECT r FROM TdgDataConditionalDO r Order By r.id desc ")
					.setFirstResult(offSet).setMaxResults(recordsperpage).getResultList();
		}
		logger.info(strClassName + strMethodName + " got the dashboard details, which size is : "
				+ lResult.size());
		logger.info(strClassName + strMethodName + " return getDashBoardDetails method");
		return lResult;
	}

	@Override
	public TdgDataConditionalDO fetchDataConditionalById(Long id, EntityManager managerEntity){
		String strMethodName = " [ fetchDataConditionalById() ] ";
		logger.info(strClassName + strMethodName + " inside fetchDataConditionalById method");
		TdgDataConditionalDO tempTdgDataConditionalDO = null;
		if (managerEntity != null) {
			tempTdgDataConditionalDO = managerEntity
					.createNamedQuery("TdgDataConditionalDO.findById", TdgDataConditionalDO.class)
					.setParameter("id", id).getSingleResult();
			logger.info(strClassName + strMethodName + " got the schema details, which size is : "
					+ tempTdgDataConditionalDO);
		}
		logger.info(strClassName + strMethodName
				+ " return from fetchDataConditionalDetailsAll method");
		return tempTdgDataConditionalDO;
	}

	@Override
	public List<TdgGeneratedRequestDO> getGeneratedRequestData(Long lRequestId,
			EntityManager managerentity){
		String strMethodName = " [ getGeneratedRequestData() ] ";
		logger.info(strClassName + strMethodName + " inside getGeneratedRequestData method");
		List<TdgGeneratedRequestDO> listTdgGeneratedRequestDO = new ArrayList<TdgGeneratedRequestDO>();
		if (managerentity != null) {
			listTdgGeneratedRequestDO.addAll(managerentity
					.createNamedQuery("TdgGeneratedRequestDO.findRequestId",
							TdgGeneratedRequestDO.class).setParameter("requestid", lRequestId)
					.getResultList());
			logger.info(strClassName + strMethodName
					+ " got the generated data details, which size is : "
					+ listTdgGeneratedRequestDO.size());
		}
		logger.info(strClassName + strMethodName + " return from getGeneratedRequestData method");
		return listTdgGeneratedRequestDO;
	}

	@Override
	public void deleteTdgDataConditionalDetails(String id, EntityManager managerentity){
		String strMethodName = " [ deleteTdgDataConditionalDetails() ] ";
		logger.info(strClassName + strMethodName + " inside deleteTdgDataConditionalDetails method");
		if (managerentity != null) {
			managerentity.getTransaction().begin();
			TdgDataConditionalDO tdgDataConditionalDO = managerentity
					.createNamedQuery("TdgDataConditionalDO.findById", TdgDataConditionalDO.class)
					.setParameter("id", Long.parseLong(id)).getSingleResult();
			if (tdgDataConditionalDO != null
					&& !StringUtils.isEmpty(tdgDataConditionalDO.getTablename())) {
				dropManualDictionaryDetails(tdgDataConditionalDO.getTablename(), managerentity);
			}
			managerentity.remove(tdgDataConditionalDO);
			managerentity.getTransaction().commit();
		}
		logger.info(strClassName + strMethodName
				+ " return from deleteTdgDataConditionalDetails method");
	}

	@Override
	public void doDeleteDataConditionalValues(List<String> lstTableNames, long iRownum,
			EntityManager entityManager){
		String strMethodName = " [ doDeleteDataConditionalValues() ] ";
		logger.info(strClassName + strMethodName + " inside doDeleteDataConditionalValues method");
		if (lstTableNames != null && !lstTableNames.isEmpty() && iRownum != 0) {
			String strBufInsertQuery1 = "DELETE FROM ";
			StringBuffer strBufInsertQuery2 = new StringBuffer(" WHERE ROWNUM <")
					.append(iRownum + 1);
			for (String strTableName : lstTableNames) {
				final String strFinalQuery = strBufInsertQuery1.toString() + strTableName
						+ strBufInsertQuery2;
				entityManager.unwrap(Session.class).doWork(new Work(){
					@Override
					public void execute(Connection connection) throws SQLException{
						PreparedStatement ps = connection.prepareStatement(strFinalQuery);
						ps.executeUpdate();
					}
				});
			}
			logger.info(strClassName + strMethodName
					+ " return doDeleteDataConditionalValues method");
		}
	}
}
