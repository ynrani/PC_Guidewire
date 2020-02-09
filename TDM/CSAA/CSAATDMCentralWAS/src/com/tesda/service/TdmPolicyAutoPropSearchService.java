package com.tesda.service;

import com.tesda.exception.ServiceException;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;

public interface TdmPolicyAutoPropSearchService
{

	public int saveReservedData(TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, String userName,
			String enviro) throws ServiceException;

	public int saveReservedData(TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			String userName, String enviro) throws ServiceException;

	public TdmPolicyAutoSearchDTO searchPolicyAutoRecordsByPolicySearchNew(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userName) throws ServiceException;

	public TdmPolicyPropertySearchDTO searchPolicyPropRecordsByPolicySearchNew(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userName) throws ServiceException;

}
