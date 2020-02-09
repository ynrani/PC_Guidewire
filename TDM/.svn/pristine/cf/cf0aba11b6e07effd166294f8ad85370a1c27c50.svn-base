package com.tesda.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.dao.TDMNonStandSearchDao;
import com.tesda.exception.DAOException;
import com.tesda.exception.ServiceException;
import com.tesda.model.DO.TdmLookupDO;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DO.TdmSubscriberDetailsDO;
import com.tesda.model.DTO.TDMNonStandardSearchDTO;
import com.tesda.model.DTO.TdmNonStandardSearchResultListDTO;
import com.tesda.model.mapper.TDMNonStandardSearchMapper;
import com.tesda.service.TDMNonStandSearchService;

@Component
@Service("nonStandsearchManagementService")
@Transactional(propagation = Propagation.REQUIRED)
public class TDMNonStandSearchServiceImpl extends TdmBaseServiceImpl implements
		TDMNonStandSearchService
{

	@Autowired
	TDMNonStandSearchDao tDMNonStandSearchDAO;
	@Autowired
	TDMNonStandardSearchMapper tdmNonStandSrchmapr;

	@Override
	public Map<String, List<String>> getSearchFields() throws ServiceException
	{
		try
		{
			EntityManager managerLookup = openUserEntityManager();
			Map<String, List<String>> map = new HashMap<String, List<String>>();
			List<TdmLookupDO> nonStandFields = tDMNonStandSearchDAO.getTDMSearchFields(map,
					managerLookup);
			devideSearchFileds(nonStandFields, map);
			closeUserEntityManager(managerLookup);
			return map;
		}
		catch (NullPointerException de)
		{
			throw new ServiceException(de.getMessage());
		}
		catch (DAOException de)
		{
			throw new ServiceException(de.getMessage());
		}
	}

	@Override
	public TDMNonStandardSearchDTO getNonStandSearchRecords(TDMNonStandardSearchDTO tdmSearchDTO)
			throws ServiceException
	{
		try
		{
			EntityManager subscriberManager = openSubscriberEntityManager();
			List<TdmSubscriberDetailsDO> subsrcDo = tDMNonStandSearchDAO
					.getTDMNonStandSearchRecords(tdmSearchDTO, subscriberManager);
			List<TdmNonStandardSearchResultListDTO> tdmNonStandSearchDTOList = tdmNonStandSrchmapr
					.converTdmSbscrDtlsDOtoTDMNonStandardSearchDTO(subsrcDo);
			tdmSearchDTO.setTdmNonStandardSrchResultListDTOs(tdmNonStandSearchDTOList);
			closeSubscriberEntityManager(subscriberManager);
			return tdmSearchDTO;
		}
		catch (NullPointerException de)
		{
			throw new ServiceException(de.getMessage());
		}
		catch (DAOException de)
		{
			throw new ServiceException(de.getMessage());
		}
	}

	@Override
	public int saveReservedData(TDMNonStandardSearchDTO tdmNonSrchDTO, String userId)
			throws ServiceException
	{
		try
		{
			EntityManager usrManager = openUserEntityManager();
			List<TdmReservationDO> tdmResrvationDoList = tdmNonStandSrchmapr
					.converTDMNonStandardSearchDTOtoTdmReservationDO(tdmNonSrchDTO, userId);
			tDMNonStandSearchDAO.saveReserveData(tdmResrvationDoList,
					tdmNonSrchDTO.getTestCaseName(), tdmNonSrchDTO.getTestCaseId(), usrManager);
			System.out.println();
			closeUserEntityManager(usrManager);
			return tdmResrvationDoList.size();
		}
		catch (NullPointerException de)
		{
			throw new ServiceException(de.getMessage());
		}
		catch (DAOException de)
		{
			throw new ServiceException(de.getMessage());
		}
	}

	public void devideSearchFileds(List<TdmLookupDO> nonStandFields, Map<String, List<String>> map)
	{
		List<String> planType = new ArrayList<String>();
		List<String> claimType = new ArrayList<String>();
		List<String> memCatList = new ArrayList<String>();
		List<String> coverageType = new ArrayList<String>();
		List<String> memStatus = new ArrayList<String>();
		List<String> stateList = new ArrayList<String>();
		List<String> subscRelation = new ArrayList<String>();
		List<String> ageGroup = new ArrayList<String>();
		for (TdmLookupDO tdmLookup : nonStandFields)
		{
			if (tdmLookup.getListValName().equalsIgnoreCase("PLAN TYPE"))
			{
				planType.add(tdmLookup.getListValue());
			}
			else if (tdmLookup.getListValName().equalsIgnoreCase("CLAIM TYPE"))
			{
				claimType.add(tdmLookup.getListValue());
			}
			else if (tdmLookup.getListValName().equalsIgnoreCase("MEMBER CATEGORY"))
			{
				memCatList.add(tdmLookup.getListValue());
			}
			else if (tdmLookup.getListValName().equalsIgnoreCase("COVERAGE TYPE"))
			{
				coverageType.add(tdmLookup.getListValue());
			}
			else if (tdmLookup.getListValName().equalsIgnoreCase("MEMBER STATUS"))
			{
				memStatus.add(tdmLookup.getListValue());
			}
			else if (tdmLookup.getListValName().equalsIgnoreCase("STATE"))
			{
				stateList.add(tdmLookup.getListValue());
			}
			else if (tdmLookup.getListValName().equalsIgnoreCase("SUBSCRIBER RELATIOSHIP"))
			{
				subscRelation.add(tdmLookup.getListValue());
			}
			else if (tdmLookup.getListValName().equalsIgnoreCase("AGE GROUP"))
			{
				ageGroup.add(tdmLookup.getListValue());
			}
		}
		map.put("claimType", claimType);
		map.put("planType", planType);
		map.put("memCatList", memCatList);
		map.put("coverageType", coverageType);
		map.put("memStatus", memStatus);
		map.put("stateList", stateList);
		map.put("subscRelation", subscRelation);
		map.put("ageGroup", ageGroup);
	}
}
