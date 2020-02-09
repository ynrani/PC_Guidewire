/*---------------------------------------------------------------------------------------
 * Object Name: TdmPolicySearchServiceImpl.Java
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

package com.tdm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.dao.TdmPolicySearchDAO;
import com.tdm.exception.DAOException;
import com.tdm.exception.ServiceException;
import com.tdm.model.DO.MetlifeClaimDO;
import com.tdm.model.DO.MetlifePolicyDO;
import com.tdm.model.DO.TdmReservationDO;
import com.tdm.model.DTO.AutoEmailDTO;
import com.tdm.model.DTO.TdmClaimSearchResultDTO;
import com.tdm.model.DTO.TdmPolicyClaimSearchDTO;
import com.tdm.model.DTO.TdmPolicySearchDTO;
import com.tdm.model.DTO.TdmPolicySearchResultDTO;
import com.tdm.model.mapper.TdmPolicySearchMapper;
import com.tdm.service.TdmPolicySearchService;

/**
 * 
 * @author Seshadri Chowdary
 *
 */

@Component
@Service(MessageConstant.TDM_POLICY_SEARCH_SERVICE)
@Transactional(propagation = Propagation.REQUIRED)
public class TdmPolicySearchServiceImpl extends TdmBaseServiceImpl implements
		TdmPolicySearchService
{
	private static Logger logger = Logger.getLogger(TdmPolicySearchServiceImpl.class);

	@Autowired
	TdmPolicySearchDAO tdmPolicySearchDAO;

	@Autowired
	TdmPolicySearchMapper tdmPolicySearchMapper;

	@Override
	public TdmPolicySearchDTO searchPolicyRecords(TdmPolicySearchDTO tdmPolicySearchDTO,
			int offSet, int recordsperpage, boolean pageNationOnOffFlag, String userName)
			throws ServiceException {
		logger.info(MessageConstant.TDM_POLICY_SERVICE
				+ MessageConstant.TDM_FTD_SER_POLICY_SEARCH_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerPolicySearch = openCsaaUserEntityManager();
			List<AutoEmailDTO> autoEmailDTOs = null;
			AutoEmailDTO autoEmailDTO = null;
			String searchType = AppConstant.POLICY;
			List<TdmReservationDO> reservationDOs1 = tdmPolicySearchDAO.getReservedRecords(
					userName, searchType, managerUser);
			StringBuffer policys = new StringBuffer();
			for (TdmReservationDO reservationDO : reservationDOs1) {
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
					policys.append(",'" + reservationDO.getReserveDataId() + "'");
				}
			}
			List<MetlifePolicyDO> pcPolicyDOs = tdmPolicySearchDAO.searchPolicyRecords(
					tdmPolicySearchDTO, offSet, recordsperpage, pageNationOnOffFlag, policys,
					managerPolicySearch);
			List<TdmReservationDO> reservationDOs = tdmPolicySearchDAO.getReservedRecords(userName,
					managerUser);
			List<TdmPolicySearchResultDTO> tdmPolicySearchResultDTOs = tdmPolicySearchMapper
					.converObjectToTdmPolicySearchResultDTO(pcPolicyDOs, reservationDOs, userName);
			tdmPolicySearchDTO.setTdmPolicySearchResultDTOs(tdmPolicySearchResultDTOs);
			if (null == tdmPolicySearchResultDTOs && null != reservationDOs1
					&& !reservationDOs1.isEmpty()) {
				List<MetlifePolicyDO> pcPolicyDOss = tdmPolicySearchDAO.searchPolicyRecords(
						tdmPolicySearchDTO, offSet, recordsperpage, pageNationOnOffFlag, null,
						managerPolicySearch);
				if (null != pcPolicyDOss && !pcPolicyDOss.isEmpty()) {
					autoEmailDTOs = new ArrayList<AutoEmailDTO>();
					for (MetlifePolicyDO tdmProviderDO : pcPolicyDOss) {
						for (TdmReservationDO reservationDO : reservationDOs1) {
							if (tdmProviderDO.getPolicyNumber().equalsIgnoreCase(
									reservationDO.getReserveDataId())) {
								if (!reservationDO.getUserId().equalsIgnoreCase(userName)) {
									autoEmailDTO = new AutoEmailDTO();
									autoEmailDTO.setUserId(reservationDO.getUserId());
									autoEmailDTO.setTestCaseId(reservationDO.getTestCaseId());
									autoEmailDTO.setTestCaseName(reservationDO.getTestCaseName());
									autoEmailDTOs.add(autoEmailDTO);
								}
							}
						}
					}
				}
				tdmPolicySearchDTO.setAutoEmailDTOs(autoEmailDTOs);
			} else {
				tdmPolicySearchDTO.setAutoEmailDTOs(null);
			}
			closeCsaaUserEntityManager(managerPolicySearch);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_SEARCH_REC
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmPolicySearchDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long searchPolicyRecordsCount(TdmPolicySearchDTO tdmPolicySearchDTO, String userName)
			throws ServiceException {
		logger.info(MessageConstant.TDM_POLICY_SERVICE
				+ MessageConstant.TDM_FTD_SER_POLICY_SEARCH_REC_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerPolicySearch = openCsaaUserEntityManager();
			String searchType = AppConstant.POLICY;
			List<TdmReservationDO> reservationDOs1 = tdmPolicySearchDAO.getReservedRecords(
					userName, searchType, managerUser);
			StringBuffer policys = new StringBuffer();
			for (TdmReservationDO reservationDO : reservationDOs1) {
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
					policys.append(",'" + reservationDO.getReserveDataId() + "'");
				}
			}
			Long count = tdmPolicySearchDAO.searchPolicyRecordsCount(tdmPolicySearchDTO, policys,
					managerPolicySearch);
			closeCsaaUserEntityManager(managerPolicySearch);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_SEARCH_REC_CNT
					+ MessageConstant.LOG_INFO_RETURN);
			return count;

		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmPolicySearchDTO getReservedRecordForUser(String userId, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag) throws ServiceException {
		logger.info(MessageConstant.TDM_POLICY_SERVICE
				+ MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerPolicySearch = openCsaaUserEntityManager();
			String searchType = AppConstant.POLICY;
			List<TdmReservationDO> reservationDOs = tdmPolicySearchDAO.getReservedRecords(
					searchType, userId, offSet, recordsperpage, pageNationOnOffFlag, managerUser);
			StringBuffer policys = new StringBuffer();
			for (TdmReservationDO reservationDO : reservationDOs) {
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
					policys.append(",'" + reservationDO.getReserveDataId() + "'");
				}
			}
			List<MetlifePolicyDO> pcPolicyDOs = tdmPolicySearchDAO.getPolicyRecords(policys,
					managerPolicySearch);
			List<TdmPolicySearchResultDTO> tdmPolicySearchResultDTOs = tdmPolicySearchMapper
					.converObjectToTdmPolicySearchResultDTO(pcPolicyDOs, reservationDOs, userId);
			TdmPolicySearchDTO tdmPolicySearchDTO = new TdmPolicySearchDTO();
			tdmPolicySearchDTO.setTdmPolicySearchResultDTOs(tdmPolicySearchResultDTOs);
			closeCsaaUserEntityManager(managerPolicySearch);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmPolicySearchDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmPolicyClaimSearchDTO searchClaimRecords(
			TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userName) throws ServiceException {
		logger.info(MessageConstant.TDM_POLICY_SERVICE
				+ MessageConstant.TDM_FTD_SER_CLAIM_SEARCH_REC + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerClaimSearch = openCsaaUserEntityManager();
			String searchType = AppConstant.CLAIM;
			List<AutoEmailDTO> autoEmailDTOs = null;
			AutoEmailDTO autoEmailDTO = null;
			List<TdmReservationDO> reservationDOs1 = tdmPolicySearchDAO.getReservedRecords(
					userName, searchType, managerUser);
			StringBuffer claims = new StringBuffer();
			for (TdmReservationDO reservationDO : reservationDOs1) {
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
					claims.append(",'" + reservationDO.getReserveDataId() + "'");
				}
			}
			List<MetlifeClaimDO> ccPolicyDOs = tdmPolicySearchDAO.searchClaimRecords(
					tdmPolicyClaimSearchDTO, offSet, recordsperpage, pageNationOnOffFlag, claims,
					managerClaimSearch);
			List<TdmReservationDO> reservationDOs = tdmPolicySearchDAO.getReservedRecords(userName,
					managerUser);
			List<TdmClaimSearchResultDTO> tdmClaimSearchResultDTOs = tdmPolicySearchMapper
					.converObjectToTdmClaimSearchResultDTO(ccPolicyDOs, reservationDOs,
							tdmPolicyClaimSearchDTO.getUserId());
			tdmPolicyClaimSearchDTO.setTdmClaimSearchResultDTOs(tdmClaimSearchResultDTOs);
			if (null == tdmClaimSearchResultDTOs && null != reservationDOs1
					&& !reservationDOs1.isEmpty()) {
				List<MetlifeClaimDO> ccPolicyDOss = tdmPolicySearchDAO.searchClaimRecords(
						tdmPolicyClaimSearchDTO, offSet, recordsperpage, pageNationOnOffFlag, null,
						managerClaimSearch);
				if (null != ccPolicyDOss && !ccPolicyDOss.isEmpty()) {
					autoEmailDTOs = new ArrayList<AutoEmailDTO>();
					for (MetlifeClaimDO ccPolicyDO : ccPolicyDOss) {
						for (TdmReservationDO reservationDO : reservationDOs1) {
							if (ccPolicyDO.getClaimNumber().equalsIgnoreCase(
									reservationDO.getReserveDataId())) {
								if (!reservationDO.getUserId().equalsIgnoreCase(userName)) {
									autoEmailDTO = new AutoEmailDTO();
									autoEmailDTO.setUserId(reservationDO.getUserId());
									autoEmailDTO.setTestCaseId(reservationDO.getTestCaseId());
									autoEmailDTO.setTestCaseName(reservationDO.getTestCaseName());
									autoEmailDTOs.add(autoEmailDTO);
								}
							}
						}
					}
				}
				tdmPolicyClaimSearchDTO.setAutoEmailDTOs(autoEmailDTOs);
			} else {
				tdmPolicyClaimSearchDTO.setAutoEmailDTOs(null);
			}
			closeCsaaUserEntityManager(managerClaimSearch);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SEARCH_REC
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmPolicyClaimSearchDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long searchClaimRecordsCount(TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO,
			String userName) throws ServiceException {
		logger.info(MessageConstant.TDM_POLICY_SERVICE
				+ MessageConstant.TDM_FTD_SER_CLAIM_SEARCH_REC_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerClaimSearch = openCsaaUserEntityManager();
			String searchType = AppConstant.CLAIM;
			List<TdmReservationDO> reservationDOs1 = tdmPolicySearchDAO.getReservedRecords(
					userName, searchType, managerUser);
			StringBuffer claims = new StringBuffer();
			for (TdmReservationDO reservationDO : reservationDOs1) {
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
					claims.append(",'" + reservationDO.getReserveDataId() + "'");
				}
			}
			Long count = tdmPolicySearchDAO.searchClaimRecordsCount(tdmPolicyClaimSearchDTO,
					claims, managerClaimSearch);
			closeCsaaUserEntityManager(managerClaimSearch);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SEARCH_REC_CNT
					+ MessageConstant.LOG_INFO_RETURN);
			return count;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmPolicyClaimSearchDTO getReservedRecordForUserClaim(String userId, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag) throws ServiceException {
		logger.info(MessageConstant.TDM_POLICY_SERVICE
				+ MessageConstant.TDM_FTD_SER_CLAIM_SAVE_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerClaimSearch = openCsaaUserEntityManager();
			String searchType = AppConstant.CLAIM;
			List<TdmReservationDO> reservationDOs = tdmPolicySearchDAO.getReservedRecords(
					searchType, userId, offSet, recordsperpage, pageNationOnOffFlag, managerUser);
			StringBuffer claims = new StringBuffer();
			for (TdmReservationDO reservationDO : reservationDOs) {
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
					claims.append(",'" + reservationDO.getReserveDataId() + "'");
				}
			}
			List<MetlifeClaimDO> ccPolicyDOs = tdmPolicySearchDAO.getClaimRecords(claims,
					managerClaimSearch);
			List<TdmClaimSearchResultDTO> tdmClaimSearchResultDTOs = tdmPolicySearchMapper
					.converObjectToTdmClaimSearchResultDTO(ccPolicyDOs, reservationDOs, userId);
			TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO = new TdmPolicyClaimSearchDTO();
			tdmPolicyClaimSearchDTO.setTdmClaimSearchResultDTOs(tdmClaimSearchResultDTOs);
			closeCsaaUserEntityManager(managerClaimSearch);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmPolicyClaimSearchDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public int saveReservedData(TdmPolicySearchDTO tdmPolicySearchDTO, String userName)
			throws ServiceException {
		logger.info(MessageConstant.TDM_POLICY_SERVICE
				+ MessageConstant.TDM_FTD_SER_POLICY_SAVE_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			int size = 0;
			List<TdmReservationDO> list = null;
			if (null != tdmPolicySearchDTO.getTdmPolicySearchResultDTOs()
					&& !tdmPolicySearchDTO.getTdmPolicySearchResultDTOs().isEmpty()) {
				EntityManager managerUser = openUserEntityManager();
				List<TdmReservationDO> reservationDOs = tdmPolicySearchMapper
						.converTdmPolicySearchResultDTOToTdmReservationDO(
								tdmPolicySearchDTO.getTdmPolicySearchResultDTOs(), userName);
				list = tdmPolicySearchDAO.saveReservedData(reservationDOs,
						tdmPolicySearchDTO.getTestCaseId(), tdmPolicySearchDTO.getTestCaseName(),
						managerUser);
				closeUserEntityManager(managerUser);
				size = list.size();
			}
			logger.info(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return size;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public int saveReservedData(TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO, String userName)
			throws ServiceException {
		logger.info(MessageConstant.TDM_POLICY_SERVICE
				+ MessageConstant.TDM_FTD_SER_CLAIM_SAVE_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			int size = 0;
			List<TdmReservationDO> list = null;
			if (null != tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs()
					&& !tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs().isEmpty()) {
				EntityManager managerUser = openUserEntityManager();
				List<TdmReservationDO> reservationDOList = tdmPolicySearchMapper
						.converTdmClaimSearchResultDTOToTdmReservationDO(
								tdmPolicyClaimSearchDTO.getTdmClaimSearchResultDTOs(), userName);
				list = tdmPolicySearchDAO.saveReservedData(reservationDOList,
						tdmPolicyClaimSearchDTO.getTestCaseId(),
						tdmPolicyClaimSearchDTO.getTestCaseName(), managerUser);
				closeUserEntityManager(managerUser);
				size = list.size();
			}
			logger.info(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return size;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLAIM_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long getReservedRecordsCount(String searchType, String userId) throws ServiceException {
		logger.info(MessageConstant.TDM_POLICY_SERVICE
				+ MessageConstant.TDM_FTD_SER_POLICY_GET_RESERVE_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerUser = openUserEntityManager();
			Long cnt = tdmPolicySearchDAO.getReservedRecordsCount(searchType, userId, managerUser);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_GET_RESERVE_CNT
					+ MessageConstant.LOG_INFO_RETURN);
			return cnt;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Boolean unReservedRecordForUser(String policyNo) throws ServiceException {
		logger.info(MessageConstant.TDM_POLICY_SERVICE
				+ MessageConstant.TDM_FTD_SER_POLICY_UNRESERVE_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerUser = openUserEntityManager();
			boolean bln = tdmPolicySearchDAO.unReservedRecordForUser(policyNo, managerUser);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_UNRESERVE_REC
					+ MessageConstant.LOG_INFO_RETURN);
			return bln;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_UNRESERVE_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_UNRESERVE_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_POLICY_SERVICE
					+ MessageConstant.TDM_FTD_SER_POLICY_UNRESERVE_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

}
