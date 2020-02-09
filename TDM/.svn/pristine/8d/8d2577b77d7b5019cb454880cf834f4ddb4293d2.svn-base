package com.tesda.model.mapper.impl;

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

import com.tesda.model.DO.PolicySummaryStg;
// import com.tesda.model.DO.PropPolicyDO;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyAutoSearchResultDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchResultDTO;
import com.tesda.model.mapper.TdmPolicyAutoPropSearchMapper;

@Component
@Service("tdmPolicyAutoPropSearchMapper")
public class TdmPolicyAutoPropSearchMapperImpl implements TdmPolicyAutoPropSearchMapper
{
	final static Logger logger = Logger.getLogger(TdmPolicyAutoPropSearchMapperImpl.class);
	public static final String tabDriver = "DRIVER";
	public static final String tabVehi = "RISKITEM";
	public static final String tabViolats = "ACCIDENTVIOLATION";
	public static final String tabNo_Of_Named_Insured = "INSUREDPRINCIPAL";

	@Override
	public List<TdmPolicyPropertySearchResultDTO> converPolicysummaryToTdmPolicyPropertySearchDTONew(
			List<PolicySummaryStg> policySummaryStgDOs,
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO) {
		logger.info("This is in method TdmPolicyAutoPropSearchMapperImpl.converPolicysummaryToTdmPolicyPropertySearchDTO() : ");
		List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchResultDTOs = null;
		if (policySummaryStgDOs != null && !policySummaryStgDOs.isEmpty()) {
			tdmPolicyPropertySearchResultDTOs = new ArrayList<TdmPolicyPropertySearchResultDTO>();

			for (PolicySummaryStg policySummaryStgDO : policySummaryStgDOs) {
				TdmPolicyPropertySearchResultDTO tdmPolicyPropertySearchResultDTO = new TdmPolicyPropertySearchResultDTO();

				// Policy Detail Id
				if (StringUtils.isNotEmpty(policySummaryStgDO.getPolicydetailId())) {
					tdmPolicyPropertySearchResultDTO.setPolicyDetailId(Long
							.parseLong(policySummaryStgDO.getPolicydetailId()));
				}

				// Policy Number
				if (StringUtils.isNotEmpty(policySummaryStgDO.getPolicynumber())) {
					tdmPolicyPropertySearchResultDTO.setPolicynumber(policySummaryStgDO
							.getPolicynumber());
				}

				// Product Type
				if (StringUtils.isNotEmpty(policySummaryStgDO.getPolicyformcd())) {
					tdmPolicyPropertySearchResultDTO.setProductType(policySummaryStgDO
							.getPolicyformcd());
				}

				// Policy Stage
				if (StringUtils.isNotEmpty(policySummaryStgDO.getPolicystatuscd())) {
					if (policySummaryStgDO.getPolicystatuscd().equalsIgnoreCase("issued")
							&& policySummaryStgDO.getTimedpolicystatuscd().equalsIgnoreCase(
									"inForce")) {
						tdmPolicyPropertySearchResultDTO.setPolicyStage("Active");
					} else if (policySummaryStgDO.getPolicystatuscd().equalsIgnoreCase("cancelled")) {
						tdmPolicyPropertySearchResultDTO.setPolicyStage("Cancelled");
					} else {
						tdmPolicyPropertySearchResultDTO.setPolicyStage("Pending");
					}
				}

				// Risk State
				if (StringUtils.isNotEmpty(policySummaryStgDO.getRiskstatecd())) {
					tdmPolicyPropertySearchResultDTO.setPolicyState(policySummaryStgDO
							.getRiskstatecd());
				}

				// Policy Term
				if (StringUtils.isNotEmpty(policySummaryStgDO.getContracttermtypecd())) {
					if (policySummaryStgDO.getContracttermtypecd().equalsIgnoreCase("AN")) {
						tdmPolicyPropertySearchResultDTO.setPolicyTerm("ANNUAL");
					} else if (policySummaryStgDO.getContracttermtypecd().equalsIgnoreCase("SA")) {
						tdmPolicyPropertySearchResultDTO.setPolicyTerm("SEMI-ANNUAL");
					} else {
						tdmPolicyPropertySearchResultDTO.setPolicyTerm(policySummaryStgDO
								.getContracttermtypecd());
					}
				}

				// Policy Risk level Coverage

				if (null != policySummaryStgDO.getCoverageRiskStgs()
						&& !policySummaryStgDO.getCoverageRiskStgs().isEmpty()) {

					for (int i = 0; i < policySummaryStgDO.getCoverageRiskStgs().size(); i++) {
						if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddRiskCovge())
								&& tdmPolicyPropertySearchDTO.getAddRiskCovge().equalsIgnoreCase(
										policySummaryStgDO.getCoverageRiskStgs().get(i)
												.getCoveragecd())) {
							tdmPolicyPropertySearchResultDTO.setRiskCovge(policySummaryStgDO
									.getCoverageRiskStgs().get(i).getCoveragecd());
							break;
						} else {
							tdmPolicyPropertySearchResultDTO.setRiskCovge(policySummaryStgDO
									.getCoverageRiskStgs().get(i).getCoveragecd());

						}
					}
				}

				// Associate Payments required
				tdmPolicyPropertySearchResultDTO.setAssoPayReq(null);

				// Effective date
				if (null != policySummaryStgDO.getEffective()) {
					tdmPolicyPropertySearchResultDTO
							.setPolicyEffectDt(converDateToString(policySummaryStgDO.getEffective()));
				}

				// Expiration date
				if (null != policySummaryStgDO.getExpiration()) {
					tdmPolicyPropertySearchResultDTO
							.setPolicyExpDt(converDateToString(policySummaryStgDO.getExpiration()));
				}

				// Associated Documents required
				if (StringUtils.isNotEmpty(policySummaryStgDO.getDocYn())) {
					if ("Y".equalsIgnoreCase(policySummaryStgDO.getDocYn())) {
						tdmPolicyPropertySearchResultDTO.setAssoDocType("Yes");
					} else {
						tdmPolicyPropertySearchResultDTO.setAssoDocType("No");
					}

				}

				// Doc Type
				if (null != policySummaryStgDO.getDocType()) {
					tdmPolicyPropertySearchResultDTO.setDocType(policySummaryStgDO.getDocType());
				}

				/**
				 * Adding the Object to list values
				 */
				tdmPolicyPropertySearchResultDTOs.add(tdmPolicyPropertySearchResultDTO);

			}
		}
		return tdmPolicyPropertySearchResultDTOs;
	}

	@Override
	public List<TdmPolicyAutoSearchResultDTO> converPolicysummaryToTdmPolicyAutoSearchResultDTONew(
			List<PolicySummaryStg> policySummaryStgDOs,
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO) {
		logger.info("This is in method TdmPolicyAutoPropSearchMapperImpl.converPolicysummaryToTdmPolicyAutoSearchResultDTO() : ");
		List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOs = null;
		if (policySummaryStgDOs != null && !policySummaryStgDOs.isEmpty()) {
			tdmPolicyAutoSearchResultDTOs = new ArrayList<TdmPolicyAutoSearchResultDTO>();

			for (PolicySummaryStg policySummaryStgDO : policySummaryStgDOs) {
				TdmPolicyAutoSearchResultDTO tdmPolicyAutoSearchResultDTO = new TdmPolicyAutoSearchResultDTO();

				// Policy Detail Id
				if (StringUtils.isNotEmpty(policySummaryStgDO.getPolicydetailId())) {
					tdmPolicyAutoSearchResultDTO.setPolicyDetailId(Long
							.parseLong(policySummaryStgDO.getPolicydetailId()));
				}

				// Policy Number
				if (StringUtils.isNotEmpty(policySummaryStgDO.getPolicynumber())) {
					tdmPolicyAutoSearchResultDTO.setPolicynumber(policySummaryStgDO
							.getPolicynumber());
				}
				// Product Type
				if (StringUtils.isNotEmpty(policySummaryStgDO.getProductcd())) {
					tdmPolicyAutoSearchResultDTO.setProductType(policySummaryStgDO.getProductcd());
				}
				// Policy Stage
				if (StringUtils.isNotEmpty(policySummaryStgDO.getPolicystatuscd())) {
					if ((policySummaryStgDO.getPolicystatuscd().equalsIgnoreCase("issued") && policySummaryStgDO
							.getTimedpolicystatuscd().equalsIgnoreCase("inForce"))
							|| policySummaryStgDO.getPolicystatuscd().equalsIgnoreCase("Active")) {
						tdmPolicyAutoSearchResultDTO.setPolicyStage("Active");
					} else if (policySummaryStgDO.getPolicystatuscd().equalsIgnoreCase("cancelled")) {
						tdmPolicyAutoSearchResultDTO.setPolicyStage("Cancelled");
					} else {
						tdmPolicyAutoSearchResultDTO.setPolicyStage("Pending");
					}
				}
				// Risk State
				if (StringUtils.isNotEmpty(policySummaryStgDO.getRiskstatecd())) {
					tdmPolicyAutoSearchResultDTO
							.setPolicyState(policySummaryStgDO.getRiskstatecd());
				}
				// Policy Term
				if (StringUtils.isNotEmpty(policySummaryStgDO.getContracttermtypecd())) {
					if (policySummaryStgDO.getContracttermtypecd().equalsIgnoreCase("AN")) {
						tdmPolicyAutoSearchResultDTO.setPolicyTerm("ANNUAL");
					} else if (policySummaryStgDO.getContracttermtypecd().equalsIgnoreCase("SA")) {
						tdmPolicyAutoSearchResultDTO.setPolicyTerm("SEMI-ANNUAL");
					} else {
						tdmPolicyAutoSearchResultDTO.setPolicyTerm(policySummaryStgDO
								.getContracttermtypecd());
					}
				}

				// Policy Coverage
				if (null != policySummaryStgDO.getCoverageStgs()
						&& !policySummaryStgDO.getCoverageStgs().isEmpty()) {

					for (int i = 0; i < policySummaryStgDO.getCoverageStgs().size(); i++) {
						if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())
								&& tdmPolicyAutoSearchDTO.getPolicyCovge()
										.equalsIgnoreCase(
												policySummaryStgDO.getCoverageStgs().get(i)
														.getCoveragecd())) {
							tdmPolicyAutoSearchResultDTO.setPolicyCovge(policySummaryStgDO
									.getCoverageStgs().get(i).getCoveragecd());

							break;
						} else {
							tdmPolicyAutoSearchResultDTO.setPolicyCovge(policySummaryStgDO
									.getCoverageStgs().get(i).getCoveragecd());
						}
					}
				}

				// Risk Level Coverage
				if (null != policySummaryStgDO.getCoverageRiskStgs()
						&& !policySummaryStgDO.getCoverageRiskStgs().isEmpty()) {

					for (int i = 0; i < policySummaryStgDO.getCoverageRiskStgs().size(); i++) {
						if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getRiskCovge())
								&& tdmPolicyAutoSearchDTO.getRiskCovge().equalsIgnoreCase(
										policySummaryStgDO.getCoverageRiskStgs().get(i)
												.getCoveragecd())) {
							tdmPolicyAutoSearchResultDTO.setRiskCovge(policySummaryStgDO
									.getCoverageRiskStgs().get(i).getCoveragecd());
							break;
						} else {
							tdmPolicyAutoSearchResultDTO.setRiskCovge(policySummaryStgDO
									.getCoverageRiskStgs().get(i).getCoveragecd());
						}
					}
				}

				// Associate Payments required
				tdmPolicyAutoSearchResultDTO.setAssoPayReq(null);

				tdmPolicyAutoSearchResultDTO.setRenewalcount(null);

				// Effective date
				if (null != policySummaryStgDO.getEffective()) {
					tdmPolicyAutoSearchResultDTO
							.setPolicyEffectDt(converDateToString(policySummaryStgDO.getEffective()));
				}
				// Expiration date
				if (null != policySummaryStgDO.getExpiration()) {
					tdmPolicyAutoSearchResultDTO
							.setPolicyExpDt(converDateToString(policySummaryStgDO.getExpiration()));

				}

				// No of Drivers
				if (null != policySummaryStgDO.getNoOfDriverStg()) {
					tdmPolicyAutoSearchResultDTO.setNoOfDrivers(String.valueOf(policySummaryStgDO
							.getNoOfDriverStg().getCount()));
				}
				// No Of Name Insu
				if (null != policySummaryStgDO.getNoOfNameInsuStg()) {
					tdmPolicyAutoSearchResultDTO.setNoOfNamedInsu(String.valueOf(policySummaryStgDO
							.getNoOfNameInsuStg().getCount()));
				}

				// No Of Name Vehi
				if (null != policySummaryStgDO.getNoOfVehiStg()) {
					tdmPolicyAutoSearchResultDTO.setNoOfVehi(String.valueOf(policySummaryStgDO
							.getNoOfVehiStg().getCount()));
				}

				// No Of Name Vio
				if (null != policySummaryStgDO.getNoOfVioStg()) {
					tdmPolicyAutoSearchResultDTO.setNoOfViola(String.valueOf(policySummaryStgDO
							.getNoOfVioStg().getCount()));
				}

				// Associated Documents required
				if (null != policySummaryStgDO.getDocYn()) {
					if (StringUtils.isNotEmpty(policySummaryStgDO.getDocYn())) {
						if ("Y".equalsIgnoreCase(policySummaryStgDO.getDocYn())) {
							tdmPolicyAutoSearchResultDTO.setAssoDocReq("Yes");
						} else {
							tdmPolicyAutoSearchResultDTO.setAssoDocReq("No");
						}
					}

				}
				// Doc Type
				if (null != policySummaryStgDO.getDocType()) {
					tdmPolicyAutoSearchResultDTO.setDocType(policySummaryStgDO.getDocType());
				}

				/**
				 * Adding the Object to list values
				 */
				tdmPolicyAutoSearchResultDTOs.add(tdmPolicyAutoSearchResultDTO);
			}

		}
		return tdmPolicyAutoSearchResultDTOs;
	}

	@Override
	public List<TdmReservationDO> converTdmPolicyAutoSearchResultDTOToTdmReservationDO(
			List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOList,
			String searchcriti, String userId, String enviro) {
		logger.info("This is in method TdmPolicyAutoPropSearchMapperImpl.converTdmPolicyAutoSearchResultDTOToTdmReservationDO() : ");
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

					reservationDO.setEffectivedate(converStringToDate(tdmPolicyAutoSearchResultDTO
							.getPolicyEffectDt()));
					reservationDO.setExpirationdate(converStringToDate(tdmPolicyAutoSearchResultDTO
							.getPolicyExpDt()));

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
	public List<TdmReservationDO> converTdmPolicyPropertySearchDTOToTdmReservationDO(
			List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchResultDTOList,
			String searchcriti, String userId, String enviro) {
		logger.info("This is in method TdmPolicyAutoPropSearchMapperImpl.converTdmPolicyPropertySearchDTOToTdmReservationDO() : ");
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

					reservationDO
							.setEffectivedate(converStringToDate(tdmPolicyPropertySearchResultDTO
									.getPolicyEffectDt()));
					reservationDO
							.setExpirationdate(converStringToDate(tdmPolicyPropertySearchResultDTO
									.getPolicyExpDt()));

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

	public String converDateToString(Date date) {
		if (null != date) {
			SimpleDateFormat dataFormater = new SimpleDateFormat("dd/MM/yyyy");
			String stringobj = dataFormater.format(date);
			return stringobj;
		}
		return null;
	}

	public Date converStringToDate(String strdate) {
		Date returndate = null;
		if (null != strdate) {
			try {
				SimpleDateFormat dataFormater = new SimpleDateFormat("dd/MM/yyyy");
				returndate = dataFormater.parse(strdate);
				dataFormater.format(returndate);
				return returndate;
			} catch (ParseException pe) {
				pe.printStackTrace();
			}
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

				tdmPolicyAutoSearchResultDTO.setPolicyEffectDt(converDateToString(tdmReservationDO
						.getEffectivedate()));
				tdmPolicyAutoSearchResultDTO.setPolicyExpDt(converDateToString(tdmReservationDO
						.getExpirationdate()));

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

				tdmPolicyPropertySearchResultDTO
						.setPolicyEffectDt(converDateToString(tdmReservationDO.getEffectivedate()));
				tdmPolicyPropertySearchResultDTO.setPolicyExpDt(converDateToString(tdmReservationDO
						.getExpirationdate()));

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

}
