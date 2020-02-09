/*
 * Object Name : TdmPolicyAutoPropSearchDAO.java
 * Modification Block
 * ------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ------------------------------------------------------------------
 * 	1.	  vkrish14		2:55:46 PM				Created
 * ------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.tesda.exception.DAOException;
import com.tesda.model.DO.PolicySummaryStgDO;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;

/**
 * @author vkrish14
 *
 */
public interface TdmPolicyAutoPropSearchDAO{

	List<PolicySummaryStgDO> searchPolicyAutoRecordsByPolicySearch(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, boolean pageNationOnOffFlag,
			int recordsperpage, StringBuffer policyautos, String ptype, EntityManager managerCsaa)
			throws DAOException;

	List<PolicySummaryStgDO> searchPolicyPropRecordsByPolicySearch(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, StringBuffer policyProps, String policytype,
			EntityManager managerCsaaProp) throws DAOException;
}
