/*---------------------------------------------------------------------------------------
* Object Name: TDMNonStandardSearchMapper.Java
* 
 * Modification Block:
* --------------------------------------------------------------------------------------
* S.No. Name                Date      Bug Fix no. Desc
* --------------------------------------------------------------------------------------
* 1     Seshadri Chowdary   11/04/15  NA          Created
* --------------------------------------------------------------------------------------
*
* Copyright: 2015 <CapGemini>
*---------------------------------------------------------------------------------------*/


package com.tesda.model.mapper;

import java.util.List;

import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DO.TdmSubscriberDetailsDO;
import com.tesda.model.DTO.TDMNonStandReservationDTO;
import com.tesda.model.DTO.TDMNonStandardSearchDTO;
import com.tesda.model.DTO.TdmNonStandardSearchResultListDTO;

public interface TDMNonStandardSearchMapper
{
	List<TdmNonStandardSearchResultListDTO> converTdmSbscrDtlsDOtoTDMNonStandardSearchDTO(
			List<TdmSubscriberDetailsDO> tdmOnboardReqDOs);

	List<TdmReservationDO> converTDMNonStandardSearchDTOtoTdmReservationDO(
			TDMNonStandardSearchDTO tdmNonSrchDTO, String userId);

	List<TDMNonStandReservationDTO> convertReservationDosToResvationDTO(
			List<TdmReservationDO> reservedList);

	List<TdmReservationDO> convertReservationDTOsToResvationDO(
			TDMNonStandardSearchDTO tdmNonStandSearchDTO);
}
