package com.tesda.model.mapper;

import java.util.List;

import com.tesda.model.DO.PolicySummaryStg;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyAutoSearchResultDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchResultDTO;

public interface TdmPolicyAutoPropSearchMapper
{

	// /Reservation

	public List<TdmPolicyPropertySearchResultDTO> converPolicysummaryToTdmPolicyPropertySearchDTONew(
			List<PolicySummaryStg> policySummaryStgDOs,
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO);

	public List<TdmPolicyAutoSearchResultDTO> converPolicysummaryToTdmPolicyAutoSearchResultDTONew(
			List<PolicySummaryStg> policySummaryStgDOs,
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO);

	public List<TdmReservationDO> converTdmPolicyAutoSearchResultDTOToTdmReservationDO(
			List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOList,
			String searchcriti, String userName, String enviro);

	public List<TdmReservationDO> converTdmPolicyPropertySearchDTOToTdmReservationDO(
			List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchResultDTOList,
			String searchcriti, String userName, String enviro);

	public List<TdmPolicyAutoSearchResultDTO> converTdmReservationDOToFTdmPolicyAutoSearchResultDTO(
			List<TdmReservationDO> tdmReservationDOlist, String userName,
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO);

	public List<TdmPolicyPropertySearchResultDTO> converTdmReservationDOToTdmPolicyPropertySearchDTO(
			List<TdmReservationDO> tdmReservationDOlist, String userName);

}
