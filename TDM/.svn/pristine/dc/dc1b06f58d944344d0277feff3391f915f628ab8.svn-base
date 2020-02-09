package com.tesda.model.mapper.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tesda.constants.TDMConstants;
import com.tesda.model.DO.ReqChDO;
import com.tesda.model.DO.RequestorDO;
import com.tesda.model.DO.TdmOnboadReqNoTabDO;
import com.tesda.model.DO.TdmOnboardReqDO;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DTO.TDMClaimSearchResultListDTO;
import com.tesda.model.DTO.TDMProvSearchResultListDTO;
import com.tesda.model.DTO.TDMSubscSearchResultListDTO;
import com.tesda.model.DTO.TdgDataMaskingDTO;
import com.tesda.model.DTO.TdgDataMaskingNoOfAppsDTO;
import com.tesda.model.DTO.TdmOnBoardReqDTO;
import com.tesda.model.mapper.TDMProviderSearchMapper;

@Component
@Service("tDMProviderSearchMapper")
public class TDMProviderSearchMapperImpl implements TDMProviderSearchMapper
{

	@Override
	public List<TdmReservationDO> converfTDProvSearchResultListDTOToTdmReservationDO(
			List<TDMProvSearchResultListDTO> fTDProvSearchResultListDTOList, String userName)
	{
		List<TdmReservationDO> reservationDOList = null;
		if (null != fTDProvSearchResultListDTOList && 0 < fTDProvSearchResultListDTOList.size())
		{
			TdmReservationDO reservationDO = null;
			TDMProvSearchResultListDTO tDMProvSearchResultListDTO = null;
			reservationDOList = new ArrayList<TdmReservationDO>();
			for (int i = 0; i < fTDProvSearchResultListDTOList.size(); i++)
			{
				tDMProvSearchResultListDTO = fTDProvSearchResultListDTOList.get(i);
				if (null != tDMProvSearchResultListDTO.getReservedYN())
				{
					// reservationDO = new TdmReservationDO();
					// if (0 < tDMProvSearchResultListDTO.getProviderId())
					// {
					// reservationDO.setReserveDataId(String.valueOf(tDMProvSearchResultListDTO
					// .getProviderId()));
					// }
					// reservationDO.setLocked("Y");
					// reservationDO.setReserveData(null);
					// reservationDO.setRowData(null);
					// reservationDO.setUserId(userName);
					// reservationDO.setUnreserve("N");
					// reservationDO.setReserveDataType(TDMConstants.PROV);
					// reservationDO.setUnlockTime(new Timestamp(new
					// Date().getTime()));
					// reservationDOList.add(reservationDO);
				}
			}
		}
		return reservationDOList;
	}

	@Override
	public List<TdmReservationDO> converTDMSubscSearchResultListDTOToTdmReservationDO(
			List<TDMSubscSearchResultListDTO> tdmSubscSearchResultListDTOList, String userId)
	{
		List<TdmReservationDO> reservationDOList = null;
		if (null != tdmSubscSearchResultListDTOList && 0 < tdmSubscSearchResultListDTOList.size())
		{
			TdmReservationDO reservationDO = null;
			TDMSubscSearchResultListDTO tDMSubscSearchResultListDTO = null;
			reservationDOList = new ArrayList<TdmReservationDO>();
			for (int i = 0; i < tdmSubscSearchResultListDTOList.size(); i++)
			{
				tDMSubscSearchResultListDTO = tdmSubscSearchResultListDTOList.get(i);
				if (null != tDMSubscSearchResultListDTO.getReservedYN())
				{
					reservationDO = new TdmReservationDO();
					// if (null !=
					// tDMSubscSearchResultListDTO.getSubscriberId())
					// {
					// reservationDO.setReserveDataId(tDMSubscSearchResultListDTO
					// .getSubscriberId());
					// }
					// reservationDO.setLocked("Y");
					// reservationDO.setReserveData(null);
					// reservationDO.setRowData(null);
					// reservationDO.setUserId(userId);
					// reservationDO.setUnreserve("N");
					// reservationDO.setReserveDataType(TDMConstants.SUB);
					// reservationDO.setUnlockTime(new Timestamp(new
					// Date().getTime()));
					// reservationDOList.add(reservationDO);
				}
			}
		}
		return reservationDOList;
	}

