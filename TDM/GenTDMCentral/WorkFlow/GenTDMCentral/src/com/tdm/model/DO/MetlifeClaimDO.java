package com.tdm.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the METLIFE_CLAIM database table.
 * 
 */
@Entity
@Table(name = "METLIFE_CLAIM")
@NamedQuery(name = "MetlifeClaimDO.findAll", query = "SELECT m FROM MetlifeClaimDO m")
public class MetlifeClaimDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CLAIM_NUMBER")
	private String claimNumber;

	@Column(name = "AGENT_ID")
	private BigDecimal agentId;

	private String beneficiary;

	@Column(name = "CASH_ACCUM")
	private String cashAccum;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	private Timestamp dob;

	@Temporal(TemporalType.DATE)
	@Column(name = "EFF_DT")
	private Date effDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "EXP_DT")
	private Date expDt;

	@Column(name = "FACE_AMT")
	private BigDecimal faceAmt;

	@Column(name = "FRIST_NAME")
	private String fristName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "LOAN_AMT")
	private BigDecimal loanAmt;

	@Column(name = "LOAN_REPAY_AMT")
	private BigDecimal loanRepayAmt;

	private String owner;

	@Column(name = "PAYMENT_METHOD")
	private String paymentMethod;

	@Column(name = "PAYMENT_MODE")
	private String paymentMode;

	@Column(name = "POLICY_NUMBER")
	private String policyNumber;

	@Column(name = "POLICY_STS")
	private String policySts;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRODUCT_TYPE")
	private String productType;

	private String riders;

	@Column(name = "BENEFITS")
	private String benefits;

	private BigDecimal ssn;

	public MetlifeClaimDO()
	{
	}

	public String getClaimNumber() {
		return this.claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public BigDecimal getAgentId() {
		return this.agentId;
	}

	public void setAgentId(BigDecimal agentId) {
		this.agentId = agentId;
	}

	public String getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}

	public String getCashAccum() {
		return this.cashAccum;
	}

	public void setCashAccum(String cashAccum) {
		this.cashAccum = cashAccum;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Timestamp getDob() {
		return this.dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}

	public Date getEffDt() {
		return this.effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}

	public Date getExpDt() {
		return this.expDt;
	}

	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}

	public BigDecimal getFaceAmt() {
		return this.faceAmt;
	}

	public void setFaceAmt(BigDecimal faceAmt) {
		this.faceAmt = faceAmt;
	}

	public String getFristName() {
		return this.fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getLoanAmt() {
		return this.loanAmt;
	}

	public void setLoanAmt(BigDecimal loanAmt) {
		this.loanAmt = loanAmt;
	}

	public BigDecimal getLoanRepayAmt() {
		return this.loanRepayAmt;
	}

	public void setLoanRepayAmt(BigDecimal loanRepayAmt) {
		this.loanRepayAmt = loanRepayAmt;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentMode() {
		return this.paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPolicyNumber() {
		return this.policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicySts() {
		return this.policySts;
	}

	public void setPolicySts(String policySts) {
		this.policySts = policySts;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getRiders() {
		return this.riders;
	}

	public void setRiders(String riders) {
		this.riders = riders;
	}

	public BigDecimal getSsn() {
		return this.ssn;
	}

	public void setSsn(BigDecimal ssn) {
		this.ssn = ssn;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

}