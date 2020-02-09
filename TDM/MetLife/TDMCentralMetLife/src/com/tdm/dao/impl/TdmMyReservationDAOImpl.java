package com.tdm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.dao.TdmMyReservationDAO;
import com.tdm.exception.DAOException;
import com.tdm.model.DO.PolicySummaryStg;
import com.tdm.model.DO.TdmReservationDO;

@Component("tdmMyReservationDAOImpl")
public class TdmMyReservationDAOImpl implements TdmMyReservationDAO
{

	final static Logger logger = Logger.getLogger(TdmMyReservationDAOImpl.class);

	@Autowired
	private MessageSource messageSource;

	@Override
	public List<TdmReservationDO> getReservedRecords(String searchType, String userName,
			int offSet, int recordsperpage, boolean pageNationOnOffFlag,
			EntityManager managerCsaaUser) throws DAOException {
		try {
			logger.info("In TdmMyReservationDAOImpl.getReservedRecords()  : ");

			@SuppressWarnings("unchecked")
			List<TdmReservationDO> list = managerCsaaUser
					.createQuery(
							"SELECT p FROM TdmReservationDO p where p.reserveDataType='"
									+ searchType + "' AND p.userId='" + userName + "'")
					.setFirstResult(offSet).setMaxResults(recordsperpage).getResultList();

			return list;
		} catch (IllegalStateException illegalStateEx) {
			logger.error("MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION "
					+ illegalStateEx);
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);

		} catch (IllegalArgumentException illegalArgEx) {
			logger.error("MessageConstant.INVALID_QUERY_EXCEPTION " + illegalArgEx);
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);

		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION " + nullPointerEx);
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);

		} catch (Exception otherEx) {
			logger.error("MessageConstant.DATABASE_EXCEPTION " + otherEx);
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);

		}

	}

	@Override
	public List<TdmReservationDO> getPolicyAutoRecords(List<String> policyAutoNumbers,
			EntityManager managerCsaaUser, String searchType, String userName) throws DAOException {
		try {
			List<TdmReservationDO> autoReservePolicyDOs = new ArrayList<TdmReservationDO>();
			for (String policyAutoNumber : policyAutoNumbers) {
				if (policyAutoNumber != null) {
					@SuppressWarnings("unchecked")
					List<TdmReservationDO> results = managerCsaaUser.createQuery(
							"SELECT p FROM TdmReservationDO p where p.policyNumber='"
									+ policyAutoNumber + "'").getResultList();

					if (!results.isEmpty()) {
						autoReservePolicyDOs.add(results.get(0));// else if (results.size() == 1)
																	// return results.get(0);
					}

					if (0 < (Long) managerCsaaUser.createQuery(
							"SELECT count(p.policyNumber)  FROM TdmReservationDO p where p.reserveDataType='"
									+ searchType + "' AND p.userId='" + userName + "'")
							.getSingleResult()) {
						autoReservePolicyDOs.add((TdmReservationDO) managerCsaaUser.createQuery(
								"SELECT p FROM TdmReservationDO p where p.reserveDataType='"
										+ searchType + "' AND p.userId='" + userName + "'")
								.getSingleResult());
					}

				}
			}

			return autoReservePolicyDOs;
		} catch (IllegalStateException illegalStateEx) {
			logger.error("MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION "
					+ illegalStateEx);
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);

		} catch (IllegalArgumentException illegalArgEx) {
			logger.error("MessageConstant.INVALID_QUERY_EXCEPTION " + illegalArgEx);
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);

		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION " + nullPointerEx);
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);

		} catch (Exception otherEx) {
			logger.error("MessageConstant.DATABASE_EXCEPTION " + otherEx);
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);
		}
	}

	@Override
	public Long getReservedRecordsCount(String searchType, String userName,
			EntityManager managerUser) throws DAOException {
		try {

			Long list = (Long) managerUser.createQuery(
					"SELECT COUNT(*) FROM TdmReservationDO p where p.reserveDataType='"
							+ searchType + "' AND p.userId='" + userName + "'").getSingleResult();

			return list;
		} catch (IllegalStateException illegalStateEx) {
			logger.error("MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION "
					+ illegalStateEx);
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);

		} catch (IllegalArgumentException illegalArgEx) {
			logger.error("MessageConstant.INVALID_QUERY_EXCEPTION " + illegalArgEx);
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION " + nullPointerEx);
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);

		} catch (Exception otherEx) {
			logger.error("MessageConstant.DATABASE_EXCEPTION " + otherEx);
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);
		}
	}

	@Override
	public boolean unReservedRecordForUser(Long policyAutoNo, EntityManager managerCsaaUser)
			throws DAOException {
		try {
			managerCsaaUser.getTransaction().begin();
			Query q1 = managerCsaaUser
					.createQuery("DELETE FROM TdmReservationDO p where p.reserveDataId =:policyNumber");
			q1.setParameter("policyNumber", String.valueOf(policyAutoNo));
			int count = q1.executeUpdate();
			managerCsaaUser.getTransaction().commit();

			return count > 0 ? true : false;
		} catch (IllegalStateException illegalStateEx) {
			logger.error("MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION "
					+ illegalStateEx);
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);

		} catch (IllegalArgumentException illegalArgEx) {
			logger.error("MessageConstant.INVALID_QUERY_EXCEPTION " + illegalArgEx);
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);

		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION " + nullPointerEx);
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);

		} catch (Exception otherEx) {
			logger.error("MessageConstant.DATABASE_EXCEPTION " + otherEx);
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);
		}

	}

	@Override
	public boolean unReservedRecordForUser(String policyPropNo, EntityManager managerCsaaUser)
			throws DAOException {
		try {
			managerCsaaUser.getTransaction().begin();
			Query q1 = managerCsaaUser
					.createQuery("DELETE FROM TdmReservationDO p where p.reserveDataId =:policyNumber");
			q1.setParameter("policyNumber", String.valueOf(policyPropNo));
			int count = q1.executeUpdate();
			managerCsaaUser.getTransaction().commit();

			return count > 0 ? true : false;
		} catch (IllegalStateException illegalStateEx) {
			logger.error("MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION" + illegalStateEx);
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);

		} catch (IllegalArgumentException illegalArgEx) {
			logger.error("MessageConstant.INVALID_QUERY_EXCEPTION" + illegalArgEx);
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);

		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION" + nullPointerEx);
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);

		} catch (Exception otherEx) {
			logger.error("MessageConstant.DATABASE_EXCEPTION" + otherEx);
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);
		}

	}

	@Override
	public List<PolicySummaryStg> getReservedRecords(StringBuffer propIds,
			EntityManager managerCsaaUser) throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_POLICY_GET_POL_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			StringBuffer query = new StringBuffer("SELECT P FROM PolicySummaryStg P WHERE 0=0 ");

			if (null != propIds) {
				query.append("AND P.policynumber IN ( 'A' ");
				query.append(propIds);
				query.append(") ");
			}

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<PolicySummaryStg> list = managerCsaaUser.createQuery(query.toString())
					.getResultList();
			logger.info(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_GET_POL_REC + MessageConstant.LOG_INFO_RETURN);
			return list;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_GET_POL_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_GET_POL_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_GET_POL_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_GET_POL_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

}
