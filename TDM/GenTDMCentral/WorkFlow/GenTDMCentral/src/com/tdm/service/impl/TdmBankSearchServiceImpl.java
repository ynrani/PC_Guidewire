package com.tdm.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tdm.constant.MessageConstant;
import com.tdm.dao.TdmBankSearchDAO;
import com.tdm.exception.DAOException;
import com.tdm.exception.ServiceException;
import com.tdm.model.DO.AccountDO;
import com.tdm.model.DO.ReservationDO;
import com.tdm.model.DTO.AccountDTO;
import com.tdm.model.DTO.TDMBankReservationDTO;
import com.tdm.model.mapper.TdmBankSearchMapper;
import com.tdm.service.TdmBankSearchService;

@Component
@Service(MessageConstant.TDM_BANK_SEARCH_SERVICE)
@Transactional(propagation = Propagation.REQUIRED)
public class TdmBankSearchServiceImpl extends TdmBaseServiceImpl implements TdmBankSearchService
{

	private static Logger logger = Logger.getLogger(TdmBankSearchServiceImpl.class);

	@Autowired
	TdmBankSearchDAO tdmBankSearchDAO;

	@Autowired
	TdmBankSearchMapper tdmBankSearchMapper;

	@Override
	public AccountDTO searchAccoutnDetails(AccountDTO acDTO) throws ServiceException {
		EntityManager managerSubsc = openSubscriberEntityManager();
		int offSet = 0;
		try {
			int recordsperpage = Integer.parseInt(acDTO.getSearchRecordsNo());
			List<AccountDO> accountDoList = tdmBankSearchDAO.searchAccountDetails(acDTO, offSet,
					recordsperpage, managerSubsc);
			List<AccountDTO> accountDTos = tdmBankSearchMapper.convertAccountDosToAccountDTO(
					accountDoList, acDTO.isCreditCard());

			if (accountDTos != null && accountDTos.size() > 0)
				acDTO.setAccountDTosList(accountDTos);
			return acDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_FORGOT_PASS1
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_FORGOT_PASS1
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		} finally {
			closeUserEntityManager(managerSubsc);
		}
	}

	@Override
	public AccountDTO unresrveRecord(AccountDTO acDTO) throws ServiceException {

		return null;
	}

	@Override
	public int reserveBankRecords(AccountDTO acDTO, String userID) throws ServiceException {
		EntityManager managerSubsc = openSubscriberEntityManager();
		try {
			int count = 0;
			List<ReservationDO> reservationDO = tdmBankSearchMapper
					.convertAccountDToReservationDO(acDTO);
			if (reservationDO != null) {
				count = reservationDO.size();
			}
			tdmBankSearchDAO.resrerveBankRecords(reservationDO, acDTO.getTestCaseId(),
					acDTO.getTestCaseName(), userID, managerSubsc);
			return count;
		} catch (Exception otherEx) {
			otherEx.printStackTrace();
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_FORGOT_PASS1
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		} finally {
			closeUserEntityManager(managerSubsc);
		}
	}

	@Override
	public List<TDMBankReservationDTO> getReservedRecords(String username) throws ServiceException {

		EntityManager managerSubsc = openSubscriberEntityManager();
		try {
			List<ReservationDO> reservedList = tdmBankSearchDAO.getResrvedRecords(username,
					managerSubsc);
			List<TDMBankReservationDTO> reservationDO = tdmBankSearchMapper
					.convertResvrationDosToReservationDTO(reservedList);
			return reservationDO;
		} catch (Exception otherEx) {
			otherEx.printStackTrace();
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_FORGOT_PASS1
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		} finally {
			closeUserEntityManager(managerSubsc);
		}
	}

	@Override
	public int unReserveReservedRecords(AccountDTO accountDTO, String userName)
			throws ServiceException {
		EntityManager managerSubsc = openSubscriberEntityManager();
		try {
			int count = 0;
			List<ReservationDO> unResrveList = tdmBankSearchMapper
					.convertbankReservationDTOtoDOs(accountDTO);
			tdmBankSearchDAO.unReserveBankResrvedRecords(unResrveList, userName, managerSubsc);
			if (unResrveList != null) {
				count = unResrveList.size();
			}
			return count;
		} catch (Exception otherEx) {
			otherEx.printStackTrace();
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_FORGOT_PASS1
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		} finally {
			closeUserEntityManager(managerSubsc);
		}
	}
}
