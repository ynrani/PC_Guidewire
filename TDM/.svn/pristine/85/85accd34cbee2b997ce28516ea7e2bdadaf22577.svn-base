package com.tdm.service;

import java.util.List;

import com.tdm.exception.ServiceException;
import com.tdm.model.DTO.TdgDataMaskingDTO;
import com.tdm.model.DTO.TdmOnBoardReqDTO;

public interface TDMDataMaskingService
{
	public TdgDataMaskingDTO getUserDetails(TdgDataMaskingDTO tdgDataMaskingDTO)
			throws ServiceException;

	public TdgDataMaskingDTO saveReqDtls(TdgDataMaskingDTO tdgDataMaskingDTO, boolean page1,
			boolean page2, boolean page3) throws ServiceException;

	public TdgDataMaskingDTO getSavedDtls(TdgDataMaskingDTO tdgDataMaskingDTO, boolean page1,
			boolean page2, boolean page3) throws ServiceException;

	public Long getReservedRecordsCount(String userId, String type) throws ServiceException;

	public TdgDataMaskingDTO getAllDtMaskRequestedRecordForPagination(int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, TdgDataMaskingDTO tdgDataMaskingDTO,
			String type) throws ServiceException;

	public TdgDataMaskingDTO getSavedDtlsforExport(TdgDataMaskingDTO tdgDataMaskingDTO,
			boolean page1, boolean page2, boolean page3, String type) throws ServiceException;

	public List<String> getReqIdList(String userId, String reqIdtoken) throws ServiceException;

	public TdmOnBoardReqDTO getEditableDetails(String reqId) throws ServiceException;

	public TdmOnBoardReqDTO getUserDetails(String attribute, TdmOnBoardReqDTO tdmOnboardReqDTO)
			throws ServiceException;

	public TdmOnBoardReqDTO getSaveOnboardingReq(TdmOnBoardReqDTO tdmOnboardReqDTO)
			throws ServiceException;

	public Long getReservedRecordsCountOnBoard(String attribute, String type)
			throws ServiceException;

	public List<TdgDataMaskingDTO> getAllOnBoardRequestedRecordForPagination(int offSet,
			int recordsperpage, boolean b, String attribute, String type) throws ServiceException;

	public boolean getCheckExistingReqYesNo(TdgDataMaskingDTO tdgDataMaskingDTO)
			throws ServiceException;

	public boolean dtMaskCancelReq(String reqId) throws ServiceException;

	public boolean cancelOnBoardingRequest(String reqId) throws ServiceException;

	public boolean cancelMaskingRequest(String reqId) throws ServiceException;
}
