package com.datacon.model.mapper.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.picketbox.util.StringUtil;
import org.springframework.stereotype.Service;

import com.datacon.constant.AppConstant;
import com.datacon.constant.MessageConstant;
import com.datacon.exception.ServiceException;
import com.datacon.model.DO.DataConConnectionsDO;
import com.datacon.model.DTO.DbConnectionsDTO;
import com.datacon.model.mapper.DbConnectionMapper;

@Service(MessageConstant.DB_CONN_MAPPER)
public class DbConnectionMapperImpl implements DbConnectionMapper
{
	private static Logger logger = Logger.getLogger(DbConnectionMapperImpl.class);

	@Override
	public DataConConnectionsDO convertDbConnectionsDTOtoDataConConnectionsDO(
			DbConnectionsDTO dbConnectionsDTO) {
		DataConConnectionsDO dataConConnectionsDO = null;
		if (null != dbConnectionsDTO) {
			dataConConnectionsDO = new DataConConnectionsDO();
			dataConConnectionsDO.setDbType(dbConnectionsDTO.getDbType());
			dataConConnectionsDO.setHostName(dbConnectionsDTO.getHostName());
			dataConConnectionsDO.setPortNo(Long.parseLong(dbConnectionsDTO.getPort()));
			dataConConnectionsDO.setSid(dbConnectionsDTO.getSid());
			dataConConnectionsDO.setUserName(dbConnectionsDTO.getUser());
			dataConConnectionsDO.setPassWord(dbConnectionsDTO.getPass());
			dataConConnectionsDO.setActive("Y");
			dataConConnectionsDO.setActionBy(dbConnectionsDTO.getUserId());
			dataConConnectionsDO.setActionDt(new Timestamp(new Date().getTime()));
			if (StringUtil.isNotNull(dbConnectionsDTO.getConId())) {
				dataConConnectionsDO.setDataConConnId(Long.parseLong(dbConnectionsDTO.getConId()));
			}
		}
		return dataConConnectionsDO;
	}

	@Override
	public DbConnectionsDTO convertDataConConnectionsDOtoDbConnectionsDTO(
			DataConConnectionsDO dataConConnectionsDO, DbConnectionsDTO dbConnectionsDTO) {
		if (null != dataConConnectionsDO) {
			dbConnectionsDTO.setDbType(dataConConnectionsDO.getDbType());
			dbConnectionsDTO.setHostName(dataConConnectionsDO.getHostName());
			dbConnectionsDTO.setPort(String.valueOf(dataConConnectionsDO.getPortNo()));
			dbConnectionsDTO.setSid(dataConConnectionsDO.getSid());
			dbConnectionsDTO.setUser(dataConConnectionsDO.getUserName());
			dbConnectionsDTO.setPass(dataConConnectionsDO.getPassWord());
			dbConnectionsDTO.setUserId(dataConConnectionsDO.getActionBy());
			dbConnectionsDTO.setConId(String.valueOf(dataConConnectionsDO.getDataConConnId()));
			if (dataConConnectionsDO.getActive().equalsIgnoreCase("Y")) {
				dbConnectionsDTO.setActive("Yes");
			}
		}
		return dbConnectionsDTO;
	}

	@Override
	public List<DbConnectionsDTO> convertDataConConnectionsDOstoDbConnectionsDTOs(
			List<DataConConnectionsDO> dataConConnectionsDOs,
			List<DbConnectionsDTO> dbConnectionsDTOs) {
		DbConnectionsDTO dbConnectionsDTO = null;
		if (null != dataConConnectionsDOs) {
			if (null == dbConnectionsDTOs) {
				dbConnectionsDTOs = new ArrayList<DbConnectionsDTO>();
			}
			for (DataConConnectionsDO dataConConnectionsDO : dataConConnectionsDOs) {
				dbConnectionsDTO = new DbConnectionsDTO();
				dbConnectionsDTO = convertDataConConnectionsDOtoDbConnectionsDTO(
						dataConConnectionsDO, dbConnectionsDTO);
				dbConnectionsDTOs.add(dbConnectionsDTO);
			}
		}
		return dbConnectionsDTOs;
	}

	@Override
	public StringBuffer getUrl(DbConnectionsDTO dbConnectionsDTO, StringBuffer url)
			throws ServiceException {

		try {
			if (null != dbConnectionsDTO) {
				// build url start
				if (StringUtils.isNotEmpty(dbConnectionsDTO.getDbType())) {
					if (dbConnectionsDTO.getDbType().equalsIgnoreCase("Oracle")) {
						// driver class
						Class.forName(AppConstant.ORA_DRIVER);
						// driver url
						url.append(AppConstant.ORA_URL);
						// Host name
						url.append(dbConnectionsDTO.getHostName());
						// port number
						url.append(':');
						url.append(dbConnectionsDTO.getPort());
						// sid/service/db name
						url.append(':');
						url.append(dbConnectionsDTO.getSid());
					} else if (dbConnectionsDTO.getDbType().equalsIgnoreCase("SqlServer")) {
						// driver class
						Class.forName(AppConstant.SQL_SERVER_DRIVER);
						// driver url
						url.append(AppConstant.SQL_SERVER_URL);
						// Host name
						url.append(dbConnectionsDTO.getHostName());
						// port number
						url.append(':');
						url.append(dbConnectionsDTO.getPort());
						// sid/service/db name
						url.append(";databaseName=");
						url.append(dbConnectionsDTO.getSid());
						url.append(";");
					} else if (dbConnectionsDTO.getDbType().equalsIgnoreCase("MySql")) {
						// driver class
						Class.forName(AppConstant.MYSQL_DRIVER);
						// driver url
						url.append(AppConstant.MYSQL_URL);
						// Host name
						url.append(dbConnectionsDTO.getHostName());
						// port number
						url.append(':');
						url.append(dbConnectionsDTO.getPort());
						// sid/service/db name
						url.append('/');
						url.append(dbConnectionsDTO.getSid());
					} else if (dbConnectionsDTO.getDbType().equalsIgnoreCase("DB2")) {
						// driver class
						Class.forName(AppConstant.DB2_DRIVER);
						// driver url
						// jdbc:db2://<hostname>:50000/SAMPLE:currentSchema=USRES;
						url.append(AppConstant.DB2_URL);
						// Host name
						url.append(dbConnectionsDTO.getHostName());
						// port number
						url.append(':');
						url.append(dbConnectionsDTO.getPort());
						// sid/service/db name
						url.append("/SAMPLE:currentSchema=");
						url.append(dbConnectionsDTO.getSid());

					}
				}// build url end
			}
			return url;
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.DB_CON_SERV + MessageConstant.DB_TEST_CON
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

}
