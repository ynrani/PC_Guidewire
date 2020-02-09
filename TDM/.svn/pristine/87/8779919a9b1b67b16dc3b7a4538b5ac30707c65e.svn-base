package com.tesda.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Component;

import com.tesda.constants.TDMExceptionCode;
import com.tesda.dao.TDGDataMaskingDAO;
import com.tesda.exception.DAOException;
import com.tesda.model.DO.ReqChDO;
import com.tesda.model.DO.RequestorDO;
import com.tesda.model.DO.TdmOnboardReqDO;
import com.tesda.model.DO.TdmUserDO;
import com.tesda.model.DTO.TdgDataMaskingDTO;
import com.tesda.model.DTO.TdmOnBoardReqDTO;

@Component("tDGDataMaskingDAO")
public class TDGDataMaskingDAOImpl implements TDGDataMaskingDAO
{

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
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
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

	@SuppressWarnings("unchecked")
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
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
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

	@SuppressWarnings("unchecked")
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
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
		}
		catch (IllegalStateException ex)
		{
			throw new DAOException(TDMExceptionCode.ILLEGAL_STATE, ex);
		}
		catch (NoResultException ex)
		{
			throw new DAOException(TDMExceptionCode.NORESULT, ex);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestorDO> searchDataMaskingRecords(int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userId, String type, EntityManager managerDtmask)
			throws DAOException
	{
		try
		{
			String query = null;
			if (type.equalsIgnoreCase("FR"))
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
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
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
	public Long getDataMaskingRecordsCount(String userId, String type, EntityManager managerDtmask)
			throws DAOException
	{
		try
		{
			String query = null;
			if (type.equalsIgnoreCase("FR"))
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
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
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
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
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
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
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
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
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
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getReqIdList(String userId, EntityManager managerDtmask, String reqIdtoken)
			throws DAOException
	{
		List<String> reqIds = null;
		try
		{
			if (reqIdtoken.toUpperCase().contains("TR"))
			{
				reqIds = managerDtmask.createQuery(
						"SELECT p.onboardReqId FROM TdmOnboardReqDO p where p.onboardReqId like'%"
								+ reqIdtoken + "%' AND P.actionBy='" + userId + "'")
						.getResultList();
			}
			else if (reqIdtoken.toUpperCase().contains("MR"))
			{
				reqIds = managerDtmask.createQuery(
						"SELECT p.id FROM RequestorDO p where p.id like'%" + reqIdtoken
								+ "%' AND p.userName='" + userId + "'").getResultList();
			}
			return reqIds;
		}
		catch (NullPointerException ex)
		{
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
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
	public Long getOnBoardingRecordsCount(String userId, String type, EntityManager managerDtmask)
			throws DAOException
	{
		try
		{
			String query = null;
			if (type.equalsIgnoreCase("FR"))
			{
				query = "SELECT COUNT(*) FROM TdmOnboardReqDO p where p.actionBy='" + userId
						+ "' AND p.vno = 0";
			}
			else if (type.equalsIgnoreCase("CR"))
			{
				query = "SELECT COUNT(*) FROM TdmOnboardReqDO p where p.actionBy='" + userId
						+ "' AND p.vno != 0";
			}
			Long list = (Long) managerDtmask.createQuery(query).getSingleResult();
			return list;
		}
		catch (NullPointerException ex)
		{
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
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
	public List<TdmOnboardReqDO> searchOnBoardingRecords(int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userId, String type, EntityManager managerDtmask)
			throws DAOException
	{
		try
		{
			String query = null;
			if (type.equalsIgnoreCase("FR"))
			{
				query = "SELECT p FROM TdmOnboardReqDO p where p.actionBy='" + userId
						+ "' AND p.vno = 0 Order By p.onboardReqId desc";
			}
			else if (type.equalsIgnoreCase("CR"))
			{
				query = "SELECT p FROM TdmOnboardReqDO p where p.actionBy='" + userId
						+ "'  AND p.vno != 0 Order By p.onboardReqId desc";
			}

			@SuppressWarnings("unchecked")
			List<TdmOnboardReqDO> list = managerDtmask.createQuery(query).setFirstResult(offSet)
					.setMaxResults(recordsperpage).getResultList();
			return list;
		}
		catch (NullPointerException ex)
		{
			throw new DAOException(TDMExceptionCode.NULL_POINTR, ex);
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
	public String onBoardingRecId(EntityManager managerDtmask)
	{
		String seqNO = (String) managerDtmask.createNativeQuery(
				"SELECT LPAD ( (NEXT VALUE FOR  SEQ_ONBOARD_REQ_ID), 6, '0' ) ID FROM DUAL")
				.getSingleResult();
		return seqNO;
	}

	@Override
	public String maskingRecId(EntityManager managerDtmask)
	{
		String seqNO = (String) managerDtmask.createNativeQuery(
				"SELECT LPAD ( (NEXT VALUE FOR  SEQ_MASK_REQ_ID), 6, '0' ) ID FROM DUAL")
				.getSingleResult();
		return seqNO;
	}

}
