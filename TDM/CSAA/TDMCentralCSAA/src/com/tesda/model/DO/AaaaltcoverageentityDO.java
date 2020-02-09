package com.tesda.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
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
 * The persistent class for the AAAALTCOVERAGEENTITY database table.
 * 
 */
@Entity
@Table(name = "AAAALTCOVERAGEENTITY")
@NamedQuery(name = "AaaaltcoverageentityDO.findAll", query = "SELECT a FROM AaaaltcoverageentityDO a")
public class AaaaltcoverageentityDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private BigDecimal additionallimitamount;

	private String coveragecd;

	private BigDecimal deductible;

	@Column(name = "\"LIMIT\"")
	private String limit;

	// bi-directional many-to-one association to RiskitemDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLEENTITY_ID")
	private RiskitemDO riskitem;

	public AaaaltcoverageentityDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAdditionallimitamount() {
		return this.additionallimitamount;
	}

	public void setAdditionallimitamount(BigDecimal additionallimitamount) {
		this.additionallimitamount = additionallimitamount;
	}

	public String getCoveragecd() {
		return this.coveragecd;
	}

	public void setCoveragecd(String coveragecd) {
		this.coveragecd = coveragecd;
	}

	public BigDecimal getDeductible() {
		return this.deductible;
	}

	public void setDeductible(BigDecimal deductible) {
		this.deductible = deductible;
	}

	public String getLimit() {
		return this.limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public RiskitemDO getRiskitem() {
		return this.riskitem;
	}

	public void setRiskitem(RiskitemDO riskitem) {
		this.riskitem = riskitem;
	}

}