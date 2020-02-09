package com.tesda.model.DO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the POLICY_SUMMARY_STG database table.
 * 
 */
@Entity
@Table(name = "POLICY_SUMMARY_STG")
@NamedQuery(name = "PolicySummaryStg.findAll", query = "SELECT p FROM PolicySummaryStg p")
public class PolicySummaryStg implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "POLICYDETAIL_ID")
	private String policydetailId;

	private String contracttermtypecd;

	private String currentrevisionind;

	@Column(name = "DOC_YN")
	private String docYn;

	@Temporal(TemporalType.DATE)
	private Date effective;

	@Temporal(TemporalType.DATE)
	private Date expiration;

	private String lob;

	@Column(name = "DOC_TYPE")
	private String docType;

	private String policyformcd;

	private String policynumber;

	private String policystatuscd;

	private String productcd;

	private String riskstatecd;

	private String timedpolicystatuscd;

	private String txtype;

	// bi-directional many-to-one association to CoverageRiskStg
	@OneToMany(mappedBy = "policySummaryStg", cascade = CascadeType.ALL)
	@BatchSize(size = 5)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<CoverageRiskStg> coverageRiskStgs;

	// bi-directional many-to-one association to CoverageStg
	@OneToMany(mappedBy = "policySummaryStg", cascade = CascadeType.ALL)
	@BatchSize(size = 5)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<CoverageStg> coverageStgs;

	// single-directional one-to-one association to NoOfDriverStg
	@OneToOne(mappedBy = "policySummaryStg", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private NoOfDriverStg noOfDriverStg;

	// single-directional one-to-one association to NoOfNameInsuStg
	@OneToOne(mappedBy = "policySummaryStg", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private NoOfNameInsuStg noOfNameInsuStg;

	// single-directional one-to-one association to NoOfVehiStg
	@OneToOne(mappedBy = "policySummaryStg", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private NoOfVehiStg noOfVehiStg;

	// single-directional one-to-one association to NoOfVioStg
	@OneToOne(mappedBy = "policySummaryStg", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private NoOfVioStg noOfVioStg;

	public PolicySummaryStg()
	{
	}

	public String getPolicydetailId() {
		return this.policydetailId;
	}

	public void setPolicydetailId(String policydetailId) {
		this.policydetailId = policydetailId;
	}

	public String getContracttermtypecd() {
		return this.contracttermtypecd;
	}

	public void setContracttermtypecd(String contracttermtypecd) {
		this.contracttermtypecd = contracttermtypecd;
	}

	public String getCurrentrevisionind() {
		return this.currentrevisionind;
	}

	public void setCurrentrevisionind(String currentrevisionind) {
		this.currentrevisionind = currentrevisionind;
	}

	public String getDocYn() {
		return this.docYn;
	}

	public void setDocYn(String docYn) {
		this.docYn = docYn;
	}

	public Date getEffective() {
		return this.effective;
	}

	public void setEffective(Date effective) {
		this.effective = effective;
	}

	public Date getExpiration() {
		return this.expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getLob() {
		return this.lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getPolicyformcd() {
		return this.policyformcd;
	}

	public void setPolicyformcd(String policyformcd) {
		this.policyformcd = policyformcd;
	}

	public String getPolicynumber() {
		return this.policynumber;
	}

	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}

	public String getPolicystatuscd() {
		return this.policystatuscd;
	}

	public void setPolicystatuscd(String policystatuscd) {
		this.policystatuscd = policystatuscd;
	}

	public String getProductcd() {
		return this.productcd;
	}

	public void setProductcd(String productcd) {
		this.productcd = productcd;
	}

	public String getRiskstatecd() {
		return this.riskstatecd;
	}

	public void setRiskstatecd(String riskstatecd) {
		this.riskstatecd = riskstatecd;
	}

	public String getTimedpolicystatuscd() {
		return this.timedpolicystatuscd;
	}

	public void setTimedpolicystatuscd(String timedpolicystatuscd) {
		this.timedpolicystatuscd = timedpolicystatuscd;
	}

	public String getTxtype() {
		return this.txtype;
	}

	public void setTxtype(String txtype) {
		this.txtype = txtype;
	}

	public List<CoverageStg> getCoverageStgs() {
		return this.coverageStgs;
	}

	public void setCoverageStgs(List<CoverageStg> coverageStgs) {
		this.coverageStgs = coverageStgs;
	}

	public CoverageStg addCoverageStg(CoverageStg coverageStg) {
		getCoverageStgs().add(coverageStg);
		coverageStg.setPolicySummaryStg(this);

		return coverageStg;
	}

	public CoverageStg removeCoverageStg(CoverageStg coverageStg) {
		getCoverageStgs().remove(coverageStg);
		coverageStg.setPolicySummaryStg(null);

		return coverageStg;
	}

	public CoverageRiskStg addCoverageRiskStg(CoverageRiskStg coverageRiskStg) {
		getCoverageRiskStgs().add(coverageRiskStg);
		coverageRiskStg.setPolicySummaryStg(this);

		return coverageRiskStg;
	}

	public CoverageRiskStg removeCoverageRiskStg(CoverageRiskStg coverageRiskStg) {
		getCoverageRiskStgs().remove(coverageRiskStg);
		coverageRiskStg.setPolicySummaryStg(null);

		return coverageRiskStg;
	}

	public List<CoverageRiskStg> getCoverageRiskStgs() {
		return coverageRiskStgs;
	}

	public void setCoverageRiskStg(List<CoverageRiskStg> coverageRiskStgs) {
		this.coverageRiskStgs = coverageRiskStgs;
	}

	public NoOfDriverStg getNoOfDriverStg() {
		return noOfDriverStg;
	}

	public void setNoOfDriverStg(NoOfDriverStg noOfDriverStg) {
		this.noOfDriverStg = noOfDriverStg;
	}

	public NoOfNameInsuStg getNoOfNameInsuStg() {
		return noOfNameInsuStg;
	}

	public void setNoOfNameInsuStg(NoOfNameInsuStg noOfNameInsuStg) {
		this.noOfNameInsuStg = noOfNameInsuStg;
	}

	public NoOfVehiStg getNoOfVehiStg() {
		return noOfVehiStg;
	}

	public void setNoOfVehiStg(NoOfVehiStg noOfVehiStg) {
		this.noOfVehiStg = noOfVehiStg;
	}

	public NoOfVioStg getNoOfVioStg() {
		return noOfVioStg;
	}

	public void setNoOfVioStg(NoOfVioStg noOfVioStg) {
		this.noOfVioStg = noOfVioStg;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public void setCoverageRiskStgs(List<CoverageRiskStg> coverageRiskStgs) {
		this.coverageRiskStgs = coverageRiskStgs;
	}

}