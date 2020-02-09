/**
 * Object Name : TdgDataConditionService.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 23, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.service.impl;

import java.util.List;
import java.util.Map;

import com.tesda.model.DTO.TdgDataConditionDTO;

public interface TdgDataConditionService{
	String saveDataConditionData(TdgDataConditionDTO tdgDataConditionDTO);

	Map<String, List<String>> retrieveManualDictionaryValues(String strDictionaryName);

	Long totalDataConditionalDetailsAll();

	List<TdgDataConditionDTO> fetchDataConditionalDetailsAll(int offSet, int recordsperpage,
			boolean b);

	void deleteTdgDataConditionalDetails(String id);

	TdgDataConditionDTO fetchDataConditionalById(String id);
}
