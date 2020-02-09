/*---------------------------------------------------------------------------------------
 * Object Name: TdmPolicyClaimSearchMapperImp.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          20/08/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tdm.model.mapper.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
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
import com.tdm.model.DO.CcPolicyDO;
import com.tdm.model.DO.PcPolicyDO;
import com.tdm.model.DO.TdmReservationDO;
import com.tdm.model.DTO.TdmClaimSearchResultDTO;
import com.tdm.model.DTO.TdmPolicySearchResultDTO;
import com.tdm.model.mapper.TdmPolicySearchMapper;

/**
 * 
 * @author Seshadri Chowdary
 *
 */
@Component
@Service(MessageConstant.TDM_POLICY_CLAIM_SEARCH_MAPPER)
public class TdmPolicyClaimSearchMapperImp implements TdmPolicySearchMapper
{

	private static Logger logger = Logger.getLogger(TdmPolicyClaimSearchMapperImp.class);

	@Override
	public List<TdmPolicySearchResultDTO> converObjectToTdmPolicySearchResultDTO(
			List<Object[]> pcPolicyDOs, List<TdmReservationDO> reservationDOs, String userId)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
				+ MessageConstant.TDM_FTD_MP_POLICY_DO_TO_DTO + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			DateFormat myFormat = new SimpleDateFormat(AppConstant.MMDDYYYY);
			Calendar cal = Calendar.getInstance();
			Date date2 = cal.getTime();

