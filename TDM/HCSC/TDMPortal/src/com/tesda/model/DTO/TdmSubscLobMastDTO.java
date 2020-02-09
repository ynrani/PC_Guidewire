/*---------------------------------------------------------------------------------------
* Object Name: TdmSubscLobMastDTO.Java
* 
 * Modification Block:
* --------------------------------------------------------------------------------------
* S.No. Name                Date      Bug Fix no. 		Desc
* --------------------------------------------------------------------------------------
* 1     Seshadri Chowdary   11/04/15  NA          		Created* 
* --------------------------------------------------------------------------------------
*
* Copyright: 2015 <CapGemini>
*---------------------------------------------------------------------------------------*/


package com.tesda.model.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class TdmSubscLobMastDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private String subscLobDesc;

	public BigDecimal getId()
	{
		return this.id;
	}

	public void setId(BigDecimal id)
	{
		this.id = id;
	}

	public String getSubscLobDesc()
	{
		return this.subscLobDesc;
	}

	public void setSubscLobDesc(String subscLobDesc)
	{
		this.subscLobDesc = subscLobDesc;
	}

}