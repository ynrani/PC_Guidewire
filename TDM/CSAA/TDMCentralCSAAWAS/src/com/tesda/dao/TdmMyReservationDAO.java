package com.tesda.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.tesda.exception.DAOException;
import com.tesda.model.DO.PolicysummaryDO;
import com.tesda.model.DO.TdmReservationDO;

public interface TdmMyReservationDAO
{

	public List<TdmReservationDO> getReservedRecords(String searchType, String userName,
			int offSet, int recordsperpage, boolean pageNationOnOffFlag,
			EntityManager managerCsaaUser) throws DAOException;

	public List<TdmReservationDO> getPolicyAutoRecords(List<String> policyAutoNumbers,
			EntityManager managerCsaaUser, String searchType, String userName) throws DAOException;

	public Long getReservedRecordsCount(String searchType, String userName,
			EntityManager managerCsaaUser) throws DAOException;

	public boolean unReservedRecordForUser(Long policyAutoNo, EntityManager managerCsaaUser)
			throws DAOException;

	public List<TdmReservationDO> getPolicyPropRecords(List<String> policyPropNumbers,
			EntityManager managerCsaaProp, String searchType, String userName) throws DAOException;

	public boolean unReservedRecordForUser(String policyPropNo, EntityManager managerCsaaUser)
			throws DAOException;

	public PolicysummaryDO getPolicyAutoRecord(String id, EntityManager managerCsaaAuto)
			throws DAOException;

	public PolicysummaryDO getPolicyPropRecord(String id, EntityManager managerCsaaProp)
			throws DAOException;

}
