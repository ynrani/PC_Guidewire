/*---------------------------------------------------------------------------------------
* Object Name: TDMClaimStatusMastDTO.Java
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

public class TDMClaimStatusMastDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private BigDecimal id;

	private String claimStatusDesc;

	public TDMClaimStatusMastDTO()
	{
	}

	public BigDecimal getId()
	{
		return this.id;
	}

	public void setId(BigDecimal id)
	{
		this.id = id;
	}

	public String getClaimStatusDesc()
	{
		return this.claimStatusDesc;
	}

	public void setClaimStatusDesc(String claimStatusDesc)
	{
		this.claimStatusDesc = claimStatusDesc;
	}

}