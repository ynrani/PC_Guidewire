package com.tdm.model.DO;


import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TDM_SUSCRIBER_ADDRESS database table.
 * 
 */
@Entity
@Table(name="TDM_SUSCRIBER_ADDRESS")
@NamedQuery(name="TdmSuscriberAddressDO.findAll", query="SELECT t FROM TdmSuscriberAddressDO t")
public class TdmSuscriberAddressDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SUBSCRIBER_ADDRESS_ID")
	private long subscriberAddressId;

	private String addrress1;

	private String addrress2;

	@Column(name="CHANGED_BY")
	private BigDecimal changedBy;

	@Column(name="CITY_VILLAGE")
	private String cityVillage;

	private String country;

	@Column(name="COUNTRY_DISTRICT")
	private String countryDistrict;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_CHANGED")
	private Date dateChanged;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	@Column(name="STATE_PROVINCE")
	private String stateProvince;

	@Column(name="ZIP_CODE")
	private String zipCode;

	//bi-directional many-to-one association to TdmSubscriberDO
	@ManyToOne
	@JoinColumn(name="SUBSCRIBER_ID", insertable = false, updatable = false)
	private TdmSubscriberDO tdmSubscriber;

	public TdmSuscriberAddressDO() {
	}

	public long getSubscriberAddressId() {
		return this.subscriberAddressId;
	}

	public void setSubscriberAddressId(long subscriberAddressId) {
		this.subscriberAddressId = subscriberAddressId;
	}

	public String getAddrress1() {
		return this.addrress1;
	}

	public void setAddrress1(String addrress1) {
		this.addrress1 = addrress1;
	}

	public String getAddrress2() {
		return this.addrress2;
	}

	public void setAddrress2(String addrress2) {
		this.addrress2 = addrress2;
	}

	public BigDecimal getChangedBy() {
		return this.changedBy;
	}

	public void setChangedBy(BigDecimal changedBy) {
		this.changedBy = changedBy;
	}

	public String getCityVillage() {
		return this.cityVillage;
	}

	public void setCityVillage(String cityVillage) {
		this.cityVillage = cityVillage;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryDistrict() {
		return this.countryDistrict;
	}

	public void setCountryDistrict(String countryDistrict) {
		this.countryDistrict = countryDistrict;
	}

	public Date getDateChanged() {
		return this.dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public TdmSubscriberDO getTdmSubscriber() {
		return this.tdmSubscriber;
	}

	public void setTdmSubscriber(TdmSubscriberDO tdmSubscriber) {
		this.tdmSubscriber = tdmSubscriber;
	}

}