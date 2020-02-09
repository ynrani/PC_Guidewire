package com.tesda.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.constants.TDMConstants;
import com.tesda.dao.TDGDataMaskingDAO;
import com.tesda.exception.DAOException;
import com.tesda.exception.ServiceException;
import com.tesda.model.DO.ReqChDO;
import com.tesda.model.DO.RequestorDO;
import com.tesda.model.DO.TdmOnboardReqDO;
import com.tesda.model.DTO.TdgDataMaskingDTO;
import com.tesda.model.DTO.TdmOnBoardReqDTO;
import com.tesda.model.mapper.TDMProviderSearchMapper;
import com.tesda.service.TDGDataMaskingService;

@Component
@Service("dataMaskingService")
@Transactional(propagation = Propagation.REQUIRED)
public class TDGDataMaskingServiceImpl extends TdmBaseServiceImpl implements TDGDataMaskingService
{

	@Autowired
	TDGDataMaskingDAO tDGDataMaskingDAO;

	@Autowired
	TDMProviderSearchMapper tDMProviderSearchMapper;

	@Override
	public Long getReservedRecordsCount(String userId, String type) throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			Long lResult = tDGDataMaskingDAO
					.getDataMaskingRecordsCount(userId, type, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			return lResult;
		}
		catch (DAOException de)
		{
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}
	}

	@Override
	public String saveMaskingData(TdgDataMaskingDTO tdgDataMaskingDTO) throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			String id = null;
			String seq = null;
			if (StringUtils.isEmpty(tdgDataMaskingDTO.getId()))
			{
				seq = tDGDataMaskingDAO.maskingRecId(managerDtmask);
			}
			RequestorDO requestorDO = tDMProviderSearchMapper.convertTDGDataMaskRequestToDO(
					tdgDataMaskingDTO, seq);
			id = tDGDataMaskingDAO.saveMaskingData(requestorDO, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			return id;
		}
		catch (DAOException de)
		{
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}
	}

	@Override
	public TdgDataMaskingDTO getAllDtMaskRequestedRecord(String userId) throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			List<RequestorDO> requestorDOs = tDGDataMaskingDAO.getAllDtMaskRequestedRecord(userId,
					managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			return tDMProviderSearchMapper.converDOtoRequestorDTO(requestorDOs);
		}
		catch (DAOException de)
		{
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
			Map<RequestorDO, List<ReqChDO>> map = tDGDataMaskingDAO.getDtMaskRequestedRecord(
					managerDtmask, userId, reqId);
			closeDataMaskingEntityManager(managerDtmask);
			return tDMProviderSearchMapper.converDOtoRequestDTOForReqId(map);
		}
		catch (DAOException de)
		{
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}

	}

	@Override
	public TdgDataMaskingDTO getAllDtMaskRequestedRecordForPagination(int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, String userId, String type)
			throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			List<RequestorDO> requestorDOs = tDGDataMaskingDAO.searchDataMaskingRecords(offSet,
					recordsperpage, pageNationOnOffFlag, userId, type, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			return tDMProviderSearchMapper.converDOtoRequestorDTO(requestorDOs);
		}
		catch (DAOException de)
		{
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}
	}

	@Override
	public TdgDataMaskingDTO getUserDetails(TdgDataMaskingDTO tdgDataMaskingDTO)
			throws ServiceException
	{
		try
		{
			EntityManager managerUser = openUserEntityManager();
			tdgDataMaskingDTO = tDGDataMaskingDAO.getUserDetails(managerUser,
					tdgDataMaskingDTO.getUserId());
			closeDataMaskingEntityManager(managerUser);
			return tdgDataMaskingDTO;
		}
		catch (DAOException de)
		{
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
			tdmOnBoardReqDTO = tDGDataMaskingDAO.getUserDetailsOnboard(userId, managerUser,
					tdmOnBoardReqDTO);
			closeUserEntityManager(managerUser);
			return tdmOnBoardReqDTO;
		}
		catch (DAOException de)
		{
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
				seq = tDGDataMaskingDAO.onBoardingRecId(managerDtmask);
			}
			TdmOnboardReqDO tdmOnboardReqDO = tDMProviderSearchMapper.convertTdmOnBoardReqDTOToDO(
					tdmOnboardReqDTO, seq);
			tdmOnboardReqDO = tDGDataMaskingDAO
					.getSaveOnboardingReq(managerDtmask, tdmOnboardReqDO);
			tdmOnboardReqDTO.setOnboardReqId(tdmOnboardReqDO.getOnboardReqId());
			closeDataMaskingEntityManager(managerDtmask);
			return tdmOnboardReqDTO;
		}
		catch (DAOException de)
		{
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}
	}

	@Override
	public TdmOnBoardReqDTO getEditableDetails(String reqId) throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			TdmOnboardReqDO tdmOnboardReqDO = tDGDataMaskingDAO.getEditableDetails(managerDtmask,
					reqId);
			TdmOnBoardReqDTO tdmOnboardReqDTO = tDMProviderSearchMapper
					.convertTdmOnboardReqDOToDO(tdmOnboardReqDO);
			closeDataMaskingEntityManager(managerDtmask);
			return tdmOnboardReqDTO;
		}
		catch (DAOException de)
		{
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
			List<String> reqList = tDGDataMaskingDAO
					.getReqIdList(userId, managerDtmask, reqIdtoken);
			if (null != reqList && 0 < reqList.size())
			{
				reqIds = filterReqIDs(reqList);
			}
			closeDataMaskingEntityManager(managerDtmask);
			return reqIds;
		}
		catch (DAOException de)
		{
			throw new ServiceException(de.getErrorCode(), de.getMessage());
		}

	}

	@Override
	public Long getReservedRecordsCountOnBoard(String userId, String type) throws ServiceException
	{
		try
		{
			EntityManager managerDtmask = openDataMaskingEntityManager();
			Long lResult = tDGDataMaskingDAO.getOnBoardingRecordsCount(userId, type, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			return lResult;
		}
		catch (DAOException de)
		{
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
			List<TdmOnboardReqDO> requestorDOs = tDGDataMaskingDAO.searchOnBoardingRecords(offSet,
					recordsperpage, pageNationOnOffFlag, userId, type, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			return tDMProviderSearchMapper.converTdmOnboardReqDOtoDTO(requestorDOs);
		}
		catch (DAOException de)
		{
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
}
