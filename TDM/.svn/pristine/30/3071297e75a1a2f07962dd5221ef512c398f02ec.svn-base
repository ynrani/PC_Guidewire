package com.tdm.model.mapper.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tdm.exception.ServiceException;
import com.tdm.model.DO.TdmWfCreateReqTxDO;
import com.tdm.model.DTO.TdmRequestDTO;
import com.tdm.model.DTO.TdmSearchRequestDTO;
import com.tdm.model.mapper.TdmRequestMapper;

@Component
@Service("tdmRequestMapper")
public class TdmRequestMapperImpl implements TdmRequestMapper {

	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a zzz");

	@Override
	public TdmRequestDTO converTdmWfCreateReqTxDOToTdmRequestDTO(TdmWfCreateReqTxDO tdmWfCreateReqTxDO)
			throws ServiceException {
		TdmRequestDTO tdmRequestDTO = null;
		if (null != tdmWfCreateReqTxDO) {
			tdmRequestDTO = new TdmRequestDTO();

			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getReqId())) {
				tdmRequestDTO.setId(tdmWfCreateReqTxDO.getReqId());
			}

			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getProjName())) {
				tdmRequestDTO.setProjName(tdmWfCreateReqTxDO.getProjName());
			}

			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getProjNo())) {
				tdmRequestDTO.setProjNum(tdmWfCreateReqTxDO.getProjNo());
			}

			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getApplication())) {
				tdmRequestDTO.setApp(tdmWfCreateReqTxDO.getApplication());
			}

			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getActionBy())) {
				tdmRequestDTO.setUserId(tdmWfCreateReqTxDO.getActionBy());
			}

			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getDomainArea())) {
				tdmRequestDTO.setDomainArea(tdmWfCreateReqTxDO.getDomainArea());
			}
			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getCiSimpli())) {
				if ("Y".equalsIgnoreCase(tdmWfCreateReqTxDO.getCiSimpli())) {
					tdmRequestDTO.setCi("Yes");
				} else {
					tdmRequestDTO.setCi("No");
				}
			}

			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getAddiDtl())) {
				tdmRequestDTO.setAddiInfo(tdmWfCreateReqTxDO.getAddiDtl());
			}
			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getProjFolder())) {
				tdmRequestDTO.setProjFolder(tdmWfCreateReqTxDO.getProjFolder());
			}
			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getPriority())) {
				tdmRequestDTO.setPriority(tdmWfCreateReqTxDO.getPriority());
			}
			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getRequestor())) {
				tdmRequestDTO.setRequestor(tdmWfCreateReqTxDO.getRequestor());
			}
			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getTdmPriority())) {
				tdmRequestDTO.setTdmPriority(tdmWfCreateReqTxDO.getTdmPriority());
			}
			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getEstimate())) {
				tdmRequestDTO.setEstimate(tdmWfCreateReqTxDO.getEstimate());
			}
			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getTdmPhase())) {
				tdmRequestDTO.setTdmPhase(tdmWfCreateReqTxDO.getTdmPhase());
			}
			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getReqType())) {
				tdmRequestDTO.setReqType(tdmWfCreateReqTxDO.getReqType());
			}
			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getReqCateg())) {
				tdmRequestDTO.setReqCategory(tdmWfCreateReqTxDO.getReqCateg());
			}
			if (StringUtils.isNotEmpty(tdmWfCreateReqTxDO.getSts())) {
				tdmRequestDTO.setSts(tdmWfCreateReqTxDO.getSts());
			}

		}
		return tdmRequestDTO;
	}

	@Override
	public TdmWfCreateReqTxDO converTdmRequestDTOToTdmWfCreateReqTxDO(TdmRequestDTO tdmRequestDTO, String seq)
			throws ServiceException {
		TdmWfCreateReqTxDO tdmWfCreateReqTxDO = null;
		if (null != tdmRequestDTO) {
			tdmWfCreateReqTxDO = new TdmWfCreateReqTxDO();

			if (StringUtils.isNotEmpty(tdmRequestDTO.getId())) {
				tdmWfCreateReqTxDO.setVno(tdmRequestDTO.getVno() + 1);
				tdmWfCreateReqTxDO.setReqId(tdmRequestDTO.getId());
				tdmWfCreateReqTxDO.setUpActionDt(new Timestamp(new Date().getTime()));
			} else {
				tdmWfCreateReqTxDO.setCreActionDt(new Timestamp(new Date().getTime()));
				tdmWfCreateReqTxDO.setReqId("R" + seq);
				tdmWfCreateReqTxDO.setSts("Submitted");
				tdmWfCreateReqTxDO.setVno(tdmRequestDTO.getVno());
			}

			if (StringUtils.isNotEmpty(tdmRequestDTO.getUserId())) {
				tdmWfCreateReqTxDO.setActionBy(tdmRequestDTO.getUserId());
			}

			if (StringUtils.isNotEmpty(tdmRequestDTO.getProjName())) {
				tdmWfCreateReqTxDO.setProjName(tdmRequestDTO.getProjName());
			}
			if (StringUtils.isNotEmpty(tdmRequestDTO.getProjNum())) {
				tdmWfCreateReqTxDO.setProjNo(tdmRequestDTO.getProjNum());
			}
			if (StringUtils.isNotEmpty(tdmRequestDTO.getDomainArea())) {
				tdmWfCreateReqTxDO.setDomainArea(tdmRequestDTO.getDomainArea());
			}
			if (StringUtils.isNotEmpty(tdmRequestDTO.getCi())) {
				if ("Yes".equalsIgnoreCase(tdmRequestDTO.getCi())) {
					tdmWfCreateReqTxDO.setCiSimpli("Y");
				} else {
					tdmWfCreateReqTxDO.setCiSimpli("N");
				}
			}
			if (StringUtils.isNotEmpty(tdmRequestDTO.getApp())) {
				tdmWfCreateReqTxDO.setApplication(tdmRequestDTO.getApp());
			}

			if (StringUtils.isNotEmpty(tdmRequestDTO.getAddiInfo())) {
				tdmWfCreateReqTxDO.setAddiDtl(tdmRequestDTO.getAddiInfo());
			}
			if (StringUtils.isNotEmpty(tdmRequestDTO.getProjFolder())) {
				tdmWfCreateReqTxDO.setProjFolder(tdmRequestDTO.getProjFolder());
			}
			if (StringUtils.isNotEmpty(tdmRequestDTO.getPriority())) {
				tdmWfCreateReqTxDO.setPriority(tdmRequestDTO.getPriority());
			}
			if (StringUtils.isNotEmpty(tdmRequestDTO.getRequestor())) {
				tdmWfCreateReqTxDO.setRequestor(tdmRequestDTO.getRequestor());
			}
			if (StringUtils.isNotEmpty(tdmRequestDTO.getTdmPriority())) {
				tdmWfCreateReqTxDO.setTdmPriority(tdmRequestDTO.getTdmPriority());
			}
			if (StringUtils.isNotEmpty(tdmRequestDTO.getEstimate())) {
				tdmWfCreateReqTxDO.setEstimate(tdmRequestDTO.getEstimate());
			}
			if (StringUtils.isNotEmpty(tdmRequestDTO.getTdmPhase())) {
				tdmWfCreateReqTxDO.setTdmPhase(tdmRequestDTO.getTdmPhase());
			}
			if (StringUtils.isNotEmpty(tdmRequestDTO.getReqType())) {
				tdmWfCreateReqTxDO.setReqType(tdmRequestDTO.getReqType());
			}
			if (StringUtils.isNotEmpty(tdmRequestDTO.getReqCategory())) {
				tdmWfCreateReqTxDO.setReqCateg(tdmRequestDTO.getReqCategory());
			}

			if (null != tdmRequestDTO.getFile()) {
				tdmWfCreateReqTxDO.setFileYn("Y");
				tdmWfCreateReqTxDO.setFileName(tdmRequestDTO.getFile().getOriginalFilename());
				tdmWfCreateReqTxDO.setFileCon(tdmRequestDTO.getFile().getBytes());
			} else {
				tdmWfCreateReqTxDO.setFileYn("N");
			}

		}
		return tdmWfCreateReqTxDO;
	}

	@Override
	public List<TdmSearchRequestDTO> converTdmWfCreateReqTxDOToTdmSearchRequestDTO(List<TdmWfCreateReqTxDO> reqList)
			throws ServiceException {

		List<TdmSearchRequestDTO> tdmSearchRequestDTOs = null;
		TdmSearchRequestDTO tdmSearchRequestDTO = null;
		if (null != reqList && 0 < reqList.size()) {
			tdmSearchRequestDTOs = new ArrayList<TdmSearchRequestDTO>();

			for (TdmWfCreateReqTxDO tdmWfCreateReqTxDO : reqList) {
				tdmSearchRequestDTO = new TdmSearchRequestDTO();

				tdmSearchRequestDTO.setId(tdmWfCreateReqTxDO.getReqId());

				tdmSearchRequestDTO.setDomainArea(tdmWfCreateReqTxDO.getDomainArea());
				tdmSearchRequestDTO.setApp(tdmWfCreateReqTxDO.getApplication());
				tdmSearchRequestDTO.setSts(tdmWfCreateReqTxDO.getSts());
				tdmSearchRequestDTO.setProjName(tdmWfCreateReqTxDO.getProjName());
				tdmSearchRequestDTO.setProjNum(tdmWfCreateReqTxDO.getProjNo());
				tdmSearchRequestDTO.setRequestor(tdmWfCreateReqTxDO.getRequestor());
				tdmSearchRequestDTO.setSts(tdmWfCreateReqTxDO.getSts());
				tdmSearchRequestDTO.setCreatedDate(format.format(tdmWfCreateReqTxDO.getCreActionDt()));

				tdmSearchRequestDTOs.add(tdmSearchRequestDTO);
			}

		}
		return tdmSearchRequestDTOs;
	}
}
