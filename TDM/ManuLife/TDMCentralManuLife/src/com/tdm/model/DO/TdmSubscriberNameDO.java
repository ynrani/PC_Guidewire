package com.tdm.model.DO;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TDM_SUBSCRIBER_NAME database table.
 * 
 */
@Entity
@Table(name="TDM_SUBSCRIBER_NAME")
@NamedQuery(name="TdmSubscriberNameDO.findAll", query="SELECT t FROM TdmSubscriberNameDO t")
public class TdmSubscriberNameDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SUBSCRIBER_NAME_ID")
	private long subscriberNameId;

	private String creator;

	@Column(name="DATE_CHANGED")
	private String dateChanged;

	@Column(name="DATE_CREATED")
	private String dateCreated;

	private String degree;

	@Column(name="FAMILY_NAME")
	private String familyName;

	@Column(name="FAMILY_NAME_PREFIX")
	private String familyNamePrefix;

	@Column(name="FAMILY_NAME_SUFFIX")
	private String familyNameSuffix;

	@Column(name="GIVEN_NAME")
	private String givenName;

	@Column(name="MIDDLE_NAME")
	private String middleName;

	@Column(name="PREFIX")
	private String prefix;

	//bi-directional many-to-one association to TdmSubscriberDO
	@OneToOne
	@JoinColumn(name="SUBSCRIBER_ID", insertable = false, updatable = false)
	private TdmSubscriberDO tdmSubscriber;

	public TdmSubscriberNameDO() {
	}

	public long getSubscriberNameId() {
		return this.subscriberNameId;
	}

	public void setSubscriberNameId(long subscriberNameId) {
		this.subscriberNameId = subscriberNameId;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDateChanged() {
		return this.dateChanged;
	}

	public void setDateChanged(String dateChanged) {
		this.dateChanged = dateChanged;
	}

	public String getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFamilyNamePrefix() {
		return this.familyNamePrefix;
	}

	public void setFamilyNamePrefix(String familyNamePrefix) {
		this.familyNamePrefix = familyNamePrefix;
	}

	public String getFamilyNameSuffix() {
		return this.familyNameSuffix;
	}

	public void setFamilyNameSuffix(String familyNameSuffix) {
		this.familyNameSuffix = familyNameSuffix;
	}

	public String getGivenName() {
		return this.givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public TdmSubscriberDO getTdmSubscriber() {
		return this.tdmSubscriber;
	}

	public void setTdmSubscriber(TdmSubscriberDO tdmSubscriber) {
		this.tdmSubscriber = tdmSubscriber;
	}

}