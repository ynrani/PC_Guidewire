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

import org.hibernate.annotations.BatchSize;

/**
 * The persistent class for the RISKITEM database table.
 * 
 */
@Entity
@Table(name = "RISKITEM")
@NamedQuery(name = "RiskitemDO.findAll", query = "SELECT r FROM RiskitemDO r")
public class RiskitemDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "AAADELETEDFROMPOLICY_ID")
	private BigDecimal aaadeletedfrompolicyId;

	@Column(name = "ACTUAL_AMT")
	private BigDecimal actualAmt;

	private BigDecimal amount;

	@Column(name = "ANNUALAMOUNT_AMT")
	private BigDecimal annualamountAmt;

	@Column(name = "APPLIEDVEHICLEDISCOUNTS_ID")
	private BigDecimal appliedvehiclediscountsId;

	@Column(name = "APRP_AMT")
	private BigDecimal aprpAmt;

	private String carrierpolicynum;

	@Column(name = "CLEARANCECHECK_ID")
	private BigDecimal clearancecheckId;

	private String collcoveragecd;

	@Column(name = "COLLECTORINFO_ID")
	private BigDecimal collectorinfoId;

	@Column(name = "COMMISSIONS_AMT")
	private BigDecimal commissionsAmt;

	@Column(name = "COMMISSIONS_CURCD")
	private String commissionsCurcd;

	private String compcoveragecd;

	@Column(name = "CONSTRUCTIONINFO_ID")
	private BigDecimal constructioninfoId;

	private String coveragetypecd;

	private BigDecimal discountsamount;

	private String dtype;

	@Column(name = "DWELLDETAIL_ID")
	private BigDecimal dwelldetailId;

	@Column(name = "DWELLINGESTIMATIONENTITY_ID")
	private BigDecimal dwellingestimationentityId;

	@Column(name = "DWELLORDERCLUEENTITY_ID")
	private BigDecimal dwellorderclueentityId;

	private BigDecimal entitystatus;

	@Column(name = "FIRELINEDETAILS_ID")
	private BigDecimal firelinedetailsId;

	@Column(name = "GARAGINGADDRESS_ID")
	private BigDecimal garagingaddressId;

	@Column(name = "INSPECTIONREQUESTENTITY_ID")
	private BigDecimal inspectionrequestentityId;

	@Column(name = "\"LENGTH\"")
	private BigDecimal length;

	@Column(name = "MARKETING_ID")
	private BigDecimal marketingId;

	@Column(name = "MISCINFO_ID")
	private BigDecimal miscinfoId;

	@Column(name = "MOORINGINFO_ID")
	private BigDecimal mooringinfoId;

	@Column(name = "OTHERORPRIORPOLICY_ID")
	private BigDecimal otherorpriorpolicyId;

	@Column(name = "POLICYDETAIL_ID")
	private BigDecimal policydetailId;

	@Column(name = "POLICYPRIORCARRIER_ID")
	private BigDecimal policypriorcarrierId;

	private String policytypecd;

	@Column(name = "PPCDETAILS_ID")
	private BigDecimal ppcdetailsId;

	@Column(name = "PRIORDWELLORDERCLUEENTITY_ID")
	private BigDecimal priordwellorderclueentityId;

	@Column(name = "RATINGINFO_ID")
	private BigDecimal ratinginfoId;

	@Column(name = "REGISTEREDOWNER_ID")
	private BigDecimal registeredownerId;

	@Column(name = "RISKITEM_ID")
	private BigDecimal riskitemId;

	@Column(name = "RISKMETERDETAILS_ID")
	private BigDecimal riskmeterdetailsId;

	@Column(name = "TERM_AMT")
	private BigDecimal termAmt;

	@Column(name = "UMBRELLAWATERCRAFT_ID")
	private BigDecimal umbrellawatercraftId;

	@Column(name = "VEHICLEOWNERSHIP_ID")
	private BigDecimal vehicleownershipId;

	private BigDecimal vehlength;

	@Column(name = "VEHQUESTIONNAIRE_ID")
	private BigDecimal vehquestionnaireId;

	@Column(name = "\"YEAR\"")
	private BigDecimal year;

	// bi-directional many-to-one association to AaaaltcoverageentityDO
	@OneToMany(mappedBy = "riskitem", fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	private List<AaaaltcoverageentityDO> aaaaltcoverageentities;

	// bi-directional many-to-one association to AccidentviolationDO
	@OneToMany(mappedBy = "riskitem", fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	private List<AccidentviolationDO> accidentviolations;

	// bi-directional many-to-one association to CoverageDO
	@OneToMany(mappedBy = "riskitem", fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	private List<CoverageDO> coverages;

	// bi-directional many-to-one association to PremiumentryDO
	@OneToMany(mappedBy = "riskitem", fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	private List<PremiumentryDO> premiumentries;

	// bi-directional many-to-one association to RegisteredownerinfoDO
	@OneToMany(mappedBy = "riskitem1", fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	private List<RegisteredownerinfoDO> registeredownerinfos1;

	// bi-directional many-to-one association to RegisteredownerinfoDO
	@OneToMany(mappedBy = "riskitem2", fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	private List<RegisteredownerinfoDO> registeredownerinfos2;

	// bi-directional many-to-one association to ContactentityDO
	@ManyToOne(fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	@JoinColumn(name = "GARAGINGADDRESSCONTACT_ID")
	private ContactentityDO contactentity;

	public RiskitemDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAaadeletedfrompolicyId() {
		return this.aaadeletedfrompolicyId;
	}

	public void setAaadeletedfrompolicyId(BigDecimal aaadeletedfrompolicyId) {
		this.aaadeletedfrompolicyId = aaadeletedfrompolicyId;
	}

	public List<AaaaltcoverageentityDO> getAaaaltcoverageentities() {
		return this.aaaaltcoverageentities;
	}

	public void setAaaaltcoverageentities(List<AaaaltcoverageentityDO> aaaaltcoverageentities) {
		this.aaaaltcoverageentities = aaaaltcoverageentities;
	}

	public AaaaltcoverageentityDO addAaaaltcoverageentity(
			AaaaltcoverageentityDO aaaaltcoverageentity) {
		getAaaaltcoverageentities().add(aaaaltcoverageentity);
		aaaaltcoverageentity.setRiskitem(this);

		return aaaaltcoverageentity;
	}

	public AaaaltcoverageentityDO removeAaaaltcoverageentity(
			AaaaltcoverageentityDO aaaaltcoverageentity) {
		getAaaaltcoverageentities().remove(aaaaltcoverageentity);
		aaaaltcoverageentity.setRiskitem(null);

		return aaaaltcoverageentity;
	}

	public List<AccidentviolationDO> getAccidentviolations() {
		return this.accidentviolations;
	}

	public void setAccidentviolations(List<AccidentviolationDO> accidentviolations) {
		this.accidentviolations = accidentviolations;
	}

	public AccidentviolationDO addAccidentviolation(AccidentviolationDO accidentviolation) {
		getAccidentviolations().add(accidentviolation);
		accidentviolation.setRiskitem(this);

		return accidentviolation;
	}

	public AccidentviolationDO removeAccidentviolation(AccidentviolationDO accidentviolation) {
		getAccidentviolations().remove(accidentviolation);
		accidentviolation.setRiskitem(null);

		return accidentviolation;
	}

	public List<CoverageDO> getCoverages() {
		return this.coverages;
	}

	public void setCoverages(List<CoverageDO> coverages) {
		this.coverages = coverages;
	}

	public CoverageDO addCoverage(CoverageDO coverage) {
		getCoverages().add(coverage);
		coverage.setRiskitem(this);

		return coverage;
	}

	public CoverageDO removeCoverage(CoverageDO coverage) {
		getCoverages().remove(coverage);
		coverage.setRiskitem(null);

		return coverage;
	}

	public List<PremiumentryDO> getPremiumentries() {
		return this.premiumentries;
	}

	public void setPremiumentries(List<PremiumentryDO> premiumentries) {
		this.premiumentries = premiumentries;
	}

	public PremiumentryDO addPremiumentry(PremiumentryDO premiumentry) {
		getPremiumentries().add(premiumentry);
		premiumentry.setRiskitem(this);

		return premiumentry;
	}

	public PremiumentryDO removePremiumentry(PremiumentryDO premiumentry) {
		getPremiumentries().remove(premiumentry);
		premiumentry.setRiskitem(null);

		return premiumentry;
	}

	public List<RegisteredownerinfoDO> getRegisteredownerinfos1() {
		return this.registeredownerinfos1;
	}

	public void setRegisteredownerinfos1(List<RegisteredownerinfoDO> registeredownerinfos1) {
		this.registeredownerinfos1 = registeredownerinfos1;
	}

	public RegisteredownerinfoDO addRegisteredownerinfos1(
			RegisteredownerinfoDO registeredownerinfos1) {
		getRegisteredownerinfos1().add(registeredownerinfos1);
		registeredownerinfos1.setRiskitem1(this);

		return registeredownerinfos1;
	}

	public RegisteredownerinfoDO removeRegisteredownerinfos1(
			RegisteredownerinfoDO registeredownerinfos1) {
		getRegisteredownerinfos1().remove(registeredownerinfos1);
		registeredownerinfos1.setRiskitem1(null);

		return registeredownerinfos1;
	}

	public List<RegisteredownerinfoDO> getRegisteredownerinfos2() {
		return this.registeredownerinfos2;
	}

	public void setRegisteredownerinfos2(List<RegisteredownerinfoDO> registeredownerinfos2) {
		this.registeredownerinfos2 = registeredownerinfos2;
	}

	public RegisteredownerinfoDO addRegisteredownerinfos2(
			RegisteredownerinfoDO registeredownerinfos2) {
		getRegisteredownerinfos2().add(registeredownerinfos2);
		registeredownerinfos2.setRiskitem2(this);

		return registeredownerinfos2;
	}

	public RegisteredownerinfoDO removeRegisteredownerinfos2(
			RegisteredownerinfoDO registeredownerinfos2) {
		getRegisteredownerinfos2().remove(registeredownerinfos2);
		registeredownerinfos2.setRiskitem2(null);

		return registeredownerinfos2;
	}

	public ContactentityDO getContactentity() {
		return this.contactentity;
	}

	public void setContactentity(ContactentityDO contactentity) {
		this.contactentity = contactentity;
	}

	public BigDecimal getActualAmt() {
		return actualAmt;
	}

	public void setActualAmt(BigDecimal actualAmt) {
		this.actualAmt = actualAmt;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAnnualamountAmt() {
		return annualamountAmt;
	}

	public void setAnnualamountAmt(BigDecimal annualamountAmt) {
		this.annualamountAmt = annualamountAmt;
	}

	public BigDecimal getAppliedvehiclediscountsId() {
		return appliedvehiclediscountsId;
	}

	public void setAppliedvehiclediscountsId(BigDecimal appliedvehiclediscountsId) {
		this.appliedvehiclediscountsId = appliedvehiclediscountsId;
	}

	public BigDecimal getAprpAmt() {
		return aprpAmt;
	}

	public void setAprpAmt(BigDecimal aprpAmt) {
		this.aprpAmt = aprpAmt;
	}

	public String getCarrierpolicynum() {
		return carrierpolicynum;
	}

	public void setCarrierpolicynum(String carrierpolicynum) {
		this.carrierpolicynum = carrierpolicynum;
	}

	public BigDecimal getClearancecheckId() {
		return clearancecheckId;
	}

	public void setClearancecheckId(BigDecimal clearancecheckId) {
		this.clearancecheckId = clearancecheckId;
	}

	public String getCollcoveragecd() {
		return collcoveragecd;
	}

	public void setCollcoveragecd(String collcoveragecd) {
		this.collcoveragecd = collcoveragecd;
	}

	public BigDecimal getCollectorinfoId() {
		return collectorinfoId;
	}

	public void setCollectorinfoId(BigDecimal collectorinfoId) {
		this.collectorinfoId = collectorinfoId;
	}

	public BigDecimal getCommissionsAmt() {
		return commissionsAmt;
	}

	public void setCommissionsAmt(BigDecimal commissionsAmt) {
		this.commissionsAmt = commissionsAmt;
	}

	public String getCommissionsCurcd() {
		return commissionsCurcd;
	}

	public void setCommissionsCurcd(String commissionsCurcd) {
		this.commissionsCurcd = commissionsCurcd;
	}

	public String getCompcoveragecd() {
		return compcoveragecd;
	}

	public void setCompcoveragecd(String compcoveragecd) {
		this.compcoveragecd = compcoveragecd;
	}

	public BigDecimal getConstructioninfoId() {
		return constructioninfoId;
	}

	public void setConstructioninfoId(BigDecimal constructioninfoId) {
		this.constructioninfoId = constructioninfoId;
	}

	public String getCoveragetypecd() {
		return coveragetypecd;
	}

	public void setCoveragetypecd(String coveragetypecd) {
		this.coveragetypecd = coveragetypecd;
	}

	public BigDecimal getDiscountsamount() {
		return discountsamount;
	}

	public void setDiscountsamount(BigDecimal discountsamount) {
		this.discountsamount = discountsamount;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public BigDecimal getDwelldetailId() {
		return dwelldetailId;
	}

	public void setDwelldetailId(BigDecimal dwelldetailId) {
		this.dwelldetailId = dwelldetailId;
	}

	public BigDecimal getDwellingestimationentityId() {
		return dwellingestimationentityId;
	}

	public void setDwellingestimationentityId(BigDecimal dwellingestimationentityId) {
		this.dwellingestimationentityId = dwellingestimationentityId;
	}

	public BigDecimal getDwellorderclueentityId() {
		return dwellorderclueentityId;
	}

	public void setDwellorderclueentityId(BigDecimal dwellorderclueentityId) {
		this.dwellorderclueentityId = dwellorderclueentityId;
	}

	public BigDecimal getEntitystatus() {
		return entitystatus;
	}

	public void setEntitystatus(BigDecimal entitystatus) {
		this.entitystatus = entitystatus;
	}

	public BigDecimal getFirelinedetailsId() {
		return firelinedetailsId;
	}

	public void setFirelinedetailsId(BigDecimal firelinedetailsId) {
		this.firelinedetailsId = firelinedetailsId;
	}

	public BigDecimal getGaragingaddressId() {
		return garagingaddressId;
	}

	public void setGaragingaddressId(BigDecimal garagingaddressId) {
		this.garagingaddressId = garagingaddressId;
	}

	public BigDecimal getInspectionrequestentityId() {
		return inspectionrequestentityId;
	}

	public void setInspectionrequestentityId(BigDecimal inspectionrequestentityId) {
		this.inspectionrequestentityId = inspectionrequestentityId;
	}

	public BigDecimal getLength() {
		return length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public BigDecimal getMarketingId() {
		return marketingId;
	}

	public void setMarketingId(BigDecimal marketingId) {
		this.marketingId = marketingId;
	}

	public BigDecimal getMiscinfoId() {
		return miscinfoId;
	}

	public void setMiscinfoId(BigDecimal miscinfoId) {
		this.miscinfoId = miscinfoId;
	}

	public BigDecimal getMooringinfoId() {
		return mooringinfoId;
	}

	public void setMooringinfoId(BigDecimal mooringinfoId) {
		this.mooringinfoId = mooringinfoId;
	}

	public BigDecimal getOtherorpriorpolicyId() {
		return otherorpriorpolicyId;
	}

	public void setOtherorpriorpolicyId(BigDecimal otherorpriorpolicyId) {
		this.otherorpriorpolicyId = otherorpriorpolicyId;
	}

	public BigDecimal getPolicydetailId() {
		return policydetailId;
	}

	public void setPolicydetailId(BigDecimal policydetailId) {
		this.policydetailId = policydetailId;
	}

	public BigDecimal getPolicypriorcarrierId() {
		return policypriorcarrierId;
	}

	public void setPolicypriorcarrierId(BigDecimal policypriorcarrierId) {
		this.policypriorcarrierId = policypriorcarrierId;
	}

	public String getPolicytypecd() {
		return policytypecd;
	}

	public void setPolicytypecd(String policytypecd) {
		this.policytypecd = policytypecd;
	}

	public BigDecimal getPpcdetailsId() {
		return ppcdetailsId;
	}

	public void setPpcdetailsId(BigDecimal ppcdetailsId) {
		this.ppcdetailsId = ppcdetailsId;
	}

	public BigDecimal getPriordwellorderclueentityId() {
		return priordwellorderclueentityId;
	}

	public void setPriordwellorderclueentityId(BigDecimal priordwellorderclueentityId) {
		this.priordwellorderclueentityId = priordwellorderclueentityId;
	}

	public BigDecimal getRatinginfoId() {
		return ratinginfoId;
	}

	public void setRatinginfoId(BigDecimal ratinginfoId) {
		this.ratinginfoId = ratinginfoId;
	}

	public BigDecimal getRegisteredownerId() {
		return registeredownerId;
	}

	public void setRegisteredownerId(BigDecimal registeredownerId) {
		this.registeredownerId = registeredownerId;
	}

	public BigDecimal getRiskitemId() {
		return riskitemId;
	}

	public void setRiskitemId(BigDecimal riskitemId) {
		this.riskitemId = riskitemId;
	}

	public BigDecimal getRiskmeterdetailsId() {
		return riskmeterdetailsId;
	}

	public void setRiskmeterdetailsId(BigDecimal riskmeterdetailsId) {
		this.riskmeterdetailsId = riskmeterdetailsId;
	}

	public BigDecimal getTermAmt() {
		return termAmt;
	}

	public void setTermAmt(BigDecimal termAmt) {
		this.termAmt = termAmt;
	}

	public BigDecimal getUmbrellawatercraftId() {
		return umbrellawatercraftId;
	}

	public void setUmbrellawatercraftId(BigDecimal umbrellawatercraftId) {
		this.umbrellawatercraftId = umbrellawatercraftId;
	}

	public BigDecimal getVehicleownershipId() {
		return vehicleownershipId;
	}

	public void setVehicleownershipId(BigDecimal vehicleownershipId) {
		this.vehicleownershipId = vehicleownershipId;
	}

	public BigDecimal getVehlength() {
		return vehlength;
	}

	public void setVehlength(BigDecimal vehlength) {
		this.vehlength = vehlength;
	}

	public BigDecimal getVehquestionnaireId() {
		return vehquestionnaireId;
	}

	public void setVehquestionnaireId(BigDecimal vehquestionnaireId) {
		this.vehquestionnaireId = vehquestionnaireId;
	}

	public BigDecimal getYear() {
		return year;
	}

	public void setYear(BigDecimal year) {
		this.year = year;
	}

}