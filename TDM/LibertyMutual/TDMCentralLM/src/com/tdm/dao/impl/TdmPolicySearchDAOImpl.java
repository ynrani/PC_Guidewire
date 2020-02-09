/*---------------------------------------------------------------------------------------
 * Object Name: TdmPolicySearchDAOImpl.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          19/08/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tdm.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.dao.TdmPolicySearchDAO;
import com.tdm.exception.DAOException;
import com.tdm.exception.ServiceException;
import com.tdm.model.DO.TdmReservationDO;
import com.tdm.model.DTO.TdmPolicyClaimSearchDTO;
import com.tdm.model.DTO.TdmPolicySearchDTO;

/**
 * 
 * @author Seshadri Chowdary
 *
 */
@Component(MessageConstant.TDM_POLICY_CLAIM_SEARCH_DAO)
public class TdmPolicySearchDAOImpl implements TdmPolicySearchDAO
{

	private static Logger logger = Logger.getLogger(TdmPolicySearchDAOImpl.class);

	@Override
	public List<Object[]> searchPolicyRecords(TdmPolicySearchDTO tdmPolicySearchDTO, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, StringBuffer policys,
			EntityManager managerPolicySearch) throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_POLICY_SEARCH
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			StringBuffer query = new StringBuffer(
					"SELECT DISTINCT(PCPOP.POLICYNUMBER),PCPOP.PRIMARYINSUREDNAME,PCPO.PRODUCTCODE,PCTLSTS.TYPECODE, ");
			query.append("PCPOP.PERIODSTART,PCPOP.PERIODEND, PCAC.ACCOUNTNUMBER,PCD.CODE, PCPO.ID ");
			query.append("FROM PC_POLICY PCPO,PC_POLICYPERIOD PCPOP, ");
			query.append("PC_ACCOUNT PCAC, PCTL_POLICYPERIODSTATUS PCTLSTS , PC_PRODUCERCODE PCD ");
			query.append("WHERE PCPO.ID=PCPOP.POLICYID ");
			query.append("AND PCPO.ACCOUNTID=PCAC.ID AND PCPOP.STATUS=PCTLSTS.ID ");

			if (null != policys) {
				query.append("AND PCPOP.POLICYNUMBER NOT IN ( 'A' ");
				query.append(policys);
				query.append(") ");
			}

			query.append("AND PCPOP.PRODUCERCODEOFRECORDID = PCD.ID ");
			query.append("AND (PCPOP.POLICYID,PCPOP.PERIODEND) ");
			query.append("IN ");
			query.append("(SELECT POLICYID,  MAX(PERIODEND) AS PERIODEND  FROM PC_POLICYPERIOD GROUP BY POLICYID) ");
			query.append("AND PCPOP.POLICYNUMBER != 'Unassigned' ");

