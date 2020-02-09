/*---------------------------------------------------------------------------------------
 * Object Name: TDMDataMaskingServiceImpl.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          12/06/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tdm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.dao.TDMDataMaskingDAO;
import com.tdm.exception.DAOException;
import com.tdm.exception.ServiceException;
import com.tdm.model.DO.RequestorDO;
import com.tdm.model.DO.TdmOnboardReqDO;
import com.tdm.model.DO.TdmUserDO;
import com.tdm.model.DTO.TdgDataMaskingDTO;
import com.tdm.model.DTO.TdgDataMaskingNoOfAppsDTO;
import com.tdm.model.DTO.TdmOnBoardReqDTO;
import com.tdm.model.mapper.TDMDataMaskingMapper;
import com.tdm.service.TDMDataMaskingService;

/**
 * 
 * @author Seshadri Chowdary
 *
 */
@Component
@Service(MessageConstant.SERVICE_MSK)
@Transactional(propagation = Propagation.REQUIRED)
public class TDMDataMaskingServiceImpl extends TdmBaseServiceImpl implements TDMDataMaskingService
{
	private static Logger logger = Logger.getLogger(TDMDataMaskingServiceImpl.class);

	@Autowired
	TDMDataMaskingDAO tDMDataMaskingDAO;

	@Autowired
	TDMDataMaskingMapper tdmDataMaskingMapper;

