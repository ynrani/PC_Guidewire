package com.tesda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.dao.TDMAdminDAO;
import com.tesda.email.EmailNotificationService;
import com.tesda.exception.DAOException;
import com.tesda.exception.ServiceException;
import com.tesda.model.DTO.TdmUserDTO;
import com.tesda.model.mapper.TDMUserMapper;
import com.tesda.service.TDMAdminService;

@Component
@Service("tDMAdminService")
@Transactional(propagation = Propagation.REQUIRED)
public class TDMAdminServiceImpl implements TDMAdminService
{

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
		} catch (DAOException de)
		{
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
		} catch (DAOException de)
		{
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
		} catch (DAOException de)
		{
			throw new ServiceException(de.getMessage());
		}
	}

	@Override
	public String deleteUserByUserId(String userId) throws ServiceException
	{
		try
		{
			return tDMAdminDAO.deleteUserByUserId(userId);
		} catch (DAOException de)
		{
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
		} catch (DAOException de)
		{
			throw new ServiceException(de.getMessage());
		}
	}

	@Override
	public boolean validateUserId(String userid) throws ServiceException
	{
		try
		{
			return tDMAdminDAO.validateUserId(userid);
		} catch (DAOException de)
		{
			throw new ServiceException(de.getMessage());
		}
	}

}
