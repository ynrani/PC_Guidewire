package com.tesda.model.DO;

import java.io.Serializable;
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
 * The persistent class for the TDM_RESERVATION database table.
 * 
 */
@Entity
@Table(name = "TDM_RESERVATION")
@NamedQuery(name = "TdmReservationDO.findAll", query = "SELECT t FROM TdmReservationDO t")
public class TdmReservationDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	// @SequenceGenerator(name = "RESERVATION_1_ID_SEQ", sequenceName = "ID_SEQ", allocationSize =
	// 1)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESERVATION_1_ID_SEQ")
	@Column(name = "RECORD_ID")
	private long recordId;

	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "Product_Type")
	private String productType;

	@Column(name = "Construction_Type")
	private String constructionType;

	@Column(name = "Valuation_Method")
	private String valuationMethod;

	@Column(name = "Year_Built")
	private String yearBuilt;

	@Column(name = "Roof_Year")
	private String roofYear;

	@Column(name = "Documents_Type")
	private String documentType;

	@Column(name = "Policy_Coverage")
	private String policyCoverage;

	@Column(name = "No_of_Drivers")
	private long noOfDrivers;

	@Column(name = "No_of_Vehicles")
	private long noOfVehicles;

	@Column(name = "No_of_Violations")
	private long noOfViolations;

	@Column(name = "Available_Documents")
	private String availableDocs;

	@Column(name = "PROJECT_ID")
	private String projectId;

	@Temporal(TemporalType.DATE)
	@Column(name = "Expires_On")
	private Date expiresOn;

	@Column(name = "TEST_CASE_ID")
	private String testCaseId;

	@Column(name = "TEST_CASE_NAME")
	private String testCaseName;

	@Column(name = "Policy_Number")
	private String policyNumber;

	@Column(name = "Risk_State")
	private String riskState;

	@Column(name = "Search_Scenario")
	private String searchScenario;

	@Column(name = "Policy_Term")
	private String policyTerm;

	@Column(name = "Policy_Status")
	private String policyStatus;

	@Temporal(TemporalType.DATE)
	@Column(name = "Effective_Date")
	private Date effectivedate;

	@Temporal(TemporalType.DATE)
	@Column(name = "Expiration_Date")
	private Date expirationdate;

	@Column(name = "Available_Payments")
	private String availablePay;

	@Column(name = "RESERVE_DATA_TYPE")
	private String reserveDataType;

	@Column(name = "USER_ENV")
	private String USER_ENV;

	@Column(name = "UNLOCK_TIME")
	private Timestamp unlockTime;

	@Column(name = "POLICYDETAIL_ID")
	private long policyDetailId;

	private String unreserve;
	private String locked;

	public TdmReservationDO()
	{
	}

	public String getUSER_ENV() {
		return USER_ENV;
	}

	public void setUSER_ENV(String uSER_ENV) {
		USER_ENV = uSER_ENV;
	}

	public void setAvailableDocs(String availableDocs) {
		this.availableDocs = availableDocs;
	}

	public String getLocked() {
		return this.locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	/*
	 * public String getReserveData() { return this.reserveData; }
	 * 
	 * public void setReserveData(String reserveData) { this.reserveData = reserveData; }
	 */

	public String getReserveDataType() {
		return this.reserveDataType;
	}

	public void setReserveDataType(String reserveDataType) {
		this.reserveDataType = reserveDataType;
	}

	/*
	 * public String getRowData() { return this.rowData; }
	 * 
	 * public void setRowData(String rowData) { this.rowData = rowData; }
	 */

	public Timestamp getUnlockTime() {
		return this.unlockTime;
	}

	public void setUnlockTime(Timestamp unlockTime) {
		this.unlockTime = unlockTime;
	}

	public String getUnreserve() {
		return this.unreserve;
	}

	public void setUnreserve(String unreserve) {
		this.unreserve = unreserve;
	}

	public long getRecordId() {
		return recordId;
	}

	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/*
	 * public String getReserveDataId() { return reserveDataId; }
	 * 
	 * public void setReserveDataId(String reserveDataId) { this.reserveDataId = reserveDataId; }
	 * 
	 * public String getTestCaseName() { return testCaseName; }
	 */

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public String getTestCaseId() {
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getConstructionType() {
		return constructionType;
	}

	public void setConstructionType(String constructionType) {
		this.constructionType = constructionType;
	}

	public String getValuationMethod() {
		return valuationMethod;
	}

	public void setValuationMethod(String valuationMethod) {
		this.valuationMethod = valuationMethod;
	}

	public String getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(String yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public String getRoofYear() {
		return roofYear;
	}

	public void setRoofYear(String roofYear) {
		this.roofYear = roofYear;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getPolicyCoverage() {
		return policyCoverage;
	}

	public void setPolicyCoverage(String policyCoverage) {
		this.policyCoverage = policyCoverage;
	}

	public long getNoOfDrivers() {
		return noOfDrivers;
	}

	public void setNoOfDrivers(long noOfDrivers) {
		this.noOfDrivers = noOfDrivers;
	}

	public long getNoOfVehicles() {
		return noOfVehicles;
	}

	public void setNoOfVehicles(long noOfVehicles) {
		this.noOfVehicles = noOfVehicles;
	}

	public long getNoOfViolations() {
		return noOfViolations;
	}

	public void setNoOfViolations(long noOfViolations) {
		this.noOfViolations = noOfViolations;
	}

	public String getAvailableDocs() {
		return availableDocs;
	}

	public void setAvaliableDocs(String availableDocs) {
		this.availableDocs = availableDocs;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getRiskState() {
		return riskState;
	}

	public void setRiskState(String riskState) {
		this.riskState = riskState;
	}

	public String getSearchScenario() {
		return searchScenario;
	}

	public void setSearchScenario(String searchScenario) {
		this.searchScenario = searchScenario;
	}

	public String getPolicyTerm() {
		return policyTerm;
	}

	public void setPolicyTerm(String policyTerm) {
		this.policyTerm = policyTerm;
	}

	public String getAvailablePay() {
		return availablePay;
	}

	public void setAvailablePay(String availablePay) {
		this.availablePay = availablePay;
	}

	public Date getExpiresOn() {
		return expiresOn;
	}

	public void setExpiresOn(Date expiresOn) {
		this.expiresOn = expiresOn;
	}

	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public Date getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(Date expirationdate) {
		this.expirationdate = expirationdate;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public long getPolicyDetailId() {
		return policyDetailId;
	}

	public void setPolicyDetailId(long policyDetailId) {
		this.policyDetailId = policyDetailId;
	}

}