	public String converDateToString(Date date) throws ParseException
	{
		if (null != date)
		{
			SimpleDateFormat dataFormater = new SimpleDateFormat(TDMConstants.DD_MM_YYYY);
			String stringobj = dataFormater.format(date);
			return stringobj;
		}
		return null;
	}

	@Override
	public List<TdmReservationDO> converTDMClaimSearchResultListDTOToTdmReservationDO(
			List<TDMClaimSearchResultListDTO> tdmClaimSearchResultListDTOList, String userId)
	{
		List<TdmReservationDO> reservationDOList = null;

		if (null != tdmClaimSearchResultListDTOList && 0 < tdmClaimSearchResultListDTOList.size())
		{
			TdmReservationDO reservationDO = null;
			TDMClaimSearchResultListDTO tDMClaimSearchResultListDTO = null;
			reservationDOList = new ArrayList<TdmReservationDO>();
			for (int i = 0; i < tdmClaimSearchResultListDTOList.size(); i++)
			{
				tDMClaimSearchResultListDTO = tdmClaimSearchResultListDTOList.get(i);
				if (null != tDMClaimSearchResultListDTO.getReservedYN())
				{
					reservationDO = new TdmReservationDO();
					// if (null != tDMClaimSearchResultListDTO.getClaimId())
					// {
					// reservationDO.setReserveDataId(tDMClaimSearchResultListDTO.getClaimId());
					// }
					// reservationDO.setLocked("Y");
					// reservationDO.setReserveData(null);
					// reservationDO.setRowData(null);
					// reservationDO.setUserId(userId);
					// reservationDO.setUnreserve("N");
					// reservationDO.setReserveDataType(TDMConstants.CLM);
					// reservationDO.setUnlockTime(new Timestamp(new
					// Date().getTime()));
					// reservationDOList.add(reservationDO);
				}
			}
		}
		return reservationDOList;
	}

