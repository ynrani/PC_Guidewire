package com.tesda.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * The persistent class for the POLICYSUMMARY database table.
 * 
 */
@Entity
@Table(name = "POLICYSUMMARY")
@NamedQuery(name = "PolicysummaryDO.findAll", query = "SELECT p FROM PolicysummaryDO p")
public class PolicysummaryDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String policystatuscd;

	private String timedpolicystatuscd;

	private String contracttermtypecd;

	private String riskstatecd;

	private String productcd;

	private String policynumber;

	private String lob;

	private String supportingdata;

	private Timestamp effective;

	private Timestamp expiration;

	private String policyformcd;

	@Column(name = "PIPCOVENTITY_ID")
	private BigDecimal pipcoventityId;

	@Column(name = "POLICYDETAIL_ID")
	private long policydetailId;

	@Column(name = "POLICYISSUE_ID")
	private BigDecimal policyissueId;

	@Column(name = "POLICYPLAN_ID")
	private BigDecimal policyplanId;

	@Column(name = "POLICYPRIORCARRIER_ID")
	private BigDecimal policypriorcarrierId;

	@Column(name = "PPCREPORT_ID")
	private BigDecimal ppcreportId;

	@Column(name = "PPCREPORTORDER_ID")
	private BigDecimal ppcreportorderId;

	@Column(name = "PREFILLENTITY_ID")
	private BigDecimal prefillentityId;

	@Column(name = "PRINTINGINFO_ID")
	private BigDecimal printinginfoId;

	@Column(name = "RISKMETERREPORTORDER_ID")
	private BigDecimal riskmeterreportorderId;

	private Timestamp updatedon;

	@Column(name = "\"VERSION\"")
	private BigDecimal version;

	private BigDecimal ycf;

	// bi-directional many-to-one association to AaaunderwritingquestionDO
	@OneToMany(mappedBy = "policysummary", fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	private List<AaaunderwritingquestionDO> aaaunderwritingquestions;

	// bi-directional many-to-one association to AccidentviolationDO
	@OneToMany(mappedBy = "policysummary", fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<AccidentviolationDO> accidentviolations;

	// bi-directional many-to-one association to DriverDO
	@OneToMany(mappedBy = "policysummary")
	@BatchSize(size = 5)
	@LazyCollection(LazyCollectionOption.TRUE)
	private List<DriverDO> drivers;

	// bi-directional many-to-one association to OrderclueentityDO
	@OneToMany(mappedBy = "policysummary", fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	private List<OrderclueentityDO> orderclueentities;

	// bi-directional many-to-one association to PremiumentryDO
	@OneToMany(mappedBy = "policysummary", fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	private List<PremiumentryDO> premiumentries;

	public PolicysummaryDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContracttermtypecd() {
		return this.contracttermtypecd;
	}

	public void setContracttermtypecd(String contracttermtypecd) {
		this.contracttermtypecd = contracttermtypecd;
	}

	public BigDecimal getPipcoventityId() {
		return this.pipcoventityId;
	}

	public void setPipcoventityId(BigDecimal pipcoventityId) {
		this.pipcoventityId = pipcoventityId;
	}

	public long getPolicydetailId() {
		return this.policydetailId;
	}

	public void setPolicydetailId(long policydetailId) {
		this.policydetailId = policydetailId;
	}

	public BigDecimal getPolicyissueId() {
		return this.policyissueId;
	}

	public void setPolicyissueId(BigDecimal policyissueId) {
		this.policyissueId = policyissueId;
	}

	public String getPolicynumber() {
		return this.policynumber;
	}

	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}

	public BigDecimal getPolicyplanId() {
		return this.policyplanId;
	}

	public void setPolicyplanId(BigDecimal policyplanId) {
		this.policyplanId = policyplanId;
	}

	public BigDecimal getPolicypriorcarrierId() {
		return this.policypriorcarrierId;
	}

	public void setPolicypriorcarrierId(BigDecimal policypriorcarrierId) {
		this.policypriorcarrierId = policypriorcarrierId;
	}

	public String getPolicystatuscd() {
		return this.policystatuscd;
	}

	public void setPolicystatuscd(String policystatuscd) {
		this.policystatuscd = policystatuscd;
	}

	public BigDecimal getPpcreportId() {
		return this.ppcreportId;
	}

	public void setPpcreportId(BigDecimal ppcreportId) {
		this.ppcreportId = ppcreportId;
	}

	public BigDecimal getPpcreportorderId() {
		return this.ppcreportorderId;
	}

	public void setPpcreportorderId(BigDecimal ppcreportorderId) {
		this.ppcreportorderId = ppcreportorderId;
	}

	public BigDecimal getPrefillentityId() {
		return this.prefillentityId;
	}

	public void setPrefillentityId(BigDecimal prefillentityId) {
		this.prefillentityId = prefillentityId;
	}

	public BigDecimal getPrintinginfoId() {
		return this.printinginfoId;
	}

	public void setPrintinginfoId(BigDecimal printinginfoId) {
		this.printinginfoId = printinginfoId;
	}

	public String getProductcd() {
		return this.productcd;
	}

	public void setProductcd(String productcd) {
		this.productcd = productcd;
	}

	public BigDecimal getRiskmeterreportorderId() {
		return this.riskmeterreportorderId;
	}

	public void setRiskmeterreportorderId(BigDecimal riskmeterreportorderId) {
		this.riskmeterreportorderId = riskmeterreportorderId;
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

	public Timestamp getUpdatedon() {
		return this.updatedon;
	}

	public void setUpdatedon(Timestamp updatedon) {
		this.updatedon = updatedon;
	}

	public BigDecimal getVersion() {
		return this.version;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

	public BigDecimal getYcf() {
		return this.ycf;
	}

	public void setYcf(BigDecimal ycf) {
		this.ycf = ycf;
	}

	public List<AaaunderwritingquestionDO> getAaaunderwritingquestions() {
		return this.aaaunderwritingquestions;
	}

	public void setAaaunderwritingquestions(List<AaaunderwritingquestionDO> aaaunderwritingquestions) {
		this.aaaunderwritingquestions = aaaunderwritingquestions;
	}

	public AaaunderwritingquestionDO addAaaunderwritingquestion(
			AaaunderwritingquestionDO aaaunderwritingquestion) {
		getAaaunderwritingquestions().add(aaaunderwritingquestion);
		aaaunderwritingquestion.setPolicysummary(this);

		return aaaunderwritingquestion;
	}

	public AaaunderwritingquestionDO removeAaaunderwritingquestion(
			AaaunderwritingquestionDO aaaunderwritingquestion) {
		getAaaunderwritingquestions().remove(aaaunderwritingquestion);
		aaaunderwritingquestion.setPolicysummary(null);

		return aaaunderwritingquestion;
	}

	public List<AccidentviolationDO> getAccidentviolations() {
		return this.accidentviolations;
	}

	public void setAccidentviolations(List<AccidentviolationDO> accidentviolations) {
		this.accidentviolations = accidentviolations;
	}

	public AccidentviolationDO addAccidentviolation(AccidentviolationDO accidentviolation) {
		getAccidentviolations().add(accidentviolation);
		accidentviolation.setPolicysummary(this);

		return accidentviolation;
	}

	public AccidentviolationDO removeAccidentviolation(AccidentviolationDO accidentviolation) {
		getAccidentviolations().remove(accidentviolation);
		accidentviolation.setPolicysummary(null);

		return accidentviolation;
	}

	public List<DriverDO> getDrivers() {
		return this.drivers;
	}

	public void setDrivers(List<DriverDO> drivers) {
		this.drivers = drivers;
	}

	public DriverDO addDriver(DriverDO driver) {
		getDrivers().add(driver);
		driver.setPolicysummary(this);

		return driver;
	}

	public DriverDO removeDriver(DriverDO driver) {
		getDrivers().remove(driver);
		driver.setPolicysummary(null);

		return driver;
	}

	public List<OrderclueentityDO> getOrderclueentities() {
		return this.orderclueentities;
	}

	public void setOrderclueentities(List<OrderclueentityDO> orderclueentities) {
		this.orderclueentities = orderclueentities;
	}

	public OrderclueentityDO addOrderclueentity(OrderclueentityDO orderclueentity) {
		getOrderclueentities().add(orderclueentity);
		orderclueentity.setPolicysummary(this);

		return orderclueentity;
	}

	public OrderclueentityDO removeOrderclueentity(OrderclueentityDO orderclueentity) {
		getOrderclueentities().remove(orderclueentity);
		orderclueentity.setPolicysummary(null);

		return orderclueentity;
	}

	public List<PremiumentryDO> getPremiumentries() {
		return premiumentries;
	}

	public void setPremiumentries(List<PremiumentryDO> premiumentries) {
		this.premiumentries = premiumentries;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getSupportingdata() {
		return this.supportingdata;
	}

	public void setSupportingdata(String supportingdata) {
		this.supportingdata = supportingdata;
	}

	public Timestamp getEffective() {
		return this.effective;
	}

	public void setEffective(Timestamp effective) {
		this.effective = effective;
	}

	public Timestamp getExpiration() {
		return this.expiration;
	}

	public void setExpiration(Timestamp expiration) {
		this.expiration = expiration;
	}

	public String getPolicyformcd() {
		return this.policyformcd;
	}

	public void setPolicyformcd(String policyformcd) {
		this.policyformcd = policyformcd;
	}

}