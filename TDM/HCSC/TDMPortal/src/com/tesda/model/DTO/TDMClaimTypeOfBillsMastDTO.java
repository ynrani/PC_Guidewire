/*---------------------------------------------------------------------------------------
* Object Name: TDMClaimTypeOfBillsMastDTO.Java
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


public class TDMClaimTypeOfBillsMastDTO
{
	private static final long serialVersionUID = 1L;

	private String id;

	private String claimTypeOfBillDesc;

	public TDMClaimTypeOfBillsMastDTO()
	{
	}

	public String getId()
	{
		return this.id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getClaimTypeOfBillDesc()
	{
		return this.claimTypeOfBillDesc;
	}

	public void setClaimTypeOfBillDesc(String claimTypeOfBillDesc)
	{
		this.claimTypeOfBillDesc = claimTypeOfBillDesc;
	}

}
