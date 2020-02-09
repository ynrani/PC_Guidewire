package com.tesda.model.mapper;

import java.util.List;
import java.util.Map;

import com.tesda.model.DO.ReqChDO;
import com.tesda.model.DO.RequestorDO;
import com.tesda.model.DO.TdmOnboardReqDO;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DTO.TDMClaimSearchResultListDTO;
import com.tesda.model.DTO.TDMProvSearchResultListDTO;
import com.tesda.model.DTO.TDMSubscSearchResultListDTO;
import com.tesda.model.DTO.TdgDataMaskingDTO;
import com.tesda.model.DTO.TdmOnBoardReqDTO;

public interface TDMProviderSearchMapper
{

	 

	public List<TdmReservationDO> converfTDProvSearchResultListDTOToTdmReservationDO(
			List<TDMProvSearchResultListDTO> getfTDProvSearchResultListDTOList, String userName);

	public List<TdmReservationDO> converTDMSubscSearchResultListDTOToTdmReservationDO(
			List<TDMSubscSearchResultListDTO> tdmSubscSearchResultListDTOList, String userId);

	public List<TdmReservationDO> converTDMClaimSearchResultListDTOToTdmReservationDO(
			List<TDMClaimSearchResultListDTO> tdmClaimSearchResultListDTOList, String userId);
 

	public RequestorDO convertTDGDataMaskRequestToDO(TdgDataMaskingDTO tdgDataMaskingDTO, String seq);

	public TdgDataMaskingDTO converDOtoRequestorDTO(List<RequestorDO> requestorDOs);

	public TdgDataMaskingDTO converDOtoRequestDTOForReqId(Map<RequestorDO, List<ReqChDO>> map);

	public TdmOnboardReqDO convertTdmOnBoardReqDTOToDO(TdmOnBoardReqDTO tdmOnboardReqDTO, String seq);

	public TdmOnBoardReqDTO convertTdmOnboardReqDOToDO(TdmOnboardReqDO tdmOnboardReqDO);

	public List<TdgDataMaskingDTO> converTdmOnboardReqDOtoDTO(List<TdmOnboardReqDO> requestorDOs);

}
