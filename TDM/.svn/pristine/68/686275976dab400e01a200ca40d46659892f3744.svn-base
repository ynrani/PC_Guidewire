package com.tdm.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the PC_POLICYPERIOD database table.
 * 
 */
@Entity
@Table(name = "PC_POLICYPERIOD")
@NamedQuery(name = "PcPolicyperiodDO.findAll", query = "SELECT p FROM PcPolicyperiodDO p")
public class PcPolicyperiodDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal allocationofremainder;

	private BigDecimal allowgapsbefore;

	private String altbillingaccountnumber;

	private String archivedate;

	private BigDecimal archivefailuredetailsid;

	private BigDecimal archivefailureid;

	private BigDecimal archivepartition;

	private BigDecimal archiveschemainfo;

	private BigDecimal archivestate;

	private BigDecimal assignedrisk;

	private String basedondate;

	private BigDecimal basedonid;

	private BigDecimal basestate;

	private BigDecimal beanversion;

	private BigDecimal billimmediatelypercentage;

	@Column(name = "BILLINGADDRESSCITY_CGIC")
	private String billingaddresscityCgic;

	@Column(name = "BILLINGADDRESSLINE1_CGIC")
	private String billingaddressline1Cgic;

	@Column(name = "BILLINGADDRESSLINE2_CGIC")
	private String billingaddressline2Cgic;

	@Column(name = "BILLINGADDRESSPOSTALCODE_CGIC")
	private String billingaddresspostalcodeCgic;

	@Column(name = "BILLINGADDRESSSTATE_CGIC")
	private BigDecimal billingaddressstateCgic;

	private BigDecimal billingmethod;

	private String branchname;

	private BigDecimal branchnumber;

	private String cancellationdate;

	@Column(name = "CARDEXPIRATIONDATE_CGIC")
	private String cardexpirationdateCgic;

	@Column(name = "CARDHOLDERNAME_CGIC")
	private String cardholdernameCgic;

	@Column(name = "CARDNUMBER_CGIC")
	private String cardnumberCgic;

	private String createtime;

	private BigDecimal createuserid;

	@Column(name = "CVV_CGIC")
	private String cvvCgic;

	private BigDecimal depositamount;

	@Column(name = "DEPOSITAMOUNT_CUR")
	private BigDecimal depositamountCur;

	private BigDecimal depositcollected;

	@Column(name = "DEPOSITCOLLECTED_CUR")
	private BigDecimal depositcollectedCur;

	private BigDecimal depositoverridepct;

	private BigDecimal donotpurge;

	private String editeffectivedate;

	private BigDecimal editlocked;

	private BigDecimal excludedfromarchive;

	private String excludereason;

	private BigDecimal failedooseevaluation;

	private BigDecimal failedoosevalidation;

	private BigDecimal futureperiods;

	@Column(name = "INVOICENUMBER_CGIC")
	private String invoicenumberCgic;

	private String invoicestreamcode;

	private BigDecimal jobid;

	private BigDecimal locationautonumberseq;

	private BigDecimal locked;

	private BigDecimal lockingcolumn;

	private BigDecimal minimumpremium;

	private String modeldate;

	private BigDecimal modelnumber;

	private String modelnumberindex;

	private BigDecimal mostrecentmodel;

	private String mostrecentmodelindex;

	private BigDecimal overridebillingallocation;

	@Column(name = "PAYMENTAMOUNT_CGIC")
	private BigDecimal paymentamountCgic;

	@Column(name = "PAYMENTAMOUNT_CGIC_CUR")
	private BigDecimal paymentamountCgicCur;

	@Column(name = "PAYMENTAMOUNTCASH_CGIC")
	private BigDecimal paymentamountcashCgic;

	@Column(name = "PAYMENTAMOUNTCASH_CGIC_CUR")
	private BigDecimal paymentamountcashCgicCur;

	@Column(name = "PAYMENTAMOUNTCREDIT_CGIC")
	private BigDecimal paymentamountcreditCgic;

	@Column(name = "PAYMENTAMOUNTCREDIT_CGIC_CUR")
	private BigDecimal paymentamountcreditCgicCur;

	private String paymentplanid;

	private String paymentplanname;

	@Column(name = "PAYMENTPROCESSDATE_CGIC")
	private String paymentprocessdateCgic;

	private String periodend;

	private BigDecimal periodid;

	private String periodstart;

	private BigDecimal pnicontactdenorm;

	private BigDecimal policyid;

	private String policynumber;

	private BigDecimal policytermid;

	private BigDecimal preempted;

	private BigDecimal preferredcoveragecurrency;

	private BigDecimal preferredsettlementcurrency;

	private String primaryinsuredname;

	private String primaryinsurednamedenorm;

	private BigDecimal producercodeofrecordid;

	private String publicid;

	@Column(name = "PYMTINSTRUMENTTYPE_CGIC")
	private BigDecimal pymtinstrumenttypeCgic;

	private BigDecimal quotehidden;

	private String rateasofdate;

	private BigDecimal refundcalcmethod;

	private String reportingpatterncode;

	private BigDecimal retired;

	@Column(name = "\"SEGMENT\"")
	private BigDecimal segment;

	private String seriescheckingpatterncode;

	private String singlecheckingpatterncode;

	private BigDecimal status;

	private BigDecimal temporarybranch;

	private BigDecimal termnumber;

	private BigDecimal totalcostrpt;

	@Column(name = "TOTALCOSTRPT_CUR")
	private BigDecimal totalcostrptCur;

	private BigDecimal totalpremiumrpt;

	@Column(name = "TOTALPREMIUMRPT_CUR")
	private BigDecimal totalpremiumrptCur;

	private BigDecimal transactioncostrpt;

	@Column(name = "TRANSACTIONCOSTRPT_CUR")
	private BigDecimal transactioncostrptCur;

	private BigDecimal transactionpremiumrpt;

	@Column(name = "TRANSACTIONPREMIUMRPT_CUR")
	private BigDecimal transactionpremiumrptCur;

	private String updatetime;

	private BigDecimal updateuserid;

	private BigDecimal uwcompany;

	private BigDecimal validquote;

	private BigDecimal validreinsurance;

	private BigDecimal waivedepositchange;

	private String writtendate;

	@ManyToOne
	@JoinColumn(name = "ID", insertable = false, updatable = false)
	private PcPolicyDO pcPolicyDO;

	public PcPolicyperiodDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAllocationofremainder() {
		return this.allocationofremainder;
	}

	public void setAllocationofremainder(BigDecimal allocationofremainder) {
		this.allocationofremainder = allocationofremainder;
	}

	public BigDecimal getAllowgapsbefore() {
		return this.allowgapsbefore;
	}

	public void setAllowgapsbefore(BigDecimal allowgapsbefore) {
		this.allowgapsbefore = allowgapsbefore;
	}

	public String getAltbillingaccountnumber() {
		return this.altbillingaccountnumber;
	}

	public void setAltbillingaccountnumber(String altbillingaccountnumber) {
		this.altbillingaccountnumber = altbillingaccountnumber;
	}

	public String getArchivedate() {
		return this.archivedate;
	}

	public void setArchivedate(String archivedate) {
		this.archivedate = archivedate;
	}

	public BigDecimal getArchivefailuredetailsid() {
		return this.archivefailuredetailsid;
	}

	public void setArchivefailuredetailsid(BigDecimal archivefailuredetailsid) {
		this.archivefailuredetailsid = archivefailuredetailsid;
	}

	public BigDecimal getArchivefailureid() {
		return this.archivefailureid;
	}

	public void setArchivefailureid(BigDecimal archivefailureid) {
		this.archivefailureid = archivefailureid;
	}

	public BigDecimal getArchivepartition() {
		return this.archivepartition;
	}

	public void setArchivepartition(BigDecimal archivepartition) {
		this.archivepartition = archivepartition;
	}

	public BigDecimal getArchiveschemainfo() {
		return this.archiveschemainfo;
	}

	public void setArchiveschemainfo(BigDecimal archiveschemainfo) {
		this.archiveschemainfo = archiveschemainfo;
	}

	public BigDecimal getArchivestate() {
		return this.archivestate;
	}

	public void setArchivestate(BigDecimal archivestate) {
		this.archivestate = archivestate;
	}

	public BigDecimal getAssignedrisk() {
		return this.assignedrisk;
	}

	public void setAssignedrisk(BigDecimal assignedrisk) {
		this.assignedrisk = assignedrisk;
	}

	public String getBasedondate() {
		return this.basedondate;
	}

	public void setBasedondate(String basedondate) {
		this.basedondate = basedondate;
	}

	public BigDecimal getBasedonid() {
		return this.basedonid;
	}

	public void setBasedonid(BigDecimal basedonid) {
		this.basedonid = basedonid;
	}

	public BigDecimal getBasestate() {
		return this.basestate;
	}

	public void setBasestate(BigDecimal basestate) {
		this.basestate = basestate;
	}

	public BigDecimal getBeanversion() {
		return this.beanversion;
	}

	public void setBeanversion(BigDecimal beanversion) {
		this.beanversion = beanversion;
	}

	public BigDecimal getBillimmediatelypercentage() {
		return this.billimmediatelypercentage;
	}

	public void setBillimmediatelypercentage(BigDecimal billimmediatelypercentage) {
		this.billimmediatelypercentage = billimmediatelypercentage;
	}

	public String getBillingaddresscityCgic() {
		return this.billingaddresscityCgic;
	}

	public void setBillingaddresscityCgic(String billingaddresscityCgic) {
		this.billingaddresscityCgic = billingaddresscityCgic;
	}

	public String getBillingaddressline1Cgic() {
		return this.billingaddressline1Cgic;
	}

	public void setBillingaddressline1Cgic(String billingaddressline1Cgic) {
		this.billingaddressline1Cgic = billingaddressline1Cgic;
	}

	public String getBillingaddressline2Cgic() {
		return this.billingaddressline2Cgic;
	}

	public void setBillingaddressline2Cgic(String billingaddressline2Cgic) {
		this.billingaddressline2Cgic = billingaddressline2Cgic;
	}

	public String getBillingaddresspostalcodeCgic() {
		return this.billingaddresspostalcodeCgic;
	}

	public void setBillingaddresspostalcodeCgic(String billingaddresspostalcodeCgic) {
		this.billingaddresspostalcodeCgic = billingaddresspostalcodeCgic;
	}

	public BigDecimal getBillingaddressstateCgic() {
		return this.billingaddressstateCgic;
	}

	public void setBillingaddressstateCgic(BigDecimal billingaddressstateCgic) {
		this.billingaddressstateCgic = billingaddressstateCgic;
	}

	public BigDecimal getBillingmethod() {
		return this.billingmethod;
	}

	public void setBillingmethod(BigDecimal billingmethod) {
		this.billingmethod = billingmethod;
	}

	public String getBranchname() {
		return this.branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public BigDecimal getBranchnumber() {
		return this.branchnumber;
	}

	public void setBranchnumber(BigDecimal branchnumber) {
		this.branchnumber = branchnumber;
	}

	public String getCancellationdate() {
		return this.cancellationdate;
	}

	public void setCancellationdate(String cancellationdate) {
		this.cancellationdate = cancellationdate;
	}

	public String getCardexpirationdateCgic() {
		return this.cardexpirationdateCgic;
	}

	public void setCardexpirationdateCgic(String cardexpirationdateCgic) {
		this.cardexpirationdateCgic = cardexpirationdateCgic;
	}

	public String getCardholdernameCgic() {
		return this.cardholdernameCgic;
	}

	public void setCardholdernameCgic(String cardholdernameCgic) {
		this.cardholdernameCgic = cardholdernameCgic;
	}

	public String getCardnumberCgic() {
		return this.cardnumberCgic;
	}

	public void setCardnumberCgic(String cardnumberCgic) {
		this.cardnumberCgic = cardnumberCgic;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public BigDecimal getCreateuserid() {
		return this.createuserid;
	}

	public void setCreateuserid(BigDecimal createuserid) {
		this.createuserid = createuserid;
	}

	public String getCvvCgic() {
		return this.cvvCgic;
	}

	public void setCvvCgic(String cvvCgic) {
		this.cvvCgic = cvvCgic;
	}

	public BigDecimal getDepositamount() {
		return this.depositamount;
	}

	public void setDepositamount(BigDecimal depositamount) {
		this.depositamount = depositamount;
	}

	public BigDecimal getDepositamountCur() {
		return this.depositamountCur;
	}

	public void setDepositamountCur(BigDecimal depositamountCur) {
		this.depositamountCur = depositamountCur;
	}

	public BigDecimal getDepositcollected() {
		return this.depositcollected;
	}

	public void setDepositcollected(BigDecimal depositcollected) {
		this.depositcollected = depositcollected;
	}

	public BigDecimal getDepositcollectedCur() {
		return this.depositcollectedCur;
	}

	public void setDepositcollectedCur(BigDecimal depositcollectedCur) {
		this.depositcollectedCur = depositcollectedCur;
	}

	public BigDecimal getDepositoverridepct() {
		return this.depositoverridepct;
	}

	public void setDepositoverridepct(BigDecimal depositoverridepct) {
		this.depositoverridepct = depositoverridepct;
	}

	public BigDecimal getDonotpurge() {
		return this.donotpurge;
	}

	public void setDonotpurge(BigDecimal donotpurge) {
		this.donotpurge = donotpurge;
	}

	public String getEditeffectivedate() {
		return this.editeffectivedate;
	}

	public void setEditeffectivedate(String editeffectivedate) {
		this.editeffectivedate = editeffectivedate;
	}

	public BigDecimal getEditlocked() {
		return this.editlocked;
	}

	public void setEditlocked(BigDecimal editlocked) {
		this.editlocked = editlocked;
	}

	public BigDecimal getExcludedfromarchive() {
		return this.excludedfromarchive;
	}

	public void setExcludedfromarchive(BigDecimal excludedfromarchive) {
		this.excludedfromarchive = excludedfromarchive;
	}

	public String getExcludereason() {
		return this.excludereason;
	}

	public void setExcludereason(String excludereason) {
		this.excludereason = excludereason;
	}

	public BigDecimal getFailedooseevaluation() {
		return this.failedooseevaluation;
	}

	public void setFailedooseevaluation(BigDecimal failedooseevaluation) {
		this.failedooseevaluation = failedooseevaluation;
	}

	public BigDecimal getFailedoosevalidation() {
		return this.failedoosevalidation;
	}

	public void setFailedoosevalidation(BigDecimal failedoosevalidation) {
		this.failedoosevalidation = failedoosevalidation;
	}

	public BigDecimal getFutureperiods() {
		return this.futureperiods;
	}

	public void setFutureperiods(BigDecimal futureperiods) {
		this.futureperiods = futureperiods;
	}

	public String getInvoicenumberCgic() {
		return this.invoicenumberCgic;
	}

	public void setInvoicenumberCgic(String invoicenumberCgic) {
		this.invoicenumberCgic = invoicenumberCgic;
	}

	public String getInvoicestreamcode() {
		return this.invoicestreamcode;
	}

	public void setInvoicestreamcode(String invoicestreamcode) {
		this.invoicestreamcode = invoicestreamcode;
	}

	public BigDecimal getJobid() {
		return this.jobid;
	}

	public void setJobid(BigDecimal jobid) {
		this.jobid = jobid;
	}

	public BigDecimal getLocationautonumberseq() {
		return this.locationautonumberseq;
	}

	public void setLocationautonumberseq(BigDecimal locationautonumberseq) {
		this.locationautonumberseq = locationautonumberseq;
	}

	public BigDecimal getLocked() {
		return this.locked;
	}

	public void setLocked(BigDecimal locked) {
		this.locked = locked;
	}

	public BigDecimal getLockingcolumn() {
		return this.lockingcolumn;
	}

	public void setLockingcolumn(BigDecimal lockingcolumn) {
		this.lockingcolumn = lockingcolumn;
	}

	public BigDecimal getMinimumpremium() {
		return this.minimumpremium;
	}

	public void setMinimumpremium(BigDecimal minimumpremium) {
		this.minimumpremium = minimumpremium;
	}

	public String getModeldate() {
		return this.modeldate;
	}

	public void setModeldate(String modeldate) {
		this.modeldate = modeldate;
	}

	public BigDecimal getModelnumber() {
		return this.modelnumber;
	}

	public void setModelnumber(BigDecimal modelnumber) {
		this.modelnumber = modelnumber;
	}

	public String getModelnumberindex() {
		return this.modelnumberindex;
	}

	public void setModelnumberindex(String modelnumberindex) {
		this.modelnumberindex = modelnumberindex;
	}

	public BigDecimal getMostrecentmodel() {
		return this.mostrecentmodel;
	}

	public void setMostrecentmodel(BigDecimal mostrecentmodel) {
		this.mostrecentmodel = mostrecentmodel;
	}

	public String getMostrecentmodelindex() {
		return this.mostrecentmodelindex;
	}

	public void setMostrecentmodelindex(String mostrecentmodelindex) {
		this.mostrecentmodelindex = mostrecentmodelindex;
	}

	public BigDecimal getOverridebillingallocation() {
		return this.overridebillingallocation;
	}

	public void setOverridebillingallocation(BigDecimal overridebillingallocation) {
		this.overridebillingallocation = overridebillingallocation;
	}

	public BigDecimal getPaymentamountCgic() {
		return this.paymentamountCgic;
	}

	public void setPaymentamountCgic(BigDecimal paymentamountCgic) {
		this.paymentamountCgic = paymentamountCgic;
	}

	public BigDecimal getPaymentamountCgicCur() {
		return this.paymentamountCgicCur;
	}

	public void setPaymentamountCgicCur(BigDecimal paymentamountCgicCur) {
		this.paymentamountCgicCur = paymentamountCgicCur;
	}

	public BigDecimal getPaymentamountcashCgic() {
		return this.paymentamountcashCgic;
	}

	public void setPaymentamountcashCgic(BigDecimal paymentamountcashCgic) {
		this.paymentamountcashCgic = paymentamountcashCgic;
	}

	public BigDecimal getPaymentamountcashCgicCur() {
		return this.paymentamountcashCgicCur;
	}

	public void setPaymentamountcashCgicCur(BigDecimal paymentamountcashCgicCur) {
		this.paymentamountcashCgicCur = paymentamountcashCgicCur;
	}

	public BigDecimal getPaymentamountcreditCgic() {
		return this.paymentamountcreditCgic;
	}

	public void setPaymentamountcreditCgic(BigDecimal paymentamountcreditCgic) {
		this.paymentamountcreditCgic = paymentamountcreditCgic;
	}

	public BigDecimal getPaymentamountcreditCgicCur() {
		return this.paymentamountcreditCgicCur;
	}

	public void setPaymentamountcreditCgicCur(BigDecimal paymentamountcreditCgicCur) {
		this.paymentamountcreditCgicCur = paymentamountcreditCgicCur;
	}

	public String getPaymentplanid() {
		return this.paymentplanid;
	}

	public void setPaymentplanid(String paymentplanid) {
		this.paymentplanid = paymentplanid;
	}

	public String getPaymentplanname() {
		return this.paymentplanname;
	}

	public void setPaymentplanname(String paymentplanname) {
		this.paymentplanname = paymentplanname;
	}

	public String getPaymentprocessdateCgic() {
		return this.paymentprocessdateCgic;
	}

	public void setPaymentprocessdateCgic(String paymentprocessdateCgic) {
		this.paymentprocessdateCgic = paymentprocessdateCgic;
	}

	public String getPeriodend() {
		return this.periodend;
	}

	public void setPeriodend(String periodend) {
		this.periodend = periodend;
	}

	public BigDecimal getPeriodid() {
		return this.periodid;
	}

	public void setPeriodid(BigDecimal periodid) {
		this.periodid = periodid;
	}

	public String getPeriodstart() {
		return this.periodstart;
	}

	public void setPeriodstart(String periodstart) {
		this.periodstart = periodstart;
	}

	public BigDecimal getPnicontactdenorm() {
		return this.pnicontactdenorm;
	}

	public void setPnicontactdenorm(BigDecimal pnicontactdenorm) {
		this.pnicontactdenorm = pnicontactdenorm;
	}

	public BigDecimal getPolicyid() {
		return this.policyid;
	}

	public void setPolicyid(BigDecimal policyid) {
		this.policyid = policyid;
	}

	public String getPolicynumber() {
		return this.policynumber;
	}

	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}

	public BigDecimal getPolicytermid() {
		return this.policytermid;
	}

	public void setPolicytermid(BigDecimal policytermid) {
		this.policytermid = policytermid;
	}

	public BigDecimal getPreempted() {
		return this.preempted;
	}

	public void setPreempted(BigDecimal preempted) {
		this.preempted = preempted;
	}

	public BigDecimal getPreferredcoveragecurrency() {
		return this.preferredcoveragecurrency;
	}

	public void setPreferredcoveragecurrency(BigDecimal preferredcoveragecurrency) {
		this.preferredcoveragecurrency = preferredcoveragecurrency;
	}

	public BigDecimal getPreferredsettlementcurrency() {
		return this.preferredsettlementcurrency;
	}

	public void setPreferredsettlementcurrency(BigDecimal preferredsettlementcurrency) {
		this.preferredsettlementcurrency = preferredsettlementcurrency;
	}

	public String getPrimaryinsuredname() {
		return this.primaryinsuredname;
	}

	public void setPrimaryinsuredname(String primaryinsuredname) {
		this.primaryinsuredname = primaryinsuredname;
	}

	public String getPrimaryinsurednamedenorm() {
		return this.primaryinsurednamedenorm;
	}

	public void setPrimaryinsurednamedenorm(String primaryinsurednamedenorm) {
		this.primaryinsurednamedenorm = primaryinsurednamedenorm;
	}

	public BigDecimal getProducercodeofrecordid() {
		return this.producercodeofrecordid;
	}

	public void setProducercodeofrecordid(BigDecimal producercodeofrecordid) {
		this.producercodeofrecordid = producercodeofrecordid;
	}

	public String getPublicid() {
		return this.publicid;
	}

	public void setPublicid(String publicid) {
		this.publicid = publicid;
	}

	public BigDecimal getPymtinstrumenttypeCgic() {
		return this.pymtinstrumenttypeCgic;
	}

	public void setPymtinstrumenttypeCgic(BigDecimal pymtinstrumenttypeCgic) {
		this.pymtinstrumenttypeCgic = pymtinstrumenttypeCgic;
	}

	public BigDecimal getQuotehidden() {
		return this.quotehidden;
	}

	public void setQuotehidden(BigDecimal quotehidden) {
		this.quotehidden = quotehidden;
	}

	public String getRateasofdate() {
		return this.rateasofdate;
	}

	public void setRateasofdate(String rateasofdate) {
		this.rateasofdate = rateasofdate;
	}

	public BigDecimal getRefundcalcmethod() {
		return this.refundcalcmethod;
	}

	public void setRefundcalcmethod(BigDecimal refundcalcmethod) {
		this.refundcalcmethod = refundcalcmethod;
	}

	public String getReportingpatterncode() {
		return this.reportingpatterncode;
	}

	public void setReportingpatterncode(String reportingpatterncode) {
		this.reportingpatterncode = reportingpatterncode;
	}

	public BigDecimal getRetired() {
		return this.retired;
	}

	public void setRetired(BigDecimal retired) {
		this.retired = retired;
	}

	public BigDecimal getSegment() {
		return this.segment;
	}

	public void setSegment(BigDecimal segment) {
		this.segment = segment;
	}

	public String getSeriescheckingpatterncode() {
		return this.seriescheckingpatterncode;
	}

	public void setSeriescheckingpatterncode(String seriescheckingpatterncode) {
		this.seriescheckingpatterncode = seriescheckingpatterncode;
	}

	public String getSinglecheckingpatterncode() {
		return this.singlecheckingpatterncode;
	}

	public void setSinglecheckingpatterncode(String singlecheckingpatterncode) {
		this.singlecheckingpatterncode = singlecheckingpatterncode;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public BigDecimal getTemporarybranch() {
		return this.temporarybranch;
	}

	public void setTemporarybranch(BigDecimal temporarybranch) {
		this.temporarybranch = temporarybranch;
	}

	public BigDecimal getTermnumber() {
		return this.termnumber;
	}

	public void setTermnumber(BigDecimal termnumber) {
		this.termnumber = termnumber;
	}

	public BigDecimal getTotalcostrpt() {
		return this.totalcostrpt;
	}

	public void setTotalcostrpt(BigDecimal totalcostrpt) {
		this.totalcostrpt = totalcostrpt;
	}

	public BigDecimal getTotalcostrptCur() {
		return this.totalcostrptCur;
	}

	public void setTotalcostrptCur(BigDecimal totalcostrptCur) {
		this.totalcostrptCur = totalcostrptCur;
	}

	public BigDecimal getTotalpremiumrpt() {
		return this.totalpremiumrpt;
	}

	public void setTotalpremiumrpt(BigDecimal totalpremiumrpt) {
		this.totalpremiumrpt = totalpremiumrpt;
	}

	public BigDecimal getTotalpremiumrptCur() {
		return this.totalpremiumrptCur;
	}

	public void setTotalpremiumrptCur(BigDecimal totalpremiumrptCur) {
		this.totalpremiumrptCur = totalpremiumrptCur;
	}

	public BigDecimal getTransactioncostrpt() {
		return this.transactioncostrpt;
	}

	public void setTransactioncostrpt(BigDecimal transactioncostrpt) {
		this.transactioncostrpt = transactioncostrpt;
	}

	public BigDecimal getTransactioncostrptCur() {
		return this.transactioncostrptCur;
	}

	public void setTransactioncostrptCur(BigDecimal transactioncostrptCur) {
		this.transactioncostrptCur = transactioncostrptCur;
	}

	public BigDecimal getTransactionpremiumrpt() {
		return this.transactionpremiumrpt;
	}

	public void setTransactionpremiumrpt(BigDecimal transactionpremiumrpt) {
		this.transactionpremiumrpt = transactionpremiumrpt;
	}

	public BigDecimal getTransactionpremiumrptCur() {
		return this.transactionpremiumrptCur;
	}

	public void setTransactionpremiumrptCur(BigDecimal transactionpremiumrptCur) {
		this.transactionpremiumrptCur = transactionpremiumrptCur;
	}

	public String getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public BigDecimal getUpdateuserid() {
		return this.updateuserid;
	}

	public void setUpdateuserid(BigDecimal updateuserid) {
		this.updateuserid = updateuserid;
	}

	public BigDecimal getUwcompany() {
		return this.uwcompany;
	}

	public void setUwcompany(BigDecimal uwcompany) {
		this.uwcompany = uwcompany;
	}

	public BigDecimal getValidquote() {
		return this.validquote;
	}

	public void setValidquote(BigDecimal validquote) {
		this.validquote = validquote;
	}

	public BigDecimal getValidreinsurance() {
		return this.validreinsurance;
	}

	public void setValidreinsurance(BigDecimal validreinsurance) {
		this.validreinsurance = validreinsurance;
	}

	public BigDecimal getWaivedepositchange() {
		return this.waivedepositchange;
	}

	public void setWaivedepositchange(BigDecimal waivedepositchange) {
		this.waivedepositchange = waivedepositchange;
	}

	public String getWrittendate() {
		return this.writtendate;
	}

	public void setWrittendate(String writtendate) {
		this.writtendate = writtendate;
	}

	public PcPolicyDO getPcPolicyDO() {
		return pcPolicyDO;
	}

	public void setPcPolicyDO(PcPolicyDO pcPolicyDO) {
		this.pcPolicyDO = pcPolicyDO;
	}

}