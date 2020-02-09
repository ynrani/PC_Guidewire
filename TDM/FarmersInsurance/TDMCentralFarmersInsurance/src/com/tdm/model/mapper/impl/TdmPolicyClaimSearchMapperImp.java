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
import com.tdm.model.DO.MetlifeClaimDO;
import com.tdm.model.DO.MetlifePolicyDO;
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
			List<MetlifePolicyDO> pcPolicyDOs, List<TdmReservationDO> reservationDOs, String userId)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
				+ MessageConstant.TDM_FTD_MP_POLICY_DO_TO_DTO + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			DateFormat myFormat = new SimpleDateFormat(AppConstant.MMDDYYYY);
			Calendar cal = Calendar.getInstance();
			Date date2 = cal.getTime();

			List<TdmPolicySearchResultDTO> tdmPolicySearchResultDTOs = null;
			if (null != pcPolicyDOs && !pcPolicyDOs.isEmpty()) {
				MetlifePolicyDO pcPolicyDO = null;
				TdmPolicySearchResultDTO tdmPolicySearchResultDTO = null;
				tdmPolicySearchResultDTOs = new ArrayList<TdmPolicySearchResultDTO>();
				for (int i = 0; i < pcPolicyDOs.size(); i++) {
					pcPolicyDO = pcPolicyDOs.get(i);
					tdmPolicySearchResultDTO = new TdmPolicySearchResultDTO();

					if (null != pcPolicyDO.getPolicyNumber()) {
						tdmPolicySearchResultDTO.setPolicyNo(pcPolicyDO.getPolicyNumber());
					}

					if (null != pcPolicyDO.getProductName()) {
						tdmPolicySearchResultDTO.setProductName(pcPolicyDO.getProductName());
					}
					if (null != pcPolicyDO.getProductType()) {
						tdmPolicySearchResultDTO.setProductType(pcPolicyDO.getProductType());
					}

					if (null != pcPolicyDO.getCompanyName()) {
						tdmPolicySearchResultDTO.setCompanyName(pcPolicyDO.getCompanyName());
					}

					if (null != pcPolicyDO.getFaceAmt()) {
						tdmPolicySearchResultDTO
								.setFaceAmt(String.valueOf(pcPolicyDO.getFaceAmt()));
					}

					if (null != pcPolicyDO.getFristName()) {
						tdmPolicySearchResultDTO.setFristName(pcPolicyDO.getFristName());
					}

					if (null != pcPolicyDO.getLastName()) {
						tdmPolicySearchResultDTO.setLastName(pcPolicyDO.getLastName());
					}

					if (null != pcPolicyDO.getSsn()) {
						tdmPolicySearchResultDTO.setSsn(String.valueOf(pcPolicyDO.getSsn()));
					}

					if (null != pcPolicyDO.getGender()) {
						tdmPolicySearchResultDTO.setGender(pcPolicyDO.getGender());
					}

					if (null != pcPolicyDO.getDob()) {
						tdmPolicySearchResultDTO.setDob(converDateToString(pcPolicyDO.getDob()));
					}

					if (null != pcPolicyDO.getDistChnal()) {
						tdmPolicySearchResultDTO.setDistChnal(pcPolicyDO.getDistChnal());
					}

					if (null != pcPolicyDO.getAgentId()) {
						tdmPolicySearchResultDTO
								.setAgentId(String.valueOf(pcPolicyDO.getAgentId()));
					}

					if (null != pcPolicyDO.getRiders()) {
						tdmPolicySearchResultDTO.setRiders(pcPolicyDO.getRiders());
					}

					if (null != pcPolicyDO.getBenefits()) {
						tdmPolicySearchResultDTO.setBenefits(pcPolicyDO.getBenefits());
					}

					if (null != pcPolicyDO.getOwner()) {
						tdmPolicySearchResultDTO.setOwner(pcPolicyDO.getOwner());
					}

					if (null != pcPolicyDO.getBeneficiary()) {
						tdmPolicySearchResultDTO.setBeneficiary(pcPolicyDO.getBeneficiary());
					}

					if (null != pcPolicyDO.getPaymentMethod()) {
						tdmPolicySearchResultDTO.setPaymentMethod(pcPolicyDO.getPaymentMethod());
					}

					if (null != pcPolicyDO.getPaymentMode()) {
						tdmPolicySearchResultDTO.setPaymentMode(pcPolicyDO.getPaymentMode());
					}

					if (null != reservationDOs && 0 < reservationDOs.size()) {
						for (int j = 0; j < reservationDOs.size(); j++) {
							if (null != reservationDOs.get(j).getReserveDataType()
									&& reservationDOs.get(j).getReserveDataType()
											.equalsIgnoreCase(AppConstant.POLICY)) {
								if (pcPolicyDO.getPolicyNumber().equalsIgnoreCase(
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
			List<MetlifeClaimDO> ccPolicyDOs, List<TdmReservationDO> reservationDOs, String userId)
			throws ServiceException {
		logger.info(MessageConstant.TDM_FTD_POLICY_MAPPER
				+ MessageConstant.TDM_FTD_MP_CLAIM_DO_TO_DTO + MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			DateFormat myFormat = new SimpleDateFormat(AppConstant.MMDDYYYY);
			Calendar cal = Calendar.getInstance();
			Date date2 = cal.getTime();

			List<TdmClaimSearchResultDTO> tdmClaimSearchResultDTOs = null;
			if (null != ccPolicyDOs && !ccPolicyDOs.isEmpty()) {
				MetlifeClaimDO ccPolicyDO = null;
				TdmClaimSearchResultDTO tdmClaimSearchResultDTO = null;
				tdmClaimSearchResultDTOs = new ArrayList<TdmClaimSearchResultDTO>();
				for (int i = 0; i < ccPolicyDOs.size(); i++) {
					ccPolicyDO = ccPolicyDOs.get(i);
					tdmClaimSearchResultDTO = new TdmClaimSearchResultDTO();

					if (null != ccPolicyDO.getClaimNumber()) {
						tdmClaimSearchResultDTO.setClaimNo(ccPolicyDO.getClaimNumber());
					}

					if (null != ccPolicyDO.getPolicyNumber()) {
						tdmClaimSearchResultDTO.setPolicyNo(ccPolicyDO.getPolicyNumber());
					}
					if (null != ccPolicyDO.getCompanyName()) {
						tdmClaimSearchResultDTO.setCompanyName(ccPolicyDO.getCompanyName());
					}

					if (null != ccPolicyDO.getProductName()) {
						tdmClaimSearchResultDTO.setProductName(ccPolicyDO.getProductName());
					}
					if (null != ccPolicyDO.getProductType()) {
						tdmClaimSearchResultDTO.setProductType(ccPolicyDO.getProductType());
					}

					if (null != ccPolicyDO.getPolicySts()) {
						tdmClaimSearchResultDTO.setPolicySts(ccPolicyDO.getPolicySts());
					}

					if (null != ccPolicyDO.getFaceAmt()) {
						tdmClaimSearchResultDTO.setFaceAmt(String.valueOf(ccPolicyDO.getFaceAmt()));
					}

					if (null != ccPolicyDO.getFristName()) {
						tdmClaimSearchResultDTO.setFristName(ccPolicyDO.getFristName());
					}

					if (null != ccPolicyDO.getLastName()) {
						tdmClaimSearchResultDTO.setLastName(ccPolicyDO.getLastName());
					}

					if (null != ccPolicyDO.getSsn()) {
						tdmClaimSearchResultDTO.setSsn(String.valueOf(ccPolicyDO.getSsn()));
					}

					if (null != ccPolicyDO.getDob()) {
						tdmClaimSearchResultDTO.setDob(converDateToString(ccPolicyDO.getDob()));
					}

					if (null != ccPolicyDO.getAgentId()) {
						tdmClaimSearchResultDTO.setAgentId(String.valueOf(ccPolicyDO.getAgentId()));
					}

					if (null != ccPolicyDO.getRiders()) {
						tdmClaimSearchResultDTO.setRiders(ccPolicyDO.getRiders());
					}

					if (null != ccPolicyDO.getBenefits()) {
						tdmClaimSearchResultDTO.setBenefits(ccPolicyDO.getBenefits());
					}

					if (null != ccPolicyDO.getOwner()) {
						tdmClaimSearchResultDTO.setOwner(ccPolicyDO.getOwner());
					}

					if (null != ccPolicyDO.getBeneficiary()) {
						tdmClaimSearchResultDTO.setBeneficiary(ccPolicyDO.getBeneficiary());
					}

					if (null != ccPolicyDO.getPaymentMethod()) {
						tdmClaimSearchResultDTO.setPaymentMethod(ccPolicyDO.getPaymentMethod());
					}

					if (null != ccPolicyDO.getPaymentMode()) {
						tdmClaimSearchResultDTO.setPaymentMode(ccPolicyDO.getPaymentMode());
					}

					if (null != ccPolicyDO.getCashAccum()) {
						tdmClaimSearchResultDTO.setCashAccum(ccPolicyDO.getCashAccum());
					}

					if (null != ccPolicyDO.getLoanAmt()) {
						tdmClaimSearchResultDTO.setLoanAmt(String.valueOf(ccPolicyDO.getLoanAmt()));
					}

					if (null != ccPolicyDO.getLoanRepayAmt()) {
						tdmClaimSearchResultDTO.setLoanRepayAmt(String.valueOf(ccPolicyDO
								.getLoanRepayAmt()));
					}

					if (null != reservationDOs && 0 < reservationDOs.size()) {
						for (int j = 0; j < reservationDOs.size(); j++) {
							if (null != reservationDOs.get(j).getReserveDataType()
									&& reservationDOs.get(j).getReserveDataType()
											.equalsIgnoreCase(AppConstant.CLAIM)) {

								if (ccPolicyDO.getClaimNumber().equalsIgnoreCase(
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
