package com.tdm.model.DTO;

import java.io.Serializable;

public class TdmProviderSpecParentDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String providerSpecialityId;

	private String providerSpecialityName;

	public TdmProviderSpecParentDTO()
	{
	}

	public String getProviderSpecialityId()
	{
		return this.providerSpecialityId;
	}

	public void setProviderSpecialityId(String providerSpecialityId)
	{
		this.providerSpecialityId = providerSpecialityId;
	}

	public String getProviderSpecialityName()
	{
		return this.providerSpecialityName;
	}

	public void setProviderSpecialityName(String providerSpecialityName)
	{
		this.providerSpecialityName = providerSpecialityName;
	}

}