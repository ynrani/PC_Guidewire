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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the COVERAGE database table.
 * 
 */
@Entity
@Table(name = "COVERAGE")
@NamedQuery(name = "CoverageDO.findAll", query = "SELECT c FROM CoverageDO c")
public class CoverageDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// private double actualpremiumamount;

	private BigDecimal additionallimitamount;

	private String additionallimitdesc;

	private BigDecimal adjustedrate;

	private BigDecimal amount;

	private BigDecimal citytaxrate;

	private String combinedlimitamount;

	// private double commissionamount;

	@Column(name = "COMMISSIONOVERRIDE_ID")
	private BigDecimal commissionoverrideId;

	private String componentinstancename;

	private String connectedtoinstancename;

	private BigDecimal countytaxrate;

	private String coveragecd;

	private String coverlevelcd;

	private String currencycd;

	private BigDecimal deductibleamount;

	private String deductibleappliestocd;

	private String deductibleoptioncd;

	private BigDecimal deductiblepct;

	private String deductibletypecd;

	private BigDecimal deltapremiumamt;

	private String deltapremiumcur;

	private BigDecimal displayscheduledproperty;

	private String driveroid;

	private String dtype;

	private Timestamp effectivedt;

	private BigDecimal entitystatus;

	private String equipmentcd;

	private Timestamp expirationdt;

	private BigDecimal fees;

	@Column(name = "FORM_ID")
	private BigDecimal formId;

	private String fullglassoptioncd;

	private String instancename;

	private BigDecimal itemlimitamt;

	private BigDecimal lastcomponentinfoseqno;

	private BigDecimal limitamount;

	private String limitamountdisplay;

	private String limitappliestocd;

	private BigDecimal limitincludedind;

	private String limitvaluationcd;

	private BigDecimal maxdeductibleamount;

	private BigDecimal mindeductibleamount;

	private BigDecimal minimumpremiumamt;

	private String minimumpremiumcur;

	private BigDecimal numberhouseholdemployees;

	private String oid;

	private BigDecimal percentageamt;

	@Column(name = "POLICYDETAIL_ID")
	private BigDecimal policydetailId;

	// private double premiumchangeamount;

	@Column(name = "PREMIUMRATEINFO_ID")
	private BigDecimal premiumrateinfoId;

	private String producercomponentname;

	// private double producercomponentversion;

	private BigDecimal rate;

	private BigDecimal ratedpremiumamt;

	private String ratedpremiumcur;

	private Timestamp rateeffectivedate;

	private BigDecimal rateeffectivedateoverriddenind;

	private Timestamp raterequestdate;

	private BigDecimal raterequestdateoverriddenind;

	private String reasoncd;

	private String reasonothertext;

	private BigDecimal seqidx;

	private BigDecimal seqno;

	private String subcoveragecd;

	private BigDecimal targetpremiumamt;

	private String targetpremiumcur;

	private BigDecimal taxes;

	private BigDecimal underlyinglimitamount;

	private BigDecimal workerscompensationcoverageind;

	// bi-directional many-to-one association to RiskitemDO
	@ManyToOne(fetch = FetchType.LAZY)
	private RiskitemDO riskitem;

	// bi-directional many-to-one association to PremiumentryDO
	@OneToMany(mappedBy = "coverage", fetch = FetchType.LAZY)
	private List<PremiumentryDO> premiumentries;

	public CoverageDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAdditionallimitamount() {
		return this.additionallimitamount;
	}

	public void setAdditionallimitamount(BigDecimal additionallimitamount) {
		this.additionallimitamount = additionallimitamount;
	}

	public String getAdditionallimitdesc() {
		return this.additionallimitdesc;
	}

	public void setAdditionallimitdesc(String additionallimitdesc) {
		this.additionallimitdesc = additionallimitdesc;
	}

	public BigDecimal getAdjustedrate() {
		return this.adjustedrate;
	}

	public void setAdjustedrate(BigDecimal adjustedrate) {
		this.adjustedrate = adjustedrate;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getCitytaxrate() {
		return this.citytaxrate;
	}

	public void setCitytaxrate(BigDecimal citytaxrate) {
		this.citytaxrate = citytaxrate;
	}

	public String getCombinedlimitamount() {
		return this.combinedlimitamount;
	}

	public void setCombinedlimitamount(String combinedlimitamount) {
		this.combinedlimitamount = combinedlimitamount;
	}

	// public double getCommissionamount() {
	// return this.commissionamount;
	// }
	//
	// public void setCommissionamount(double commissionamount) {
	// this.commissionamount = commissionamount;
	// }

	public BigDecimal getCommissionoverrideId() {
		return this.commissionoverrideId;
	}

	public void setCommissionoverrideId(BigDecimal commissionoverrideId) {
		this.commissionoverrideId = commissionoverrideId;
	}

	public String getComponentinstancename() {
		return this.componentinstancename;
	}

	public void setComponentinstancename(String componentinstancename) {
		this.componentinstancename = componentinstancename;
	}

	public String getConnectedtoinstancename() {
		return this.connectedtoinstancename;
	}

	public void setConnectedtoinstancename(String connectedtoinstancename) {
		this.connectedtoinstancename = connectedtoinstancename;
	}

	public BigDecimal getCountytaxrate() {
		return this.countytaxrate;
	}

	public void setCountytaxrate(BigDecimal countytaxrate) {
		this.countytaxrate = countytaxrate;
	}

	public String getCoveragecd() {
		return this.coveragecd;
	}

	public void setCoveragecd(String coveragecd) {
		this.coveragecd = coveragecd;
	}

	public String getCoverlevelcd() {
		return this.coverlevelcd;
	}

	public void setCoverlevelcd(String coverlevelcd) {
		this.coverlevelcd = coverlevelcd;
	}

	public String getCurrencycd() {
		return this.currencycd;
	}

	public void setCurrencycd(String currencycd) {
		this.currencycd = currencycd;
	}

	public BigDecimal getDeductibleamount() {
		return this.deductibleamount;
	}

	public void setDeductibleamount(BigDecimal deductibleamount) {
		this.deductibleamount = deductibleamount;
	}

	public String getDeductibleappliestocd() {
		return this.deductibleappliestocd;
	}

	public void setDeductibleappliestocd(String deductibleappliestocd) {
		this.deductibleappliestocd = deductibleappliestocd;
	}

	public String getDeductibleoptioncd() {
		return this.deductibleoptioncd;
	}

	public void setDeductibleoptioncd(String deductibleoptioncd) {
		this.deductibleoptioncd = deductibleoptioncd;
	}

	public BigDecimal getDeductiblepct() {
		return this.deductiblepct;
	}

	public void setDeductiblepct(BigDecimal deductiblepct) {
		this.deductiblepct = deductiblepct;
	}

	public String getDeductibletypecd() {
		return this.deductibletypecd;
	}

	public void setDeductibletypecd(String deductibletypecd) {
		this.deductibletypecd = deductibletypecd;
	}

	public BigDecimal getDeltapremiumamt() {
		return this.deltapremiumamt;
	}

	public void setDeltapremiumamt(BigDecimal deltapremiumamt) {
		this.deltapremiumamt = deltapremiumamt;
	}

	public String getDeltapremiumcur() {
		return this.deltapremiumcur;
	}

	public void setDeltapremiumcur(String deltapremiumcur) {
		this.deltapremiumcur = deltapremiumcur;
	}

	public BigDecimal getDisplayscheduledproperty() {
		return this.displayscheduledproperty;
	}

	public void setDisplayscheduledproperty(BigDecimal displayscheduledproperty) {
		this.displayscheduledproperty = displayscheduledproperty;
	}

	public String getDriveroid() {
		return this.driveroid;
	}

	public void setDriveroid(String driveroid) {
		this.driveroid = driveroid;
	}

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public Timestamp getEffectivedt() {
		return this.effectivedt;
	}

	public void setEffectivedt(Timestamp effectivedt) {
		this.effectivedt = effectivedt;
	}

	public BigDecimal getEntitystatus() {
		return this.entitystatus;
	}

	public void setEntitystatus(BigDecimal entitystatus) {
		this.entitystatus = entitystatus;
	}

	public String getEquipmentcd() {
		return this.equipmentcd;
	}

	public void setEquipmentcd(String equipmentcd) {
		this.equipmentcd = equipmentcd;
	}

	public Timestamp getExpirationdt() {
		return this.expirationdt;
	}

	public void setExpirationdt(Timestamp expirationdt) {
		this.expirationdt = expirationdt;
	}

	public BigDecimal getFees() {
		return this.fees;
	}

	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}

	public BigDecimal getFormId() {
		return this.formId;
	}

	public void setFormId(BigDecimal formId) {
		this.formId = formId;
	}

	public String getFullglassoptioncd() {
		return this.fullglassoptioncd;
	}

	public void setFullglassoptioncd(String fullglassoptioncd) {
		this.fullglassoptioncd = fullglassoptioncd;
	}

	public String getInstancename() {
		return this.instancename;
	}

	public void setInstancename(String instancename) {
		this.instancename = instancename;
	}

	public BigDecimal getItemlimitamt() {
		return this.itemlimitamt;
	}

	public void setItemlimitamt(BigDecimal itemlimitamt) {
		this.itemlimitamt = itemlimitamt;
	}

	public BigDecimal getLastcomponentinfoseqno() {
		return this.lastcomponentinfoseqno;
	}

	public void setLastcomponentinfoseqno(BigDecimal lastcomponentinfoseqno) {
		this.lastcomponentinfoseqno = lastcomponentinfoseqno;
	}

	public BigDecimal getLimitamount() {
		return this.limitamount;
	}

	public void setLimitamount(BigDecimal limitamount) {
		this.limitamount = limitamount;
	}

	public String getLimitamountdisplay() {
		return this.limitamountdisplay;
	}

	public void setLimitamountdisplay(String limitamountdisplay) {
		this.limitamountdisplay = limitamountdisplay;
	}

	public String getLimitappliestocd() {
		return this.limitappliestocd;
	}

	public void setLimitappliestocd(String limitappliestocd) {
		this.limitappliestocd = limitappliestocd;
	}

	public BigDecimal getLimitincludedind() {
		return this.limitincludedind;
	}

	public void setLimitincludedind(BigDecimal limitincludedind) {
		this.limitincludedind = limitincludedind;
	}

	public String getLimitvaluationcd() {
		return this.limitvaluationcd;
	}

	public void setLimitvaluationcd(String limitvaluationcd) {
		this.limitvaluationcd = limitvaluationcd;
	}

	public BigDecimal getMaxdeductibleamount() {
		return this.maxdeductibleamount;
	}

	public void setMaxdeductibleamount(BigDecimal maxdeductibleamount) {
		this.maxdeductibleamount = maxdeductibleamount;
	}

	public BigDecimal getMindeductibleamount() {
		return this.mindeductibleamount;
	}

	public void setMindeductibleamount(BigDecimal mindeductibleamount) {
		this.mindeductibleamount = mindeductibleamount;
	}

	public BigDecimal getMinimumpremiumamt() {
		return this.minimumpremiumamt;
	}

	public void setMinimumpremiumamt(BigDecimal minimumpremiumamt) {
		this.minimumpremiumamt = minimumpremiumamt;
	}

	public String getMinimumpremiumcur() {
		return this.minimumpremiumcur;
	}

	public void setMinimumpremiumcur(String minimumpremiumcur) {
		this.minimumpremiumcur = minimumpremiumcur;
	}

	public BigDecimal getNumberhouseholdemployees() {
		return this.numberhouseholdemployees;
	}

	public void setNumberhouseholdemployees(BigDecimal numberhouseholdemployees) {
		this.numberhouseholdemployees = numberhouseholdemployees;
	}

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public BigDecimal getPercentageamt() {
		return this.percentageamt;
	}

	public void setPercentageamt(BigDecimal percentageamt) {
		this.percentageamt = percentageamt;
	}

	public BigDecimal getPolicydetailId() {
		return this.policydetailId;
	}

	public void setPolicydetailId(BigDecimal policydetailId) {
		this.policydetailId = policydetailId;
	}

	//
	// public double getPremiumchangeamount() {
	// return this.premiumchangeamount;
	// }
	//
	// public void setPremiumchangeamount(double premiumchangeamount) {
	// this.premiumchangeamount = premiumchangeamount;
	// }

	public BigDecimal getPremiumrateinfoId() {
		return this.premiumrateinfoId;
	}

	public void setPremiumrateinfoId(BigDecimal premiumrateinfoId) {
		this.premiumrateinfoId = premiumrateinfoId;
	}

	public String getProducercomponentname() {
		return this.producercomponentname;
	}

	public void setProducercomponentname(String producercomponentname) {
		this.producercomponentname = producercomponentname;
	}

	// public double getProducercomponentversion() {
	// return this.producercomponentversion;
	// }
	//
	// public void setProducercomponentversion(double producercomponentversion) {
	// this.producercomponentversion = producercomponentversion;
	// }

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getRatedpremiumamt() {
		return this.ratedpremiumamt;
	}

	public void setRatedpremiumamt(BigDecimal ratedpremiumamt) {
		this.ratedpremiumamt = ratedpremiumamt;
	}

	public String getRatedpremiumcur() {
		return this.ratedpremiumcur;
	}

	public void setRatedpremiumcur(String ratedpremiumcur) {
		this.ratedpremiumcur = ratedpremiumcur;
	}

	public Timestamp getRateeffectivedate() {
		return this.rateeffectivedate;
	}

	public void setRateeffectivedate(Timestamp rateeffectivedate) {
		this.rateeffectivedate = rateeffectivedate;
	}

	public BigDecimal getRateeffectivedateoverriddenind() {
		return this.rateeffectivedateoverriddenind;
	}

	public void setRateeffectivedateoverriddenind(BigDecimal rateeffectivedateoverriddenind) {
		this.rateeffectivedateoverriddenind = rateeffectivedateoverriddenind;
	}

	public Timestamp getRaterequestdate() {
		return this.raterequestdate;
	}

	public void setRaterequestdate(Timestamp raterequestdate) {
		this.raterequestdate = raterequestdate;
	}

	public BigDecimal getRaterequestdateoverriddenind() {
		return this.raterequestdateoverriddenind;
	}

	public void setRaterequestdateoverriddenind(BigDecimal raterequestdateoverriddenind) {
		this.raterequestdateoverriddenind = raterequestdateoverriddenind;
	}

	public String getReasoncd() {
		return this.reasoncd;
	}

	public void setReasoncd(String reasoncd) {
		this.reasoncd = reasoncd;
	}

	public String getReasonothertext() {
		return this.reasonothertext;
	}

	public void setReasonothertext(String reasonothertext) {
		this.reasonothertext = reasonothertext;
	}

	public BigDecimal getSeqidx() {
		return this.seqidx;
	}

	public void setSeqidx(BigDecimal seqidx) {
		this.seqidx = seqidx;
	}

	public BigDecimal getSeqno() {
		return this.seqno;
	}

	public void setSeqno(BigDecimal seqno) {
		this.seqno = seqno;
	}

	public String getSubcoveragecd() {
		return this.subcoveragecd;
	}

	public void setSubcoveragecd(String subcoveragecd) {
		this.subcoveragecd = subcoveragecd;
	}

	public BigDecimal getTargetpremiumamt() {
		return this.targetpremiumamt;
	}

	public void setTargetpremiumamt(BigDecimal targetpremiumamt) {
		this.targetpremiumamt = targetpremiumamt;
	}

	public String getTargetpremiumcur() {
		return this.targetpremiumcur;
	}

	public void setTargetpremiumcur(String targetpremiumcur) {
		this.targetpremiumcur = targetpremiumcur;
	}

	public BigDecimal getTaxes() {
		return this.taxes;
	}

	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}

	// public double getTermpremiumamount() {
	// return this.termpremiumamount;
	// }
	//
	// public void setTermpremiumamount(double termpremiumamount) {
	// this.termpremiumamount = termpremiumamount;
	// }

	public BigDecimal getUnderlyinglimitamount() {
		return this.underlyinglimitamount;
	}

	public void setUnderlyinglimitamount(BigDecimal underlyinglimitamount) {
		this.underlyinglimitamount = underlyinglimitamount;
	}

	// public double getVoluntarydeductamt() {
	// return this.voluntarydeductamt;
	// }
	//
	// public void setVoluntarydeductamt(double voluntarydeductamt) {
	// this.voluntarydeductamt = voluntarydeductamt;
	// }
	//
	// public double getWindscreendeductamt() {
	// return this.windscreendeductamt;
	// }

	// public void setWindscreendeductamt(double windscreendeductamt) {
	// this.windscreendeductamt = windscreendeductamt;
	// }

	public BigDecimal getWorkerscompensationcoverageind() {
		return this.workerscompensationcoverageind;
	}

	public void setWorkerscompensationcoverageind(BigDecimal workerscompensationcoverageind) {
		this.workerscompensationcoverageind = workerscompensationcoverageind;
	}

	public RiskitemDO getRiskitem() {
		return this.riskitem;
	}

	public void setRiskitem(RiskitemDO riskitem) {
		this.riskitem = riskitem;
	}

	public List<PremiumentryDO> getPremiumentries() {
		return this.premiumentries;
	}

	public void setPremiumentries(List<PremiumentryDO> premiumentries) {
		this.premiumentries = premiumentries;
	}

	public PremiumentryDO addPremiumentry(PremiumentryDO premiumentry) {
		getPremiumentries().add(premiumentry);
		premiumentry.setCoverage(this);

		return premiumentry;
	}

	public PremiumentryDO removePremiumentry(PremiumentryDO premiumentry) {
		getPremiumentries().remove(premiumentry);
		premiumentry.setCoverage(null);

		return premiumentry;
	}

}