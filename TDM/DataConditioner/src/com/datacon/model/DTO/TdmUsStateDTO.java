package com.datacon.model.DTO;

import java.io.Serializable;

public class TdmUsStateDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String refName;
	private String stateName;

	public TdmUsStateDTO()
	{
	}

	public String getRefName()
	{
		return this.refName;
	}

	public void setRefName(String refName)
	{
		this.refName = refName;
	}

	public String getStateName()
	{
		return this.stateName;
	}

	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}

}