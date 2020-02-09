/*---------------------------------------------------------------------------------------
 * Object Name: TDGDataMaskingDAOImpl.Java
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tesda.constants.TDMConstants;
import com.tesda.constants.TDMExceptionCode;
import com.tesda.dao.TDMDataMaskingDAO;
import com.tesda.exception.DAOException;
import com.tesda.model.DO.ReqChDO;
import com.tesda.model.DO.RequestorDO;
import com.tesda.model.DO.TdmOnboardReqDO;
import com.tesda.model.DO.TdmUserDO;
import com.tesda.model.DTO.TdgDataMaskingDTO;
import com.tesda.model.DTO.TdmOnBoardReqDTO;

@Component(TDMConstants.DATAMSKING_DAOIMPL)
public class TDMDataMaskingDAOImpl implements TDMDataMaskingDAO
{

	private static final Logger logger = LoggerFactory.getLogger(TDMDataMaskingDAOImpl.class);

	@Override
	public String saveMaskingData(RequestorDO requestorDO, EntityManager managerDtmask)
			throws DAOException
	{
		try
		{
			managerDtmask.getTransaction().begin();
			requestorDO = managerDtmask.merge(requestorDO);
			managerDtmask.getTransaction().commit();
			return requestorDO.getId();
		}
		catch (NullPointerException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_1, ex);
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_2, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_3, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_4, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_5, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}

	@Override
	public RequestorDO getSaveReqDtls(RequestorDO requestorDO, EntityManager managerDtmask)
			throws DAOException
	{
		try
		{
			if (null != managerDtmask)
			{
				managerDtmask.getTransaction().begin();
				requestorDO = managerDtmask.merge(requestorDO);
				managerDtmask.getTransaction().commit();
			}
			return requestorDO;
		}
		catch (IllegalStateException illegalStateEx)
		{
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			throw new DAOException(TDMExceptionCode.NULL_POINTR, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			throw new DAOException(TDMExceptionCode.EXCEPTION, otherEx);
		}
	}

	@Override
	public RequestorDO getSavedDtls(String reqId, EntityManager managerDtmask) throws DAOException
	{
		RequestorDO requestorDO = null;
		try
		{
			if (0 < (Long.parseLong(managerDtmask
					.createQuery("SELECT COUNT(*) FROM RequestorDO r WHERE r.id ='" + reqId + "'")
					.getSingleResult().toString())))
			{
				requestorDO = (RequestorDO) managerDtmask.createQuery(
						"SELECT r FROM RequestorDO r WHERE r.id ='" + reqId + "'")
						.getSingleResult();
			}
			return requestorDO;
		}
		catch (IllegalStateException illegalStateEx)
		{
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			throw new DAOException(TDMExceptionCode.NULL_POINTR, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			throw new DAOException(TDMExceptionCode.EXCEPTION, otherEx);
		}
	}

	@SuppressWarnings(TDMConstants.UNCHECKED)
	@Override
	public List<RequestorDO> getAllDtMaskRequestedRecord(String userId, EntityManager managerDtmask)
			throws DAOException
	{
		try
		{
			List<RequestorDO> list = managerDtmask.createQuery(
					"SELECT r FROM RequestorDO r where r.userName='" + userId + "'")
					.getResultList();
			return list;
		}
		catch (NullPointerException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_6, ex);
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_7, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_8, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_9, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_10, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}

	@SuppressWarnings(TDMConstants.UNCHECKED)
	@Override
	public Map<RequestorDO, List<ReqChDO>> getDtMaskRequestedRecord(EntityManager managerDtmask,
			String userId, String reqId) throws DAOException
	{
		try
		{
			RequestorDO requestorDO = (RequestorDO) managerDtmask.createQuery(
					"SELECT r FROM RequestorDO r WHERE r.id ='" + reqId + "'").getSingleResult();
			List<ReqChDO> reqChDOList = managerDtmask.createQuery(
					"SELECT r FROM ReqChDO r WHERE r.pId ='" + reqId + "'").getResultList();
			Map<RequestorDO, List<ReqChDO>> map = new HashMap<RequestorDO, List<ReqChDO>>();
			map.put(requestorDO, reqChDOList);
			return map;
		}
		catch (NullPointerException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_11, ex);
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_12, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_13, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_14, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_15, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}

	@SuppressWarnings(TDMConstants.UNCHECKED)
	@Override
	public List<RequestorDO> searchDataMaskingRecords(int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userId, String type, EntityManager managerDtmask)
			throws DAOException
	{
		try
		{
			String query = null;
			if (type.equalsIgnoreCase(TDMConstants.FR))
			{
				query = "SELECT r FROM RequestorDO r where r.userName='" + userId
						+ "' AND r.vno=0 Order By r.id desc";
			}
			else if (type.equalsIgnoreCase("CR"))
			{
				query = "SELECT r FROM RequestorDO r where r.userName='" + userId
						+ "'AND r.vno != 0 Order By r.id desc";
			}

			List<RequestorDO> list = managerDtmask.createQuery(query).setFirstResult(offSet)
					.setMaxResults(recordsperpage).getResultList();
			return list;
		}
		catch (NullPointerException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_16, ex);
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_17, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_18, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_19, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_20, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}

	@Override
	public Long getDataMaskingRecordsCount(String userId, String type, EntityManager managerDtmask)
			throws DAOException
	{
		try
		{
			String query = null;
			if (type.equalsIgnoreCase(TDMConstants.FR))
			{
				query = "SELECT COUNT(*) FROM RequestorDO p where p.userName='" + userId
						+ "' AND p.vno = 0";
			}
			else if (type.equalsIgnoreCase("CR"))
			{
				query = "SELECT COUNT(*) FROM RequestorDO p where p.userName='" + userId
						+ "' AND p.vno != 0";
			}
			Long list = (Long) managerDtmask.createQuery(query).getSingleResult();
			return list;
		}
		catch (NullPointerException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_21, ex);
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_22, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_23, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_24, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_25, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}

	@Override
	public TdgDataMaskingDTO getUserDetails(EntityManager managerUser, String userId)
			throws DAOException
	{
		TdgDataMaskingDTO tdgDataMaskingDTO = new TdgDataMaskingDTO();
		try
		{
			TdmUserDO userDO = (TdmUserDO) managerUser.createQuery(
					"SELECT p FROM TdmUserDO p where p.userId='" + userId + "'").getSingleResult();
			tdgDataMaskingDTO.setUserName(userDO.getUsername());
			tdgDataMaskingDTO.setEmailId(userDO.getEmailId());
			tdgDataMaskingDTO.setPhoneNo(userDO.getMobileNo());
			return tdgDataMaskingDTO;
		}
		catch (NullPointerException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_26, ex);
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_27, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_28, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_29, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_30, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}

	}

	@Override
	public TdmOnBoardReqDTO getUserDetailsOnboard(String userId, EntityManager managerUser,
			TdmOnBoardReqDTO tdmOnBoardReqDTO) throws DAOException
	{
		try
		{
			TdmUserDO userDO = (TdmUserDO) managerUser.createQuery(
					"SELECT p FROM TdmUserDO p where p.userId='" + tdmOnBoardReqDTO.getUserId()
							+ "'").getSingleResult();
			tdmOnBoardReqDTO.setUserName(userDO.getUsername());
			tdmOnBoardReqDTO.setEmailId(userDO.getEmailId());
			tdmOnBoardReqDTO.setPhoneNo(userDO.getMobileNo());
			return tdmOnBoardReqDTO;
		}
		catch (NullPointerException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_31, ex);
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_32, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_33, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_34, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_35, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}

	@Override
	public TdmOnboardReqDO getSaveOnboardingReq(EntityManager managerDtmask,
			TdmOnboardReqDO tdmOnboardReqDO) throws DAOException
	{
		try
		{
			managerDtmask.getTransaction().begin();
			managerDtmask.merge(tdmOnboardReqDO);
			managerDtmask.getTransaction().commit();
			return tdmOnboardReqDO;
		}
		catch (NullPointerException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_36, ex);
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_37, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_38, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_39, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_40, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}

	@Override
	public TdmOnboardReqDO getEditableDetails(EntityManager managerDtmask, String reqId)
			throws DAOException
	{
		try
		{
			TdmOnboardReqDO tdmOnboardReqDO = (TdmOnboardReqDO) managerDtmask.createQuery(
					"SELECT p FROM TdmOnboardReqDO p where p.onboardReqId ='" + reqId + "'")
					.getSingleResult();
			return tdmOnboardReqDO;
		}
		catch (NullPointerException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_41, ex);
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_42, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_43, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_44, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_45, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}

	}

	@SuppressWarnings(TDMConstants.UNCHECKED)
	@Override
	public List<String> getReqIdList(String userId, EntityManager managerDtmask, String reqIdtoken)
			throws DAOException
	{
		List<String> reqIds = null;
		try
		{
			if (reqIdtoken.toUpperCase().contains(TDMConstants.TR))
			{
				reqIds = managerDtmask.createQuery(
						"SELECT p.onboardReqId FROM TdmOnboardReqDO p where p.onboardReqId like'%"
								+ reqIdtoken + "%' AND P.actionBy='" + userId + "'")
						.getResultList();
			}
			else if (reqIdtoken.toUpperCase().contains(TDMConstants.MR))
			{
				reqIds = managerDtmask.createQuery(
						"SELECT p.id FROM RequestorDO p where p.id like'%" + reqIdtoken
								+ "%' AND p.userName='" + userId + "'").getResultList();
			}
			return reqIds;
		}
		catch (NullPointerException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_46, ex);
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_47, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_48, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_49, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_50, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}

	}

	@Override
	public Long getOnBoardingRecordsCount(String userId, String type, EntityManager managerDtmask)
			throws DAOException
	{
		try
		{
			String query = null;
			if (type.equalsIgnoreCase(TDMConstants.FR))
			{
				query = "SELECT COUNT(*) FROM TdmOnboardReqDO p where p.actionBy='" + userId
						+ "' AND p.vno = 0";
			}
			else if (type.equalsIgnoreCase(TDMConstants.CR))
			{
				query = "SELECT COUNT(*) FROM TdmOnboardReqDO p where p.actionBy='" + userId
						+ "' AND p.vno != 0";
			}
			Long list = (Long) managerDtmask.createQuery(query).getSingleResult();
			return list;
		}
		catch (NullPointerException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_51, ex);
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_52, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_53, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_54, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_55, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}

	@Override
	public List<TdmOnboardReqDO> searchOnBoardingRecords(int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userId, String type, EntityManager managerDtmask)
			throws DAOException
	{
		try
		{
			String query = null;
			if (type.equalsIgnoreCase(TDMConstants.FR))
			{
				query = "SELECT p FROM TdmOnboardReqDO p where p.actionBy='" + userId
						+ "' AND p.vno = 0 Order By p.onboardReqId desc";
			}
			else if (type.equalsIgnoreCase(TDMConstants.CR))
			{
				query = "SELECT p FROM TdmOnboardReqDO p where p.actionBy='" + userId
						+ "'  AND p.vno != 0 Order By p.onboardReqId desc";
			}

			@SuppressWarnings(TDMConstants.UNCHECKED)
			List<TdmOnboardReqDO> list = managerDtmask.createQuery(query).setFirstResult(offSet)
					.setMaxResults(recordsperpage).getResultList();
			return list;
		}
		catch (NullPointerException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_56, ex);
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_57, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_58, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_59, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_60, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}

	@Override
	public String onBoardingRecId(EntityManager managerDtmask)
	{
		String seqNO = (String) managerDtmask.createNativeQuery(
				"SELECT LPAD ( (NEXT VALUE FOR  SEQ_ONBOARD_REQ_ID), 6, '0' ) ID FROM sysibm.sysdummy1")
				.getSingleResult();
		return seqNO;
	}

	@Override
	public String maskingRecId(EntityManager managerDtmask)
	{
		String seqNO = (String) managerDtmask.createNativeQuery(
				"SELECT LPAD ( (NEXT VALUE FOR  SEQ_MASK_REQ_ID), 6, '0' ) ID FROM sysibm.sysdummy1")
				.getSingleResult();
		return seqNO;
	}

	@Override
	public boolean cancelOnBoardingReq(EntityManager managerDtmask, String reqId)
			throws DAOException
	{
		try
		{
			Long count = 0L;
			if (!reqId.contains(TDMConstants.CR))
			{
				count = (Long) managerDtmask.createQuery(
						"SELECT COUNT(*) FROM TdmOnboardReqDO p where p.onboardReqId like '%"
								+ reqId + "%' AND p.status='Submitted'").getSingleResult();
				if (count > 1)
				{
					return false;
				}
			}

			TdmOnboardReqDO reqDo = (TdmOnboardReqDO) managerDtmask.createQuery(
					"SELECT p FROM TdmOnboardReqDO p where p.onboardReqId = '" + reqId
							+ "' AND p.status='Submitted'").getSingleResult();
			reqDo.setStatus(TDMConstants.STATUS_CANCELLED);
			managerDtmask.getTransaction().begin();
			reqDo = managerDtmask.merge(reqDo);
			managerDtmask.getTransaction().commit();
			return true;
		}
		catch (NullPointerException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_56, ex);
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_57, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_58, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_59, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_60, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}

	@Override
	public List<RequestorDO> getSavedDtlsforExport(String userId, String type,
			EntityManager managerDtmask) throws DAOException
	{
		String query = null;
		try
		{
			if (type.equalsIgnoreCase(TDMConstants.FR))
			{
				query = "SELECT p FROM RequestorDO p where p.userName='" + userId
						+ "' AND p.vno = 0";
			}
			else if (type.equalsIgnoreCase(TDMConstants.CR))
			{
				query = "SELECT p FROM RequestorDO p where p.userName='" + userId
						+ "' AND p.vno != 0";
			}
			@SuppressWarnings(TDMConstants.UNCHECKED)
			List<RequestorDO> list = managerDtmask.createQuery(query).getResultList();
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			throw new DAOException(TDMExceptionCode.NULL_POINTR, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			throw new DAOException(TDMExceptionCode.EXCEPTION, otherEx);
		}
	}

	@Override
	public boolean cancelMaskingReq(EntityManager managerDtmask, String reqId) throws DAOException
	{
		try
		{
			Long count = 0L;
			if (!reqId.contains(TDMConstants.CR))
			{
				count = (Long) managerDtmask.createQuery(
						"SELECT COUNT(*) FROM RequestorDO p where p.id like '%" + reqId
								+ "%' AND p.status='Submitted'").getSingleResult();
				if (count > 1)
				{
					return false;
				}
			}

			RequestorDO reqDo = (RequestorDO) managerDtmask.createQuery(
					"SELECT p FROM RequestorDO p where p.id = '" + reqId
							+ "' AND p.status='Submitted'").getSingleResult();
			reqDo.setStatus(TDMConstants.STATUS_CANCELLED);
			managerDtmask.getTransaction().begin();
			reqDo = managerDtmask.merge(reqDo);
			managerDtmask.getTransaction().commit();
			return true;
		}
		catch (NullPointerException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_56, ex);
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (NoResultException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_57, ex);
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
		}
		catch (IllegalStateException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_58, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (IllegalArgumentException ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_59, ex);
			throw new DAOException(TDMExceptionCode.ILLEGAL_ARGUMENT, ex);
		}
		catch (Exception ex)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_60, ex);
			throw new DAOException(TDMExceptionCode.EXCEPTION, ex);
		}
	}
}
