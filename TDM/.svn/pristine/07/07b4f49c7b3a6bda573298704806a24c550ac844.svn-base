package com.tdm.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tdm.constant.MessageConstant;
import com.tdm.dao.TdmPolicyAutoPropSearchDAO;
import com.tdm.email.EmailNotificationService;
import com.tdm.exception.DAOException;
import com.tdm.exception.ServiceException;
import com.tdm.model.DO.PolicySummaryStg;
import com.tdm.model.DO.TdmReqTestDataDO;
import com.tdm.model.DO.TdmReservationDO;
import com.tdm.model.DTO.TdmPolicyAutoSearchDTO;
import com.tdm.model.DTO.TdmPolicyAutoSearchResultDTO;
import com.tdm.model.DTO.TdmPolicyPropertySearchDTO;
import com.tdm.model.DTO.TdmPolicyPropertySearchResultDTO;
import com.tdm.model.DTO.TdmReqTestDataDTO;
import com.tdm.model.mapper.TdmPolicyAutoPropSearchMapper;
import com.tdm.service.TdmPolicyAutoPropSearchService;

@Component
@Service("tdmPolicyAutoPropSearchService")
@Transactional(propagation = Propagation.REQUIRED)
public class TdmPolicyAutoPropSearchServiceImpl extends TdmBaseServiceImpl implements TdmPolicyAutoPropSearchService
{
	final static Logger logger = Logger.getLogger(TdmPolicyAutoPropSearchServiceImpl.class);

	@Autowired
	TdmPolicyAutoPropSearchDAO tdmPolicyAutoPropSearchDAO;

	@Autowired
	TdmPolicyAutoPropSearchMapper tdmPolicyAutoPropSearchMapper;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	EmailNotificationService emailNotificationService;

