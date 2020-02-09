/*---------------------------------------------------------------------------------------
 * Object Name: TDMUserMapperImp.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          12/06/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tdm.model.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tdm.constant.MessageConstant;
import com.tdm.exception.ServiceException;
import com.tdm.model.DO.TdmUserDO;
import com.tdm.model.DO.TdmUsersAuthDO;
import com.tdm.model.DTO.TdmUserAuthDTO;
import com.tdm.model.DTO.TdmUserDTO;
import com.tdm.model.mapper.TDMUserMapper;

/**
 * 
 * @author Seshadri Chowdary
 *
 */
@Component
@Service(MessageConstant.MAPPER_ADMIN)
public class TDMUserMapperImp implements TDMUserMapper
{
	private static Logger logger = Logger.getLogger(TDMUserMapperImp.class);

	@Override
	public TdmUserDTO converTdmUserDOToUserSearchResultDTO(TdmUserDO tdmUserDo,
			TdmUsersAuthDO tdmUsersAuthDo) throws ServiceException {
		logger.info(MessageConstant.TDM_ADMIN_MAPPER + MessageConstant.TDM_ADMIN_MAPPER_DO_TO_DTO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			TdmUserDTO tdmUserDTO = new TdmUserDTO();
			TdmUserAuthDTO tdmUserAuthDTO = new TdmUserAuthDTO();
			tdmUserDTO.setCreated(false);
			tdmUserDTO.setEmailId(tdmUserDo.getEmailId());
			tdmUserDTO.setMobileNo(tdmUserDo.getMobileNo());
			tdmUserDTO.setPassword(tdmUserDo.getPassword());
			tdmUserDTO.setUserId(tdmUserDo.getUserId());
			tdmUserDTO.setUsername(tdmUserDo.getUsername());
			tdmUserDTO.setEnabled(tdmUserDo.getEnabled());
			tdmUserAuthDTO.setTdmUserDTO(tdmUserDTO);
			if (tdmUsersAuthDo != null)
				tdmUserAuthDTO.setRole(tdmUsersAuthDo.getRole());
			tdmUserDTO.setTdmUserAuthDTO(tdmUserAuthDTO);
			logger.info(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DO_TO_DTO + MessageConstant.LOG_INFO_RETURN);
			return tdmUserDTO;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmUserDTO converTdmUserDOToUserSearchResultDTO(TdmUserDO tdmUserDo)
			throws ServiceException {
		logger.info(MessageConstant.TDM_ADMIN_MAPPER + MessageConstant.TDM_ADMIN_MAPPER_DO_TO_DTO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			TdmUserDTO tdmUserDTO = new TdmUserDTO();
			TdmUserAuthDTO tdmUserAuthDTO = new TdmUserAuthDTO();
			tdmUserDTO.setCreated(false);
			tdmUserDTO.setEmailId(tdmUserDo.getEmailId());
			tdmUserDTO.setMobileNo(tdmUserDo.getMobileNo());
			tdmUserDTO.setPassword(tdmUserDo.getPassword());
			tdmUserDTO.setUserId(tdmUserDo.getUserId());
			tdmUserDTO.setUsername(tdmUserDo.getUsername());
			tdmUserDTO.setEnabled(tdmUserDo.getEnabled());
			tdmUserAuthDTO.setTdmUserDTO(tdmUserDTO);
			if (tdmUserDo.getTdmUsersAuths() != null)
				tdmUserAuthDTO.setRole(tdmUserDo.getTdmUsersAuths().getRole());
			tdmUserDTO.setTdmUserAuthDTO(tdmUserAuthDTO);
			logger.info(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DO_TO_DTO + MessageConstant.LOG_INFO_RETURN);
			return tdmUserDTO;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmUserDTO> converTdmUserDOToUserSearchResultListDTO(List<TdmUserDO> listTdmUserDo)
			throws ServiceException {
		logger.info(MessageConstant.TDM_ADMIN_MAPPER + MessageConstant.TDM_ADMIN_MAPPER_DO_TO_DTOs
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			List<TdmUserDTO> listTdmUserDTO = new ArrayList<TdmUserDTO>();
			for (TdmUserDO tdmUserDO : listTdmUserDo) {
				listTdmUserDTO.add(converTdmUserDOToUserSearchResultDTO(tdmUserDO));
			}
			logger.info(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DO_TO_DTOs + MessageConstant.LOG_INFO_RETURN);
			return listTdmUserDTO;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DO_TO_DTOs
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DO_TO_DTOs
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmUserDO converTdmUserDTOToUserDO(TdmUserDTO tdmUserDTo, TdmUserAuthDTO tdmUsersAuthDo)
			throws ServiceException {
		logger.info(MessageConstant.TDM_ADMIN_MAPPER + MessageConstant.TDM_ADMIN_MAPPER_DTO_TO_DO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			TdmUserDO tdmUserDO = new TdmUserDO();
			TdmUsersAuthDO tdmUsersAuthDO = new TdmUsersAuthDO();
			tdmUserDO.setEmailId(tdmUserDTo.getEmailId());
			tdmUserDO.setMobileNo(tdmUserDTo.getMobileNo());
			tdmUserDO.setPassword(tdmUserDTo.getPassword());
			tdmUserDO.setUserId(tdmUserDTo.getUserId());
			tdmUserDO.setUsername(tdmUserDTo.getUsername());
			tdmUserDO.setEnabled(tdmUserDTo.getEnabled());
			tdmUsersAuthDO.setTdmUser(tdmUserDO);
			if (tdmUsersAuthDo != null)
				tdmUsersAuthDO.setRole(tdmUsersAuthDo.getRole());
			tdmUserDO.setTdmUsersAuths(tdmUsersAuthDO);
			logger.info(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DTO_TO_DO + MessageConstant.LOG_INFO_RETURN);
			return tdmUserDO;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmUserDO converTdmUserDTOToUserDO(TdmUserDTO tdmUserDTO) throws ServiceException {
		logger.info(MessageConstant.TDM_ADMIN_MAPPER + MessageConstant.TDM_ADMIN_MAPPER_DTO_TO_DO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			TdmUserDO tdmUserDO = new TdmUserDO();
			TdmUsersAuthDO tdmUsersAuthDO = new TdmUsersAuthDO();
			TdmUserAuthDTO tdmUserAuthDTO = tdmUserDTO.getTdmUserAuthDTO();
			tdmUserDO.setEmailId(tdmUserDTO.getEmailId());
			tdmUserDO.setMobileNo(tdmUserDTO.getMobileNo());
			tdmUserDO.setPassword(tdmUserDTO.getPassword());
			tdmUserDO.setUserId(tdmUserDTO.getUserId());
			tdmUserDO.setUsername(tdmUserDTO.getUsername());
			tdmUserDO.setEnabled(tdmUserDTO.getEnabled());
			tdmUsersAuthDO.setTdmUser(tdmUserDO);
			if (tdmUserAuthDTO != null)
				tdmUsersAuthDO.setRole(tdmUserAuthDTO.getRole());
			tdmUserDO.setTdmUsersAuths(tdmUsersAuthDO);
			logger.info(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DTO_TO_DO + MessageConstant.LOG_INFO_RETURN);
			return tdmUserDO;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmUserDO> converTdmUserDTOToUserDO(List<TdmUserDTO> listTdmUserDTO)
			throws ServiceException {
		logger.info(MessageConstant.TDM_ADMIN_MAPPER + MessageConstant.TDM_ADMIN_MAPPER_DTO_TO_DO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			List<TdmUserDO> listTdmUserDo = new ArrayList<TdmUserDO>();
			for (TdmUserDTO tdmUserDTO : listTdmUserDTO) {
				listTdmUserDo.add(converTdmUserDTOToUserDO(tdmUserDTO));
			}
			logger.info(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DTO_TO_DO + MessageConstant.LOG_INFO_RETURN);
			return listTdmUserDo;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_MAPPER
					+ MessageConstant.TDM_ADMIN_MAPPER_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

}
