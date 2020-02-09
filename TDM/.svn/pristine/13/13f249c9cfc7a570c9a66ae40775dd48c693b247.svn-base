package com.tdm.service;

import java.util.List;

import com.tdm.exception.ServiceException;
import com.tdm.model.DTO.TdmRequestDTO;
import com.tdm.model.DTO.TdmSearchRequestDTO;

public interface TdmRequestService {

	public String createReq(TdmRequestDTO tdmRequestDTO) throws ServiceException;

	public TdmRequestDTO updateReq(TdmRequestDTO tdmRequestDTO) throws ServiceException;

	public List<TdmRequestDTO> selectReq(TdmRequestDTO tdmRequestDTO, int offSet, int recordsperpage, boolean b)
			throws ServiceException;

	public List<TdmRequestDTO> selectSearchReq(TdmSearchRequestDTO tdmSearchRequestDTO, int offSet, int recordsperpage,
			boolean b) throws ServiceException;

	public boolean deleteReq(String reqId) throws ServiceException;

	public Long reqListCount(String userId) throws ServiceException;

	public List<TdmSearchRequestDTO> reqList(int offSet, int recordsperpage, boolean b, String attribute)
			throws ServiceException;

	public TdmRequestDTO selectRecord(String reqId) throws ServiceException;

	public TdmSearchRequestDTO searchReq(TdmSearchRequestDTO tdmSearchRequestDTO, int offSet, int recordsperpage,
			boolean b) throws ServiceException;

	public Long searchReqCnt(TdmSearchRequestDTO tdmSearchRequestDTO) throws ServiceException;

}
