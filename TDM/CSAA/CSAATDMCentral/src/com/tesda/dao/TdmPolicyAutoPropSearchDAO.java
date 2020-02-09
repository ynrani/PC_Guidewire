package com.tesda.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.tesda.exception.DAOException;
import com.tesda.model.DO.PolicySummaryStg;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;

public interface TdmPolicyAutoPropSearchDAO
{

	public List<TdmReservationDO> getReservedRecords(String userName, String searchType,
			EntityManager managerUser) throws DAOException;

	public List<TdmReservationDO> saveReservedData(List<TdmReservationDO> reservationDOs,
			String testCaseId, String testCaseName, EntityManager managerCsaaUser)
			throws DAOException;

	public List<PolicySummaryStg> searchPolicyPropRecordsByPolicySearchNew(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, StringBuffer policyProps, String policytype,
			EntityManager managerCsaaUser) throws DAOException;

	public List<PolicySummaryStg> searchPolicyAutoRecordsByPolicySearchNew(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, StringBuffer policyautos, String ptype,
			EntityManager managerCsaauser) throws DAOException;

}
