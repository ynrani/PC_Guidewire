package com.tdm.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.tdm.exception.DAOException;
import com.tdm.model.DO.PolicySummaryStg;
import com.tdm.model.DO.TdmReservationDO;

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

	public boolean unReservedRecordForUser(String policyPropNo, EntityManager managerCsaaUser)
			throws DAOException;

	public List<PolicySummaryStg> getReservedRecords(StringBuffer propIds,
			EntityManager managerCsaaUser) throws DAOException;

}
