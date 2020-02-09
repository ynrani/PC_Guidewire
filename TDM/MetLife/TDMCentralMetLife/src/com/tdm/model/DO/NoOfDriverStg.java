package com.tdm.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the NO_OF_DRIVER_STG database table.
 * 
 */
@Entity
@Table(name = "NO_OF_DRIVER_STG")
@NamedQuery(name = "NoOfDriverStg.findAll", query = "SELECT n FROM NoOfDriverStg n")
public class NoOfDriverStg implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "\"COUNT\"")
	private BigDecimal count;

	// single-directional many-to-one association to PolicySummaryStg
	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLICYDETAIL_ID")
	private PolicySummaryStg policySummaryStg;

	public NoOfDriverStg()
	{
	}

	public BigDecimal getCount() {
		return this.count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	public PolicySummaryStg getPolicySummaryStg() {
		return this.policySummaryStg;
	}

	public void setPolicySummaryStg(PolicySummaryStg policySummaryStg) {
		this.policySummaryStg = policySummaryStg;
	}

}