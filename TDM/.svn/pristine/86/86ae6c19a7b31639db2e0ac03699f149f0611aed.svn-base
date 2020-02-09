package com.tesda.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.tesda.exception.DAOException;
import com.tesda.model.DO.CassPolListDO;
import com.tesda.model.DO.PolicysummaryDO;
import com.tesda.model.DO.TdmPolicySearchDO;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DTO.TdmAutoSearchResultDTO;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;

public interface TdmPolicyAutoSearchDAO
{

	List<TdmReservationDO> getReservedRecords(String userName, String searchType,
			EntityManager managerUser) throws DAOException;

	List<TdmReservationDO> getReservedRecords(List<PolicysummaryDO> policyautos, String userName,
			EntityManager managerUser) throws DAOException;

	TdmAutoSearchResultDTO searchPolicyAutoRecords(TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO,
			int offSet, int recordsperpage, boolean pageNationOnOffFlag, StringBuffer policyautos,
			String policytype, StringBuffer listOfPolocies, EntityManager managerCsaa)
			throws DAOException;

	Long searchPolicyAutoRecordsCount(TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO,
			StringBuffer providersIds, String policytype, EntityManager managerCsaa)
			throws DAOException;

	List<TdmReservationDO> saveReservedData(List<TdmReservationDO> reservationDOs,
			String testCaseId, String testCaseName, EntityManager managerUser) throws DAOException;

	List<TdmReservationDO> getReservedRecordsHo(List<PolicysummaryDO> hoPolicyDOs, String userName,
			EntityManager managerUser) throws DAOException;

	List<PolicysummaryDO> searchPolicyPropRecords(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, StringBuffer policyProps, String policytype,
			StringBuffer listOfPolocies, EntityManager managerCsaa) throws DAOException;

	Long searchPolicyPropRecordsCount(TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			List<String> policyProps, String policytype, EntityManager managerCsaa)
			throws DAOException;

	public List<Object[]> getPolicyCov(StringBuffer sb, EntityManager managerCsaa)
			throws DAOException;

	public List<Object[]> getPolicyRiskCov(StringBuffer sb, String type, EntityManager managerCsaa)
			throws DAOException;

	public List<CassPolListDO> getRecordsWithConditionPASFL(String assoDocReq, int offSet,
			int recordsperpage, StringBuffer policyautos, String policytype,
			EntityManager managerUser) throws DAOException;

	List<Object[]> searchPolicyAutoRecordsByPolicySearch(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, boolean pageNationOnOffFlag,
			int recordsperpage, StringBuffer policyautos, String ptype, EntityManager managerUser)
			throws DAOException;

	List<TdmPolicySearchDO> searchPolicyPropRecordsByPolicySearch(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, StringBuffer policyProps, String policytype,
			EntityManager managerCsaaProp) throws DAOException;

	List<TdmPolicySearchDO> searchPolicyAutoRecordsByPolicySearchNew(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, boolean pageNationOnOffFlag,
			int recordsperpage, StringBuffer policyautos, String ptype, EntityManager managerCsaa)
			throws DAOException;

}
