/*---------------------------------------------------------------------------------------
* Object Name: TDMClaimFerquSearchDTO.Java
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

public class TDMClaimFerquSearchDTO
{

	private String envType;
	private String ClaimCatgType;
	private String ClaimCatgCombType;
	private String ClaimTopPull;

	public String getEnvType()
	{
		return envType;
	}

	public void setEnvType(String envType)
	{
		this.envType = envType;
	}

	public String getClaimCatgType()
	{
		return ClaimCatgType;
	}

	public void setClaimCatgType(String claimCatgType)
	{
		ClaimCatgType = claimCatgType;
	}

	public String getClaimCatgCombType()
	{
		return ClaimCatgCombType;
	}

	public void setClaimCatgCombType(String claimCatgCombType)
	{
		ClaimCatgCombType = claimCatgCombType;
	}

	public String getClaimTopPull()
	{
		return ClaimTopPull;
	}

	public void setClaimTopPull(String claimTopPull)
	{
		ClaimTopPull = claimTopPull;
	}

}
