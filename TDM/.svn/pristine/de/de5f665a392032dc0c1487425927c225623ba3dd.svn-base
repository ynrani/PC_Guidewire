package com.tesda.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.tesda.constants.TDMExceptionCode;
import com.tesda.dao.TDMNonStandSearchDao;
import com.tesda.exception.DAOException;
import com.tesda.model.DO.TdmLookupDO;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DO.TdmSubscriberDetailsDO;
import com.tesda.model.DTO.TDMNonStandardSearchDTO;

@Component("nonStandsearchImplDao")
public class TDMNonStandSearchDAOImpl implements TDMNonStandSearchDao
{

	@SuppressWarnings("unchecked")
	@Override
	public List<TdmLookupDO> getTDMSearchFields(Map<String, List<String>> map,
			EntityManager managerLookup) throws DAOException
	{
		try
		{
			List<TdmLookupDO> nonStandFields = managerLookup.createQuery(
					"SELECT l FROM TdmLookupDO l").getResultList();
			return nonStandFields;
		}
		catch (NoResultException ex)
		{
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}

	@Override
	public List<TdmReservationDO> saveReserveData(List<TdmReservationDO> tdmResrveList,
			String testCaseName, String testCaseId, EntityManager managerUsr) throws DAOException
	{
		List<TdmReservationDO> reservationDOs = null;
		try
		{
			if (null != tdmResrveList && 0 < tdmResrveList.size())
			{
				managerUsr.getTransaction().begin();
				reservationDOs = new ArrayList<TdmReservationDO>();
				for (TdmReservationDO tdmReserveDo : tdmResrveList)
				{
					if (tdmReserveDo != null)
					{
						tdmReserveDo.setTestCaseId(testCaseId);
						tdmReserveDo.setTestCaseName(testCaseName);
						tdmReserveDo = managerUsr.merge(tdmReserveDo);
						reservationDOs.add(tdmReserveDo);
					}
				}
				managerUsr.getTransaction().commit();
			}
		}
		catch (NoResultException ex)
		{
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
		return reservationDOs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TdmSubscriberDetailsDO> getTDMNonStandSearchRecords(
			TDMNonStandardSearchDTO tdmNonStandDTO, EntityManager subscrManager)
			throws DAOException
	{
		try
		{
			StringBuffer query = new StringBuffer(
					"SELECT s FROM TdmSubscriberDetailsDO s where 0=0 ");

			if (StringUtils.isNotEmpty(tdmNonStandDTO.getMemCat())
					&& !"ANY".equalsIgnoreCase(tdmNonStandDTO.getMemCat()))
			{
				query.append(" AND s.membrCat ='").append(tdmNonStandDTO.getMemCat()).append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getAgeGroup())
					&& !"ANY".equalsIgnoreCase(tdmNonStandDTO.getAgeGroup()))
			{
				query.append(" AND  s.age ='44' ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getSubscRelation())
					&& !"ANY".equalsIgnoreCase(tdmNonStandDTO.getSubscRelation()))
			{
				query.append(" AND  s.relationShipName ='SUBSCRIBER' ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getProvState())
					&& !"ANY".equalsIgnoreCase(tdmNonStandDTO.getProvState()))
			{
				query.append(" AND  s.state ='IL' ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getAccountName()))
			{
				query.append(" AND  s.accountName ='").append(tdmNonStandDTO.getAccountName())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getAccountNum()))
			{
				query.append(" AND  s.accountNum ='").append(tdmNonStandDTO.getAccountNum())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getPlanType())
					&& !"ANY".equalsIgnoreCase(tdmNonStandDTO.getMemCat()))
			{
				query.append(" AND s.prodCD ='").append(tdmNonStandDTO.getPlanType()).append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getSubscId())
					&& !"ANY".equalsIgnoreCase(tdmNonStandDTO.getSubscId()))
			{
				query.append(" AND s.subscriberId ='").append(tdmNonStandDTO.getSubscId())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getCoverageCode())
					&& !"ANY".equalsIgnoreCase(tdmNonStandDTO.getCoverageCode()))
			{
				// query.replace(query.indexOf("where") - 1,
				// query.indexOf("where") - 1,
				// " JOIN s.tdmClaimdetails clm");
				//
				// query.append(" AND s.covrgEleName ='").append("WELLNESS").append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getSubscStatus())
					&& !"ANY".equalsIgnoreCase(tdmNonStandDTO.getSubscStatus()))
			{
				query.append(" AND s.subscrStatus ='").append(tdmNonStandDTO.getSubscStatus())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getExtClaim())
					&& !"ANY".equalsIgnoreCase(tdmNonStandDTO.getExtClaim()))
			{
				// query.append(" AND s.subscriberId = clm.subscrId ");
			}

			// query +=
			// "AND s.subscriberId = sclaim.subscrId AND s.membrId = sclaim.membrId";
			List<TdmSubscriberDetailsDO> list = subscrManager.createQuery(query.toString())
					.setMaxResults(Integer.parseInt(tdmNonStandDTO.getSearchRecordsNo()))
					.getResultList();
			return list;
		}
		catch (NoResultException ex)
		{
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}
}
