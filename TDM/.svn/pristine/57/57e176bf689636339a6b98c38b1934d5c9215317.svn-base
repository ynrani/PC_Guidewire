package com.tdm.model.mapper;

import java.util.List;

import com.tdm.model.DO.PolicySummaryStg;
import com.tdm.model.DO.TdmReqTestDataDO;
import com.tdm.model.DO.TdmReservationDO;
import com.tdm.model.DTO.TdmPolicyAutoSearchDTO;
import com.tdm.model.DTO.TdmPolicyAutoSearchResultDTO;
import com.tdm.model.DTO.TdmPolicyPropertySearchDTO;
import com.tdm.model.DTO.TdmPolicyPropertySearchResultDTO;
import com.tdm.model.DTO.TdmReqTestDataDTO;

public interface TdmPolicyAutoPropSearchMapper
{

	// /Reservation

	public List<TdmPolicyPropertySearchResultDTO> converPolicysummaryToTdmPolicyPropertySearchDTONew(
			List<PolicySummaryStg> policySummaryStgDOs, TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			List<TdmReservationDO> reservationDOs, String userName);

	public List<TdmPolicyAutoSearchResultDTO> converPolicysummaryToTdmPolicyAutoSearchResultDTONew(
			List<PolicySummaryStg> policySummaryStgDOs, TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO,
			List<TdmReservationDO> reservationDOs, String userName);

	public List<TdmReservationDO> converTdmPolicyAutoSearchResultDTOToTdmReservationDO(
			List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOList, String searchcriti, String userName,
			String enviro);

	public List<TdmReservationDO> converTdmPolicyPropertySearchDTOToTdmReservationDO(
			List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchResultDTOList, String searchcriti,
			String userName, String enviro);

	public List<TdmPolicyAutoSearchResultDTO> converTdmReservationDOToFTdmPolicyAutoSearchResultDTO(
			List<TdmReservationDO> tdmReservationDOlist, String userName, TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO);

	public List<TdmPolicyPropertySearchResultDTO> converTdmReservationDOToTdmPolicyPropertySearchDTO(
			List<TdmReservationDO> tdmReservationDOlist, String userName);

	public TdmReqTestDataDO convertdmReqTestDataDTOTotdmReqTestDataDO(TdmReqTestDataDTO tdmReqTestDataDTO);

	public List<TdmReqTestDataDTO> convertdmReqTestDataDOsTotdmReqTestDataDTOs(List<TdmReqTestDataDO> tdmReqTestDataDOs);

	public TdmReqTestDataDTO convertdmReqTestDataDOTotdmReqTestDataDTO(TdmReqTestDataDO tdmReqTestDataDO);

}
