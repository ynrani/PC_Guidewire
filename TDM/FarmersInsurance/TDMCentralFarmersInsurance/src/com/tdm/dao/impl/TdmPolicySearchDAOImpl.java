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
import com.tdm.model.DO.MetlifeClaimDO;
import com.tdm.model.DO.MetlifePolicyDO;
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
	public List<MetlifePolicyDO> searchPolicyRecords(TdmPolicySearchDTO tdmPolicySearchDTO,
			int offSet, int recordsperpage, boolean pageNationOnOffFlag, StringBuffer policys,
			EntityManager managerPolicySearch) throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_POLICY_SEARCH
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			StringBuffer query = new StringBuffer("SELECT P FROM MetlifePolicyDO P WHERE 0=0 ");

			if (null != policys) {
				query.append("AND P.policyNumber NOT IN ( 'A' ");
				query.append(policys);
				query.append(") ");
			}

			// Company
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getCompany())) {
				query.append(" AND P.companyName LIKE '%" + tdmPolicySearchDTO.getCompany() + "%' ");
			}
			// Product Type
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getProductType())) {
				query.append(" AND P.productType LIKE '%" + tdmPolicySearchDTO.getProductType()
						+ "%' ");
			}
			// Product Name
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getProductName())) {
				query.append(" AND P.productName LIKE '%" + tdmPolicySearchDTO.getProductName()
						+ "%' ");
			}

			// Policy Number
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getPolicyNo())) {
				query.append(" AND P.policyNumber= '" + tdmPolicySearchDTO.getPolicyNo() + '\'');
			}

			// Face Amount
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getFaceAmt())) {
				query.append(" AND P.faceAmt = " + tdmPolicySearchDTO.getFaceAmt());
			}

			// SSN
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getSsn())) {
				query.append(" AND P.ssn= '" + tdmPolicySearchDTO.getSsn() + '\'');
			}
			// Insured First Name
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getInsuFirstName())) {
				query.append(" AND P.fristName LIKE '%" + tdmPolicySearchDTO.getInsuFirstName()
						+ "%' ");
			}
			// Insured Last Name
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getInsuLastName())) {
				query.append(" AND P.lastName LIKE '%" + tdmPolicySearchDTO.getInsuLastName()
						+ "%' ");
			}
			// Gender
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getGender())
					&& !"Both".equalsIgnoreCase(tdmPolicySearchDTO.getGender())) {
				query.append(" AND P.gender= '" + tdmPolicySearchDTO.getGender() + '\'');
			}
			// Date of Birth
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getDob())) {
				query.append(" AND TRUNC(P.dob) = To_date('").append(tdmPolicySearchDTO.getDob())
						.append("', 'MM/DD/YYYY') ");
			}
			// Distribution Channel
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getDistChnl())) {
				query.append(" AND P.distChnal LIKE '%" + tdmPolicySearchDTO.getDistChnl() + "%' ");
			}

			// Date Between
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getFromDate())) {
				query.append(" AND TRUNC(P.effDt) < To_date('")
						.append(tdmPolicySearchDTO.getFromDate()).append("', 'MM/DD/YYYY') ");
			}
			// And BETWEEN
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getToDate())) {
				query.append(" AND TRUNC(P.expDt) >  To_date('")
						.append(tdmPolicySearchDTO.getToDate()).append("', 'MM/DD/YYYY') ");

			}

			// Agent ID
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getAgntId())) {
				query.append(" AND P.agentId= " + tdmPolicySearchDTO.getAgntId());
			}

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<MetlifePolicyDO> list = managerPolicySearch.createQuery(query.toString())
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
					"SELECT COUNT(P) FROM MetlifePolicyDO P WHERE 0=0 ");

			if (null != policys) {
				query.append("AND P.policyNumber NOT IN ( 'A' ");
				query.append(policys);
				query.append(") ");
			}

			// Company
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getCompany())) {
				query.append(" AND P.companyName LIKE '%" + tdmPolicySearchDTO.getCompany() + "%' ");
			}
			// Product Type
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getProductType())) {
				query.append(" AND P.productType LIKE '%" + tdmPolicySearchDTO.getProductType()
						+ "%' ");
			}
			// Product Name
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getProductName())) {
				query.append(" AND P.productName LIKE '%" + tdmPolicySearchDTO.getProductName()
						+ "%' ");
			}

			// Policy Number
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getPolicyNo())) {
				query.append(" AND P.policyNumber= '" + tdmPolicySearchDTO.getPolicyNo() + '\'');
			}

			// Face Amount
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getFaceAmt())) {
				query.append(" AND P.faceAmt = " + tdmPolicySearchDTO.getFaceAmt());
			}

			// SSN
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getSsn())) {
				query.append(" AND P.ssn= '" + tdmPolicySearchDTO.getSsn() + '\'');
			}
			// Insured First Name
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getInsuFirstName())) {
				query.append(" AND P.fristName LIKE '%" + tdmPolicySearchDTO.getInsuFirstName()
						+ "%' ");
			}
			// Insured Last Name
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getInsuLastName())) {
				query.append(" AND P.lastName LIKE '%" + tdmPolicySearchDTO.getInsuLastName()
						+ "%' ");
			}
			// Gender
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getGender())
					&& !"Both".equalsIgnoreCase(tdmPolicySearchDTO.getGender())) {
				query.append(" AND P.gender= '" + tdmPolicySearchDTO.getGender() + '\'');
			}
			// Date of Birth
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getDob())) {
				query.append(" AND TRUNC(P.dob) = To_date('").append(tdmPolicySearchDTO.getDob())
						.append("', 'MM/DD/YYYY') ");
			}
			// Distribution Channel
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getDistChnl())) {
				query.append(" AND P.distChnal LIKE '%" + tdmPolicySearchDTO.getDistChnl() + "%' ");
			}

			// Date Between
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getFromDate())) {
				query.append(" AND TRUNC(P.effDt) < To_date('")
						.append(tdmPolicySearchDTO.getFromDate()).append("', 'MM/DD/YYYY') ");
			}
			// And BETWEEN
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getToDate())) {
				query.append(" AND TRUNC(P.expDt) >  To_date('")
						.append(tdmPolicySearchDTO.getToDate()).append("', 'MM/DD/YYYY') ");

			}

			// Agent ID
			if (StringUtils.isNotEmpty(tdmPolicySearchDTO.getAgntId())) {
				query.append(" AND P.agentId= " + tdmPolicySearchDTO.getAgntId());
			}

			Long count = (Long) managerPolicySearch.createQuery(query.toString()).getSingleResult();

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
	public List<MetlifePolicyDO> getPolicyRecords(StringBuffer policys,
			EntityManager managerPolicySearch) throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_POLICY_GET_POL_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			StringBuffer query = new StringBuffer("SELECT P FROM MetlifePolicyDO P WHERE 0=0 ");

			if (null != policys) {
				query.append("AND P.policyNumber IN ( 'A' ");
				query.append(policys);
				query.append(") ");
			}

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<MetlifePolicyDO> list = managerPolicySearch.createQuery(query.toString())
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
	public List<MetlifeClaimDO> searchClaimRecords(TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO,
			int offSet, int recordsperpage, boolean pageNationOnOffFlag, StringBuffer claims,
			EntityManager managerClaimSearch) throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_CLAIM_SEARCH
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			StringBuffer query = new StringBuffer("SELECT P FROM MetlifeClaimDO P WHERE 0=0 ");

			if (null != claims) {
				query.append("AND P.claimNumber NOT IN ( 'A' ");
				query.append(claims);
				query.append(") ");
			}

			// Company
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getCompany())) {
				query.append(" AND P.companyName LIKE '%" + tdmPolicyClaimSearchDTO.getCompany()
						+ "%' ");
			}
			// Product Type
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getProductType())) {
				query.append(" AND P.productType LIKE '%"
						+ tdmPolicyClaimSearchDTO.getProductType() + "%' ");
			}
			// Product Name
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getProductName())) {
				query.append(" AND P.productName LIKE '%"
						+ tdmPolicyClaimSearchDTO.getProductName() + "%' ");
			}

			// Policy Number
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getPolicyNo())) {
				query.append(" AND P.policyNumber= '" + tdmPolicyClaimSearchDTO.getPolicyNo()
						+ '\'');
			}

			// Policy Status
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getPolicySts())) {
				query.append(" AND P.policySts LIKE '%" + tdmPolicyClaimSearchDTO.getPolicySts()
						+ "%' ");
			}

			// SSN/TIN
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getSsn())) {
				query.append(" AND P.ssn= '" + tdmPolicyClaimSearchDTO.getSsn() + '\'');
			}

			// Agent ID
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getAgntId())) {
				query.append(" AND P.agentId= " + tdmPolicyClaimSearchDTO.getAgntId());
			}

			// Date of Birth
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getDob())) {
				query.append(" AND TRUNC(P.dob) = To_date('")
						.append(tdmPolicyClaimSearchDTO.getDob()).append("', 'MM/DD/YYYY') ");
			}

			// Date Between
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getFromDate())) {

				query.append(" AND TRUNC(P.effDt) < To_date('")
						.append(tdmPolicyClaimSearchDTO.getFromDate()).append("', 'MM/DD/YYYY') ");
			}
			// And
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getToDate())) {

				query.append(" AND TRUNC(P.expDt) > To_date('")
						.append(tdmPolicyClaimSearchDTO.getToDate()).append("', 'MM/DD/YYYY') ");
			}

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<MetlifeClaimDO> list = managerClaimSearch.createQuery(query.toString())
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
					"SELECT COUNT(P) FROM MetlifeClaimDO P WHERE 0=0 ");

			if (null != claims) {
				query.append("AND P.claimNumber NOT IN ( 'A' ");
				query.append(claims);
				query.append(") ");
			}

			// Company
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getCompany())) {
				query.append(" AND P.companyName LIKE '%" + tdmPolicyClaimSearchDTO.getCompany()
						+ "%' ");
			}
			// Product Type
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getProductType())) {
				query.append(" AND P.productType LIKE '%"
						+ tdmPolicyClaimSearchDTO.getProductType() + "%' ");
			}
			// Product Name
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getProductName())) {
				query.append(" AND P.productName LIKE '%"
						+ tdmPolicyClaimSearchDTO.getProductName() + "%' ");
			}

			// Policy Number
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getPolicyNo())) {
				query.append(" AND P.policyNumber= '" + tdmPolicyClaimSearchDTO.getPolicyNo()
						+ '\'');
			}

			// Policy Status
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getPolicySts())) {
				query.append(" AND P.policySts LIKE '%" + tdmPolicyClaimSearchDTO.getPolicySts()
						+ "%' ");
			}

			// SSN/TIN
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getSsn())) {
				query.append(" AND P.ssn= '" + tdmPolicyClaimSearchDTO.getSsn() + '\'');
			}

			// Agent ID
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getAgntId())) {
				query.append(" AND P.agentId= " + tdmPolicyClaimSearchDTO.getAgntId());
			}

			// Date of Birth
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getDob())) {
				query.append(" AND TRUNC(P.dob) = To_date('")
						.append(tdmPolicyClaimSearchDTO.getDob()).append("', 'MM/DD/YYYY') ");
			}

			// Date Between
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getFromDate())) {

				query.append(" AND TRUNC(P.effDt) < To_date('")
						.append(tdmPolicyClaimSearchDTO.getFromDate()).append("', 'MM/DD/YYYY') ");
			}
			// And
			if (StringUtils.isNotEmpty(tdmPolicyClaimSearchDTO.getToDate())) {

				query.append(" AND TRUNC(P.expDt) > To_date('")
						.append(tdmPolicyClaimSearchDTO.getToDate()).append("', 'MM/DD/YYYY') ");
			}

			Long count = (Long) managerClaimSearch.createQuery(query.toString()).getSingleResult();

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
	public List<MetlifeClaimDO> getClaimRecords(StringBuffer claims,
			EntityManager managerClaimSearch) throws DAOException {
		logger.info(MessageConstant.TDM_FTD_POLICY_DAO + MessageConstant.TDM_FTD_CLAIM_GET_POL_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			StringBuffer query = new StringBuffer("SELECT P FROM MetlifeClaimDO P WHERE 0=0 ");

			if (null != claims) {
				query.append("AND P.claimNumber IN ( 'A' ");
				query.append(claims);
				query.append(") ");
			}
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<MetlifeClaimDO> list = managerClaimSearch.createQuery(query.toString())
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
