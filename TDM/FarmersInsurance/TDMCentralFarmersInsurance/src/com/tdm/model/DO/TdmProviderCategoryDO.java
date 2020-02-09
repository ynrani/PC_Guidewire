package com.tdm.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_PROVIDER_CATEGORY database table.
 * 
 */
@Entity
@Table(name = "TDM_PROVIDER_CATEGORY")
@NamedQuery(name = "TdmProviderCategoryDO.findAll", query = "SELECT t FROM TdmProviderCategoryDO t")
public class TdmProviderCategoryDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "CATEGORY_DESCRIPTION")
	private String categoryDescription;

	@Id
	@Column(name = "PROVIDER_CATEGORY_ID")
	private BigDecimal providerCategoryId;

	// bi-directional many-to-one association to TdmProviderDO
	@OneToOne
	@JoinColumn(name = "PROVIDER_ID", insertable = false, updatable = false)
	private TdmProviderDO tdmProvider;

	public TdmProviderCategoryDO()
	{
	}

	public String getCategoryDescription()
	{
		return this.categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription)
	{
		this.categoryDescription = categoryDescription;
	}

	public BigDecimal getProviderCategoryId()
	{
		return this.providerCategoryId;
	}

	public void setProviderCategoryId(BigDecimal providerCategoryId)
	{
		this.providerCategoryId = providerCategoryId;
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