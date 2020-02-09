package com.datacon.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Component;

import com.datacon.constant.AppConstant;
import com.datacon.constant.MessageConstant;
import com.datacon.dao.UploadDAO;
import com.datacon.exception.DAOException;
import com.datacon.model.DO.DataConConnectionsDO;
import com.datacon.util.SepcQueryUtil;

@Component(MessageConstant.UPLOAD_DAO)
public class UploadDAOImpl implements UploadDAO
{
	private static Logger logger = Logger.getLogger(UploadDAOImpl.class);

	private String dbType;
	private String schemaName;

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	@Override
	public List<DataConConnectionsDO> getAvilableDBs(String userId, EntityManager managerUser)
			throws DAOException {
		logger.info(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_AVIL_DBS
				+ MessageConstant.LOG_INFO_PARAMS_NO);

		try {

			String query = "SELECT r FROM DataConConnectionsDO r where r.actionBy='" + userId
					+ "' AND r.active='Y' Order By r.actionDt desc";

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<DataConConnectionsDO> list = managerUser.createQuery(query).getResultList();

			logger.info(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_AVIL_DBS
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_AVIL_DBS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_AVIL_DBS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_AVIL_DBS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_AVIL_DBS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	/**
	 * This method is used to get the jdbc template of respective schema
	 */
	SingleConnectionDataSource dataSource = null;

	@Override
	public JdbcTemplate getTemplate(String strUrl, String strUsername, String strPassword)
			throws DAOException {
		logger.info(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_TEMP
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			dataSource = new SingleConnectionDataSource(strUrl, strUsername, strPassword, true);
			dataSource.setAutoCommit(false);
			DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(
					dataSource);
			dataSourceTransactionManager.setRollbackOnCommitFailure(true);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(
					dataSourceTransactionManager.getDataSource());
			if (strUrl != null) {
				if (strUrl.toLowerCase().contains("oracle")) {
					setDbType(AppConstant.DB_TYPE_ORACLE);
					setSchemaName("");
				} else if (strUrl.toLowerCase().contains("mysql")) {
					setDbType(AppConstant.DB_TYPE_MYSQL);
					String strArrays[] = strUrl.split("\\/");
					if (strArrays != null && strArrays.length > 0) {
						setSchemaName(strArrays[strArrays.length - 1].toUpperCase());
					} else {
						setSchemaName("TEST");// set for default now
					}
				} else if (strUrl.toLowerCase().contains("db2")) {
					setDbType(AppConstant.DB_TYPE_DB2);
					setSchemaName("");
				} else if (strUrl.toLowerCase().contains("sqlserver")) {
					setDbType(AppConstant.DB_TYPE_SQLSERVER);
					setSchemaName("");
				}
			}
			logger.info(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_TEMP
					+ MessageConstant.LOG_INFO_RETURN);
			return jdbcTemplate;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_TEMP
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_TEMP
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_TABLES
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_TEMP
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	/**
	 * This method is used to fetch all the tables are in sequence which are exist in respective
	 * schema of oracle
	 */
	@Override
	public List<Object> getTables(JdbcTemplate jdbcTemplate, String tableName) throws DAOException {
		logger.info(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_TABLES
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			List<Object> listObject = new ArrayList<Object>();
			Vector<String> vct = new Vector<String>(getVectorVals());
			vct.add(tableName);

			List<Map<String, Object>> listValues = jdbcTemplate.queryForList(SepcQueryUtil
					.getSpecificDBQuery(getDbType(), AppConstant.GET_TABLES, vct));// generic
																					// solution
			logger.info(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_TABLES
					+ MessageConstant.LOG_INFO_PARAMS_NO);

			for (Map<String, Object> mapValues : listValues) {
				listObject.add(generateSequenceOfTables(jdbcTemplate, ((String) mapValues
						.entrySet().iterator().next().getValue())
						+ tableName.substring(tableName.indexOf("#"), tableName.length())));
			}
			logger.info(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_TABLES
					+ MessageConstant.LOG_INFO_RETURN);
			return listObject;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_TABLES
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_TABLES
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_TABLES
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_TABLES
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}

	}

	/**
	 * This method is used to fetch all the tables which are exist in respective schema of oracle
	 */
	@Override
	public List<String> getAllTables(String url, String username, String password)
			throws DAOException {
		logger.info(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_ALL_TABLES
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		JdbcTemplate template = getTemplate(url, username, password);
		List<String> listTableNames = new ArrayList<String>();
		try {
			List<Map<String, Object>> listString = template.queryForList(SepcQueryUtil
					.getSpecificDBQuery(getDbType(), AppConstant.GET_ALL_TABLES, getVectorVals()));
			for (Map<String, Object> mapValues : listString) {
				listTableNames.add(mapValues.get("TABLE_NAME").toString().toUpperCase());
			}
			logger.info(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_ALL_TABLES
					+ MessageConstant.LOG_INFO_RETURN);
			return listTableNames;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_ALL_TABLES
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_ALL_TABLES
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_ALL_TABLES
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GET_ALL_TABLES
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}

	}

	private Vector<String> getVectorVals() {
		Vector<String> vct = new Vector<String>();
		if (getSchemaName() != null && !"".equals(getSchemaName())) {
			vct.add(getSchemaName());
		}
		return vct;
	}

	/**
	 * This method is used to fetch tables in sequence order to dump the data into respective tables
	 */
	@Override
	public List<Object> generateSequenceOfTables(JdbcTemplate jdbcTemplate, String tableName)
			throws DAOException {
		logger.info(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GEN_SEQ_TABLES
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			List<Object> listObject = new ArrayList<Object>();
			tableName += "#";
			listObject.add(tableName.toUpperCase());
			String temptableName = tableName.substring(0, tableName.indexOf("#"));
			Vector<String> vct = new Vector<String>(getVectorVals());
			vct.add(temptableName);
			List<Map<String, Object>> listValues = jdbcTemplate.queryForList(SepcQueryUtil
					.getSpecificDBQuery(getDbType(), AppConstant.GET_SEQUENCE_TABLES, vct));
			for (Map<String, Object> mapValues : listValues) {
				listObject.add(generateSequenceOfTables(jdbcTemplate, ((String) mapValues
						.entrySet().iterator().next().getValue())
						+ tableName.substring(tableName.indexOf("#"), tableName.length())
								.toUpperCase()));
			}
			logger.info(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GEN_SEQ_TABLES
					+ MessageConstant.LOG_INFO_RETURN);
			return listObject;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GEN_SEQ_TABLES
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GEN_SEQ_TABLES
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GEN_SEQ_TABLES
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.UPLOAD_DAO_IMPL + MessageConstant.UPLOAD_GEN_SEQ_TABLES
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<DataConConnectionsDO> getSelctedConnections(String dataConConnIds,
			EntityManager managerUser) throws DAOException {
		logger.info(MessageConstant.DB_CON_DAO + MessageConstant.DB_SAVED_CON
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			String query = "SELECT r FROM DataConConnectionsDO r where r.dataConConnId in ("
					+ dataConConnIds + ")";

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<DataConConnectionsDO> dataConConnectionsDOs = managerUser.createQuery(query)
					.getResultList();
			logger.info(MessageConstant.DB_CON_DAO + MessageConstant.DB_SAVED_CON
					+ MessageConstant.LOG_INFO_RETURN);
			return dataConConnectionsDOs;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.DB_CON_DAO + MessageConstant.DB_SAVED_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.DB_CON_DAO + MessageConstant.DB_SAVED_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.DB_CON_DAO + MessageConstant.DB_SAVED_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.DB_CON_DAO + MessageConstant.DB_SAVED_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}

	}

	@Override
	public DataConConnectionsDO getSelctedConnection(String dataConConnIds,
			EntityManager managerUser) throws DAOException {
		logger.info(MessageConstant.DB_CON_DAO + MessageConstant.DB_SAVED_CON
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String query = "SELECT r FROM DataConConnectionsDO r where r.dataConConnId in ("
					+ dataConConnIds + ")";
			DataConConnectionsDO dataConConnectionsDO = (DataConConnectionsDO) managerUser
					.createQuery(query).getSingleResult();
			logger.info(MessageConstant.DB_CON_DAO + MessageConstant.DB_SAVED_CON
					+ MessageConstant.LOG_INFO_RETURN);
			return dataConConnectionsDO;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.DB_CON_DAO + MessageConstant.DB_SAVED_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.DB_CON_DAO + MessageConstant.DB_SAVED_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.DB_CON_DAO + MessageConstant.DB_SAVED_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.DB_CON_DAO + MessageConstant.DB_SAVED_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}

	}
}
