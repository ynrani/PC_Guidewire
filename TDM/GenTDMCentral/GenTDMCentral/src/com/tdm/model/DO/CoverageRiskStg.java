package com.tdm.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the COVERAGE_RISK_STG database table.
 * 
 */
@Entity
@Table(name = "COVERAGE_RISK_STG")
@NamedQuery(name = "CoverageRiskStg.findAll", query = "SELECT c FROM CoverageRiskStg c")
public class CoverageRiskStg implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String coveragecd;

	@Id
	private String id;

	@Column(name = "POLICYDETAIL_ID")
	private String policyDetailId;
	// bi-directional many-to-one association to PolicySummaryStg
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLICYDETAIL_ID", insertable = false, updatable = false)
	private PolicySummaryStg policySummaryStg;

	public CoverageRiskStg()
	{
	}

	public PolicySummaryStg getPolicySummaryStg() {
		return this.policySummaryStg;
	}

	public void setPolicySummaryStg(PolicySummaryStg policySummaryStg) {
		this.policySummaryStg = policySummaryStg;
	}

	public String getPolicyDetailId() {
		return policyDetailId;
	}

	public void setPolicyDetailId(String policyDetailId) {
		this.policyDetailId = policyDetailId;
	}

	public String getCoveragecd() {
		return coveragecd;
	}

	public void setCoveragecd(String coveragecd) {
		this.coveragecd = coveragecd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}