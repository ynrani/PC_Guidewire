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
 * The persistent class for the COVERAGE_STG database table.
 * 
 */
@Entity
@Table(name = "COVERAGE_STG")
@NamedQuery(name = "CoverageStg.findAll", query = "SELECT c FROM CoverageStg c")
public class CoverageStg implements Serializable
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

	public CoverageStg()
	{
	}

	public String getCoveragecd() {
		return this.coveragecd;
	}

	public void setCoveragecd(String coveragecd) {
		this.coveragecd = coveragecd;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

}