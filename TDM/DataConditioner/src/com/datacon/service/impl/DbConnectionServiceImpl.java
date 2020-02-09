package com.datacon.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.datacon.constant.MessageConstant;
import com.datacon.dao.DbConnectionDAO;
import com.datacon.exception.DAOException;
import com.datacon.exception.ServiceException;
import com.datacon.model.DO.DataConConnectionsDO;
import com.datacon.model.DTO.DbConnectionsDTO;
import com.datacon.model.mapper.DbConnectionMapper;
import com.datacon.service.DbConnectionService;

@Component
@Service(MessageConstant.DB_CON_SERVICE)
public class DbConnectionServiceImpl extends DataConBaseServiceImpl implements DbConnectionService
{
	private static Logger logger = Logger.getLogger(DbConnectionServiceImpl.class);

	@Autowired
	DbConnectionDAO dbConnectionDAO;

	@Autowired
	DbConnectionMapper dbConnectionMapper;

	@Override
	public String testConnection(DbConnectionsDTO dbConnectionsDTO) throws ServiceException {
		logger.info(MessageConstant.DB_CON_SERV + MessageConstant.DB_TEST_CON
				+ MessageConstant.LOG_INFO_PARAMS_SEPC);
		try {

			StringBuffer url = new StringBuffer();
			url = dbConnectionMapper.getUrl(dbConnectionsDTO, url);
			Connection oracleCon = DriverManager.getConnection(url.toString(),
					dbConnectionsDTO.getUser(), dbConnectionsDTO.getPass());
			if (null != oracleCon) {
				oracleCon.close();
			}
			logger.info(MessageConstant.DB_CON_SERV + MessageConstant.DB_TEST_CON
					+ MessageConstant.LOG_INFO_RETURN + url);
			return MessageConstant.SUCCESS_PING_MSG;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_TEST_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_TEST_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public DbConnectionsDTO saveConnection(DbConnectionsDTO dbConnectionsDTO)
			throws ServiceException {
		logger.info(MessageConstant.DB_CON_SERV + MessageConstant.DB_SAVE_CON
				+ MessageConstant.LOG_INFO_PARAMS_SEPC);
		try {

			DataConConnectionsDO dataConConnectionsDO = dbConnectionMapper
					.convertDbConnectionsDTOtoDataConConnectionsDO(dbConnectionsDTO);

			EntityManager managerUser = openUserEntityManager();
			dataConConnectionsDO = dbConnectionDAO
					.saveConnection(dataConConnectionsDO, managerUser);
			closeUserEntityManager(managerUser);
			dbConnectionsDTO = dbConnectionMapper.convertDataConConnectionsDOtoDbConnectionsDTO(
					dataConConnectionsDO, dbConnectionsDTO);
			logger.info(MessageConstant.DB_CON_SERV + MessageConstant.DB_SAVE_CON
					+ MessageConstant.LOG_INFO_RETURN);
			return dbConnectionsDTO;
		} catch (NullPointerException nullPointerEx) {

			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_SAVE_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_SAVE_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_SAVE_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public DbConnectionsDTO savedConnection(String dataConConnId) throws ServiceException {
		logger.info(MessageConstant.DB_CON_SERV + MessageConstant.DB_SAVED_CON
				+ MessageConstant.LOG_INFO_PARAMS_SEPC);
		try {
			DbConnectionsDTO dbConnectionsDTO = new DbConnectionsDTO();
			EntityManager managerUser = openUserEntityManager();
			DataConConnectionsDO dataConConnectionsDO = dbConnectionDAO.savedConnection(
					dataConConnId, managerUser);
			closeUserEntityManager(managerUser);
			dbConnectionsDTO = dbConnectionMapper.convertDataConConnectionsDOtoDbConnectionsDTO(
					dataConConnectionsDO, dbConnectionsDTO);
			logger.info(MessageConstant.DB_CON_SERV + MessageConstant.DB_SAVED_CON
					+ MessageConstant.LOG_INFO_RETURN);
			return dbConnectionsDTO;
		} catch (NullPointerException nullPointerEx) {

			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_SAVED_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_SAVED_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_SAVED_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public boolean deleteConnection(String conId) throws ServiceException {
		logger.info(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DELETE
				+ MessageConstant.LOG_INFO_PARAMS_SEPC);
		try {

			EntityManager managerUser = openUserEntityManager();
			boolean sts = dbConnectionDAO.deleteConnection(conId, managerUser);
			closeUserEntityManager(managerUser);

			logger.info(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DELETE
					+ MessageConstant.LOG_INFO_RETURN + sts);
			return sts;
		} catch (NullPointerException nullPointerEx) {

			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DELETE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DELETE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DELETE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long connectionsDashboardCount(String userId) throws ServiceException {
		logger.info(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DASH_CNT
				+ MessageConstant.LOG_INFO_PARAMS_SEPC);
		try {

			EntityManager managerUser = openUserEntityManager();
			Long cnt = dbConnectionDAO.connectionsDashboardCount(userId, managerUser);
			closeUserEntityManager(managerUser);

			logger.info(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DASH_CNT
					+ MessageConstant.LOG_INFO_RETURN + cnt);

			return cnt;
		} catch (NullPointerException nullPointerEx) {

			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DASH_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DASH_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DASH_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<DbConnectionsDTO> connectionsDashboard(int offSet, int recordsperpage, boolean b,
			String userId) throws ServiceException {
		logger.info(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DASH
				+ MessageConstant.LOG_INFO_PARAMS_SEPC);
		try {
			List<DbConnectionsDTO> dbConnectionsDTOs = null;
			EntityManager managerUser = openUserEntityManager();
			List<DataConConnectionsDO> dataConConnectionsDO = dbConnectionDAO.connectionsDashboard(
					offSet, recordsperpage, b, userId, managerUser);
			closeUserEntityManager(managerUser);
			dbConnectionsDTOs = dbConnectionMapper.convertDataConConnectionsDOstoDbConnectionsDTOs(
					dataConConnectionsDO, dbConnectionsDTOs);
			logger.info(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DASH
					+ MessageConstant.LOG_INFO_RETURN);
			return dbConnectionsDTOs;
		} catch (NullPointerException nullPointerEx) {

			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DASH
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DASH
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_CON_DASH
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

}
