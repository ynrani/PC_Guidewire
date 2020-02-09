/*---------------------------------------------------------------------------------------
 * Object Name: TDMNonStandSearchService.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Sridhar Gudipati   16/06/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tesda.service;

import java.util.List;
import java.util.Set;

import com.tesda.exception.ServiceException;
import com.tesda.model.DTO.TDMNonStandReservationDTO;
import com.tesda.model.DTO.TDMNonStandSearchFieldsDTO;
import com.tesda.model.DTO.TDMNonStandardSearchDTO;

public interface TDMNonStandSearchService
{
	public TDMNonStandSearchFieldsDTO getSearchFields() throws ServiceException;

	public TDMNonStandardSearchDTO getNonStandSearchRecords(TDMNonStandardSearchDTO tdm,
			int offSet, int recordsperpage) throws ServiceException;

	public int saveReservedData(TDMNonStandardSearchDTO tdmNonSrchDTO, String userName)
			throws ServiceException;

	public List<TDMNonStandReservationDTO> getReservedRecords(String userId)
			throws ServiceException;

	public int unReserveReservedRecords(TDMNonStandardSearchDTO tdmNonStandSearchDTO, String userId)
			throws ServiceException;

	public Set<String> getAccountNameNumberList(String type, String reqToken)
			throws ServiceException;

	public long getNonStandardSearchRecordCount(TDMNonStandardSearchDTO tdmNonStandSearchDTO,
			String userId) throws ServiceException;
}
