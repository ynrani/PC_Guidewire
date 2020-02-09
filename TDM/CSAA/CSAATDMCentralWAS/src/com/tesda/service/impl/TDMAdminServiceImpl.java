package com.tesda.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.dao.TDMAdminDAO;
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

	final static Logger logger = Logger.getLogger(TDMAdminServiceImpl.class);

	@Autowired
	TDMAdminDAO tDMAdminDAO;

	@Autowired
	TDMUserMapper tdmUserMapper;

	@Autowired
	private MessageSource messageSource;

	@Override
	public String saveUserDetails(TdmUserDTO userdo, boolean bEdit) throws ServiceException {
		try {
			return tDMAdminDAO.saveUserDetails(tdmUserMapper.converTdmUserDTOToUserDO(userdo),
					bEdit);
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO Exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}
	}

	@Override
	public List<TdmUserDTO> getAllUser(TdmUserDTO userdo, int offSet, int recordsperpage, boolean b) {
		return tdmUserMapper.converTdmUserDOToUserSearchResultListDTO(tDMAdminDAO.getAllUser(
				tdmUserMapper.converTdmUserDTOToUserDO(userdo), offSet, recordsperpage, b));
	}

	@Override
	public TdmUserDTO getEditUser(String userId) throws ServiceException {
		try {
			return tdmUserMapper.converTdmUserDOToUserSearchResultDTO(tDMAdminDAO
					.getEditUser(userId));
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO Exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}

	}

	@Override
	public String deleteUserByUserId(String userId) throws ServiceException {
		try {
			return tDMAdminDAO.deleteUserByUserId(userId);
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO Exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}

	}

	@Override
	public Long searchUserRecordsCount(TdmUserDTO userdo) throws ServiceException {
		try {

			return tDMAdminDAO.searchUserRecordsCount(tdmUserMapper
					.converTdmUserDTOToUserDO(userdo));
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO Exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}
	}

	@Override
	public boolean validateUserId(String userid) throws ServiceException {
		try {
			return tDMAdminDAO.validateUserId(userid);
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO Exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}
	}

}
