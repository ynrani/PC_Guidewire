package com.tdm.service;

import com.tdm.exception.ServiceException;
import com.tdm.model.DTO.TdmPolicyAutoSearchDTO;
import com.tdm.model.DTO.TdmPolicyPropertySearchDTO;

public interface TdmMyReservationService
{

	public TdmPolicyAutoSearchDTO getReservedRecordForUser(String userId, int offSet,
			int recordsperpage, boolean b) throws ServiceException;

	public Long getReservedRecordsCount(String searchType, String userId) throws ServiceException;

	public boolean unReservedRecordForUser(Long valueOf) throws ServiceException;

	public TdmPolicyPropertySearchDTO getReservedRecordForUserProperty(String userId, int offSet,
			int recordsperpage, boolean b) throws ServiceException;

	public boolean unReservedRecordForUser(String parameter) throws ServiceException;

}
