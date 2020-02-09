package com.tdm.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_PROVIDER_TYPE database table.
 * 
 */
@Entity
@Table(name = "TDM_PROVIDER_TYPE")
@NamedQuery(name = "TdmProviderTypeDO.findAll", query = "SELECT t FROM TdmProviderTypeDO t")
public class TdmProviderTypeDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PROVIDER_TYPE_ID")
	private String providerTypeId;

	@Column(name = "PROVIDER_TYPE_NAME")
	private String providerTypeName;

	// bi-directional many-to-one association to TdmProviderDO
	@ManyToOne
	@JoinColumn(name = "PROVIDER_ID", insertable = false, updatable = false)
	private TdmProviderDO tdmProvider;

	public TdmProviderTypeDO()
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

	public TdmProviderDO getTdmProvider()
	{
		return this.tdmProvider;
	}

	public void setTdmProvider(TdmProviderDO tdmProvider)
	{
		this.tdmProvider = tdmProvider;
	}

}