	@Override
	public TdgDataMaskingDTO getUserDetails(TdgDataMaskingDTO tdgDataMaskingDTO) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_USER_DTL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerUser = openUserEntityManager();
			TdmUserDO tdmUserDO = tDMDataMaskingDAO.getUserDetails(managerUser, tdgDataMaskingDTO.getUserId());
			closeUserEntityManager(managerUser);
			if (null != tdmUserDO) {
				tdgDataMaskingDTO.setUserName(tdmUserDO.getUsername());
				tdgDataMaskingDTO.setEmailId(tdmUserDO.getEmailId());
				tdgDataMaskingDTO.setPhoneNo(tdmUserDO.getMobileNo());
			}
			logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_USER_DTL
					+ MessageConstant.LOG_INFO_RETURN);
			return tdgDataMaskingDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_USER_DTL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_USER_DTL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_USER_DTL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdgDataMaskingDTO saveReqDtls(TdgDataMaskingDTO tdgDataMaskingDTO, boolean page1, boolean page2,
			boolean page3) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_SAVE_REQ_DTL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		RequestorDO requestorDO = null;
		String seq = null;
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			if (page1 && StringUtils.isEmpty(tdgDataMaskingDTO.getEdit())) {
				if (StringUtils.isEmpty(tdgDataMaskingDTO.getId())) {
					seq = tDMDataMaskingDAO.maskingRecId(managerDtmask);
				}
			}
			requestorDO = tDMDataMaskingDAO.getSavedDtls(tdgDataMaskingDTO.getId(), managerDtmask);
			managerDtmask.clear();
			requestorDO = tdmDataMaskingMapper.convertMaskDTOtoDO(requestorDO, tdgDataMaskingDTO, seq, page1, page2,
					page3, false);
			requestorDO = tDMDataMaskingDAO.getSaveReqDtls(requestorDO, managerDtmask);
			tdgDataMaskingDTO.setId(requestorDO.getId());
			closeDataMaskingEntityManager(managerDtmask);
			logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_SAVE_REQ_DTL
					+ MessageConstant.LOG_INFO_RETURN);
			return tdgDataMaskingDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_SAVE_REQ_DTL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_SAVE_REQ_DTL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_SAVE_REQ_DTL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdgDataMaskingDTO getSavedDtls(TdgDataMaskingDTO tdgDataMaskingDTO, boolean page1, boolean page2,
			boolean page3) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVED_DTL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		RequestorDO requestorDO = null;
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			requestorDO = tDMDataMaskingDAO.getSavedDtls(tdgDataMaskingDTO.getId(), managerDtmask);
			tdgDataMaskingDTO = tdmDataMaskingMapper.convertDOtoMaskDTO(tdgDataMaskingDTO, requestorDO, page1, page2,
					page3);
			closeDataMaskingEntityManager(managerDtmask);
			if (null != tdgDataMaskingDTO) {
				if (null == tdgDataMaskingDTO.getTdgDataMaskingNoOfAppsDTOs()) {
					List<TdgDataMaskingNoOfAppsDTO> tdgDataMaskingNoOfAppsDTOs = new ArrayList<TdgDataMaskingNoOfAppsDTO>();
					TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO = new TdgDataMaskingNoOfAppsDTO();
					tdgDataMaskingNoOfAppsDTOs.add(tdgDataMaskingNoOfAppsDTO);
					tdgDataMaskingDTO.setTdgDataMaskingNoOfAppsDTOs(tdgDataMaskingNoOfAppsDTOs);
				}
			}

			logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVED_DTL
					+ MessageConstant.LOG_INFO_RETURN);
			return tdgDataMaskingDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVED_DTL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVED_DTL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVED_DTL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long getReservedRecordsCount(String userId, String type, String status) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_REV_REC_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			Long lResult = tDMDataMaskingDAO.getDataMaskingRecordsCount(userId, type, status, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_REV_REC_CNT
					+ MessageConstant.LOG_INFO_RETURN);
			return lResult;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_REV_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_REV_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_REV_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdgDataMaskingDTO getAllDtMaskRequestedRecordForPagination(int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, TdgDataMaskingDTO tdgDataMaskingDTO, String type, String status)
			throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_ALL_DT_MSK_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			List<RequestorDO> requestorDOs = tDMDataMaskingDAO.searchDataMaskingRecords(offSet, recordsperpage,
					pageNationOnOffFlag, tdgDataMaskingDTO.getUserId(), type, status, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_ALL_DT_MSK_REC
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmDataMaskingMapper.convertDOtoMaskDTOs(tdgDataMaskingDTO, requestorDOs, true, true, true);
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_ALL_DT_MSK_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_ALL_DT_MSK_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_ALL_DT_MSK_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdgDataMaskingDTO getSavedDtlsforExport(TdgDataMaskingDTO tdgDataMaskingDTO, boolean page1, boolean page2,
			boolean page3, String type) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVED_DTL_EXPO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			List<RequestorDO> requestorDOs = tDMDataMaskingDAO.getSavedDtlsforExport(tdgDataMaskingDTO.getUserId(),
					type, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVED_DTL_EXPO
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmDataMaskingMapper.convertDOtoMaskDTOs(tdgDataMaskingDTO, requestorDOs, true, true, true);
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVED_DTL_EXPO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVED_DTL_EXPO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVED_DTL_EXPO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> getReqIdList(String userId, String reqIdtoken) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_REQ_IDS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			List<String> reqIds = null;
			List<String> reqList = tDMDataMaskingDAO.getReqIdList(userId, managerDtmask, reqIdtoken);
			if (null != reqList && 0 < reqList.size()) {
				reqIds = filterReqIDs(reqList);
			}
			closeDataMaskingEntityManager(managerDtmask);
			logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_REQ_IDS
					+ MessageConstant.LOG_INFO_RETURN);
			return reqIds;

		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_REQ_IDS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_REQ_IDS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_REQ_IDS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	public List<String> filterReqIDs(List<String> reqList) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_FILTER_REQ_IDS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		List<String> reqIds = new ArrayList<String>();
		try {
			String reqId = "";
			for (String s : reqList) {
				if (!s.contains(AppConstant.CR)) {
					reqId = s;
					int max = 0;
					for (String s1 : reqList) {
						if (s1.contains(AppConstant.CR) && s1.startsWith(s)) {
							int id = Integer.parseInt(s1.split(AppConstant.CR)[1]);
							if (max < id) {
								max = id;
								reqId = s1;
							}
						}
					}
					reqIds.add(reqId);
				}
			}
			logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_FILTER_REQ_IDS
					+ MessageConstant.LOG_INFO_RETURN);
			return reqIds;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_FILTER_REQ_IDS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_FILTER_REQ_IDS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmOnBoardReqDTO getEditableDetails(String reqId) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_EDITABLE_DTLS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			TdmOnboardReqDO tdmOnboardReqDO = tDMDataMaskingDAO.getEditableDetails(managerDtmask, reqId);
			TdmOnBoardReqDTO tdmOnboardReqDTO = tdmDataMaskingMapper.convertTdmOnboardReqDOToDO(tdmOnboardReqDO);
			closeDataMaskingEntityManager(managerDtmask);
			if (null == tdmOnboardReqDTO.getTdgDataMaskingNoOfAppsDTOs()) {
				List<TdgDataMaskingNoOfAppsDTO> tdgDataMaskingNoOfAppsDTOs = new ArrayList<TdgDataMaskingNoOfAppsDTO>();
				TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO = new TdgDataMaskingNoOfAppsDTO();
				tdgDataMaskingNoOfAppsDTOs.add(tdgDataMaskingNoOfAppsDTO);
				tdmOnboardReqDTO.setTdgDataMaskingNoOfAppsDTOs(tdgDataMaskingNoOfAppsDTOs);
			} else {
				tdmOnboardReqDTO.getTdgDataMaskingNoOfAppsDTOs().add(new TdgDataMaskingNoOfAppsDTO());
			}

			logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_EDITABLE_DTLS
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmOnboardReqDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_EDITABLE_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_EDITABLE_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_EDITABLE_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmOnBoardReqDTO getUserDetails(String userId, TdmOnBoardReqDTO tdmOnBoardReqDTO) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_USER_DTLS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerUser = openUserEntityManager();
			tdmOnBoardReqDTO = tDMDataMaskingDAO.getUserDetailsOnboard(userId, managerUser, tdmOnBoardReqDTO);
			closeUserEntityManager(managerUser);

			List<TdgDataMaskingNoOfAppsDTO> tdgDataMaskingNoOfAppsDTOs = new ArrayList<TdgDataMaskingNoOfAppsDTO>();
			TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO = new TdgDataMaskingNoOfAppsDTO();
			tdgDataMaskingNoOfAppsDTOs.add(tdgDataMaskingNoOfAppsDTO);
			tdmOnBoardReqDTO.setTdgDataMaskingNoOfAppsDTOs(tdgDataMaskingNoOfAppsDTOs);

			logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_USER_DTLS
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmOnBoardReqDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_USER_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_USER_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_USER_DTLS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmOnBoardReqDTO getSaveOnboardingReq(TdmOnBoardReqDTO tdmOnboardReqDTO) throws ServiceException {

		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVE_ONBOARDING
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			String seq = null;
			if (StringUtils.isEmpty(tdmOnboardReqDTO.getOnboardReqId())) {
				seq = tDMDataMaskingDAO.onBoardingRecId(managerDtmask);
			}
			TdmOnboardReqDO tdmOnboardReqDO = tdmDataMaskingMapper.convertTdmOnBoardReqDTOToDO(tdmOnboardReqDTO, seq);
			tdmOnboardReqDO = tDMDataMaskingDAO.getSaveOnboardingReq(managerDtmask, tdmOnboardReqDO);
			tdmOnboardReqDTO.setOnboardReqId(tdmOnboardReqDO.getOnboardReqId());
			closeDataMaskingEntityManager(managerDtmask);
			logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVE_ONBOARDING
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmOnboardReqDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVE_ONBOARDING
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVE_ONBOARDING
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_SAVE_ONBOARDING
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long getReservedRecordsCountOnBoard(String userId, String type, String status) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_RESER_REC_CNT_ONBOARD
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			Long lResult = tDMDataMaskingDAO.getOnBoardingRecordsCount(userId, type, status, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			logger.info(MessageConstant.TDM_DT_MSK_SERVICE
					+ MessageConstant.TDM_DT_MSK_SERVICE_GET_RESER_REC_CNT_ONBOARD + MessageConstant.LOG_INFO_RETURN);
			return lResult;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE
					+ MessageConstant.TDM_DT_MSK_SERVICE_GET_RESER_REC_CNT_ONBOARD
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE
					+ MessageConstant.TDM_DT_MSK_SERVICE_GET_RESER_REC_CNT_ONBOARD
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE
					+ MessageConstant.TDM_DT_MSK_SERVICE_GET_RESER_REC_CNT_ONBOARD
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdgDataMaskingDTO> getAllOnBoardRequestedRecordForPagination(int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userId, String type, String status) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_ALL_ONBOARD_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			List<TdmOnboardReqDO> requestorDOs = tDMDataMaskingDAO.searchOnBoardingRecords(offSet, recordsperpage,
					pageNationOnOffFlag, userId, type, status, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_ALL_ONBOARD_REC
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmDataMaskingMapper.converTdmOnboardReqDOtoDTO(requestorDOs);
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_ALL_ONBOARD_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_ALL_ONBOARD_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_GET_ALL_ONBOARD_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public boolean getCheckExistingReqYesNo(TdgDataMaskingDTO tdgDataMaskingDTO) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_CHECK_EXISTING
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			boolean checkExistingReq = tDMDataMaskingDAO.getCheckExistingReqYesNo(tdgDataMaskingDTO.getUserId(),
					managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_CHECK_EXISTING
					+ MessageConstant.LOG_INFO_RETURN);
			return checkExistingReq;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_CHECK_EXISTING
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_CHECK_EXISTING
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_CHECK_EXISTING
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public boolean dtMaskCancelReq(String reqId) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_CANCEL_REQ
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			boolean checkExistingReq = tDMDataMaskingDAO.dtMaskCancelReq(reqId, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_CANCEL_REQ
					+ MessageConstant.LOG_INFO_RETURN);
			return checkExistingReq;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_DT_MSK_SERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public boolean cancelOnBoardingRequest(String reqId) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_ONBOARDING_SERVICE_CANCEL_REQ
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			boolean isConcelled = tDMDataMaskingDAO.cancelOnBoardingReq(managerDtmask, reqId);
			closeDataMaskingEntityManager(managerDtmask);
			return isConcelled;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_ONBOARDING_SERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_ONBOARDING_SERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_ONBOARDING_SERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public boolean cancelMaskingRequest(String reqId) throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_MASKINGSERVICE_CANCEL_REQ
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			boolean isConcelled = tDMDataMaskingDAO.cancelMaskingReq(managerDtmask, reqId);
			closeDataMaskingEntityManager(managerDtmask);
			return isConcelled;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_MASKINGSERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_MASKINGSERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_MASKINGSERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String updateRequestStatus(TdgDataMaskingDTO tdgDataMaskingDTO, String userName, String sts)
			throws ServiceException {
		logger.info(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_MASKINGSERVICE_CANCEL_REQ
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			EntityManager managerDtmask = openDataMaskingEntityManager();
			String isupdated = tDMDataMaskingDAO.updateRequestStatus(tdgDataMaskingDTO, userName, sts, managerDtmask);
			closeDataMaskingEntityManager(managerDtmask);
			return isupdated;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_MASKINGSERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_MASKINGSERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_DT_MSK_SERVICE + MessageConstant.TDM_MASKINGSERVICE_CANCEL_REQ
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

}
