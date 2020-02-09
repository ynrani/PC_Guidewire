/*
 * Object Name : TdmAutoSearchResultDTO.java
 * Modification Block
 * ------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ------------------------------------------------------------------
 * 	1.	  vkrish14		1:40:37 PM				Created
 * ------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.DTO;

import java.util.List;
import java.util.Map;

import com.tesda.model.DO.PolicysummaryDO;

/**
 * @author vkrish14
 *
 */
public class TdmAutoSearchResultDTO extends AbstractBaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<PolicysummaryDO> listPolicySummeryDo;
	
	private Map<String,Map<String,String>> mapDerivedFields;

	public List<PolicysummaryDO> getListPolicySummeryDo(){
		return listPolicySummeryDo;
	}

	public void setListPolicySummeryDo(List<PolicysummaryDO> listPolicySummeryDo){
		this.listPolicySummeryDo = listPolicySummeryDo;
	}

	public Map<String,Map<String,String>> getMapDerivedFields(){
		return mapDerivedFields;
	}

	public void setMapDerivedFields(Map<String,Map<String,String>> mapDerivedFields){
		this.mapDerivedFields = mapDerivedFields;
	}
	
	
}
