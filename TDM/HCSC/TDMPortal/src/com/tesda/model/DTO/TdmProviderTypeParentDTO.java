/*---------------------------------------------------------------------------------------
* Object Name: TdmProviderTypeParentDTO.Java
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

import java.io.Serializable;

public class TdmProviderTypeParentDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String providerTypeId;

	private String providerTypeName;

	public TdmProviderTypeParentDTO()
	{
	}

	public String getProviderTypeId()
	{
		return this.providerTypeId;
	}

	public void setProviderTypeId(String providerTypeId)
	{
		this.providerTypeId = providerTypeId;
	}

	public String getProviderTypeName()
	{
		return this.providerTypeName;
	}

	public void setProviderTypeName(String providerTypeName)
	{
		this.providerTypeName = providerTypeName;
	}

}