package com.tdm.model.DTO;

import java.io.Serializable;

public class TdmProviderSpecMasterDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String providerSpecialityId;

	private String providerSpecialityName;

	public String getProviderSpecialityId()
	{
		return providerSpecialityId;
	}

	public void setProviderSpecialityId(String providerSpecialityId)
	{
		this.providerSpecialityId = providerSpecialityId;
	}

	public String getProviderSpecialityName()
	{
		return providerSpecialityName;
	}

	public void setProviderSpecialityName(String providerSpecialityName)
	{
		this.providerSpecialityName = providerSpecialityName;
	}

}