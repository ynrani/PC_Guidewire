package com.tesda.dao;

import java.util.List;

import com.tesda.exception.DAOException;
import com.tesda.model.DO.TdmUserDO;

public interface TDMAdminDAO
{

	public String saveUserDetails(TdmUserDO userdo, boolean bEdit) throws DAOException;

	public List<TdmUserDO> getAllUser(TdmUserDO userdo, int offSet, int recordsperpage, boolean b)
			throws DAOException;

	public TdmUserDO getEditUser(String userId) throws DAOException;

	public String deleteUserByUserId(String userId) throws DAOException;

	public Long searchUserRecordsCount(TdmUserDO userdo) throws DAOException;

	boolean validateUserId(String userId) throws DAOException;

}
