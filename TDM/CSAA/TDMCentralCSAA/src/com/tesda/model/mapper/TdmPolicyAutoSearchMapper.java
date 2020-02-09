package com.tesda.model.mapper;

import java.util.List;

import com.tesda.model.DO.CassPolListDO;
import com.tesda.model.DO.PolicysummaryDO;
import com.tesda.model.DO.TdmPolicySearchDO;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DTO.TdmAutoSearchResultDTO;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyAutoSearchResultDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchResultDTO;

// import com.tesda.model.DO.Policysummary;

public interface TdmPolicyAutoSearchMapper
{

	// /Reservation
	List<TdmPolicyAutoSearchResultDTO> converTdmReservationDOToFTdmPolicyAutoSearchResultDTO(
			List<TdmReservationDO> providerDOlist, String userName,
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO);

	List<TdmPolicyPropertySearchResultDTO> converTdmReservationDOToTdmPolicyPropertySearchDTO(
			List<TdmReservationDO> hoPolicyDOlist, String userName);

	List<TdmReservationDO> converTdmPolicyAutoSearchResultDTOToTdmReservationDO(
			List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTOList,
			String searchcriti, String userName, String enviro);

	List<TdmPolicyPropertySearchResultDTO> converPolicysummaryToTdmPolicyPropertySearchDTO(
			List<PolicysummaryDO> hoPolicyDOlist, List<TdmReservationDO> reservationDOs,
			String userName, TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			List<Object[]> riskCovList, List<CassPolListDO> cassPolListDOs);

	List<TdmReservationDO> converTdmPolicyPropertySearchDTOToTdmReservationDO(
			List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchResultDTOList,
			String searchcriti, String userName, String enviro);

	List<TdmPolicyAutoSearchResultDTO> converPolicysummaryToFTdmPolicyAutoSearchResultDTO(
			TdmAutoSearchResultDTO tdmAutoSearchResultDTO, List<TdmReservationDO> reservationDOs,
			String userName, TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, List<Object[]> covList,
			List<Object[]> riskCovList, List<CassPolListDO> cassPolListDOs);

	List<TdmPolicyAutoSearchResultDTO> converPolicysummaryToFTdmPolicyAutoSearchResultDTO(
			List<Object[]> listPolicySearchDo, TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO);

	List<TdmPolicyPropertySearchResultDTO> converPolicysummaryToTdmPolicyPropertySearchDTO(
			List<TdmPolicySearchDO> propPolicyDOlist,
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO);

	List<TdmPolicyAutoSearchResultDTO> converPolicysummaryToFTdmPolicyAutoSearchResultDTONew(
			List<TdmPolicySearchDO> listPolicySearchDo,
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO);

}
