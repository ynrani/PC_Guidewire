package com.tesda.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.dao.TdmPolicyAutoSearchDAO;
import com.tesda.exception.DAOException;
import com.tesda.model.DO.CassPolListDO;
import com.tesda.model.DO.PolicysummaryDO;
import com.tesda.model.DO.TdmPolicySearchDO;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DTO.TdmAutoSearchResultDTO;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;

@Component("tdmPolicyAutoSearchDAO")
public class TdmPolicyAutoSearchDAOImpl implements TdmPolicyAutoSearchDAO
{
	final static Logger logger = Logger.getLogger(TdmPolicyAutoSearchDAOImpl.class);
	public static final String tabDriver = "DRIVER";
	public static final String tabVehi = "RISKITEM";
	public static final String tabViolats = "ACCIDENTVIOLATION";
	public static final String tabNo_Of_Named_Insured = "INSUREDPRINCIPAL";
	public static final String BILLABLEPOLICYTERM = "BILLABLEPOLICYTERM";
	public static final String tabfastlane_ACAAU = "FastLane_ACAAU_TAB";
	public static final String tabfastlane_AUTO = "FASTLANE_AUTO_TAB";
	public static final String tabfastlane_ACAHO = "FastLane_ACAHO_TAB";
	public static final String tabfastlane_HOME = "Fastlane_HOME_TAB";
	private Map<String, Map<String, String>> mapDerivedFields = null;
	@PersistenceUnit(unitName = "fastlaneMappingPersistenceUnitSQL")
	private EntityManagerFactory factoryCsaaFastlaneMappingUser;
	EntityManager factoryCsaaFastLane;
	@Autowired
	private MessageSource messageSource;

