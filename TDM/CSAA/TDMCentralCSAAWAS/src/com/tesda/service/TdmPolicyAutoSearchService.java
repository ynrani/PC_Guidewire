package com.tesda.service;

import com.tesda.exception.ServiceException;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;

public interface TdmPolicyAutoSearchService
{

	public TdmPolicyAutoSearchDTO searchPolicyAutoRecords(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userName) throws ServiceException;

	public int saveReservedData(TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, String userName,
			String enviro) throws ServiceException;

	public Long searchPolicyAutoRecordsCount(TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO,
			String userName) throws ServiceException;

	public TdmPolicyPropertySearchDTO searchPolicyPropRecords(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean b, String userName) throws ServiceException;

	public Long searchPolicyPropRecordsCount(TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			String userName) throws ServiceException;

	public int saveReservedData(TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			String userName, String enviro) throws ServiceException;

	TdmPolicyAutoSearchDTO searchPolicyAutoRecordsByPolicySearch(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userName) throws ServiceException;

	public TdmPolicyPropertySearchDTO searchPolicyPropRecordsByPolicySearch(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean b, String userName) throws ServiceException;

}
