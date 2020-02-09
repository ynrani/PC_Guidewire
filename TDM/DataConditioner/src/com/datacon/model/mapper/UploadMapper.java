package com.datacon.model.mapper;

import java.util.List;
import java.util.Map;

import com.datacon.exception.ServiceException;
import com.datacon.model.DO.DataConConnectionsDO;

public interface UploadMapper
{
	public Map<String, String> convertAvilableDBsMap(
			List<DataConConnectionsDO> dataConConnectionsDOs, Map<String, String> dbLists);

	public StringBuffer getUrl(DataConConnectionsDO dataConConnectionsDO, StringBuffer url)
			throws ServiceException;

}
