/*---------------------------------------------------------------------------------------
 * Object Name: TDMProviserSearchServiceImpl.Java
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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import com.tdm.dao.TDMProviserSearchDAO;
import com.tdm.email.EmailNotificationService;
import com.tdm.exception.DAOException;
import com.tdm.exception.ServiceException;
import com.tdm.model.DO.AccountDO;
import com.tdm.model.DO.ReservationDO;
import com.tdm.model.DO.TdmClaimDO;
import com.tdm.model.DO.TdmClaimSrcMastDO;
import com.tdm.model.DO.TdmClaimStatusMastDO;
import com.tdm.model.DO.TdmClaimTypeMastDO;
import com.tdm.model.DO.TdmPosMastDO;
import com.tdm.model.DO.TdmProviderCatMasterDO;
import com.tdm.model.DO.TdmProviderDO;
import com.tdm.model.DO.TdmProviderTypeMasterDO;
import com.tdm.model.DO.TdmReservationDO;
import com.tdm.model.DO.TdmSubscLobMastDO;
import com.tdm.model.DO.TdmSubscStatusMastDO;
import com.tdm.model.DO.TdmSubscTypeMastDO;
import com.tdm.model.DO.TdmSubscriberDO;
import com.tdm.model.DO.TdmTypeOfBillMastDO;
import com.tdm.model.DO.TdmUsStateDO;
import com.tdm.model.DO.TdmUsStateSubDO;
import com.tdm.model.DO.TdmUserDO;
import com.tdm.model.DTO.AccountDTO;
import com.tdm.model.DTO.AutoEmailDTO;
import com.tdm.model.DTO.ForgotPassword;
import com.tdm.model.DTO.TDMBankReservationDTO;
import com.tdm.model.DTO.TDMClaimSearchDTO;
import com.tdm.model.DTO.TDMClaimSearchResultListDTO;
import com.tdm.model.DTO.TDMProvSearchDTO;
import com.tdm.model.DTO.TDMProvSearchResultListDTO;
import com.tdm.model.DTO.TDMSubscSearchDTO;
import com.tdm.model.DTO.TDMSubscSearchResultListDTO;
import com.tdm.model.DTO.TdmNonStandSearchDTO;
import com.tdm.model.DTO.TdmNonStandardResultListDTO;
import com.tdm.model.mapper.TDMProviderSearchMapper;
import com.tdm.service.TDMProviserSearchService;

/**
 * 
 * @author Seshadri Chowdary
 *
 */

