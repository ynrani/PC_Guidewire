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
 * The persistent class for the TDM_PROVIDER_SPECIALITY database table.
 * 
 */
@Entity
@Table(name = "TDM_PROVIDER_SPECIALITY")
@NamedQuery(name = "TdmProviderSpecialityDO.findAll", query = "SELECT t FROM TdmProviderSpecialityDO t")
public class TdmProviderSpecialityDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PROVIDER_SPECIALITY_ID")
	private String providerSpecialityId;

	@Column(name = "SPECIALITY_DESCRIPTION")
	private String specialityDescription;

	// bi-directional many-to-one association to TdmProviderDO
	@OneToOne
	@JoinColumn(name = "PROVIDER_ID", insertable = false, updatable = false)
	private TdmProviderDO tdmProvider;

	public TdmProviderSpecialityDO()
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

	public String getSpecialityDescription()
	{
		return this.specialityDescription;
	}

	public void setSpecialityDescription(String specialityDescription)
	{
		this.specialityDescription = specialityDescription;
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