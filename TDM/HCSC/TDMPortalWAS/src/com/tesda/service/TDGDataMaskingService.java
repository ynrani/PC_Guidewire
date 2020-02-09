package com.tesda.service;

import java.util.List;

import com.tesda.exception.ServiceException;
import com.tesda.model.DTO.TdgDataMaskingDTO;
import com.tesda.model.DTO.TdmOnBoardReqDTO;

public interface TDGDataMaskingService
{
	public String saveMaskingData(TdgDataMaskingDTO tdgDataMaskingDTO) throws ServiceException;

	public TdgDataMaskingDTO getAllDtMaskRequestedRecord(String userId) throws ServiceException;

	public TdgDataMaskingDTO getDtMaskRequestedRecord(String userId, String reqId)
			throws ServiceException;

	public TdgDataMaskingDTO getAllDtMaskRequestedRecordForPagination(int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, String userId, String type)
			throws ServiceException;

	public Long getReservedRecordsCount(String userId, String type) throws ServiceException;

	public TdgDataMaskingDTO getUserDetails(TdgDataMaskingDTO tdgDataMaskingDTO)
			throws ServiceException;

	public TdmOnBoardReqDTO getUserDetails(String userId, TdmOnBoardReqDTO tdmOnBoardReqDTO)
			throws ServiceException;

	public TdmOnBoardReqDTO getSaveOnboardingReq(TdmOnBoardReqDTO tdmOnboardReqDTO) throws ServiceException;

	public TdmOnBoardReqDTO getEditableDetails(String reqId) throws ServiceException;

	public List<String> getReqIdList(String userId, String reqIdtoken) throws ServiceException;

	public Long getReservedRecordsCountOnBoard(String userId, String type) throws ServiceException;

	public List<TdgDataMaskingDTO> getAllOnBoardRequestedRecordForPagination(int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, String userId, String type)
			throws ServiceException;

}