			// status
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getPolicyStatus())) {
				query.append(" AND PCPOP.STATUS= '" + tdmPolicySearchDTO.getPolicyStatus() + '\'');
			}
			// state
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getPolicyState())) {
				query.append(" AND PCPOP.BASESTATE= '" + tdmPolicySearchDTO.getPolicyState() + '\'');
			}
			// policy no
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getPolicyNo())) {
				query.append(" AND PCPOP.POLICYNUMBER= '" + tdmPolicySearchDTO.getPolicyNo() + '\'');
			}

			// acc no
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getAccNo())) {
				query.append(" AND PCAC.ACCOUNTNUMBER= '" + tdmPolicySearchDTO.getAccNo() + '\'');
			}

			// Named Insured
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getNamedInsu())) {
				query.append(" AND PCPOP.PRIMARYINSUREDNAME LIKE '%"
						+ tdmPolicySearchDTO.getNamedInsu() + "%' ");
			}
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<Object[]> list = managerPolicySearch.createNativeQuery(query.toString())
					.setFirstResult(offSet).setMaxResults(recordsperpage).getResultList();

			logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_POLICY_SEARCH
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_POLICY_SEARCH
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_POLICY_SEARCH
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_POLICY_SEARCH
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_POLICY_SEARCH
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long searchPolicyRecordsCount(TdmPolicySearchDTO tdmPolicySearchDTO,
			StringBuffer policys, EntityManager managerPolicySearch) throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_POLICY_SEARCH_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			StringBuffer query = new StringBuffer(
					"SELECT DISTINCT(PCPOP.POLICYNUMBER),PCPOP.PRIMARYINSUREDNAME,PCPO.PRODUCTCODE,PCTLSTS.TYPECODE, ");
			query.append("PCPOP.PERIODSTART,PCPOP.PERIODEND, PCAC.ACCOUNTNUMBER,PCD.CODE, PCPO.ID ");
			query.append("FROM PC_POLICY PCPO,PC_POLICYPERIOD PCPOP, ");
			query.append("PC_ACCOUNT PCAC, PCTL_POLICYPERIODSTATUS PCTLSTS , PC_PRODUCERCODE PCD ");
			query.append("WHERE PCPO.ID=PCPOP.POLICYID ");
			query.append("AND PCPO.ACCOUNTID=PCAC.ID AND PCPOP.STATUS=PCTLSTS.ID ");
			if (null != policys) {
				query.append("AND PCPOP.POLICYNUMBER NOT IN ( 'A' ");
				query.append(policys);
				query.append(") ");
			}
			query.append("AND PCPOP.PRODUCERCODEOFRECORDID = PCD.ID ");
			query.append("AND (PCPOP.POLICYID,PCPOP.PERIODEND) ");
			query.append("IN ");
			query.append("(SELECT POLICYID,  MAX(PERIODEND) AS PERIODEND  FROM PC_POLICYPERIOD GROUP BY POLICYID) ");
			query.append("AND PCPOP.POLICYNUMBER != 'Unassigned' ");

			// status
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getPolicyStatus())) {
				query.append(" AND PCPOP.STATUS= '" + tdmPolicySearchDTO.getPolicyStatus() + '\'');
			}
			// state
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getPolicyState())) {
				query.append(" AND PCPOP.BASESTATE= '" + tdmPolicySearchDTO.getPolicyState() + '\'');
			}
			// acc no
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getPolicyNo())) {
				query.append(" AND PCPOP.POLICYNUMBER= '" + tdmPolicySearchDTO.getPolicyNo() + '\'');
			}

			// acc no
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getAccNo())) {
				query.append(" AND PCAC.ACCOUNTNUMBER= '" + tdmPolicySearchDTO.getAccNo() + '\'');
			}
			// Named Insured
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getNamedInsu())) {
				query.append(" AND PCPOP.PRIMARYINSUREDNAME LIKE '%"
						+ tdmPolicySearchDTO.getNamedInsu() + "%' ");
			}

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<Object[]> list = managerPolicySearch.createNativeQuery(query.toString())
					.getResultList();
			Long count = 0l;
			if (null != list && !list.isEmpty()) {
				count = Long.parseLong(String.valueOf(list.size()));
			}
			logger.info(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_SEARCH_CNT + MessageConstant.LOG_INFO_RETURN);
			return count;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_SEARCH_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_SEARCH_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_SEARCH_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_SEARCH_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<Object[]> getPolicyRecords(StringBuffer policys, EntityManager managerPolicySearch)
			throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_POLICY_GET_POL_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			StringBuffer query = new StringBuffer(
					"SELECT DISTINCT(PCPOP.POLICYNUMBER),PCPOP.PRIMARYINSUREDNAME,PCPO.PRODUCTCODE,PCTLSTS.TYPECODE, ");
			query.append("PCPOP.PERIODSTART,PCPOP.PERIODEND, PCAC.ACCOUNTNUMBER,PCD.CODE, PCPO.ID ");
			query.append("FROM PC_POLICY PCPO,PC_POLICYPERIOD PCPOP, ");
			query.append("PC_ACCOUNT PCAC, PCTL_POLICYPERIODSTATUS PCTLSTS , PC_PRODUCERCODE PCD ");
			query.append("WHERE PCPO.ID=PCPOP.POLICYID ");
			query.append("AND PCPO.ACCOUNTID=PCAC.ID AND PCPOP.STATUS=PCTLSTS.ID ");
			if (null != policys) {
				query.append("AND PCPOP.POLICYNUMBER IN ( 'A' ");
				query.append(policys);
				query.append(") ");
			}
			query.append("AND PCPOP.PRODUCERCODEOFRECORDID = PCD.ID ");
			query.append("AND (PCPOP.POLICYID,PCPOP.PERIODEND) ");
			query.append("IN ");
			query.append("(SELECT POLICYID,  MAX(PERIODEND) AS PERIODEND  FROM PC_POLICYPERIOD GROUP BY POLICYID) ");
			query.append("AND PCPOP.POLICYNUMBER != 'Unassigned' ");

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<Object[]> list = managerPolicySearch.createNativeQuery(query.toString())
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

	@Override
	public List<Object[]> searchClaimRecords(TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO,
			int offSet, int recordsperpage, boolean pageNationOnOffFlag, StringBuffer claims,
			EntityManager managerClaimSearch) throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_CLAIM_SEARCH
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			StringBuffer query = new StringBuffer(
					" SELECT DISTINCT(CCC.CLAIMNUMBER),  CCP.POLICYNUMBER AS POLICYNO,  CCCON.FIRSTNAME  || ' '  || CCCON.LASTNAMEDENORM AS INSUNAME, CCTLSTS.NAME AS STS, ");
			query.append(" CCTLSRC.NAME AS NA, CCC.LOSSDATE,  TO_CHAR(NVL(X.TOTALPAYMENT,0), '990.00') AS AmountTotal , TO_CHAR(NVL(Y.TOTALRESERVES,0) - NVL(Z.TOTALRECEOVERY,0), '9990.00') AS NetIncurred, ");
			query.append(" CCTLLOB.NAME   AS LOB,   CCP.ID ");
			query.append(" FROM CC_POLICY CCP,  CC_CLAIM CCC,  CC_CLAIMCONTACT CC, ");
			query.append(" CC_CLAIMCONTACTROLE CCR, CCTL_CONTACTROLE CR, CC_CONTACT CCCON, ");
			query.append(" CCTL_LOBCODE CCTLLOB, CCTL_POLICYSTATUS CCTLSTS,  CCTL_SOURCESYSTEM CCTLSRC , ");
			query.append(" (SELECT C.CLAIMNUMBER , SUM(B.TOTAL) AS TOTALPAYMENT FROM CC_CLAIM C,  ");
			query.append(" (SELECT CLAIMID, ID FROM CC_TRANSACTION WHERE SUBTYPE = 1 ) A, ");
			query.append(" (SELECT TRANSACTIONID, SUM(TRANSACTIONAMOUNT) AS TOTAL  FROM CC_TRANSACTIONLINEITEM GROUP BY TRANSACTIONID ) B ");
			query.append(" WHERE A.CLAIMID = C.ID AND A.ID = B.TRANSACTIONID GROUP BY C.CLAIMNUMBER ) X, ");
			query.append(" ( SELECT C.CLAIMNUMBER , SUM(B.TOTAL) AS TOTALRESERVES FROM CC_CLAIM C, ");
			query.append(" (SELECT CLAIMID, ID FROM CC_TRANSACTION WHERE SUBTYPE = 2 ) A, ");
			query.append(" (SELECT TRANSACTIONID, SUM(TRANSACTIONAMOUNT) AS TOTAL  FROM CC_TRANSACTIONLINEITEM GROUP BY TRANSACTIONID ) B ");
			query.append(" WHERE A.CLAIMID = C.ID AND A.ID = B.TRANSACTIONID GROUP BY C.CLAIMNUMBER )Y, ");
			query.append(" ( SELECT C.CLAIMNUMBER , SUM(B.TOTAL) AS TOTALRECEOVERY FROM CC_CLAIM C, ");
			query.append(" (SELECT CLAIMID, ID FROM CC_TRANSACTION WHERE SUBTYPE = 3 ) A, ");
			query.append(" (SELECT TRANSACTIONID, SUM(TRANSACTIONAMOUNT) AS TOTAL  FROM CC_TRANSACTIONLINEITEM GROUP BY TRANSACTIONID ) B ");
			query.append(" WHERE A.CLAIMID = C.ID AND A.ID = B.TRANSACTIONID GROUP BY C.CLAIMNUMBER )Z ");
			query.append(" WHERE CCC.CLAIMNUMBER = X.CLAIMNUMBER(+) AND CCC.CLAIMNUMBER = Y.CLAIMNUMBER(+) AND  CCC.CLAIMNUMBER = Z.CLAIMNUMBER(+) ");
			query.append(" AND CCC.POLICYID = CCP.ID  AND CCTLSTS.ID(+) = CCP.STATUS AND CCTLLOB.ID(+) = CCC.LOBCODE AND CCC.ID = CC.CLAIMID  ");
			query.append(" AND CC.ID = CCR.CLAIMCONTACTID AND CCR.ROLE = CR.ID AND CC.CONTACTID = CCCON.ID AND CCR.ROLE = 1 AND CCC.CLAIMSOURCE = CCTLSRC.ID ");

			if (null != claims) {
				query.append("AND CCC.CLAIMNUMBER NOT IN ( 'A' ");
				query.append(claims);
				query.append(") ");
			}

			// SRC SYSTEM
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getSourceSystem())) {
				query.append(" AND CCC.CLAIMSOURCE= '" + tdmPolicyClaimSearchDTO.getSourceSystem()
						+ '\'');
			}
			// LOB
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getLob())) {
				query.append(" AND CCC.LOBCODE= '" + tdmPolicyClaimSearchDTO.getLob() + '\'');
			}

			// status
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getClaimStatus())) {
				query.append(" AND CCP.STATUS= '" + tdmPolicyClaimSearchDTO.getClaimStatus() + '\'');
			}
			// state
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getClaimState())) {
				query.append(" AND CCC.STATE= '" + tdmPolicyClaimSearchDTO.getClaimState() + '\'');
			}
			// acc no
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getPolicyNo())) {
				query.append(" AND CCP.POLICYNUMBER= '" + tdmPolicyClaimSearchDTO.getPolicyNo()
						+ '\'');
			}
			// LOSS DT
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getLossDt())) {
				query.append(" AND CCC.LOSSDATE LIKE '%"
						+ converDateToString(converStringToDate(tdmPolicyClaimSearchDTO.getLossDt()))
						+ "%'");
			}

			// Named Insured
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getNamedInsu())) {
				query.append(" AND (CCCON.FIRSTNAME LIKE '%"
						+ tdmPolicyClaimSearchDTO.getNamedInsu()
						+ "%' OR CCCON.LASTNAMEDENORM LIKE '%"
						+ tdmPolicyClaimSearchDTO.getNamedInsu() + "%' )");
			}

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<Object[]> list = managerClaimSearch.createNativeQuery(query.toString())
					.setFirstResult(offSet).setMaxResults(recordsperpage).getResultList();

			logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_CLAIM_SEARCH
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_CLAIM_SEARCH
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_CLAIM_SEARCH
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_CLAIM_SEARCH
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_CLAIM_SEARCH
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long searchClaimRecordsCount(TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO,
			StringBuffer claims, EntityManager managerClaimSearch) throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_CLAIM_SEARCH_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			StringBuffer query = new StringBuffer(
					" SELECT DISTINCT(CCC.CLAIMNUMBER),  CCP.POLICYNUMBER AS POLICYNO,  CCCON.FIRSTNAME  || ' '  || CCCON.LASTNAMEDENORM AS INSUNAME, CCTLSTS.NAME AS STS, ");
			query.append(" CCTLSRC.NAME AS NA, CCC.LOSSDATE,  TO_CHAR(NVL(X.TOTALPAYMENT,0), '990.00') AS AmountTotal , TO_CHAR(NVL(Y.TOTALRESERVES,0) - NVL(Z.TOTALRECEOVERY,0), '9990.00') AS NetIncurred, ");
			query.append(" CCTLLOB.NAME   AS LOB,   CCP.ID ");
			query.append(" FROM CC_POLICY CCP,  CC_CLAIM CCC,  CC_CLAIMCONTACT CC, ");
			query.append(" CC_CLAIMCONTACTROLE CCR, CCTL_CONTACTROLE CR, CC_CONTACT CCCON, ");
			query.append(" CCTL_LOBCODE CCTLLOB, CCTL_POLICYSTATUS CCTLSTS,  CCTL_SOURCESYSTEM CCTLSRC , ");
			query.append(" (SELECT C.CLAIMNUMBER , SUM(B.TOTAL) AS TOTALPAYMENT FROM CC_CLAIM C,  ");
			query.append(" (SELECT CLAIMID, ID FROM CC_TRANSACTION WHERE SUBTYPE = 1 ) A, ");
			query.append(" (SELECT TRANSACTIONID, SUM(TRANSACTIONAMOUNT) AS TOTAL  FROM CC_TRANSACTIONLINEITEM GROUP BY TRANSACTIONID ) B ");
			query.append(" WHERE A.CLAIMID = C.ID AND A.ID = B.TRANSACTIONID GROUP BY C.CLAIMNUMBER ) X, ");
			query.append(" ( SELECT C.CLAIMNUMBER , SUM(B.TOTAL) AS TOTALRESERVES FROM CC_CLAIM C, ");
			query.append(" (SELECT CLAIMID, ID FROM CC_TRANSACTION WHERE SUBTYPE = 2 ) A, ");
			query.append(" (SELECT TRANSACTIONID, SUM(TRANSACTIONAMOUNT) AS TOTAL  FROM CC_TRANSACTIONLINEITEM GROUP BY TRANSACTIONID ) B ");
			query.append(" WHERE A.CLAIMID = C.ID AND A.ID = B.TRANSACTIONID GROUP BY C.CLAIMNUMBER )Y, ");
			query.append(" ( SELECT C.CLAIMNUMBER , SUM(B.TOTAL) AS TOTALRECEOVERY FROM CC_CLAIM C, ");
			query.append(" (SELECT CLAIMID, ID FROM CC_TRANSACTION WHERE SUBTYPE = 3 ) A, ");
			query.append(" (SELECT TRANSACTIONID, SUM(TRANSACTIONAMOUNT) AS TOTAL  FROM CC_TRANSACTIONLINEITEM GROUP BY TRANSACTIONID ) B ");
			query.append(" WHERE A.CLAIMID = C.ID AND A.ID = B.TRANSACTIONID GROUP BY C.CLAIMNUMBER )Z ");
			query.append(" WHERE CCC.CLAIMNUMBER = X.CLAIMNUMBER(+) AND CCC.CLAIMNUMBER = Y.CLAIMNUMBER(+) AND  CCC.CLAIMNUMBER = Z.CLAIMNUMBER(+) ");
			query.append(" AND CCC.POLICYID = CCP.ID  AND CCTLSTS.ID(+) = CCP.STATUS AND CCTLLOB.ID(+) = CCC.LOBCODE AND CCC.ID = CC.CLAIMID  ");
			query.append(" AND CC.ID = CCR.CLAIMCONTACTID AND CCR.ROLE = CR.ID AND CC.CONTACTID = CCCON.ID AND CCR.ROLE = 1 AND CCC.CLAIMSOURCE = CCTLSRC.ID ");

			if (null != claims) {
				query.append("AND CCC.CLAIMNUMBER NOT IN ( 'A' ");
				query.append(claims);
				query.append(") ");
			}

			// SRC SYSTEM
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getSourceSystem())) {
				query.append(" AND CCC.CLAIMSOURCE= '" + tdmPolicyClaimSearchDTO.getSourceSystem()
						+ '\'');
			}
			// LOB
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getLob())) {
				query.append(" AND CCC.LOBCODE= '" + tdmPolicyClaimSearchDTO.getLob() + '\'');
			}

			// status
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getClaimStatus())) {
				query.append(" AND CCP.STATUS= '" + tdmPolicyClaimSearchDTO.getClaimStatus() + '\'');
			}
			// state
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getClaimState())) {
				query.append(" AND CCC.STATE= '" + tdmPolicyClaimSearchDTO.getClaimState() + '\'');
			}
			// acc no
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getPolicyNo())) {
				query.append(" AND CCP.POLICYNUMBER= '" + tdmPolicyClaimSearchDTO.getPolicyNo()
						+ '\'');
			}
			// LOSS DT
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getLossDt())) {
				query.append(" AND CCC.LOSSDATE LIKE '%"
						+ converDateToString(converStringToDate(tdmPolicyClaimSearchDTO.getLossDt()))
						+ "%'");
			}

			// Named Insured
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getNamedInsu())) {
				query.append(" AND (CCCON.FIRSTNAME LIKE '%"
						+ tdmPolicyClaimSearchDTO.getNamedInsu()
						+ "%' OR CCCON.LASTNAMEDENORM LIKE '%"
						+ tdmPolicyClaimSearchDTO.getNamedInsu() + "%' )");
			}

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<Object[]> list = managerClaimSearch.createNativeQuery(query.toString())
					.getResultList();

			Long count = 0l;
			if (null != list && !list.isEmpty()) {
				count = Long.parseLong(String.valueOf(list.size()));
			}

			logger.info(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_CLAIM_SEARCH_CNT + MessageConstant.LOG_INFO_RETURN);
			return count;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_CLAIM_SEARCH_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_CLAIM_SEARCH_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_CLAIM_SEARCH_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_CLAIM_SEARCH_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<Object[]> getClaimRecords(StringBuffer claims, EntityManager managerClaimSearch)
			throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_CLAIM_GET_POL_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			StringBuffer query = new StringBuffer(
					" SELECT DISTINCT(CCC.CLAIMNUMBER),  CCP.POLICYNUMBER AS POLICYNO,  CCCON.FIRSTNAME  || ' '  || CCCON.LASTNAMEDENORM AS INSUNAME, CCTLSTS.NAME AS STS, ");
			query.append(" CCTLSRC.NAME AS NA, CCC.LOSSDATE,  TO_CHAR(NVL(X.TOTALPAYMENT,0), '990.00') AS AmountTotal , TO_CHAR(NVL(Y.TOTALRESERVES,0) - NVL(Z.TOTALRECEOVERY,0), '9990.00') AS NetIncurred, ");
			query.append(" CCTLLOB.NAME   AS LOB,   CCP.ID ");
			query.append(" FROM CC_POLICY CCP,  CC_CLAIM CCC,  CC_CLAIMCONTACT CC, ");
			query.append(" CC_CLAIMCONTACTROLE CCR, CCTL_CONTACTROLE CR, CC_CONTACT CCCON, ");
			query.append(" CCTL_LOBCODE CCTLLOB, CCTL_POLICYSTATUS CCTLSTS,  CCTL_SOURCESYSTEM CCTLSRC , ");
			query.append(" (SELECT C.CLAIMNUMBER , SUM(B.TOTAL) AS TOTALPAYMENT FROM CC_CLAIM C,  ");
			query.append(" (SELECT CLAIMID, ID FROM CC_TRANSACTION WHERE SUBTYPE = 1 ) A, ");
			query.append(" (SELECT TRANSACTIONID, SUM(TRANSACTIONAMOUNT) AS TOTAL  FROM CC_TRANSACTIONLINEITEM GROUP BY TRANSACTIONID ) B ");
			query.append(" WHERE A.CLAIMID = C.ID AND A.ID = B.TRANSACTIONID GROUP BY C.CLAIMNUMBER ) X, ");
			query.append(" ( SELECT C.CLAIMNUMBER , SUM(B.TOTAL) AS TOTALRESERVES FROM CC_CLAIM C, ");
			query.append(" (SELECT CLAIMID, ID FROM CC_TRANSACTION WHERE SUBTYPE = 2 ) A, ");
			query.append(" (SELECT TRANSACTIONID, SUM(TRANSACTIONAMOUNT) AS TOTAL  FROM CC_TRANSACTIONLINEITEM GROUP BY TRANSACTIONID ) B ");
			query.append(" WHERE A.CLAIMID = C.ID AND A.ID = B.TRANSACTIONID GROUP BY C.CLAIMNUMBER )Y, ");
			query.append(" ( SELECT C.CLAIMNUMBER , SUM(B.TOTAL) AS TOTALRECEOVERY FROM CC_CLAIM C, ");
			query.append(" (SELECT CLAIMID, ID FROM CC_TRANSACTION WHERE SUBTYPE = 3 ) A, ");
			query.append(" (SELECT TRANSACTIONID, SUM(TRANSACTIONAMOUNT) AS TOTAL  FROM CC_TRANSACTIONLINEITEM GROUP BY TRANSACTIONID ) B ");
			query.append(" WHERE A.CLAIMID = C.ID AND A.ID = B.TRANSACTIONID GROUP BY C.CLAIMNUMBER )Z ");
			query.append(" WHERE CCC.CLAIMNUMBER = X.CLAIMNUMBER(+) AND CCC.CLAIMNUMBER = Y.CLAIMNUMBER(+) AND  CCC.CLAIMNUMBER = Z.CLAIMNUMBER(+) ");
			query.append(" AND CCC.POLICYID = CCP.ID  AND CCTLSTS.ID(+) = CCP.STATUS AND CCTLLOB.ID(+) = CCC.LOBCODE AND CCC.ID = CC.CLAIMID  ");
			query.append(" AND CC.ID = CCR.CLAIMCONTACTID AND CCR.ROLE = CR.ID AND CC.CONTACTID = CCCON.ID AND CCR.ROLE = 1 AND CCC.CLAIMSOURCE = CCTLSRC.ID ");
			if (null != claims) {
				query.append("AND CCC.CLAIMNUMBER IN ( 'A' ");
				query.append(claims);
				query.append(") ");
			}

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<Object[]> list = managerClaimSearch.createNativeQuery(query.toString())
					.getResultList();

			logger.info(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_CLAIM_GET_POL_REC + MessageConstant.LOG_INFO_RETURN);
			return list;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_CLAIM_GET_POL_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_CLAIM_GET_POL_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_CLAIM_GET_POL_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_CLAIM_GET_POL_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> getReservedRecords(String userName, String searchType,
			EntityManager managerUser) throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_POLICY_DAO_REV_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmReservationDO> list = managerUser.createQuery(
					"SELECT p FROM TdmReservationDO p where p.reserveDataType IN ('" + searchType
							+ "')").getResultList();
			logger.info(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_DAO_REV_REC + MessageConstant.LOG_INFO_RETURN);
			return list;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_DAO_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_DAO_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_DAO_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_DAO_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> getReservedRecords(String userName, EntityManager managerUser)
			throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_POLICY_DAO_REV_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String searchType = AppConstant.PROV;
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmReservationDO> list = managerUser.createQuery(
					"SELECT p FROM TdmReservationDO p where p.reserveDataType='" + searchType
							+ "' AND p.userId='" + userName + "'").getResultList();
			logger.info(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_DAO_REV_REC + MessageConstant.LOG_INFO_RETURN);
			return list;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_DAO_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_DAO_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_DAO_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_DAO_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> saveReservedData(List<TdmReservationDO> reservationDOList,
			String testCaseId, String testCaseName, EntityManager managerUser) throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO
				+ MessageConstant.TDM_FTD_POLICY_SAVE_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			List<TdmReservationDO> reservationDOs = null;
			if (null != reservationDOList && 0 < reservationDOList.size()) {
				managerUser.getTransaction().begin();
				reservationDOs = new ArrayList<TdmReservationDO>();
				for (TdmReservationDO reservationDO : reservationDOList) {
					if (null != reservationDO && 0 == reservationDO.getRecordId()) {
						reservationDO.setTestCaseId(testCaseId);
						reservationDO.setTestCaseName(testCaseName);
						reservationDO = managerUser.merge(reservationDO);
						reservationDOs.add(reservationDO);
					}

				}
				managerUser.getTransaction().commit();
			}
			logger.info(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return reservationDOs;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> getReservedRecords(String searchType, String userId, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, EntityManager managerUser)
			throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_REV_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmReservationDO> list = managerUser
					.createQuery(
							"SELECT p FROM TdmReservationDO p where p.reserveDataType='"
									+ searchType + "' AND p.userId='" + userId + "'")
					.setFirstResult(offSet).setMaxResults(recordsperpage).getResultList();
			logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long getReservedRecordsCount(String searchType, String userId, EntityManager managerUser)
			throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO
				+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			Long list = (Long) managerUser.createQuery(
					"SELECT COUNT(*) FROM TdmReservationDO p where p.reserveDataType='"
							+ searchType + "' AND p.userId='" + userId + "'").getSingleResult();
			logger.info(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT + MessageConstant.LOG_INFO_RETURN);
			return list;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public boolean unReservedRecordForUser(String policyNo, EntityManager managerUser)
			throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO
				+ MessageConstant.TDM_FTD_POLICY_UNRESERVE_REC + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			managerUser.getTransaction().begin();
			Query q1 = managerUser
					.createQuery("DELETE FROM TdmReservationDO p where p.reserveDataId =:reserveDataId");
			q1.setParameter("reserveDataId", String.valueOf(policyNo));
			int count = q1.executeUpdate();
			managerUser.getTransaction().commit();
			logger.info(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_UNRESERVE_REC
					+ MessageConstant.LOG_INFO_RETURN);
			return count > 0 ? true : false;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_UNRESERVE_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_UNRESERVE_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_UNRESERVE_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_POLICY_UNRESERVE_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<Object[]> getPolicyStatus(EntityManager managerPolicySearch) throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO
				+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			@SuppressWarnings("unchecked")
			List<Object[]> list = managerPolicySearch.createQuery(
					"SELECT ID,DESCRIPTION  FROM PCTL_POLICYPERIODSTATUS;").getResultList();
			logger.info(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT + MessageConstant.LOG_INFO_RETURN);
			return list;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	// TODO NEED TO MOVE TO UTIL

	public String converDateToString(Date date) throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
				+ MessageConstant.TDM_FTD_MP_DATE_TO_STRING + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			if (null != date) {
				SimpleDateFormat dataFormater = new SimpleDateFormat("yyyy-MM-dd");
				String stringobj = dataFormater.format(date);
				logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
						+ MessageConstant.TDM_FTD_MP_DATE_TO_STRING
						+ MessageConstant.LOG_INFO_RETURN);
				return stringobj;
			}

			return null;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_DATE_TO_STRING
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_DATE_TO_STRING
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	public Date converStringToDate(String strdate) {

		if (strdate.contains(".")) {
			strdate = strdate.substring(0, strdate.indexOf("."));
		}
		Date returndate = null;
		if (null != strdate) {
			try {
				SimpleDateFormat dataFormater = new SimpleDateFormat("dd/MM/yyyy");
				returndate = dataFormater.parse(strdate);
				dataFormater.format(returndate);
				return returndate;
			} catch (ParseException pe) {
				pe.printStackTrace();
			}
		}
		return returndate;
	}

}
