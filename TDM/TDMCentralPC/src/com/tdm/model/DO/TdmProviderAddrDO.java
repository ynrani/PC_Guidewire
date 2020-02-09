package com.tdm.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_PROVIDER_ADDR database table.
 * 
 */
@Entity
@Table(name = "TDM_PROVIDER_ADDR")
@NamedQuery(name = "TdmProviderAddrDO.findAll", query = "SELECT t FROM TdmProviderAddrDO t")
public class TdmProviderAddrDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TdmProviderAddrDOPK id;

	private String address1;

	private String address2;

	private String city;

	private String country;

	@Column(name = "COUNTRY_CODE")
	private String countryCode;

	private String description;

	private String name;

	@Column(name = "PARENT_LOCATION")
	private BigDecimal parentLocation;

	@Column(name = "POSTAL_CODE")
	private String postalCode;

	@Column(name = "STATE")
	private String state;

	// bi-directional many-to-one association to TdmProviderDO
	@ManyToOne
	@JoinColumn(name = "PROVIDER_ID", insertable = false, updatable = false)
	private TdmProviderDO tdmProvider;

	public TdmProviderAddrDO()
	{
	}

	public TdmProviderAddrDOPK getId()
	{
		return this.id;
	}

	public void setId(TdmProviderAddrDOPK id)
	{
		this.id = id;
	}

	public String getAddress1()
	{
		return this.address1;
	}

	public void setAddress1(String address1)
	{
		this.address1 = address1;
	}

	public String getAddress2()
	{
		return this.address2;
	}

	public void setAddress2(String address2)
	{
		this.address2 = address2;
	}

	public String getCity()
	{
		return this.city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getCountry()
	{
		return this.country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getCountryCode()
	{
		return this.countryCode;
	}

	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public BigDecimal getParentLocation()
	{
		return this.parentLocation;
	}

	public void setParentLocation(BigDecimal parentLocation)
	{
		this.parentLocation = parentLocation;
	}

	public String getPostalCode()
	{
		return this.postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getState()
	{
		return this.state;
	}

	public void setState(String state)
	{
		this.state = state;
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