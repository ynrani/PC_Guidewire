package com.tesda.model.mapper;

import java.util.List;

import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DO.TdmSubscriberDetailsDO;
import com.tesda.model.DTO.TDMNonStandardSearchDTO;
import com.tesda.model.DTO.TdmNonStandardSearchResultListDTO;

public interface TDMNonStandardSearchMapper
{
	List<TdmNonStandardSearchResultListDTO> converTdmSbscrDtlsDOtoTDMNonStandardSearchDTO(
			List<TdmSubscriberDetailsDO> tdmOnboardReqDOs);

	List<TdmReservationDO> converTDMNonStandardSearchDTOtoTdmReservationDO(
			TDMNonStandardSearchDTO tdmNonSrchDTO, String userId);
}
