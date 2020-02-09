/*---------------------------------------------------------------------------------------
 * Object Name: TDMProviderSearchMapperImpl.Java
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

package com.tdm.model.mapper.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.exception.ServiceException;
import com.tdm.model.DO.TdmClaimDO;
import com.tdm.model.DO.TdmClaimSrcMastDO;
import com.tdm.model.DO.TdmClaimStatusMastDO;
import com.tdm.model.DO.TdmClaimTypeMastDO;
import com.tdm.model.DO.TdmPosMastDO;
import com.tdm.model.DO.TdmProviderAddrDO;
import com.tdm.model.DO.TdmProviderCatMasterDO;
import com.tdm.model.DO.TdmProviderDO;
import com.tdm.model.DO.TdmProviderTypeMasterDO;
import com.tdm.model.DO.TdmReservationDO;
import com.tdm.model.DO.TdmSubscLobMastDO;
import com.tdm.model.DO.TdmSubscStatusMastDO;
import com.tdm.model.DO.TdmSubscTypeMastDO;
import com.tdm.model.DO.TdmSubscriberDO;
import com.tdm.model.DO.TdmSuscriberAddressDO;
import com.tdm.model.DO.TdmTypeOfBillMastDO;
import com.tdm.model.DO.TdmUsStateDO;
import com.tdm.model.DO.TdmUsStateSubDO;
import com.tdm.model.DTO.TDMClaimPOSMastDTO;
import com.tdm.model.DTO.TDMClaimSearchDTO;
import com.tdm.model.DTO.TDMClaimSearchResultListDTO;
import com.tdm.model.DTO.TDMClaimSrcDTO;
import com.tdm.model.DTO.TDMClaimStatusMastDTO;
import com.tdm.model.DTO.TDMClaimTypeMastDTO;
import com.tdm.model.DTO.TDMClaimTypeOfBillsMastDTO;
import com.tdm.model.DTO.TDMProvSearchDTO;
import com.tdm.model.DTO.TDMProvSearchResultListDTO;
import com.tdm.model.DTO.TDMSubscSearchDTO;
import com.tdm.model.DTO.TDMSubscSearchResultListDTO;
import com.tdm.model.DTO.TdmNonStandSearchDTO;
import com.tdm.model.DTO.TdmNonStandardResultListDTO;
import com.tdm.model.DTO.TdmProviderCatParentDTO;
import com.tdm.model.DTO.TdmProviderTypeParentDTO;
import com.tdm.model.DTO.TdmSubscLobMastDTO;
import com.tdm.model.DTO.TdmSubscStatusMastDTO;
import com.tdm.model.DTO.TdmSubscTypeMastDTO;
import com.tdm.model.DTO.TdmUsStateDTO;
import com.tdm.model.mapper.TDMProviderSearchMapper;

/**
 * 
 * @author Seshadri Chowdary
 *
 */
@Component
@Service(MessageConstant.MAPPER_FTD)
public class TDMProviderSearchMapperImpl implements TDMProviderSearchMapper
{
	private static Logger logger = Logger.getLogger(TDMProviderSearchMapperImpl.class);

