package com.tesda.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the DRIVER database table.
 * 
 */
@Entity
@Table(name = "DRIVER")
@NamedQuery(name = "DriverDO.findAll", query = "SELECT d FROM DriverDO d")
public class DriverDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String carrierpolicynum;

	private String changestatus;

	@Column(name = "CLEARANCECHECK_ID")
	private BigDecimal clearancecheckId;

	@Column(name = "COMMUNICATIONDETAIL_ID")
	private BigDecimal communicationdetailId;

	@Column(name = "DRIVERINFO_ID")
	private BigDecimal driverinfoId;

	private BigDecimal drivernotinsuredind;

	@Column(name = "DRIVERRATINGINFO_ID")
	private BigDecimal driverratinginfoId;

	private String dtype;

	@Column(name = "LICENSEENTITY_ID")
	private BigDecimal licenseentityId;

	@Column(name = "OPERATESVEHICLE_ID")
	private BigDecimal operatesvehicleId;

	@Column(name = "POLICYDETAIL_ID")
	private BigDecimal policydetailId;

	private String policynumber;

	@Column(name = "POLICYPRIORCARRIER_ID")
	private BigDecimal policypriorcarrierId;

	private BigDecimal violationindicator;

	// bi-directional many-to-one association to AccidentviolationDO
	@OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
	private List<AccidentviolationDO> accidentviolations;

	// bi-directional many-to-one association to PolicysummaryDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AAADELETEDFROMPOLICY_ID")
	private PolicysummaryDO policysummary;

	public DriverDO()
	{
	}

	public List<AccidentviolationDO> getAccidentviolations() {
		return this.accidentviolations;
	}

	public void setAccidentviolations(List<AccidentviolationDO> accidentviolations) {
		this.accidentviolations = accidentviolations;
	}

	public AccidentviolationDO addAccidentviolation(AccidentviolationDO accidentviolation) {
		getAccidentviolations().add(accidentviolation);
		accidentviolation.setDriver(this);

		return accidentviolation;
	}

	public AccidentviolationDO removeAccidentviolation(AccidentviolationDO accidentviolation) {
		getAccidentviolations().remove(accidentviolation);
		accidentviolation.setDriver(null);

		return accidentviolation;
	}

	public PolicysummaryDO getPolicysummary() {
		return this.policysummary;
	}

	public void setPolicysummary(PolicysummaryDO policysummary) {
		this.policysummary = policysummary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCarrierpolicynum() {
		return carrierpolicynum;
	}

	public void setCarrierpolicynum(String carrierpolicynum) {
		this.carrierpolicynum = carrierpolicynum;
	}

	public String getChangestatus() {
		return changestatus;
	}

	public void setChangestatus(String changestatus) {
		this.changestatus = changestatus;
	}

	public BigDecimal getClearancecheckId() {
		return clearancecheckId;
	}

	public void setClearancecheckId(BigDecimal clearancecheckId) {
		this.clearancecheckId = clearancecheckId;
	}

	public BigDecimal getCommunicationdetailId() {
		return communicationdetailId;
	}

	public void setCommunicationdetailId(BigDecimal communicationdetailId) {
		this.communicationdetailId = communicationdetailId;
	}

	public BigDecimal getDriverinfoId() {
		return driverinfoId;
	}

	public void setDriverinfoId(BigDecimal driverinfoId) {
		this.driverinfoId = driverinfoId;
	}

	public BigDecimal getDrivernotinsuredind() {
		return drivernotinsuredind;
	}

	public void setDrivernotinsuredind(BigDecimal drivernotinsuredind) {
		this.drivernotinsuredind = drivernotinsuredind;
	}

	public BigDecimal getDriverratinginfoId() {
		return driverratinginfoId;
	}

	public void setDriverratinginfoId(BigDecimal driverratinginfoId) {
		this.driverratinginfoId = driverratinginfoId;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public BigDecimal getLicenseentityId() {
		return licenseentityId;
	}

	public void setLicenseentityId(BigDecimal licenseentityId) {
		this.licenseentityId = licenseentityId;
	}

	public BigDecimal getOperatesvehicleId() {
		return operatesvehicleId;
	}

	public void setOperatesvehicleId(BigDecimal operatesvehicleId) {
		this.operatesvehicleId = operatesvehicleId;
	}

	public BigDecimal getPolicydetailId() {
		return policydetailId;
	}

	public void setPolicydetailId(BigDecimal policydetailId) {
		this.policydetailId = policydetailId;
	}

	public String getPolicynumber() {
		return policynumber;
	}

	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}

	public BigDecimal getPolicypriorcarrierId() {
		return policypriorcarrierId;
	}

	public void setPolicypriorcarrierId(BigDecimal policypriorcarrierId) {
		this.policypriorcarrierId = policypriorcarrierId;
	}

	public BigDecimal getViolationindicator() {
		return violationindicator;
	}

	public void setViolationindicator(BigDecimal violationindicator) {
		this.violationindicator = violationindicator;
	}

}