package com.datacon.model.mapper.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.datacon.constant.AppConstant;
import com.datacon.constant.MessageConstant;
import com.datacon.exception.ServiceException;
import com.datacon.model.DO.DataConConnectionsDO;
import com.datacon.model.mapper.UploadMapper;

@Service(MessageConstant.UPLOAD_MAPPER)
public class UploadMapperImpl implements UploadMapper
{
	@Override
	public Map<String, String> convertAvilableDBsMap(
			List<DataConConnectionsDO> dataConConnectionsDOs, Map<String, String> dbLists) {
		StringBuffer val = null;
		if (null != dataConConnectionsDOs) {
			if (null == dbLists) {
				dbLists = new LinkedHashMap<String, String>();
			}
			for (DataConConnectionsDO dataConConnectionsDO : dataConConnectionsDOs) {
				val = new StringBuffer();
				val.append(dataConConnectionsDO.getDbType());
				val.append(">>" + dataConConnectionsDO.getHostName());
				val.append(">>" + dataConConnectionsDO.getPortNo());
				val.append(">>" + dataConConnectionsDO.getSid());
				val.append(">>" + dataConConnectionsDO.getUserName());
				dbLists.put(String.valueOf(dataConConnectionsDO.getDataConConnId()), val + "");

			}
		}
		return dbLists;
	}

	@Override
	public StringBuffer getUrl(DataConConnectionsDO dataConConnectionsDO, StringBuffer url)
			throws ServiceException {
		try {
			if (null != dataConConnectionsDO) {
				// build url start
				if (StringUtils.isNotEmpty(dataConConnectionsDO.getDbType())) {
					if (dataConConnectionsDO.getDbType().equalsIgnoreCase("Oracle")) {
						// driver class
						Class.forName(AppConstant.ORA_DRIVER);
						// driver url
						url.append(AppConstant.ORA_URL);
						// Host name
						url.append(dataConConnectionsDO.getHostName());
						// port number
						url.append(':');
						url.append(dataConConnectionsDO.getPortNo());
						// sid/service/db name
						url.append(':');
						url.append(dataConConnectionsDO.getSid());
					} else if (dataConConnectionsDO.getDbType().equalsIgnoreCase("SqlServer")) {
						// driver class
						Class.forName(AppConstant.SQL_SERVER_DRIVER);
						// driver url
						url.append(AppConstant.SQL_SERVER_URL);
						// Host name
						url.append(dataConConnectionsDO.getHostName());
						// port number
						url.append(':');
						url.append(dataConConnectionsDO.getPortNo());
						// sid/service/db name
						url.append(";databaseName=");
						url.append(dataConConnectionsDO.getSid());

					} else if (dataConConnectionsDO.getDbType().equalsIgnoreCase("MySql")) {
						// driver class
						Class.forName(AppConstant.MYSQL_DRIVER);
						// driver url
						url.append(AppConstant.MYSQL_URL);
						// Host name
						url.append(dataConConnectionsDO.getHostName());
						// port number
						url.append(':');
						url.append(dataConConnectionsDO.getPortNo());
						// sid/service/db name
						url.append('/');
						url.append(dataConConnectionsDO.getSid());
					} else if (dataConConnectionsDO.getDbType().equalsIgnoreCase("DB2")) {
						// driver class
						Class.forName(AppConstant.DB2_DRIVER);
						// driver url
						// jdbc:db2://<hostname>:50000/SAMPLE:currentSchema=USRES;
						url.append(AppConstant.DB2_URL);
						// Host name
						url.append(dataConConnectionsDO.getHostName());
						// port number
						url.append(':');
						url.append(dataConConnectionsDO.getPortNo());
						// sid/service/db name
						url.append('/');
						url.append(dataConConnectionsDO.getSid());

					}
				}// build url end
			}
			return url;
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

}