	@Override
	public List<TDMProvSearchResultListDTO> converTdmProviderDOToFTDProvSearchResultListDTO(
			List<TdmProviderDO> providerDOList, List<TdmReservationDO> reservationDOs,
			String userName) throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DO_TO_DTO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			DateFormat myFormat = new SimpleDateFormat(AppConstant.MMDDYYYY);
			Calendar cal = Calendar.getInstance();
			Date date2 = cal.getTime();
			List<TDMProvSearchResultListDTO> fTDProvSearchResultListDTOList = null;
			if (null != providerDOList && 0 < providerDOList.size()) {
				TdmProviderDO providerDO = null;
				TDMProvSearchResultListDTO tDMProvSearchResultListDTO = null;
				fTDProvSearchResultListDTOList = new ArrayList<TDMProvSearchResultListDTO>();
				for (int i = 0; i < providerDOList.size(); i++) {
					providerDO = providerDOList.get(i);
					tDMProvSearchResultListDTO = new TDMProvSearchResultListDTO();
					tDMProvSearchResultListDTO.setProviderId(providerDO.getProviderId());
					tDMProvSearchResultListDTO.setFirstName(providerDO.getFirstName());
					tDMProvSearchResultListDTO.setLastName(providerDO.getLastName());
					if (null != providerDO.getTdmProviderSpecialities()) {
						tDMProvSearchResultListDTO.setSpecialityDescription(providerDO
								.getTdmProviderSpecialities().getSpecialityDescription());
					}
					tDMProvSearchResultListDTO.setMedicareId(providerDO.getMedicareId());
					tDMProvSearchResultListDTO.setLicenseNo(providerDO.getLicenseNo());
					tDMProvSearchResultListDTO.setTin(providerDO.getTin());
					tDMProvSearchResultListDTO.setNpi(providerDO.getNpi());
					tDMProvSearchResultListDTO.setProvFET(providerDO.getEft());
					tDMProvSearchResultListDTO.setAtypical(providerDO.getAtypical());
					tDMProvSearchResultListDTO.setProvGender(providerDO.getGender());
					tDMProvSearchResultListDTO.setProvContactType(providerDO.getContractName());
					if (null != providerDO.getTdmProviderCategories()) {
						tDMProvSearchResultListDTO.setProvCatgType(providerDO
								.getTdmProviderCategories().getCategoryDescription());
					}
					if (null != providerDO.getTdmProviderTypes()
							&& 0 < providerDO.getTdmProviderTypes().size()) {
						tDMProvSearchResultListDTO.setProvType(providerDO.getTdmProviderTypes()
								.get(0).getProviderTypeName());
					}
					tDMProvSearchResultListDTO.setTerminationDate(converDateToString(providerDO
							.getTerminationDate()));
					if (null != providerDO.getTdmProviderAddrs()) {
						for (TdmProviderAddrDO tdmProviderAddrDO : providerDO.getTdmProviderAddrs()) {
							if (null != tdmProviderAddrDO.getParentLocation()) {
								tDMProvSearchResultListDTO.setProvAddr1(tdmProviderAddrDO
										.getAddress1());
								tDMProvSearchResultListDTO.setProvAddr2(tdmProviderAddrDO
										.getAddress2());
								tDMProvSearchResultListDTO.setProvCity(tdmProviderAddrDO.getCity());
								tDMProvSearchResultListDTO.setProvState(tdmProviderAddrDO
										.getState());
							}
						}
					}
					if (null != reservationDOs && 0 < reservationDOs.size()) {
						for (int j = 0; j < reservationDOs.size(); j++) {
							if (null != reservationDOs.get(j).getReserveDataType()
									&& reservationDOs.get(j).getReserveDataType()
											.equalsIgnoreCase(AppConstant.PROV)) {
								if (providerDOList.get(i).getProviderId() == Long
										.parseLong(reservationDOs.get(j).getReserveDataId())) {
									tDMProvSearchResultListDTO.setReservedYN(AppConstant.YES);
									tDMProvSearchResultListDTO.setTestCaseId(reservationDOs.get(j)
											.getTestCaseId());
									tDMProvSearchResultListDTO.setTestCaseName(reservationDOs
											.get(j).getTestCaseName());
									tDMProvSearchResultListDTO.setUserId(reservationDOs.get(j)
											.getUserId());
									Date date1 = reservationDOs.get(j).getUnlockTime();
									long diff = date2.getTime() - date1.getTime();
									switch ((int) (TimeUnit.DAYS.convert(diff,
											TimeUnit.MILLISECONDS))) {
										case 0:
											date1 = DateUtils.addDays(date1, 5);
											break;
										case 1:
											date1 = DateUtils.addDays(date1, 4);
											break;
										case 2:
											date1 = DateUtils.addDays(date1, 3);
											break;
										case 3:
											date1 = DateUtils.addDays(date1, 2);
											break;
										case 4:
											date1 = DateUtils.addDays(date1, 1);
											break;
										case 5:
											date1 = DateUtils.addDays(date1, 0);
											break;
										default:
											break;
									}
									tDMProvSearchResultListDTO
											.setExpairDate(myFormat.format(date1));
								}
							}
						}
					}
					if (StringUtils.isNotEmpty(tDMProvSearchResultListDTO.getUserId())) {
						if (tDMProvSearchResultListDTO.getUserId().equalsIgnoreCase(userName)) {
							fTDProvSearchResultListDTOList.add(tDMProvSearchResultListDTO);
						}
					} else {
						fTDProvSearchResultListDTOList.add(tDMProvSearchResultListDTO);
					}
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DO_TO_DTO
					+ MessageConstant.LOG_INFO_RETURN);
			return fTDProvSearchResultListDTOList;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}

	}

	@Override
	public List<TDMSubscSearchResultListDTO> converTdmSubscriberDOTofTDSubscSearchResultListDTO(
			List<TdmSubscriberDO> tdmSubscriberDOList, List<TdmReservationDO> reservationDOs,
			String userName) throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_DTO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			List<TDMSubscSearchResultListDTO> fTDSubscSearchResultListDTOList = null;
			DateFormat myFormat = new SimpleDateFormat(AppConstant.MMDDYYYY);
			Calendar cal = Calendar.getInstance();
			Date date2 = cal.getTime();
			if (null != tdmSubscriberDOList && 0 < tdmSubscriberDOList.size()) {
				TdmSubscriberDO subscriberDO = null;
				TDMSubscSearchResultListDTO tDMSubscSearchResultListDTO = null;
				fTDSubscSearchResultListDTOList = new ArrayList<TDMSubscSearchResultListDTO>();
				for (int i = 0; i < tdmSubscriberDOList.size(); i++) {
					subscriberDO = tdmSubscriberDOList.get(i);
					tDMSubscSearchResultListDTO = new TDMSubscSearchResultListDTO();
					tDMSubscSearchResultListDTO.setSubscriberId(subscriberDO.getSubscriberId());
					tDMSubscSearchResultListDTO.setGender(subscriberDO.getGender());
					tDMSubscSearchResultListDTO.setSsn(subscriberDO.getSsn());
					tDMSubscSearchResultListDTO.setSubcContCode(subscriberDO.getContractCode());
					tDMSubscSearchResultListDTO.setLob(subscriberDO.getLob());
					tDMSubscSearchResultListDTO.setPcp(subscriberDO.getPcp());
					tDMSubscSearchResultListDTO.setPlanId(subscriberDO.getPlanId());
					tDMSubscSearchResultListDTO.setPlanName(subscriberDO.getPlanName());
					tDMSubscSearchResultListDTO.setSubcStatus(subscriberDO.getStatus());
					tDMSubscSearchResultListDTO.setBirthDate(converDateToString(subscriberDO
							.getBirthDate()));
					tDMSubscSearchResultListDTO.setDateChanged(converDateToString(subscriberDO
							.getTermDate()));
					if (null != subscriberDO.getTdmSubscriberNames()) {
						tDMSubscSearchResultListDTO.setFirstName(subscriberDO
								.getTdmSubscriberNames().getGivenName());
						tDMSubscSearchResultListDTO.setLastName(subscriberDO
								.getTdmSubscriberNames().getFamilyName());
					}
					if (null != subscriberDO.getTdmSubscriberRelationships()
							&& 0 < subscriberDO.getTdmSubscriberRelationships().size()) {
						tDMSubscSearchResultListDTO.setSubcType(subscriberDO
								.getTdmSubscriberRelationships().get(0).getRelationshipType());
						tDMSubscSearchResultListDTO.setDependentId(String.valueOf(subscriberDO
								.getTdmSubscriberRelationships().get(0).getRelationshipId()));
					} else {
						tDMSubscSearchResultListDTO.setSubcType(subscriberDO.getSubcType());
					}
					if (null != subscriberDO.getTdmSuscriberAddresses()) {
						for (TdmSuscriberAddressDO tdmSuscriberAddress : subscriberDO
								.getTdmSuscriberAddresses()) {
							if (0 != tdmSuscriberAddress.getSubscriberAddressId()) {
								tDMSubscSearchResultListDTO.setSubcAddr1(tdmSuscriberAddress
										.getAddrress1());
								tDMSubscSearchResultListDTO.setSubcAddr2(tdmSuscriberAddress
										.getAddrress2());
								tDMSubscSearchResultListDTO.setSubcCity(tdmSuscriberAddress
										.getCityVillage());
								tDMSubscSearchResultListDTO.setSubcState(tdmSuscriberAddress
										.getStateProvince());
								tDMSubscSearchResultListDTO.setSubcZip(tdmSuscriberAddress
										.getZipCode());
							}
						}
					}
					if (null != reservationDOs && 0 < reservationDOs.size()) {
						for (int j = 0; j < reservationDOs.size(); j++) {

							if (null != reservationDOs.get(j).getReserveDataType()
									&& reservationDOs.get(j).getReserveDataType()
											.equalsIgnoreCase(AppConstant.SUB)) {
								if (tdmSubscriberDOList.get(i).getSubscriberId()
										.equalsIgnoreCase(reservationDOs.get(j).getReserveDataId())) {
									tDMSubscSearchResultListDTO.setReservedYN(AppConstant.YES);
									tDMSubscSearchResultListDTO.setTestCaseId(reservationDOs.get(j)
											.getTestCaseId());
									tDMSubscSearchResultListDTO.setTestCaseName(reservationDOs.get(
											j).getTestCaseName());
									tDMSubscSearchResultListDTO.setUserId(reservationDOs.get(j)
											.getUserId());
									Date date1 = reservationDOs.get(j).getUnlockTime();
									long diff = date2.getTime() - date1.getTime();
									switch ((int) (TimeUnit.DAYS.convert(diff,
											TimeUnit.MILLISECONDS))) {
										case 0:
											date1 = DateUtils.addDays(date1, 5);
											break;
										case 1:
											date1 = DateUtils.addDays(date1, 4);
											break;
										case 2:
											date1 = DateUtils.addDays(date1, 3);
											break;
										case 3:
											date1 = DateUtils.addDays(date1, 2);
											break;
										case 4:
											date1 = DateUtils.addDays(date1, 1);
											break;
										case 5:
											date1 = DateUtils.addDays(date1, 0);
											break;
										default:
											break;
									}
									tDMSubscSearchResultListDTO.setExpairDate(myFormat
											.format(date1));
								}
							}
						}
					}
					if (StringUtils.isNotEmpty(tDMSubscSearchResultListDTO.getUserId())) {
						if (tDMSubscSearchResultListDTO.getUserId().equalsIgnoreCase(userName)) {
							fTDSubscSearchResultListDTOList.add(tDMSubscSearchResultListDTO);
						}
					} else {
						fTDSubscSearchResultListDTOList.add(tDMSubscSearchResultListDTO);
					}
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_DTO
					+ MessageConstant.LOG_INFO_RETURN);
			return fTDSubscSearchResultListDTOList;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> converfTDProvSearchResultListDTOToTdmReservationDO(
			List<TDMProvSearchResultListDTO> fTDProvSearchResultListDTOList, String userName)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DTO_TO_DO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		List<TdmReservationDO> reservationDOList = null;
		try {
			if (null != fTDProvSearchResultListDTOList && 0 < fTDProvSearchResultListDTOList.size()) {
				TdmReservationDO reservationDO = null;
				TDMProvSearchResultListDTO tDMProvSearchResultListDTO = null;
				reservationDOList = new ArrayList<TdmReservationDO>();
				for (int i = 0; i < fTDProvSearchResultListDTOList.size(); i++) {
					tDMProvSearchResultListDTO = fTDProvSearchResultListDTOList.get(i);
					if (null != tDMProvSearchResultListDTO.getReservedYN()) {
						reservationDO = new TdmReservationDO();
						if (0 < tDMProvSearchResultListDTO.getProviderId()) {
							reservationDO.setReserveDataId(String
									.valueOf(tDMProvSearchResultListDTO.getProviderId()));
						}
						reservationDO.setLocked(AppConstant.Y);
						reservationDO.setReserveData(null);
						reservationDO.setRowData(null);
						reservationDO.setUserId(userName);
						reservationDO.setUnreserve(AppConstant.N);
						reservationDO.setReserveDataType(AppConstant.PROV);
						reservationDO.setUnlockTime(new Timestamp(new Date().getTime()));
						reservationDOList.add(reservationDO);
					}
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DTO_TO_DO
					+ MessageConstant.LOG_INFO_RETURN);
			return reservationDOList;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> converTDMSubscSearchResultListDTOToTdmReservationDO(
			List<TDMSubscSearchResultListDTO> tdmSubscSearchResultListDTOList, String userId)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DTO_TO_DO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		List<TdmReservationDO> reservationDOList = null;
		try {
			if (null != tdmSubscSearchResultListDTOList
					&& 0 < tdmSubscSearchResultListDTOList.size()) {
				TdmReservationDO reservationDO = null;
				TDMSubscSearchResultListDTO tDMSubscSearchResultListDTO = null;
				reservationDOList = new ArrayList<TdmReservationDO>();
				for (int i = 0; i < tdmSubscSearchResultListDTOList.size(); i++) {
					tDMSubscSearchResultListDTO = tdmSubscSearchResultListDTOList.get(i);
					if (null != tDMSubscSearchResultListDTO.getReservedYN()) {
						reservationDO = new TdmReservationDO();
						if (null != tDMSubscSearchResultListDTO.getSubscriberId()) {
							reservationDO.setReserveDataId(tDMSubscSearchResultListDTO
									.getSubscriberId());
						}

						reservationDO.setLocked(AppConstant.Y);
						reservationDO.setReserveData(null);
						reservationDO.setRowData(null);
						reservationDO.setUserId(userId);
						reservationDO.setUnreserve(AppConstant.N);
						reservationDO.setReserveDataType(AppConstant.SUB);
						reservationDO.setUnlockTime(new Timestamp(new Date().getTime()));
						reservationDOList.add(reservationDO);
					}
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DTO_TO_DO
					+ MessageConstant.LOG_INFO_RETURN);
			return reservationDOList;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TDMProvSearchDTO converDOtoDropdown(
			List<TdmProviderTypeMasterDO> tdmProviderTypeParentDOs,
			List<TdmProviderCatMasterDO> tdmProviderCatParentDOs, List<TdmUsStateDO> tdmUsStateDOs,
			TDMProvSearchDTO tDMProvSearchDTO) throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DO_TO_DROP
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			tDMProvSearchDTO
					.setTdmProviderTypeParentDTOs(converDOtoDropdownProvType(tdmProviderTypeParentDOs));
			tDMProvSearchDTO
					.setTdmProviderCatParentDTOs(converDOtoDropdownProvCat(tdmProviderCatParentDOs));
			tDMProvSearchDTO.setTdmUsStateDTOs(converDOtoDropdownProvState(tdmUsStateDOs));
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DO_TO_DROP
					+ MessageConstant.LOG_INFO_RETURN);
			return tDMProvSearchDTO;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER
					+ MessageConstant.TDM_FTD_MP_PROV_DO_TO_DROP
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER
					+ MessageConstant.TDM_FTD_MP_PROV_DO_TO_DROP
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	public List<TdmProviderTypeParentDTO> converDOtoDropdownProvType(
			List<TdmProviderTypeMasterDO> tdmProviderTypeParentDOs) throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DO_TO_TYPE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		TdmProviderTypeParentDTO tdmProviderTypeParentDTO = null;
		List<TdmProviderTypeParentDTO> tdmProviderTypeParentDTOs = null;
		try {
			if (null != tdmProviderTypeParentDOs) {
				tdmProviderTypeParentDTOs = new ArrayList<TdmProviderTypeParentDTO>();
				for (TdmProviderTypeMasterDO tdmProviderTypeParentDO : tdmProviderTypeParentDOs) {
					tdmProviderTypeParentDTO = new TdmProviderTypeParentDTO();
					tdmProviderTypeParentDTO.setProviderTypeId(tdmProviderTypeParentDO
							.getProviderTypeId());
					tdmProviderTypeParentDTO.setProviderTypeName(tdmProviderTypeParentDO
							.getProviderTypeName());
					tdmProviderTypeParentDTOs.add(tdmProviderTypeParentDTO);
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DO_TO_TYPE
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmProviderTypeParentDTOs;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER
					+ MessageConstant.TDM_FTD_MP_PROV_DO_TO_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER
					+ MessageConstant.TDM_FTD_MP_PROV_DO_TO_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	public List<TdmProviderCatParentDTO> converDOtoDropdownProvCat(
			List<TdmProviderCatMasterDO> tdmProviderCatParentDOs) throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DO_TO_CAT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		TdmProviderCatParentDTO tdmProviderCatParentDTO = null;
		List<TdmProviderCatParentDTO> tdmProviderCatParentDTOs = null;
		try {
			if (null != tdmProviderCatParentDOs) {
				tdmProviderCatParentDTOs = new ArrayList<TdmProviderCatParentDTO>();
				for (TdmProviderCatMasterDO tdmProviderCatParentDO : tdmProviderCatParentDOs) {
					tdmProviderCatParentDTO = new TdmProviderCatParentDTO();
					tdmProviderCatParentDTO.setProviderCategoryId(tdmProviderCatParentDO
							.getProviderCategoryId());
					tdmProviderCatParentDTO.setProviderCategoryName(tdmProviderCatParentDO
							.getProviderCategoryName());
					tdmProviderCatParentDTOs.add(tdmProviderCatParentDTO);
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DO_TO_CAT
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmProviderCatParentDTOs;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DO_TO_CAT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DO_TO_CAT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	public List<TdmUsStateDTO> converDOtoDropdownProvState(List<TdmUsStateDO> tdmUsStateDOs)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_PROV_DO_TO_STATE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		TdmUsStateDTO tdmUsStateDTO = null;
		List<TdmUsStateDTO> tdmUsStateDTOs = null;
		try {
			if (null != tdmUsStateDOs) {
				tdmUsStateDTOs = new ArrayList<TdmUsStateDTO>();
				for (TdmUsStateDO tdmUsStateDO : tdmUsStateDOs) {
					tdmUsStateDTO = new TdmUsStateDTO();
					tdmUsStateDTO.setStateName(tdmUsStateDO.getStateName());
					tdmUsStateDTO.setRefName(tdmUsStateDO.getRefName());
					tdmUsStateDTOs.add(tdmUsStateDTO);
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER
					+ MessageConstant.TDM_FTD_MP_PROV_DO_TO_STATE + MessageConstant.LOG_INFO_RETURN);
			return tdmUsStateDTOs;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER
					+ MessageConstant.TDM_FTD_MP_PROV_DO_TO_STATE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER
					+ MessageConstant.TDM_FTD_MP_PROV_DO_TO_STATE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	public String converDateToString(Date date) throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_DATE_TO_STRING
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			if (null != date) {
				SimpleDateFormat dataFormater = new SimpleDateFormat("dd/MM/yyyy");
				String stringobj = dataFormater.format(date);
				logger.info(MessageConstant.TDM_FTD_MAPPER
						+ MessageConstant.TDM_FTD_MP_DATE_TO_STRING
						+ MessageConstant.LOG_INFO_RETURN);
				return stringobj;
			}

			return null;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_DATE_TO_STRING
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_DATE_TO_STRING
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TDMSubscSearchDTO converDOtoDropdownSubcDTO(
			List<TdmSubscTypeMastDO> tdmSubscTypeMastDOs,
			List<TdmSubscStatusMastDO> tdmSubscStatusMastDOs,
			List<TdmUsStateSubDO> tdmUsStateSubDOs, List<TdmSubscLobMastDO> tdmSubscLobMastDOs,
			TDMSubscSearchDTO tDMSubscSearchDTO) throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_DROP
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			tDMSubscSearchDTO
					.setTdmSubscTypeMastDTOs(converDOtoDropdownSubcTypMst(tdmSubscTypeMastDOs));
			tDMSubscSearchDTO
					.setTdmSubscStatusMastDTOs(converDOtoDropdownSubcStsMst(tdmSubscStatusMastDOs));
			tDMSubscSearchDTO.setTdmUsStateDTOs(converDOtoDropdownSubcStateMst(tdmUsStateSubDOs));
			tDMSubscSearchDTO
					.setTdmSubscLobMastDTOs(converDOtoDropdownSubcLobMst(tdmSubscLobMastDOs));
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_DROP
					+ MessageConstant.LOG_INFO_RETURN);
			return tDMSubscSearchDTO;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_DROP
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_DROP
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	public List<TdmSubscTypeMastDTO> converDOtoDropdownSubcTypMst(
			List<TdmSubscTypeMastDO> tdmSubscTypeMastDOs) throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_TYPE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		List<TdmSubscTypeMastDTO> tdmSubscTypeMastDTOs = null;
		TdmSubscTypeMastDTO tdmSubscTypeMastDTO = null;
		try {
			if (null != tdmSubscTypeMastDOs) {
				tdmSubscTypeMastDTOs = new ArrayList<TdmSubscTypeMastDTO>();
				for (TdmSubscTypeMastDO tdmSubscTypeMastDO : tdmSubscTypeMastDOs) {
					tdmSubscTypeMastDTO = new TdmSubscTypeMastDTO();
					tdmSubscTypeMastDTO.setId(tdmSubscTypeMastDO.getId());
					tdmSubscTypeMastDTO.setSubscTypeDesc(tdmSubscTypeMastDO.getSubscTypeDesc());
					tdmSubscTypeMastDTOs.add(tdmSubscTypeMastDTO);
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_TYPE
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmSubscTypeMastDTOs;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	public List<TdmSubscStatusMastDTO> converDOtoDropdownSubcStsMst(
			List<TdmSubscStatusMastDO> tdmSubscStatusMastDOs) throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_STS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		List<TdmSubscStatusMastDTO> tdmSubscStatusMastDTOs = null;
		TdmSubscStatusMastDTO tdmSubscStatusMastDTO = null;
		try {
			if (null != tdmSubscStatusMastDOs) {
				tdmSubscStatusMastDTOs = new ArrayList<TdmSubscStatusMastDTO>();
				for (TdmSubscStatusMastDO tdmSubscStatusMastDO : tdmSubscStatusMastDOs) {
					tdmSubscStatusMastDTO = new TdmSubscStatusMastDTO();
					tdmSubscStatusMastDTO.setId(tdmSubscStatusMastDO.getId());
					tdmSubscStatusMastDTO.setSubscStatusDesc(tdmSubscStatusMastDO
							.getSubscStatusDesc());
					tdmSubscStatusMastDTOs.add(tdmSubscStatusMastDTO);
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_STS
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmSubscStatusMastDTOs;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_STS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_STS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	public List<TdmUsStateDTO> converDOtoDropdownSubcStateMst(List<TdmUsStateSubDO> tdmUsStateSubDOs)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_STATE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		TdmUsStateDTO tdmUsStateDTO = null;
		List<TdmUsStateDTO> tdmUsStateDTOs = null;
		try {
			if (null != tdmUsStateSubDOs) {
				tdmUsStateDTOs = new ArrayList<TdmUsStateDTO>();
				for (TdmUsStateSubDO tdmUsStateSubDO : tdmUsStateSubDOs) {
					tdmUsStateDTO = new TdmUsStateDTO();
					tdmUsStateDTO.setStateName(tdmUsStateSubDO.getStateName());
					tdmUsStateDTO.setRefName(tdmUsStateSubDO.getRefName());
					tdmUsStateDTOs.add(tdmUsStateDTO);
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_STATE
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmUsStateDTOs;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER
					+ MessageConstant.TDM_FTD_MP_SUB_DO_TO_STATE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER
					+ MessageConstant.TDM_FTD_MP_SUB_DO_TO_STATE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	public List<TdmSubscLobMastDTO> converDOtoDropdownSubcLobMst(
			List<TdmSubscLobMastDO> tdmSubscLobMastDOs) throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_LOB
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		TdmSubscLobMastDTO tdmSubscLobMastDTO = null;
		List<TdmSubscLobMastDTO> tdmSubscLobMastDTOs = null;
		try {
			if (null != tdmSubscLobMastDOs) {
				tdmSubscLobMastDTOs = new ArrayList<TdmSubscLobMastDTO>();
				for (TdmSubscLobMastDO tdmSubscLobMastDO : tdmSubscLobMastDOs) {
					tdmSubscLobMastDTO = new TdmSubscLobMastDTO();
					tdmSubscLobMastDTO.setId(tdmSubscLobMastDO.getId());
					tdmSubscLobMastDTO.setSubscLobDesc(tdmSubscLobMastDO.getSubscLobDesc());
					tdmSubscLobMastDTOs.add(tdmSubscLobMastDTO);
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_LOB
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmSubscLobMastDTOs;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_LOB
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_SUB_DO_TO_LOB
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmNonStandSearchDTO converDOtoDropdownAll(
			List<TdmProviderTypeMasterDO> tdmProviderTypeParentDOs,
			List<TdmProviderCatMasterDO> tdmProviderCatParentDOs,
			List<TdmSubscTypeMastDO> tdmSubscTypeMastDOs,
			List<TdmSubscStatusMastDO> tdmSubscStatusMastDOs,
			List<TdmSubscLobMastDO> tdmSubscLobMastDOs, List<TdmUsStateDO> tdmUsStateDOs,
			TdmNonStandSearchDTO tdmNonStandSearchDTO,
			List<TdmClaimTypeMastDO> tdmClaimTypeMastDOs,
			List<TdmClaimStatusMastDO> tdmClaimStatusMastDOs,
			List<TdmClaimSrcMastDO> tdmClaimSrcMastDOs, List<TdmPosMastDO> tdmClaimPOSMastDO)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_DO_TO_ALL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			tdmNonStandSearchDTO
					.setTdmProviderCatParentDTOs(converDOtoDropdownProvCat(tdmProviderCatParentDOs));
			tdmNonStandSearchDTO
					.setTdmProviderTypeParentDTOs(converDOtoDropdownProvType(tdmProviderTypeParentDOs));
			tdmNonStandSearchDTO
					.setTdmSubscTypeMastDTOs(converDOtoDropdownSubcTypMst(tdmSubscTypeMastDOs));
			tdmNonStandSearchDTO
					.setTdmSubscStatusMastDTOs(converDOtoDropdownSubcStsMst(tdmSubscStatusMastDOs));
			tdmNonStandSearchDTO
					.setTdmClaimStatusMastDTOs(converDOtoDropdownClaimStsMst(tdmClaimStatusMastDOs));
			tdmNonStandSearchDTO.setTdmUsStateDTOs(converDOtoDropdownProvState(tdmUsStateDOs));
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_DO_TO_ALL
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmNonStandSearchDTO;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_DO_TO_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_DO_TO_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	private List<TDMClaimStatusMastDTO> converDOtoDropdownClaimStsMst(
			List<TdmClaimStatusMastDO> tdmClaimStatusMastDOs) throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DO_TO_STS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		List<TDMClaimStatusMastDTO> tdmClaimStatusMastDTOList = null;
		TDMClaimStatusMastDTO tdmClaimStatusMastDTO = null;
		try {
			if (tdmClaimStatusMastDOs != null) {
				tdmClaimStatusMastDTOList = new ArrayList<TDMClaimStatusMastDTO>();
				for (TdmClaimStatusMastDO tdmClaimStatusMastDO : tdmClaimStatusMastDOs) {
					tdmClaimStatusMastDTO = new TDMClaimStatusMastDTO();
					tdmClaimStatusMastDTO.setId(tdmClaimStatusMastDO.getId());
					tdmClaimStatusMastDTO.setClaimStatusDesc(tdmClaimStatusMastDO
							.getClaimStatusDesc());
					tdmClaimStatusMastDTOList.add(tdmClaimStatusMastDTO);
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DO_TO_STS
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmClaimStatusMastDTOList;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DO_TO_STS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DO_TO_STS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TDMClaimSearchResultListDTO> convertTdmClaimDOTofTDClaimSearchResultListDTO(
			List<TdmClaimDO> tdmClaimDOList, List<TdmReservationDO> reservationDOs, String userName)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DO_TO_DTO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			DateFormat myFormat = new SimpleDateFormat(AppConstant.MMDDYYYY);
			Calendar cal = Calendar.getInstance();
			Date date2 = cal.getTime();
			List<TDMClaimSearchResultListDTO> fTDClaimSearchResultListDTOList = null;
			if (null != tdmClaimDOList && 0 < tdmClaimDOList.size()) {
				TdmClaimDO claimDO = null;
				TDMClaimSearchResultListDTO tDMClaimSearchResultListDTO = null;
				fTDClaimSearchResultListDTOList = new ArrayList<TDMClaimSearchResultListDTO>();
				for (int i = 0; i < tdmClaimDOList.size(); i++) {
					claimDO = tdmClaimDOList.get(i);
					tDMClaimSearchResultListDTO = new TDMClaimSearchResultListDTO();
					tDMClaimSearchResultListDTO.setClaimId(claimDO.getClaimId());
					tDMClaimSearchResultListDTO.setClaimType(claimDO.getClaimType());
					tDMClaimSearchResultListDTO.setClaimPatientGender(claimDO.getGender());
					tDMClaimSearchResultListDTO.setClaimStatus(claimDO.getClaimStatus());
					tDMClaimSearchResultListDTO.setAdmissionDate(converDateToString(claimDO
							.getAdmissionDate()));
					tDMClaimSearchResultListDTO.setDischargeDate(converDateToString(claimDO
							.getDischargeDate()));
					tDMClaimSearchResultListDTO.setClaimGrpNum(claimDO.getGroupId());
					tDMClaimSearchResultListDTO.setPatientFirstName(claimDO.getPatientFname());
					tDMClaimSearchResultListDTO.setPatientLastName(claimDO.getPatientLname());
					tDMClaimSearchResultListDTO.setPatientId(claimDO.getSubId());
					tDMClaimSearchResultListDTO.setClaimSource(claimDO.getClaimSource());
					tDMClaimSearchResultListDTO.setClaimReceiptDate(converDateToString(claimDO
							.getReceiptDate()));
					tDMClaimSearchResultListDTO.setCoins(claimDO.getCoIns());
					tDMClaimSearchResultListDTO.setDeductible(claimDO.getDeductible());
					tDMClaimSearchResultListDTO.setTotalCharge(claimDO.getTotalBillCharged());
					tDMClaimSearchResultListDTO.setTotalAllowed(claimDO.getTotalAllowed());
					tDMClaimSearchResultListDTO.setTotalPaid(claimDO.getTotalBillPaid());
					tDMClaimSearchResultListDTO.setCopay(claimDO.getCopay());
					tDMClaimSearchResultListDTO.setClaimProviderNPI(claimDO
							.getTdmClaimLineDetails().get(0).getProc());
					tDMClaimSearchResultListDTO.setClaimProviderTIN(claimDO
							.getTdmClaimLineDetails().get(0).getTin());
					tDMClaimSearchResultListDTO.setClaimIntOn(claimDO.getIntClaim());
					tDMClaimSearchResultListDTO.setClaimDXCode(claimDO.getTdmClaimLineDetails()
							.get(0).getDx());
					tDMClaimSearchResultListDTO.setClaimPOS(claimDO.getTdmClaimLineDetails().get(0)
							.getPos());
					tDMClaimSearchResultListDTO.setClaimProcCode(claimDO.getTdmClaimLineDetails()
							.get(0).getProc());
					tDMClaimSearchResultListDTO.setClaimModifier(claimDO.getTdmClaimLineDetails()
							.get(0).getModifier());
					if (null != reservationDOs && 0 < reservationDOs.size()) {
						for (int j = 0; j < reservationDOs.size(); j++) {
							if (null != reservationDOs.get(j).getReserveDataType()
									&& reservationDOs.get(j).getReserveDataType()
											.equalsIgnoreCase(AppConstant.CLM)) {
								if (tdmClaimDOList.get(i).getClaimId()
										.equalsIgnoreCase(reservationDOs.get(j).getReserveDataId())) {
									tDMClaimSearchResultListDTO.setReservedYN(AppConstant.YES);
									tDMClaimSearchResultListDTO.setTestCaseId(reservationDOs.get(j)
											.getTestCaseId());
									tDMClaimSearchResultListDTO.setTestCaseName(reservationDOs.get(
											j).getTestCaseName());
									tDMClaimSearchResultListDTO.setUserId(reservationDOs.get(j)
											.getUserId());
									Date date1 = reservationDOs.get(j).getUnlockTime();
									long diff = date2.getTime() - date1.getTime();
									switch ((int) (TimeUnit.DAYS.convert(diff,
											TimeUnit.MILLISECONDS))) {
										case 0:
											date1 = DateUtils.addDays(date1, 5);
											break;
										case 1:
											date1 = DateUtils.addDays(date1, 4);
											break;
										case 2:
											date1 = DateUtils.addDays(date1, 3);
											break;
										case 3:
											date1 = DateUtils.addDays(date1, 2);
											break;
										case 4:
											date1 = DateUtils.addDays(date1, 1);
											break;
										case 5:
											date1 = DateUtils.addDays(date1, 0);
											break;
										default:
											break;
									}
									tDMClaimSearchResultListDTO.setExpireDate(myFormat
											.format(date1));
								}
							}
						}
					}
					if (StringUtils.isNotEmpty(tDMClaimSearchResultListDTO.getUserId())) {
						if (tDMClaimSearchResultListDTO.getUserId().equalsIgnoreCase(userName)) {
							fTDClaimSearchResultListDTOList.add(tDMClaimSearchResultListDTO);
						}
					} else {
						fTDClaimSearchResultListDTOList.add(tDMClaimSearchResultListDTO);
					}
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DO_TO_DTO
					+ MessageConstant.LOG_INFO_RETURN);
			return fTDClaimSearchResultListDTOList;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TDMClaimSearchDTO converDOtoDropdownClaimDTO(
			List<TdmClaimTypeMastDO> tdmClaimTypeMastDOs,
			List<TdmClaimStatusMastDO> tdmClaimStatusMastDOs,
			List<TdmClaimSrcMastDO> tdmClaimSrcMastDOs,
			List<TdmTypeOfBillMastDO> tdmClaimTypeOfBillMastDOs,
			List<TdmPosMastDO> tdmClaimPOSMastDOs, TDMClaimSearchDTO tDMClaimSearchDTO)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DO_TO_DROP
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		TDMClaimTypeMastDTO tdmClaimTypeMastDTO = null;
		TDMClaimStatusMastDTO tdmClaimStatusMastDTO = null;
		TDMClaimSrcDTO tdmClaimSrcDTO = null;
		TDMClaimTypeOfBillsMastDTO tdmClaimTypeOfBillsMastDTO = null;
		TDMClaimPOSMastDTO tdmClaimPOSMastDTO = null;
		List<TDMClaimTypeMastDTO> tdmClaimTypeMastDTOList = null;
		List<TDMClaimStatusMastDTO> tdmClaimStatusMastDTOList = null;
		List<TDMClaimSrcDTO> tdmClaimSrcMastDTOList = null;
		List<TDMClaimTypeOfBillsMastDTO> tdmClaimTypeOfBillsMastDTOList = null;
		List<TDMClaimPOSMastDTO> tdmClaimPOSMastDTOList = null;
		try {
			if (tdmClaimTypeMastDOs != null) {
				tdmClaimTypeMastDTOList = new ArrayList<TDMClaimTypeMastDTO>();
				for (TdmClaimTypeMastDO tdmClaimTypeMastDO : tdmClaimTypeMastDOs) {
					tdmClaimTypeMastDTO = new TDMClaimTypeMastDTO();
					tdmClaimTypeMastDTO.setId(tdmClaimTypeMastDO.getId());
					tdmClaimTypeMastDTO.setClaimTypeDesc(tdmClaimTypeMastDO.getClaimTypeDesc());
					tdmClaimTypeMastDTOList.add(tdmClaimTypeMastDTO);
				}
			}
			if (tdmClaimStatusMastDOs != null) {
				tdmClaimStatusMastDTOList = new ArrayList<TDMClaimStatusMastDTO>();
				for (TdmClaimStatusMastDO tdmClaimStatusMastDO : tdmClaimStatusMastDOs) {
					tdmClaimStatusMastDTO = new TDMClaimStatusMastDTO();
					tdmClaimStatusMastDTO.setId(tdmClaimStatusMastDO.getId());
					tdmClaimStatusMastDTO.setClaimStatusDesc(tdmClaimStatusMastDO
							.getClaimStatusDesc());
					tdmClaimStatusMastDTOList.add(tdmClaimStatusMastDTO);
				}
			}
			if (tdmClaimSrcMastDOs != null) {
				tdmClaimSrcMastDTOList = new ArrayList<TDMClaimSrcDTO>();
				for (TdmClaimSrcMastDO tdmClaimSrcMastDO : tdmClaimSrcMastDOs) {
					tdmClaimSrcDTO = new TDMClaimSrcDTO();
					tdmClaimSrcDTO.setId(tdmClaimSrcMastDO.getId());
					tdmClaimSrcDTO.setClaimSrcDesc(tdmClaimSrcMastDO.getClaimSrcDesc());
					tdmClaimSrcMastDTOList.add(tdmClaimSrcDTO);
				}
			}
			if (tdmClaimTypeOfBillMastDOs != null) {
				tdmClaimTypeOfBillsMastDTOList = new ArrayList<TDMClaimTypeOfBillsMastDTO>();
				for (TdmTypeOfBillMastDO tdmTypeOfBillMastDO : tdmClaimTypeOfBillMastDOs) {
					tdmClaimTypeOfBillsMastDTO = new TDMClaimTypeOfBillsMastDTO();
					tdmClaimTypeOfBillsMastDTO.setId(tdmTypeOfBillMastDO.getId());
					tdmClaimTypeOfBillsMastDTO.setClaimTypeOfBillDesc(tdmTypeOfBillMastDO
							.getBillTypeDesc());
					tdmClaimTypeOfBillsMastDTOList.add(tdmClaimTypeOfBillsMastDTO);
				}
			}
			if (tdmClaimPOSMastDOs != null) {
				tdmClaimPOSMastDTOList = new ArrayList<TDMClaimPOSMastDTO>();
				for (TdmPosMastDO tdmPOSMastDO : tdmClaimPOSMastDOs) {
					tdmClaimPOSMastDTO = new TDMClaimPOSMastDTO();
					tdmClaimPOSMastDTO.setId(tdmPOSMastDO.getId());
					tdmClaimPOSMastDTO.setClaimPOSDesc(tdmPOSMastDO.getPosDesc());
					tdmClaimPOSMastDTOList.add(tdmClaimPOSMastDTO);
				}
			}
			tDMClaimSearchDTO.setTdmClaimSrcDTOs(tdmClaimSrcMastDTOList);
			tDMClaimSearchDTO.setTdmClaimStatusMastDTOs(tdmClaimStatusMastDTOList);
			tDMClaimSearchDTO.setTdmClaimTypeMastDTOs(tdmClaimTypeMastDTOList);
			tDMClaimSearchDTO.setTdmClaimTypeOfBillsMastDTOs(tdmClaimTypeOfBillsMastDTOList);
			tDMClaimSearchDTO.setTdmClaimPOSMastDTOs(tdmClaimPOSMastDTOList);
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DO_TO_DROP
					+ MessageConstant.LOG_INFO_RETURN);
			return tDMClaimSearchDTO;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DO_TO_DROP
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DO_TO_DROP
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> converTDMClaimSearchResultListDTOToTdmReservationDO(
			List<TDMClaimSearchResultListDTO> tdmClaimSearchResultListDTOList, String userId)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DTO_TO_DO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		List<TdmReservationDO> reservationDOList = null;
		try {
			if (null != tdmClaimSearchResultListDTOList
					&& 0 < tdmClaimSearchResultListDTOList.size()) {
				TdmReservationDO reservationDO = null;
				TDMClaimSearchResultListDTO tDMClaimSearchResultListDTO = null;
				reservationDOList = new ArrayList<TdmReservationDO>();
				for (int i = 0; i < tdmClaimSearchResultListDTOList.size(); i++) {
					tDMClaimSearchResultListDTO = tdmClaimSearchResultListDTOList.get(i);
					if (null != tDMClaimSearchResultListDTO.getReservedYN()) {
						reservationDO = new TdmReservationDO();
						if (null != tDMClaimSearchResultListDTO.getClaimId()) {
							reservationDO
									.setReserveDataId(tDMClaimSearchResultListDTO.getClaimId());
						}
						reservationDO.setLocked(AppConstant.Y);
						reservationDO.setReserveData(null);
						reservationDO.setRowData(null);
						reservationDO.setUserId(userId);
						reservationDO.setUnreserve(AppConstant.N);
						reservationDO.setReserveDataType(AppConstant.CLM);
						reservationDO.setUnlockTime(new Timestamp(new Date().getTime()));
						reservationDOList.add(reservationDO);
					}
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DTO_TO_DO
					+ MessageConstant.LOG_INFO_RETURN);
			return reservationDOList;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_CLM_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmNonStandardResultListDTO> converTdmDOsToTdmNonStandardResultListDTO(
			List<TdmProviderDO> providerDOlist, List<TdmSubscriberDO> subscriberDOlist,
			String userName) throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_NS_DO_TO_DTO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		List<TdmNonStandardResultListDTO> tdmNonStandardResultListDTOs = null;
		TdmNonStandardResultListDTO tdmNonStandardResultListDTO = null;
		try {
			if (null != providerDOlist && 0 < providerDOlist.size()) {
				tdmNonStandardResultListDTOs = new ArrayList<TdmNonStandardResultListDTO>();
				for (TdmProviderDO providerDO : providerDOlist) {
					tdmNonStandardResultListDTO = new TdmNonStandardResultListDTO();
					tdmNonStandardResultListDTO.setProviderId(providerDO.getProviderId());
					tdmNonStandardResultListDTO.setFirstName(providerDO.getFirstName());
					tdmNonStandardResultListDTO.setLastName(providerDO.getLastName());
					if (null != providerDO.getTdmProviderSpecialities()) {
						tdmNonStandardResultListDTO.setSpecialityDescription(providerDO
								.getTdmProviderSpecialities().getSpecialityDescription());
					}
					tdmNonStandardResultListDTO.setTin(providerDO.getTin());
					tdmNonStandardResultListDTO.setProvContactType(providerDO.getContractName());
					if (null != providerDO.getTdmProviderCategories()) {
						tdmNonStandardResultListDTO.setProvCatgType(providerDO
								.getTdmProviderCategories().getCategoryDescription());
					}
					if (null != providerDO.getTdmProviderTypes()
							&& 0 < providerDO.getTdmProviderTypes().size()) {
						tdmNonStandardResultListDTO.setProvType(providerDO.getTdmProviderTypes()
								.get(0).getProviderTypeName());
					}
					tdmNonStandardResultListDTO.setTerminationDate(converDateToString(providerDO
							.getTerminationDate()));
					if (null != providerDO.getTdmProviderAddrs()) {
						for (TdmProviderAddrDO tdmProviderAddrDO : providerDO.getTdmProviderAddrs()) {
							if (null != tdmProviderAddrDO.getParentLocation()) {
								tdmNonStandardResultListDTO.setProvState(tdmProviderAddrDO
										.getState());
							}
						}
					}
					tdmNonStandardResultListDTO.setSearchFlag(AppConstant.PROV);
					tdmNonStandardResultListDTOs.add(tdmNonStandardResultListDTO);
				}
			}
			List<TdmNonStandardResultListDTO> tdmNonStandardResultListDTOs1 = null;
			TdmNonStandardResultListDTO tdmNonStandardResultListDTO1 = null;
			if (null != subscriberDOlist && 0 < subscriberDOlist.size()) {
				if (null == tdmNonStandardResultListDTOs1) {
					tdmNonStandardResultListDTOs1 = new ArrayList<TdmNonStandardResultListDTO>();
				}
				for (TdmSubscriberDO subscriberDO : subscriberDOlist) {
					tdmNonStandardResultListDTO1 = new TdmNonStandardResultListDTO();
					tdmNonStandardResultListDTO1.setTin(subscriberDO.getPcp());
					tdmNonStandardResultListDTO1.setSubscriberId(subscriberDO.getSubscriberId());
					tdmNonStandardResultListDTO1.setTerminationDate(converDateToString(subscriberDO
							.getTermDate()));
					if (null != subscriberDO.getTdmSubscriberNames()) {
						tdmNonStandardResultListDTO1.setFirstName(subscriberDO
								.getTdmSubscriberNames().getGivenName());
						tdmNonStandardResultListDTO1.setLastName(subscriberDO
								.getTdmSubscriberNames().getFamilyName());
					}
					if (null != subscriberDO.getTdmSubscriberRelationships()) {
						tdmNonStandardResultListDTO1.setSubcType(subscriberDO
								.getTdmSubscriberRelationships().get(0).getRelationshipType());
					}
					if (null != subscriberDO.getTdmSuscriberAddresses()) {
						for (TdmSuscriberAddressDO tdmSuscriberAddress : subscriberDO
								.getTdmSuscriberAddresses()) {
							if (0 != tdmSuscriberAddress.getSubscriberAddressId()) {
								tdmNonStandardResultListDTO1.setProvState(tdmSuscriberAddress
										.getStateProvince());
							}
						}
					}
					tdmNonStandardResultListDTO1.setSearchFlag(AppConstant.SUB);
					tdmNonStandardResultListDTOs1.add(tdmNonStandardResultListDTO1);
				}
			}
			if (null != tdmNonStandardResultListDTOs && null != tdmNonStandardResultListDTOs1
					&& 0 < tdmNonStandardResultListDTOs.size()
					&& 0 < tdmNonStandardResultListDTOs1.size()) {
				for (int i = 0; i < tdmNonStandardResultListDTOs.size(); i++) {
					for (int j = 0; j < tdmNonStandardResultListDTOs1.size(); j++) {
						if (true) {
							tdmNonStandardResultListDTOs.get(i).setTin(
									tdmNonStandardResultListDTOs1.get(j).getTin());
							tdmNonStandardResultListDTOs.get(i).setSubscriberId(
									tdmNonStandardResultListDTOs1.get(j).getSubscriberId());
							tdmNonStandardResultListDTOs.get(i).setTerminationDate(
									tdmNonStandardResultListDTOs1.get(j).getTerminationDate());
							tdmNonStandardResultListDTOs.get(i).setSubcType(
									tdmNonStandardResultListDTOs1.get(j).getSubcType());
							tdmNonStandardResultListDTOs.get(i).setSubcState(
									tdmNonStandardResultListDTOs1.get(j).getProvState());
							tdmNonStandardResultListDTOs.get(i).setTerminationDate(
									tdmNonStandardResultListDTOs1.get(j).getTerminationDate());
							tdmNonStandardResultListDTOs.get(i).setSubcType(
									tdmNonStandardResultListDTOs1.get(j).getSubcType());
						}
					}
				}
			}
			logger.info(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_NS_DO_TO_DTO
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmNonStandardResultListDTOs;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_NS_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_MAPPER + MessageConstant.TDM_FTD_MP_NS_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

}
