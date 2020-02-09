package com.tesda.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the COVERAGE_RISK_STG database table.
 * 
 */
@Entity
@Table(name = "COVERAGE_RISK_STG")
public class CoverageRiskStgDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String coveragecd;

	@Column(name = "POLICYDETAIL_ID")
	private String policydetailId;

	@Column(name = "RISK_POLICY_DTL_ID")
	private String riskPolicyDtlId;

	public CoverageRiskStgDO()
	{
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCoveragecd() {
		return this.coveragecd;
	}

	public void setCoveragecd(String coveragecd) {
		this.coveragecd = coveragecd;
	}

	public String getPolicydetailId() {
		return this.policydetailId;
	}

	public void setPolicydetailId(String policydetailId) {
		this.policydetailId = policydetailId;
	}

	public String getRiskPolicyDtlId() {
		return this.riskPolicyDtlId;
	}

	public void setRiskPolicyDtlId(String riskPolicyDtlId) {
		this.riskPolicyDtlId = riskPolicyDtlId;
	}

}