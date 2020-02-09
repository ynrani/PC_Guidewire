package com.tdm.service;

import com.tdm.exception.ServiceException;
import com.tdm.model.DTO.TdmPolicyClaimSearchDTO;
import com.tdm.model.DTO.TdmPolicySearchDTO;

public interface TdmPolicySearchService
{

	public TdmPolicySearchDTO searchPolicyRecords(TdmPolicySearchDTO tdmPolicySearchDTO,
			int offSet, int recordsperpage, boolean pageNationOnOffFlag, String userName)
			throws ServiceException;

	public Long searchPolicyRecordsCount(TdmPolicySearchDTO tdmPolicySearchDTO, String userName)
			throws ServiceException;

	public TdmPolicyClaimSearchDTO searchClaimRecords(
			TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userName) throws ServiceException;

	public Long searchClaimRecordsCount(TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO,
			String userName) throws ServiceException;

	public int saveReservedData(TdmPolicySearchDTO tdmPolicySearchDTO, String userName)
			throws ServiceException;

	public int saveReservedData(TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO, String userName)
			throws ServiceException;

	public TdmPolicySearchDTO getReservedRecordForUser(String userId, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag) throws ServiceException;

	public TdmPolicyClaimSearchDTO getReservedRecordForUserClaim(String userId, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag) throws ServiceException;

	public Long getReservedRecordsCount(String searchType, String userId) throws ServiceException;

	public Boolean unReservedRecordForUser(String policyNo) throws ServiceException;

}