@Component
@Service(MessageConstant.TDM_SEARCH_SERVICE)
@Transactional(propagation = Propagation.REQUIRED)
public class TDMProviserSearchServiceImpl extends TdmBaseServiceImpl implements
		TDMProviserSearchService
{
	private static Logger logger = Logger.getLogger(TDMProviserSearchServiceImpl.class);

	@Autowired
	TDMProviserSearchDAO tDMProviserSearchDAO;

	@Autowired
	TDMProviderSearchMapper tDMProviderSearchMapper;

	@Autowired
	EmailNotificationService emailNotificationService;

	@Override
	public TDMProvSearchDTO searchProviderRecords(TDMProvSearchDTO tDMProvSearchDTO, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, String userName)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerProv = openProviderEntityManager();
			List<AutoEmailDTO> autoEmailDTOs = null;
			AutoEmailDTO autoEmailDTO = null;
			String searchType = AppConstant.PROV;
			List<TdmReservationDO> reservationDOs1 = tDMProviserSearchDAO.getReservedRecords(
					userName, searchType, managerUser);
			List<Long> providersIds = new ArrayList<Long>();
			if (null != reservationDOs1 && 0 < reservationDOs1.size())
			{
				for (TdmReservationDO reservationDO : reservationDOs1)
				{
					if (null != reservationDO.getReserveDataType()
							&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType))
					{
						providersIds.add(Long.valueOf(reservationDO.getReserveDataId()));
						if (reservationDO.getUserId().equalsIgnoreCase(userName))
						{
							tDMProvSearchDTO.setMsgFlag(true);
						}
					}
				}
			}
			List<TdmProviderDO> providerDOlist = tDMProviserSearchDAO.searchProviderRecords(
					tDMProvSearchDTO, offSet, recordsperpage, pageNationOnOffFlag, providersIds,
					managerProv);
			List<TdmReservationDO> reservationDOs = tDMProviserSearchDAO.getReservedRecords(
					providerDOlist, userName, managerUser);
			List<TDMProvSearchResultListDTO> fTDProvSearchResultListDTOList = tDMProviderSearchMapper
					.converTdmProviderDOToFTDProvSearchResultListDTO(providerDOlist,
							reservationDOs, userName);
			tDMProvSearchDTO.settDMProvSearchResultListDTOs(fTDProvSearchResultListDTOList);
			if (null == fTDProvSearchResultListDTOList && null != reservationDOs1
					&& 0 < reservationDOs1.size())
			{
				List<TdmProviderDO> providerDOs = tDMProviserSearchDAO.searchProviderRecords(
						tDMProvSearchDTO, offSet, recordsperpage, pageNationOnOffFlag, null,
						managerProv);
				if (null != providerDOs && 0 < providerDOs.size())
				{
					autoEmailDTOs = new ArrayList<AutoEmailDTO>();
					for (TdmProviderDO tdmProviderDO : providerDOs)
					{
						for (TdmReservationDO reservationDO : reservationDOs1)
						{
							if (tdmProviderDO.getProviderId() == Long.parseLong(reservationDO
									.getReserveDataId()))
							{
								if (!reservationDO.getUserId().equalsIgnoreCase(userName))
								{
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
				tDMProvSearchDTO.setAutoEmailDTOs(autoEmailDTOs);
			}
			else
			{
				tDMProvSearchDTO.setAutoEmailDTOs(null);
			}
			closeProviderEntityManager(managerProv);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC + MessageConstant.LOG_INFO_RETURN);
			return tDMProvSearchDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long searchProviderRecordsCount(TDMProvSearchDTO tDMProvSearchDTO, String userName)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE
				+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerProv = openProviderEntityManager();
			String searchType = AppConstant.PROV;
			List<TdmReservationDO> reservationDOs1 = tDMProviserSearchDAO.getReservedRecords(
					userName, searchType, managerUser);
			List<Long> providersIds = new ArrayList<Long>();
			if (null != reservationDOs1 && 0 < reservationDOs1.size())
			{
				for (TdmReservationDO reservationDO : reservationDOs1)
				{
					if (null != reservationDO.getReserveDataType()
							&& reservationDO.getReserveDataType()
									.equalsIgnoreCase(AppConstant.PROV))
					{
						providersIds.add(Long.valueOf(reservationDO.getReserveDataId()));
					}
				}
			}
			Long count = tDMProviserSearchDAO.searchProviderRecordsCount(tDMProvSearchDTO,
					providersIds, managerProv);
			closeProviderEntityManager(managerProv);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC_CNT
					+ MessageConstant.LOG_INFO_RETURN);
			return count;

		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TDMProvSearchDTO getReservedRecordForUser(String userId, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag) throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE
				+ MessageConstant.TDM_FTD_SER_PROV_GET_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerProv = openProviderEntityManager();
			String searchType = AppConstant.PROV;
			List<TdmReservationDO> reservationDOs = tDMProviserSearchDAO.getReservedRecords(
					searchType, userId, offSet, recordsperpage, pageNationOnOffFlag, managerUser);
			List<Long> providerIds = new ArrayList<Long>();
			for (TdmReservationDO reservationDO : reservationDOs)
			{
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType))
				{
					providerIds.add(Long.valueOf(reservationDO.getReserveDataId()));
				}
			}
			List<TdmProviderDO> providerDOlist = tDMProviserSearchDAO.getProviderRecords(
					providerIds, managerProv);
			List<TDMProvSearchResultListDTO> fTDProvSearchResultListDTOList = tDMProviderSearchMapper
					.converTdmProviderDOToFTDProvSearchResultListDTO(providerDOlist,
							reservationDOs, userId);
			TDMProvSearchDTO tDMProvSearchDTO = new TDMProvSearchDTO();
			tDMProvSearchDTO.settDMProvSearchResultListDTOs(fTDProvSearchResultListDTOList);
			closeProviderEntityManager(managerProv);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_GET_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return tDMProvSearchDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TDMProvSearchDTO dropdownValues(TDMProvSearchDTO tDMProvSearchDTO)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerProv = openProviderEntityManager();
			List<TdmProviderTypeMasterDO> tdmProviderTypeParentDOs = tDMProviserSearchDAO
					.getProviderTypeDropDown(managerProv);
			List<TdmProviderCatMasterDO> tdmProviderCatParentDOs = tDMProviserSearchDAO
					.getProviderCatDropDown(managerProv);
			List<TdmUsStateDO> tdmUsStateDOs = tDMProviserSearchDAO
					.getProviderStateDropDown(managerProv);
			List<String> specDropdown = tDMProviserSearchDAO.dropdownSpecialty(
					tDMProvSearchDTO.getProvCatgType(), managerProv);
			tDMProvSearchDTO = tDMProviderSearchMapper.converDOtoDropdown(tdmProviderTypeParentDOs,
					tdmProviderCatParentDOs, tdmUsStateDOs, tDMProvSearchDTO);
			tDMProvSearchDTO.setSpecDropdown(specDropdown);
			closeProviderEntityManager(managerProv);
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN + MessageConstant.LOG_INFO_RETURN);
			return tDMProvSearchDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> dropdownSpecialty(String value) throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE
				+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN_SPE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerProv = openProviderEntityManager();
			List<String> list = tDMProviserSearchDAO.dropdownSpecialty(value, managerProv);
			closeProviderEntityManager(managerProv);
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN_SPE
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN_SPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN_SPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN_SPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TDMSubscSearchDTO searchSubscRecords(TDMSubscSearchDTO tDMSubscSearchDTO, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, String userName)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerSubsc = openSubscriberEntityManager();
			String searchType = AppConstant.SUB;
			List<AutoEmailDTO> autoEmailDTOs = null;
			AutoEmailDTO autoEmailDTO = null;
			List<TdmReservationDO> reservationDOs1 = tDMProviserSearchDAO.getReservedRecords(
					userName, searchType, managerUser);
			List<String> subscriberIds = new ArrayList<String>();
			if (null != reservationDOs1 && 0 < reservationDOs1.size())
			{
				for (TdmReservationDO reservationDO : reservationDOs1)
				{
					if (null != reservationDO.getReserveDataType()
							&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType))
					{
						subscriberIds.add(reservationDO.getReserveDataId());
						if (reservationDO.getUserId().equalsIgnoreCase(userName))
						{
							tDMSubscSearchDTO.setMsgFlag(true);
						}
					}
				}
			}
			List<TdmSubscriberDO> subscriberDOlist = tDMProviserSearchDAO.searchSubscRecords(
					tDMSubscSearchDTO, offSet, recordsperpage, pageNationOnOffFlag, subscriberIds,
					managerSubsc);
			List<TdmReservationDO> reservationDOs = tDMProviserSearchDAO.getReservedRecordsOfSub(
					subscriberDOlist, userName, managerUser);
			List<TDMSubscSearchResultListDTO> fTDSubscSearchResultListDTOList = tDMProviderSearchMapper
					.converTdmSubscriberDOTofTDSubscSearchResultListDTO(subscriberDOlist,
							reservationDOs, tDMSubscSearchDTO.getUserId());
			tDMSubscSearchDTO.settDMSubscSearchResultListDTOs(fTDSubscSearchResultListDTOList);
			if (null == fTDSubscSearchResultListDTOList && null != reservationDOs1
					&& 0 < reservationDOs1.size())
			{
				List<TdmSubscriberDO> subscriberDOs = tDMProviserSearchDAO.searchSubscRecords(
						tDMSubscSearchDTO, offSet, recordsperpage, pageNationOnOffFlag, null,
						managerSubsc);
				if (null != subscriberDOs && 0 < subscriberDOs.size())
				{
					autoEmailDTOs = new ArrayList<AutoEmailDTO>();
					for (TdmSubscriberDO tdmSubscriberDO : subscriberDOs)
					{
						for (TdmReservationDO reservationDO : reservationDOs1)
						{
							if (tdmSubscriberDO.getSubscriberId().equalsIgnoreCase(
									reservationDO.getReserveDataId()))
							{
								if (!reservationDO.getUserId().equalsIgnoreCase(userName))
								{
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
				tDMSubscSearchDTO.setAutoEmailDTOs(autoEmailDTOs);
			}
			else
			{
				tDMSubscSearchDTO.setAutoEmailDTOs(null);
			}
			closeSubscriberEntityManager(managerSubsc);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC + MessageConstant.LOG_INFO_RETURN);
			return tDMSubscSearchDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long searchSubscrRecordsCount(TDMSubscSearchDTO tDMSubscSearchDTO, String userName)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE
				+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerSubsc = openSubscriberEntityManager();
			String searchType = AppConstant.SUB;
			List<TdmReservationDO> reservationDOs1 = tDMProviserSearchDAO.getReservedRecords(
					userName, searchType, managerUser);
			List<String> subscriberIds = new ArrayList<String>();
			for (TdmReservationDO reservationDO : reservationDOs1)
			{
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType))
				{
					subscriberIds.add(reservationDO.getReserveDataId());
				}
			}
			Long count = tDMProviserSearchDAO.searchSubscrRecordsCount(tDMSubscSearchDTO,
					subscriberIds, managerSubsc);
			closeSubscriberEntityManager(managerSubsc);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC_CNT
					+ MessageConstant.LOG_INFO_RETURN);
			return count;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TDMSubscSearchDTO getReservedRecordForUserSubc(String userId, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag) throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE
				+ MessageConstant.TDM_FTD_SER_SUB_GET_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerSubsc = openSubscriberEntityManager();
			String searchType = AppConstant.SUB;
			List<TdmReservationDO> reservationDOs = tDMProviserSearchDAO.getReservedRecords(
					searchType, userId, offSet, recordsperpage, pageNationOnOffFlag, managerUser);
			List<String> subscriberIds = new ArrayList<String>();
			for (TdmReservationDO reservationDO : reservationDOs)
			{
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType))
				{
					subscriberIds.add(reservationDO.getReserveDataId());
				}
			}
			List<TdmSubscriberDO> tdmSubscriberDOList = tDMProviserSearchDAO.getSubscriberRecords(
					subscriberIds, managerSubsc);
			List<TDMSubscSearchResultListDTO> tDMSubscSearchResultListDTOs = tDMProviderSearchMapper
					.converTdmSubscriberDOTofTDSubscSearchResultListDTO(tdmSubscriberDOList,
							reservationDOs, userId);
			TDMSubscSearchDTO tDMSubscSearchDTO = new TDMSubscSearchDTO();
			tDMSubscSearchDTO.settDMSubscSearchResultListDTOs(tDMSubscSearchResultListDTOs);
			closeSubscriberEntityManager(managerSubsc);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_GET_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return tDMSubscSearchDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TDMSubscSearchDTO dropdownValuesSubsc(TDMSubscSearchDTO tDMSubscSearchDTO)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_SUB_DROP_DOWN
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerSubsc = openSubscriberEntityManager();
			List<TdmSubscTypeMastDO> tdmSubscTypeMastDOs = tDMProviserSearchDAO
					.getSubscTypeDropDown(managerSubsc);
			List<TdmSubscStatusMastDO> tdmSubscStatusMastDOs = tDMProviserSearchDAO
					.getSubscStsDropDown(managerSubsc);
			List<TdmUsStateSubDO> tdmUsStateSubDOs = tDMProviserSearchDAO
					.getSubscStateDropDown(managerSubsc);
			List<TdmSubscLobMastDO> tdmSubscLobMastDOs = tDMProviserSearchDAO
					.getSubscLobDropDown(managerSubsc);
			tDMSubscSearchDTO = tDMProviderSearchMapper.converDOtoDropdownSubcDTO(
					tdmSubscTypeMastDOs, tdmSubscStatusMastDOs, tdmUsStateSubDOs,
					tdmSubscLobMastDOs, tDMSubscSearchDTO);
			closeSubscriberEntityManager(managerSubsc);
			logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_SUB_DROP_DOWN
					+ MessageConstant.LOG_INFO_RETURN);
			return tDMSubscSearchDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_DROP_DOWN
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_DROP_DOWN
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_DROP_DOWN
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TDMClaimSearchDTO dropdownValuesClaim(TDMClaimSearchDTO tDMClaimSearchDTO)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_CLM_DROP_DOWN
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerClaim = openClaimEntityManager();
			List<TdmClaimTypeMastDO> tdmClaimTypeMastDOs = tDMProviserSearchDAO
					.getClaimTypeDropDown(managerClaim);
			List<TdmClaimStatusMastDO> tdmClaimStatusMastDOs = tDMProviserSearchDAO
					.getClaimStsDropDown(managerClaim);
			List<TdmClaimSrcMastDO> tdmClaimSrcMastDOs = tDMProviserSearchDAO
					.getClaimSrcDropDown(managerClaim);
			List<TdmTypeOfBillMastDO> tdmClaimTypeOfBillMastDO = tDMProviserSearchDAO
					.getClaimTypeOfBillsDropDown(managerClaim);
			List<TdmPosMastDO> tdmClaimPOSMastDO = tDMProviserSearchDAO
					.getClaimPOSDropDown(managerClaim);
			tDMClaimSearchDTO = tDMProviderSearchMapper.converDOtoDropdownClaimDTO(
					tdmClaimTypeMastDOs, tdmClaimStatusMastDOs, tdmClaimSrcMastDOs,
					tdmClaimTypeOfBillMastDO, tdmClaimPOSMastDO, tDMClaimSearchDTO);
			closeClaimEntityManager(managerClaim);
			logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_CLM_DROP_DOWN
					+ MessageConstant.LOG_INFO_RETURN);
			return tDMClaimSearchDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_DROP_DOWN
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_DROP_DOWN
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_DROP_DOWN
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TDMClaimSearchDTO searchClaimRecords(TDMClaimSearchDTO tDMClaimSearchDTO, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, String userName)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerClaim = openClaimEntityManager();
			String searchType = AppConstant.CLM;
			List<AutoEmailDTO> autoEmailDTOs = null;
			AutoEmailDTO autoEmailDTO = null;
			List<TdmReservationDO> reservationDOs1 = tDMProviserSearchDAO.getReservedRecords(
					userName, searchType, managerUser);
			List<String> claimIds = new ArrayList<String>();
			if (null != reservationDOs1 && 0 < reservationDOs1.size())
			{
				for (TdmReservationDO reservationDO : reservationDOs1)
				{
					if (null != reservationDO.getReserveDataType()
							&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType))
					{
						claimIds.add(reservationDO.getReserveDataId());
						if (reservationDO.getUserId().equalsIgnoreCase(userName))
						{
							tDMClaimSearchDTO.setMsgFlag(true);
						}
					}
				}
			}
			List<TdmClaimDO> claimDOlist = tDMProviserSearchDAO.searchClaimRecords(
					tDMClaimSearchDTO, offSet, recordsperpage, pageNationOnOffFlag, claimIds,
					managerClaim);
			List<TdmReservationDO> reservationDOs = tDMProviserSearchDAO.getReservedRecordsOfClaim(
					claimDOlist, managerUser);
			List<TDMClaimSearchResultListDTO> fTDClaimSearchResultListDTOList = tDMProviderSearchMapper
					.convertTdmClaimDOTofTDClaimSearchResultListDTO(claimDOlist, reservationDOs,
							tDMClaimSearchDTO.getUserId());
			tDMClaimSearchDTO.settDMClaimSearchResultListDTOs(fTDClaimSearchResultListDTOList);
			if (null == fTDClaimSearchResultListDTOList && null != reservationDOs1
					&& 0 < reservationDOs1.size())
			{
				List<TdmClaimDO> claimDOs = tDMProviserSearchDAO.searchClaimRecords(
						tDMClaimSearchDTO, offSet, recordsperpage, pageNationOnOffFlag, claimIds,
						managerClaim);
				if (null != claimDOs && 0 < claimDOs.size())
				{
					autoEmailDTOs = new ArrayList<AutoEmailDTO>();
					for (TdmClaimDO tdmClaimDO : claimDOs)
					{
						for (TdmReservationDO reservationDO : reservationDOs1)
						{
							if (tdmClaimDO.getClaimId().equalsIgnoreCase(
									reservationDO.getReserveDataId()))
							{
								if (!reservationDO.getUserId().equalsIgnoreCase(userName))
								{
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
				tDMClaimSearchDTO.setAutoEmailDTOs(autoEmailDTOs);
			}
			else
			{
				tDMClaimSearchDTO.setAutoEmailDTOs(null);
			}
			closeClaimEntityManager(managerClaim);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC + MessageConstant.LOG_INFO_RETURN);
			return tDMClaimSearchDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long searchClaimRecordsCount(TDMClaimSearchDTO tDMClaimSearchDTO, String userName)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE
				+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerClaim = openClaimEntityManager();
			String searchType = AppConstant.CLM;
			List<TdmReservationDO> reservationDOs1 = tDMProviserSearchDAO.getReservedRecords(
					userName, searchType, managerUser);
			List<String> claimIds = new ArrayList<String>();
			for (TdmReservationDO reservationDO : reservationDOs1)
			{
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType))
				{
					claimIds.add(reservationDO.getReserveDataId());
				}
			}
			Long count = tDMProviserSearchDAO.searchClaimRecordsCount(tDMClaimSearchDTO, claimIds,
					managerClaim);
			closeClaimEntityManager(managerClaim);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC_CNT
					+ MessageConstant.LOG_INFO_RETURN);
			return count;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TDMClaimSearchDTO getReservedRecordForUserClaim(String userId, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag) throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE
				+ MessageConstant.TDM_FTD_SER_CLM_GET_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerClaim = openClaimEntityManager();
			String searchType = AppConstant.CLM;
			List<TdmReservationDO> reservationDOs = tDMProviserSearchDAO.getReservedRecords(
					searchType, userId, offSet, recordsperpage, pageNationOnOffFlag, managerUser);
			List<String> claimIds = new ArrayList<String>();
			for (TdmReservationDO reservationDO : reservationDOs)
			{
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(AppConstant.CLM))
				{
					claimIds.add(reservationDO.getReserveDataId());
				}
			}
			List<TdmClaimDO> tdmclaimDOList = tDMProviserSearchDAO.getClaimRecords(claimIds,
					managerClaim);
			List<TDMClaimSearchResultListDTO> tDMClaimSearchResultListDTOs = tDMProviderSearchMapper
					.convertTdmClaimDOTofTDClaimSearchResultListDTO(tdmclaimDOList, reservationDOs,
							userId);
			TDMClaimSearchDTO tDMClaimSearchDTO = new TDMClaimSearchDTO();
			tDMClaimSearchDTO.settDMClaimSearchResultListDTOs(tDMClaimSearchResultListDTOs);
			closeClaimEntityManager(managerClaim);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_GET_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return tDMClaimSearchDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_GET_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmNonStandSearchDTO getAllDropdownValues(TdmNonStandSearchDTO tdmNonStandSearchDTO)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_NS_DROP_DOWN
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerClaim = openClaimEntityManager();
			EntityManager managerSubsc = openSubscriberEntityManager();
			EntityManager managerProv = openProviderEntityManager();
			List<TdmProviderTypeMasterDO> tdmProviderTypeParentDOs = tDMProviserSearchDAO
					.getProviderTypeDropDown(managerProv);
			List<TdmProviderCatMasterDO> tdmProviderCatParentDOs = tDMProviserSearchDAO
					.getProviderCatDropDown(managerProv);
			List<TdmUsStateDO> tdmUsStateDOs = tDMProviserSearchDAO
					.getProviderStateDropDown(managerProv);
			List<String> specDropdown = tDMProviserSearchDAO.dropdownSpecialty(
					tdmNonStandSearchDTO.getProvCatgType(), managerProv);
			List<TdmSubscTypeMastDO> tdmSubscTypeMastDOs = tDMProviserSearchDAO
					.getSubscTypeDropDown(managerSubsc);
			List<TdmSubscStatusMastDO> tdmSubscStatusMastDOs = tDMProviserSearchDAO
					.getSubscStsDropDown(managerSubsc);
			List<TdmSubscLobMastDO> tdmSubscLobMastDOs = tDMProviserSearchDAO
					.getSubscLobDropDown(managerSubsc);
			List<TdmClaimTypeMastDO> tdmClaimTypeMastDOs = tDMProviserSearchDAO
					.getClaimTypeDropDown(managerClaim);
			List<TdmClaimStatusMastDO> tdmClaimStatusMastDOs = tDMProviserSearchDAO
					.getClaimStsDropDown(managerClaim);
			List<TdmClaimSrcMastDO> tdmClaimSrcMastDOs = tDMProviserSearchDAO
					.getClaimSrcDropDown(managerClaim);
			List<TdmPosMastDO> tdmClaimPOSMastDO = tDMProviserSearchDAO
					.getClaimPOSDropDown(managerClaim);
			tdmNonStandSearchDTO = tDMProviderSearchMapper.converDOtoDropdownAll(
					tdmProviderTypeParentDOs, tdmProviderCatParentDOs, tdmSubscTypeMastDOs,
					tdmSubscStatusMastDOs, tdmSubscLobMastDOs, tdmUsStateDOs, tdmNonStandSearchDTO,
					tdmClaimTypeMastDOs, tdmClaimStatusMastDOs, tdmClaimSrcMastDOs,
					tdmClaimPOSMastDO);
			tdmNonStandSearchDTO.setSpecDropdown(specDropdown);
			closeProviderEntityManager(managerProv);
			closeSubscriberEntityManager(managerSubsc);
			closeClaimEntityManager(managerClaim);
			logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_NS_DROP_DOWN
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmNonStandSearchDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_NS_DROP_DOWN
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_NS_DROP_DOWN
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_NS_DROP_DOWN
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmNonStandSearchDTO searcNonStandRecords(TdmNonStandSearchDTO tdmNonStandSearchDTO,
			int offSet, int recordsperpage, boolean pageNationOnOffFlag, String userName)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_NS_SEARCH_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerProv = openProviderEntityManager();
			EntityManager managerSubsc = openSubscriberEntityManager();
			EntityManager managerClaim = openClaimEntityManager();
			List<TdmReservationDO> reservationDOs1 = tDMProviserSearchDAO.getReservedRecords(
					userName, AppConstant.PROV_SUB_CLM, managerUser);
			List<String> subscriberIds = new ArrayList<String>();
			List<Long> providerIds = new ArrayList<Long>();
			for (TdmReservationDO reservationDO : reservationDOs1)
			{
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(AppConstant.PROV))
				{
					providerIds.add(Long.valueOf(reservationDO.getReserveDataId()));
				}
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(AppConstant.SUB))
				{
					subscriberIds.add(reservationDO.getReserveDataId());
				}

			}
			TDMSubscSearchDTO tDMSubscSearchDTO = divideSubscriber(tdmNonStandSearchDTO);
			TDMProvSearchDTO tDMProvSearchDTO = divideProvider(tdmNonStandSearchDTO);
			List<TdmProviderDO> providerDOlist = tDMProviserSearchDAO.searchProviderRecords(
					tDMProvSearchDTO, offSet, recordsperpage, pageNationOnOffFlag, providerIds,
					managerProv);
			List<TdmSubscriberDO> subscriberDOlist = tDMProviserSearchDAO.searchSubscRecords(
					tDMSubscSearchDTO, offSet, recordsperpage, pageNationOnOffFlag, subscriberIds,
					managerSubsc);
			List<TdmNonStandardResultListDTO> tdmNonStandardResultListDTOs = tDMProviderSearchMapper
					.converTdmDOsToTdmNonStandardResultListDTO(providerDOlist, subscriberDOlist,
							userName);
			tdmNonStandSearchDTO.setTdmNonStandardResultListDTOs(tdmNonStandardResultListDTOs);
			closeUserEntityManager(managerUser);
			closeProviderEntityManager(managerProv);
			closeSubscriberEntityManager(managerSubsc);
			closeClaimEntityManager(managerClaim);
			logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_NS_SEARCH_REC
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmNonStandSearchDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_NS_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_NS_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_NS_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long searchNonStandRecordsCount(TdmNonStandSearchDTO tdmNonStandSearchDTO,
			String userName) throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_NS_SEARCH_REC_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerUser = openUserEntityManager();
			EntityManager managerProv = openProviderEntityManager();
			EntityManager managerSubsc = openSubscriberEntityManager();
			EntityManager managerClaim = openClaimEntityManager();

			List<TdmReservationDO> reservationDOs1 = tDMProviserSearchDAO.getReservedRecords(
					userName, AppConstant.PROV_SUB_CLM, managerUser);
			List<String> subscriberIds = new ArrayList<String>();
			List<Long> providerIds = new ArrayList<Long>();
			for (TdmReservationDO reservationDO : reservationDOs1)
			{
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(AppConstant.PROV))
				{
					providerIds.add(Long.valueOf(reservationDO.getReserveDataId()));
				}
				if (null != reservationDO.getReserveDataType()
						&& reservationDO.getReserveDataType().equalsIgnoreCase(AppConstant.SUB))
				{
					subscriberIds.add(reservationDO.getReserveDataId());
				}
			}
			TDMSubscSearchDTO tDMSubscSearchDTO = divideSubscriber(tdmNonStandSearchDTO);
			TDMProvSearchDTO tDMProvSearchDTO = divideProvider(tdmNonStandSearchDTO);
			Long l1 = tDMProviserSearchDAO.searchProviderRecordsCount(tDMProvSearchDTO,
					providerIds, managerProv);
			Long l2 = tDMProviserSearchDAO.searchSubscrRecordsCount(tDMSubscSearchDTO,
					subscriberIds, managerSubsc);
			closeUserEntityManager(managerUser);
			closeProviderEntityManager(managerProv);
			closeSubscriberEntityManager(managerSubsc);
			closeClaimEntityManager(managerClaim);
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_NS_SEARCH_REC_CNT
					+ MessageConstant.LOG_INFO_RETURN);
			return l1 + l2;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_NS_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_NS_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_NS_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public int saveReservedData(TDMProvSearchDTO tDMProvSearchDTO, String userName)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE
				+ MessageConstant.TDM_FTD_SER_PROV_SAVE_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			int size = 0;
			List<TdmReservationDO> list = null;
			if (null != tDMProvSearchDTO.gettDMProvSearchResultListDTOs()
					&& 0 < tDMProvSearchDTO.gettDMProvSearchResultListDTOs().size())
			{
				EntityManager managerUser = openUserEntityManager();
				List<TdmReservationDO> reservationDOs = tDMProviderSearchMapper
						.converfTDProvSearchResultListDTOToTdmReservationDO(
								tDMProvSearchDTO.gettDMProvSearchResultListDTOs(), userName);
				list = tDMProviserSearchDAO.saveReservedData(reservationDOs,
						tDMProvSearchDTO.getTestCaseId(), tDMProvSearchDTO.getTestCaseName(),
						managerUser);
				closeUserEntityManager(managerUser);
				size = list.size();
			}
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return size;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public int saveReservedData(TDMSubscSearchDTO tDMSubscSearchDTO) throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE
				+ MessageConstant.TDM_FTD_SER_SUB_SAVE_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			int size = 0;
			List<TdmReservationDO> list = null;
			if (null != tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs()
					&& 0 < tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs().size())
			{
				EntityManager managerUser = openUserEntityManager();
				List<TdmReservationDO> reservationDOList = tDMProviderSearchMapper
						.converTDMSubscSearchResultListDTOToTdmReservationDO(
								tDMSubscSearchDTO.gettDMSubscSearchResultListDTOs(),
								tDMSubscSearchDTO.getUserId());
				list = tDMProviserSearchDAO.saveReservedData(reservationDOList,
						tDMSubscSearchDTO.getTestCaseId(), tDMSubscSearchDTO.getTestCaseName(),
						managerUser);
				closeUserEntityManager(managerUser);
				size = list.size();
			}
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return size;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_SUB_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public int saveReservedData(TDMClaimSearchDTO tDMClaimSearchDTO) throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE
				+ MessageConstant.TDM_FTD_SER_CLM_SAVE_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			int size = 0;
			List<TdmReservationDO> list = null;
			if (null != tDMClaimSearchDTO.gettDMClaimSearchResultListDTOs()
					&& 0 < tDMClaimSearchDTO.gettDMClaimSearchResultListDTOs().size())
			{
				EntityManager managerUser = openUserEntityManager();
				List<TdmReservationDO> reservationDOList = tDMProviderSearchMapper
						.converTDMClaimSearchResultListDTOToTdmReservationDO(
								tDMClaimSearchDTO.gettDMClaimSearchResultListDTOs(),
								tDMClaimSearchDTO.getUserId());
				list = tDMProviserSearchDAO.saveReservedData(reservationDOList,
						tDMClaimSearchDTO.getTestCaseId(), tDMClaimSearchDTO.getTestCaseName(),
						managerUser);
				closeUserEntityManager(managerUser);
				size = list.size();
			}
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return size;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_CLM_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public int saveReservedDataNonStand(TdmNonStandSearchDTO tdmNonStandSearchDTO, String userName)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE
				+ MessageConstant.TDM_FTD_SER_NS_SAVE_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			int size = 0;
			List<TdmReservationDO> list = null;
			if (null != tdmNonStandSearchDTO.getTdmNonStandardResultListDTOs()
					&& 0 < tdmNonStandSearchDTO.getTdmNonStandardResultListDTOs().size())
			{
				EntityManager managerUser = openUserEntityManager();
				List<TdmReservationDO> reservationDOs = new ArrayList<TdmReservationDO>();
				TdmReservationDO reservationDO = null;
				for (TdmNonStandardResultListDTO tdmNonStandardResultListDTO : tdmNonStandSearchDTO
						.getTdmNonStandardResultListDTOs())
				{
					if (null != tdmNonStandardResultListDTO
							&& StringUtils.isNotEmpty(tdmNonStandardResultListDTO.getReservedYN()))
					{
						reservationDO = new TdmReservationDO();
						if (0 != tdmNonStandardResultListDTO.getProviderId())
						{
							reservationDO.setReserveDataId(String
									.valueOf(tdmNonStandardResultListDTO.getProviderId()));
						}
						reservationDO.setLocked(AppConstant.Y);
						reservationDO.setReserveData(null);
						reservationDO.setRowData(null);
						reservationDO.setUserId(userName);
						reservationDO.setUnreserve(AppConstant.N);
						reservationDO.setReserveDataType(tdmNonStandardResultListDTO
								.getSearchFlag());
						reservationDO.setUnlockTime(new Timestamp(new Date().getTime()));
						reservationDOs.add(reservationDO);
					}
				}
				list = tDMProviserSearchDAO.saveReservedData(reservationDOs,
						tdmNonStandSearchDTO.getTestCaseId(),
						tdmNonStandSearchDTO.getTestCaseName(), managerUser);
				closeUserEntityManager(managerUser);
				size = list.size();
			}
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_NS_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return size;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_NS_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_NS_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_NS_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long getReservedRecordsCount(String searchType, String userId) throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerUser = openUserEntityManager();
			Long cnt = tDMProviserSearchDAO
					.getReservedRecordsCount(searchType, userId, managerUser);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT + MessageConstant.LOG_INFO_RETURN);
			return cnt;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Boolean unReservedRecordForUser(Long providerId) throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE
				+ MessageConstant.TDM_FTD_SER_PROV_UNRESERVE_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			EntityManager managerUser = openUserEntityManager();
			boolean bln = tDMProviserSearchDAO.unReservedRecordForUser(providerId, managerUser);
			closeUserEntityManager(managerUser);
			logger.info(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_UNRESERVE_REC
					+ MessageConstant.LOG_INFO_RETURN);
			return bln;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_UNRESERVE_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_UNRESERVE_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_UNRESERVE_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Boolean forgotPassword(ForgotPassword forgotPasswordDTO) throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_FORGOT_PASS1
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		EntityManager managerUser = openUserEntityManager();
		try
		{
			TdmUserDO userDO = tDMProviserSearchDAO.checkAvailabilityOfUserId(
					forgotPasswordDTO.getUserId(), managerUser);
			if (null != userDO && null != userDO.getPassword() && null != userDO.getEmailId())
			{
				forgotPasswordDTO.setPassword(userDO.getPassword());
				// emailNotificationService.sendEmailNotification(forgotPasswordDTO);
				logger.info(MessageConstant.TDM_FTD_SERVICE
						+ MessageConstant.TDM_FTD_SER_FORGOT_PASS1
						+ MessageConstant.LOG_INFO_RETURN);
				return true;
			}
			return false;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_FORGOT_PASS1
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_FORGOT_PASS1
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_FORGOT_PASS1
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
		finally
		{
			closeUserEntityManager(managerUser);
		}
	}

	public TDMProvSearchDTO divideProvider(TdmNonStandSearchDTO tdmNonStandSearchDTO)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_DIVIDE_PROV
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		TDMProvSearchDTO tDMProvSearchDTO = null;
		if (null != tdmNonStandSearchDTO)
		{
			tDMProvSearchDTO = new TDMProvSearchDTO();
			tDMProvSearchDTO.setContractCode(tdmNonStandSearchDTO.getContractCode());
			tDMProvSearchDTO.setEffectiveDate(tdmNonStandSearchDTO.getEffectiveDate());
			tDMProvSearchDTO.setGender(tdmNonStandSearchDTO.getGender());
			tDMProvSearchDTO.setMedicareId(tdmNonStandSearchDTO.getMedicareId());
			tDMProvSearchDTO.setProvCatgType(tdmNonStandSearchDTO.getProvCatgType());
			tDMProvSearchDTO.setProvSpecType(tdmNonStandSearchDTO.getProvSpecType());
			tDMProvSearchDTO.setProvState(tdmNonStandSearchDTO.getProvState());
			tDMProvSearchDTO.setProvType(tdmNonStandSearchDTO.getProvType());
			tDMProvSearchDTO.setProvZip(tdmNonStandSearchDTO.getProvZip());
			tDMProvSearchDTO.setTermDate(tdmNonStandSearchDTO.getTermDate());
			tDMProvSearchDTO.setTin(tdmNonStandSearchDTO.getTin());
		}
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_DIVIDE_PROV
				+ MessageConstant.LOG_INFO_RETURN);
		return tDMProvSearchDTO;
	}

	public TDMSubscSearchDTO divideSubscriber(TdmNonStandSearchDTO tdmNonStandSearchDTO)
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_DIVIDE_SUB
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		TDMSubscSearchDTO tDMSubscSearchDTO = null;
		if (null != tdmNonStandSearchDTO)
		{
			tDMSubscSearchDTO = new TDMSubscSearchDTO();
			tDMSubscSearchDTO.setContractCode(tdmNonStandSearchDTO.getContractCode());
			tDMSubscSearchDTO.setDob(tdmNonStandSearchDTO.getDob());
			tDMSubscSearchDTO.setSsn(tdmNonStandSearchDTO.getSsn());
			tDMSubscSearchDTO.setSubscGender(tdmNonStandSearchDTO.getGender());
			tDMSubscSearchDTO.setSubscLOB(tdmNonStandSearchDTO.getSubscLOB());
			tDMSubscSearchDTO.setSubscriberId(tdmNonStandSearchDTO.getSubscriberId());
			tDMSubscSearchDTO.setSubscState(tdmNonStandSearchDTO.getProvState());
			tDMSubscSearchDTO.setSubscStatus(tdmNonStandSearchDTO.getSubscStatus());
			tDMSubscSearchDTO.setSubscType(tdmNonStandSearchDTO.getSubscType());
			tDMSubscSearchDTO.setSubscZip(tdmNonStandSearchDTO.getProvZip());
			tDMSubscSearchDTO.setTermDate(tdmNonStandSearchDTO.getTermDate());
			tDMSubscSearchDTO.setPcp(tdmNonStandSearchDTO.getTin());
		}
		logger.info(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_DIVIDE_SUB
				+ MessageConstant.LOG_INFO_RETURN);
		return tDMSubscSearchDTO;
	}

	@Override
	public AccountDTO searchAccoutnDetails(AccountDTO acDTO) throws ServiceException
	{
		EntityManager managerSubsc = openSubscriberEntityManager();
		int offSet = 0;
		try
		{
			int recordsperpage = Integer.parseInt(acDTO.getSearchRecordsNo());
			List<AccountDO> accountDoList = tDMProviserSearchDAO.searchAccountDetails(acDTO,
					offSet, recordsperpage, managerSubsc);
			List<AccountDTO> accountDTos = tDMProviderSearchMapper.convertAccountDosToAccountDTO(
					accountDoList, acDTO.isCreditCard());

			if (accountDTos != null && accountDTos.size() > 0)
				acDTO.setAccountDTosList(accountDTos);
			return acDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (DAOException daoEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_FORGOT_PASS1
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		}
		catch (Exception otherEx)
		{
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_FORGOT_PASS1
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
		finally
		{
			closeUserEntityManager(managerSubsc);
		}
	}

	@Override
	public AccountDTO unresrveRecord(AccountDTO acDTO) throws ServiceException
	{

		return null;
	}

	@Override
	public int reserveBankRecords(AccountDTO acDTO, String userID) throws ServiceException
	{
		EntityManager managerSubsc = openSubscriberEntityManager();
		try
		{
			int count = 0;
			List<ReservationDO> reservationDO = tDMProviderSearchMapper
					.convertAccountDToReservationDO(acDTO);
			if (reservationDO != null)
			{
				count = reservationDO.size();
			}
			tDMProviserSearchDAO.resrerveBankRecords(reservationDO, acDTO.getTestCaseId(),
					acDTO.getTestCaseName(), userID, managerSubsc);
			return count;
		}
		catch (Exception otherEx)
		{
			otherEx.printStackTrace();
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_FORGOT_PASS1
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
		finally
		{
			closeUserEntityManager(managerSubsc);
		}
	}

	@Override
	public List<TDMBankReservationDTO> getReservedRecords(String username) throws ServiceException
	{

		EntityManager managerSubsc = openSubscriberEntityManager();
		try
		{
			List<ReservationDO> reservedList = tDMProviserSearchDAO.getResrvedRecords(username,
					managerSubsc);
			List<TDMBankReservationDTO> reservationDO = tDMProviderSearchMapper
					.convertResvrationDosToReservationDTO(reservedList);
			return reservationDO;
		}
		catch (Exception otherEx)
		{
			otherEx.printStackTrace();
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_FORGOT_PASS1
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
		finally
		{
			closeUserEntityManager(managerSubsc);
		}
	}

	@Override
	public int unReserveReservedRecords(AccountDTO accountDTO, String userName)
			throws ServiceException
	{
		EntityManager managerSubsc = openSubscriberEntityManager();
		try
		{
			int count = 0;
			List<ReservationDO> unResrveList = tDMProviderSearchMapper
					.convertbankReservationDTOtoDOs(accountDTO);
			tDMProviserSearchDAO.unReserveBankResrvedRecords(unResrveList, userName, managerSubsc);
			if (unResrveList != null)
			{
				count = unResrveList.size();
			}
			return count;
		}
		catch (Exception otherEx)
		{
			otherEx.printStackTrace();
			// releaseEntityMgrForRollback(entityManager);
			logger.error(MessageConstant.TDM_FTD_SERVICE + MessageConstant.TDM_FTD_SER_FORGOT_PASS1
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
		finally
		{
			closeUserEntityManager(managerSubsc);
		}
	}
}
