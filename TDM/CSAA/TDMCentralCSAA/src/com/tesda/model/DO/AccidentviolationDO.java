package com.tesda.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the ACCIDENTVIOLATION database table.
 * 
 */
@Entity
@Table(name = "ACCIDENTVIOLATION")
@NamedQuery(name = "AccidentviolationDO.findAll", query = "SELECT a FROM AccidentviolationDO a")
public class AccidentviolationDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private BigDecimal accidentind;

	private String accidentviolationcd;

	private String countrycd;

	private String county;

	private String drivername;

	private String driveroid;

	private String dtype;

	private BigDecimal entitystatus;

	private String liabilitycd;

	private String policynumber;

	private String postalcode;

	// bi-directional many-to-one association to ContactentityDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCIDENTADDRESS_ID")
	private ContactentityDO contactentity;

	// bi-directional many-to-one association to DriverDO
	@ManyToOne(fetch = FetchType.LAZY)
	private DriverDO driver;

	// bi-directional many-to-one association to PolicysummaryDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLICY_ID")
	private PolicysummaryDO policysummary;

	// bi-directional many-to-one association to RiskitemDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLERISKITEM_ID")
	private RiskitemDO riskitem;

	public AccidentviolationDO()
	{
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAccidentind() {
		return accidentind;
	}

	public void setAccidentind(BigDecimal accidentind) {
		this.accidentind = accidentind;
	}

	public String getAccidentviolationcd() {
		return accidentviolationcd;
	}

	public void setAccidentviolationcd(String accidentviolationcd) {
		this.accidentviolationcd = accidentviolationcd;
	}

	public String getCountrycd() {
		return countrycd;
	}

	public void setCountrycd(String countrycd) {
		this.countrycd = countrycd;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public String getDriveroid() {
		return driveroid;
	}

	public void setDriveroid(String driveroid) {
		this.driveroid = driveroid;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public BigDecimal getEntitystatus() {
		return entitystatus;
	}

	public void setEntitystatus(BigDecimal entitystatus) {
		this.entitystatus = entitystatus;
	}

	public String getLiabilitycd() {
		return liabilitycd;
	}

	public void setLiabilitycd(String liabilitycd) {
		this.liabilitycd = liabilitycd;
	}

	public String getPolicynumber() {
		return policynumber;
	}

	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public ContactentityDO getContactentity() {
		return contactentity;
	}

	public void setContactentity(ContactentityDO contactentity) {
		this.contactentity = contactentity;
	}

	public DriverDO getDriver() {
		return driver;
	}

	public void setDriver(DriverDO driver) {
		this.driver = driver;
	}

	public PolicysummaryDO getPolicysummary() {
		return policysummary;
	}

	public void setPolicysummary(PolicysummaryDO policysummary) {
		this.policysummary = policysummary;
	}

	public RiskitemDO getRiskitem() {
		return riskitem;
	}

	public void setRiskitem(RiskitemDO riskitem) {
		this.riskitem = riskitem;
	}

}