	@Override
	public RequestorDO convertTDGDataMaskRequestToDO(TdgDataMaskingDTO tdgDataMaskingDTO, String seq)
	{
		RequestorDO requestorDO = new RequestorDO();
		ReqChDO reqChDO = null;
		List<ReqChDO> reqChDOList = new ArrayList<ReqChDO>();

		if (StringUtils.isNotEmpty(tdgDataMaskingDTO.getId()))
		{
			int crNo = tdgDataMaskingDTO.getVno() + 1;
			if (tdgDataMaskingDTO.getId().contains(TDMConstants.CR))
			{
				requestorDO.setId(tdgDataMaskingDTO.getId().replace(
						tdgDataMaskingDTO.getId().substring(tdgDataMaskingDTO.getId().indexOf("C"),
								tdgDataMaskingDTO.getId().length()), TDMConstants.CR + crNo));
				tdgDataMaskingDTO.setId(requestorDO.getId());
			}
			else
			{
				requestorDO.setId(tdgDataMaskingDTO.getId() + TDMConstants.CR
						+ (tdgDataMaskingDTO.getVno() + 1));
				tdgDataMaskingDTO.setId(requestorDO.getId());
			}
			requestorDO.setVno(tdgDataMaskingDTO.getVno() + 1);
		}
		else
		{
			requestorDO.setId(TDMConstants.MR + seq);
			requestorDO.setVno(0);
		}

		requestorDO.setName(tdgDataMaskingDTO.getUserName());
		requestorDO.setUserName(tdgDataMaskingDTO.getUserId());
		requestorDO.setEmailid(tdgDataMaskingDTO.getEmailId());
		requestorDO.setPhoneno(tdgDataMaskingDTO.getPhoneNo());
		requestorDO.setDepartment(tdgDataMaskingDTO.getDeptName());
		requestorDO.setNeededby(tdgDataMaskingDTO.getNeededBy());
		requestorDO.setProjectName(tdgDataMaskingDTO.getProjName());
		requestorDO.setProjectPhase(tdgDataMaskingDTO.getProjPhase());
		requestorDO.setEnvironment(tdgDataMaskingDTO.getEnvType());

		requestorDO.setHlfd(tdgDataMaskingDTO.getPage2Q1());
		requestorDO.setDsmech(tdgDataMaskingDTO.getPage2Q2());
		requestorDO.setOdsmech(tdgDataMaskingDTO.getPage2Q3());
		requestorDO.setProdnonprodUpsteam(tdgDataMaskingDTO.getPage2Q4());
		requestorDO.setNonEnglishChar(tdgDataMaskingDTO.getPage2Q5());
		requestorDO.setDfdchart(tdgDataMaskingDTO.getPage2Q6());
		requestorDO.setOatpsource(tdgDataMaskingDTO.getPage2Q7());
		requestorDO.setDsADU(tdgDataMaskingDTO.getPage2Q8());
		requestorDO.setPiiMnpi(tdgDataMaskingDTO.getPage2Q9());
		requestorDO.setMaskNonProd(tdgDataMaskingDTO.getPage2Q10());
		requestorDO.setValMaskData(tdgDataMaskingDTO.getPage2Q11());
		requestorDO.setProdSensElem(tdgDataMaskingDTO.getPage2Q12());

		requestorDO.setNonEngLang(tdgDataMaskingDTO.getPage3Q1());
		requestorDO.setNoOfTable(tdgDataMaskingDTO.getPage3Q2());
		requestorDO.setCountDatabase(tdgDataMaskingDTO.getPage3Q3());
		requestorDO.setDsSchemaChnage(tdgDataMaskingDTO.getPage3Q4());
		requestorDO.setVolDataDataMask(tdgDataMaskingDTO.getPage3Q5());
		requestorDO.setPlaceMaskingStg(tdgDataMaskingDTO.getPage3Q6());
		requestorDO.setNonProdMask(tdgDataMaskingDTO.getPage3Q7());
		requestorDO.setDataMaskDev(tdgDataMaskingDTO.getPage3Q8());
		requestorDO.setDataMaskOngoingSupport(tdgDataMaskingDTO.getPage3Q9());
		requestorDO.setSlaDataMasking(tdgDataMaskingDTO.getPage3Q10());
		requestorDO.setRequestTime(new Timestamp(new Date().getTime()));
		requestorDO.setStatus(TDMConstants.STATUS_SUBMITTED);
		requestorDO.setNoOfApps(tdgDataMaskingDTO.getPage3NoOfApps());

		for (TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO : tdgDataMaskingDTO
				.getTdgDataMaskingNoOfAppsDTOs())
		{
			reqChDO = new ReqChDO();
			reqChDO.setRequestor(requestorDO);
			reqChDO.setPId(requestorDO.getId());
			reqChDO.setAppName(tdgDataMaskingNoOfAppsDTO.getAppName());
			reqChDO.setDbName(tdgDataMaskingNoOfAppsDTO.getDbName());
			reqChDO.setNoOfTable(tdgDataMaskingNoOfAppsDTO.getNoOfTables());
			reqChDOList.add(reqChDO);
		}
		requestorDO.setChngReqCmmt(tdgDataMaskingDTO.getChngReqCmmt());
		requestorDO.setReqChDOs(reqChDOList);

		return requestorDO;
	}

