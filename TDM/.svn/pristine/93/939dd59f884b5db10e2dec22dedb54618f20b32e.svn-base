package com.tesda.model.mapper.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tesda.model.DO.CassPolListDO;
import com.tesda.model.DO.PolicysummaryDO;
import com.tesda.model.DO.TdmPolicySearchDO;
// import com.tesda.model.DO.PropPolicyDO;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DTO.TdmAutoSearchResultDTO;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyAutoSearchResultDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchResultDTO;
import com.tesda.model.mapper.TdmPolicyAutoSearchMapper;

@Component
@Service("tdmPolicyAutoSearchMapper")
public class TdmPolicyAutoSearchMapperImpl implements TdmPolicyAutoSearchMapper
{
	final static Logger logger = Logger.getLogger(TdmPolicyAutoSearchMapperImpl.class);
	public static final String tabDriver = "DRIVER";
	public static final String tabVehi = "RISKITEM";
	public static final String tabViolats = "ACCIDENTVIOLATION";
	public static final String tabNo_Of_Named_Insured = "INSUREDPRINCIPAL";

	@Override
	public List<TdmPolicyAutoSearchResultDTO> converPolicysummaryToFTdmPolicyAutoSearchResultDTO(
			TdmAutoSearchResultDTO tdmAutoSearchResultDTO, List<TdmReservationDO> reservationDOs,
			String userName, TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, List<Object[]> covList,
			List<Object[]> riskCovList, List<CassPolListDO> cassPolListDOs) {
		logger.info("This is in method TdmPolicyAutoSearchMapperImpl.converPolicysummaryToFTdmPolicyAutoSearchResultDTO() : ");
		List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOs = null;
		TdmPolicyAutoSearchResultDTO tdmPolicyAutoSearchResultDTO = null;
		Object[] objStr = null;
		CassPolListDO cassPolListDO = null;
		Set<String> setPolicySummery = new HashSet<String>();
		if (null != tdmAutoSearchResultDTO.getListPolicySummeryDo()
				&& 0 < tdmAutoSearchResultDTO.getListPolicySummeryDo().size()) {
			tdmPolicyAutoSearchResultDTOs = new ArrayList<TdmPolicyAutoSearchResultDTO>();
			PolicysummaryDO policySummaryDO = null;
			Map<String, Map<String, String>> mapDerivedFields = tdmAutoSearchResultDTO
					.getMapDerivedFields();
			for (int i = 0; i < tdmAutoSearchResultDTO.getListPolicySummeryDo().size(); i++) {
				policySummaryDO = tdmAutoSearchResultDTO.getListPolicySummeryDo().get(i);
				if (!setPolicySummery.contains(policySummaryDO.getPolicynumber())) {
					tdmPolicyAutoSearchResultDTO = new TdmPolicyAutoSearchResultDTO();
					if (StringUtils.isNotEmpty(policySummaryDO.getPolicynumber())) {
						tdmPolicyAutoSearchResultDTO.setPolicynumber(policySummaryDO
								.getPolicynumber());
						setPolicySummery.add(policySummaryDO.getPolicynumber());
						if (mapDerivedFields != null
								&& mapDerivedFields.containsKey(policySummaryDO.getPolicynumber())) {
							tdmPolicyAutoSearchResultDTO
									.setNoOfDrivers(StringUtils.isNotEmpty(mapDerivedFields.get(
											policySummaryDO.getPolicynumber()).get(tabDriver)) ? mapDerivedFields
											.get(policySummaryDO.getPolicynumber()).get(tabDriver)
											: "0");
							tdmPolicyAutoSearchResultDTO
									.setNoOfVehi(StringUtils.isNotEmpty(mapDerivedFields.get(
											policySummaryDO.getPolicynumber()).get(tabVehi)) ? mapDerivedFields
											.get(policySummaryDO.getPolicynumber()).get(tabVehi)
											: "0");
							tdmPolicyAutoSearchResultDTO
									.setNoOfViola(StringUtils.isNotEmpty(mapDerivedFields.get(
											policySummaryDO.getPolicynumber()).get(tabViolats)) ? mapDerivedFields
											.get(policySummaryDO.getPolicynumber()).get(tabViolats)
											: "0");
							tdmPolicyAutoSearchResultDTO.setNoOfNamedInsu(StringUtils
									.isNotEmpty(mapDerivedFields.get(
											policySummaryDO.getPolicynumber()).get(
											tabNo_Of_Named_Insured)) ? mapDerivedFields.get(
									policySummaryDO.getPolicynumber()).get(tabNo_Of_Named_Insured)
									: "0");
						}
					}
					if (StringUtils.isNotEmpty(policySummaryDO.getProductcd())) {
						tdmPolicyAutoSearchResultDTO.setProductType(policySummaryDO.getProductcd());
					}
					tdmPolicyAutoSearchResultDTO.setAssoPayReq(tdmPolicyAutoSearchDTO
							.getAssoPayReq());
					// Doc Yes or No
					if (null != cassPolListDOs) {
						for (int j = 0; j < cassPolListDOs.size(); j++) {
							cassPolListDO = cassPolListDOs.get(j);
							if (cassPolListDO.getPolicyNumber().equalsIgnoreCase(
									policySummaryDO.getPolicynumber())) {
								if (StringUtils.isNotEmpty(cassPolListDO.getFlag())) {
									if ("N".equalsIgnoreCase(cassPolListDO.getFlag())) {
										policySummaryDO.setSupportingdata("No");
									} else {
										policySummaryDO.setSupportingdata("Yes");
									}
								} else {
									policySummaryDO.setSupportingdata("No");
								}
							}
						}
					}
					// document yes or NO
					tdmPolicyAutoSearchResultDTO.setAssoDocReq(policySummaryDO.getSupportingdata());
					if (StringUtils.isNotEmpty(policySummaryDO.getPolicystatuscd())) {
						if (policySummaryDO.getPolicystatuscd().equalsIgnoreCase("issued")
								&& policySummaryDO.getTimedpolicystatuscd().equalsIgnoreCase(
										"inForce")) {
							tdmPolicyAutoSearchResultDTO.setPolicyStage("Active");
						} else if (policySummaryDO.getPolicystatuscd()
								.equalsIgnoreCase("cancelled")) {
							tdmPolicyAutoSearchResultDTO.setPolicyStage("Cancelled");
						} else {
							tdmPolicyAutoSearchResultDTO.setPolicyStage("Pending");
						}
					}
					if (StringUtils.isNotEmpty(policySummaryDO.getRiskstatecd())) {
						tdmPolicyAutoSearchResultDTO.setPolicyState(policySummaryDO
								.getRiskstatecd());
					}
					if (StringUtils.isNotEmpty(policySummaryDO.getContracttermtypecd())) {
						if (policySummaryDO.getContracttermtypecd().equalsIgnoreCase("AN")) {
							tdmPolicyAutoSearchResultDTO.setPolicyTerm("ANNUAL");
						} else if (policySummaryDO.getContracttermtypecd().equalsIgnoreCase("SA")) {
							tdmPolicyAutoSearchResultDTO.setPolicyTerm("SEMI-ANNUAL");
						} else {
							tdmPolicyAutoSearchResultDTO.setPolicyTerm(policySummaryDO
									.getContracttermtypecd());
						}
					}
					// policy Covarege
					// covList
					if (null != covList && 0 < covList.size()) {
						for (int k = 0; k < covList.size(); k++) {
							objStr = covList.get(k);
							if (policySummaryDO.getPolicynumber().equalsIgnoreCase(
									(String) objStr[0])) {
								tdmPolicyAutoSearchResultDTO.setPolicyCovge((String) objStr[1]);
								break;
							}
						}
					} else {
						tdmPolicyAutoSearchResultDTO.setPolicyCovge(tdmPolicyAutoSearchDTO
								.getPolicyCovge());
					}
					// riskCoverage
					if (null != riskCovList && 0 < riskCovList.size()) {
						for (int k = 0; k < riskCovList.size(); k++) {
							objStr = riskCovList.get(k);
							if (policySummaryDO.getPolicynumber().equalsIgnoreCase(
									(String) objStr[0])) {
								tdmPolicyAutoSearchResultDTO.setRiskCovge((String) objStr[1]);
								break;
							}
						}
					} else {
						tdmPolicyAutoSearchResultDTO.setRiskCovge(tdmPolicyAutoSearchDTO
								.getRiskCovge());
					}
					tdmPolicyAutoSearchResultDTO.setAssoPayReq(tdmPolicyAutoSearchResultDTO
							.getPayMethod());
					tdmPolicyAutoSearchResultDTO
							.setAssoDocType(policySummaryDO.getSupportingdata());
					tdmPolicyAutoSearchResultDTO.setRenewalcount(null);
					try {
						if (StringUtils.isNotEmpty(converDateToString(policySummaryDO
								.getEffective()))) {
							tdmPolicyAutoSearchResultDTO
									.setPolicyEffectDt(converDateToString(policySummaryDO
											.getEffective()));
						}
						if (StringUtils.isNotEmpty(converDateToString(policySummaryDO
								.getExpiration()))) {
							tdmPolicyAutoSearchResultDTO
									.setPolicyExpDt(converDateToString(policySummaryDO
											.getExpiration()));
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if (StringUtils.isNotEmpty(tdmPolicyAutoSearchResultDTO.getUserId())) {
						if (tdmPolicyAutoSearchResultDTO.getUserId().equalsIgnoreCase(userName)) {
							tdmPolicyAutoSearchResultDTOs.add(tdmPolicyAutoSearchResultDTO);
						}
					} else {
						tdmPolicyAutoSearchResultDTOs.add(tdmPolicyAutoSearchResultDTO);
					}

					tdmPolicyAutoSearchResultDTO.setAssoDocReq("No");

					tdmPolicyAutoSearchResultDTO.setPolicyDetailId(policySummaryDO
							.getPolicydetailId());
				}
			}
		}
		return tdmPolicyAutoSearchResultDTOs;
	}

	@Override
	public List<TdmReservationDO> converTdmPolicyAutoSearchResultDTOToTdmReservationDO(
			List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOList,
			String searchcriti, String userId, String enviro) {
		logger.info("This is in method TdmPolicyAutoSearchMapperImpl.converTdmPolicyAutoSearchResultDTOToTdmReservationDO() : ");
		List<TdmReservationDO> reservationDOList = null;
		if (null != tdmPolicyAutoSearchResultDTOList && 0 < tdmPolicyAutoSearchResultDTOList.size()) {
			TdmReservationDO reservationDO = null;
			TdmPolicyAutoSearchResultDTO tdmPolicyAutoSearchResultDTO = null;
			reservationDOList = new ArrayList<TdmReservationDO>();
			for (int i = 0; i < tdmPolicyAutoSearchResultDTOList.size(); i++) {
				tdmPolicyAutoSearchResultDTO = tdmPolicyAutoSearchResultDTOList.get(i);
				if (null != tdmPolicyAutoSearchResultDTO.getReservedYN()) {
					reservationDO = new TdmReservationDO();
					if (null != tdmPolicyAutoSearchResultDTO.getPolicynumber()) {
						reservationDO.setPolicyNumber(String.valueOf(tdmPolicyAutoSearchResultDTO
								.getPolicynumber()));
					}
					reservationDO.setLocked("Y");
					reservationDO.setUserId(userId);
					reservationDO.setUnreserve("N");
					reservationDO.setPolicyDetailId(tdmPolicyAutoSearchResultDTO
							.getPolicyDetailId());
					reservationDO.setPolicyStatus(String.valueOf(tdmPolicyAutoSearchResultDTO
							.getPolicyStage()));
					reservationDO.setRiskState(String.valueOf(tdmPolicyAutoSearchResultDTO
							.getPolicyState()));
					reservationDO.setPolicyTerm(String.valueOf(tdmPolicyAutoSearchResultDTO
							.getPolicyTerm()));
					try {
						reservationDO
								.setEffectivedate(converStringToDate(tdmPolicyAutoSearchResultDTO
										.getPolicyEffectDt()));
						reservationDO
								.setExpirationdate(converStringToDate(tdmPolicyAutoSearchResultDTO
										.getPolicyExpDt()));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if (StringUtils.isNotEmpty(tdmPolicyAutoSearchResultDTO.getPolicyCovge())) {
						reservationDO.setPolicyCoverage(String.valueOf(tdmPolicyAutoSearchResultDTO
								.getPolicyCovge()));
					}
					if (StringUtils.isNotEmpty(tdmPolicyAutoSearchResultDTO.getNoOfDrivers())) {
						reservationDO.setNoOfDrivers(Long.parseLong(tdmPolicyAutoSearchResultDTO
								.getNoOfDrivers()));
					}
					if (StringUtils.isNotEmpty(tdmPolicyAutoSearchResultDTO.getNoOfVehi())) {
						reservationDO.setNoOfVehicles(Long.parseLong(tdmPolicyAutoSearchResultDTO
								.getNoOfVehi()));
					}
					if (StringUtils.isNotEmpty(tdmPolicyAutoSearchResultDTO.getNoOfViola())) {
						reservationDO.setNoOfViolations(Long.parseLong(tdmPolicyAutoSearchResultDTO
								.getNoOfViola()));
					}
					if (StringUtils.isNotEmpty(tdmPolicyAutoSearchResultDTO.getAssoPayReq())) {
						reservationDO.setAvailablePay(String.valueOf(tdmPolicyAutoSearchResultDTO
								.getAssoPayReq()));
					}
					if (StringUtils.isNotEmpty(tdmPolicyAutoSearchResultDTO.getAssoDocReq())) {
						reservationDO.setAvaliableDocs(String.valueOf(tdmPolicyAutoSearchResultDTO
								.getAssoDocReq()));
					}
					reservationDO.setReserveDataType("CSAA_AU");
					reservationDO.setUnlockTime(new Timestamp(new Date().getTime()));
					reservationDO.setSearchScenario(searchcriti.substring(18));
					reservationDO.setProjectId(null);
					reservationDO.setUSER_ENV(enviro);
					/*
					 * reservationDO.setReserveData(null); reservationDO.setRowData(null);
					 * reservationDO.setReserveData(searchcriti);
					 */
					reservationDOList.add(reservationDO);
				}
			}
		}
		return reservationDOList;
	}

	@Override
	public List<TdmPolicyPropertySearchResultDTO> converPolicysummaryToTdmPolicyPropertySearchDTO(
			List<PolicysummaryDO> hoPolicyDOList, List<TdmReservationDO> reservationDOs,
			String userName, TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			List<Object[]> riskCovList, List<CassPolListDO> cassPolListDOs) {
		logger.info("This is in method TdmPolicyAutoSearchMapperImpl.converPolicysummaryToTdmPolicyPropertySearchDTO() : ");
		List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchResultDTOs = null;
		TdmPolicyPropertySearchResultDTO tdmPolicyPropertySearchResultDTO = null;
		Set<String> setPolicySummeries = new HashSet<String>();
		Object[] objStr = null;
		CassPolListDO cassPolListDO = null;
		if (null != hoPolicyDOList && 0 < hoPolicyDOList.size()) {
			tdmPolicyPropertySearchResultDTOs = new ArrayList<TdmPolicyPropertySearchResultDTO>();
			PolicysummaryDO policysummaryDO = null;
			for (int i = 0; i < hoPolicyDOList.size(); i++) {
				policysummaryDO = hoPolicyDOList.get(i);
				if (!setPolicySummeries.contains(policysummaryDO.getPolicynumber())) {
					tdmPolicyPropertySearchResultDTO = new TdmPolicyPropertySearchResultDTO();
					tdmPolicyPropertySearchResultDTO.setPolicynumber(policysummaryDO
							.getPolicynumber());
					setPolicySummeries.add(policysummaryDO.getPolicynumber());
					if (StringUtils.isNotEmpty(policysummaryDO.getProductcd())) {
						tdmPolicyPropertySearchResultDTO.setProductType(policysummaryDO
								.getPolicyformcd());
					}

					tdmPolicyPropertySearchResultDTO.setAssoDocType("No");

					tdmPolicyPropertySearchResultDTO.setAssoPayReq(tdmPolicyPropertySearchDTO
							.getAddPayReq());
					// Doc Yes or No
					if (null != cassPolListDOs) {
						for (int j = 0; j < cassPolListDOs.size(); j++) {
							cassPolListDO = cassPolListDOs.get(j);
							if (cassPolListDO.getPolicyNumber().equalsIgnoreCase(
									policysummaryDO.getPolicynumber())) {
								if (StringUtils.isNotEmpty(cassPolListDO.getFlag())) {
									if ("N".equalsIgnoreCase(cassPolListDO.getFlag())) {
										policysummaryDO.setSupportingdata("No");
									} else {
										policysummaryDO.setSupportingdata("Yes");
									}
								} else {
									policysummaryDO.setSupportingdata("No");
								}
							}
						}
					}

					if (StringUtils.isNotEmpty(policysummaryDO.getPolicystatuscd())) {
						// tdmPolicyPropertySearchResultDTO
						// .setPolicyStage(policysummaryDO.getPolicystatuscd());
						if (policysummaryDO.getPolicystatuscd().equalsIgnoreCase("issued")
								&& policysummaryDO.getTimedpolicystatuscd().equalsIgnoreCase(
										"inForce")) {
							tdmPolicyPropertySearchResultDTO.setPolicyStage("Active");
						} else if (policysummaryDO.getPolicystatuscd()
								.equalsIgnoreCase("cancelled")) {
							tdmPolicyPropertySearchResultDTO.setPolicyStage("Cancelled");
						} else {
							tdmPolicyPropertySearchResultDTO.setPolicyStage("Pending");
						}
					}
					if (StringUtils.isNotEmpty(policysummaryDO.getContracttermtypecd())) {
						if (policysummaryDO.getContracttermtypecd().equalsIgnoreCase("AN")) {
							tdmPolicyPropertySearchResultDTO.setPolicyTerm("ANNUAL");
						} else if (policysummaryDO.getContracttermtypecd().equalsIgnoreCase("SA")) {
							tdmPolicyPropertySearchResultDTO.setPolicyTerm("SEMI-ANNUAL");
						} else {
							tdmPolicyPropertySearchResultDTO.setPolicyTerm(policysummaryDO
									.getContracttermtypecd());
						}
					}
					if (StringUtils.isNotEmpty(policysummaryDO.getPolicyformcd())) {
						tdmPolicyPropertySearchResultDTO.setChildProductType(policysummaryDO
								.getPolicyformcd());
					}
					// riskCoverage
					if (null != riskCovList && 0 < riskCovList.size()) {
						for (int k = 0; k < riskCovList.size(); k++) {
							objStr = riskCovList.get(k);
							if (policysummaryDO.getPolicynumber().equalsIgnoreCase(
									(String) objStr[0])) {
								tdmPolicyPropertySearchResultDTO.setRiskCovge((String) objStr[1]);
								break;
							}
						}
					} else {
						tdmPolicyPropertySearchResultDTO.setRiskCovge(tdmPolicyPropertySearchDTO
								.getAddRiskCovge());
					}
					if (StringUtils.isNotEmpty(policysummaryDO.getRiskstatecd())) {
						tdmPolicyPropertySearchResultDTO.setPolicyState(policysummaryDO
								.getRiskstatecd());
					}
					try {
						tdmPolicyPropertySearchResultDTO
								.setPolicyEffectDt(converDateToString(policysummaryDO
										.getEffective()));
						tdmPolicyPropertySearchResultDTO
								.setPolicyExpDt(converDateToString(policysummaryDO.getExpiration()));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if (StringUtils.isNotEmpty(tdmPolicyPropertySearchResultDTO.getUserId())) {
						if (tdmPolicyPropertySearchResultDTO.getUserId().equalsIgnoreCase(userName)) {
							tdmPolicyPropertySearchResultDTOs.add(tdmPolicyPropertySearchResultDTO);
						}
					} else {
						tdmPolicyPropertySearchResultDTOs.add(tdmPolicyPropertySearchResultDTO);
					}
					tdmPolicyPropertySearchResultDTO.setPolicyDetailId(policysummaryDO
							.getPolicydetailId());
				}
			}
		}
		return tdmPolicyPropertySearchResultDTOs;
	}

	@Override
	public List<TdmReservationDO> converTdmPolicyPropertySearchDTOToTdmReservationDO(
			List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchResultDTOList,
			String searchcriti, String userId, String enviro) {
		logger.info("This is in method TdmPolicyAutoSearchMapperImpl.converTdmPolicyPropertySearchDTOToTdmReservationDO() : ");
		List<TdmReservationDO> reservationDOList = null;
		if (null != tdmPolicyPropertySearchResultDTOList
				&& 0 < tdmPolicyPropertySearchResultDTOList.size()) {
			TdmReservationDO reservationDO = null;
			TdmPolicyPropertySearchResultDTO tdmPolicyPropertySearchResultDTO = null;
			reservationDOList = new ArrayList<TdmReservationDO>();
			for (int i = 0; i < tdmPolicyPropertySearchResultDTOList.size(); i++) {
				tdmPolicyPropertySearchResultDTO = tdmPolicyPropertySearchResultDTOList.get(i);
				if (null != tdmPolicyPropertySearchResultDTO.getReservedYN()) {
					reservationDO = new TdmReservationDO();
					if (null != tdmPolicyPropertySearchResultDTO.getPolicynumber()) {
						reservationDO.setPolicyNumber(String
								.valueOf(tdmPolicyPropertySearchResultDTO.getPolicynumber()));
					}
					reservationDO.setLocked("Y");
					reservationDO.setUserId(userId);
					reservationDO.setUnreserve("N");
					reservationDO.setPolicyDetailId(tdmPolicyPropertySearchResultDTO
							.getPolicyDetailId());
					reservationDO.setProductType(String.valueOf(tdmPolicyPropertySearchResultDTO
							.getProductType()));
					reservationDO.setPolicyStatus(String.valueOf(tdmPolicyPropertySearchResultDTO
							.getPolicyStage()));
					reservationDO.setRiskState(String.valueOf(tdmPolicyPropertySearchResultDTO
							.getPolicyState()));
					reservationDO.setPolicyTerm(String.valueOf(tdmPolicyPropertySearchResultDTO
							.getPolicyTerm()));
					try {
						reservationDO
								.setEffectivedate(converStringToDate(tdmPolicyPropertySearchResultDTO
										.getPolicyEffectDt()));
						reservationDO
								.setExpirationdate(converStringToDate(tdmPolicyPropertySearchResultDTO
										.getPolicyExpDt()));
					} catch (ParseException e) {
						logger.error(
								"Issue while conver Policy Property SearchDTO To TdmReservationDO!",
								e);
						e.printStackTrace();
					}
					reservationDO.setConstructionType(String
							.valueOf(tdmPolicyPropertySearchResultDTO.getConstructionType()));
					reservationDO.setValuationMethod(String
							.valueOf(tdmPolicyPropertySearchResultDTO.getValuationMethod()));
					reservationDO.setYearBuilt(String.valueOf(tdmPolicyPropertySearchResultDTO
							.getYearBuilt()));
					reservationDO.setRoofYear(String.valueOf(tdmPolicyPropertySearchResultDTO
							.getRoofYear()));
					reservationDO.setAvailablePay(String.valueOf(tdmPolicyPropertySearchResultDTO
							.getAssoPayReq()));
					// reservationDO.setAvaliableDocs(String.valueOf(tdmPolicyPropertySearchResultDTO
					// .getAssoDocReq()));
					reservationDO.setAvaliableDocs(String.valueOf(tdmPolicyPropertySearchResultDTO
							.getAssoDocType()));
					reservationDO.setSearchScenario(searchcriti.substring(18));
					reservationDO.setProjectId(null);
					reservationDO.setUSER_ENV(enviro);
					/*
					 * reservationDO.setReserveData(null); reservationDO.setRowData(null);
					 * reservationDO.setReserveData(searchcriti);
					 */
					reservationDO.setReserveDataType("CSAA_PO");
					reservationDO.setUnlockTime(new Timestamp(new Date().getTime()));
					reservationDOList.add(reservationDO);
				}
			}
		}
		return reservationDOList;
	}

	public String converDateToString(Date date) throws ParseException {
		if (null != date) {
			SimpleDateFormat dataFormater = new SimpleDateFormat("dd/MM/yyyy");
			String stringobj = dataFormater.format(date);
			return stringobj;
		}
		return null;
	}

	public Date converStringToDate(String strdate) throws ParseException {
		Date returndate = null;
		if (null != strdate) {
			SimpleDateFormat dataFormater = new SimpleDateFormat("dd/MM/yyyy");
			returndate = dataFormater.parse(strdate);
			dataFormater.format(returndate);
			return returndate;
		}
		return returndate;
	}

	@Override
	public List<TdmPolicyAutoSearchResultDTO> converTdmReservationDOToFTdmPolicyAutoSearchResultDTO(
			List<TdmReservationDO> tdmReservationDOlist, String userName,
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO) {
		logger.info("This is in method TdmPolicyAutoSearchMapperImpl.converTdmReservationDOToFTdmPolicyAutoSearchResultDTO() : ");
		DateFormat myFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		Date date2 = cal.getTime();
		List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOs = null;
		TdmPolicyAutoSearchResultDTO tdmPolicyAutoSearchResultDTO = null;
		if (null != tdmReservationDOlist && 0 < tdmReservationDOlist.size()) {
			tdmPolicyAutoSearchResultDTOs = new ArrayList<TdmPolicyAutoSearchResultDTO>();
			TdmReservationDO tdmReservationDO = null;
			for (int i = 0; i < tdmReservationDOlist.size(); i++) {
				tdmReservationDO = tdmReservationDOlist.get(i);
				tdmPolicyAutoSearchResultDTO = new TdmPolicyAutoSearchResultDTO();
				tdmPolicyAutoSearchResultDTO
						.setPolicyDetailId(tdmReservationDO.getPolicyDetailId());
				tdmPolicyAutoSearchResultDTO.setPolicynumber(tdmReservationDO.getPolicyNumber());
				if (StringUtils.isNotEmpty(tdmReservationDO.getPolicyStatus())) {
					tdmPolicyAutoSearchResultDTO.setPolicyStage(tdmReservationDO.getPolicyStatus());
				}
				if (StringUtils.isNotEmpty(tdmReservationDO.getRiskState())) {
					tdmPolicyAutoSearchResultDTO.setPolicyState(tdmReservationDO.getRiskState());
				}
				if (StringUtils.isNotEmpty(tdmReservationDO.getPolicyTerm())) {
					if (tdmReservationDO.getPolicyTerm().equalsIgnoreCase("AN")) {
						tdmPolicyAutoSearchResultDTO.setPolicyTerm("ANNUAL");
					} else if (tdmReservationDO.getPolicyTerm().equalsIgnoreCase("SA")) {
						tdmPolicyAutoSearchResultDTO.setPolicyTerm("SEMI-ANNUAL");
					} else {
						tdmPolicyAutoSearchResultDTO.setPolicyTerm(String.valueOf(tdmReservationDO
								.getPolicyTerm()));
					}
				}
				// tdmPolicyAutoSearchResultDTO.setRenewalcount(null);
				if (null != String.valueOf(tdmReservationDO.getNoOfDrivers())) {
					tdmPolicyAutoSearchResultDTO.setNoOfDrivers(String.valueOf(tdmReservationDO
							.getNoOfDrivers()));
				}
				if (null != String.valueOf(tdmReservationDO.getNoOfVehicles())) {
					tdmPolicyAutoSearchResultDTO.setNoOfVehi(String.valueOf(tdmReservationDO
							.getNoOfVehicles()));
				}
				if (null != String.valueOf(tdmReservationDO.getNoOfViolations())) {
					tdmPolicyAutoSearchResultDTO.setNoOfViola(String.valueOf(tdmReservationDO
							.getNoOfViolations()));
				}
				if (StringUtils.isNotEmpty(tdmReservationDO.getPolicyCoverage())) {
					tdmPolicyAutoSearchResultDTO.setPolicyCovge(tdmReservationDO
							.getPolicyCoverage());
				}
				if (StringUtils.isNotEmpty(tdmReservationDO.getAvailablePay())) {
					tdmPolicyAutoSearchResultDTO.setAssoPayReq(tdmReservationDO.getAvailablePay());
				}
				if (StringUtils.isNotEmpty(tdmReservationDO.getAvailableDocs())) {
					tdmPolicyAutoSearchResultDTO.setAssoDocReq(tdmReservationDO.getAvailableDocs());
				}
				try {
					tdmPolicyAutoSearchResultDTO
							.setPolicyEffectDt(converDateToString(tdmReservationDO
									.getEffectivedate()));
					tdmPolicyAutoSearchResultDTO.setPolicyExpDt(converDateToString(tdmReservationDO
							.getExpirationdate()));
				} catch (ParseException e) {
					logger.error(
							"Issue convert TdmReservationDO To FTdmPolicyAutoSearchResultDTO!", e);
					e.printStackTrace();
				}
				tdmPolicyAutoSearchResultDTO.setReservedYN("Yes");
				tdmPolicyAutoSearchResultDTO.setTestCaseId(tdmReservationDO.getTestCaseId());
				tdmPolicyAutoSearchResultDTO.setTestCaseName(tdmReservationDO.getTestCaseName());
				tdmPolicyAutoSearchResultDTO.setUserId(tdmReservationDO.getUserId());
				tdmPolicyAutoSearchResultDTO.setScenario(tdmReservationDO.getSearchScenario());
				Date date1 = tdmReservationDO.getUnlockTime();
				long diff = date2.getTime() - date1.getTime();
				switch ((int) (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS))) {
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
				tdmPolicyAutoSearchResultDTO.setExpairDate(myFormat.format(date1));
				if (StringUtils.isNotEmpty(tdmPolicyAutoSearchResultDTO.getUserId())) {
					if (tdmPolicyAutoSearchResultDTO.getUserId().equalsIgnoreCase(userName)) {
						tdmPolicyAutoSearchResultDTOs.add(tdmPolicyAutoSearchResultDTO);
					}
				} else {
					tdmPolicyAutoSearchResultDTOs.add(tdmPolicyAutoSearchResultDTO);
				}
			}
		}
		return tdmPolicyAutoSearchResultDTOs;
	}

	@Override
	public List<TdmPolicyPropertySearchResultDTO> converTdmReservationDOToTdmPolicyPropertySearchDTO(
			List<TdmReservationDO> tdmReservationDOlist, String userName) {
		logger.info("This is in method TdmPolicyAutoSearchMapperImpl.converTdmReservationDOToTdmPolicyPropertySearchDTO() : ");
		DateFormat myFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		Date date2 = cal.getTime();
		List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchResultDTOs = null;
		TdmPolicyPropertySearchResultDTO tdmPolicyPropertySearchResultDTO = null;
		if (null != tdmReservationDOlist && 0 < tdmReservationDOlist.size()) {
			tdmPolicyPropertySearchResultDTOs = new ArrayList<TdmPolicyPropertySearchResultDTO>();
			TdmReservationDO tdmReservationDO = null;
			for (int i = 0; i < tdmReservationDOlist.size(); i++) {
				tdmReservationDO = tdmReservationDOlist.get(i);
				tdmPolicyPropertySearchResultDTO = new TdmPolicyPropertySearchResultDTO();
				tdmPolicyPropertySearchResultDTO.setPolicyDetailId(tdmReservationDO
						.getPolicyDetailId());
				tdmPolicyPropertySearchResultDTO
						.setPolicynumber(tdmReservationDO.getPolicyNumber());
				if (StringUtils.isNotEmpty(tdmReservationDO.getProductType())) {
					tdmPolicyPropertySearchResultDTO.setProductType(tdmReservationDO
							.getProductType());
				}
				if (StringUtils.isNotEmpty(tdmReservationDO.getYearBuilt())) {
					tdmPolicyPropertySearchResultDTO.setYearBuilt(String.valueOf(tdmReservationDO
							.getYearBuilt()));
				}
				if (StringUtils.isNotEmpty(tdmReservationDO.getConstructionType())) {
					tdmPolicyPropertySearchResultDTO.setConstructionType(tdmReservationDO
							.getConstructionType());
				}
				if (StringUtils.isNotEmpty(tdmReservationDO.getValuationMethod())) {
					tdmPolicyPropertySearchResultDTO.setValuationMethod(tdmReservationDO
							.getValuationMethod());
				}
				if (StringUtils.isNotEmpty(tdmReservationDO.getRiskState())) {
					tdmPolicyPropertySearchResultDTO
							.setPolicyState(tdmReservationDO.getRiskState());
				}
				if (StringUtils.isNotEmpty(tdmReservationDO.getPolicyTerm())) {
					if (tdmReservationDO.getPolicyTerm().equalsIgnoreCase("AN")) {
						tdmPolicyPropertySearchResultDTO.setPolicyTerm("ANNUAL");
					} else if (tdmReservationDO.getPolicyTerm().equalsIgnoreCase("SA")) {
						tdmPolicyPropertySearchResultDTO.setPolicyTerm("SEMI-ANNUAL");
					} else {
						tdmPolicyPropertySearchResultDTO.setPolicyTerm(String
								.valueOf(tdmReservationDO.getPolicyTerm()));
					}
				}
				if (StringUtils.isNotEmpty(tdmReservationDO.getPolicyStatus())) {
					tdmPolicyPropertySearchResultDTO.setPolicyStage(tdmReservationDO
							.getPolicyStatus());
				}
				if (StringUtils.isNotEmpty(tdmReservationDO.getAvailableDocs())) {
					tdmPolicyPropertySearchResultDTO.setAssoDocType(tdmReservationDO
							.getAvailableDocs());
				}
				if (StringUtils.isNotEmpty(tdmReservationDO.getAvailablePay())) {
					tdmPolicyPropertySearchResultDTO.setAssoPayReq(tdmReservationDO
							.getAvailablePay());
				}
				try {
					tdmPolicyPropertySearchResultDTO
							.setPolicyEffectDt(converDateToString(tdmReservationDO
									.getEffectivedate()));
					tdmPolicyPropertySearchResultDTO
							.setPolicyExpDt(converDateToString(tdmReservationDO.getExpirationdate()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				tdmPolicyPropertySearchResultDTO.setReservedYN("Yes");
				tdmPolicyPropertySearchResultDTO.setTestCaseId(tdmReservationDO.getTestCaseId());
				tdmPolicyPropertySearchResultDTO
						.setTestCaseName(tdmReservationDO.getTestCaseName());
				tdmPolicyPropertySearchResultDTO.setUserId(tdmReservationDO.getUserId());
				tdmPolicyPropertySearchResultDTO.setScenario(tdmReservationDO.getSearchScenario());
				Date date1 = tdmReservationDO.getUnlockTime();
				long diff = date2.getTime() - date1.getTime();
				switch ((int) (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS))) {
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
				tdmPolicyPropertySearchResultDTO.setExpairDate(myFormat.format(date1));
				if (StringUtils.isNotEmpty(tdmPolicyPropertySearchResultDTO.getUserId())) {
					if (tdmPolicyPropertySearchResultDTO.getUserId().equalsIgnoreCase(userName)) {
						tdmPolicyPropertySearchResultDTOs.add(tdmPolicyPropertySearchResultDTO);
					}
				} else {
					tdmPolicyPropertySearchResultDTOs.add(tdmPolicyPropertySearchResultDTO);
				}
			}
		}
		return tdmPolicyPropertySearchResultDTOs;
	}

	@Override
	public List<TdmPolicyAutoSearchResultDTO> converPolicysummaryToFTdmPolicyAutoSearchResultDTO(
			List<Object[]> listPolicySearchDo, TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO) {
		logger.info("This is in method TdmPolicyAutoSearchMapperImpl.converPolicysummaryToFTdmPolicyAutoSearchResultDTO() : ");
		List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOs = null;
		if (listPolicySearchDo != null && !listPolicySearchDo.isEmpty()) {
			tdmPolicyAutoSearchResultDTOs = new ArrayList<TdmPolicyAutoSearchResultDTO>();
			Set<String> setPolicySummeries = new HashSet<String>();
			for (Object[] tdmPolicySearchDO : listPolicySearchDo) {
				if (!setPolicySummeries.contains(tdmPolicySearchDO[0].toString())) {
					TdmPolicyAutoSearchResultDTO tdmPolicyAutoSearchResultDTO = new TdmPolicyAutoSearchResultDTO();
					if (StringUtils.isNotEmpty(tdmPolicySearchDO[0].toString())) {
						tdmPolicyAutoSearchResultDTO.setPolicynumber(tdmPolicySearchDO[0]
								.toString());
						setPolicySummeries.add(tdmPolicySearchDO[0].toString());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO[9].toString())) {
						tdmPolicyAutoSearchResultDTO
								.setNoOfDrivers(tdmPolicySearchDO[9].toString());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO[10].toString())) {
						tdmPolicyAutoSearchResultDTO.setNoOfVehi(tdmPolicySearchDO[10].toString());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO[11].toString())) {
						tdmPolicyAutoSearchResultDTO.setNoOfViola(tdmPolicySearchDO[11].toString());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO[12].toString())) {
						tdmPolicyAutoSearchResultDTO.setNoOfNamedInsu(tdmPolicySearchDO[12]
								.toString());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO[8].toString())) {
						tdmPolicyAutoSearchResultDTO
								.setProductType(tdmPolicySearchDO[8].toString());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO[14].toString())) {
						tdmPolicyAutoSearchResultDTO
								.setAssoPayReq(tdmPolicySearchDO[14].toString());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO[1].toString())) {
						if ((tdmPolicySearchDO[1].toString().equalsIgnoreCase("issued") && tdmPolicySearchDO[1]
								.toString().equalsIgnoreCase("inForce"))
								|| tdmPolicySearchDO[1].toString().equalsIgnoreCase("Active")) {
							tdmPolicyAutoSearchResultDTO.setPolicyStage("Active");
						} else if (tdmPolicySearchDO[1].toString().equalsIgnoreCase("cancelled")) {
							tdmPolicyAutoSearchResultDTO.setPolicyStage("Cancelled");
						} else {
							tdmPolicyAutoSearchResultDTO.setPolicyStage("Pending");
						}
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO[2].toString())) {
						tdmPolicyAutoSearchResultDTO
								.setPolicyState(tdmPolicySearchDO[2].toString());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO[3].toString())) {
						if (tdmPolicySearchDO[3].toString().equalsIgnoreCase("AN")) {
							tdmPolicyAutoSearchResultDTO.setPolicyTerm("ANNUAL");
						} else if (tdmPolicySearchDO[3].toString().equalsIgnoreCase("SA")) {
							tdmPolicyAutoSearchResultDTO.setPolicyTerm("SEMI-ANNUAL");
						} else {
							tdmPolicyAutoSearchResultDTO.setPolicyTerm(tdmPolicySearchDO[3]
									.toString());
						}
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO[6].toString())) {
						tdmPolicyAutoSearchResultDTO
								.setPolicyCovge(tdmPolicySearchDO[6].toString());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO[7].toString())) {
						tdmPolicyAutoSearchResultDTO.setRiskCovge(tdmPolicySearchDO[7].toString());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO[14].toString())) {
						tdmPolicyAutoSearchResultDTO
								.setAssoPayReq(tdmPolicySearchDO[14].toString());
					}
					tdmPolicyAutoSearchResultDTO.setRenewalcount(null);

					try {

						if (StringUtils.isNotEmpty(tdmPolicySearchDO[4].toString())) {
							tdmPolicyAutoSearchResultDTO
									.setPolicyEffectDt(converDateToString(converStringToDate(tdmPolicySearchDO[4]
											.toString())));
						}
						if (StringUtils.isNotEmpty(tdmPolicySearchDO[5].toString())) {
							tdmPolicyAutoSearchResultDTO
									.setPolicyExpDt(converDateToString(converStringToDate(tdmPolicySearchDO[5]
											.toString())));
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}

					if (StringUtils.isNotEmpty(tdmPolicySearchDO[16].toString())) {
						tdmPolicyAutoSearchResultDTO.setPolicyDetailId(Long
								.parseLong(tdmPolicySearchDO[16].toString() + ""));
					}

					// TODO
					/**
					 * need to be remove
					 * 
					 */

					tdmPolicyAutoSearchResultDTO.setAssoDocReq("Yes");

					/**
					 * Adding the Object to list values
					 */
					tdmPolicyAutoSearchResultDTOs.add(tdmPolicyAutoSearchResultDTO);
				}
			}
		}
		return tdmPolicyAutoSearchResultDTOs;
	}

	@Override
	public List<TdmPolicyPropertySearchResultDTO> converPolicysummaryToTdmPolicyPropertySearchDTO(
			List<TdmPolicySearchDO> propPolicyDOlist,
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO) {
		logger.info("This is in method TdmPolicyAutoSearchMapperImpl.converPolicysummaryToTdmPolicyPropertySearchDTO() : ");
		List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchResultDTOs = null;
		if (propPolicyDOlist != null && !propPolicyDOlist.isEmpty()) {
			tdmPolicyPropertySearchResultDTOs = new ArrayList<TdmPolicyPropertySearchResultDTO>();
			Set<String> setPolicySummeries = new HashSet<String>();
			for (TdmPolicySearchDO tdmPolicySearchDO : propPolicyDOlist) {
				TdmPolicyPropertySearchResultDTO tdmPolicyPropertySearchResultDTO = new TdmPolicyPropertySearchResultDTO();
				if (!setPolicySummeries.contains(tdmPolicySearchDO.getPolicynumber())) {
					tdmPolicyPropertySearchResultDTO.setPolicynumber(tdmPolicySearchDO
							.getPolicynumber());
					setPolicySummeries.add(tdmPolicySearchDO.getPolicynumber());
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getPolicyformcd())) {
						tdmPolicyPropertySearchResultDTO.setProductType(tdmPolicySearchDO
								.getPolicyformcd());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getAvailabledocuments())) {
						tdmPolicyPropertySearchResultDTO.setAssoPayReq(tdmPolicySearchDO
								.getAvailabledocuments());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getPolicystatuscd())) {
						if (tdmPolicySearchDO.getPolicystatuscd().equalsIgnoreCase("issued")
								&& tdmPolicySearchDO.getTimedpolicystatuscd().equalsIgnoreCase(
										"inForce")) {
							tdmPolicyPropertySearchResultDTO.setPolicyStage("Active");
						} else if (tdmPolicySearchDO.getPolicystatuscd().equalsIgnoreCase(
								"cancelled")) {
							tdmPolicyPropertySearchResultDTO.setPolicyStage("Cancelled");
						} else {
							tdmPolicyPropertySearchResultDTO.setPolicyStage("Pending");
						}
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getRiskstatecd())) {
						tdmPolicyPropertySearchResultDTO.setPolicyState(tdmPolicySearchDO
								.getRiskstatecd());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getPolicyterm())) {
						if (tdmPolicySearchDO.getPolicyterm().equalsIgnoreCase("AN")) {
							tdmPolicyPropertySearchResultDTO.setPolicyTerm("ANNUAL");
						} else if (tdmPolicySearchDO.getPolicyterm().equalsIgnoreCase("SA")) {
							tdmPolicyPropertySearchResultDTO.setPolicyTerm("SEMI-ANNUAL");
						} else {
							tdmPolicyPropertySearchResultDTO.setPolicyTerm(tdmPolicySearchDO
									.getPolicyterm());
						}
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getPolicycoverage())) {
						tdmPolicyPropertySearchResultDTO.setPolicyCovge(tdmPolicySearchDO
								.getPolicycoverage());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getRisklevelcoverage())) {
						tdmPolicyPropertySearchResultDTO.setRiskCovge(tdmPolicySearchDO
								.getRisklevelcoverage());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getPaymethod())) {
						tdmPolicyPropertySearchResultDTO.setAssoPayReq(tdmPolicySearchDO
								.getPaymethod());
					}
					try {
						if (StringUtils.isNotEmpty(converDateToString(tdmPolicySearchDO
								.getEffectivedate()))) {
							tdmPolicyPropertySearchResultDTO
									.setPolicyEffectDt(converDateToString(tdmPolicySearchDO
											.getEffectivedate()));
						}
						if (StringUtils.isNotEmpty(converDateToString(tdmPolicySearchDO
								.getExpirationdate()))) {
							tdmPolicyPropertySearchResultDTO
									.setPolicyExpDt(converDateToString(tdmPolicySearchDO
											.getExpirationdate()));
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getPolicydetailid() + "")) {
						tdmPolicyPropertySearchResultDTO.setPolicyDetailId(Long
								.parseLong(tdmPolicySearchDO.getPolicydetailid() + ""));
					}
					// TODO
					/**
					 * need to be remove
					 * 
					 */
					tdmPolicyPropertySearchResultDTO.setAssoDocType("Yes");

					/**
					 * Adding the Object to list values
					 */
					tdmPolicyPropertySearchResultDTOs.add(tdmPolicyPropertySearchResultDTO);
				}
			}
		}
		return tdmPolicyPropertySearchResultDTOs;
	}

	@Override
	public List<TdmPolicyAutoSearchResultDTO> converPolicysummaryToFTdmPolicyAutoSearchResultDTONew(
			List<TdmPolicySearchDO> listPolicySearchDo,
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO) {
		logger.info("This is in method TdmPolicyAutoSearchMapperImpl.converPolicysummaryToFTdmPolicyAutoSearchResultDTO() : ");
		List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOs = null;
		if (listPolicySearchDo != null && !listPolicySearchDo.isEmpty()) {
			tdmPolicyAutoSearchResultDTOs = new ArrayList<TdmPolicyAutoSearchResultDTO>();
			Set<String> setPolicySummeries = new HashSet<String>();
			for (TdmPolicySearchDO tdmPolicySearchDO : listPolicySearchDo) {
				if (!setPolicySummeries.contains(tdmPolicySearchDO.getPolicynumber())) {
					TdmPolicyAutoSearchResultDTO tdmPolicyAutoSearchResultDTO = new TdmPolicyAutoSearchResultDTO();
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getPolicynumber())) {
						tdmPolicyAutoSearchResultDTO.setPolicynumber(tdmPolicySearchDO
								.getPolicynumber());
						setPolicySummeries.add(tdmPolicySearchDO.getPolicynumber());
					}

					tdmPolicyAutoSearchResultDTO.setNoOfDrivers(String.valueOf(tdmPolicySearchDO
							.getNoofdrivers()));
					tdmPolicyAutoSearchResultDTO.setNoOfVehi(String.valueOf(tdmPolicySearchDO
							.getNoofvehicles()));
					tdmPolicyAutoSearchResultDTO.setNoOfViola(String.valueOf(tdmPolicySearchDO
							.getNoofviolations()));
					tdmPolicyAutoSearchResultDTO.setNoOfNamedInsu(String.valueOf(tdmPolicySearchDO
							.getNoofnamedinsured()));

					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getProductcd())) {
						tdmPolicyAutoSearchResultDTO.setProductType(tdmPolicySearchDO
								.getProductcd());
					}

					tdmPolicyAutoSearchResultDTO.setAssoPayReq(null);

					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getPolicystage())) {
						if ((tdmPolicySearchDO.getPolicystage().equalsIgnoreCase("issued") && tdmPolicySearchDO
								.getPolicystage().equalsIgnoreCase("inForce"))
								|| tdmPolicySearchDO.getPolicystage().equalsIgnoreCase("Active")) {
							tdmPolicyAutoSearchResultDTO.setPolicyStage("Active");
						} else if (tdmPolicySearchDO.getPolicystage().equalsIgnoreCase("cancelled")) {
							tdmPolicyAutoSearchResultDTO.setPolicyStage("Cancelled");
						} else {
							tdmPolicyAutoSearchResultDTO.setPolicyStage("Pending");
						}
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getRiskstatecd())) {
						tdmPolicyAutoSearchResultDTO.setPolicyState(tdmPolicySearchDO
								.getRiskstatecd());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getPolicyterm())) {
						if (tdmPolicySearchDO.getPolicyterm().equalsIgnoreCase("AN")) {
							tdmPolicyAutoSearchResultDTO.setPolicyTerm("ANNUAL");
						} else if (tdmPolicySearchDO.getPolicyterm().equalsIgnoreCase("SA")) {
							tdmPolicyAutoSearchResultDTO.setPolicyTerm("SEMI-ANNUAL");
						} else {
							tdmPolicyAutoSearchResultDTO.setPolicyTerm(tdmPolicySearchDO
									.getPolicyterm());
						}
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getPolicycoverage())) {
						tdmPolicyAutoSearchResultDTO.setPolicyCovge(tdmPolicySearchDO
								.getPolicycoverage());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getRisklevelcoverage())) {
						tdmPolicyAutoSearchResultDTO.setRiskCovge(tdmPolicySearchDO
								.getRisklevelcoverage());
					}
					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getAvailablepayments())) {
						tdmPolicyAutoSearchResultDTO.setAssoPayReq(tdmPolicySearchDO
								.getAvailablepayments());
					}
					tdmPolicyAutoSearchResultDTO.setRenewalcount(null);

					try {

						if (StringUtils.isNotEmpty(converDateToString(tdmPolicySearchDO
								.getEffectivedate()))) {
							tdmPolicyAutoSearchResultDTO
									.setPolicyEffectDt(converDateToString(tdmPolicySearchDO
											.getEffectivedate()));
						}
						if (StringUtils.isNotEmpty(converDateToString(tdmPolicySearchDO
								.getExpirationdate()))) {
							tdmPolicyAutoSearchResultDTO
									.setPolicyExpDt(converDateToString(tdmPolicySearchDO
											.getExpirationdate()));
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}

					if (StringUtils.isNotEmpty(tdmPolicySearchDO.getPolicydetailid())) {
						tdmPolicyAutoSearchResultDTO.setPolicyDetailId(Long
								.parseLong(tdmPolicySearchDO.getPolicydetailid() + ""));
					}

					// TODO
					/**
					 * need to be remove
					 * 
					 */

					tdmPolicyAutoSearchResultDTO.setAssoDocReq("Yes");

					/**
					 * Adding the Object to list values
					 */
					tdmPolicyAutoSearchResultDTOs.add(tdmPolicyAutoSearchResultDTO);
				}
			}
		}
		return tdmPolicyAutoSearchResultDTOs;
	}

	public Date converStringToDateNew(String strdate) throws ParseException {
		Date returndate = null;
		if (null != strdate) {
			SimpleDateFormat dataFormater = new SimpleDateFormat("yyyy-mm-dd");
			returndate = dataFormater.parse(strdate);
			dataFormater.format(returndate);
			return returndate;
		}
		return returndate;
	}
}
