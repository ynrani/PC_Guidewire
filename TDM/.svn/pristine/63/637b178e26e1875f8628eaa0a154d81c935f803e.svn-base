/*---------------------------------------------------------------------------------------
 * Object Name: TDMDataMaskingDAOImpl.Java
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

package com.tdm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.dao.TDMDataMaskingDAO;
import com.tdm.exception.DAOException;
import com.tdm.model.DO.RequestorDO;
import com.tdm.model.DO.TdmOnboardReqDO;
import com.tdm.model.DO.TdmUserDO;
import com.tdm.model.DTO.TdmOnBoardReqDTO;

/**
 * 
 * @author Seshadri Chowdary
 *
 */
@Component(MessageConstant.DAO_COMPONET_MSK)
public class TDMDataMaskingDAOImpl implements TDMDataMaskingDAO
{
	private static Logger logger = Logger.getLogger(TDMDataMaskingDAOImpl.class);

	@Override
	public TdmUserDO getUserDetails(EntityManager managerUser, String userId) throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_GET_USER_DTL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			TdmUserDO userDO = (TdmUserDO) managerUser.createQuery(
					"SELECT p FROM TdmUserDO p where p.userId='" + userId + "'").getSingleResult();
			logger.info(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_USER_DTL + MessageConstant.LOG_INFO_RETURN);
			return userDO;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_USER_DTL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_USER_DTL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_USER_DTL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_USER_DTL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}

	}

	@Override
	public RequestorDO getSaveReqDtls(RequestorDO requestorDO, EntityManager managerDtmask)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO
				+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_REQ_DTLS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			if (null != managerDtmask)
			{
				managerDtmask.getTransaction().begin();
				requestorDO = managerDtmask.merge(requestorDO);
				managerDtmask.getTransaction().commit();
			}
			logger.info(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_REQ_DTLS
					+ MessageConstant.LOG_INFO_RETURN);
			return requestorDO;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_REQ_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_REQ_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_REQ_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_REQ_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String maskingRecId(EntityManager managerDtmask) throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_MSK_REC_ID
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			String seqNo = (String) managerDtmask.createNativeQuery(
					"SELECT LPAD ( SEQ_MASK_REQ_ID.NEXTVAL, 6, '0' ) ID FROM DUAL")
					.getSingleResult();
			logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_MSK_REC_ID
					+ MessageConstant.LOG_INFO_RETURN);
			return seqNo;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_MSK_REC_ID
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_MSK_REC_ID
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_MSK_REC_ID
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_MSK_REC_ID
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public RequestorDO getSavedDtls(String reqId, EntityManager managerDtmask) throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_DTLS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		RequestorDO requestorDO = null;
		try
		{
			if (0 < (long) managerDtmask.createQuery(
					"SELECT COUNT(*) FROM RequestorDO r WHERE r.id ='" + reqId + "'")
					.getSingleResult())
			{
				requestorDO = (RequestorDO) managerDtmask.createQuery(
						"SELECT r FROM RequestorDO r WHERE r.id ='" + reqId + "'")
						.getSingleResult();
			}
			logger.info(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_DTLS
					+ MessageConstant.LOG_INFO_RETURN);
			return requestorDO;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long getDataMaskingRecordsCount(String userId, String type, EntityManager managerDtmask)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_GET_REC_COUNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String query = null;
		try
		{
			if (type.equalsIgnoreCase(AppConstant.FR))
			{
				query = "SELECT COUNT(*) FROM RequestorDO p where p.userName='" + userId
						+ "' AND p.vno = 0";
			}
			else if (type.equalsIgnoreCase(AppConstant.CR))
			{
				query = "SELECT COUNT(*) FROM RequestorDO p where p.userName='" + userId
						+ "' AND p.vno != 0";
			}
			Long list = (Long) managerDtmask.createQuery(query).getSingleResult();
			logger.info(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_REC_COUNT
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_REC_COUNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_REC_COUNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_REC_COUNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_REC_COUNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<RequestorDO> searchDataMaskingRecords(int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userId, String type, EntityManager managerDtmask)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO
				+ MessageConstant.TDM_DT_MSK_DAO_SEARCH_DT_MSK_RECS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String query = null;
		try
		{
			if (type.equalsIgnoreCase(AppConstant.FR))
			{
				query = "SELECT r FROM RequestorDO r where r.userName='" + userId
						+ "' AND r.vno=0 Order By r.id desc";
			}
			else if (type.equalsIgnoreCase(AppConstant.CR))
			{
				query = "SELECT r FROM RequestorDO r where r.userName='" + userId
						+ "'AND r.vno != 0 Order By r.id desc";
			}
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<RequestorDO> list = managerDtmask.createQuery(query).setFirstResult(offSet)
					.setMaxResults(recordsperpage).getResultList();
			logger.info(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SEARCH_DT_MSK_RECS
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SEARCH_DT_MSK_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SEARCH_DT_MSK_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SEARCH_DT_MSK_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SEARCH_DT_MSK_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<RequestorDO> getSavedDtlsforExport(String userId, String type,
			EntityManager managerDtmask) throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_EXPT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String query = null;
		try
		{
			if (type.equalsIgnoreCase(AppConstant.FR))
			{
				query = "SELECT p FROM RequestorDO p where p.userName='" + userId
						+ "' AND p.vno = 0";
			}
			else if (type.equalsIgnoreCase(AppConstant.CR))
			{
				query = "SELECT p FROM RequestorDO p where p.userName='" + userId
						+ "' AND p.vno != 0";
			}
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<RequestorDO> list = managerDtmask.createQuery(query).getResultList();
			logger.info(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_EXPT
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_EXPT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_EXPT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_EXPT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_EXPT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@SuppressWarnings(AppConstant.UNCHECKED)
	@Override
	public List<String> getReqIdList(String userId, EntityManager managerDtmask, String reqIdtoken)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_GET_REC_ID_LIST
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		List<String> reqIds = null;
		try
		{
			if (reqIdtoken.toUpperCase().contains(AppConstant.TR))
			{
				reqIds = managerDtmask.createQuery(
						"SELECT p.onboardReqId FROM TdmOnboardReqDO p where p.onboardReqId like'%"
								+ reqIdtoken + "%' AND P.actionBy='" + userId + "'")
						.getResultList();
			}
			else if (reqIdtoken.toUpperCase().contains(AppConstant.MR))
			{
				reqIds = managerDtmask.createQuery(
						"SELECT p.id FROM RequestorDO p where p.id like'%" + reqIdtoken
								+ "%' AND p.userName='" + userId + "'").getResultList();
			}
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_REC_ID_LIST
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_REC_ID_LIST
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_REC_ID_LIST
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_REC_ID_LIST
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
		logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_GET_REC_ID_LIST
				+ MessageConstant.LOG_INFO_RETURN);
		return reqIds;
	}

	@Override
	public TdmOnboardReqDO getEditableDetails(EntityManager managerDtmask, String reqId)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_GET_EDIT_DTLS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			TdmOnboardReqDO tdmOnboardReqDO = (TdmOnboardReqDO) managerDtmask.createQuery(
					"SELECT p FROM TdmOnboardReqDO p where p.onboardReqId ='" + reqId + "'")
					.getSingleResult();
			logger.info(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_EDIT_DTLS
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmOnboardReqDO;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_EDIT_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_EDIT_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_EDIT_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_EDIT_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmOnBoardReqDTO getUserDetailsOnboard(String userId, EntityManager managerUser,
			TdmOnBoardReqDTO tdmOnBoardReqDTO) throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO
				+ MessageConstant.TDM_DT_MSK_DAO_GET_USER_DTL_ONBOARD
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			TdmUserDO userDO = (TdmUserDO) managerUser.createQuery(
					"SELECT p FROM TdmUserDO p where p.userId='" + tdmOnBoardReqDTO.getUserId()
							+ "'").getSingleResult();
			tdmOnBoardReqDTO.setUserName(userDO.getUsername());
			tdmOnBoardReqDTO.setEmailId(userDO.getEmailId());
			tdmOnBoardReqDTO.setPhoneNo(userDO.getMobileNo());
			logger.info(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_USER_DTL_ONBOARD
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmOnBoardReqDTO;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_USER_DTL_ONBOARD
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_USER_DTL_ONBOARD
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_USER_DTL_ONBOARD
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_USER_DTL_ONBOARD
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String onBoardingRecId(EntityManager managerDtmask) throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO
				+ MessageConstant.TDM_DT_MSK_DAO_GET_ONBOARD_REC_ID
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			String seqNO = (String) managerDtmask.createNativeQuery(
					"SELECT LPAD ( SEQ_ONBOARD_REQ_ID.NEXTVAL, 6, '0' ) ID FROM DUAL")
					.getSingleResult();
			logger.info(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_ONBOARD_REC_ID
					+ MessageConstant.LOG_INFO_RETURN);
			return seqNO;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_ONBOARD_REC_ID
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_ONBOARD_REC_ID
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_ONBOARD_REC_ID
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_ONBOARD_REC_ID
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmOnboardReqDO getSaveOnboardingReq(EntityManager managerDtmask,
			TdmOnboardReqDO tdmOnboardReqDO) throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO
				+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVE_ONBOARD_REQ
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			managerDtmask.getTransaction().begin();
			managerDtmask.merge(tdmOnboardReqDO);
			managerDtmask.getTransaction().commit();
			logger.info(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVE_ONBOARD_REQ
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmOnboardReqDO;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVE_ONBOARD_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVE_ONBOARD_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVE_ONBOARD_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_GET_SAVE_ONBOARD_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long getOnBoardingRecordsCount(String userId, String type, EntityManager managerDtmask)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_SAVE_USER_DTLS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String query = null;
		try
		{
			if (type.equalsIgnoreCase(AppConstant.FR))
			{
				query = "SELECT COUNT(*) FROM TdmOnboardReqDO p where p.actionBy='" + userId
						+ "' AND p.vno = 0";
			}
			else if (type.equalsIgnoreCase(AppConstant.CR))
			{
				query = "SELECT COUNT(*) FROM TdmOnboardReqDO p where p.actionBy='" + userId
						+ "' AND p.vno != 0";
			}
			Long list = (Long) managerDtmask.createQuery(query).getSingleResult();
			logger.info(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SAVE_USER_DTLS
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SAVE_USER_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SAVE_USER_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SAVE_USER_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SAVE_USER_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmOnboardReqDO> searchOnBoardingRecords(int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userId, String type, EntityManager managerDtmask)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO
				+ MessageConstant.TDM_DT_MSK_DAO_SEARCH_ONBOARD_RECS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String query = null;
		try
		{
			if (type.equalsIgnoreCase(AppConstant.FR))
			{
				query = "SELECT p FROM TdmOnboardReqDO p where p.actionBy='" + userId
						+ "' AND p.vno = 0 Order By p.onboardReqId desc";
			}
			else if (type.equalsIgnoreCase(AppConstant.CR))
			{
				query = "SELECT p FROM TdmOnboardReqDO p where p.actionBy='" + userId
						+ "'  AND p.vno != 0 Order By p.onboardReqId desc";
			}
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmOnboardReqDO> list = managerDtmask.createQuery(query).setFirstResult(offSet)
					.setMaxResults(recordsperpage).getResultList();
			logger.info(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SEARCH_ONBOARD_RECS
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SEARCH_ONBOARD_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SEARCH_ONBOARD_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SEARCH_ONBOARD_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_SEARCH_ONBOARD_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public boolean getCheckExistingReqYesNo(String userId, EntityManager managerDtmask)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_CHECK_EXISTING
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		boolean checkExistingReq = false;
		try
		{
			if (0 < (long) managerDtmask.createQuery(
					"SELECT COUNT(*) FROM RequestorDO r WHERE r.status='" + AppConstant.OPEN
							+ "' AND r.name ='" + userId + "' AND r.id NOT LIKE '%CR%'")
					.getSingleResult())
			{
				checkExistingReq = true;
			}
			else
			{
				checkExistingReq = false;
			}
			logger.info(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_CHECK_EXISTING
					+ MessageConstant.LOG_INFO_RETURN);
			return checkExistingReq;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_CHECK_EXISTING
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_CHECK_EXISTING
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_CHECK_EXISTING
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_DT_MSK_DAO_CHECK_EXISTING
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public boolean dtMaskCancelReq(String reqId, EntityManager managerDtmask) throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_CANCEL_REQ
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		boolean checkExistingReq = false;
		try
		{
			managerDtmask.getTransaction().begin();
			int updateCount = managerDtmask.createQuery(
					"UPDATE RequestorDO r SET r.status='" + AppConstant.CANCEL + "' WHERE r.id ='"
							+ reqId + "'").executeUpdate();
			managerDtmask.getTransaction().commit();
			checkExistingReq = true;
			logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_CANCEL_REQ
					+ MessageConstant.LOG_INFO_RETURN + updateCount);
			return checkExistingReq;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public boolean cancelOnBoardingReq(EntityManager managerDtmask, String reqId)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO
				+ MessageConstant.TDM_ONBOARDING_SERVICE_CANCEL_REQ
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			if (!reqId.contains(AppConstant.CR))
			{
				if (1 < (Long) managerDtmask.createQuery(
						"SELECT COUNT(*) FROM TdmOnboardReqDO p where p.onboardReqId like '%"
								+ reqId + "%' AND p.status='Submitted'").getSingleResult())
				{
					return false;
				}
			}

			TdmOnboardReqDO reqDo = (TdmOnboardReqDO) managerDtmask.createQuery(
					"SELECT p FROM TdmOnboardReqDO p where p.onboardReqId = '" + reqId
							+ "' AND p.status='Submitted'").getSingleResult();
			reqDo.setStatus(AppConstant.STATUS_CANCELLED);
			managerDtmask.getTransaction().begin();
			reqDo = managerDtmask.merge(reqDo);
			managerDtmask.getTransaction().commit();
			return true;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_ONBOARDING_SERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_ONBOARDING_SERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_ONBOARDING_SERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_ONBOARDING_SERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public boolean cancelMaskingReq(EntityManager managerDtmask, String reqId) throws DAOException
	{
		logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_MASKINGSERVICE_CANCEL_REQ
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			if (!reqId.contains(AppConstant.CR))
			{
				if (1 < (Long) managerDtmask.createQuery(
						"SELECT COUNT(*) FROM RequestorDO p where p.id like '%" + reqId
								+ "%' AND p.status='Submitted'").getSingleResult())
				{
					return false;
				}
			}

			RequestorDO reqDo = (RequestorDO) managerDtmask.createQuery(
					"SELECT p FROM RequestorDO p where p.id = '" + reqId
							+ "' AND p.status='Submitted'").getSingleResult();
			reqDo.setStatus(AppConstant.STATUS_CANCELLED);
			managerDtmask.getTransaction().begin();
			reqDo = managerDtmask.merge(reqDo);
			managerDtmask.getTransaction().commit();
			return true;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_MASKINGSERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_MASKINGSERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_MASKINGSERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DT_MSK_DAO
					+ MessageConstant.TDM_MASKINGSERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

}
