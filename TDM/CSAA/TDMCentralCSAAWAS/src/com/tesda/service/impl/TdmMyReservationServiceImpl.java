package com.tesda.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.dao.TdmMyReservationDAO;
import com.tesda.exception.DAOException;
import com.tesda.exception.ServiceException;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyAutoSearchResultDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchResultDTO;
import com.tesda.model.mapper.TdmPolicyAutoSearchMapper;
import com.tesda.service.TdmMyReservationService;

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
	TdmPolicyAutoSearchMapper tdmPolicyAutoSearchMapper;

	@Autowired
	private MessageSource messageSource;

	@Override
	public TdmPolicyAutoSearchDTO getReservedRecordForUser(String userName, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag) throws ServiceException {

		try {
			EntityManager managerCsaaUser = openCsaaUserEntityManager();
			EntityManager managerCsaaAuto = openCsaaPropAutoEntityManager();// openCsaaAutoEntityManager();
			// EntityManager managerCsaaAuto = openCsaaAutoEntityManager();
			// EntityManager managerCsaaAuto = openCsaaAutoEntityManager();

			String searchType = "CSAA_AU";
			List<TdmReservationDO> reservationDOs = tdmMyReservationDAO.getReservedRecords(
					searchType, userName, offSet, recordsperpage, pageNationOnOffFlag,
					managerCsaaUser);

			List<String> policyAutoNumbers = new ArrayList<String>();
			for (TdmReservationDO reservationDO : reservationDOs) {
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
					if (!policyAutoNumbers.contains(reservationDO.getPolicyNumber()))
						policyAutoNumbers.add(reservationDO.getPolicyNumber());
				}
			}
			// List<TdmReservationDO> tdReservationDOlist =
			// tdmMyReservationDAO.getPolicyAutoRecords(
			// policyAutoNumbers, managerCsaaUser,searchType, userName);

			//
			closeCsaaPropAutoEntityManager(managerCsaaAuto);
			List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOList = tdmPolicyAutoSearchMapper
					.converTdmReservationDOToFTdmPolicyAutoSearchResultDTO(reservationDOs,
							userName, null);

			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO = new TdmPolicyAutoSearchDTO();
			tdmPolicyAutoSearchDTO
					.setTdmPolicyAutoSearchResultDTOList(tdmPolicyAutoSearchResultDTOList);

			// closeCsaaAutoEntityManager(managerCsaaAuto);
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
	public TdmPolicyPropertySearchDTO getReservedRecordForUserProperty(String userId, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag) throws ServiceException {

		try {
			EntityManager managerCsaaUser = openCsaaUserEntityManager();
			EntityManager managerCsaaProp = openCsaaPropAutoEntityManager();// openCsaaPropEntityManager();
			// EntityManager managerCsaaProp = openCsaaPropEntityManager();
			// EntityManager managerCsaaProp = openCsaaPropEntityManager();

			String searchType = "CSAA_PO";
			List<TdmReservationDO> reservationDOs = tdmMyReservationDAO.getReservedRecords(
					searchType, userId, offSet, recordsperpage, pageNationOnOffFlag,
					managerCsaaUser);

			// List<String> policyPropNumbers = new ArrayList<String>();
			// for (TdmReservationDO reservationDO : reservationDOs)
			// {
			// if (null != reservationDO.getReserveDataType()
			// && reservationDO.getReserveDataType().equalsIgnoreCase(searchType))
			// {
			// policyPropNumbers.add(reservationDO.getPolicyNumber());
			// }
			// }

			closeCsaaPropAutoEntityManager(managerCsaaProp);

			// List<TdmReservationDO> tdmReservationDOList =
			// tdmMyReservationDAO.getPolicyPropRecords(
			// policyPropNumbers, managerCsaaUser,searchType, userId);

			List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchResultDTOList = tdmPolicyAutoSearchMapper
					.converTdmReservationDOToTdmPolicyPropertySearchDTO(reservationDOs, userId);
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO = new TdmPolicyPropertySearchDTO();
			tdmPolicyPropertySearchDTO
					.setTdmPolicyPropertySearchResultDTOList(tdmPolicyPropertySearchResultDTOList);

			// closeCsaaPropEntityManager(managerCsaaProp);
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