	@Override
	public TdgDataMaskingDTO converDOtoRequestorDTO(List<RequestorDO> requestorDOs)
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a zzz");
		TdgDataMaskingDTO tdgDataMaskingDTO = null;
		List<TdgDataMaskingDTO> tdgDataMaskingDTOList = null;
		if (requestorDOs != null)
		{
			tdgDataMaskingDTOList = new ArrayList<TdgDataMaskingDTO>();
			for (RequestorDO requestorDO : requestorDOs)
			{
				tdgDataMaskingDTO = new TdgDataMaskingDTO();
				tdgDataMaskingDTO.setId(requestorDO.getId());
				tdgDataMaskingDTO.setUserName(requestorDO.getName());
				tdgDataMaskingDTO.setUserId(requestorDO.getUserName());
				tdgDataMaskingDTO.setDeptName(requestorDO.getDepartment());
				tdgDataMaskingDTO.setProjName(requestorDO.getProjectName());
				tdgDataMaskingDTO.setProjPhase(requestorDO.getProjectPhase());
				tdgDataMaskingDTO.setReqTime(format.format(requestorDO.getRequestTime()));
				tdgDataMaskingDTO.setStatus(requestorDO.getStatus());
				tdgDataMaskingDTO.setChngReqCmmt(requestorDO.getChngReqCmmt());
				tdgDataMaskingDTO.setDesc("Masking"
						+ " > "
						+ requestorDO.getEnvironment()
						+ (requestorDO.getProjectName() == null ? "" : " > "
								+ requestorDO.getProjectName())
						+ (requestorDO.getProjectPhase() == null ? "" : " > "
								+ requestorDO.getProjectPhase())
						+ (requestorDO.getNeededby() == null ? "" : " > "
								+ requestorDO.getNeededby()));
				tdgDataMaskingDTOList.add(tdgDataMaskingDTO);
			}
		}
		if (null != tdgDataMaskingDTO)
		{
			tdgDataMaskingDTO.setTdgDataMaskingDTOs(tdgDataMaskingDTOList);
		}
		else
		{
			tdgDataMaskingDTO = new TdgDataMaskingDTO();
		}
		return tdgDataMaskingDTO;
	}

	@Override
	public TdgDataMaskingDTO converDOtoRequestDTOForReqId(Map<RequestorDO, List<ReqChDO>> map)
	{
		TdgDataMaskingDTO tdgDataMaskingDTO = null;
		List<TdgDataMaskingNoOfAppsDTO> tdgDataMaskingNoOfAppsDTOList = null;
		TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO = null;
		RequestorDO requestorDO = null;
		List<ReqChDO> reqChDOList = null;
		if (map != null)
		{
			for (Entry<RequestorDO, List<ReqChDO>> entry : map.entrySet())
			{
				requestorDO = entry.getKey();
				reqChDOList = entry.getValue();
			}
		}
		if (requestorDO != null)
		{
			tdgDataMaskingDTO = new TdgDataMaskingDTO();
			tdgDataMaskingDTO.setId(requestorDO.getId());
			tdgDataMaskingDTO.setUserName(requestorDO.getName());
			tdgDataMaskingDTO.setUserId(requestorDO.getUserName());
			tdgDataMaskingDTO.setEmailId(requestorDO.getEmailid());
			tdgDataMaskingDTO.setPhoneNo(requestorDO.getPhoneno());
			tdgDataMaskingDTO.setDeptName(requestorDO.getDepartment());
			tdgDataMaskingDTO.setNeededBy(requestorDO.getNeededby());
			tdgDataMaskingDTO.setProjName(requestorDO.getProjectName());
			tdgDataMaskingDTO.setProjPhase(requestorDO.getProjectPhase());
			tdgDataMaskingDTO.setEnvType(requestorDO.getEnvironment());

			tdgDataMaskingDTO.setReqTime(requestorDO.getRequestTime().toString());
			tdgDataMaskingDTO.setStatus(requestorDO.getStatus());
			tdgDataMaskingDTO.setPage2Q1(requestorDO.getHlfd());
			tdgDataMaskingDTO.setPage2Q2(requestorDO.getDsmech());
			tdgDataMaskingDTO.setPage2Q3(requestorDO.getOdsmech());
			tdgDataMaskingDTO.setPage2Q4(requestorDO.getProdnonprodUpsteam());
			tdgDataMaskingDTO.setPage2Q5(requestorDO.getNonEnglishChar());
			tdgDataMaskingDTO.setPage2Q6(requestorDO.getDfdchart());
			tdgDataMaskingDTO.setPage2Q7(requestorDO.getOatpsource());
			tdgDataMaskingDTO.setPage2Q8(requestorDO.getDsADU());
			tdgDataMaskingDTO.setPage2Q9(requestorDO.getPiiMnpi());
			tdgDataMaskingDTO.setPage2Q10(requestorDO.getMaskNonProd());
			tdgDataMaskingDTO.setPage2Q11(requestorDO.getValMaskData());
			tdgDataMaskingDTO.setPage2Q12(requestorDO.getProdSensElem());

			tdgDataMaskingDTO.setPage3Q1(requestorDO.getNonEngLang());
			tdgDataMaskingDTO.setPage3Q2(requestorDO.getNoOfTable());
			tdgDataMaskingDTO.setPage3Q3(requestorDO.getCountDatabase());
			tdgDataMaskingDTO.setPage3Q4(requestorDO.getDsSchemaChnage());
			tdgDataMaskingDTO.setPage3Q5(requestorDO.getVolDataDataMask());
			tdgDataMaskingDTO.setPage3Q6(requestorDO.getPlaceMaskingStg());
			tdgDataMaskingDTO.setPage3Q7(requestorDO.getNonProdMask());
			tdgDataMaskingDTO.setPage3Q8(requestorDO.getDataMaskDev());
			tdgDataMaskingDTO.setPage3Q9(requestorDO.getDataMaskOngoingSupport());
			tdgDataMaskingDTO.setPage3Q10(requestorDO.getSlaDataMasking());
			tdgDataMaskingDTO.setPage3NoOfApps(requestorDO.getNoOfApps());
		}

		if (reqChDOList != null)
		{
			tdgDataMaskingNoOfAppsDTOList = new ArrayList<TdgDataMaskingNoOfAppsDTO>();
			for (ReqChDO reqChDO : reqChDOList)
			{
				tdgDataMaskingNoOfAppsDTO = new TdgDataMaskingNoOfAppsDTO();
				tdgDataMaskingNoOfAppsDTO.setAppName(reqChDO.getAppName());
				tdgDataMaskingNoOfAppsDTO.setDbName(reqChDO.getDbName());
				tdgDataMaskingNoOfAppsDTO.setId(String.valueOf(reqChDO.getId()));
				tdgDataMaskingNoOfAppsDTO.setNoOfTables(reqChDO.getNoOfTable());
				tdgDataMaskingNoOfAppsDTOList.add(tdgDataMaskingNoOfAppsDTO);
			}
		}
		tdgDataMaskingDTO.setTdgDataMaskingNoOfAppsDTOs(tdgDataMaskingNoOfAppsDTOList);
		return tdgDataMaskingDTO;
	}

	@Override
	public TdmOnboardReqDO convertTdmOnBoardReqDTOToDO(TdmOnBoardReqDTO tdmOnboardReqDTO, String seq)
	{
		TdmOnboardReqDO tdmOnboardReqDO = null;
		if (null != tdmOnboardReqDTO)
		{
			tdmOnboardReqDO = new TdmOnboardReqDO();
			if (StringUtils.isNotEmpty(tdmOnboardReqDTO.getOnboardReqId()))
			{
				int crNo = tdmOnboardReqDTO.getVno() + 1;
				if (tdmOnboardReqDTO.getOnboardReqId().contains(TDMConstants.CR))
				{
					tdmOnboardReqDO.setOnboardReqId(tdmOnboardReqDTO.getOnboardReqId().replace(
							tdmOnboardReqDTO.getOnboardReqId().substring(
									tdmOnboardReqDTO.getOnboardReqId().indexOf("C"),
									tdmOnboardReqDTO.getOnboardReqId().length()),
							TDMConstants.CR + crNo));
					tdmOnboardReqDTO.setOnboardReqId(tdmOnboardReqDO.getOnboardReqId());
				}
				else
				{
					tdmOnboardReqDO.setOnboardReqId(tdmOnboardReqDTO.getOnboardReqId()
							+ TDMConstants.CR + (tdmOnboardReqDTO.getVno() + 1));
					tdmOnboardReqDTO.setOnboardReqId(tdmOnboardReqDO.getOnboardReqId());
				}
				tdmOnboardReqDO.setVno(tdmOnboardReqDTO.getVno() + 1);
			}
			else
			{
				tdmOnboardReqDO.setOnboardReqId(TDMConstants.TR + seq);
				tdmOnboardReqDO.setVno(0);
			}

			tdmOnboardReqDO.setAppDesc(tdmOnboardReqDTO.getAppDesc());
			tdmOnboardReqDO.setAppName(tdmOnboardReqDTO.getAppName());
			tdmOnboardReqDO.setAppPhase(tdmOnboardReqDTO.getAppPhase());
			tdmOnboardReqDO.setDept(tdmOnboardReqDTO.getDeptName());
			tdmOnboardReqDO.setEmailId(tdmOnboardReqDTO.getEmailId());
			tdmOnboardReqDO.setEnvName(tdmOnboardReqDTO.getEnvType());
			tdmOnboardReqDO.setPhoneNo(tdmOnboardReqDTO.getPhoneNo());
			tdmOnboardReqDO.setUName(tdmOnboardReqDTO.getUserName());
			tdmOnboardReqDO.setUserName(tdmOnboardReqDTO.getUserId());
			tdmOnboardReqDO.setActionBy(tdmOnboardReqDTO.getUserId());
			tdmOnboardReqDO.setActionDt(new Timestamp(new Date().getTime()));
			tdmOnboardReqDO.setStatus(TDMConstants.STATUS_SUBMITTED);

			if (null != tdmOnboardReqDTO.getTdgDataMaskingNoOfAppsDTOs()
					&& 0 < tdmOnboardReqDTO.getTdgDataMaskingNoOfAppsDTOs().size())
			{
				TdmOnboadReqNoTabDO tdmOnboadReqNoTabDO = null;
				List<TdmOnboadReqNoTabDO> tdmOnboadReqNoTabDOs = new ArrayList<TdmOnboadReqNoTabDO>();
				for (TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO : tdmOnboardReqDTO
						.getTdgDataMaskingNoOfAppsDTOs())
				{
					tdmOnboadReqNoTabDO = new TdmOnboadReqNoTabDO();
					tdmOnboadReqNoTabDO.setAppName(tdgDataMaskingNoOfAppsDTO.getAppName());
					tdmOnboadReqNoTabDO.setDbName(tdgDataMaskingNoOfAppsDTO.getDbName());
					tdmOnboadReqNoTabDO.setId(RandomUtils.nextInt());
					tdmOnboadReqNoTabDO.setNoOfTable(tdgDataMaskingNoOfAppsDTO.getNoOfTables());
					tdmOnboadReqNoTabDO.setOnboardReqId(tdmOnboardReqDO.getOnboardReqId());
					tdmOnboadReqNoTabDO.setTdmOnboardReq(tdmOnboardReqDO);
					if (StringUtils.isNotEmpty(tdgDataMaskingNoOfAppsDTO.getAppName()))
					{
						tdmOnboadReqNoTabDOs.add(tdmOnboadReqNoTabDO);
					}
				}
				tdmOnboardReqDO.setTdmOnboadReqNoTabs(tdmOnboadReqNoTabDOs);
			}
		}
		return tdmOnboardReqDO;
	}

	@Override
	public TdmOnBoardReqDTO convertTdmOnboardReqDOToDO(TdmOnboardReqDO tdmOnboardReqDO)
	{
		TdmOnBoardReqDTO tdmOnBoardReqDTO = null;
		if (null != tdmOnboardReqDO)
		{
			tdmOnBoardReqDTO = new TdmOnBoardReqDTO();
			tdmOnBoardReqDTO.setOnboardReqId(tdmOnboardReqDO.getOnboardReqId());
			tdmOnBoardReqDTO.setAppDesc(tdmOnboardReqDO.getAppDesc());
			tdmOnBoardReqDTO.setAppName(tdmOnboardReqDO.getAppName());
			tdmOnBoardReqDTO.setAppPhase(tdmOnboardReqDO.getAppPhase());
			tdmOnBoardReqDTO.setDeptName(tdmOnboardReqDO.getDept());
			tdmOnBoardReqDTO.setEmailId(tdmOnboardReqDO.getEmailId());
			tdmOnBoardReqDTO.setEnvType(tdmOnboardReqDO.getEnvName());
			tdmOnBoardReqDTO.setPhoneNo(tdmOnboardReqDO.getPhoneNo());
			tdmOnBoardReqDTO.setUserName(tdmOnboardReqDO.getUName());
			tdmOnBoardReqDTO.setUserId(tdmOnboardReqDO.getUserName());
			tdmOnBoardReqDTO.setVno(tdmOnboardReqDO.getVno());

			if (null != tdmOnboardReqDO.getTdmOnboadReqNoTabs()
					&& 0 < tdmOnboardReqDO.getTdmOnboadReqNoTabs().size())
			{
				TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO = null;
				List<TdgDataMaskingNoOfAppsDTO> tdgDataMaskingNoOfAppsDTOs = new ArrayList<TdgDataMaskingNoOfAppsDTO>();
				for (TdmOnboadReqNoTabDO tdmOnboadReqNoTabDO : tdmOnboardReqDO
						.getTdmOnboadReqNoTabs())
				{
					tdgDataMaskingNoOfAppsDTO = new TdgDataMaskingNoOfAppsDTO();
					tdgDataMaskingNoOfAppsDTO.setAppName(tdmOnboadReqNoTabDO.getAppName());
					tdgDataMaskingNoOfAppsDTO.setDbName(tdmOnboadReqNoTabDO.getDbName());
					tdgDataMaskingNoOfAppsDTO.setId(String.valueOf(tdmOnboadReqNoTabDO.getId()));
					tdgDataMaskingNoOfAppsDTO.setNoOfTables(tdmOnboadReqNoTabDO.getNoOfTable());
					tdgDataMaskingNoOfAppsDTOs.add(tdgDataMaskingNoOfAppsDTO);
				}
				tdmOnBoardReqDTO.setTdgDataMaskingNoOfAppsDTOs(tdgDataMaskingNoOfAppsDTOs);
			}
		}
		return tdmOnBoardReqDTO;
	}

	@Override
	public List<TdgDataMaskingDTO> converTdmOnboardReqDOtoDTO(List<TdmOnboardReqDO> tdmOnboardReqDOs)
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a zzz");
		TdgDataMaskingDTO tdgDataMaskingDTO = null;
		List<TdgDataMaskingDTO> tdgDataMaskingDTOList = null;
		if (tdmOnboardReqDOs != null && 0 < tdmOnboardReqDOs.size())
		{
			tdgDataMaskingDTOList = new ArrayList<TdgDataMaskingDTO>();
			for (TdmOnboardReqDO tdmOnboardReqDO : tdmOnboardReqDOs)
			{
				tdgDataMaskingDTO = new TdgDataMaskingDTO();
				tdgDataMaskingDTO.setId(tdmOnboardReqDO.getOnboardReqId());
				tdgDataMaskingDTO.setUserName(tdmOnboardReqDO.getUName());
				tdgDataMaskingDTO.setUserId(tdmOnboardReqDO.getUserName());
				tdgDataMaskingDTO.setDeptName(tdmOnboardReqDO.getDept());
				tdgDataMaskingDTO.setProjName(tdmOnboardReqDO.getAppName());
				tdgDataMaskingDTO.setProjPhase(tdmOnboardReqDO.getAppPhase());
				tdgDataMaskingDTO.setReqTime(format.format(tdmOnboardReqDO.getActionDt()));
				tdgDataMaskingDTO.setStatus(tdmOnboardReqDO.getStatus());
				tdgDataMaskingDTO.setDesc(tdmOnboardReqDO.getAppDesc());

				tdgDataMaskingDTOList.add(tdgDataMaskingDTO);
			}

		}

		return tdgDataMaskingDTOList;
	}
}
