package com.datacon.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.jdbc.core.JdbcTemplate;

import com.datacon.exception.DAOException;
import com.datacon.model.DO.DataConConnectionsDO;

public interface UploadDAO
{
	public List<DataConConnectionsDO> getAvilableDBs(String userId, EntityManager managerUser)
			throws DAOException;

	public JdbcTemplate getTemplate(String strUrl, String strUsername, String strPassword)
			throws DAOException;

	public List<Object> getTables(JdbcTemplate jdbcTemplate, String tableName) throws DAOException;

	public List<String> getAllTables(String url, String username, String password)
			throws DAOException;

	public List<Object> generateSequenceOfTables(JdbcTemplate jdbcTemplate, String tableName)
			throws DAOException;

	public List<DataConConnectionsDO> getSelctedConnections(String dataConConnIds,
			EntityManager managerUser) throws DAOException;

	public DataConConnectionsDO getSelctedConnection(String dataConConnIds,
			EntityManager managerUser) throws DAOException;

}
