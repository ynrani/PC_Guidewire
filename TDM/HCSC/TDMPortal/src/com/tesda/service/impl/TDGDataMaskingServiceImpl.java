/*---------------------------------------------------------------------------------------
 * Object Name: TDGDataMaskingServiceImpl.Java
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.constants.TDMConstants;
import com.tesda.constants.TDMExceptionCode;
import com.tesda.dao.TDMDataMaskingDAO;
import com.tesda.exception.DAOException;
import com.tesda.exception.ServiceException;
import com.tesda.model.DO.ReqChDO;
import com.tesda.model.DO.RequestorDO;
import com.tesda.model.DO.TdmOnboardReqDO;
import com.tesda.model.DTO.TdgDataMaskingDTO;
import com.tesda.model.DTO.TdgDataMaskingNoOfAppsDTO;
import com.tesda.model.DTO.TdmOnBoardReqDTO;
import com.tesda.model.mapper.TDMDataMaskingMapper;
import com.tesda.model.mapper.TDMProviderSearchMapper;
import com.tesda.service.TDMDataMaskingService;

@Component
@Service(TDMConstants.DATAMASKING_SERVICE)
@Transactional(propagation = Propagation.REQUIRED)
public class TDGDataMaskingServiceImpl extends TdmBaseServiceImpl implements TDMDataMaskingService
{

	private static final Logger logger = LoggerFactory.getLogger(TDGDataMaskingServiceImpl.class);

	@Autowired
	TDMDataMaskingDAO tDMDataMaskingDAO;

	@Autowired
	TDMDataMaskingMapper tdmDataMaskingMapper;

	@Autowired
	TDMProviderSearchMapper tdmProvMapper;

	@Override
	public Long getReservedRecordsCount(String userId, String type) throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			Long lResult = tDMDataMaskingDAO
					.getDataMaskingRecordsCount(userId, type, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			return lResult;
		}
		catch (NullPointerException ex)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_1, de);
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}
	}

	@Override
	public TdgDataMaskingDTO saveReqDtls(TdgDataMaskingDTO tdgDataMaskingDTO, boolean page1,
			boolean page2, boolean page3) throws ServiceException
	{
		RequestorDO requestorDO = null;
		String seq = null;
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			if (page1 && StringUtils.isEmpty(tdgDataMaskingDTO.getEdit()))
			{
				if (StringUtils.isEmpty(tdgDataMaskingDTO.getId()))
				{
					seq = tDMDataMaskingDAO.maskingRecId(managerDtmask);
				}
			}
			requestorDO = tDMDataMaskingDAO.getSavedDtls(tdgDataMaskingDTO.getId(), managerDtmask);
			managerDtmask.clear();
			requestorDO = tdmDataMaskingMapper.convertMaskDTOtoDO(requestorDO, tdgDataMaskingDTO,
					seq, page1, page2, page3, false);
			requestorDO = tDMDataMaskingDAO.getSaveReqDtls(requestorDO, managerDtmask);
			tdgDataMaskingDTO.setId(requestorDO.getId());
			closeDataMaskingEntityManager(managerDtmask);
			return tdgDataMaskingDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			throw new ServiceException(TDMExceptionCode.EXCEPTION, otherEx);
		}
	}

	@Override
	public TdgDataMaskingDTO getSavedDtls(TdgDataMaskingDTO tdgDataMaskingDTO, boolean page1,
			boolean page2, boolean page3) throws ServiceException
	{
		RequestorDO requestorDO = null;
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			requestorDO = tDMDataMaskingDAO.getSavedDtls(tdgDataMaskingDTO.getId(), managerDtmask);
			tdgDataMaskingDTO = tdmDataMaskingMapper.convertDOtoMaskDTO(tdgDataMaskingDTO,
					requestorDO, page1, page2, page3);
			closeDataMaskingEntityManager(managerDtmask);
			if (null != tdgDataMaskingDTO)
			{
				if (null == tdgDataMaskingDTO.getTdgDataMaskingNoOfAppsDTOs())
				{
					List<TdgDataMaskingNoOfAppsDTO> tdgDataMaskingNoOfAppsDTOs = new ArrayList<TdgDataMaskingNoOfAppsDTO>();
					TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO = new TdgDataMaskingNoOfAppsDTO();
					tdgDataMaskingNoOfAppsDTOs.add(tdgDataMaskingNoOfAppsDTO);
					tdgDataMaskingDTO.setTdgDataMaskingNoOfAppsDTOs(tdgDataMaskingNoOfAppsDTOs);
				}
			}
			return tdgDataMaskingDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			throw new ServiceException(TDMExceptionCode.EXCEPTION, otherEx);
		}
	}

	@Override
	public TdgDataMaskingDTO getAllDtMaskRequestedRecord(String userId) throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			List<RequestorDO> requestorDOs = tDMDataMaskingDAO.getAllDtMaskRequestedRecord(userId,
					managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			return tdmProvMapper.converDOtoRequestorDTO(requestorDOs);
		}
		catch (NullPointerException ex)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_3, de);
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}
	}

	@Override
	public TdgDataMaskingDTO getDtMaskRequestedRecord(String userId, String reqId)
			throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			Map<RequestorDO, List<ReqChDO>> map = tDMDataMaskingDAO.getDtMaskRequestedRecord(
					managerDtmask, userId, reqId);
			closeDataMaskingEntityManager(managerDtmask);
			return tdmProvMapper.converDOtoRequestDTOForReqId(map);
		}
		catch (NullPointerException ex)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_4, de);
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}

	}

	@Override
	public TdgDataMaskingDTO getAllDtMaskRequestedRecordForPagination(int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, TdgDataMaskingDTO tdgDataMaskingDTO,
			String type) throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			List<RequestorDO> requestorDOs = tDMDataMaskingDAO.searchDataMaskingRecords(offSet,
					recordsperpage, pageNationOnOffFlag, tdgDataMaskingDTO.getUserId(), type,
					managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			return tdmDataMaskingMapper.convertDOtoMaskDTOs(tdgDataMaskingDTO, requestorDOs, true,
					true, true);
		}
		catch (NullPointerException nullPointerEx)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			throw new ServiceException(TDMExceptionCode.EXCEPTION, otherEx);
		}
	}

	@Override
	public TdgDataMaskingDTO getUserDetails(TdgDataMaskingDTO tdgDataMaskingDTO)
			throws ServiceException
	{
		try
		{
			EntityManager managerUser = openUserEntityManager();
			tdgDataMaskingDTO = tDMDataMaskingDAO.getUserDetails(managerUser,
					tdgDataMaskingDTO.getUserId());
			closeDataMaskingEntityManager(managerUser);
			return tdgDataMaskingDTO;
		}
		catch (NullPointerException ex)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_6, de);
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}
	}

	@Override
	public TdmOnBoardReqDTO getUserDetails(String userId, TdmOnBoardReqDTO tdmOnBoardReqDTO)
			throws ServiceException
	{
		try
		{
			EntityManager managerUser = openUserEntityManager();
			tdmOnBoardReqDTO = tDMDataMaskingDAO.getUserDetailsOnboard(userId, managerUser,
					tdmOnBoardReqDTO);
			closeUserEntityManager(managerUser);
			List<TdgDataMaskingNoOfAppsDTO> tdgDataMaskingNoOfAppsDTOs = new ArrayList<TdgDataMaskingNoOfAppsDTO>();
			TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO = new TdgDataMaskingNoOfAppsDTO();
			tdgDataMaskingNoOfAppsDTOs.add(tdgDataMaskingNoOfAppsDTO);
			tdmOnBoardReqDTO.setTdgDataMaskingNoOfAppsDTOs(tdgDataMaskingNoOfAppsDTOs);
			return tdmOnBoardReqDTO;
		}
		catch (NullPointerException ex)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_7, de);
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}
	}

	@Override
	public TdmOnBoardReqDTO getSaveOnboardingReq(TdmOnBoardReqDTO tdmOnboardReqDTO)
			throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			String seq = null;
			if (StringUtils.isEmpty(tdmOnboardReqDTO.getOnboardReqId()))
			{
				seq = tDMDataMaskingDAO.onBoardingRecId(managerDtmask);
			}
			TdmOnboardReqDO tdmOnboardReqDO = tdmDataMaskingMapper.convertTdmOnBoardReqDTOToDO(
					tdmOnboardReqDTO, seq);
			tdmOnboardReqDO = tDMDataMaskingDAO
					.getSaveOnboardingReq(managerDtmask, tdmOnboardReqDO);
			tdmOnboardReqDTO.setOnboardReqId(tdmOnboardReqDO.getOnboardReqId());
			closeDataMaskingEntityManager(managerDtmask);
			return tdmOnboardReqDTO;
		}
		catch (NullPointerException ex)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_8, de);
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}
	}

	@Override
	public TdmOnBoardReqDTO getEditableDetails(String reqId) throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			TdmOnboardReqDO tdmOnboardReqDO = tDMDataMaskingDAO.getEditableDetails(managerDtmask,
					reqId);
			TdmOnBoardReqDTO tdmOnboardReqDTO = tdmDataMaskingMapper
					.convertTdmOnboardReqDOToDO(tdmOnboardReqDO);
			closeDataMaskingEntityManager(managerDtmask);
			return tdmOnboardReqDTO;
		}
		catch (NullPointerException ex)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_9, de);
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}
	}

	@Override
	public List<String> getReqIdList(String userId, String reqIdtoken) throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			List<String> reqIds = null;
			List<String> reqList = tDMDataMaskingDAO
					.getReqIdList(userId, managerDtmask, reqIdtoken);
			if (null != reqList && 0 < reqList.size())
			{
				reqIds = filterReqIDs(reqList);
			}
			closeDataMaskingEntityManager(managerDtmask);
			return reqIds;
		}
		catch (NullPointerException ex)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_10, de);
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}

	}

	@Override
	public Long getReservedRecordsCountOnBoard(String userId, String type) throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			Long lResult = tDMDataMaskingDAO.getOnBoardingRecordsCount(userId, type, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			return lResult;
		}
		catch (NullPointerException ex)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_11, de);
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}
	}

	@Override
	public List<TdgDataMaskingDTO> getAllOnBoardRequestedRecordForPagination(int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, String userId, String type)
			throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			List<TdmOnboardReqDO> requestorDOs = tDMDataMaskingDAO.searchOnBoardingRecords(offSet,
					recordsperpage, pageNationOnOffFlag, userId, type, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			return tdmDataMaskingMapper.converTdmOnboardReqDOtoDTO(requestorDOs);
		}
		catch (NullPointerException ex)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_12, de);
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}
	}

	@Override
	public boolean cancelOnBoardingRequest(String reqId) throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			boolean isConcelled = tDMDataMaskingDAO.cancelOnBoardingReq(managerDtmask, reqId);
			closeDataMaskingEntityManager(managerDtmask);
			return isConcelled;
		}
		catch (NullPointerException ex)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_12, de);
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}
	}

	@Override
	public boolean cancelMaskingRequest(String reqId) throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			boolean isConcelled = tDMDataMaskingDAO.cancelMaskingReq(managerDtmask, reqId);
			closeDataMaskingEntityManager(managerDtmask);
			return isConcelled;
		}
		catch (NullPointerException ex)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_12, de);
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}
	}

	public List<String> filterReqIDs(List<String> reqList)
	{
		List<String> reqIds = new ArrayList<String>();
		String reqId = "";
		for (String s : reqList)
		{
			if (!s.contains(TDMConstants.CR))
			{
				reqId = s;
				int max = 0;
				for (String s1 : reqList)
				{
					if (s1.contains(TDMConstants.CR) && s1.startsWith(s))
					{
						int id = Integer.parseInt(s1.split(TDMConstants.CR)[1]);
						if (max < id)
						{
							max = id;
							reqId = s1;
						}
					}
				}
				reqIds.add(reqId);
			}
		}
		return reqIds;
	}

	@Override
	public TdgDataMaskingDTO getSavedDtlsforExport(TdgDataMaskingDTO tdgDataMaskingDTO,
			boolean page1, boolean page2, boolean page3, String type) throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			List<RequestorDO> requestorDOs = tDMDataMaskingDAO.getSavedDtlsforExport(
					tdgDataMaskingDTO.getUserId(), type, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			return tdmDataMaskingMapper.convertDOtoMaskDTOs(tdgDataMaskingDTO, requestorDOs, true,
					true, true);
		}
		catch (NullPointerException nullPointerEx)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			throw new ServiceException(TDMExceptionCode.EXCEPTION, otherEx);
		}
	}
}
