/*---------------------------------------------------------------------------------------
 * Object Name: TDMNonStandSearchServiceImpl.Java
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.constants.TDMConstants;
import com.tesda.constants.TDMExceptionCode;
import com.tesda.dao.TDMNonStandSearchDao;
import com.tesda.exception.DAOException;
import com.tesda.exception.ServiceException;
import com.tesda.model.DO.TdmLookupDO;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DO.TdmSubscriberDetailsDO;
import com.tesda.model.DTO.TDMNonStandReservationDTO;
import com.tesda.model.DTO.TDMNonStandSearchFieldsDTO;
import com.tesda.model.DTO.TDMNonStandardSearchDTO;
import com.tesda.model.DTO.TdmNonStandardSearchResultListDTO;
import com.tesda.model.mapper.TDMNonStandardSearchMapper;
import com.tesda.service.TDMNonStandSearchService;

@Component
@Service(TDMConstants.NONSTAND_SEARCH_MGMT_SERVICE)
@Transactional(propagation = Propagation.REQUIRED)
public class TDMNonStandSearchServiceImpl extends TdmBaseServiceImpl implements
		TDMNonStandSearchService
{

	private static final Logger logger = LoggerFactory
			.getLogger(TDMNonStandSearchServiceImpl.class);

	@Autowired
	TDMNonStandSearchDao tDMNonStandSearchDAO;
	@Autowired
	TDMNonStandardSearchMapper tdmNonStandSrchmapr;

	@Override
	public TDMNonStandSearchFieldsDTO getSearchFields() throws ServiceException
	{
		try
		{
			EntityManager managerLookup = openUserEntityManager();
			TDMNonStandSearchFieldsDTO nonStandSrchFldsDTO = new TDMNonStandSearchFieldsDTO();;
			List<TdmLookupDO> nonStandFields = tDMNonStandSearchDAO
					.getTDMSearchFields(managerLookup);
			devideSearchFileds(nonStandFields, nonStandSrchFldsDTO);
			closeUserEntityManager(managerLookup);
			return nonStandSrchFldsDTO;
		}
		catch (NullPointerException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_19, de);
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, de);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_20, de);
			throw new ServiceException(de.getMessage());
		}
	}

	@Override
	public TDMNonStandardSearchDTO getNonStandSearchRecords(TDMNonStandardSearchDTO tdmSearchDTO,
			int offSet, int recordsperpage) throws ServiceException
	{
		try
		{
			EntityManager subscriberManager = openSubscriberEntityManager();
			List<TdmSubscriberDetailsDO> subsrcDo = tDMNonStandSearchDAO
					.getTDMNonStandSearchRecords(tdmSearchDTO, offSet, recordsperpage,
							subscriberManager);
			List<TdmNonStandardSearchResultListDTO> tdmNonStandSearchDTOList = tdmNonStandSrchmapr
					.converTdmSbscrDtlsDOtoTDMNonStandardSearchDTO(subsrcDo);
			tdmSearchDTO.setTdmNonStandardSrchResultListDTOs(tdmNonStandSearchDTOList);
			closeSubscriberEntityManager(subscriberManager);
			return tdmSearchDTO;
		}
		catch (NullPointerException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_21, de);
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, de);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_22, de);
			throw new ServiceException(de.getMessage());
		}
	}

	@Override
	public int saveReservedData(TDMNonStandardSearchDTO tdmNonSrchDTO, String userId)
			throws ServiceException
	{
		try
		{
			EntityManager usrManager = openDataMaskingEntityManager();
			List<TdmReservationDO> tdmResrvationDoList = tdmNonStandSrchmapr
					.converTDMNonStandardSearchDTOtoTdmReservationDO(tdmNonSrchDTO, userId);
			tDMNonStandSearchDAO.saveReserveData(tdmResrvationDoList,
					tdmNonSrchDTO.getTestCaseName(), tdmNonSrchDTO.getTestCaseId(), usrManager);
			closeUserEntityManager(usrManager);
			return tdmResrvationDoList.size();
		}
		catch (NullPointerException ex)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_23, de);
			throw new ServiceException(de.getMessage());
		}
	}

	@Override
	public List<TDMNonStandReservationDTO> getReservedRecords(String userId)
			throws ServiceException
	{
		try
		{
			EntityManager managerUsr = openDataMaskingEntityManager();
			List<TdmReservationDO> reservedList = tDMNonStandSearchDAO.getReservedRecords(userId,
					managerUsr);
			List<TDMNonStandReservationDTO> tdmReservedList = tdmNonStandSrchmapr
					.convertReservationDosToResvationDTO(reservedList);
			closeDataMaskingEntityManager(managerUsr);
			return tdmReservedList;
		}
		catch (NullPointerException ex)
		{
			ex.printStackTrace();
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_24, de);
			throw new ServiceException(de.getMessage());
		}
	}

	@Override
	public int unReserveReservedRecords(TDMNonStandardSearchDTO tdmNonStandUnreserve, String userId)
			throws ServiceException
	{
		try
		{
			EntityManager managerUsr = openDataMaskingEntityManager();
			List<TdmReservationDO> unreservedList = tdmNonStandSrchmapr
					.convertReservationDTOsToResvationDO(tdmNonStandUnreserve);
			tDMNonStandSearchDAO.unReserveResrvedRecords(unreservedList, userId, managerUsr);
			closeUserEntityManager(managerUsr);
			return unreservedList.size();
		}
		catch (NullPointerException ex)
		{
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (DAOException de)
		{
			throw new ServiceException(de.getMessage());
		}
	}

	public void devideSearchFileds(List<TdmLookupDO> nonStandFields,
			TDMNonStandSearchFieldsDTO nonStandSrchFldsDTO)
	{
		Set<String> planType = new TreeSet<String>();
		Set<String> claimType = new TreeSet<String>();
		Set<String> memCatList = new TreeSet<String>();
		Set<String> coverageType = new TreeSet<String>();
		Set<String> memStatus = new TreeSet<String>();
		Set<String> stateList = new TreeSet<String>();
		Set<String> subscRelation = new TreeSet<String>();
		Set<String> ageGroup = new TreeSet<String>();
		for (TdmLookupDO tdmLookup : nonStandFields)
		{
			if (tdmLookup.getListValName().equalsIgnoreCase(TDMConstants.PLAN_TYPE))
			{
				planType.add(tdmLookup.getListValue());
			}
			else if (tdmLookup.getListValName().equalsIgnoreCase(TDMConstants.CLAIM_TYPE))
			{
				claimType.add(tdmLookup.getListValue());
			}
			else if (tdmLookup.getListValName().equalsIgnoreCase(TDMConstants.MEM_CATEGORY))
			{
				memCatList.add(tdmLookup.getListValue());
			}
			else if (tdmLookup.getListValName().equalsIgnoreCase(TDMConstants.COVERAGE_TYPE))
			{
				coverageType.add(tdmLookup.getListValue());
			}
			else if (tdmLookup.getListValName().equalsIgnoreCase(TDMConstants.MEM_STATUS))
			{
				memStatus.add(tdmLookup.getListValue());
			}
			else if (tdmLookup.getListValName().equalsIgnoreCase(TDMConstants.STATE))
			{
				stateList.add(tdmLookup.getListValue());
			}
			else if (tdmLookup.getListValName().equalsIgnoreCase(TDMConstants.SUBSCR_RELATION))
			{
				subscRelation.add(tdmLookup.getListValue());
			}
			else if (tdmLookup.getListValName().equalsIgnoreCase(TDMConstants.AGE_GROUP))
			{
				ageGroup.add(tdmLookup.getListValue());
			}
		}

		nonStandSrchFldsDTO.setClaimTypes(claimType);
		nonStandSrchFldsDTO.setAgeGroups(ageGroup);
		nonStandSrchFldsDTO.setCoverageTypes(coverageType);
		nonStandSrchFldsDTO.setMemCatagories(memCatList);
		nonStandSrchFldsDTO.setMemStatus(memStatus);
		nonStandSrchFldsDTO.setPlanTypes(planType);
		nonStandSrchFldsDTO.setStateTypes(stateList);
		nonStandSrchFldsDTO.setSubscRelations(subscRelation);
	}

	@Override
	public Set<String> getAccountNameNumberList(String type, String reqToken)
			throws ServiceException
	{
		try
		{
			EntityManager subscriberManager = openSubscriberEntityManager();
			List<String> resultList = tDMNonStandSearchDAO.getSubscriberAcNameNumDetails(type,
					reqToken, subscriberManager);
			if (type.equalsIgnoreCase(TDMConstants.AC_NUM)
					|| type.equalsIgnoreCase(TDMConstants.SUBSC_ID))
			{
				resultList = convertAcNumToList(resultList);
			}
			Set<String> resultSet = new HashSet<String>();
			resultSet.addAll(resultList);
			closeSubscriberEntityManager(subscriberManager);
			return resultSet;
		}
		catch (NullPointerException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_21, de);
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, de);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_22, de);
			throw new ServiceException(de.getMessage());
		}
	}

	@Override
	public long getNonStandardSearchRecordCount(TDMNonStandardSearchDTO tdmNonStandSearchDTO,
			String userId) throws ServiceException

	{
		try
		{
			EntityManager subscriberManager = openSubscriberEntityManager();
			Long count = tDMNonStandSearchDAO.getNonStandardSearchRecordCount(tdmNonStandSearchDTO,
					subscriberManager);
			closeSubscriberEntityManager(subscriberManager);
			return count;
		}
		catch (NullPointerException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_21, de);
			throw new ServiceException(TDMExceptionCode.NULL_POINTR, de);
		}
		catch (DAOException de)
		{
			logger.error(TDMConstants.TDMP_SERVICE_ERROR_22, de);
			throw new ServiceException(de.getMessage());
		}
	}

	public List<String> convertAcNumToList(List<String> resultList)
	{
		List<String> finalList = new ArrayList<String>();

		for (Object obj : resultList)
		{
			finalList.add(String.valueOf(obj));
		}

		return finalList;
	}
}
