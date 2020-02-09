/*
 * Object Name : TDMAdminDAO.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.tesda.model.DO.TdmUserDO;

public interface TDMAdminDAO{
	public String saveUserDetails(TdmUserDO userdo, boolean bEdit);

	public List<TdmUserDO> getAllUser(TdmUserDO userdo, int offSet, int recordsperpage, boolean b);

	public TdmUserDO getEditUser(String userId);

	public String deleteUserByUserId(String userId);

	public Long searchUserRecordsCount(TdmUserDO userdo);

	boolean validateUserId(String userId);

	public void deleteTdgMasterDictionaryByReqSchemaId(EntityManager managerentity, String reqId,
			String manualDictionaryId);
}