	@Override
	@SuppressWarnings("unchecked")
	public TdmAutoSearchResultDTO searchPolicyAutoRecords(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, StringBuffer policyautos, String policytype,
			StringBuffer listOfPolocies, EntityManager managerCsaa) throws DAOException {
		try {
			TdmAutoSearchResultDTO tdmAutoSearchResultDTO = new TdmAutoSearchResultDTO();
			StringBuffer query = new StringBuffer(
					"SELECT p FROM PolicysummaryDO p  WHERE  p.lob ='AUTO'  AND 1=1 ");
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyStage())) {
				if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase("Active")) {
					query.append(" AND p.policystatuscd='issued' AND timedpolicystatuscd='inForce' ");
				} else if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase("Cancelled")) {
					query.append(" AND p.policystatuscd='cancelled' ");
				} else if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase("Pending")) {
					query.append(" AND p.policystatuscd in ('issued','initiated','dataGather','rated','proposed','pendingCompletion','customerDeclined','companyDeclined')");
					query.append(" AND timedpolicystatuscd in ('inForcePending','pendingCompletion','proposed','customerDeclined','rated','expired','companyDeclined','initiated','dataGather' ) ");
				}
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyTerm())) {
				query.append(" AND p.contracttermtypecd ='")
						.append(tdmPolicyAutoSearchDTO.getPolicyTerm()).append("' ");
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyState())) {
				query.append(" AND p.riskstatecd ='")
						.append(tdmPolicyAutoSearchDTO.getPolicyState()).append("' ");
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAddproductType())) {
				query.append(" AND p.productcd ='")
						.append(tdmPolicyAutoSearchDTO.getAddproductType()).append("' ");
			}
			query.append(" AND p.productcd  not in('").append("AAA_PUP_SS").append("') ");
			List<String> lstResultForDerivedFileds = new ArrayList<String>();

			// associated payment
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAssoPayReq())) {

			}
			// policyCoverage with specific coverage
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())
					&& StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getRiskCovge())) {
				List<String> list = getPolicyAndRiskCovSpecific(
						tdmPolicyAutoSearchDTO.getPolicyCovge(),
						tdmPolicyAutoSearchDTO.getRiskCovge(), 25, managerCsaa, "AUTO");

				lstResultForDerivedFileds.addAll(list);

			} else {
				if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())) {
					List<String> list = getPolicyCovSpecific(
							tdmPolicyAutoSearchDTO.getPolicyCovge(), 25, managerCsaa, "AUTO");

					lstResultForDerivedFileds.addAll(list);
				}
				// riskCoverage with specific coverage
				if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getRiskCovge())) {
					List<String> list = getRiskCovSpecific(tdmPolicyAutoSearchDTO.getRiskCovge(),
							25, managerCsaa, "AUTO");
					lstResultForDerivedFileds.addAll(list);
				}
			}
			// Reservation not in
			if (null != policyautos) {
				query.append(" AND p.policynumber NOT IN ( 'A' ");
				query.append(policyautos);
				query.append(") ");
			}

			if (!lstResultForDerivedFileds.isEmpty()) {
				query = getAppendedQuery(lstResultForDerivedFileds, query);
			}
			long startTime = System.currentTimeMillis();
			List<PolicysummaryDO> policysummaryDOListAny = null;
			policysummaryDOListAny = managerCsaa.createQuery(query.toString())
					.setFirstResult(offSet).setMaxResults(25).getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info("Query if document is selected NO:  " + query.toString());
			logger.info(": Millis to execute the query search Policy Auto Records : " + elapsedTime);
			tdmAutoSearchResultDTO.setListPolicySummeryDo(policysummaryDOListAny);
			tdmAutoSearchResultDTO.setMapDerivedFields(mapDerivedFields);
			return tdmAutoSearchResultDTO;
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

	private StringBuffer getAppendedQuery(List<String> list, StringBuffer query) {
		Set<String> setResult = new HashSet<String>(list);
		if (null != setResult && !setResult.isEmpty()) {
			query.append(" AND p.policynumber IN (");
			int iCount = 0;
			for (String string : setResult) {
				iCount++;
				if (iCount != 1) {
					query.append(',');
				}
				query.append('\'').append(string).append('\'');
			}
			query.append(") ");
		} else {
			query.append(" AND 0=1");
		}
		return query;
	}

	public List<String> getPolicyNoForAssociatedPayment(String associatedpayment,
			String paymentMethod, String tabName, EntityManager managerUser) throws DAOException {
		try {
			final List<String> list = new ArrayList<String>();
			String query = null;
			if (tabName.equals(BILLABLEPOLICYTERM)) {
				if (associatedpayment.equalsIgnoreCase("Y")) {
					if (StringUtils.isNotEmpty(paymentMethod)
							&& !paymentMethod.equalsIgnoreCase("ANY")) {
						query = " select distinct BPT.policynumber from POLICYSUMMARY ps,BALANCEAMOUNT BA, BILLABLEPOLICYTERM BPT, "
								+ "BALANCEINFO BI, PAYMENTDETAILS PD, PAYMENT PT, BILLINGTRANSACTION BT WHERE BPT.POLICYNUMBER=ps.POLICYNUMBER AND BPT.BALANCEINFO_ID=BI.ID  "
								+ "AND BI.BALANCEDUE_ID = BA.ID and BA.AMOUNT < 0 "
								+ " and  PT.PAYMENTNUMBER=BT.PAYMENTNUMBER and PT.PAYMENTDETAILS_ID=PD.ID and PD.DTYPE ='"
								+ paymentMethod + "'";
					} else {
						query = " select distinct BPT.policynumber from POLICYSUMMARY ps,BALANCEAMOUNT BA, BILLABLEPOLICYTERM BPT, "
								+ "BALANCEINFO BI WHERE BPT.POLICYNUMBER=ps.POLICYNUMBER AND BPT.BALANCEINFO_ID=BI.ID  "
								+ "AND BI.BALANCEDUE_ID = BA.ID and BA.AMOUNT < 0 ";
					}
				} else if (associatedpayment.equalsIgnoreCase("N")) {
					query = " select distinct BPT.policynumber from POLICYSUMMARY ps,BALANCEAMOUNT BA, BILLABLEPOLICYTERM BPT, "
							+ "BALANCEINFO BI WHERE BPT.POLICYNUMBER=ps.POLICYNUMBER AND BPT.BALANCEINFO_ID=BI.ID  "
							+ "AND BI.BALANCEDUE_ID = BA.ID and BA.AMOUNT >= 0 ";
				} else if (associatedpayment.equalsIgnoreCase("ANY")) {
					query = " select distinct BPT.policynumber from POLICYSUMMARY ps,BALANCEAMOUNT BA, BILLABLEPOLICYTERM BPT, "
							+ "BALANCEINFO BI WHERE BPT.POLICYNUMBER=ps.POLICYNUMBER AND BPT.BALANCEINFO_ID=BI.ID  "
							+ "AND BI.BALANCEDUE_ID = BA.ID ";
				}
			}
			long startTime = System.currentTimeMillis();
			// list = managerUser.createNativeQuery(query).getResultList();
			final String strFinalQuery = query.toString();
			// list = managerUser.createNativeQuery(query).getResultList();
			managerUser.unwrap(Session.class).doWork(new Work()
			{
				@Override
				public void execute(Connection connection) throws SQLException {
					PreparedStatement preparedStatement = connection
							.prepareStatement(strFinalQuery);
					ResultSet resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						list.add(resultSet.getString("policynumber"));
					}
				}
			});
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			logger.info(elapsedTime);
			logger.info("Query for PolicyNoForAssociatedPayment:  " + query.toString());
			logger.info(": Millis To execute the query search Policy Auto Records : " + elapsedTime);
			// logger.info(elapsedTime + ": Millis Time To execute the query :"
			// + query);
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

	@SuppressWarnings("unchecked")
	public List<String> getPolicyNo(String no, String tabName, EntityManager managerUser)
			throws DAOException {
		try {
			List<String> list = null;
			String query = null;
			if (tabName.equals(tabDriver)) {
				query = "SELECT PS.POLICYNUMBER,count(*) FROM POLICYSUMMARY PS, DRIVER D "
						+ "WHERE PS.POLICYDETAIL_ID=D.POLICYDETAIL_ID AND PS.CURRENTREVISIONIND="
						+ 1 + " AND D.SEQNO IS NOT NULL "
						+ "GROUP BY PS.POLICYNUMBER HAVING count(*)=" + no;
			}
			if (tabName.equals(tabVehi)) {
				query = "select childTab.policynumber from ( SELECT COUNT(*) AS NO_OF_VEHICLES,PS.policynumber,PS.lob FROM POLICYSUMMARY PS,RISKITEM R WHERE PS.policydetail_Id=R.policydetail_Id"
						+ " AND PS.currentrevisionind=1 AND R.seqno IS NOT NULL GROUP BY PS.policynumber,PS.lob)childTab WHERE childTab.NO_OF_VEHICLES="
						+ no + " AND childTab.lob='AUTO'";
			}
			if (tabName.equals(tabViolats)) {
				query = "SELECT P.POLICYNUMBER FROM DRIVER DR, POLICYSUMMARY P, ACCIDENTVIOLATION AV "
						+ "WHERE DR.POLICYDETAIL_ID=P.POLICYDETAIL_ID AND DR.ID = AV.DRIVER_ID AND P.CURRENTREVISIONIND ="
						+ 1
						+ " and AV.SEQNO IS NOT NULL "
						+ "GROUP BY P.POLICYNUMBER HAVING COUNT(*)=" + no;
			}
			long startTime = System.currentTimeMillis();
			list = managerUser.createNativeQuery(query).getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info("Query for getPolicyNo:  " + query.toString());
			logger.info(elapsedTime);
			logger.info(": Millis To execute the query search Policy Auto Records : " + elapsedTime);
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

	@SuppressWarnings("unchecked")
	public List<String> getPolicyNoNamedInsured(String no, String tabName, EntityManager managerUser)
			throws DAOException {
		try {
			List<String> list = null;
			String query = "SELECT P.POLICYNUMBER,count(*) as countValue FROM INSUREDPRINCIPAL IP, POLICYSUMMARY P WHERE IP.POLICYDETAIL_ID=P.POLICYDETAIL_ID"
					+ "	AND P.CURRENTREVISIONIND="
					+ 1
					+ " AND IP.SEQNO IS NOT NULL "
					+ "GROUP BY P.POLICYNUMBER ";
			long startTime = System.currentTimeMillis();
			list = managerUser.createNativeQuery(query).getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info("Query:  " + query.toString());
			logger.info(elapsedTime + ": Millis To execute the query :" + query);
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
	public Long searchPolicyAutoRecordsCount(TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO,
			StringBuffer policyautos, String policytype, EntityManager managerCsaa)
			throws DAOException {
		try {
			StringBuffer query = new StringBuffer(
					"SELECT COUNT(*) FROM PolicysummaryDO p WHERE  p.lob ='AUTO'  ");
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyStage())) {
				query.append(" AND p.policystatuscd ='")
						.append(tdmPolicyAutoSearchDTO.getPolicyStage()).append('\'');
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyTerm())) {
				query.append(" AND p.contracttermtypecd ='")
						.append(tdmPolicyAutoSearchDTO.getPolicyTerm()).append('\'');
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyState())) {
				query.append(" AND p.riskstatecd ='")
						.append(tdmPolicyAutoSearchDTO.getPolicyState()).append('\'');
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfDrivers())) {
				List<String> list = getPolicyNo(tdmPolicyAutoSearchDTO.getNoOfDrivers(), tabDriver,
						managerCsaa);
				if (null != list && 0 < list.size()) {
					query.append(" AND p.policynumber IN ( 'A' ");
					for (String string : list) {
						// query.append("," + string;
						query.append(",'").append(string).append('\'');
					}
					query.append(") ");
				} else {
					query.append(" AND 0=1");
				}
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfVehi())) {
				List<String> list = getPolicyNo(tdmPolicyAutoSearchDTO.getNoOfVehi(), tabVehi,
						managerCsaa);
				if (null != list && 0 < list.size()) {
					query.append(" AND p.policynumber IN ( 'A' ");
					for (String string : list) {
						// query.append("," + string;
						query.append(",'").append(string).append("'");
					}
					query.append(") ");
				} else {
					query.append(" AND 0=1");
				}
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfViola())) {
				List<String> list = getPolicyNo(tdmPolicyAutoSearchDTO.getNoOfViola(), tabViolats,
						managerCsaa);
				if (null != list && 0 < list.size()) {
					query.append(" AND p.policynumber IN ( 'A' ");
					for (String string : list) {
						// query.append("," + string;
						query.append(",'").append(string).append("'");
					}
					query.append(") ");
				} else {
					query.append(" AND 0=1");
				}
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfNamedInsu())) {
				List<String> list = getPolicyNoNamedInsured(
						tdmPolicyAutoSearchDTO.getNoOfNamedInsu(), tabDriver, managerCsaa);
				if (null != list && 0 < list.size()) {
					query.append(" AND p.id IN ( '0' ");
					for (String string : list) {
						// query.append("," + string;
						query.append(",'").append(string).append("'");
					}
					query.append(") ");
				} else {
					query.append(" AND 0=1");
				}
			}
			// policyCoverage with specific coverage
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())) {
				List<String> list = getPolicyCovSpecific(tdmPolicyAutoSearchDTO.getPolicyCovge(),
						25, managerCsaa, "AUTO");
				if (null != list && 0 < list.size()) {
					query.append(" AND p.policynumber IN ( 'A' ");
					for (String string : list) {
						query.append(",'" + string + "'");
					}
					query.append(") ");
				} else {
					query.append(" AND 0=1");
				}
			}
			// riskCoverage with specific coverage
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getRiskCovge())) {
				List<String> list = getRiskCovSpecific(tdmPolicyAutoSearchDTO.getRiskCovge(), 25,
						managerCsaa, "AUTO");
				if (null != list && 0 < list.size()) {
					query.append(" AND p.policynumber IN ( 'A' ");
					for (String string : list) {
						query.append(",'" + string + "'");
					}
					query.append(") ");
				} else {
					query.append(" AND 0=1");
				}
			}
			if (null != policyautos) {
				query.append(" AND p.policynumber NOT IN ( 'A' ");
				query.append(policyautos);
				query.append(") ");
			}
			long startTime = System.currentTimeMillis();
			Long count = (Long) managerCsaa.createQuery(query.toString()).getSingleResult();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info("Query:  " + query.toString());
			logger.info(elapsedTime + ": Millis To execute the query :" + query);
			return count;
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

	@Override
	public List<TdmReservationDO> getReservedRecords(List<PolicysummaryDO> auPolicyDOlist,
			String userName, EntityManager managerUser) throws DAOException {
		String searchType = "CSAA_AU";
		try {
			long startTime = System.currentTimeMillis();
			@SuppressWarnings("unchecked")
			List<TdmReservationDO> list = managerUser.createQuery(
					"SELECT p FROM TdmReservationDO p where p.reserveDataType='" + searchType
							+ "' AND p.userId='" + userName + "'").getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info("Query:  " + "SELECT p FROM TdmReservationDO p where p.reserveDataType='"
					+ searchType + "' AND p.userId='" + userName + "'");
			logger.info(elapsedTime + ": Millis  To execute the query for getReservedRecords");
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
					+ "'AND p.userId'" + userId + "')";
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

	@SuppressWarnings("unchecked")
	@Override
	public List<PolicysummaryDO> searchPolicyPropRecords(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, StringBuffer policyProps, String policytype,
			StringBuffer listOfPolocies, EntityManager managerCsaaProp) throws DAOException {
		try {
			StringBuffer query = new StringBuffer(
					"SELECT p FROM PolicysummaryDO p WHERE  p.lob ='HOME' ");
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyStage())) {
				if (tdmPolicyPropertySearchDTO.getPolicyStage().equalsIgnoreCase("Active")) {
					query.append(" AND p.policystatuscd='issued' AND timedpolicystatuscd='inForce' ");
				} else if (tdmPolicyPropertySearchDTO.getPolicyStage()
						.equalsIgnoreCase("Cancelled")) {
					query.append(" AND p.policystatuscd='cancelled' ");
				} else if (tdmPolicyPropertySearchDTO.getPolicyStage().equalsIgnoreCase("Pending")) {
					query.append(" AND p.policystatuscd in ('issued','initiated','dataGather','rated','proposed','pendingCompletion','customerDeclined','companyDeclined')");
					query.append(" AND timedpolicystatuscd in ('inForcePending','pendingCompletion','proposed','customerDeclined','rated','expired','companyDeclined','initiated','dataGather') ");
				}
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyTerm())) {
				query.append(" AND p.contracttermtypecd ='")
						.append(tdmPolicyPropertySearchDTO.getPolicyTerm()).append('\'');
			}
			// child product Type
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddproductType())) {
				query.append(" AND p.policyformcd ='")
						.append(tdmPolicyPropertySearchDTO.getAddproductType()).append('\'');
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyState())) {
				query.append(" AND p.riskstatecd ='")
						.append(tdmPolicyPropertySearchDTO.getPolicyState()).append('\'');
			}
			// associated payment
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddPayReq())) {
				List<String> list = getPolicyNoForAssociatedPayment(
						tdmPolicyPropertySearchDTO.getAddPayReq(),
						tdmPolicyPropertySearchDTO.getAddPayMethod(), BILLABLEPOLICYTERM,
						managerCsaaProp);
				if (null != list && 0 < list.size()) {
					query.append(" AND p.policynumber IN ( 'A' ");
					for (String string : list) {
						query.append(",'" + string + "'");
					}
					query.append(") ");
				} else {
					query.append(" AND 0=1");
				}
			}
			// Reservation not in
			if (null != policyProps) {
				query.append(" AND p.policynumber NOT IN ( 'A' ");
				query.append(policyProps);
				query.append(") ");
			}
			// riskCoverage with specific coverage
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddRiskCovge())) {
				List<String> list = getRiskCovSpecific(
						tdmPolicyPropertySearchDTO.getAddRiskCovge(), 25, managerCsaaProp, "HOME");
				if (null != list && 0 < list.size()) {
					query.append(" AND p.policynumber IN ( 'A' ");
					for (String string : list) {
						query.append(",'" + string + "'");
					}
					query.append(") ");
				} else {
					query.append(" AND 0=1");
				}
			}
			// TODO
			// fastlane
			// Reservation not in
			if (null != listOfPolocies) {
				query.append(" AND p.policynumber IN ( 'A' ");
				query.append(listOfPolocies);
				query.append(") ");
			}
			long startTime = System.currentTimeMillis();
			List<PolicysummaryDO> policysummaryDOListAny = null;
			policysummaryDOListAny = managerCsaaProp.createQuery(query.toString())
					.setFirstResult(offSet).setMaxResults(25).getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			logger.info("Query once associated document is Y:  " + offSet + ": " + query.toString());
			logger.info(elapsedTime + ": Millis To execute the query for policy record fetch");
			return policysummaryDOListAny;
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
	public Long searchPolicyPropRecordsCount(TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			List<String> policyProps, String policytype, EntityManager managerCsaaProp)
			throws DAOException {
		try {
			StringBuffer query = new StringBuffer(
					"SELECT COUNT(*) FROM PolicysummaryDO p WHERE  p.lob ='HOME'  ");
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyStage())) {
				query.append(" AND p.policystatuscd ='")
						.append(tdmPolicyPropertySearchDTO.getPolicyStage()).append("' ");
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyTerm())) {
				query.append(" AND p.contracttermtypecd ='")
						.append(tdmPolicyPropertySearchDTO.getPolicyTerm()).append("' ");
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyState())) {
				query.append(" AND p.riskstatecd ='")
						.append(tdmPolicyPropertySearchDTO.getPolicyState()).append("' ");
			}
			// riskCoverage with specific coverage
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddRiskCovge())) {
				List<String> list = getRiskCovSpecific(
						tdmPolicyPropertySearchDTO.getAddRiskCovge(), 25, managerCsaaProp, "AUTO");
				if (null != list && 0 < list.size()) {
					query.append(" AND p.policynumber IN ( 'A' ");
					for (String string : list) {
						query.append(",'" + string + "'");
					}
					query.append(") ");
				} else {
					query.append(" AND 0=1");
				}
			}
			if (null != policyProps && !policyProps.isEmpty()) {
				query.append(" AND p.policynumber NOT IN ( 'A' ");
				for (String string : policyProps) {
					query.append(",'").append(string).append('\'');
				}
				query.append(") ");
			}
			Long count = (Long) managerCsaaProp.createQuery(query.toString()).getSingleResult();
			return count;
		} catch (IllegalStateException illegalStateEx) {
			logger.error("MessageConstant.DATABASE_EXCEPTION" + illegalStateEx);
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error("MessageConstant.DATABASE_EXCEPTION" + illegalArgEx);
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.DATABASE_EXCEPTION" + nullPointerEx);
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);
		} catch (Exception otherEx) {
			logger.error("MessageConstant.DATABASE_EXCEPTION" + otherEx);
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> getReservedRecordsHo(List<PolicysummaryDO> hoPolicyDOs,
			String userName, EntityManager managerUser) throws DAOException {
		String searchType = "CSAA_PO";
		try {
			long startTime = System.currentTimeMillis();
			@SuppressWarnings("unchecked")
			List<TdmReservationDO> list = managerUser.createQuery(
					"SELECT p FROM TdmReservationDO p where p.reserveDataType='" + searchType
							+ "' AND p.userId='" + userName + "'").getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			logger.info("Query getReservedRecordsHo:  "
					+ "SELECT p FROM TdmReservationDO p where p.reserveDataType='" + searchType
					+ "' AND p.userId='" + userName + "'");
			logger.info(elapsedTime
					+ ": Millis Time To execute the query for get Reserved for RecordsHo");
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

	public EntityManager openFastlaneEntityManager() throws DAOException {
		try {
			EntityManager managerUser = factoryCsaaFastlaneMappingUser.createEntityManager();
			return managerUser;
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);
		}
	}

	public void closeFastlaneEntityManager(EntityManager managerUser) throws DAOException {
		try {
			managerUser.close();
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);
		}
	}

	private List<PolicysummaryDO> validatePolicyDocumentWithFastLaneProperty(
			List<PolicysummaryDO> policysummaryDOsList, String docRequired, String riskState,
			EntityManager factoryCsaaFastLane2) throws DAOException {
		try {
			StringBuffer query = new StringBuffer("");
			if (riskState.equalsIgnoreCase("CA")) {
				query.append("select distinct pol_num from FASTLANE_HOME_TAB where pol_Num IN ( 'A'");
			} else {
				query.append("select distinct pol_num from Fastlane_Acaho_Tab where pol_Num IN ( 'A' ");
			}
			if (null != policysummaryDOsList && 0 < policysummaryDOsList.size()) {
				for (PolicysummaryDO policysummaryDO : policysummaryDOsList) {
					query.append(",'" + policysummaryDO.getPolicynumber() + "'");
				}
			}
			query.append(") ");
			@SuppressWarnings("unchecked")
			List<String> fastLaneList = factoryCsaaFastLane2.createNativeQuery(query.toString())
					.getResultList();
			for (int i = 0; i < policysummaryDOsList.size(); i++) {
				if (null != fastLaneList && !fastLaneList.isEmpty()) {
					for (int j = 0; j < fastLaneList.size(); j++) {
						if (policysummaryDOsList.get(i).getPolicynumber()
								.equalsIgnoreCase(fastLaneList.get(j))) {
							policysummaryDOsList.get(i).setSupportingdata("Yes");
							break;
						} else {
							policysummaryDOsList.get(i).setSupportingdata("No");
						}
					}
				} else {
					policysummaryDOsList.get(i).setSupportingdata("No");
				}
			}
			return policysummaryDOsList;
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

	public List<String> getPolicyCovSpecific(String policyCoverage, int recordsperpage,
			EntityManager managerUser, String Type) throws DAOException {
		try {
			final List<String> list = new ArrayList<String>();
			String query = "SELECT DISTINCT P.POLICYNUMBER FROM POLICYSUMMARY P, COVERAGE C "
					+ " WHERE P.POLICYDETAIL_ID = C.POLICYDETAIL_ID"
					+ " AND P.CURRENTREVISIONIND=1 AND P.LOB='" + Type + "'"
					+ " AND C.COVERAGECD IN ('" + policyCoverage + "') AND ROWNUM <="
					+ recordsperpage;
			long startTime = System.currentTimeMillis();
			final String strFinalQuery = query.toString();
			// list = managerUser.createNativeQuery(query).getResultList();
			managerUser.unwrap(Session.class).doWork(new Work()
			{
				@Override
				public void execute(Connection connection) throws SQLException {
					PreparedStatement preparedStatement = connection
							.prepareStatement(strFinalQuery);
					ResultSet resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						list.add(resultSet.getString("POLICYNUMBER"));
					}
				}
			});
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			logger.info(elapsedTime + ": Millis To execute the query :" + query);
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info(elapsedTime + ": Millis To execute the query :" + query);
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
	@SuppressWarnings("unchecked")
	public List<Object[]> getPolicyCov(StringBuffer sb, EntityManager managerCsaa)
			throws DAOException {
		try {
			List<Object[]> lists = null;
			StringBuffer query = new StringBuffer(
					"SELECT DISTINCT P.POLICYNUMBER,C.COVERAGECD FROM POLICYSUMMARY P, COVERAGE C ");
			query.append("WHERE P.POLICYDETAIL_ID = C.POLICYDETAIL_ID AND P.CURRENTREVISIONIND=1  AND P.POLICYNUMBER IN ('A'");
			query.append(sb);
			query.append(")");
			long startTime = System.currentTimeMillis();
			lists = managerCsaa.createNativeQuery(query.toString()).getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info(elapsedTime + ": Millis To execute the query :" + query);
			return lists;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getPolicyRiskCov(StringBuffer sb, String type, EntityManager managerCsaa)
			throws DAOException {
		try {
			List<Object[]> lists = null;
			StringBuffer query = new StringBuffer(
					"SELECT DISTINCT P.POLICYNUMBER,C.COVERAGECD FROM POLICYSUMMARY P, RISKITEM RI, COVERAGE C ");
			query.append("WHERE P.POLICYDETAIL_ID = RI.POLICYDETAIL_ID AND RI.ID = C.RISKITEM_ID AND P.POLICYNUMBER IN ('A'");
			query.append(sb);
			query.append(")");
			long startTime = System.currentTimeMillis();
			lists = managerCsaa.createNativeQuery(query.toString()).getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info(elapsedTime + ": Millis To execute the query :" + query);
			return lists;
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

	public List<String> getRiskCovSpecific(String riskCoverage, int recordsperpage,
			EntityManager managerUser, String Type) throws DAOException {
		try {
			final List<String> list = new ArrayList<String>();
			StringBuffer query = new StringBuffer(
					"SELECT DISTINCT P.POLICYNUMBER FROM POLICYSUMMARY P, RISKITEM RI, COVERAGE C ");
			query.append("WHERE P.POLICYDETAIL_ID = RI.POLICYDETAIL_ID AND RI.ID = C.RISKITEM_ID AND P.CURRENTREVISIONIND=1");
			query.append("AND P.LOB='" + Type + "' AND C.COVERAGECD IN ('" + riskCoverage
					+ "') AND ROWNUM <=" + recordsperpage);
			long startTime = System.currentTimeMillis();
			final String strFinalQuery = query.toString();
			managerUser.unwrap(Session.class).doWork(new Work()
			{
				@Override
				public void execute(Connection connection) throws SQLException {
					PreparedStatement preparedStatement = connection
							.prepareStatement(strFinalQuery);
					ResultSet resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						list.add(resultSet.getString("POLICYNUMBER"));
					}
				}
			});
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			logger.info(elapsedTime + ": Millis To execute the query :" + query);
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info(elapsedTime + ": Millis To execute the query :" + query);
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

	@SuppressWarnings("unchecked")
	private List<String> getPolicyAndRiskCovSpecific(String policyCoverage, String riskCoverage,
			int recordsperpage, EntityManager managerUser, String Type) throws DAOException {
		try {
			List<String> list = null;
			String query = "SELECT DISTINCT P.POLICYNUMBER FROM POLICYSUMMARY P, COVERAGE C,RISKITEM RI "
					+ " WHERE P.POLICYDETAIL_ID = C.POLICYDETAIL_ID AND P.POLICYDETAIL_ID = RI.POLICYDETAIL_ID"
					+ " AND P.CURRENTREVISIONIND=1 AND P.LOB='"
					+ Type
					+ "'"
					+ " AND C.COVERAGECD IN ('"
					+ policyCoverage
					+ "','"
					+ riskCoverage
					+ "') AND ROWNUM <=" + recordsperpage;
			long startTime = System.currentTimeMillis();
			list = managerUser.createNativeQuery(query.toString()).getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info(elapsedTime + ": Millis To execute the query :" + query);
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

	private List<String> getDerivedFieldsValues(String strInputValue, List<Object[]> lstResult,
			String strDerivedType) {
		List<String> listResult = new ArrayList<String>();
		if (mapDerivedFields == null) {
			mapDerivedFields = new HashMap<String, Map<String, String>>();
		}
		for (int i = 0; i < lstResult.size(); i++) {
			if (mapDerivedFields.containsKey(lstResult.get(i)[0])) {
				if (StringUtils.isNotEmpty(strInputValue)) {
					if (strInputValue.equals(lstResult.get(i)[1] + "")) {
						Map<String, String> mapTempResult = mapDerivedFields
								.get(lstResult.get(i)[0]);
						getReplaceMap(strDerivedType, mapTempResult, lstResult.get(i));
						listResult.add(lstResult.get(i)[0] + "");
					}
				} else {
					Map<String, String> mapTempResult = mapDerivedFields.get(lstResult.get(i)[0]);
					getReplaceMap(strDerivedType, mapTempResult, lstResult.get(i));
					listResult.add(lstResult.get(i)[0] + "");
				}
			} else {
				if (StringUtils.isNotEmpty(strInputValue)) {
					if (strInputValue.equals(lstResult.get(i)[1] + "")) {
						Map<String, String> mapTempResult = new HashMap<String, String>();
						mapDerivedFields.put(lstResult.get(i)[0] + "",
								getReplaceMap(strDerivedType, mapTempResult, lstResult.get(i)));
						listResult.add(lstResult.get(i)[0] + "");
					}
				} else {
					Map<String, String> mapTempResult = new HashMap<String, String>();
					mapDerivedFields.put(lstResult.get(i)[0] + "",
							getReplaceMap(strDerivedType, mapTempResult, lstResult.get(i)));
					listResult.add(lstResult.get(i)[0] + "");
				}
			}
		}
		return listResult;
	}

	private Map<String, String> getReplaceMap(String strDerivedType,
			Map<String, String> mapTempResult, Object[] objArray) {
		if (strDerivedType.equals(tabDriver)) {
			mapTempResult.put(tabDriver, objArray.length > 1 ? objArray[1] + "" : "");
		}
		if (strDerivedType.equals(tabVehi)) {
			mapTempResult.put(tabVehi, objArray.length > 1 ? objArray[1] + "" : "");
		}
		if (strDerivedType.equals(tabViolats)) {
			mapTempResult.put(tabViolats, objArray.length > 1 ? objArray[1] + "" : "");
		}
		if (strDerivedType.equals(tabNo_Of_Named_Insured)) {
			mapTempResult.put(tabNo_Of_Named_Insured, objArray.length > 1 ? objArray[1] + "" : "");
		}
		return mapTempResult;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getPolicyNoNamedInsuredDetails(String no, String tabName,
			EntityManager managerUser) throws DAOException {
		try {
			List<Object[]> list = null;
			String query = "SELECT P.POLICYNUMBER,count(*) as countValue FROM INSUREDPRINCIPAL IP, POLICYSUMMARY P WHERE IP.POLICYDETAIL_ID=P.POLICYDETAIL_ID"
					+ "	AND P.CURRENTREVISIONIND="
					+ 1
					+ " AND IP.SEQNO IS NOT NULL "
					+ "GROUP BY P.POLICYNUMBER ";
			long startTime = System.currentTimeMillis();
			list = managerUser.createNativeQuery(query).getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info("Query:  " + query.toString());
			logger.info(elapsedTime + ": Millis To execute the query :" + query);
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

	@SuppressWarnings("unchecked")
	public List<Object[]> getPolicyNoDetails(String no, String tabName, EntityManager managerUser)
			throws DAOException {
		try {
			List<Object[]> list = null;
			String query = null;
			if (tabName.equals(tabDriver)) {
				query = "SELECT PS.POLICYNUMBER,count(*) as countValue FROM POLICYSUMMARY PS, DRIVER D "
						+ "WHERE PS.POLICYDETAIL_ID=D.POLICYDETAIL_ID AND PS.CURRENTREVISIONIND="
						+ 1 + " AND D.SEQNO IS NOT NULL " + "GROUP BY PS.POLICYNUMBER";
			}
			if (tabName.equals(tabVehi)) {
				query = "SELECT PS.policynumber,COUNT(*) AS countValue FROM POLICYSUMMARY PS,RISKITEM R WHERE PS.policydetail_Id=R.policydetail_Id"
						+ " AND PS.currentrevisionind=1 AND PS.lob='AUTO' AND R.seqno IS NOT NULL GROUP BY PS.policynumber";
				System.out.println("veliiiii " + query);
			}
			if (tabName.equals(tabViolats)) {
				query = "SELECT P.POLICYNUMBER,count(*) as countValue FROM DRIVER DR, POLICYSUMMARY P, ACCIDENTVIOLATION AV "
						+ "WHERE DR.POLICYDETAIL_ID=P.POLICYDETAIL_ID AND DR.ID = AV.DRIVER_ID AND P.CURRENTREVISIONIND ="
						+ 1 + " and AV.SEQNO IS NOT NULL " + "GROUP BY P.POLICYNUMBER";
			}
			long startTime = System.currentTimeMillis();
			list = managerUser.createNativeQuery(query).getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info("Query for getPolicyNo:  " + query.toString());
			logger.info(elapsedTime);
			logger.info(": Millis To execute the query search Policy Auto Records : " + elapsedTime);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<CassPolListDO> getRecordsWithConditionPASFL(String assoDocReq, int offSet,
			int recordsperpage, StringBuffer policyautos, String policytype,
			EntityManager managerUser) throws DAOException {
		try {
			StringBuffer query = new StringBuffer(
					"SELECT p FROM CassPolListDO p WHERE  0=0 AND p.flag='Y'");
			query.append(" AND p.lob = '" + policytype + '\'');
			if (null != policyautos) {
				query.append(" AND p.policyNumber NOT IN ( 'A' ");
				query.append(policyautos);
				query.append(") ");
			}
			long startTime = System.currentTimeMillis();
			List<CassPolListDO> cassPolListDOs = managerUser.createQuery(query + "")
					.setFirstResult(offSet).setMaxResults(2000).getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info("Query:  " + query.toString());
			logger.info(elapsedTime + ": Millis To execute the query :" + query);
			return cassPolListDOs;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchPolicyAutoRecordsByPolicySearch(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, boolean pageNationOnOffFlag,
			int recordsperpage, StringBuffer policyautos, String ptype, EntityManager managerCsaa)
			throws DAOException {
		try {
			StringBuffer newnativeQuery = new StringBuffer("SELECT DISTINCT(P.POLICYNUMBER),"); // 1
			newnativeQuery.append("P.POLICY_STAGE ,"); // 2
			newnativeQuery.append("P.RISKSTATECD ,"); // 3
			newnativeQuery.append("P.CONTRACTTERMTYPECD ,"); // 4
			newnativeQuery.append("P.EFFECTIVE ,"); // 5
			newnativeQuery.append("P.EXPIRATION,"); // 6
			newnativeQuery.append("P.POLICY_COVERAGE ,");// 7
			newnativeQuery.append("P.RISK_COVERAGE ,"); // 8
			newnativeQuery.append("P.PRODUCTCD  ,"); // 9
			newnativeQuery.append("P.NOOF_DRIVERS ,"); // 10
			newnativeQuery.append("P.NOOF_VEHICLES ,"); // 11
			newnativeQuery.append("P.NOOF_VIOLATIONS ,"); // 12
			newnativeQuery.append("P.NOOF_NAMEDINSURED ,"); // 13
			newnativeQuery.append("P.DOCUMENT_TYPE ,"); // 14
			newnativeQuery.append("P.PAYMENT_TYPE ,"); // 15
			newnativeQuery.append("P.LOB  ,"); // 16
			newnativeQuery.append("P.POLICYDETAIL_ID "); // 17
			newnativeQuery.append("FROM TDM_POLICYSEARCH P  WHERE P.LOB ='AUTO'");
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyStage())) {
				if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase("Active")) {
					newnativeQuery
							.append(" AND P.POLICYSTATUSCD  ='issued' AND TIMEDPOLICYSTATUSCD='inForce' ");
				} else if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase("Cancelled")) {
					newnativeQuery.append(" AND p.POLICYSTATUSCD='cancelled' ");
				} else if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase("Pending")) {
					newnativeQuery
							.append(" AND p.POLICYSTATUSCD in ('issued','initiated','dataGather','rated','proposed','pendingCompletion','customerDeclined','companyDeclined')");
					newnativeQuery
							.append(" AND TIMEDPOLICYSTATUSCD in ('inForcePending','pendingCompletion','proposed','customerDeclined','rated','expired','companyDeclined','initiated','dataGather' ) ");
				}
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyTerm())) {
				newnativeQuery.append(" AND P.CONTRACTTERMTYPECD ='")
						.append(tdmPolicyAutoSearchDTO.getPolicyTerm()).append("' ");
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyState())) {
				newnativeQuery.append(" AND P.RISKSTATECD ='")
						.append(tdmPolicyAutoSearchDTO.getPolicyState()).append("' ");
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAddproductType())) {
				newnativeQuery.append(" AND P.PRODUCTCD ='")
						.append(tdmPolicyAutoSearchDTO.getAddproductType()).append("' ");
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfDrivers())) {
				newnativeQuery.append(" AND p.NOOF_DRIVERS =").append(
						tdmPolicyAutoSearchDTO.getNoOfDrivers());
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfVehi())) {
				newnativeQuery.append(" AND p.NOOF_VEHICLES =").append(
						tdmPolicyAutoSearchDTO.getNoOfVehi());
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfViola())) {
				newnativeQuery.append(" AND p.NOOF_VIOLATIONS =").append(
						tdmPolicyAutoSearchDTO.getNoOfViola());
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfNamedInsu())) {
				newnativeQuery.append(" AND p.NOOF_NAMEDINSURED =").append(
						tdmPolicyAutoSearchDTO.getNoOfNamedInsu());
			}

			// cov
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())
					|| StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getRiskCovge())) {
				if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())) {
					newnativeQuery.append(" AND P.POLICY_COVERAGE    ='")
							.append(tdmPolicyAutoSearchDTO.getPolicyCovge()).append('\'');
				} else {
					newnativeQuery.append(" AND P.RISK_COVERAGE      ='")
							.append(tdmPolicyAutoSearchDTO.getRiskCovge()).append('\'');
				}
				if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getRiskCovge())) {
					newnativeQuery.append(" AND P.RISK_COVERAGE      ='")
							.append(tdmPolicyAutoSearchDTO.getRiskCovge()).append('\'');
				} else {
					newnativeQuery.append(" AND P.POLICY_COVERAGE      ='")
							.append(tdmPolicyAutoSearchDTO.getPolicyCovge()).append('\'');
				}
			}

			if (!StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())
					&& !StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getRiskCovge())) {
				newnativeQuery.append(" AND P.POLICY_COVERAGE    ='BI'");
				newnativeQuery.append(" AND P.RISK_COVERAGE      ='BI'");
			}

			newnativeQuery.append("AND P.PRODUCTCD NOT  IN ('AAA_PUP_SS')");
			// Reservation not in
			if (null != policyautos) {
				newnativeQuery.append(" AND P.POLICYNUMBER NOT IN ('A' ");
				newnativeQuery.append(policyautos);
				newnativeQuery.append(") ");
			}
			long startTime = System.currentTimeMillis();
			List<Object[]> policySearchDo = null;
			policySearchDo = managerCsaa.createNativeQuery(newnativeQuery + "")
					.setFirstResult(offSet).setMaxResults(25).getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			if ((elapsedTime / 60000) > 1) {
				throw new DAOException(
						"Query taking more than one min time for validating the records");
			}
			logger.info("Query if document is selected NO:  " + newnativeQuery.toString());
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
	public List<TdmPolicySearchDO> searchPolicyPropRecordsByPolicySearch(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, StringBuffer policyProps, String policytype,
			EntityManager managerCsaaProp) throws DAOException {
		try {
			StringBuffer query = new StringBuffer(
					"SELECT distinct p  FROM TdmPolicySearchDO p WHERE  p.lob ='HOME' ");
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyStage())) {
				if (tdmPolicyPropertySearchDTO.getPolicyStage().equalsIgnoreCase("Active")) {
					query.append(" AND p.policystatuscd='issued' AND timedpolicystatuscd='inForce' ");
				} else if (tdmPolicyPropertySearchDTO.getPolicyStage()
						.equalsIgnoreCase("Cancelled")) {
					query.append(" AND p.policystatuscd='cancelled' ");
				} else if (tdmPolicyPropertySearchDTO.getPolicyStage().equalsIgnoreCase("Pending")) {
					query.append(" AND p.policystatuscd in ('issued','initiated','dataGather','rated','proposed','pendingCompletion','customerDeclined','companyDeclined')");
					query.append(" AND timedpolicystatuscd in ('inForcePending','pendingCompletion','proposed','customerDeclined','rated','expired','companyDeclined','initiated','dataGather') ");
				}
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyTerm())) {
				query.append(" AND p.policyterm ='")
						.append(tdmPolicyPropertySearchDTO.getPolicyTerm()).append('\'');
			}
			// child product Type
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddproductType())) {
				query.append(" AND p.policyformcd ='")
						.append(tdmPolicyPropertySearchDTO.getAddproductType()).append('\'');
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getPolicyState())) {
				query.append(" AND p.riskstatecd ='")
						.append(tdmPolicyPropertySearchDTO.getPolicyState()).append('\'');
			}
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddRiskCovge())) {
				query.append(" AND p.risklevelcoverage ='")
						.append(tdmPolicyPropertySearchDTO.getAddRiskCovge()).append('\'');
			}
			// associated payment
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddPayReq())) {
			}
			// Reservation not in
			if (null != policyProps) {
				query.append(" AND p.policynumber NOT IN ( 'A' ");
				query.append(policyProps);
				query.append(") ");
			}
			long startTime = System.currentTimeMillis();
			List<TdmPolicySearchDO> policySearchDOListAny = null;
			policySearchDOListAny = managerCsaaProp
					.createQuery(query.toString(), TdmPolicySearchDO.class).setFirstResult(offSet)
					.setMaxResults(25).getResultList();
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			logger.info("Query once associated document is Y:  " + offSet + ": " + query.toString());
			logger.info(elapsedTime + ": Millis To execute the query for policy record fetch");
			return policySearchDOListAny;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<TdmPolicySearchDO> searchPolicyAutoRecordsByPolicySearchNew(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, boolean pageNationOnOffFlag,
			int recordsperpage, StringBuffer policyautos, String ptype, EntityManager managerCsaa)
			throws DAOException {
		try {
			StringBuffer query = new StringBuffer(
					"SELECT distinct p  FROM TdmPolicySearchDO p WHERE  p.lob ='AUTO' ");

			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyStage())) {
				if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase("Active")) {
					query.append(" AND P.policystatuscd  ='issued' AND TIMEDPOLICYSTATUSCD='inForce' ");
				} else if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase("Cancelled")) {
					query.append(" AND p.policystatuscd='cancelled' ");
				} else if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase("Pending")) {
					query.append(" AND p.policystatuscd in ('issued','initiated','dataGather','rated','proposed','pendingCompletion','customerDeclined','companyDeclined')");
					query.append(" AND timedpolicystatuscd in ('inForcePending','pendingCompletion','proposed','customerDeclined','rated','expired','companyDeclined','initiated','dataGather' ) ");
				}
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyTerm())) {
				query.append(" AND P.policyterm ='").append(tdmPolicyAutoSearchDTO.getPolicyTerm())
						.append("' ");
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyState())) {
				query.append(" AND P.riskstatecd ='")
						.append(tdmPolicyAutoSearchDTO.getPolicyState()).append("' ");
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAddproductType())) {
				query.append(" AND P.productcd ='")
						.append(tdmPolicyAutoSearchDTO.getAddproductType()).append("' ");
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfDrivers())) {
				query.append(" AND p.noofdrivers =")
						.append(tdmPolicyAutoSearchDTO.getNoOfDrivers());
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfVehi())) {
				query.append(" AND p.noofvehicles =").append(tdmPolicyAutoSearchDTO.getNoOfVehi());
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfViola())) {
				query.append(" AND p.noofviolations =").append(
						tdmPolicyAutoSearchDTO.getNoOfViola());
			}
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfNamedInsu())) {
				query.append(" AND p.noofnamedinsured =").append(
						tdmPolicyAutoSearchDTO.getNoOfNamedInsu());
			}

			// cov
			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())
					|| StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getRiskCovge())) {
				if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())) {
					query.append(" AND P.policycoverage    ='")
							.append(tdmPolicyAutoSearchDTO.getPolicyCovge()).append('\'');
				} else {
					query.append(" AND P.risklevelcoverage      ='")
							.append(tdmPolicyAutoSearchDTO.getRiskCovge()).append('\'');
				}
				if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getRiskCovge())) {
					query.append(" AND p.risklevelcoverage      ='")
							.append(tdmPolicyAutoSearchDTO.getRiskCovge()).append('\'');
				} else {
					query.append(" AND p.policycoverage      ='")
							.append(tdmPolicyAutoSearchDTO.getPolicyCovge()).append('\'');
				}
			}

			if (!StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())
					&& !StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getRiskCovge())) {
				query.append(" AND p.policycoverage    ='BI'");
				query.append(" AND p.risklevelcoverage      ='BI'");
			}

			query.append("AND p.productcd NOT  IN ('AAA_PUP_SS')");
			// Reservation not in
			if (null != policyautos) {
				query.append(" AND p.policynumber NOT IN ('A' ");
				query.append(policyautos);
				query.append(") ");
			}
			long startTime = System.currentTimeMillis();
			List<TdmPolicySearchDO> policySearchDo = null;
			policySearchDo = managerCsaa.createQuery(query + "").setFirstResult(offSet)
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
}