	@Override
	public TdmPolicyPropertySearchDTO searchPolicyPropRecordsByPolicySearchNew(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userName) throws ServiceException {
		String searchType = "CSAA_PO";
		String policytype = "Property";

		List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchDTOList = null;
		List<PolicySummaryStg> policySummaryStgDOs = null;
		List<TdmReservationDO> reservationDOs1 = null;
		try {
			EntityManager managerCsaaUser = openCsaaUserEntityManager();

			/**
			 * 1. going to fetch reserved records
			 */
			reservationDOs1 = tdmPolicyAutoPropSearchDAO.getReservedRecords(userName, searchType, managerCsaaUser);
			StringBuffer policyProps = new StringBuffer();
			if (null != reservationDOs1 && 0 < reservationDOs1.size()) {
				for (TdmReservationDO reservationDO : reservationDOs1) {
					if (null != reservationDO.getReserveDataType()
							&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
						policyProps.append(",'" + reservationDO.getReserveDataId() + "'");
					}
				}
			}

			/**
			 * 2. going to fetch remains records apart from reserved based on criteria
			 */
			policySummaryStgDOs = tdmPolicyAutoPropSearchDAO.searchPolicyPropRecordsByPolicySearchNew(
					tdmPolicyPropertySearchDTO, offSet, recordsperpage, pageNationOnOffFlag, policyProps, policytype,
					managerCsaaUser);

			/**
			 * 3. going to convert DO to DTO class
			 */
			tdmPolicyPropertySearchDTOList = tdmPolicyAutoPropSearchMapper
					.converPolicysummaryToTdmPolicyPropertySearchDTONew(policySummaryStgDOs,
							tdmPolicyPropertySearchDTO, reservationDOs1, userName);

			tdmPolicyPropertySearchDTO.setTdmPolicyPropertySearchResultDTOList(tdmPolicyPropertySearchDTOList);

			closeCsaaUserEntityManager(managerCsaaUser);
			return tdmPolicyPropertySearchDTO;
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null), otherEx);
		}
	}

	@Override
	public TdmPolicyAutoSearchDTO searchPolicyAutoRecordsByPolicySearchNew(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, int recordsperpage, boolean pageNationOnOffFlag,
			String userName) throws ServiceException {
		String searchType = "CSAA_AU";
		String ptype = "AUTO";

		try {
			EntityManager managerUser = openCsaaUserEntityManager();

			/**
			 * 1. going to fetch reserved records
			 */
			List<TdmReservationDO> reservationDOs1 = tdmPolicyAutoPropSearchDAO.getReservedRecords(userName,
					searchType, managerUser);
			StringBuffer policyautos = new StringBuffer();
			if (null != reservationDOs1 && 0 < reservationDOs1.size()) {
				for (TdmReservationDO reservationDO : reservationDOs1) {
					if (null != reservationDO.getReserveDataType()
							&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
						policyautos.append(",'" + reservationDO.getReserveDataId() + '\'');
					}
				}
			}
			/**
			 * 2. going to fetch remains records apart from reserved based on criteria
			 */

			List<PolicySummaryStg> policySummaryStgDOs = tdmPolicyAutoPropSearchDAO
					.searchPolicyAutoRecordsByPolicySearchNew(tdmPolicyAutoSearchDTO, offSet, recordsperpage,
							pageNationOnOffFlag, policyautos, ptype, managerUser);

			/**
			 * 3. going to convert DO to DTO class
			 */
			List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTO = tdmPolicyAutoPropSearchMapper
					.converPolicysummaryToTdmPolicyAutoSearchResultDTONew(policySummaryStgDOs, tdmPolicyAutoSearchDTO,
							reservationDOs1, userName);
			tdmPolicyAutoSearchDTO.setTdmPolicyAutoSearchResultDTOList(tdmPolicyAutoSearchResultDTO);

			closeCsaaUserEntityManager(managerUser);

			return tdmPolicyAutoSearchDTO;
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null), nullPointerEx);
		} catch (DAOException daoEx) {
			logger.error("DAO exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null), otherEx);
		}
	}

	@Override
	public int saveReservedData(TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, String userName, String enviro)
			throws ServiceException {

		try {
			List<TdmReservationDO> list = null;

			if (null != tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList()
					&& 0 < tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList().size()) {
				EntityManager managerCsaaUser = openCsaaUserEntityManager();
				List<TdmReservationDO> reservationDOs = tdmPolicyAutoPropSearchMapper
						.converTdmPolicyPropertySearchDTOToTdmReservationDO(
								tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList(),
								tdmPolicyPropertySearchDTO.getSearchCriti(), userName, enviro);
				list = tdmPolicyAutoPropSearchDAO.saveReservedData(reservationDOs,
						tdmPolicyPropertySearchDTO.getTestCaseId(), tdmPolicyPropertySearchDTO.getTestCaseName(),
						managerCsaaUser);
				closeCsaaUserEntityManager(managerCsaaUser);
			}

			return list.size();
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null), otherEx);
		}

	}

	@Override
	public int saveReservedData(TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, String userName, String enviro)
			throws ServiceException {

		try {
			List<TdmReservationDO> list = null;

			if (null != tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList()
					&& 0 < tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList().size()) {
				EntityManager managerCsaaUser = openCsaaUserEntityManager();
				List<TdmReservationDO> reservationDOs = tdmPolicyAutoPropSearchMapper
						.converTdmPolicyAutoSearchResultDTOToTdmReservationDO(
								tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList(),
								tdmPolicyAutoSearchDTO.getSearchCriti(), userName, enviro);
				list = tdmPolicyAutoPropSearchDAO.saveReservedData(reservationDOs,
						tdmPolicyAutoSearchDTO.getTestCaseId(), tdmPolicyAutoSearchDTO.getTestCaseName(),
						managerCsaaUser);
				closeCsaaUserEntityManager(managerCsaaUser);
			}
			return list.size();
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null), otherEx);
		}
	}

	@Override
	public String savereqTestData(TdmReqTestDataDTO tdmReqTestDataDTO) throws ServiceException {
		logger.info(MessageConstant.TDM_ADMIN_SERVICE + MessageConstant.TDM_ADMIN_SAVE_USER_DRL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerCsaaUser = openCsaaUserEntityManager();
			String str = tdmPolicyAutoPropSearchDAO.savereqTestData(
					tdmPolicyAutoPropSearchMapper.convertdmReqTestDataDTOTotdmReqTestDataDO(tdmReqTestDataDTO),
					managerCsaaUser);
			closeCsaaUserEntityManager(managerCsaaUser);

			StringBuffer body = new StringBuffer("Hi,\n \t Your Request for Test Data generation with Id :");
			body.append(str);
			body.append(" has been Submitted with following details.");
			body.append("\n \t \t");
			body.append("Policy Type : ");
			body.append(tdmReqTestDataDTO.getPolicyType());
			body.append("\n \t \t");
			body.append("Policy State Code : ");
			body.append(tdmReqTestDataDTO.getPolicyStateCode());
			body.append("\n \t \t");
			body.append("Source System : ");
			body.append(tdmReqTestDataDTO.getSrcSys());
			body.append("\n \t \t");
			body.append("Test Environment : ");
			body.append(tdmReqTestDataDTO.getEnvType());
			body.append("\n \t \t");
			body.append("Policy Request Details : ");
			body.append(tdmReqTestDataDTO.getPolicyReqDtl());
			body.append("\n \t \t");
			body.append("Policy Status : ");
			body.append(tdmReqTestDataDTO.getPolicySts());
			body.append("\n \t \t");
			body.append("By  : ");
			body.append(tdmReqTestDataDTO.getReqName());
			body.append("\n \t \t");

			body.append("On  : ");
			body.append(new Timestamp(new Date().getTime()));

			body.append("\n \n Regards, \n TDM Team");

			System.out.println(body);

			emailNotificationService.sendEmailNotification("manas.a.sharma@capgemini.com",
					"manas.a.sharma@capgemini.com", "Your Test Data Request Acknowlegement ", body + "");

			/*
			 * SendEmailUtils.sendMail(null, "manas.a.sharma@capgemini.com",
			 * "manas.a.sharma@capgemini.com", "Test Data Request", body + "");
			 */

			logger.info(MessageConstant.TDM_ADMIN_SERVICE + MessageConstant.TDM_ADMIN_SAVE_USER_DRL
					+ MessageConstant.LOG_INFO_RETURN);
			return str;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_ADMIN_SERVICE + MessageConstant.TDM_ADMIN_SAVE_USER_DRL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_ADMIN_SERVICE + MessageConstant.TDM_ADMIN_SAVE_USER_DRL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_ADMIN_SERVICE + MessageConstant.TDM_ADMIN_SAVE_USER_DRL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReqTestDataDTO> allReqTestData(String userId, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag) throws ServiceException {
		logger.info(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerCsaaUser = openCsaaUserEntityManager();

			List<TdmReqTestDataDO> tdmReqTestDataDOs = tdmPolicyAutoPropSearchDAO.getReservedRecords(userId, offSet,
					recordsperpage, pageNationOnOffFlag, managerCsaaUser);

			List<TdmReqTestDataDTO> tdmReqTestDataDTOs = tdmPolicyAutoPropSearchMapper
					.convertdmReqTestDataDOsTotdmReqTestDataDTOs(tdmReqTestDataDOs);

			closeCsaaUserEntityManager(managerCsaaUser);

			logger.info(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmReqTestDataDTOs;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long allReqTestDataCount(String userId) throws ServiceException {
		logger.info(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESERVE_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerCsaaUser = openCsaaUserEntityManager();
			Long cnt = tdmPolicyAutoPropSearchDAO.allReqTestDataCount(userId, managerCsaaUser);
			closeCsaaUserEntityManager(managerCsaaUser);
			logger.info(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESERVE_CNT
					+ MessageConstant.LOG_INFO_RETURN);
			return cnt;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmReqTestDataDTO editReqTestData(String userId) throws ServiceException {
		logger.info(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerCsaaUser = openCsaaUserEntityManager();

			TdmReqTestDataDO tdmReqTestDataDO = tdmPolicyAutoPropSearchDAO.editReqTestData(userId, managerCsaaUser);

			TdmReqTestDataDTO tdmReqTestDataDTO = tdmPolicyAutoPropSearchMapper
					.convertdmReqTestDataDOTotdmReqTestDataDTO(tdmReqTestDataDO);

			closeCsaaUserEntityManager(managerCsaaUser);

			logger.info(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmReqTestDataDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE + MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

}
