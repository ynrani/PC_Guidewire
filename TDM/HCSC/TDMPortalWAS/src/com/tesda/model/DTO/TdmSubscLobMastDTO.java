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