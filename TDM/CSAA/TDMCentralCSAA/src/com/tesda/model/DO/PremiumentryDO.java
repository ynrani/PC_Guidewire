package com.tesda.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the PREMIUMENTRY database table.
 * 
 */
@Entity
@Table(name = "PREMIUMENTRY")
@NamedQuery(name = "PremiumentryDO.findAll", query = "SELECT p FROM PremiumentryDO p")
public class PremiumentryDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Timestamp effective;

	private BigDecimal entitystatus;

	private Timestamp expiration;

	@Column(name = "INSTALLMENTINFO_ID")
	private BigDecimal installmentinfoId;

	private BigDecimal periodamt;

	private BigDecimal premiumamt;

	private String premiumcd;

	private String premiumtype;

	@Column(name = "PREMIUMVARIATION_ID")
	private BigDecimal premiumvariationId;

	// bi-directional many-to-one association to CoverageDO
	@ManyToOne(fetch = FetchType.LAZY)
	private CoverageDO coverage;

	// bi-directional many-to-one association to PolicysummaryDO
	@ManyToOne(fetch = FetchType.LAZY)
	private PolicysummaryDO policysummary;

	// bi-directional many-to-one association to RiskitemDO
	@ManyToOne(fetch = FetchType.LAZY)
	private RiskitemDO riskitem;

	public PremiumentryDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getEffective() {
		return this.effective;
	}

	public void setEffective(Timestamp effective) {
		this.effective = effective;
	}

	public BigDecimal getEntitystatus() {
		return this.entitystatus;
	}

	public void setEntitystatus(BigDecimal entitystatus) {
		this.entitystatus = entitystatus;
	}

	public Timestamp getExpiration() {
		return this.expiration;
	}

	public void setExpiration(Timestamp expiration) {
		this.expiration = expiration;
	}

	public BigDecimal getInstallmentinfoId() {
		return this.installmentinfoId;
	}

	public void setInstallmentinfoId(BigDecimal installmentinfoId) {
		this.installmentinfoId = installmentinfoId;
	}

	public BigDecimal getPeriodamt() {
		return this.periodamt;
	}

	public void setPeriodamt(BigDecimal periodamt) {
		this.periodamt = periodamt;
	}

	public BigDecimal getPremiumamt() {
		return this.premiumamt;
	}

	public void setPremiumamt(BigDecimal premiumamt) {
		this.premiumamt = premiumamt;
	}

	public String getPremiumcd() {
		return this.premiumcd;
	}

	public void setPremiumcd(String premiumcd) {
		this.premiumcd = premiumcd;
	}

	public String getPremiumtype() {
		return this.premiumtype;
	}

	public void setPremiumtype(String premiumtype) {
		this.premiumtype = premiumtype;
	}

	public BigDecimal getPremiumvariationId() {
		return this.premiumvariationId;
	}

	public void setPremiumvariationId(BigDecimal premiumvariationId) {
		this.premiumvariationId = premiumvariationId;
	}

	public CoverageDO getCoverage() {
		return this.coverage;
	}

	public void setCoverage(CoverageDO coverage) {
		this.coverage = coverage;
	}

	public PolicysummaryDO getPolicysummary() {
		return this.policysummary;
	}

	public void setPolicysummary(PolicysummaryDO policysummary) {
		this.policysummary = policysummary;
	}

	public RiskitemDO getRiskitem() {
		return this.riskitem;
	}

	public void setRiskitem(RiskitemDO riskitem) {
		this.riskitem = riskitem;
	}

}