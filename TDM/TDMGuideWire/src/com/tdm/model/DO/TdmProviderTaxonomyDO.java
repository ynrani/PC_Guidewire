package com.tdm.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_PROVIDER_TAXONOMY database table.
 * 
 */
@Entity
@Table(name = "TDM_PROVIDER_TAXONOMY")
@NamedQuery(name = "TdmProviderTaxonomyDO.findAll", query = "SELECT t FROM TdmProviderTaxonomyDO t")
public class TdmProviderTaxonomyDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PROVIDER_ID")
	private long providerId;

	@Column(name = "PROVIDER_TAXONOMY_CODE")
	private String providerTaxonomyCode;

	// bi-directional one-to-one association to TdmProviderDO
	@OneToOne
	@JoinColumn(name = "PROVIDER_ID", insertable = false, updatable = false)
	private TdmProviderDO tdmProvider;

	public TdmProviderTaxonomyDO()
	{
	}

	public long getProviderId()
	{
		return this.providerId;
	}

	public void setProviderId(long providerId)
	{
		this.providerId = providerId;
	}

	public String getProviderTaxonomyCode()
	{
		return this.providerTaxonomyCode;
	}

	public void setProviderTaxonomyCode(String providerTaxonomyCode)
	{
		this.providerTaxonomyCode = providerTaxonomyCode;
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