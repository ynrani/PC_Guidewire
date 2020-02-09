package com.tdm.model.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class TdmSubscTypeMastDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private BigDecimal id;

	private String subscTypeDesc;

	public TdmSubscTypeMastDTO()
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

	public String getSubscTypeDesc()
	{
		return this.subscTypeDesc;
	}

	public void setSubscTypeDesc(String subscTypeDesc)
	{
		this.subscTypeDesc = subscTypeDesc;
	}

}