package com.tdm.service;

import java.util.List;

import com.tdm.exception.ServiceException;
import com.tdm.model.DTO.TdmPolicyAutoSearchDTO;
import com.tdm.model.DTO.TdmPolicyPropertySearchDTO;
import com.tdm.model.DTO.TdmReqTestDataDTO;

public interface TdmPolicyAutoPropSearchService
{

	public int saveReservedData(TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, String userName, String enviro)
			throws ServiceException;

	public int saveReservedData(TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, String userName, String enviro)
			throws ServiceException;

	public TdmPolicyAutoSearchDTO searchPolicyAutoRecordsByPolicySearchNew(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, int recordsperpage, boolean pageNationOnOffFlag,
			String userName) throws ServiceException;

	public TdmPolicyPropertySearchDTO searchPolicyPropRecordsByPolicySearchNew(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userName) throws ServiceException;

	public String savereqTestData(TdmReqTestDataDTO tdmReqTestDataDTO) throws ServiceException;

	public List<TdmReqTestDataDTO> allReqTestData(String userId, int offSet, int recordsperpage, boolean b)
			throws ServiceException;

	public Long allReqTestDataCount(String userId) throws ServiceException;

	public TdmReqTestDataDTO editReqTestData(String userName) throws ServiceException;

}
