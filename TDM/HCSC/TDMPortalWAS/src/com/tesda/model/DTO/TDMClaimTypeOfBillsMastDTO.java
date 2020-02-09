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
