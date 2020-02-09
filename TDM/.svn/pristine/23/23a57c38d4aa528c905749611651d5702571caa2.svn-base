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
import com.tdm.model.DO.PolicySummaryStg;
// import com.tesda.model.DO.PropPolicyDO;
import com.tdm.model.DO.TdmReservationDO;
import com.tdm.model.DTO.TdmPolicyAutoSearchDTO;
import com.tdm.model.DTO.TdmPolicyAutoSearchResultDTO;
import com.tdm.model.DTO.TdmPolicyPropertySearchDTO;
import com.tdm.model.DTO.TdmPolicyPropertySearchResultDTO;
import com.tdm.model.mapper.TdmPolicyAutoPropSearchMapper;

@Component
@Service("tdmPolicyAutoPropSearchMapper")
public class TdmPolicyAutoPropSearchMapperImpl implements TdmPolicyAutoPropSearchMapper
{
	final static Logger logger = Logger.getLogger(TdmPolicyAutoPropSearchMapperImpl.class);
	public static final String tabDriver = "DRIVER";
	public static final String tabVehi = "RISKITEM";
	public static final String tabViolats = "ACCIDENTVIOLATION";
	public static final String tabNo_Of_Named_Insured = "INSUREDPRINCIPAL";

	DateFormat myFormat = new SimpleDateFormat(AppConstant.MMDDYYYY);
	Calendar cal = Calendar.getInstance();
	Date date2 = cal.getTime();

	@Override
	public List<TdmPolicyPropertySearchResultDTO> converPolicysummaryToTdmPolicyPropertySearchDTONew(
			List<PolicySummaryStg> policySummaryStgDOs,
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			List<TdmReservationDO> reservationDOs, String userName) {
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
						if (null != tdmPolicyPropertySearchDTO
								&& StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO
										.getAddRiskCovge())
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

				// Reservation
				if (null != reservationDOs && 0 < reservationDOs.size()) {
					for (int j = 0; j < reservationDOs.size(); j++) {
						if (null != reservationDOs.get(j).getReserveDataType()
								&& reservationDOs.get(j).getReserveDataType()
										.equalsIgnoreCase("CSAA_PO")) {
							if (policySummaryStgDO.getPolicynumber().equalsIgnoreCase(
									reservationDOs.get(j).getReserveDataId())) {
								tdmPolicyPropertySearchResultDTO.setReservedYN(AppConstant.YES);
								tdmPolicyPropertySearchResultDTO.setTestCaseId(reservationDOs
										.get(j).getTestCaseId());
								tdmPolicyPropertySearchResultDTO.setTestCaseName(reservationDOs
										.get(j).getTestCaseName());
								tdmPolicyPropertySearchResultDTO.setUserId(reservationDOs.get(j)
										.getUserId());
								Date date1 = reservationDOs.get(j).getUnlockTime();
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
								tdmPolicyPropertySearchResultDTO.setExpairDate(myFormat
										.format(date1));
							}
						}
					}
				}
				/**
				 * Adding the Object to list values
				 */
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
	public List<TdmPolicyAutoSearchResultDTO> converPolicysummaryToTdmPolicyAutoSearchResultDTONew(
			List<PolicySummaryStg> policySummaryStgDOs,
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, List<TdmReservationDO> reservationDOs,
			String userName) {
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

						if (null != tdmPolicyAutoSearchDTO
								&& StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())
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
						if (null != tdmPolicyAutoSearchDTO
								&& StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getRiskCovge())
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

				// Reservation
				if (null != reservationDOs && 0 < reservationDOs.size()) {
					for (int j = 0; j < reservationDOs.size(); j++) {
						if (null != reservationDOs.get(j).getReserveDataType()
								&& reservationDOs.get(j).getReserveDataType()
										.equalsIgnoreCase("CSAA_AU")) {
							if (policySummaryStgDO.getPolicynumber().equalsIgnoreCase(
									reservationDOs.get(j).getReserveDataId())) {
								tdmPolicyAutoSearchResultDTO.setReservedYN(AppConstant.YES);
								tdmPolicyAutoSearchResultDTO.setTestCaseId(reservationDOs.get(j)
										.getTestCaseId());
								tdmPolicyAutoSearchResultDTO.setTestCaseName(reservationDOs.get(j)
										.getTestCaseName());
								tdmPolicyAutoSearchResultDTO.setUserId(reservationDOs.get(j)
										.getUserId());
								Date date1 = reservationDOs.get(j).getUnlockTime();
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
							}
						}
					}
				}
				/**
				 * Adding the Object to list values
				 */
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
						reservationDO.setReserveDataId(tdmPolicyAutoSearchResultDTO
								.getPolicynumber());
					}
					reservationDO.setLocked("Y");
					reservationDO.setUserId(userId);
					reservationDO.setUnreserve("N");

					reservationDO.setReserveDataType("CSAA_AU");
					reservationDO.setUnlockTime(new Timestamp(new Date().getTime()));
					reservationDO.setRowData(searchcriti.substring(18));

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
						reservationDO.setReserveDataId(tdmPolicyPropertySearchResultDTO
								.getPolicynumber());
					}
					reservationDO.setLocked("Y");
					reservationDO.setUserId(userId);
					reservationDO.setUnreserve("N");
					reservationDO.setReserveData(searchcriti.substring(18));

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

				tdmPolicyAutoSearchResultDTO.setReservedYN("Yes");
				tdmPolicyAutoSearchResultDTO.setTestCaseId(tdmReservationDO.getTestCaseId());
				tdmPolicyAutoSearchResultDTO.setTestCaseName(tdmReservationDO.getTestCaseName());
				tdmPolicyAutoSearchResultDTO.setUserId(tdmReservationDO.getUserId());

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

			}
		}
		return tdmPolicyAutoSearchResultDTOs;
	}

	@Override
	public List<TdmPolicyPropertySearchResultDTO> converTdmReservationDOToTdmPolicyPropertySearchDTO(
			List<TdmReservationDO> tdmReservationDOlist, String userName) {
		logger.info("This is in method TdmPolicyAutoSearchMapperImpl.converTdmReservationDOToTdmPolicyPropertySearchDTO() : ");

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

				tdmPolicyPropertySearchResultDTO.setReservedYN("Yes");
				tdmPolicyPropertySearchResultDTO.setTestCaseId(tdmReservationDO.getTestCaseId());
				tdmPolicyPropertySearchResultDTO
						.setTestCaseName(tdmReservationDO.getTestCaseName());
				tdmPolicyPropertySearchResultDTO.setUserId(tdmReservationDO.getUserId());
				tdmPolicyPropertySearchResultDTO.setScenario(tdmReservationDO.getReserveData());
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

			}
		}
		return tdmPolicyPropertySearchResultDTOs;
	}

}
