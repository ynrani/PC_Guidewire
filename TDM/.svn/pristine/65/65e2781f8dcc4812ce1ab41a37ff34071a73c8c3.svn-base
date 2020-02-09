/*---------------------------------------------------------------------------------------
 * Object Name: TDMAdminServiceImpl.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary   11/04/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tesda.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.constants.TDMConstants;
import com.tesda.dao.TDMAdminDAO;
import com.tesda.email.EmailNotificationService;
import com.tesda.exception.DAOException;
import com.tesda.exception.ServiceException;
import com.tesda.model.DTO.TdmUserDTO;
import com.tesda.model.mapper.TDMUserMapper;
import com.tesda.service.TDMAdminService;

@Component
@Service(TDMConstants.TDM_ADMIN_SERVICE)
@Transactional(propagation = Propagation.REQUIRED)
public class TDMAdminServiceImpl implements TDMAdminService
{

	private static final Logger logger = LoggerFactory.getLogger(TDMAdminServiceImpl.class);

	@Autowired
	TDMAdminDAO tDMAdminDAO;

	@Autowired
	TDMUserMapper tdmUserMapper;

	@Autowired
	EmailNotificationService emailNotificationService;

	@Override
	public String saveUserDetails(TdmUserDTO userdo, boolean bEdit) throws ServiceException
	{
		try
		{
			return tDMAdminDAO.saveUserDetails(tdmUserMapper.converTdmUserDTOToUserDO(userdo),
					bEdit);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_13, de);
			throw new ServiceException(de.getMessage());
		}

	}

	@Override
	public List<TdmUserDTO> getAllUser(TdmUserDTO userdo, int offSet, int recordsperpage, boolean b)
			throws ServiceException
	{
		try
		{
			return tdmUserMapper.converTdmUserDOToUserSearchResultListDTO(tDMAdminDAO.getAllUser(
					tdmUserMapper.converTdmUserDTOToUserDO(userdo), offSet, recordsperpage, b));
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_14, de);
			throw new ServiceException(de.getMessage());
		}
	}

	@Override
	public TdmUserDTO getEditUser(String userId) throws ServiceException
	{
		try
		{
			return tdmUserMapper.converTdmUserDOToUserSearchResultDTO(tDMAdminDAO
					.getEditUser(userId));
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_15, de);
			throw new ServiceException(de.getMessage());
		}
	}

	@Override
	public String deleteUserByUserId(String userId) throws ServiceException
	{
		try
		{
			return tDMAdminDAO.deleteUserByUserId(userId);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_16, de);
			throw new ServiceException(de.getMessage());
		}

	}

	@Override
	public Long searchUserRecordsCount(TdmUserDTO userdo) throws ServiceException
	{
		try
		{
			return tDMAdminDAO.searchUserRecordsCount(tdmUserMapper
					.converTdmUserDTOToUserDO(userdo));
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_17, de);
			throw new ServiceException(de.getMessage());
		}
	}

	@Override
	public boolean validateUserId(String userid) throws ServiceException
	{
		try
		{
			return tDMAdminDAO.validateUserId(userid);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_18, de);
			throw new ServiceException(de.getMessage());
		}
	}

}
