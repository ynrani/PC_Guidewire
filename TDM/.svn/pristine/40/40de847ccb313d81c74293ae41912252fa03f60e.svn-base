package com.tdm.service;

import java.util.List;

import com.tdm.exception.ServiceException;
import com.tdm.model.DO.TdmUserDO;
import com.tdm.model.DTO.ForgotPassword;
import com.tdm.model.DTO.TdmUserDTO;

public interface TDMAdminService
{
	public Boolean forgotPassword(ForgotPassword forgotPasswordDTO) throws ServiceException;

	public String saveUserDetails(TdmUserDTO userdo, boolean bEdit) throws ServiceException;

	public List<TdmUserDTO> getAllUser(TdmUserDTO userdo, int offSet, int recordsperpage, boolean b)
			throws ServiceException;

	public TdmUserDTO getEditUser(String userId) throws ServiceException;

	public String deleteUserByUserId(String userId) throws ServiceException;

	public Long searchUserRecordsCount(TdmUserDTO userdo) throws ServiceException;

	public boolean validateUserId(String userid) throws ServiceException;

	public String getUserRole(TdmUserDO userdo) throws ServiceException;
}
