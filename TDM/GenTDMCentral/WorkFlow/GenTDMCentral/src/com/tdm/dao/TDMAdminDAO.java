package com.tdm.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.tdm.exception.DAOException;
import com.tdm.model.DO.TdmUserDO;

public interface TDMAdminDAO
{

	public String saveUserDetails(TdmUserDO userdo, boolean bEdit, EntityManager managerUser)
			throws DAOException;

	public List<TdmUserDO> getAllUser(TdmUserDO userdo, int offSet, int recordsperpage, boolean b,
			EntityManager managerUser) throws DAOException;

	public TdmUserDO getEditUser(String userId, EntityManager managerUser) throws DAOException;

	public String deleteUserByUserId(String userId, EntityManager managerUser) throws DAOException;

	public Long searchUserRecordsCount(TdmUserDO userdo, EntityManager managerUser)
			throws DAOException;

	boolean validateUserId(String userId, EntityManager managerUser) throws DAOException;

	public String getUserRole(TdmUserDO userdo, EntityManager managerUser) throws DAOException;
	
}
