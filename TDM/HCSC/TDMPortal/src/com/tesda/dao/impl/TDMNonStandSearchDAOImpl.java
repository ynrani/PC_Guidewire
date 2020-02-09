/*---------------------------------------------------------------------------------------
 * Object Name: TDMNonStandSearchDAOImpl.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. 		Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary   11/04/15  NA          		Created
 * 2		Sikandar Shaikh		18/06/15  Logging changes	Updated
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tesda.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tesda.constants.TDMConstants;
import com.tesda.constants.TDMExceptionCode;
import com.tesda.dao.TDMNonStandSearchDao;
import com.tesda.exception.DAOException;
import com.tesda.model.DO.TdmLookupDO;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DO.TdmSubscriberDetailsDO;
import com.tesda.model.DTO.TDMNonStandardSearchDTO;

@Component(TDMConstants.NONSTANDSRCH_DAOIMPL)
public class TDMNonStandSearchDAOImpl implements TDMNonStandSearchDao
{

	private static final Logger logger = LoggerFactory.getLogger(TDMNonStandSearchDAOImpl.class);

	@SuppressWarnings(TDMConstants.UNCHECKED)
	@Override
	public List<TdmLookupDO> getTDMSearchFields(EntityManager managerLookup) throws DAOException
	{
		try
		{
			List<TdmLookupDO> nonStandFields = managerLookup.createQuery(
					"SELECT l FROM TdmLookupDO l").getResultList();
			return nonStandFields;
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_67, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_68, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_68, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_69, ex);
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
			logger.error(TDMConstants.TDMP_DAO_ERROR_70, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_71, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_72, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_73, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
		return reservationDOs;
	}

	@SuppressWarnings(TDMConstants.UNCHECKED)
	@Override
	public List<TdmSubscriberDetailsDO> getTDMNonStandSearchRecords(
			TDMNonStandardSearchDTO tdmNonStandDTO, int offSet, int recordsperpage,
			EntityManager subscrManager) throws DAOException
	{
		try
		{
			StringBuffer query = new StringBuffer(
					"SELECT s FROM TdmSubscriberDetailsDO s where 0=0 ");

			if (StringUtils.isNotEmpty(tdmNonStandDTO.getMemCat())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getMemCat()))
			{
				query.append(" AND s.membrCat ='").append(tdmNonStandDTO.getMemCat().toUpperCase())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getAgeGroup())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getAgeGroup()))
			{
				String age = tdmNonStandDTO.getAgeGroup();
				if (age.contains("AND"))
				{
					query.append(" AND  s.age ='" + age.split("AND")[0] + "' ");
					query.append(" AND  s.age ='" + age.split("AND")[1] + "' ");
				}
				else
				{
					query.append(" AND  s.age ='" + age + "' ");
				}
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getSubscRelation())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getSubscRelation()))
			{
				query.append(" AND  s.relationShipName ='SUBSCRIBER' ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getProvState())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getProvState()))
			{
				query.append(" AND  s.state ='").append(tdmNonStandDTO.getProvState()).append('\'');
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
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getPlanType()))
			{
				String productType = tdmNonStandDTO.getPlanType();
				if (productType.contains(TDMConstants.COMMA))
				{
					query.append(" AND s.prodCD IN (");
					query.append(parseMultiSearchValues(productType)).append(")");
				}
				else
				{
					query.append(" AND s.prodCD ='").append(productType).append('\'');
				}
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getSubscId())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getSubscId()))
			{
				query.append(" AND s.subscriberId ='").append(tdmNonStandDTO.getSubscId())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getCoverageCode())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getCoverageCode()))
			{
				// query.append(" AND s.claimType ='").append("WELLNESS").append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getSubscStatus())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getSubscStatus()))
			{
				query.append(" AND s.subscrStatus ='").append(tdmNonStandDTO.getSubscStatus())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getExtClaim())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getExtClaim()))
			{
				// query.append(" AND s.subscriberId = clm.subscrId ");
			}

			// query +=
			// "AND s.subscriberId = sclaim.subscrId AND s.membrId = sclaim.membrId";
			List<TdmSubscriberDetailsDO> list = subscrManager.createQuery(query.toString())
					.setFirstResult(offSet)
					.setMaxResults(Integer.parseInt(tdmNonStandDTO.getSearchRecordsNo()))
					.getResultList();
			return list;
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_74, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_75, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_76, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_77, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}

	@SuppressWarnings(TDMConstants.UNCHECKED)
	@Override
	public List<TdmReservationDO> getReservedRecords(String userId, EntityManager managerUsr)
			throws DAOException
	{
		try
		{
			List<TdmReservationDO> tdmReservationDO = managerUsr.createQuery(
					"SELECT t FROM TdmReservationDO t where t.userId='" + userId
							+ "' AND t.locked='Y'").getResultList();
			return tdmReservationDO;
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
	public void unReserveResrvedRecords(List<TdmReservationDO> tdmUnResrveList, String userId,
			EntityManager managerUsr) throws DAOException
	{
		List<TdmReservationDO> reservationDOs = null;
		try
		{
			if (null != tdmUnResrveList && 0 < tdmUnResrveList.size())
			{
				managerUsr.getTransaction().begin();
				reservationDOs = new ArrayList<TdmReservationDO>();
				for (TdmReservationDO tdmReserveDo : tdmUnResrveList)
				{
					if (tdmReserveDo != null)
					{
						tdmReserveDo.setSubscrId(tdmReserveDo.getSubscrId());
						tdmReserveDo.setUserId(userId);
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
	}

	@SuppressWarnings(TDMConstants.UNCHECKED)
	@Override
	public List<String> getSubscriberAcNameNumDetails(String type, String token,
			EntityManager subscrManager) throws DAOException
	{
		List<String> resultList = null;
		try
		{
			if (type.equalsIgnoreCase(TDMConstants.AC_NAME))
			{
				resultList = subscrManager.createQuery(
						"SELECT t.accountName FROM TdmSubscriberDetailsDO t where t.accountName like'"
								+ token.toUpperCase() + "%'").getResultList();
			}
			else if (type.equalsIgnoreCase(TDMConstants.AC_NUM))
			{
				resultList = subscrManager.createQuery(
						"SELECT t.accountNum FROM TdmSubscriberDetailsDO t where t.accountNum like'"
								+ token + "%'").getResultList();
			}
			else if (type.equalsIgnoreCase(TDMConstants.SUBSC_ID))
			{
				resultList = subscrManager.createQuery(
						"SELECT t.subscriberId FROM TdmSubscriberDetailsDO t where t.subscriberId like'"
								+ token + "%'").getResultList();
			}
			return resultList;
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
	public long getNonStandardSearchRecordCount(TDMNonStandardSearchDTO tdmNonStandDTO,
			EntityManager managerSubscr) throws DAOException
	{
		try
		{
			StringBuffer query = new StringBuffer(
					"SELECT  COUNT(*)  FROM TdmSubscriberDetailsDO s where 0=0 ");

			if (StringUtils.isNotEmpty(tdmNonStandDTO.getMemCat())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getMemCat()))
			{
				query.append(" AND s.membrCat ='").append(tdmNonStandDTO.getMemCat()).append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getAgeGroup())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getAgeGroup()))
			{
				String age = tdmNonStandDTO.getAgeGroup();
				if (age.contains("AND"))
				{
					query.append(" AND  s.age ='" + age.split("AND")[0] + "' ");
					query.append(" AND  s.age ='" + age.split("AND")[1] + "' ");
				}
				else
				{
					query.append(" AND  s.age ='" + age + "' ");
				}
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getSubscRelation())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getSubscRelation()))
			{
				query.append(" AND  s.relationShipName ='SUBSCRIBER' ");
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getProvState())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getProvState()))
			{
				query.append(" AND  s.state ='").append(tdmNonStandDTO.getProvState()).append('\'');
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
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getPlanType()))
			{
				query.append(" AND s.prodCD ='").append(tdmNonStandDTO.getPlanType()).append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getSubscId())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getSubscId()))
			{
				query.append(" AND s.subscriberId ='").append(tdmNonStandDTO.getSubscId())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getCoverageCode())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getCoverageCode()))
			{
				// query.replace(query.indexOf("where") - 1,
				// query.indexOf("where") - 1,
				// " JOIN s.tdmClaimdetails clm");
				//
				// query.append(" AND s.covrgEleName ='").append("WELLNESS").append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getSubscStatus())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getSubscStatus()))
			{
				query.append(" AND s.subscrStatus ='").append(tdmNonStandDTO.getSubscStatus())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tdmNonStandDTO.getExtClaim())
					&& !TDMConstants.ANY.equalsIgnoreCase(tdmNonStandDTO.getExtClaim()))
			{
				// query.append(" AND s.subscriberId = clm.subscrId ");
			}

			// query +=
			// "AND s.subscriberId = sclaim.subscrId AND s.membrId = sclaim.membrId";
			Long count = (Long) managerSubscr.createQuery(query.toString()).getSingleResult();
			return count;
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_74, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_75, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_76, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_77, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}

	public String parseMultiSearchValues(String value)
	{
		StringBuffer query = new StringBuffer();
		String[] values = value.split(TDMConstants.COMMA);
		int i = 0;
		for (String val : values)
		{
			if (i > 0)
			{
				query.append(TDMConstants.COMMA);
			}
			query.append('\'').append(val).append('\'');
			i++;
		}
		return query.toString();
	}
}
