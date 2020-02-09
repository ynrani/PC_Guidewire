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
