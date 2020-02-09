package com.tdm.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tdm.dao.TdmMyReservationDAO;
import com.tdm.exception.DAOException;
import com.tdm.exception.ServiceException;
import com.tdm.model.DO.PolicySummaryStg;
import com.tdm.model.DO.TdmReservationDO;
import com.tdm.model.DTO.TdmPolicyAutoSearchDTO;
import com.tdm.model.DTO.TdmPolicyAutoSearchResultDTO;
import com.tdm.model.DTO.TdmPolicyPropertySearchDTO;
import com.tdm.model.DTO.TdmPolicyPropertySearchResultDTO;
import com.tdm.model.mapper.TdmPolicyAutoPropSearchMapper;
import com.tdm.service.TdmMyReservationService;

@Component
@Service("tdmMyReservationService")
@Transactional(propagation = Propagation.REQUIRED)
public class TdmMyReservationServiceImpl extends TdmBaseServiceImpl implements
		TdmMyReservationService
{
	final static Logger logger = Logger.getLogger(TdmMyReservationServiceImpl.class);

	@Autowired
	TdmMyReservationDAO tdmMyReservationDAO;

	@Autowired
	TdmPolicyAutoPropSearchMapper tdmPolicyAutoPropSearchMapper;

	@Autowired
	private MessageSource messageSource;

	@Override
	public TdmPolicyAutoSearchDTO getReservedRecordForUser(String userName, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag) throws ServiceException {

		try {
			EntityManager managerCsaaUser = openCsaaUserEntityManager();

			String searchType = "CSAA_AU";
			List<TdmReservationDO> reservationDOs = tdmMyReservationDAO.getReservedRecords(
					searchType, userName, offSet, recordsperpage, pageNationOnOffFlag,
					managerCsaaUser);

			StringBuffer autoIds = new StringBuffer();
			for (TdmReservationDO reservationDO : reservationDOs) {
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
					autoIds.append(",'" + reservationDO.getReserveDataId() + "'");
				}
			}

			List<PolicySummaryStg> policySummaryStgDOs = tdmMyReservationDAO.getReservedRecords(
					autoIds, managerCsaaUser);

			List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOList = tdmPolicyAutoPropSearchMapper
					.converPolicysummaryToTdmPolicyAutoSearchResultDTONew(policySummaryStgDOs,
							null, reservationDOs, userName);

			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO = new TdmPolicyAutoSearchDTO();
			tdmPolicyAutoSearchDTO
					.setTdmPolicyAutoSearchResultDTOList(tdmPolicyAutoSearchResultDTOList);

			closeCsaaUserEntityManager(managerCsaaUser);

			return tdmPolicyAutoSearchDTO;
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO Exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}
	}

	@Override
	public Long getReservedRecordsCount(String searchType, String userName) throws ServiceException {

		try {

			EntityManager managerCsaaUser = openCsaaUserEntityManager();

			Long cnt = tdmMyReservationDAO.getReservedRecordsCount(searchType, userName,
					managerCsaaUser);

			closeCsaaUserEntityManager(managerCsaaUser);

			return cnt;
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO Exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}
	}

	@Override
	public boolean unReservedRecordForUser(Long policyAutoNo) throws ServiceException {

		try {
			EntityManager managerCsaaUser = openCsaaUserEntityManager();

			boolean bln = tdmMyReservationDAO
					.unReservedRecordForUser(policyAutoNo, managerCsaaUser);

			closeCsaaUserEntityManager(managerCsaaUser);

			return bln;
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO Exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}

	}

	@Override
	public TdmPolicyPropertySearchDTO getReservedRecordForUserProperty(String userName, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag) throws ServiceException {

		try {
			EntityManager managerCsaaUser = openCsaaUserEntityManager();

			String searchType = "CSAA_PO";
			List<TdmReservationDO> reservationDOs = tdmMyReservationDAO.getReservedRecords(
					searchType, userName, offSet, recordsperpage, pageNationOnOffFlag,
					managerCsaaUser);
			StringBuffer propIds = new StringBuffer();
			for (TdmReservationDO reservationDO : reservationDOs) {
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
					propIds.append(",'" + reservationDO.getReserveDataId() + "'");
				}
			}
			List<PolicySummaryStg> policySummaryStgDOs = tdmMyReservationDAO.getReservedRecords(
					propIds, managerCsaaUser);

			List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchResultDTOList = tdmPolicyAutoPropSearchMapper
					.converPolicysummaryToTdmPolicyPropertySearchDTONew(policySummaryStgDOs, null,
							reservationDOs, userName);
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO = new TdmPolicyPropertySearchDTO();
			tdmPolicyPropertySearchDTO
					.setTdmPolicyPropertySearchResultDTOList(tdmPolicyPropertySearchResultDTOList);

			closeCsaaUserEntityManager(managerCsaaUser);

			return tdmPolicyPropertySearchDTO;
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO Exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}
	}

	@Override
	public boolean unReservedRecordForUser(String policyPropNo) throws ServiceException {

		try {
			EntityManager managerCsaaUser = openCsaaUserEntityManager();

			boolean bln = tdmMyReservationDAO
					.unReservedRecordForUser(policyPropNo, managerCsaaUser);

			closeCsaaUserEntityManager(managerCsaaUser);

			return bln;
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO Exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}
	}

}
