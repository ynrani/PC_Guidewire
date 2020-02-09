/*---------------------------------------------------------------------------------------
* Object Name: TDMClaimSrcDTO.Java
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

import java.math.BigDecimal;

public class TDMClaimSrcDTO
{
	private static final long serialVersionUID = 1L;

	private BigDecimal id;

	private String claimSrcDesc;

	public TDMClaimSrcDTO()
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

	public String getClaimSrcDesc()
	{
		return this.claimSrcDesc;
	}

	public void setClaimSrcDesc(String claimSrcDesc)
	{
		this.claimSrcDesc = claimSrcDesc;
	}

}
