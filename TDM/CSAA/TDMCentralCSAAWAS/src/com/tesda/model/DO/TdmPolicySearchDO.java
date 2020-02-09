/*
 * Object Name : TdmPolicySearchDO.java
 * Modification Block
 * ------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ------------------------------------------------------------------
 * 	1.	  vkrish14		11:05:02 AM				Created
 * ------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.DO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author vkrish14
 *
 */
@Entity
@Table(name = "TDM_POLICYSEARCH")
@NamedQueries({
		@NamedQuery(name = "TdmPolicySearchDO.findAll", query = "SELECT r FROM TdmPolicySearchDO r"),
		@NamedQuery(name = "TdmPolicySearchDO.findByPolicyNumber", query = "SELECT r FROM TdmPolicySearchDO r where r.policynumber=:policynumber") })
public class TdmPolicySearchDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "POLICYNUMBER")
	private String policynumber;
	@Column(name = "POLICY_STAGE")
	private String policystage;
	@Column(name = "RISKSTATECD")
	private String riskstatecd;
	@Column(name = "POLICYSTATUSCD")
	private String policystatuscd;
	@Column(name = "TIMEDPOLICYSTATUSCD")
	private String timedpolicystatuscd;
	@Column(name = "TXTYPE")
	private String txtype;
	@Column(name = "LOB")
	private String lob;
	@Column(name = "POLICYFORMCD")
	private String policyformcd;
	@Column(name = "PRODUCTCD")
	private String productcd;
	@Column(name = "EFFECTIVE")
	private Date effectivedate;
	@Column(name = "EXPIRATION")
	private Date expirationdate;
	@Column(name = "POLICY_COVERAGE")
	private String policycoverage;
	@Column(name = "RISK_COVERAGE")
	private String risklevelcoverage;
	@Column(name = "NOOF_DRIVERS")
	private long noofdrivers;
	@Column(name = "NOOF_NAMEDINSURED")
	private long noofnamedinsured;
	@Column(name = "NOOF_VEHICLES")
	private long noofvehicles;
	@Column(name = "NOOF_VIOLATIONS")
	private long noofviolations;
	@Column(name = "DOCUMENT_TYPE")
	private String availabledocuments;
	@Column(name = "ASSOCIATED_PAYMENT")
	private String paymethod;
	@Column(name = "POLICYDETAIL_ID")
	private String policydetailid;
	@Column(name = "CONTRACTTERMTYPECD")
	private String policyterm;
	@Column(name = "PAYMENT_TYPE")
	private String availablepayments;

	public String getLob(){
		return lob;
	}

	public void setLob(String lob){
		this.lob = lob;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getPolicynumber(){
		return policynumber;
	}

	public void setPolicynumber(String policynumber){
		this.policynumber = policynumber;
	}

	public String getPolicystage(){
		return policystage;
	}

	public void setPolicystage(String policystage){
		this.policystage = policystage;
	}

	public String getRiskstatecd(){
		return riskstatecd;
	}

	public void setRiskstatecd(String riskstatecd){
		this.riskstatecd = riskstatecd;
	}

	public String getPolicyterm(){
		return policyterm;
	}

	public void setPolicyterm(String policyterm){
		this.policyterm = policyterm;
	}

	public Date getEffectivedate(){
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate){
		this.effectivedate = effectivedate;
	}

	public Date getExpirationdate(){
		return expirationdate;
	}

	public void setExpirationdate(Date expirationdate){
		this.expirationdate = expirationdate;
	}

	public String getRisklevelcoverage(){
		return risklevelcoverage;
	}

	public void setRisklevelcoverage(String risklevelcoverage){
		this.risklevelcoverage = risklevelcoverage;
	}

	public String getAvailablepayments(){
		return availablepayments;
	}

	public void setAvailablepayments(String availablepayments){
		this.availablepayments = availablepayments;
	}

	public long getNoofdrivers(){
		return noofdrivers;
	}

	public void setNoofdrivers(long noofdrivers){
		this.noofdrivers = noofdrivers;
	}

	public long getNoofvehicles(){
		return noofvehicles;
	}

	public void setNoofvehicles(long noofvehicles){
		this.noofvehicles = noofvehicles;
	}

	public long getNoofviolations(){
		return noofviolations;
	}

	public void setNoofviolations(long noofviolations){
		this.noofviolations = noofviolations;
	}

	public String getAvailabledocuments(){
		return availabledocuments;
	}

	public void setAvailabledocuments(String availabledocuments){
		this.availabledocuments = availabledocuments;
	}

	public String getPolicycoverage(){
		return policycoverage;
	}

	public void setPolicycoverage(String policycoverage){
		this.policycoverage = policycoverage;
	}

	public long getNoofnamedinsured(){
		return noofnamedinsured;
	}

	public void setNoofnamedinsured(long noofnamedinsured){
		this.noofnamedinsured = noofnamedinsured;
	}

	public String getPolicyformcd(){
		return policyformcd;
	}

	public void setPolicyformcd(String policyformcd){
		this.policyformcd = policyformcd;
	}

	public String getProductcd(){
		return productcd;
	}

	public void setProductcd(String productcd){
		this.productcd = productcd;
	}

	public String getPolicystatuscd(){
		return policystatuscd;
	}

	public void setPolicystatuscd(String policystatuscd){
		this.policystatuscd = policystatuscd;
	}

	public String getTimedpolicystatuscd(){
		return timedpolicystatuscd;
	}

	public void setTimedpolicystatuscd(String timedpolicystatuscd){
		this.timedpolicystatuscd = timedpolicystatuscd;
	}

	public String getTxtype(){
		return txtype;
	}

	public void setTxtype(String txtype){
		this.txtype = txtype;
	}

	public String getPolicydetailid(){
		return policydetailid;
	}

	public void setPolicydetailid(String policydetailid){
		this.policydetailid = policydetailid;
	}

	public String getPaymethod(){
		return paymethod;
	}

	public void setPaymethod(String paymethod){
		this.paymethod = paymethod;
	}
}
