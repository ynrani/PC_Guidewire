/*
 * Object Name : TdmUserAuthDTO.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.DTO;

public class TdmUserAuthDTO extends AbstractBaseDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String role;
	private TdmUserDTO tdmUserDTO;

	public String getRole(){
		return role;
	}

	public void setRole(String role){
		this.role = role;
	}

	public TdmUserDTO getTdmUserDTO(){
		return tdmUserDTO;
	}

	public void setTdmUserDTO(TdmUserDTO tdmUserDTO){
		this.tdmUserDTO = tdmUserDTO;
	}
}
