/*
 * Object Name : TdmAutoSearchResultDTO.java Modification Block
 * ------------------------------------------------------------------ S.No. Name Date Bug_Fix_No
 * Desc ------------------------------------------------------------------ 1. vkrish14 1:40:37 PM
 * Created ------------------------------------------------------------------ Copyrights: 2015
 * Capgemini.com
 */
package com.tdm.model.DTO;

import java.util.Map;

/**
 * @author vkrish14
 *
 */
public class TdmAutoSearchResultDTO
{

	/**
	 * 
	 */

	private Map<String, Map<String, String>> mapDerivedFields;

	public Map<String, Map<String, String>> getMapDerivedFields() {
		return mapDerivedFields;
	}

	public void setMapDerivedFields(Map<String, Map<String, String>> mapDerivedFields) {
		this.mapDerivedFields = mapDerivedFields;
	}

}
