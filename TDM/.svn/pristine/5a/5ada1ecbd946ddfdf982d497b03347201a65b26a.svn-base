package com.tdm.model.mapper;

import java.util.List;

import com.tdm.exception.ServiceException;
import com.tdm.model.DO.AccountDO;
import com.tdm.model.DO.ReservationDO;
import com.tdm.model.DO.TdmClaimDO;
import com.tdm.model.DO.TdmClaimSrcMastDO;
import com.tdm.model.DO.TdmClaimStatusMastDO;
import com.tdm.model.DO.TdmClaimTypeMastDO;
import com.tdm.model.DO.TdmPosMastDO;
import com.tdm.model.DO.TdmProviderCatMasterDO;
import com.tdm.model.DO.TdmProviderDO;
import com.tdm.model.DO.TdmProviderTypeMasterDO;
import com.tdm.model.DO.TdmReservationDO;
import com.tdm.model.DO.TdmSubscLobMastDO;
import com.tdm.model.DO.TdmSubscStatusMastDO;
import com.tdm.model.DO.TdmSubscTypeMastDO;
import com.tdm.model.DO.TdmSubscriberDO;
import com.tdm.model.DO.TdmTypeOfBillMastDO;
import com.tdm.model.DO.TdmUsStateDO;
import com.tdm.model.DO.TdmUsStateSubDO;
import com.tdm.model.DTO.AccountDTO;
import com.tdm.model.DTO.TDMBankReservationDTO;
import com.tdm.model.DTO.TDMClaimSearchDTO;
import com.tdm.model.DTO.TDMClaimSearchResultListDTO;
import com.tdm.model.DTO.TDMProvSearchDTO;
import com.tdm.model.DTO.TDMProvSearchResultListDTO;
import com.tdm.model.DTO.TDMSubscSearchDTO;
import com.tdm.model.DTO.TDMSubscSearchResultListDTO;
import com.tdm.model.DTO.TdmNonStandSearchDTO;
import com.tdm.model.DTO.TdmNonStandardResultListDTO;

public interface TDMProviderSearchMapper
{

	public List<TDMProvSearchResultListDTO> converTdmProviderDOToFTDProvSearchResultListDTO(
			List<TdmProviderDO> providerDOlist, List<TdmReservationDO> reservationDOs,
			String userName) throws ServiceException;

	public List<TDMSubscSearchResultListDTO> converTdmSubscriberDOTofTDSubscSearchResultListDTO(
			List<TdmSubscriberDO> tdmSubscriberDOList, List<TdmReservationDO> reservationDOs,
			String userName) throws ServiceException;

	public List<TdmReservationDO> converfTDProvSearchResultListDTOToTdmReservationDO(
			List<TDMProvSearchResultListDTO> getfTDProvSearchResultListDTOList, String userName)
			throws ServiceException;

	public List<TdmReservationDO> converTDMSubscSearchResultListDTOToTdmReservationDO(
			List<TDMSubscSearchResultListDTO> tdmSubscSearchResultListDTOList, String userId)
			throws ServiceException;

	public List<TdmReservationDO> converTDMClaimSearchResultListDTOToTdmReservationDO(
			List<TDMClaimSearchResultListDTO> tdmClaimSearchResultListDTOList, String userId)
			throws ServiceException;

	public TDMProvSearchDTO converDOtoDropdown(
			List<TdmProviderTypeMasterDO> tdmProviderTypeParentDOs,
			List<TdmProviderCatMasterDO> tdmProviderCatParentDOs, List<TdmUsStateDO> tdmUsStateDOs,
			TDMProvSearchDTO tDMProvSearchDTO) throws ServiceException;

	public TDMSubscSearchDTO converDOtoDropdownSubcDTO(
			List<TdmSubscTypeMastDO> tdmSubscTypeMastDOs,
			List<TdmSubscStatusMastDO> tdmSubscStatusMastDOs,
			List<TdmUsStateSubDO> tdmUsStateSubDOs, List<TdmSubscLobMastDO> tdmSubscLobMastDOs,
			TDMSubscSearchDTO tDMSubscSearchDTO) throws ServiceException;

	public TDMClaimSearchDTO converDOtoDropdownClaimDTO(
			List<TdmClaimTypeMastDO> tdmClaimTypeMastDOs,
			List<TdmClaimStatusMastDO> tdmClaimStatusMastDOs,
			List<TdmClaimSrcMastDO> tdmClaimSrcMastDOs,
			List<TdmTypeOfBillMastDO> tdmClaimTypeOfBillMastDOs,
			List<TdmPosMastDO> tdmClaimPOSMastDOs, TDMClaimSearchDTO tDMClaimSearchDTO)
			throws ServiceException;

	public List<TDMClaimSearchResultListDTO> convertTdmClaimDOTofTDClaimSearchResultListDTO(
			List<TdmClaimDO> tdmClaimDOList, List<TdmReservationDO> reservationDOs, String userName)
			throws ServiceException;

	public TdmNonStandSearchDTO converDOtoDropdownAll(
			List<TdmProviderTypeMasterDO> tdmProviderTypeParentDOs,
			List<TdmProviderCatMasterDO> tdmProviderCatParentDOs,
			List<TdmSubscTypeMastDO> tdmSubscTypeMastDOs,
			List<TdmSubscStatusMastDO> tdmSubscStatusMastDOs,
			List<TdmSubscLobMastDO> tdmSubscLobMastDOs, List<TdmUsStateDO> tdmUsStateDOs,
			TdmNonStandSearchDTO tdmNonStandSearchDTO,
			List<TdmClaimTypeMastDO> tdmClaimTypeMastDOs,
			List<TdmClaimStatusMastDO> tdmClaimStatusMastDOs,
			List<TdmClaimSrcMastDO> tdmClaimSrcMastDOs, List<TdmPosMastDO> tdmClaimPOSMastDO)
			throws ServiceException;

	public List<TdmNonStandardResultListDTO> converTdmDOsToTdmNonStandardResultListDTO(
			List<TdmProviderDO> providerDOlist, List<TdmSubscriberDO> subscriberDOlist,
			String userName) throws ServiceException;

	public List<AccountDTO> convertAccountDosToAccountDTO(List<AccountDO> accountDo,
			boolean hasCreditcard) throws ServiceException;

	public List<ReservationDO> convertAccountDToReservationDO(AccountDTO accountDtos)
			throws ServiceException;

	public List<TDMBankReservationDTO> convertResvrationDosToReservationDTO(
			List<ReservationDO> reservDos) throws ServiceException;

	public List<ReservationDO> convertbankReservationDTOtoDOs(AccountDTO accountDTO)
			throws ServiceException;
}
