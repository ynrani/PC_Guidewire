/*---------------------------------------------------------------------------------------
* Object Name: TdmProviderCatParentDTO.Java
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

public class TdmProviderCatParentDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private long providerCategoryId;

	private String providerCategoryName;

	public TdmProviderCatParentDTO()
	{
	}

	public long getProviderCategoryId()
	{
		return this.providerCategoryId;
	}

	public void setProviderCategoryId(long providerCategoryId)
	{
		this.providerCategoryId = providerCategoryId;
	}

	public String getProviderCategoryName()
	{
		return this.providerCategoryName;
	}

	public void setProviderCategoryName(String providerCategoryName)
	{
		this.providerCategoryName = providerCategoryName;
	}

}