			List<TdmPolicySearchResultDTO> tdmPolicySearchResultDTOs = null;
			if (null != pcPolicyDOs && !pcPolicyDOs.isEmpty()) {
				Object[] pcPolicyDO = null;
				TdmPolicySearchResultDTO tdmPolicySearchResultDTO = null;
				tdmPolicySearchResultDTOs = new ArrayList<TdmPolicySearchResultDTO>();
				for (int i = 0; i < pcPolicyDOs.size(); i++) {
					pcPolicyDO = pcPolicyDOs.get(i);
					tdmPolicySearchResultDTO = new TdmPolicySearchResultDTO();

					if (null != pcPolicyDO[0]) {
						tdmPolicySearchResultDTO.setPolicyNo(pcPolicyDO[0].toString());
					}

					if (null != pcPolicyDO[1]) {
						tdmPolicySearchResultDTO.setPrimInsuPerson(pcPolicyDO[1].toString());
					}
					if (null != pcPolicyDO[2]) {
						tdmPolicySearchResultDTO.setProductName(pcPolicyDO[2].toString());
					}
					if (null != pcPolicyDO[3]) {
						tdmPolicySearchResultDTO.setPolicyStats(pcPolicyDO[3].toString());
					}
					if (null != pcPolicyDO[4]) {
						tdmPolicySearchResultDTO
								.setEffecDate(converDateToString(converStringToDate(pcPolicyDO[4]
										.toString())));
					}
					if (null != pcPolicyDO[5]) {
						tdmPolicySearchResultDTO
								.setExpairDate(converDateToString(converStringToDate(pcPolicyDO[5]
										.toString())));
					}
					if (null != pcPolicyDO[6]) {
						tdmPolicySearchResultDTO.setAccNo(pcPolicyDO[6].toString());
					}
					if (null != pcPolicyDO[7]) {
						tdmPolicySearchResultDTO.setProducer(pcPolicyDO[7].toString());
					}
					if (null != pcPolicyDO[8]) {
						tdmPolicySearchResultDTO.setPolicyId(pcPolicyDO[8].toString());
					}

					if (null != reservationDOs && 0 < reservationDOs.size()) {
						for (int j = 0; j < reservationDOs.size(); j++) {
							if (null != reservationDOs.get(j).getReserveDataType()
									&& reservationDOs.get(j).getReserveDataType()
											.equalsIgnoreCase(AppConstant.POLICY)) {
								if (pcPolicyDO[0].toString().equalsIgnoreCase(
										reservationDOs.get(j).getReserveDataId())) {
									tdmPolicySearchResultDTO.setReservedYN(AppConstant.YES);
									tdmPolicySearchResultDTO.setTestCaseId(reservationDOs.get(j)
											.getTestCaseId());
									tdmPolicySearchResultDTO.setTestCaseName(reservationDOs.get(j)
											.getTestCaseName());
									tdmPolicySearchResultDTO.setUserId(reservationDOs.get(j)
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
									tdmPolicySearchResultDTO.setRevExpairDate(myFormat
											.format(date1));
								}
							}
						}
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchResultDTO.getUserId())) {
						if (tdmPolicySearchResultDTO.getUserId().equalsIgnoreCase(userId)) {
							tdmPolicySearchResultDTOs.add(tdmPolicySearchResultDTO);
						}
					} else {
						tdmPolicySearchResultDTOs.add(tdmPolicySearchResultDTO);
					}
				}
			}
			logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_POLICY_DO_TO_DTO + MessageConstant.LOG_INFO_RETURN);
			return tdmPolicySearchResultDTOs;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_POLICY_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_POLICY_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}

	}

	@Override
	public List<TdmClaimSearchResultDTO> converObjectToTdmClaimSearchResultDTO(
			List<Object[]> ccPolicyDOs, List<TdmReservationDO> reservationDOs, String userId)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
				+ MessageConstant.TDM_FTD_MP_CLAIM_DO_TO_DTO + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			DateFormat myFormat = new SimpleDateFormat(AppConstant.MMDDYYYY);
			Calendar cal = Calendar.getInstance();
			Date date2 = cal.getTime();

			List<TdmClaimSearchResultDTO> tdmClaimSearchResultDTOs = null;
			if (null != ccPolicyDOs && !ccPolicyDOs.isEmpty()) {
				Object[] ccPolicyDO = null;
				TdmClaimSearchResultDTO tdmClaimSearchResultDTO = null;
				tdmClaimSearchResultDTOs = new ArrayList<TdmClaimSearchResultDTO>();
				for (int i = 0; i < ccPolicyDOs.size(); i++) {
					ccPolicyDO = ccPolicyDOs.get(i);
					tdmClaimSearchResultDTO = new TdmClaimSearchResultDTO();

					if (null != ccPolicyDO[0]) {
						tdmClaimSearchResultDTO.setClaimNo(ccPolicyDO[0].toString());
					}
					if (null != ccPolicyDO[1]) {
						tdmClaimSearchResultDTO.setPolicyNo(ccPolicyDO[1].toString());
					}
					if (null != ccPolicyDO[2]) {
						tdmClaimSearchResultDTO.setPrimInsuPerson(ccPolicyDO[2].toString());
					}
					if (null != ccPolicyDO[3]) {
						tdmClaimSearchResultDTO.setClaimStats(ccPolicyDO[3].toString());
					}
					if (null != ccPolicyDO[4]) {
						tdmClaimSearchResultDTO.setSourceSystem(ccPolicyDO[4].toString());
					}
					if (null != ccPolicyDO[5]) {
						tdmClaimSearchResultDTO
								.setLossDate(converDateToString(converStringToDate(ccPolicyDO[5]
										.toString())));
					}
					if (null != ccPolicyDO[6]) {
						tdmClaimSearchResultDTO.setAmtTotPaid(ccPolicyDO[6].toString());
					}
					if (null != ccPolicyDO[7]) {
						tdmClaimSearchResultDTO.setAmtNetInc(ccPolicyDO[7].toString());
					}
					if (null != ccPolicyDO[8]) {
						tdmClaimSearchResultDTO.setLob(ccPolicyDO[8].toString());
					}
					if (null != ccPolicyDO[9]) {
						tdmClaimSearchResultDTO.setClaimId(ccPolicyDO[9].toString());
					}

					if (null != reservationDOs && 0 < reservationDOs.size()) {
						for (int j = 0; j < reservationDOs.size(); j++) {
							if (null != reservationDOs.get(j).getReserveDataType()
									&& reservationDOs.get(j).getReserveDataType()
											.equalsIgnoreCase(AppConstant.CLAIM)) {

								if (ccPolicyDO[0].toString().equalsIgnoreCase(
										reservationDOs.get(j).getReserveDataId())) {
									tdmClaimSearchResultDTO.setReservedYN(AppConstant.YES);
									tdmClaimSearchResultDTO.setTestCaseId(reservationDOs.get(j)
											.getTestCaseId());
									tdmClaimSearchResultDTO.setTestCaseName(reservationDOs.get(j)
											.getTestCaseName());
									tdmClaimSearchResultDTO.setUserId(reservationDOs.get(j)
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
									tdmClaimSearchResultDTO
											.setRevExpairDate(myFormat.format(date1));
								}
							}
						}
					}
					tdmClaimSearchResultDTOs.add(tdmClaimSearchResultDTO);
				}
			}
			logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_CLAIM_DO_TO_DTO + MessageConstant.LOG_INFO_RETURN);
			return tdmClaimSearchResultDTOs;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_CLAIM_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_CLAIM_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}

	}

	@Override
	public List<TdmPolicySearchResultDTO> converPcPolicyDOToTdmPolicySearchResultDTO(
			List<PcPolicyDO> pcPolicyDOs, List<TdmReservationDO> reservationDOs, String userId)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
				+ MessageConstant.TDM_FTD_MP_POLICY_DO_TO_DTO + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			DateFormat myFormat = new SimpleDateFormat(AppConstant.MMDDYYYY);
			Calendar cal = Calendar.getInstance();
			Date date2 = cal.getTime();

			List<TdmPolicySearchResultDTO> tdmPolicySearchResultDTOs = null;
			if (null != pcPolicyDOs && !pcPolicyDOs.isEmpty()) {
				PcPolicyDO pcPolicyDO = null;
				TdmPolicySearchResultDTO tdmPolicySearchResultDTO = null;
				tdmPolicySearchResultDTOs = new ArrayList<TdmPolicySearchResultDTO>();
				for (int i = 0; i < pcPolicyDOs.size(); i++) {
					pcPolicyDO = pcPolicyDOs.get(i);
					tdmPolicySearchResultDTO = new TdmPolicySearchResultDTO();

					tdmPolicySearchResultDTO.setPolicyId(String.valueOf(pcPolicyDO.getId()));
					tdmPolicySearchResultDTO.setProductName(pcPolicyDO.getProductcode());
					tdmPolicySearchResultDTO.setAccNo(String.valueOf(pcPolicyDO.getAccountid()));
					tdmPolicySearchResultDTO.setProducer(String.valueOf(pcPolicyDO
							.getProducercodeofserviceid()));

					if (null != pcPolicyDO.getPcPolicyperiodDOs()) {
						tdmPolicySearchResultDTO.setPolicyNo(pcPolicyDO.getPcPolicyperiodDOs()
								.get(0).getPolicynumber());
						tdmPolicySearchResultDTO.setPolicyStats(String.valueOf(pcPolicyDO
								.getPcPolicyperiodDOs().get(0).getStatus()));
						tdmPolicySearchResultDTO.setPrimInsuPerson(pcPolicyDO
								.getPcPolicyperiodDOs().get(0).getPrimaryinsuredname());
						tdmPolicySearchResultDTO
								.setEffecDate(converDateToString(converStringToDate(pcPolicyDO
										.getPcPolicyperiodDOs().get(0).getPeriodstart())));
						tdmPolicySearchResultDTO
								.setExpairDate(converDateToString(converStringToDate(pcPolicyDO
										.getPcPolicyperiodDOs().get(0).getPeriodend())));

					}

					if (null != reservationDOs && 0 < reservationDOs.size()) {
						for (int j = 0; j < reservationDOs.size(); j++) {
							if (null != reservationDOs.get(j).getReserveDataType()
									&& reservationDOs.get(j).getReserveDataType()
											.equalsIgnoreCase(AppConstant.POLICY)) {
								if (pcPolicyDOs.get(i).getId() == Long.parseLong(reservationDOs
										.get(j).getReserveDataId())) {
									tdmPolicySearchResultDTO.setReservedYN(AppConstant.YES);
									tdmPolicySearchResultDTO.setTestCaseId(reservationDOs.get(j)
											.getTestCaseId());
									tdmPolicySearchResultDTO.setTestCaseName(reservationDOs.get(j)
											.getTestCaseName());
									tdmPolicySearchResultDTO.setUserId(reservationDOs.get(j)
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
									tdmPolicySearchResultDTO.setRevExpairDate(myFormat
											.format(date1));
								}
							}
						}
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchResultDTO.getUserId())) {
						if (tdmPolicySearchResultDTO.getUserId().equalsIgnoreCase(userId)) {
							tdmPolicySearchResultDTOs.add(tdmPolicySearchResultDTO);
						}
					} else {
						tdmPolicySearchResultDTOs.add(tdmPolicySearchResultDTO);
					}
				}
			}
			logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_POLICY_DO_TO_DTO + MessageConstant.LOG_INFO_RETURN);
			return tdmPolicySearchResultDTOs;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_POLICY_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_POLICY_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}

	}

	@Override
	public List<TdmClaimSearchResultDTO> converCcPolicyDOToTdmPolicySearchResultDTO(
			List<CcPolicyDO> ccPolicyDOs, List<TdmReservationDO> reservationDOs, String userId)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
				+ MessageConstant.TDM_FTD_MP_CLAIM_DO_TO_DTO + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			DateFormat myFormat = new SimpleDateFormat(AppConstant.MMDDYYYY);
			Calendar cal = Calendar.getInstance();
			Date date2 = cal.getTime();

			List<TdmClaimSearchResultDTO> tdmClaimSearchResultDTOs = null;
			if (null != ccPolicyDOs && !ccPolicyDOs.isEmpty()) {
				CcPolicyDO ccPolicyDO = null;
				TdmClaimSearchResultDTO tdmClaimSearchResultDTO = null;
				tdmClaimSearchResultDTOs = new ArrayList<TdmClaimSearchResultDTO>();
				for (int i = 0; i < ccPolicyDOs.size(); i++) {
					ccPolicyDO = ccPolicyDOs.get(i);
					tdmClaimSearchResultDTO = new TdmClaimSearchResultDTO();

					tdmClaimSearchResultDTO.setClaimId(String.valueOf(ccPolicyDO.getId()));
					tdmClaimSearchResultDTO.setPolicyNo(ccPolicyDO.getPolicynumber());

					if (null != ccPolicyDO.getCcClaims()) {
						tdmClaimSearchResultDTO.setClaimNo(ccPolicyDO.getCcClaims().get(0)
								.getClaimnumber());
						tdmClaimSearchResultDTO.setClaimStats(String.valueOf(ccPolicyDO
								.getCcClaims().get(0).getState()));
						tdmClaimSearchResultDTO.setLob(String.valueOf(ccPolicyDO.getCcClaims()
								.get(0).getLobcode()));
						tdmClaimSearchResultDTO
								.setLossDate(converDateToString(converStringToDate(ccPolicyDO
										.getCcClaims().get(0).getLossdate())));
						if (StringUtils.isNotEmpty(String.valueOf(ccPolicyDO.getCcClaims().get(0)
								.getClaimsource()))
								&& !"null".equalsIgnoreCase(String.valueOf(ccPolicyDO.getCcClaims()
										.get(0).getClaimsource()))) {
							tdmClaimSearchResultDTO.setSourceSystem(String.valueOf(ccPolicyDO
									.getCcClaims().get(0).getClaimsource()));
						}
						// tdmClaimSearchResultDTO.setPrimInsuPerson(ccPolicyDO.getCcClaims().get(0).get);
						// tdmClaimSearchResultDTO.setAmtTotPaid(ccPolicyDO.getCcClaims().get(0).get);
						// tdmClaimSearchResultDTO.setAmtNetInc(ccPolicyDO.getCcClaims().get(0).get);
					}

					if (null != reservationDOs && 0 < reservationDOs.size()) {
						for (int j = 0; j < reservationDOs.size(); j++) {
							if (null != reservationDOs.get(j).getReserveDataType()
									&& reservationDOs.get(j).getReserveDataType()
											.equalsIgnoreCase(AppConstant.CLAIM)) {
								if (ccPolicyDOs.get(i).getId() == Long.parseLong(reservationDOs
										.get(j).getReserveDataId())) {
									tdmClaimSearchResultDTO.setReservedYN(AppConstant.YES);
									tdmClaimSearchResultDTO.setTestCaseId(reservationDOs.get(j)
											.getTestCaseId());
									tdmClaimSearchResultDTO.setTestCaseName(reservationDOs.get(j)
											.getTestCaseName());
									tdmClaimSearchResultDTO.setUserId(reservationDOs.get(j)
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
									tdmClaimSearchResultDTO
											.setRevExpairDate(myFormat.format(date1));
								}
							}
						}
					}
					tdmClaimSearchResultDTOs.add(tdmClaimSearchResultDTO);
				}
			}
			logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_CLAIM_DO_TO_DTO + MessageConstant.LOG_INFO_RETURN);
			return tdmClaimSearchResultDTOs;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_CLAIM_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_CLAIM_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}

	}

	@Override
	public List<TdmReservationDO> converTdmPolicySearchResultDTOToTdmReservationDO(
			List<TdmPolicySearchResultDTO> tdmPolicySearchResultDTOs, String userName)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
				+ MessageConstant.TDM_FTD_MP_POLICY_DTO_TO_DO + MessageConstant.LOG_INFO_PARAMS_NO);
		List<TdmReservationDO> reservationDOList = null;
		try {
			if (null != tdmPolicySearchResultDTOs && !tdmPolicySearchResultDTOs.isEmpty()) {
				TdmReservationDO reservationDO = null;
				TdmPolicySearchResultDTO tdmPolicySearchResultDTO = null;
				reservationDOList = new ArrayList<TdmReservationDO>();
				for (int i = 0; i < tdmPolicySearchResultDTOs.size(); i++) {
					tdmPolicySearchResultDTO = tdmPolicySearchResultDTOs.get(i);
					if (null != tdmPolicySearchResultDTO.getReservedYN()) {
						reservationDO = new TdmReservationDO();
						if (null != tdmPolicySearchResultDTO.getPolicyNo()) {
							reservationDO.setReserveDataId(tdmPolicySearchResultDTO.getPolicyNo());
						}
						reservationDO.setLocked(AppConstant.Y);
						reservationDO.setReserveData(null);
						reservationDO.setRowData(null);
						reservationDO.setUserId(userName);
						reservationDO.setUnreserve(AppConstant.N);
						reservationDO.setReserveDataType(AppConstant.POLICY);
						reservationDO.setUnlockTime(new Timestamp(new Date().getTime()));
						reservationDOList.add(reservationDO);
					}
				}
			}
			logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_POLICY_DTO_TO_DO + MessageConstant.LOG_INFO_RETURN);
			return reservationDOList;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_POLICY_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_POLICY_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> converTdmClaimSearchResultDTOToTdmReservationDO(
			List<TdmClaimSearchResultDTO> tdmClaimSearchResultDTOs, String userId)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
				+ MessageConstant.TDM_FTD_MP_CLAIM_DTO_TO_DO + MessageConstant.LOG_INFO_PARAMS_NO);
		List<TdmReservationDO> reservationDOList = null;
		try {
			if (null != tdmClaimSearchResultDTOs && !tdmClaimSearchResultDTOs.isEmpty()) {
				TdmReservationDO reservationDO = null;
				TdmClaimSearchResultDTO tdmClaimSearchResultDTO = null;
				reservationDOList = new ArrayList<TdmReservationDO>();
				for (int i = 0; i < tdmClaimSearchResultDTOs.size(); i++) {
					tdmClaimSearchResultDTO = tdmClaimSearchResultDTOs.get(i);
					if (null != tdmClaimSearchResultDTO.getReservedYN()) {
						reservationDO = new TdmReservationDO();
						if (null != tdmClaimSearchResultDTO.getClaimNo()) {
							reservationDO.setReserveDataId(tdmClaimSearchResultDTO.getClaimNo());
						}
						reservationDO.setLocked(AppConstant.Y);
						reservationDO.setReserveData(null);
						reservationDO.setRowData(null);
						reservationDO.setUserId(userId);
						reservationDO.setUnreserve(AppConstant.N);
						reservationDO.setReserveDataType(AppConstant.CLAIM);
						reservationDO.setUnlockTime(new Timestamp(new Date().getTime()));
						reservationDOList.add(reservationDO);
					}
				}
			}
			logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_CLAIM_DTO_TO_DO + MessageConstant.LOG_INFO_RETURN);
			return reservationDOList;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_CLAIM_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_POLICY_MAPPER
					+ MessageConstant.TDM_FTD_MP_CLAIM_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	public String converDateToString(Date date) throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
				+ MessageConstant.TDM_FTD_MP_DATE_TO_STRING + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			if (null != date) {
				SimpleDateFormat dataFormater = new SimpleDateFormat("MM/dd/yyyy");
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
				SimpleDateFormat dataFormater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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
