/*
 * Object Name : TdmPolicyAutoPropSearchDAOImpl.java Modification Block
 * ------------------------------------------------------------------ S.No. Name Date Bug_Fix_No
 * Desc ------------------------------------------------------------------ 1. vkrish14 2:53:09 PM
 * Created ------------------------------------------------------------------ Copyrights: 2015
 * Capgemini.com
 */
package com.tesda.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.tesda.dao.TdmPolicyAutoPropSearchDAO;
import com.tesda.exception.DAOException;
import com.tesda.model.DO.PolicySummaryStgDO;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;

/**
 * @author vkrish14
 *
 */

public class TdmPolicyAutoPropSearchDAOImpl implements TdmPolicyAutoPropSearchDAO
{
	final static Logger logger = Logger.getLogger(TdmPolicyAutoPropSearchDAOImpl.class);

	@Autowired
	private MessageSource messageSource;

	@Override
	public List<PolicySummaryStgDO> searchPolicyAutoRecordsByPolicySearch(
			final TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, final int offSet,
			final boolean pageNationOnOffFlag, final int recordsperpage,
			final StringBuffer policyautos, final String ptype, EntityManager managerCsaa)
			throws DAOException {
		try {
			final List<PolicySummaryStgDO> lstResult = new ArrayList<PolicySummaryStgDO>();
			managerCsaa.unwrap(Session.class).doWork(new Work()
			{
				@Override
				public void execute(Connection con) throws SQLException {
					StringBuffer query = new StringBuffer(
							"SELECT p.POLICYNUMBER, p.LOB, p.POLICYSTATUSCD, p.POLICYFORMCD, p.TIMEDPOLICYSTATUSCD, p.TXTYPE, p.CONTRACTTERMTYPECD, p.PRODUCTCD, p.RISKSTATECD, p.EFFECTIVE, p.EXPIRATION,p.POLICYDETAIL_ID, p.CURRENTREVISIONIND, p.NO_OF_DRIVERS, p.NO_OF_VEHI, p.NO_OF_INSU, p.NO_OF_VIO, p.DOC_YN FROM POLICY_SUMMARY_STG p,COVERAGE_RISK_STG cov WHERE  p.lob ='AUTO'  ");

					if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyStage())) {
						if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase("Active")) {
							query.append(" AND p.policystatuscd='issued' AND timedpolicystatuscd='inForce' ");
						} else if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase(
								"Cancelled")) {
							query.append(" AND p.policystatuscd='cancelled' ");
						} else if (tdmPolicyAutoSearchDTO.getPolicyStage().equalsIgnoreCase(
								"Pending")) {
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
					boolean bCheckCurrentVersion = false;
					if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfDrivers())) {
						if (!bCheckCurrentVersion) {
							query.append(" AND p.currentrevisionind =1 ");
						}
						query.append(" AND p.NO_OF_DRIVERS =").append(
								tdmPolicyAutoSearchDTO.getNoOfDrivers());
					}
					if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfVehi())) {
						if (!bCheckCurrentVersion) {
							query.append(" AND p.currentrevisionind =1 ");
						}
						query.append(" AND p.NO_OF_VEHI =").append(
								tdmPolicyAutoSearchDTO.getNoOfVehi());
					}
					if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfViola())) {
						if (!bCheckCurrentVersion) {
							query.append(" AND p.currentrevisionind =1 ");
						}
						query.append(" AND p.NO_OF_VIO =").append(
								tdmPolicyAutoSearchDTO.getNoOfViola());
					}
					if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getNoOfNamedInsu())) {
						if (!bCheckCurrentVersion) {
							query.append(" AND p.currentrevisionind =1 ");
						}
						query.append(" AND p.NO_OF_INSU =").append(
								tdmPolicyAutoSearchDTO.getNoOfNamedInsu());
					}

					/*
					 * if(StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPayMethod())){
					 * query.append(" AND p.paymethod =")
					 * .append(tdmPolicyAutoSearchDTO.getPayMethod()).append(" AND p.tablename =")
					 * .append(BILLABLEPOLICYTERM); }
					 */

					if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())) {
						query.append(" AND cov.coveragecd ='")
								.append(tdmPolicyAutoSearchDTO.getPolicyCovge()).append('\'');
					}
					if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getRiskCovge())) {
						query.append(" AND cov.coveragecd ='")
								.append(tdmPolicyAutoSearchDTO.getRiskCovge()).append('\'');
					}

					query.append(" AND p.productcd  not in('").append("AAA_PUP_SS").append("') ");
					query.append(" AND cov.policydetailId=p.policydetailId ");
					if (null != policyautos) {
						query.append(" AND p.policynumber NOT IN ( 'A' ");
						query.append(policyautos);
						query.append(") ");
					}

					PreparedStatement pst = con.prepareStatement(query.toString());
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						PolicySummaryStgDO policySummaryStgDO = new PolicySummaryStgDO();
						policySummaryStgDO.setContracttermtypecd(rs.getString("contracttermtypecd"));
						policySummaryStgDO.setCurrentrevisionind(rs.getString("currentrevisionind"));
						policySummaryStgDO.setDocYn(rs.getString("DOC_YN"));
						policySummaryStgDO.setEffective(rs.getDate("effective"));
						policySummaryStgDO.setExpiration(rs.getDate("expiration"));
						// policyU
						lstResult.add(policySummaryStgDO);
					}
				}
			});

			return lstResult;

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
	public List<PolicySummaryStgDO> searchPolicyPropRecordsByPolicySearch(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, StringBuffer policyProps, String policytype,
			EntityManager managerCsaaProp) throws DAOException {
		try {
			StringBuffer query = new StringBuffer(
					"SELECT p FROM TdmPolicySearchDO p JOIN WHERE  p.lob ='HOME' ");
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
			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddRiskCovge())) {
				query.append(" AND p.riskcoverage ='")
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

			List<PolicySummaryStgDO> policySearchDOListAny = null;

			policySearchDOListAny = managerCsaaProp
					.createQuery(query.toString(), PolicySummaryStgDO.class).setFirstResult(offSet)
					.setMaxResults(5).getResultList();

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
}
