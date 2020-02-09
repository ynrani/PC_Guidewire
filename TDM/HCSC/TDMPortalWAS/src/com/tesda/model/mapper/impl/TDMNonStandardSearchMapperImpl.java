package com.tesda.model.mapper.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DO.TdmSubscriberDetailsDO;
import com.tesda.model.DTO.TDMNonStandardSearchDTO;
import com.tesda.model.DTO.TdmNonStandardSearchResultListDTO;
import com.tesda.model.mapper.TDMNonStandardSearchMapper;

@Component
@Service("tdmNonStandSearchMapper")
public class TDMNonStandardSearchMapperImpl implements TDMNonStandardSearchMapper
{
	@Override
	public List<TdmNonStandardSearchResultListDTO> converTdmSbscrDtlsDOtoTDMNonStandardSearchDTO(
			List<TdmSubscriberDetailsDO> tdmSubscDetailsDo)
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a zzz");
		TdmNonStandardSearchResultListDTO tdmNonStandSearchDTO = null;
		List<TdmNonStandardSearchResultListDTO> tdmNonStandSearchDTOList = null;
		if (tdmSubscDetailsDo != null && 0 < tdmSubscDetailsDo.size())
		{
			tdmNonStandSearchDTOList = new ArrayList<TdmNonStandardSearchResultListDTO>();
			for (TdmSubscriberDetailsDO tdmSubscrDtlsDO : tdmSubscDetailsDo)
			{
				tdmNonStandSearchDTO = new TdmNonStandardSearchResultListDTO();
				tdmNonStandSearchDTO.setAgeGroup(String.valueOf(tdmSubscrDtlsDO.getAge()));
				tdmNonStandSearchDTO.setMemId(String.valueOf(tdmSubscrDtlsDO.getMembrId()));
				tdmNonStandSearchDTO.setAccountName(tdmSubscrDtlsDO.getAccountName());
				tdmNonStandSearchDTO.setMemType(tdmSubscrDtlsDO.getMembrCat());
				tdmNonStandSearchDTO.setFirstName(tdmSubscrDtlsDO.getFirstName());
				tdmNonStandSearchDTO.setLastName(tdmSubscrDtlsDO.getLastName());
				tdmNonStandSearchDTO.setDob(format.format(tdmSubscrDtlsDO.getDob()));
				tdmNonStandSearchDTO.setHomeZipCode(tdmSubscrDtlsDO.getZipCode());
				tdmNonStandSearchDTO.setGroupNum("");
				tdmNonStandSearchDTO.setAcName(tdmSubscrDtlsDO.getAccountName());
				tdmNonStandSearchDTO.setAcNum(String.valueOf(tdmSubscrDtlsDO.getAccountNum()));
				tdmNonStandSearchDTO.setEobSuppressed("");
				tdmNonStandSearchDTO.setBlendGov("");
				tdmNonStandSearchDTO.setBlendGroup("");
				tdmNonStandSearchDTO.setBlendRetail("");
				tdmNonStandSearchDTO.setCoverageCode("");
				tdmNonStandSearchDTO.setExtClaim("");
				tdmNonStandSearchDTO.setSubscId(String.valueOf(tdmSubscrDtlsDO.getSubscriberId()));

				tdmNonStandSearchDTOList.add(tdmNonStandSearchDTO);
			}
		}
		return tdmNonStandSearchDTOList;
	}

	@Override
	public List<TdmReservationDO> converTDMNonStandardSearchDTOtoTdmReservationDO(
			TDMNonStandardSearchDTO tdmNonSrchDTO, String userId)
	{
		List<TdmReservationDO> reservelist = null;
		List<TdmNonStandardSearchResultListDTO> tdmNonStandSearcRsltList = null;
		TdmReservationDO tdmReserveDo = null;
		if ((null != tdmNonSrchDTO && null != tdmNonSrchDTO.getTdmNonStandardSrchResultListDTOs())
				&& 0 < tdmNonSrchDTO.getTdmNonStandardSrchResultListDTOs().size())
		{
			reservelist = new ArrayList<TdmReservationDO>();
			tdmNonStandSearcRsltList = new ArrayList<TdmNonStandardSearchResultListDTO>();
			for (TdmNonStandardSearchResultListDTO dto : tdmNonSrchDTO
					.getTdmNonStandardSrchResultListDTOs())
			{
				if (dto.getReservedYN() != null)
				{
					tdmReserveDo = new TdmReservationDO();
					tdmReserveDo.setSubscrId(dto.getSubscId());
					// tdmReserveDo.set
					tdmReserveDo.setAccountName(dto.getAcName());
					tdmReserveDo.setAccountNum(dto.getAcNum());
					tdmReserveDo.setBlendedCat(null);
					tdmReserveDo.setBlendedGov(null);
					tdmReserveDo.setCoverage(dto.getCoverageCode());
					tdmReserveDo.setDob(dto.getDob());
					tdmReserveDo.setFirstName(dto.getFirstName());
					tdmReserveDo.setLastName(dto.getLastName());
					tdmReserveDo.setExtClaimType(null);
					tdmReserveDo.setLocked("Y");
					tdmReserveDo.setMembrType(dto.getMemType());
					tdmReserveDo.setHomeZipCode(dto.getHomeZipCode());
					tdmReserveDo.setUserId(userId);
					tdmReserveDo.setSuppressEOBInd(null);
					tdmReserveDo.setProjectId(null);
					tdmReserveDo.setRecCreateDate(new Timestamp(new Date().getTime()));
					tdmReserveDo.setUnreservDate(new Timestamp(new Date().getTime()));
					reservelist.add(tdmReserveDo);
				}
				else
				{
					tdmNonStandSearcRsltList.add(dto);
				}
			}
			if (tdmNonStandSearcRsltList != null)
			{
				tdmNonSrchDTO.setTdmNonStandardSrchResultListDTOs(tdmNonStandSearcRsltList);
			}
		}
		return reservelist;
	}
}
