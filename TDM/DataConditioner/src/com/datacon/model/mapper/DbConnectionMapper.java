package com.datacon.model.mapper;

import java.util.List;

import com.datacon.exception.ServiceException;
import com.datacon.model.DO.DataConConnectionsDO;
import com.datacon.model.DTO.DbConnectionsDTO;

public interface DbConnectionMapper
{

	public DataConConnectionsDO convertDbConnectionsDTOtoDataConConnectionsDO(
			DbConnectionsDTO dbConnectionsDTO);

	public DbConnectionsDTO convertDataConConnectionsDOtoDbConnectionsDTO(
			DataConConnectionsDO dataConConnectionsDO, DbConnectionsDTO dbConnectionsDTO);

	public StringBuffer getUrl(DbConnectionsDTO dbConnectionsDTO, StringBuffer url)
			throws ServiceException;

	public List<DbConnectionsDTO> convertDataConConnectionsDOstoDbConnectionsDTOs(
			List<DataConConnectionsDO> dataConConnectionsDO,
			List<DbConnectionsDTO> dbConnectionsDTOs);
}
