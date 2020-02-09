package com.tesda.service;

import com.tesda.exception.ServiceException;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;

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
