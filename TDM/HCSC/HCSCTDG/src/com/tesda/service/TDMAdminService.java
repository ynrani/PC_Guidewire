/*
 * Object Name : TDMAdminService.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.service;

import java.util.List;
import java.util.Map;

import com.tesda.model.DTO.TdgSchemaDTO;
import com.tesda.model.DTO.TdmUserDTO;

public interface TDMAdminService{
	public String saveUserDetails(TdmUserDTO userdo, boolean bEdit);

	public List<TdmUserDTO> getAllUser(TdmUserDTO userdo, int offSet, int recordsperpage, boolean b);

	public TdmUserDTO getEditUser(String userId);

	public String deleteUserByUserId(String userId);

	public Long searchUserRecordsCount(TdmUserDTO userdo);

	public boolean validateUserId(String userid);

	public List<String> getAllCols(String strUrl, String strName, String strPass);

	public String saveTdgSchemaDetails(TdgSchemaDTO tdgSchemaDTO);

	public List<TdgSchemaDTO> fetchAllTdgSchemaDetails();

	public Long getTdgMasterDictionaryRecordsCount();

	public List<TdgSchemaDTO> getTdgMasterDictionaryRecordsForPagination(int offSet,
			int recordsperpage, boolean b);

	public void deleteTdgMasterDictionaryByReqSchemaId(String reqId, String manualDictionaryId);

	public String saveManualDictionaryDetails(String strTabName,
			Map<String, List<String>> mapResult, String reqSchemaId);

	public List<String> getColsByTabs(String strUrl, String strName, String strPass,
			List<String> listPassedTabs);
}
