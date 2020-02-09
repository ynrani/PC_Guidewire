package com.datacon.service;

import java.util.List;

import com.datacon.exception.ServiceException;
import com.datacon.model.DTO.DbConnectionsDTO;

public interface DbConnectionService
{

	public String testConnection(DbConnectionsDTO dbConnectionsDTO) throws ServiceException;

	public DbConnectionsDTO saveConnection(DbConnectionsDTO dbConnectionsDTO)
			throws ServiceException;

	public DbConnectionsDTO savedConnection(String dataConConnId) throws ServiceException;

	public boolean deleteConnection(String conId) throws ServiceException;

	public Long connectionsDashboardCount(String attribute) throws ServiceException;

	public List<DbConnectionsDTO> connectionsDashboard(int offSet, int recordsperpage, boolean b,
			String attribute) throws ServiceException;

}
