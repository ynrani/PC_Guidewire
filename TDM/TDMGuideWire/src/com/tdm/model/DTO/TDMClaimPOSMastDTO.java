package com.tdm.model.DTO;

import java.math.BigDecimal;

public class TDMClaimPOSMastDTO
{

	private BigDecimal id;

	private String claimPOSDesc;

	public TDMClaimPOSMastDTO()
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

	public String getClaimPOSDesc()
	{
		return claimPOSDesc;
	}

	public void setClaimPOSDesc(String claimPOSDesc)
	{
		this.claimPOSDesc = claimPOSDesc;
	}
}
