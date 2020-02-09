package com.tdm.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.tdm.exception.DAOException;
import com.tdm.model.DO.TdmClaimDO;
import com.tdm.model.DO.TdmClaimSrcMastDO;
import com.tdm.model.DO.TdmClaimStatusMastDO;
import com.tdm.model.DO.TdmClaimTypeMastDO;
import com.tdm.model.DO.TdmPosMastDO;
import com.tdm.model.DO.TdmProviderCatMasterDO;
import com.tdm.model.DO.TdmProviderDO;
import com.tdm.model.DO.TdmProviderSpecMasterDO;
import com.tdm.model.DO.TdmProviderTypeMasterDO;
import com.tdm.model.DO.TdmReservationDO;
import com.tdm.model.DO.TdmSubscLobMastDO;
import com.tdm.model.DO.TdmSubscStatusMastDO;
import com.tdm.model.DO.TdmSubscTypeMastDO;
import com.tdm.model.DO.TdmSubscriberDO;
import com.tdm.model.DO.TdmTypeOfBillMastDO;
import com.tdm.model.DO.TdmUsStateDO;
import com.tdm.model.DO.TdmUsStateSubDO;
import com.tdm.model.DO.TdmUserDO;
import com.tdm.model.DO.ZurichMasterDO;
import com.tdm.model.DO.ZurichReservationDO;
import com.tdm.model.DTO.POLOSearchDTO;
import com.tdm.model.DTO.TDMClaimSearchDTO;
import com.tdm.model.DTO.TDMProvSearchDTO;
import com.tdm.model.DTO.TDMSubscSearchDTO;

public interface TDMProviserSearchDAO
{

	public List<TdmProviderDO> searchProviderRecords(TDMProvSearchDTO tDMProvSearchDTO, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, List<Long> providersIds,
			EntityManager managerProv) throws DAOException;

	public List<TdmProviderDO> getProviderRecords(List<Long> providerIds, EntityManager managerProv)
			throws DAOException;

	public Long searchProviderRecordsCount(TDMProvSearchDTO tDMProvSearchDTO,
			List<Long> providersIds, EntityManager managerProv) throws DAOException;

	public List<TdmProviderCatMasterDO> getProviderCatDropDown(EntityManager managerProv)
			throws DAOException;

	public List<TdmProviderSpecMasterDO> getProviderSpecDropDown(long catId,
			EntityManager managerProv) throws DAOException;

	public List<TdmProviderTypeMasterDO> getProviderTypeDropDown(EntityManager managerProv)
			throws DAOException;

	public List<TdmUsStateDO> getProviderStateDropDown(EntityManager managerProv)
			throws DAOException;

	public List<String> dropdownSpecialty(String value, EntityManager managerProvs)
			throws DAOException;

	public List<TdmSubscriberDO> searchSubscRecords(TDMSubscSearchDTO tDMSubscSearchDTO,
			int offSet, int recordsperpage, boolean pageNationOnOffFlag,
			List<String> subscriberIds, EntityManager managerSubsc) throws DAOException;

	public List<TdmSubscriberDO> getSubscriberRecords(List<String> subcriberIds,
			EntityManager managerSubsc) throws DAOException;

	public Long searchSubscrRecordsCount(TDMSubscSearchDTO tDMSubscSearchDTO,
			List<String> subscriberIds, EntityManager managerSubsc) throws DAOException;

	public List<TdmSubscTypeMastDO> getSubscTypeDropDown(EntityManager managerSubsc)
			throws DAOException;

	public List<TdmSubscStatusMastDO> getSubscStsDropDown(EntityManager managerSubsc)
			throws DAOException;

	public List<TdmUsStateSubDO> getSubscStateDropDown(EntityManager managerSubsc)
			throws DAOException;

	public List<TdmSubscLobMastDO> getSubscLobDropDown(EntityManager managerSubsc)
			throws DAOException;

	public List<TdmClaimDO> searchClaimRecords(TDMClaimSearchDTO tDMClaimSearchDTO, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, List<String> claimIds,
			EntityManager managerClaim) throws DAOException;

	public List<TdmClaimDO> getClaimRecords(List<String> claimIds, EntityManager managerClaim)
			throws DAOException;

	public Long searchClaimRecordsCount(TDMClaimSearchDTO tDMClaimSearchDTO, List<String> claimIds,
			EntityManager managerClaim) throws DAOException;

	public List<TdmClaimTypeMastDO> getClaimTypeDropDown(EntityManager managerClaim)
			throws DAOException;

	public List<TdmClaimStatusMastDO> getClaimStsDropDown(EntityManager managerClaim)
			throws DAOException;

	public List<TdmClaimSrcMastDO> getClaimSrcDropDown(EntityManager managerClaim)
			throws DAOException;

	public List<TdmTypeOfBillMastDO> getClaimTypeOfBillsDropDown(EntityManager managerClaim)
			throws DAOException;

	public List<TdmPosMastDO> getClaimPOSDropDown(EntityManager managerClaim) throws DAOException;

	public TdmUserDO checkAvailabilityOfUserId(String userId, EntityManager managerUser)
			throws DAOException;

	public List<TdmReservationDO> saveReservedData(List<TdmReservationDO> reservationDOList,
			String testCaseId, String testCaseName, EntityManager managerUser) throws DAOException;

	public List<TdmReservationDO> getReservedRecords(List<TdmProviderDO> providerDOlist,
			String userName, EntityManager managerUser) throws DAOException;

	public List<TdmReservationDO> getReservedRecords(String userId, String searchType,
			EntityManager managerUser) throws DAOException;

	public List<TdmReservationDO> getReservedRecords(String searchType, String userId, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, EntityManager managerUser)
			throws DAOException;

	public Boolean unReservedRecordForUser(Long providerId, EntityManager managerUser)
			throws DAOException;

	public List<TdmReservationDO> getReservedRecordsOfSub(List<TdmSubscriberDO> subscriberDOlist,
			String userName, EntityManager managerUser) throws DAOException;

	public List<TdmReservationDO> getReservedRecordsOfSub(String userId, EntityManager managerUser)
			throws DAOException;

	public List<TdmReservationDO> getReservedRecordsOfClaim(List<TdmClaimDO> claimDOlist,
			EntityManager managerUser) throws DAOException;

	public Long getReservedRecordsCount(String searchType, String userId, EntityManager managerUser)
			throws DAOException;

	public List<ZurichMasterDO> getPoloNonStandardSearchrecords(POLOSearchDTO poloSerachDTO,
			int offSet, int recordsperpage, EntityManager managerPolo) throws DAOException;

	public void resrervePoloRecords(List<ZurichReservationDO> reservationDO, String testcaseID,
			String testcaseName, String userId, EntityManager managerSubsc) throws DAOException;

	public List<ZurichReservationDO> getPoloResrvedRecords(String username,
			EntityManager managerSubsc) throws DAOException;

	public void unReservePoloResrvedRecords(List<ZurichReservationDO> unResrveList, String userId,
			EntityManager managerSubsc) throws DAOException;

}
