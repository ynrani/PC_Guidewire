package com.tdm.service;

import java.util.List;

import com.tdm.exception.ServiceException;
import com.tdm.model.DTO.ForgotPassword;
import com.tdm.model.DTO.POLOSearchDTO;
import com.tdm.model.DTO.PoloReservationDTO;
import com.tdm.model.DTO.TDMClaimSearchDTO;
import com.tdm.model.DTO.TDMProvSearchDTO;
import com.tdm.model.DTO.TDMSubscSearchDTO;
import com.tdm.model.DTO.TdmNonStandSearchDTO;

public interface TDMProviserSearchService
{

	public Boolean forgotPassword(ForgotPassword forgotPasswordDTO) throws ServiceException;

	public TDMProvSearchDTO searchProviderRecords(TDMProvSearchDTO tDMProvSearchDTO, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, String userName)
			throws ServiceException;

	public int saveReservedData(TDMProvSearchDTO tDMProvSearchDTO, String userName)
			throws ServiceException;

	public TDMProvSearchDTO getReservedRecordForUser(String userId, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag) throws ServiceException;

	public Boolean unReservedRecordForUser(Long providerId) throws ServiceException;

	public Long searchProviderRecordsCount(TDMProvSearchDTO tDMProvSearchDTO, String userName)
			throws ServiceException;

	public Long searchSubscrRecordsCount(TDMSubscSearchDTO tDMSubscSearchDTO, String userName)
			throws ServiceException;

	public int saveReservedData(TDMSubscSearchDTO tDMSubscSearchDTO) throws ServiceException;

	public TDMSubscSearchDTO searchSubscRecords(TDMSubscSearchDTO tDMSubscSearchDTO, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, String userName)
			throws ServiceException;

	public TDMProvSearchDTO dropdownValues(TDMProvSearchDTO tDMProvSearchDTO)
			throws ServiceException;

	public List<String> dropdownSpecialty(String value) throws ServiceException;

	public TDMSubscSearchDTO getReservedRecordForUserSubc(String userId, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag) throws ServiceException;

	public TDMSubscSearchDTO dropdownValuesSubsc(TDMSubscSearchDTO tDMSubscSearchDTO)
			throws ServiceException;

	public Long searchClaimRecordsCount(TDMClaimSearchDTO tDMClaimSearchDTO, String userName)
			throws ServiceException;

	public int saveReservedData(TDMClaimSearchDTO tDMClaimSearchDTO) throws ServiceException;

	public TDMClaimSearchDTO searchClaimRecords(TDMClaimSearchDTO tDMClaimSearchDTO, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, String userName)
			throws ServiceException;

	public TDMClaimSearchDTO getReservedRecordForUserClaim(String userId, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag) throws ServiceException;

	public TDMClaimSearchDTO dropdownValuesClaim(TDMClaimSearchDTO tDMClaimSearchDTO)
			throws ServiceException;

	public TdmNonStandSearchDTO getAllDropdownValues(TdmNonStandSearchDTO tdmNonStandSearchDTO)
			throws ServiceException;

	public TdmNonStandSearchDTO searcNonStandRecords(TdmNonStandSearchDTO tdmNonStandSearchDTO,
			int offSet, int recordsperpage, boolean b, String userName) throws ServiceException;

	public Long searchNonStandRecordsCount(TdmNonStandSearchDTO tdmNonStandSearchDTO,
			String userName) throws ServiceException;

	public int saveReservedDataNonStand(TdmNonStandSearchDTO tdmNonStandSearchDTO, String userName)
			throws ServiceException;

	public Long getReservedRecordsCount(String searchType, String userId) throws ServiceException;

	public POLOSearchDTO getPOloSearchRecords(POLOSearchDTO psDTO) throws ServiceException;

	public POLOSearchDTO unresrvePoloRecord(POLOSearchDTO poloDTO) throws ServiceException;

	public int reservePoloRecords(POLOSearchDTO poloDTO, String userID) throws ServiceException;

	public List<PoloReservationDTO> getReservedRecords(String username) throws ServiceException;

	public int unReserveReservedPoloRecords(POLOSearchDTO poloDTO, String userName)
			throws ServiceException;
}
