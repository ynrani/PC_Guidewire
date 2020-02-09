package com.tesda.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.dao.TdmPolicyAutoPropSearchDAO;
import com.tesda.exception.DAOException;
import com.tesda.model.DO.PolicySummaryStg;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;

@Component("tdmPolicyAutoPropSearchDAO")
public class TdmPolicyAutoPropSearchDAOImpl implements TdmPolicyAutoPropSearchDAO
{
	final static Logger logger = Logger.getLogger(TdmPolicyAutoPropSearchDAOImpl.class);

	@Autowired
	private MessageSource messageSource;

	// TODO
	@SuppressWarnings("unchecked")
	@Override
	public List<PolicySummaryStg> searchPolicyPropRecordsByPolicySearchNew(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, StringBuffer policyProps, String policytype,
			EntityManager managerCsaauser) throws DAOException {
		try {
			StringBuffer query = new StringBuffer("SELECT p FROM PolicySummaryStg p WHERE 0=0 ");

			// Reservation not in
			if (null != policyProps) {
				query.append(" AND p.policynumber NOT IN ( 'A' ");
				query.append(policyProps);
				query.append(") ");
			}

			// Product Type
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddproductType())) {
				query.append(" AND p.policyformcd ='")
						.append(tdmPolicyPropertySearchDTO.getAddproductType()).append('\'');
			}
			// Policy Stage
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyStage())) {
				if (tdmPolicyPropertySearchDTO.getPolicyStage().equalsIgnoreCase("Active")) {
					query.append(" AND p.policystatuscd='issued' AND P.timedpolicystatuscd='inForce' ");
				} else if (tdmPolicyPropertySearchDTO.getPolicyStage()
						.equalsIgnoreCase("Cancelled")) {
					query.append(" AND p.policystatuscd='cancelled' ");
				} else if (tdmPolicyPropertySearchDTO.getPolicyStage().equalsIgnoreCase("Pending")) {
					query.append(" AND p.policystatuscd in ('issued','initiated','dataGather','rated','proposed','pendingCompletion','customerDeclined','companyDeclined')");
					query.append(" AND p.timedpolicystatuscd in ('inForcePending','pendingCompletion','proposed','customerDeclined','rated','expired','companyDeclined','initiated','dataGather') ");
				}
			}
			// Risk State
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyState())) {
				query.append(" AND p.riskstatecd ='")
						.append(tdmPolicyPropertySearchDTO.getPolicyState()).append('\'');
			}

			// Policy Term
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyTerm())) {
				query.append(" AND p.contracttermtypecd ='")
						.append(tdmPolicyPropertySearchDTO.getPolicyTerm()).append('\'');
			}
			// Associate Payments required
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddPayReq())) {

			}
			// Risk Level Coverage addRiskCovge
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddRiskCovge())) {

				query.replace(query.indexOf("PolicySummaryStg p"),
						query.indexOf("PolicySummaryStg p")
								+ "PolicySummaryStg p".toString().length(),
						"PolicySummaryStg p JOIN p.coverageRiskStgs cr");
				query.append(" AND cr.coveragecd ='")
						.append(tdmPolicyPropertySearchDTO.getAddRiskCovge()).append('\'');
			}

			// Associated Documents required
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddDocReq())) {
				if ("Y".equalsIgnoreCase(tdmPolicyPropertySearchDTO.getAddDocReq())) {
					query.append(" AND p.docYn ='Y' ");
				} else if ("N".equalsIgnoreCase(tdmPolicyPropertySearchDTO.getAddDocReq())) {
					query.append(" AND p.docYn ='N' ");
				} else {
					query.append(" AND p.docYn IN ('N','Y')");
				}
			}

			long startTime = System.currentTimeMillis();

			List<PolicySummaryStg> policySummaryStgDOs = null;
			policySummaryStgDOs = managerCsaauser.createQuery(query.toString())
					.setFirstResult(offSet).setMaxResults(25).getResultList();

			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			logger.info("Query once associated document is Y:  " + offSet + ": " + query.toString());
			logger.info(elapsedTime + ": Millis To execute the query for policy record fetch");

			return policySummaryStgDOs;
		} catch (IllegalStateException illegalStateEx) {
			logger.error("MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION" + illegalStateEx);
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error("MessageConstant.INVALID_QUERY_EXCEPTION" + illegalArgEx);
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			nullPointerEx.printStackTrace();
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION" + nullPointerEx);
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);
		} catch (Exception otherEx) {
			logger.error("MessageConstant.DATABASE_EXCEPTION" + otherEx);
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);
		}
	}

	// TODO

	@SuppressWarnings("unchecked")
	@Override
	public List<PolicySummaryStg> searchPolicyAutoRecordsByPolicySearchNew(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, StringBuffer policyautos, String ptype,
			EntityManager managerCsaauser) throws DAOException {
		try {
			StringBuffer query = new StringBuffer("SELECT p FROM PolicySummaryStg p WHERE 0=0 ");

			// Reservation not in
			if (null != policyautos) {
				query.append(" AND p.policynumber NOT IN ( 'A' ");
				query.append(policyautos);
				query.append(") ");
			}

			// Product Type
			query.append("AND p.productcd NOT  IN ('AAA_PUP_SS')");
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAddproductType())) {
				query.append(" AND p.productcd ='")
						.append(tdmPolicyAutoSearchDTO.getAddproductType()).append("' ");
			}

			// Policy Stage
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyStage())) {
				if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase("Active")) {
					query.append(" AND p.policystatuscd  ='issued' AND p.timedpolicystatuscd='inForce' ");
				} else if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase("Cancelled")) {
					query.append(" AND p.policystatuscd='cancelled' ");
				} else if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase("Pending")) {
					query.append(" AND p.policystatuscd in ('issued','initiated','dataGather','rated','proposed','pendingCompletion','customerDeclined','companyDeclined')");
					query.append(" AND p.timedpolicystatuscd in ('inForcePending','pendingCompletion','proposed','customerDeclined','rated','expired','companyDeclined','initiated','dataGather' ) ");
				}
			}

			// Risk State
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyState())) {
				query.append(" AND p.riskstatecd ='")
						.append(tdmPolicyAutoSearchDTO.getPolicyState()).append("' ");
			}

			// Policy Term
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyTerm())) {
				query.append(" AND p.contracttermtypecd='")
						.append(tdmPolicyAutoSearchDTO.getPolicyTerm()).append("' ");
			}

			// Associate Payments required
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAssoPayReq())) {

			}

			// Policy Coverage
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())) {

				query.replace(query.indexOf("PolicySummaryStg p"),
						query.indexOf("PolicySummaryStg p")
								+ "PolicySummaryStg p".toString().length(),
						"PolicySummaryStg p JOIN p.coverageStgs cs ");

				query.append(" AND cs.coveragecd ='")
						.append(tdmPolicyAutoSearchDTO.getPolicyCovge()).append('\'');
			}
			// Risk Level Coverage
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getRiskCovge())) {

				query.replace(query.indexOf("PolicySummaryStg p"),
						query.indexOf("PolicySummaryStg p")
								+ "PolicySummaryStg p".toString().length(),
						"PolicySummaryStg p JOIN p.coverageRiskStgs cr ");

				query.append(" AND cr.coveragecd ='").append(tdmPolicyAutoSearchDTO.getRiskCovge())
						.append('\'');

			}

			// No Of Drivers
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfDrivers())) {
				query.replace(query.indexOf("PolicySummaryStg p"),
						query.indexOf("PolicySummaryStg p")
								+ "PolicySummaryStg p".toString().length(),
						"PolicySummaryStg p JOIN p.noOfDriverStg noOfDr ");
				query.append(" AND noOfDr.count ='")
						.append(tdmPolicyAutoSearchDTO.getNoOfDrivers()).append('\'');
			}

			// No Of Named Insu
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfNamedInsu())) {
				query.replace(query.indexOf("PolicySummaryStg p"),
						query.indexOf("PolicySummaryStg p")
								+ "PolicySummaryStg p".toString().length(),
						"PolicySummaryStg p JOIN p.noOfNameInsuStg noOfNi ");
				query.append(" AND noOfNi.count ='")
						.append(tdmPolicyAutoSearchDTO.getNoOfNamedInsu()).append('\'');
			}

			// No Of Vehi
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfVehi())) {
				query.replace(query.indexOf("PolicySummaryStg p"),
						query.indexOf("PolicySummaryStg p")
								+ "PolicySummaryStg p".toString().length(),
						"PolicySummaryStg p JOIN p.noOfVehiStg noOfVehi ");
				query.append(" AND noOfVehi.count ='").append(tdmPolicyAutoSearchDTO.getNoOfVehi())
						.append('\'');
			}

			// No Of Vio
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfViola())) {
				query.replace(query.indexOf("PolicySummaryStg p"),
						query.indexOf("PolicySummaryStg p")
								+ "PolicySummaryStg p".toString().length(),
						"PolicySummaryStg p JOIN p.noOfVioStg noOfVio ");
				query.append(" AND noOfVio.count ='").append(tdmPolicyAutoSearchDTO.getNoOfViola())
						.append('\'');
			}

			// Associated Documents required
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAssoDocReq())) {
				if ("Y".equalsIgnoreCase(tdmPolicyAutoSearchDTO.getAssoDocReq())) {
					query.append(" AND p.docYn ='Y' ");
				} else if ("N".equalsIgnoreCase(tdmPolicyAutoSearchDTO.getAssoDocReq())) {
					query.append(" AND p.docYn ='N' ");
				} else {
					query.append(" AND p.docYn IN ('N','Y')");
				}
			}

			long startTime = System.currentTimeMillis();
			List<PolicySummaryStg> policySearchDo = null;
			policySearchDo = managerCsaauser.createQuery(query + "").setFirstResult(offSet)
					.setMaxResults(25).getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info("Query if document is selected NO:  " + query.toString());
			logger.info(": Millis to execute the query search Policy Auto Records : " + elapsedTime);
			return policySearchDo;
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
	public List<TdmReservationDO> getReservedRecords(String userId, String searchType,
			EntityManager managerCsaaUser) throws DAOException {
		try {
			long startTime = System.currentTimeMillis();
			@SuppressWarnings("unchecked")
			List<TdmReservationDO> list = managerCsaaUser.createQuery(
					" FROM TdmReservationDO p where p.reserveDataType IN ('" + searchType
							+ "')  AND p.userId='" + userId + "'").getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			String str = " FROM TdmReservationDO p where p.reserveDataType IN ('" + searchType
					+ "') AND p.userId'" + userId + "'";
			logger.info(elapsedTime + ": Millis To execute the query getReservedRecords: " + str);
			return list;
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
	@Transactional
	public List<TdmReservationDO> saveReservedData(List<TdmReservationDO> reservationDOList,
			String testCaseId, String testCaseName, EntityManager managerCsaaUser)
			throws DAOException {
		List<TdmReservationDO> reservationDOs = null;
		try {
			if (null != reservationDOList && 0 < reservationDOList.size()) {
				managerCsaaUser.getTransaction().begin();
				reservationDOs = new ArrayList<TdmReservationDO>();
				long sequenceNO = getNextReservationSequenceNumber(managerCsaaUser);
				for (TdmReservationDO reservationDO : reservationDOList) {
					if (null != reservationDO && 0 == reservationDO.getRecordId()) {
						reservationDO.setTestCaseId(testCaseId);
						reservationDO.setTestCaseName(testCaseName);
						reservationDO.setProductType(null);
						sequenceNO = sequenceNO + 1;
						reservationDO.setRecordId(sequenceNO);
						reservationDO = managerCsaaUser.merge(reservationDO);
						reservationDOs.add(reservationDO);
					}
				}
				managerCsaaUser.getTransaction().commit();
			}
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
		return reservationDOs;
	}

	private Long getNextReservationSequenceNumber(EntityManager managerCsaaUse) {
		try {
			long startTime = System.currentTimeMillis();
			Long currentSeq = (Long) managerCsaaUse.createQuery(
					"SELECT max(recordId) FROM TdmReservationDO ").getSingleResult();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			return currentSeq;
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return 0L;
	}

}
