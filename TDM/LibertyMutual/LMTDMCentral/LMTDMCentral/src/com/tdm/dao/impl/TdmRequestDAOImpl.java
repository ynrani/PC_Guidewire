package com.tdm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.dao.TdmRequestDAO;
import com.tdm.exception.DAOException;
import com.tdm.model.DO.TdmWfCreateReqTxDO;
import com.tdm.model.DTO.TdmSearchRequestDTO;

@Component("tdmRequestDAO")
public class TdmRequestDAOImpl implements TdmRequestDAO {

	private static Logger logger = Logger.getLogger(TdmRequestDAOImpl.class);

	@Override
	public String createReq(TdmWfCreateReqTxDO tdmWfCreateReqTxDO, EntityManager managerUser) throws DAOException {
		logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_REQ_DTLS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			if (null != managerUser) {
				managerUser.getTransaction().begin();
				tdmWfCreateReqTxDO = managerUser.merge(tdmWfCreateReqTxDO);
				managerUser.getTransaction().commit();
			}
			logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_REQ_DTLS
					+ MessageConstant.LOG_INFO_RETURN);

			return tdmWfCreateReqTxDO.getReqId();
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_REQ_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION, illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_REQ_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_REQ_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_GET_SAVED_REQ_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String reqRuningRecId(EntityManager managerUser) throws DAOException {
		logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_MSK_REC_ID
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String seqNo = (String) managerUser.createNativeQuery(
					"SELECT LPAD ( SEQ_CREATE_REQ.NEXTVAL, 6, '0' ) ID FROM DUAL").getSingleResult();
			logger.info(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_MSK_REC_ID
					+ MessageConstant.LOG_INFO_RETURN);
			return seqNo;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_MSK_REC_ID
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION, illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_MSK_REC_ID
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_MSK_REC_ID
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_DT_MSK_DAO + MessageConstant.TDM_DT_MSK_DAO_MSK_REC_ID
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long reqListCount(String userId, EntityManager managerUser) throws DAOException {
		logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_SEARCH_USER_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String query = "SELECT count(*) FROM TdmWfCreateReqTxDO p Where p.actionBy ='" + userId + "'";
			Long count = (Long) managerUser.createQuery(query).getSingleResult();
			return count;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_SEARCH_USER_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION, illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_SEARCH_USER_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_SEARCH_USER_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_SEARCH_USER_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmWfCreateReqTxDO> reqList(int offSet, int recordsperpage, boolean b, String userId,
			EntityManager managerUser) throws DAOException {

		logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmWfCreateReqTxDO> tdmWfCreateReqTxDOs = managerUser
					.createQuery("SELECT p FROM TdmWfCreateReqTxDO p where p.actionBy = '" + userId + "' ")
					.setFirstResult(offSet).setMaxResults(recordsperpage).getResultList();
			logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmWfCreateReqTxDOs;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION, illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}

	}

	@Override
	public TdmWfCreateReqTxDO selectRecord(String reqId, EntityManager managerUser) throws DAOException {

		logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			TdmWfCreateReqTxDO tdmWfCreateReqTxDO = (TdmWfCreateReqTxDO) managerUser.createQuery(
					"SELECT p FROM TdmWfCreateReqTxDO p where p.reqId = '" + reqId + "' ").getSingleResult();
			logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmWfCreateReqTxDO;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION, illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}

	}

	@Override
	public List<TdmWfCreateReqTxDO> searchReq(TdmSearchRequestDTO tdmSearchRequestDTO, int offSet, int recordsperpage,
			boolean b, EntityManager managerUser) throws DAOException {
		logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			StringBuffer query = new StringBuffer("SELECT p FROM TdmWfCreateReqTxDO p where 1=1");

			if (null != tdmSearchRequestDTO) {

				if (StringUtils.isNotEmpty(tdmSearchRequestDTO.getId())) {
					query.append(" AND p.reqId='" + tdmSearchRequestDTO.getId() + '\'');
				}
				if (StringUtils.isNotEmpty(tdmSearchRequestDTO.getDomainArea())) {
					query.append(" AND p.domainArea='" + tdmSearchRequestDTO.getDomainArea() + '\'');
				}
				if (StringUtils.isNotEmpty(tdmSearchRequestDTO.getApp())) {
					query.append(" AND p.application='" + tdmSearchRequestDTO.getApp() + '\'');
				}
				if (StringUtils.isNotEmpty(tdmSearchRequestDTO.getSts())) {
					query.append(" AND p.sts='" + tdmSearchRequestDTO.getSts() + '\'');
				}

			}

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmWfCreateReqTxDO> tdmWfCreateReqTxDOs = managerUser.createQuery(query + "").setFirstResult(offSet)
					.setMaxResults(recordsperpage).getResultList();
			logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmWfCreateReqTxDOs;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION, illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}

	}

	@Override
	public Long searchReqCnt(TdmSearchRequestDTO tdmSearchRequestDTO, EntityManager managerUser) throws DAOException {
		logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			StringBuffer query = new StringBuffer("SELECT COUNT(*) FROM TdmWfCreateReqTxDO p where 1=1");

			if (null != tdmSearchRequestDTO) {

				if (StringUtils.isNotEmpty(tdmSearchRequestDTO.getId())) {
					query.append(" AND p.reqId='" + tdmSearchRequestDTO.getId() + '\'');
				}
				if (StringUtils.isNotEmpty(tdmSearchRequestDTO.getDomainArea())) {
					query.append(" AND p.domainArea='" + tdmSearchRequestDTO.getDomainArea() + '\'');
				}
				if (StringUtils.isNotEmpty(tdmSearchRequestDTO.getApp())) {
					query.append(" AND p.application='" + tdmSearchRequestDTO.getApp() + '\'');
				}
				if (StringUtils.isNotEmpty(tdmSearchRequestDTO.getSts())) {
					query.append(" AND p.sts='" + tdmSearchRequestDTO.getSts() + '\'');
				}

			}

			Long cnt = (Long) managerUser.createQuery(query + "").getSingleResult();
			logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_INFO_RETURN);
			return cnt;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION, illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}

	}

}
