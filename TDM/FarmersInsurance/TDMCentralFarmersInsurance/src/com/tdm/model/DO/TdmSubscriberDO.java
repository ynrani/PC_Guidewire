package com.tdm.model.DO;

import java.io.Serializable;
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
 * The persistent class for the TDM_SUBSCRIBER database table.
 * 
 */
@Entity
@Table(name = "TDM_SUBSCRIBER")
@NamedQuery(name = "TdmSubscriberDO.findAll", query = "SELECT t FROM TdmSubscriberDO t")
public class TdmSubscriberDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SUBSCRIBER_ID")
	private String subscriberId;

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	@Column(name = "CONTRACT_CODE")
	private String contractCode;

	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECTIVE_DATE")
	private Date effectiveDate;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "LOB")
	private String lob;

	@Column(name = "PACKAGE")
	private String packages;

	@Column(name = "PCP")
	private String pcp;

	@Column(name = "PLAN_ID")
	private String planId;

	@Column(name = "PLAN_NAME")
	private String planName;

	@Column(name = "SECTION")
	private String section;

	@Column(name = "SSN")
	private String ssn;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "SUBC_GROUP")
	private String subcGroup;

	@Column(name = "SUBC_TYPE")
	private String subcType;

	@Temporal(TemporalType.DATE)
	@Column(name = "TERM_DATE")
	private Date termDate;

	@Column(name = "WITH_COB")
	private String withCob;

	// bi-directional many-to-one association to TdmSubscriberNameDO
	@OneToOne(mappedBy = "tdmSubscriber", fetch = FetchType.LAZY)
	private TdmSubscriberNameDO tdmSubscriberNames;

	// bi-directional many-to-one association to TdmSubscriberRelationshipDO
	@OneToMany(mappedBy = "tdmSubscriber")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<TdmSubscriberRelationshipDO> tdmSubscriberRelationships;

	// bi-directional many-to-one association to TdmSuscriberAddressDO
	@OneToMany(mappedBy = "tdmSubscriber")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<TdmSuscriberAddressDO> tdmSuscriberAddresses;

	public TdmSubscriberDO()
	{
	}

	public String getSubscriberId()
	{
		return this.subscriberId;
	}

	public void setSubscriberId(String subscriberId)
	{
		this.subscriberId = subscriberId;
	}

	public Date getBirthDate()
	{
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}

	public String getContractCode()
	{
		return this.contractCode;
	}

	public void setContractCode(String contractCode)
	{
		this.contractCode = contractCode;
	}

	public Date getEffectiveDate()
	{
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate)
	{
		this.effectiveDate = effectiveDate;
	}

	public String getGender()
	{
		return this.gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getLob()
	{
		return this.lob;
	}

	public void setLob(String lob)
	{
		this.lob = lob;
	}

	public String getPackages()
	{
		return this.packages;
	}

	public void setPackages(String packages)
	{
		this.packages = packages;
	}

	public String getPcp()
	{
		return this.pcp;
	}

	public void setPcp(String pcp)
	{
		this.pcp = pcp;
	}

	public String getPlanId()
	{
		return this.planId;
	}

	public void setPlanId(String planId)
	{
		this.planId = planId;
	}

	public String getPlanName()
	{
		return this.planName;
	}

	public void setPlanName(String planName)
	{
		this.planName = planName;
	}

	public String getSection()
	{
		return this.section;
	}

	public void setSection(String section)
	{
		this.section = section;
	}

	public String getSsn()
	{
		return this.ssn;
	}

	public void setSsn(String ssn)
	{
		this.ssn = ssn;
	}

	public String getStatus()
	{
		return this.status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getSubcGroup()
	{
		return this.subcGroup;
	}

	public void setSubcGroup(String subcGroup)
	{
		this.subcGroup = subcGroup;
	}

	public String getSubcType()
	{
		return this.subcType;
	}

	public void setSubcType(String subcType)
	{
		this.subcType = subcType;
	}

	public Date getTermDate()
	{
		return this.termDate;
	}

	public void setTermDate(Date termDate)
	{
		this.termDate = termDate;
	}

	public String getWithCob()
	{
		return this.withCob;
	}

	public void setWithCob(String withCob)
	{
		this.withCob = withCob;
	}

	public TdmSubscriberNameDO getTdmSubscriberNames()
	{
		return this.tdmSubscriberNames;
	}

	public void setTdmSubscriberNames(TdmSubscriberNameDO tdmSubscriberNames)
	{
		this.tdmSubscriberNames = tdmSubscriberNames;
	}

	public List<TdmSubscriberRelationshipDO> getTdmSubscriberRelationships()
	{
		return this.tdmSubscriberRelationships;
	}

	public void setTdmSubscriberRelationships(
			List<TdmSubscriberRelationshipDO> tdmSubscriberRelationships)
	{
		this.tdmSubscriberRelationships = tdmSubscriberRelationships;
	}

	public TdmSubscriberRelationshipDO addTdmSubscriberRelationship(
			TdmSubscriberRelationshipDO tdmSubscriberRelationship)
	{
		getTdmSubscriberRelationships().add(tdmSubscriberRelationship);
		tdmSubscriberRelationship.setTdmSubscriber(this);

		return tdmSubscriberRelationship;
	}

	public TdmSubscriberRelationshipDO removeTdmSubscriberRelationship(
			TdmSubscriberRelationshipDO tdmSubscriberRelationship)
	{
		getTdmSubscriberRelationships().remove(tdmSubscriberRelationship);
		tdmSubscriberRelationship.setTdmSubscriber(null);

		return tdmSubscriberRelationship;
	}

	public List<TdmSuscriberAddressDO> getTdmSuscriberAddresses()
	{
		return this.tdmSuscriberAddresses;
	}

	public void setTdmSuscriberAddresses(List<TdmSuscriberAddressDO> tdmSuscriberAddresses)
	{
		this.tdmSuscriberAddresses = tdmSuscriberAddresses;
	}

	public TdmSuscriberAddressDO addTdmSuscriberAddress(TdmSuscriberAddressDO tdmSuscriberAddress)
	{
		getTdmSuscriberAddresses().add(tdmSuscriberAddress);
		tdmSuscriberAddress.setTdmSubscriber(this);

		return tdmSuscriberAddress;
	}

	public TdmSuscriberAddressDO removeTdmSuscriberAddress(TdmSuscriberAddressDO tdmSuscriberAddress)
	{
		getTdmSuscriberAddresses().remove(tdmSuscriberAddress);
		tdmSuscriberAddress.setTdmSubscriber(null);

		return tdmSuscriberAddress;
	}

}