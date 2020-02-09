package com.tdm.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.tdm.exception.DAOException;
import com.tdm.model.DO.TdmReservationDO;
import com.tdm.model.DTO.TdmPolicyClaimSearchDTO;
import com.tdm.model.DTO.TdmPolicySearchDTO;

public interface TdmPolicySearchDAO
{

	public List<Object[]> searchPolicyRecords(TdmPolicySearchDTO tdmPolicySearchDTO, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, StringBuffer policys,
			EntityManager managerPolicySearch) throws DAOException;

	public Long searchPolicyRecordsCount(TdmPolicySearchDTO tdmPolicySearchDTO,
			StringBuffer policys, EntityManager managerPolicySearch) throws DAOException;

	public List<Object[]> getPolicyRecords(StringBuffer policys, EntityManager managerPolicySearch)
			throws DAOException;

	public List<Object[]> searchClaimRecords(TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO,
			int offSet, int recordsperpage, boolean pageNationOnOffFlag, StringBuffer claims,
			EntityManager managerClaimSearch) throws DAOException;

	public Long searchClaimRecordsCount(TdmPolicyClaimSearchDTO tdmPolicyClaimSearchDTO,
			StringBuffer claims, EntityManager managerClaimSearch) throws DAOException;

	public List<Object[]> getClaimRecords(StringBuffer claims, EntityManager managerClaimSearch)
			throws DAOException;

	public List<TdmReservationDO> getReservedRecords(String userName, String searchType,
			EntityManager managerUser) throws DAOException;

	public List<TdmReservationDO> getReservedRecords(String userName, EntityManager managerUser)
			throws DAOException;

	public List<TdmReservationDO> saveReservedData(List<TdmReservationDO> reservationDOs,
			String testCaseId, String testCaseName, EntityManager managerUser) throws DAOException;

	public boolean unReservedRecordForUser(String policyNo, EntityManager managerUser)
			throws DAOException;

	public List<TdmReservationDO> getReservedRecords(String searchType, String userId, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, EntityManager managerUser)
			throws DAOException;

	public Long getReservedRecordsCount(String searchType, String userId, EntityManager managerUser)
			throws DAOException;

	List<Object[]> getPolicyStatus(EntityManager managerPolicySearch) throws DAOException;

}
