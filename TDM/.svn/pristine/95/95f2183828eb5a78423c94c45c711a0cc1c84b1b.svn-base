package com.tdm.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the TDM_PROVIDER database table.
 * 
 */
@Entity
@Table(name = "TDM_PROVIDER")
@NamedQuery(name = "TdmProviderDO.findAll", query = "SELECT t FROM TdmProviderDO t")
public class TdmProviderDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PROVIDER_ID")
	private long providerId;

	private String atypical;

	@Column(name = "CONTRACT_NAME")
	private String contractName;

	private BigDecimal creator;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_CREATED")
	private Date dateCreated;

	private String eft;

	@Column(name = "FIRST_NAME")
	private String firstName;

	private String gender;

	private String identifier;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "LICENSE_NO")
	private String licenseNo;

	@Column(name = "MEDICARE_ID")
	private String medicareId;

	private String npi;

	@Temporal(TemporalType.DATE)
	@Column(name = "TERMINATION_DATE")
	private Date terminationDate;

	private String tin;

	// bi-directional many-to-one association to TdmProviderAddrDO
	@OneToMany(mappedBy = "tdmProvider", fetch = FetchType.EAGER)
	private List<TdmProviderAddrDO> tdmProviderAddrs;

	// bi-directional one-to-one association to TdmProviderCategoryDO
	@OneToOne(mappedBy = "tdmProvider", fetch = FetchType.LAZY)
	private TdmProviderCategoryDO tdmProviderCategories;

	// bi-directional one-to-one association to TdmProviderSpecialityDO
	@OneToOne(mappedBy = "tdmProvider", fetch = FetchType.LAZY)
	private TdmProviderSpecialityDO tdmProviderSpecialities;

	// bi-directional one-to-one association to TdmProviderTaxonomyDO
	@OneToOne(mappedBy = "tdmProvider", fetch = FetchType.LAZY)
	private TdmProviderTaxonomyDO tdmProviderTaxonomy;

	// bi-directional many-to-one association to TdmProviderTypeDO
	@OneToMany(mappedBy = "tdmProvider")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<TdmProviderTypeDO> tdmProviderTypes;

	public TdmProviderDO()
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

	public String getAtypical()
	{
		return this.atypical;
	}

	public void setAtypical(String atypical)
	{
		this.atypical = atypical;
	}

	public String getContractName()
	{
		return this.contractName;
	}

	public void setContractName(String contractName)
	{
		this.contractName = contractName;
	}

	public BigDecimal getCreator()
	{
		return this.creator;
	}

	public void setCreator(BigDecimal creator)
	{
		this.creator = creator;
	}

	public Date getDateCreated()
	{
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}

	public String getEft()
	{
		return this.eft;
	}

	public void setEft(String eft)
	{
		this.eft = eft;
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getGender()
	{
		return this.gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getIdentifier()
	{
		return this.identifier;
	}

	public void setIdentifier(String identifier)
	{
		this.identifier = identifier;
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getLicenseNo()
	{
		return this.licenseNo;
	}

	public void setLicenseNo(String licenseNo)
	{
		this.licenseNo = licenseNo;
	}

	public String getMedicareId()
	{
		return this.medicareId;
	}

	public void setMedicareId(String medicareId)
	{
		this.medicareId = medicareId;
	}

	public String getNpi()
	{
		return this.npi;
	}

	public void setNpi(String npi)
	{
		this.npi = npi;
	}

	public Date getTerminationDate()
	{
		return this.terminationDate;
	}

	public void setTerminationDate(Date terminationDate)
	{
		this.terminationDate = terminationDate;
	}

	public String getTin()
	{
		return this.tin;
	}

	public void setTin(String tin)
	{
		this.tin = tin;
	}

	public List<TdmProviderAddrDO> getTdmProviderAddrs()
	{
		return this.tdmProviderAddrs;
	}

	public void setTdmProviderAddrs(List<TdmProviderAddrDO> tdmProviderAddrs)
	{
		this.tdmProviderAddrs = tdmProviderAddrs;
	}

	public TdmProviderAddrDO addTdmProviderAddr(TdmProviderAddrDO tdmProviderAddr)
	{
		getTdmProviderAddrs().add(tdmProviderAddr);
		tdmProviderAddr.setTdmProvider(this);

		return tdmProviderAddr;
	}

	public TdmProviderAddrDO removeTdmProviderAddr(TdmProviderAddrDO tdmProviderAddr)
	{
		getTdmProviderAddrs().remove(tdmProviderAddr);
		tdmProviderAddr.setTdmProvider(null);

		return tdmProviderAddr;
	}

	public TdmProviderCategoryDO getTdmProviderCategories()
	{
		return this.tdmProviderCategories;
	}

	public void setTdmProviderCategories(TdmProviderCategoryDO tdmProviderCategories)
	{
		this.tdmProviderCategories = tdmProviderCategories;
	}

	public TdmProviderSpecialityDO getTdmProviderSpecialities()
	{
		return this.tdmProviderSpecialities;
	}

	public void setTdmProviderSpecialities(TdmProviderSpecialityDO tdmProviderSpecialities)
	{
		this.tdmProviderSpecialities = tdmProviderSpecialities;
	}

	public TdmProviderTaxonomyDO getTdmProviderTaxonomy()
	{
		return this.tdmProviderTaxonomy;
	}

	public void setTdmProviderTaxonomy(TdmProviderTaxonomyDO tdmProviderTaxonomy)
	{
		this.tdmProviderTaxonomy = tdmProviderTaxonomy;
	}

	public List<TdmProviderTypeDO> getTdmProviderTypes()
	{
		return this.tdmProviderTypes;
	}

	public void setTdmProviderTypes(List<TdmProviderTypeDO> tdmProviderTypes)
	{
		this.tdmProviderTypes = tdmProviderTypes;
	}

	public TdmProviderTypeDO addTdmProviderType(TdmProviderTypeDO tdmProviderType)
	{
		getTdmProviderTypes().add(tdmProviderType);
		tdmProviderType.setTdmProvider(this);

		return tdmProviderType;
	}

	public TdmProviderTypeDO removeTdmProviderType(TdmProviderTypeDO tdmProviderType)
	{
		getTdmProviderTypes().remove(tdmProviderType);
		tdmProviderType.setTdmProvider(null);

		return tdmProviderType;
	}

}