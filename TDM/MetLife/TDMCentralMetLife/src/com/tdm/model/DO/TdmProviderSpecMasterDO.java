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
 * The persistent class for the TDM_PROVIDER_SPEC_MASTER database table.
 * 
 */
@Entity
@Table(name = "TDM_PROVIDER_SPEC_MASTER")
@NamedQuery(name = "TdmProviderSpecMasterDO.findAll", query = "SELECT t FROM TdmProviderSpecMasterDO t")
public class TdmProviderSpecMasterDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PROVIDER_SPECIALITY_ID")
	private String providerSpecialityId;

	@Column(name = "PROVIDER_SPECIALITY_NAME")
	private String providerSpecialityName;

	// bi-directional many-to-one association to TdmProviderCatMasterDO
	@ManyToOne
	@JoinColumn(name = "PROVIDER_CATEGORY_ID", insertable = false, updatable = false)
	private TdmProviderCatMasterDO tdmProviderCatMaster;

	public TdmProviderSpecMasterDO()
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

	public TdmProviderCatMasterDO getTdmProviderCatMaster()
	{
		return this.tdmProviderCatMaster;
	}

	public void setTdmProviderCatMaster(TdmProviderCatMasterDO tdmProviderCatMaster)
	{
		this.tdmProviderCatMaster = tdmProviderCatMaster;
	}

}