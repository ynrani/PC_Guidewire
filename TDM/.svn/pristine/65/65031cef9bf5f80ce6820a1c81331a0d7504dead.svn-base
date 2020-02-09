package com.tdm.model.mapper;

import java.util.List;

import com.tdm.exception.ServiceException;
import com.tdm.model.DO.TdmWfCreateReqTxDO;
import com.tdm.model.DTO.TdmRequestDTO;
import com.tdm.model.DTO.TdmSearchRequestDTO;

public interface TdmRequestMapper
{

	public TdmRequestDTO converTdmWfCreateReqTxDOToTdmRequestDTO(
			TdmWfCreateReqTxDO tdmWfCreateReqTxDO) throws ServiceException;

	public TdmWfCreateReqTxDO converTdmRequestDTOToTdmWfCreateReqTxDO(TdmRequestDTO tdmRequestDTO,
			String seq) throws ServiceException;

	public List<TdmSearchRequestDTO> converTdmWfCreateReqTxDOToTdmSearchRequestDTO(
			List<TdmWfCreateReqTxDO> reqList) throws ServiceException;

}
