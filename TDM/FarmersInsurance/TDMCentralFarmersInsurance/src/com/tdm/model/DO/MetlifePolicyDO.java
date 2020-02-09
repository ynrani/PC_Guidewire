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
 * The persistent class for the METLIFE_POLICY database table.
 * 
 */
@Entity
@Table(name = "METLIFE_POLICY")
@NamedQuery(name = "MetlifePolicyDO.findAll", query = "SELECT m FROM MetlifePolicyDO m")
public class MetlifePolicyDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "POLICY_NUMBER")
	private String policyNumber;

	@Column(name = "AGENT_ID")
	private BigDecimal agentId;

	private String beneficiary;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "DIST_CHNAL")
	private String distChnal;

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

	private String gender;

	@Column(name = "LAST_NAME")
	private String lastName;

	private String owner;

	@Column(name = "PAYMENT_METHOD")
	private String paymentMethod;

	@Column(name = "PAYMENT_MODE")
	private String paymentMode;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRODUCT_TYPE")
	private String productType;

	private String riders;

	private BigDecimal ssn;

	@Column(name = "BENEFITS")
	private String benefits;

	@Column(name = "\"STATE\"")
	private String state;

	public MetlifePolicyDO()
	{
	}

	public String getPolicyNumber() {
		return this.policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
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

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDistChnal() {
		return this.distChnal;
	}

	public void setDistChnal(String distChnal) {
		this.distChnal = distChnal;
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

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

}