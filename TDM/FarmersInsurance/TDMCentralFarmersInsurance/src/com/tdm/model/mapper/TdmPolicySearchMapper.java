package com.tdm.model.mapper;

import java.util.List;

import com.tdm.exception.ServiceException;
import com.tdm.model.DO.CcPolicyDO;
import com.tdm.model.DO.MetlifeClaimDO;
import com.tdm.model.DO.MetlifePolicyDO;
import com.tdm.model.DO.PcPolicyDO;
import com.tdm.model.DO.TdmReservationDO;
import com.tdm.model.DTO.TdmClaimSearchResultDTO;
import com.tdm.model.DTO.TdmPolicySearchResultDTO;

public interface TdmPolicySearchMapper
{

	public List<TdmPolicySearchResultDTO> converObjectToTdmPolicySearchResultDTO(
			List<MetlifePolicyDO> pcPolicyDOs, List<TdmReservationDO> reservationDOs, String userId)
			throws ServiceException;

	public List<TdmPolicySearchResultDTO> converPcPolicyDOToTdmPolicySearchResultDTO(
			List<PcPolicyDO> pcPolicyDOs, List<TdmReservationDO> reservationDOs, String userId)
			throws ServiceException;

	public List<TdmClaimSearchResultDTO> converCcPolicyDOToTdmPolicySearchResultDTO(
			List<CcPolicyDO> ccPolicyDOs, List<TdmReservationDO> reservationDOs, String userId)
			throws ServiceException;

	public List<TdmReservationDO> converTdmPolicySearchResultDTOToTdmReservationDO(
			List<TdmPolicySearchResultDTO> tdmPolicySearchResultDTOs, String userName)
			throws ServiceException;

	public List<TdmReservationDO> converTdmClaimSearchResultDTOToTdmReservationDO(
			List<TdmClaimSearchResultDTO> tdmClaimSearchResultDTOs, String userId)
			throws ServiceException;

	public List<TdmClaimSearchResultDTO> converObjectToTdmClaimSearchResultDTO(
			List<MetlifeClaimDO> ccPolicyDOs, List<TdmReservationDO> reservationDOs, String userId)
			throws ServiceException;

}
