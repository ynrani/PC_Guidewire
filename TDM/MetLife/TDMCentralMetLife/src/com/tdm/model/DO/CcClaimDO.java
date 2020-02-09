package com.tdm.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the CC_CLAIM database table.
 * 
 */
@Entity
@Table(name = "CC_CLAIM")
@NamedQuery(name = "CcClaimDO.findAll", query = "SELECT c FROM CcClaimDO c")
public class CcClaimDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal accidenttype;

	private String agencyid;

	private BigDecimal archivepartition;

	private BigDecimal assignedbyuserid;

	private BigDecimal assignedgroupid;

	private BigDecimal assignedqueueid;

	private BigDecimal assigneduserid;

	private String assignmentdate;

	private BigDecimal assignmentstatus;

	private BigDecimal beanversion;

	private BigDecimal benefitsstatusdcsn;

	private BigDecimal catastropheid;

	private BigDecimal claimantdenormid;

	private String claimantrprtddate;

	private String claimnumber;

	private BigDecimal claimsource;

	private BigDecimal claimtier;

	private BigDecimal claimworkcompid;

	private String closedate;

	private BigDecimal closedoutcome;

	private BigDecimal computersecurity;

	private BigDecimal concurrentemp;

	private BigDecimal coverageinquestion;

	private String createtime;

	private BigDecimal createuserid;

	private BigDecimal currency;

	private BigDecimal currentconditions;

	private String datecompdcsndue;

	private String datecompdcsnmade;

	private String dateeligibleforarchive;

	private String dateformgiventoemp;

	private String dateformretbyemp;

	private String daterptdtoagent;

	private String daterptdtoemployer;

	private String daterptdtoinsured;

	private String deathdate;

	@Lob
	private String description;

	private BigDecimal diagnosticcnsistnt;

	private BigDecimal drugsinvolved;

	private String employervalidityreason;

	private BigDecimal employmentdataid;

	private BigDecimal employmentinjury;

	private BigDecimal empqusvalidity;

	private String empsentmpnnotice;

	private String examinationdate;

	private String exposurebegan;

	private String exposureended;

	private BigDecimal fault;

	private BigDecimal faultrating;

	private String firedeptinfo;

	private BigDecimal firstnoticesuit;

	private BigDecimal flagged;

	private String flaggeddate;

	@Lob
	private String flaggedreason;

	private BigDecimal furthertreatment;

	private BigDecimal hazardouswaste;

	private String hospitaldate;

	private BigDecimal hospitaldays;

	private BigDecimal howreported;

	private BigDecimal incidentreport;

	private BigDecimal injuredonpremises;

	private BigDecimal injuredregularjob;

	private String injwkrinmpn;

	private BigDecimal insureddenormid;

	private BigDecimal insuredpremises;

	private String insurersentmpnnotice;

	private BigDecimal integerext;

	private BigDecimal isoenabled;

	private BigDecimal isoknown;

	private String isoreceivedate;

	private String isosenddate;

	private BigDecimal isostatus;

	private BigDecimal jurisdictionstate;

	private BigDecimal largelossnotificationstatus;

	private BigDecimal litigationstatus;

	private BigDecimal loadcommandid;

	private BigDecimal lobcode;

	private BigDecimal locationcodeid;

	private BigDecimal locationoftheft;

	private BigDecimal lockingcolumn;

	private BigDecimal losscause;

	private String lossdate;

	private String losslocationcode;

	private BigDecimal losslocationid;

	private BigDecimal losstype;

	private BigDecimal maincontacttype;

	private String manifestationdate;

	@Column(name = "MEDICALACKCODE_CGIC")
	private BigDecimal medicalackcodeCgic;

	private String mmidate;

	private BigDecimal modifieddutyavail;

	private BigDecimal mold;

	private BigDecimal otherrecovstatus;

	private BigDecimal permissionrequired;

	private String policedeptinfo;

	private BigDecimal preexdisblty;

	private BigDecimal previousgroupid;

	private BigDecimal previousqueueid;

	private BigDecimal previoususerid;

	private BigDecimal progress;

	private BigDecimal ptpinmpn;

	private String publicid;

	private String purgedate;

	private BigDecimal reinsuranceflaggedstatus;

	private BigDecimal reinsurancereportable;

	private String reopendate;

	private BigDecimal reopenedreason;

	private BigDecimal reportedbytype;

	private String reporteddate;

	private BigDecimal retired;

	private BigDecimal safetyequipprov;

	private BigDecimal safetyequipused;

	private BigDecimal salvagestatus;

	@Column(name = "\"SEGMENT\"")
	private BigDecimal segment;

	private BigDecimal showmedicalfirstinfo;

	private BigDecimal siescalatesiu;

	private String siescalatesiudate;

	private BigDecimal siscore;

	private BigDecimal siulifecyclestate;

	private BigDecimal siustatus;

	@Column(name = "\"STATE\"")
	private BigDecimal state;

	private String stateacknumber;

	private String statefilenumber;

	private String statutedate;

	private String storagebarcodenum;

	private String storageboxnum;

	private BigDecimal storagecategory;

	private String storagedate;

	private BigDecimal storagelocationstate;

	private BigDecimal storagetype;

	private String storagevolumes;

	private BigDecimal strategy;

	private BigDecimal subrogationstatus;

	private BigDecimal supplementalworkloadweight;

	private BigDecimal treatedpatientbfr;

	private BigDecimal typekeyext;

	private String updatetime;

	private BigDecimal updateuserid;

	private BigDecimal validationlevel;

	private String varcharext;

	private BigDecimal weather;

	private BigDecimal weatherrelated;

	private String workloadupdated;

	private BigDecimal workloadweight;

	// bi-directional many-to-one association to CcPolicyDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLICYID", insertable = false, updatable = false)
	private CcPolicyDO ccPolicy;

	public CcClaimDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAccidenttype() {
		return this.accidenttype;
	}

	public void setAccidenttype(BigDecimal accidenttype) {
		this.accidenttype = accidenttype;
	}

	public String getAgencyid() {
		return this.agencyid;
	}

	public void setAgencyid(String agencyid) {
		this.agencyid = agencyid;
	}

	public BigDecimal getArchivepartition() {
		return this.archivepartition;
	}

	public void setArchivepartition(BigDecimal archivepartition) {
		this.archivepartition = archivepartition;
	}

	public BigDecimal getAssignedbyuserid() {
		return this.assignedbyuserid;
	}

	public void setAssignedbyuserid(BigDecimal assignedbyuserid) {
		this.assignedbyuserid = assignedbyuserid;
	}

	public BigDecimal getAssignedgroupid() {
		return this.assignedgroupid;
	}

	public void setAssignedgroupid(BigDecimal assignedgroupid) {
		this.assignedgroupid = assignedgroupid;
	}

	public BigDecimal getAssignedqueueid() {
		return this.assignedqueueid;
	}

	public void setAssignedqueueid(BigDecimal assignedqueueid) {
		this.assignedqueueid = assignedqueueid;
	}

	public BigDecimal getAssigneduserid() {
		return this.assigneduserid;
	}

	public void setAssigneduserid(BigDecimal assigneduserid) {
		this.assigneduserid = assigneduserid;
	}

	public String getAssignmentdate() {
		return this.assignmentdate;
	}

	public void setAssignmentdate(String assignmentdate) {
		this.assignmentdate = assignmentdate;
	}

	public BigDecimal getAssignmentstatus() {
		return this.assignmentstatus;
	}

	public void setAssignmentstatus(BigDecimal assignmentstatus) {
		this.assignmentstatus = assignmentstatus;
	}

	public BigDecimal getBeanversion() {
		return this.beanversion;
	}

	public void setBeanversion(BigDecimal beanversion) {
		this.beanversion = beanversion;
	}

	public BigDecimal getBenefitsstatusdcsn() {
		return this.benefitsstatusdcsn;
	}

	public void setBenefitsstatusdcsn(BigDecimal benefitsstatusdcsn) {
		this.benefitsstatusdcsn = benefitsstatusdcsn;
	}

	public BigDecimal getCatastropheid() {
		return this.catastropheid;
	}

	public void setCatastropheid(BigDecimal catastropheid) {
		this.catastropheid = catastropheid;
	}

	public BigDecimal getClaimantdenormid() {
		return this.claimantdenormid;
	}

	public void setClaimantdenormid(BigDecimal claimantdenormid) {
		this.claimantdenormid = claimantdenormid;
	}

	public String getClaimantrprtddate() {
		return this.claimantrprtddate;
	}

	public void setClaimantrprtddate(String claimantrprtddate) {
		this.claimantrprtddate = claimantrprtddate;
	}

	public String getClaimnumber() {
		return this.claimnumber;
	}

	public void setClaimnumber(String claimnumber) {
		this.claimnumber = claimnumber;
	}

	public BigDecimal getClaimsource() {
		return this.claimsource;
	}

	public void setClaimsource(BigDecimal claimsource) {
		this.claimsource = claimsource;
	}

	public BigDecimal getClaimtier() {
		return this.claimtier;
	}

	public void setClaimtier(BigDecimal claimtier) {
		this.claimtier = claimtier;
	}

	public BigDecimal getClaimworkcompid() {
		return this.claimworkcompid;
	}

	public void setClaimworkcompid(BigDecimal claimworkcompid) {
		this.claimworkcompid = claimworkcompid;
	}

	public String getClosedate() {
		return this.closedate;
	}

	public void setClosedate(String closedate) {
		this.closedate = closedate;
	}

	public BigDecimal getClosedoutcome() {
		return this.closedoutcome;
	}

	public void setClosedoutcome(BigDecimal closedoutcome) {
		this.closedoutcome = closedoutcome;
	}

	public BigDecimal getComputersecurity() {
		return this.computersecurity;
	}

	public void setComputersecurity(BigDecimal computersecurity) {
		this.computersecurity = computersecurity;
	}

	public BigDecimal getConcurrentemp() {
		return this.concurrentemp;
	}

	public void setConcurrentemp(BigDecimal concurrentemp) {
		this.concurrentemp = concurrentemp;
	}

	public BigDecimal getCoverageinquestion() {
		return this.coverageinquestion;
	}

	public void setCoverageinquestion(BigDecimal coverageinquestion) {
		this.coverageinquestion = coverageinquestion;
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

	public BigDecimal getCurrency() {
		return this.currency;
	}

	public void setCurrency(BigDecimal currency) {
		this.currency = currency;
	}

	public BigDecimal getCurrentconditions() {
		return this.currentconditions;
	}

	public void setCurrentconditions(BigDecimal currentconditions) {
		this.currentconditions = currentconditions;
	}

	public String getDatecompdcsndue() {
		return this.datecompdcsndue;
	}

	public void setDatecompdcsndue(String datecompdcsndue) {
		this.datecompdcsndue = datecompdcsndue;
	}

	public String getDatecompdcsnmade() {
		return this.datecompdcsnmade;
	}

	public void setDatecompdcsnmade(String datecompdcsnmade) {
		this.datecompdcsnmade = datecompdcsnmade;
	}

	public String getDateeligibleforarchive() {
		return this.dateeligibleforarchive;
	}

	public void setDateeligibleforarchive(String dateeligibleforarchive) {
		this.dateeligibleforarchive = dateeligibleforarchive;
	}

	public String getDateformgiventoemp() {
		return this.dateformgiventoemp;
	}

	public void setDateformgiventoemp(String dateformgiventoemp) {
		this.dateformgiventoemp = dateformgiventoemp;
	}

	public String getDateformretbyemp() {
		return this.dateformretbyemp;
	}

	public void setDateformretbyemp(String dateformretbyemp) {
		this.dateformretbyemp = dateformretbyemp;
	}

	public String getDaterptdtoagent() {
		return this.daterptdtoagent;
	}

	public void setDaterptdtoagent(String daterptdtoagent) {
		this.daterptdtoagent = daterptdtoagent;
	}

	public String getDaterptdtoemployer() {
		return this.daterptdtoemployer;
	}

	public void setDaterptdtoemployer(String daterptdtoemployer) {
		this.daterptdtoemployer = daterptdtoemployer;
	}

	public String getDaterptdtoinsured() {
		return this.daterptdtoinsured;
	}

	public void setDaterptdtoinsured(String daterptdtoinsured) {
		this.daterptdtoinsured = daterptdtoinsured;
	}

	public String getDeathdate() {
		return this.deathdate;
	}

	public void setDeathdate(String deathdate) {
		this.deathdate = deathdate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDiagnosticcnsistnt() {
		return this.diagnosticcnsistnt;
	}

	public void setDiagnosticcnsistnt(BigDecimal diagnosticcnsistnt) {
		this.diagnosticcnsistnt = diagnosticcnsistnt;
	}

	public BigDecimal getDrugsinvolved() {
		return this.drugsinvolved;
	}

	public void setDrugsinvolved(BigDecimal drugsinvolved) {
		this.drugsinvolved = drugsinvolved;
	}

	public String getEmployervalidityreason() {
		return this.employervalidityreason;
	}

	public void setEmployervalidityreason(String employervalidityreason) {
		this.employervalidityreason = employervalidityreason;
	}

	public BigDecimal getEmploymentdataid() {
		return this.employmentdataid;
	}

	public void setEmploymentdataid(BigDecimal employmentdataid) {
		this.employmentdataid = employmentdataid;
	}

	public BigDecimal getEmploymentinjury() {
		return this.employmentinjury;
	}

	public void setEmploymentinjury(BigDecimal employmentinjury) {
		this.employmentinjury = employmentinjury;
	}

	public BigDecimal getEmpqusvalidity() {
		return this.empqusvalidity;
	}

	public void setEmpqusvalidity(BigDecimal empqusvalidity) {
		this.empqusvalidity = empqusvalidity;
	}

	public String getEmpsentmpnnotice() {
		return this.empsentmpnnotice;
	}

	public void setEmpsentmpnnotice(String empsentmpnnotice) {
		this.empsentmpnnotice = empsentmpnnotice;
	}

	public String getExaminationdate() {
		return this.examinationdate;
	}

	public void setExaminationdate(String examinationdate) {
		this.examinationdate = examinationdate;
	}

	public String getExposurebegan() {
		return this.exposurebegan;
	}

	public void setExposurebegan(String exposurebegan) {
		this.exposurebegan = exposurebegan;
	}

	public String getExposureended() {
		return this.exposureended;
	}

	public void setExposureended(String exposureended) {
		this.exposureended = exposureended;
	}

	public BigDecimal getFault() {
		return this.fault;
	}

	public void setFault(BigDecimal fault) {
		this.fault = fault;
	}

	public BigDecimal getFaultrating() {
		return this.faultrating;
	}

	public void setFaultrating(BigDecimal faultrating) {
		this.faultrating = faultrating;
	}

	public String getFiredeptinfo() {
		return this.firedeptinfo;
	}

	public void setFiredeptinfo(String firedeptinfo) {
		this.firedeptinfo = firedeptinfo;
	}

	public BigDecimal getFirstnoticesuit() {
		return this.firstnoticesuit;
	}

	public void setFirstnoticesuit(BigDecimal firstnoticesuit) {
		this.firstnoticesuit = firstnoticesuit;
	}

	public BigDecimal getFlagged() {
		return this.flagged;
	}

	public void setFlagged(BigDecimal flagged) {
		this.flagged = flagged;
	}

	public String getFlaggeddate() {
		return this.flaggeddate;
	}

	public void setFlaggeddate(String flaggeddate) {
		this.flaggeddate = flaggeddate;
	}

	public String getFlaggedreason() {
		return this.flaggedreason;
	}

	public void setFlaggedreason(String flaggedreason) {
		this.flaggedreason = flaggedreason;
	}

	public BigDecimal getFurthertreatment() {
		return this.furthertreatment;
	}

	public void setFurthertreatment(BigDecimal furthertreatment) {
		this.furthertreatment = furthertreatment;
	}

	public BigDecimal getHazardouswaste() {
		return this.hazardouswaste;
	}

	public void setHazardouswaste(BigDecimal hazardouswaste) {
		this.hazardouswaste = hazardouswaste;
	}

	public String getHospitaldate() {
		return this.hospitaldate;
	}

	public void setHospitaldate(String hospitaldate) {
		this.hospitaldate = hospitaldate;
	}

	public BigDecimal getHospitaldays() {
		return this.hospitaldays;
	}

	public void setHospitaldays(BigDecimal hospitaldays) {
		this.hospitaldays = hospitaldays;
	}

	public BigDecimal getHowreported() {
		return this.howreported;
	}

	public void setHowreported(BigDecimal howreported) {
		this.howreported = howreported;
	}

	public BigDecimal getIncidentreport() {
		return this.incidentreport;
	}

	public void setIncidentreport(BigDecimal incidentreport) {
		this.incidentreport = incidentreport;
	}

	public BigDecimal getInjuredonpremises() {
		return this.injuredonpremises;
	}

	public void setInjuredonpremises(BigDecimal injuredonpremises) {
		this.injuredonpremises = injuredonpremises;
	}

	public BigDecimal getInjuredregularjob() {
		return this.injuredregularjob;
	}

	public void setInjuredregularjob(BigDecimal injuredregularjob) {
		this.injuredregularjob = injuredregularjob;
	}

	public String getInjwkrinmpn() {
		return this.injwkrinmpn;
	}

	public void setInjwkrinmpn(String injwkrinmpn) {
		this.injwkrinmpn = injwkrinmpn;
	}

	public BigDecimal getInsureddenormid() {
		return this.insureddenormid;
	}

	public void setInsureddenormid(BigDecimal insureddenormid) {
		this.insureddenormid = insureddenormid;
	}

	public BigDecimal getInsuredpremises() {
		return this.insuredpremises;
	}

	public void setInsuredpremises(BigDecimal insuredpremises) {
		this.insuredpremises = insuredpremises;
	}

	public String getInsurersentmpnnotice() {
		return this.insurersentmpnnotice;
	}

	public void setInsurersentmpnnotice(String insurersentmpnnotice) {
		this.insurersentmpnnotice = insurersentmpnnotice;
	}

	public BigDecimal getIntegerext() {
		return this.integerext;
	}

	public void setIntegerext(BigDecimal integerext) {
		this.integerext = integerext;
	}

	public BigDecimal getIsoenabled() {
		return this.isoenabled;
	}

	public void setIsoenabled(BigDecimal isoenabled) {
		this.isoenabled = isoenabled;
	}

	public BigDecimal getIsoknown() {
		return this.isoknown;
	}

	public void setIsoknown(BigDecimal isoknown) {
		this.isoknown = isoknown;
	}

	public String getIsoreceivedate() {
		return this.isoreceivedate;
	}

	public void setIsoreceivedate(String isoreceivedate) {
		this.isoreceivedate = isoreceivedate;
	}

	public String getIsosenddate() {
		return this.isosenddate;
	}

	public void setIsosenddate(String isosenddate) {
		this.isosenddate = isosenddate;
	}

	public BigDecimal getIsostatus() {
		return this.isostatus;
	}

	public void setIsostatus(BigDecimal isostatus) {
		this.isostatus = isostatus;
	}

	public BigDecimal getJurisdictionstate() {
		return this.jurisdictionstate;
	}

	public void setJurisdictionstate(BigDecimal jurisdictionstate) {
		this.jurisdictionstate = jurisdictionstate;
	}

	public BigDecimal getLargelossnotificationstatus() {
		return this.largelossnotificationstatus;
	}

	public void setLargelossnotificationstatus(BigDecimal largelossnotificationstatus) {
		this.largelossnotificationstatus = largelossnotificationstatus;
	}

	public BigDecimal getLitigationstatus() {
		return this.litigationstatus;
	}

	public void setLitigationstatus(BigDecimal litigationstatus) {
		this.litigationstatus = litigationstatus;
	}

	public BigDecimal getLoadcommandid() {
		return this.loadcommandid;
	}

	public void setLoadcommandid(BigDecimal loadcommandid) {
		this.loadcommandid = loadcommandid;
	}

	public BigDecimal getLobcode() {
		return this.lobcode;
	}

	public void setLobcode(BigDecimal lobcode) {
		this.lobcode = lobcode;
	}

	public BigDecimal getLocationcodeid() {
		return this.locationcodeid;
	}

	public void setLocationcodeid(BigDecimal locationcodeid) {
		this.locationcodeid = locationcodeid;
	}

	public BigDecimal getLocationoftheft() {
		return this.locationoftheft;
	}

	public void setLocationoftheft(BigDecimal locationoftheft) {
		this.locationoftheft = locationoftheft;
	}

	public BigDecimal getLockingcolumn() {
		return this.lockingcolumn;
	}

	public void setLockingcolumn(BigDecimal lockingcolumn) {
		this.lockingcolumn = lockingcolumn;
	}

	public BigDecimal getLosscause() {
		return this.losscause;
	}

	public void setLosscause(BigDecimal losscause) {
		this.losscause = losscause;
	}

	public String getLossdate() {
		return this.lossdate;
	}

	public void setLossdate(String lossdate) {
		this.lossdate = lossdate;
	}

	public String getLosslocationcode() {
		return this.losslocationcode;
	}

	public void setLosslocationcode(String losslocationcode) {
		this.losslocationcode = losslocationcode;
	}

	public BigDecimal getLosslocationid() {
		return this.losslocationid;
	}

	public void setLosslocationid(BigDecimal losslocationid) {
		this.losslocationid = losslocationid;
	}

	public BigDecimal getLosstype() {
		return this.losstype;
	}

	public void setLosstype(BigDecimal losstype) {
		this.losstype = losstype;
	}

	public BigDecimal getMaincontacttype() {
		return this.maincontacttype;
	}

	public void setMaincontacttype(BigDecimal maincontacttype) {
		this.maincontacttype = maincontacttype;
	}

	public String getManifestationdate() {
		return this.manifestationdate;
	}

	public void setManifestationdate(String manifestationdate) {
		this.manifestationdate = manifestationdate;
	}

	public BigDecimal getMedicalackcodeCgic() {
		return this.medicalackcodeCgic;
	}

	public void setMedicalackcodeCgic(BigDecimal medicalackcodeCgic) {
		this.medicalackcodeCgic = medicalackcodeCgic;
	}

	public String getMmidate() {
		return this.mmidate;
	}

	public void setMmidate(String mmidate) {
		this.mmidate = mmidate;
	}

	public BigDecimal getModifieddutyavail() {
		return this.modifieddutyavail;
	}

	public void setModifieddutyavail(BigDecimal modifieddutyavail) {
		this.modifieddutyavail = modifieddutyavail;
	}

	public BigDecimal getMold() {
		return this.mold;
	}

	public void setMold(BigDecimal mold) {
		this.mold = mold;
	}

	public BigDecimal getOtherrecovstatus() {
		return this.otherrecovstatus;
	}

	public void setOtherrecovstatus(BigDecimal otherrecovstatus) {
		this.otherrecovstatus = otherrecovstatus;
	}

	public BigDecimal getPermissionrequired() {
		return this.permissionrequired;
	}

	public void setPermissionrequired(BigDecimal permissionrequired) {
		this.permissionrequired = permissionrequired;
	}

	public String getPolicedeptinfo() {
		return this.policedeptinfo;
	}

	public void setPolicedeptinfo(String policedeptinfo) {
		this.policedeptinfo = policedeptinfo;
	}

	public BigDecimal getPreexdisblty() {
		return this.preexdisblty;
	}

	public void setPreexdisblty(BigDecimal preexdisblty) {
		this.preexdisblty = preexdisblty;
	}

	public BigDecimal getPreviousgroupid() {
		return this.previousgroupid;
	}

	public void setPreviousgroupid(BigDecimal previousgroupid) {
		this.previousgroupid = previousgroupid;
	}

	public BigDecimal getPreviousqueueid() {
		return this.previousqueueid;
	}

	public void setPreviousqueueid(BigDecimal previousqueueid) {
		this.previousqueueid = previousqueueid;
	}

	public BigDecimal getPrevioususerid() {
		return this.previoususerid;
	}

	public void setPrevioususerid(BigDecimal previoususerid) {
		this.previoususerid = previoususerid;
	}

	public BigDecimal getProgress() {
		return this.progress;
	}

	public void setProgress(BigDecimal progress) {
		this.progress = progress;
	}

	public BigDecimal getPtpinmpn() {
		return this.ptpinmpn;
	}

	public void setPtpinmpn(BigDecimal ptpinmpn) {
		this.ptpinmpn = ptpinmpn;
	}

	public String getPublicid() {
		return this.publicid;
	}

	public void setPublicid(String publicid) {
		this.publicid = publicid;
	}

	public String getPurgedate() {
		return this.purgedate;
	}

	public void setPurgedate(String purgedate) {
		this.purgedate = purgedate;
	}

	public BigDecimal getReinsuranceflaggedstatus() {
		return this.reinsuranceflaggedstatus;
	}

	public void setReinsuranceflaggedstatus(BigDecimal reinsuranceflaggedstatus) {
		this.reinsuranceflaggedstatus = reinsuranceflaggedstatus;
	}

	public BigDecimal getReinsurancereportable() {
		return this.reinsurancereportable;
	}

	public void setReinsurancereportable(BigDecimal reinsurancereportable) {
		this.reinsurancereportable = reinsurancereportable;
	}

	public String getReopendate() {
		return this.reopendate;
	}

	public void setReopendate(String reopendate) {
		this.reopendate = reopendate;
	}

	public BigDecimal getReopenedreason() {
		return this.reopenedreason;
	}

	public void setReopenedreason(BigDecimal reopenedreason) {
		this.reopenedreason = reopenedreason;
	}

	public BigDecimal getReportedbytype() {
		return this.reportedbytype;
	}

	public void setReportedbytype(BigDecimal reportedbytype) {
		this.reportedbytype = reportedbytype;
	}

	public String getReporteddate() {
		return this.reporteddate;
	}

	public void setReporteddate(String reporteddate) {
		this.reporteddate = reporteddate;
	}

	public BigDecimal getRetired() {
		return this.retired;
	}

	public void setRetired(BigDecimal retired) {
		this.retired = retired;
	}

	public BigDecimal getSafetyequipprov() {
		return this.safetyequipprov;
	}

	public void setSafetyequipprov(BigDecimal safetyequipprov) {
		this.safetyequipprov = safetyequipprov;
	}

	public BigDecimal getSafetyequipused() {
		return this.safetyequipused;
	}

	public void setSafetyequipused(BigDecimal safetyequipused) {
		this.safetyequipused = safetyequipused;
	}

	public BigDecimal getSalvagestatus() {
		return this.salvagestatus;
	}

	public void setSalvagestatus(BigDecimal salvagestatus) {
		this.salvagestatus = salvagestatus;
	}

	public BigDecimal getSegment() {
		return this.segment;
	}

	public void setSegment(BigDecimal segment) {
		this.segment = segment;
	}

	public BigDecimal getShowmedicalfirstinfo() {
		return this.showmedicalfirstinfo;
	}

	public void setShowmedicalfirstinfo(BigDecimal showmedicalfirstinfo) {
		this.showmedicalfirstinfo = showmedicalfirstinfo;
	}

	public BigDecimal getSiescalatesiu() {
		return this.siescalatesiu;
	}

	public void setSiescalatesiu(BigDecimal siescalatesiu) {
		this.siescalatesiu = siescalatesiu;
	}

	public String getSiescalatesiudate() {
		return this.siescalatesiudate;
	}

	public void setSiescalatesiudate(String siescalatesiudate) {
		this.siescalatesiudate = siescalatesiudate;
	}

	public BigDecimal getSiscore() {
		return this.siscore;
	}

	public void setSiscore(BigDecimal siscore) {
		this.siscore = siscore;
	}

	public BigDecimal getSiulifecyclestate() {
		return this.siulifecyclestate;
	}

	public void setSiulifecyclestate(BigDecimal siulifecyclestate) {
		this.siulifecyclestate = siulifecyclestate;
	}

	public BigDecimal getSiustatus() {
		return this.siustatus;
	}

	public void setSiustatus(BigDecimal siustatus) {
		this.siustatus = siustatus;
	}

	public BigDecimal getState() {
		return this.state;
	}

	public void setState(BigDecimal state) {
		this.state = state;
	}

	public String getStateacknumber() {
		return this.stateacknumber;
	}

	public void setStateacknumber(String stateacknumber) {
		this.stateacknumber = stateacknumber;
	}

	public String getStatefilenumber() {
		return this.statefilenumber;
	}

	public void setStatefilenumber(String statefilenumber) {
		this.statefilenumber = statefilenumber;
	}

	public String getStatutedate() {
		return this.statutedate;
	}

	public void setStatutedate(String statutedate) {
		this.statutedate = statutedate;
	}

	public String getStoragebarcodenum() {
		return this.storagebarcodenum;
	}

	public void setStoragebarcodenum(String storagebarcodenum) {
		this.storagebarcodenum = storagebarcodenum;
	}

	public String getStorageboxnum() {
		return this.storageboxnum;
	}

	public void setStorageboxnum(String storageboxnum) {
		this.storageboxnum = storageboxnum;
	}

	public BigDecimal getStoragecategory() {
		return this.storagecategory;
	}

	public void setStoragecategory(BigDecimal storagecategory) {
		this.storagecategory = storagecategory;
	}

	public String getStoragedate() {
		return this.storagedate;
	}

	public void setStoragedate(String storagedate) {
		this.storagedate = storagedate;
	}

	public BigDecimal getStoragelocationstate() {
		return this.storagelocationstate;
	}

	public void setStoragelocationstate(BigDecimal storagelocationstate) {
		this.storagelocationstate = storagelocationstate;
	}

	public BigDecimal getStoragetype() {
		return this.storagetype;
	}

	public void setStoragetype(BigDecimal storagetype) {
		this.storagetype = storagetype;
	}

	public String getStoragevolumes() {
		return this.storagevolumes;
	}

	public void setStoragevolumes(String storagevolumes) {
		this.storagevolumes = storagevolumes;
	}

	public BigDecimal getStrategy() {
		return this.strategy;
	}

	public void setStrategy(BigDecimal strategy) {
		this.strategy = strategy;
	}

	public BigDecimal getSubrogationstatus() {
		return this.subrogationstatus;
	}

	public void setSubrogationstatus(BigDecimal subrogationstatus) {
		this.subrogationstatus = subrogationstatus;
	}

	public BigDecimal getSupplementalworkloadweight() {
		return this.supplementalworkloadweight;
	}

	public void setSupplementalworkloadweight(BigDecimal supplementalworkloadweight) {
		this.supplementalworkloadweight = supplementalworkloadweight;
	}

	public BigDecimal getTreatedpatientbfr() {
		return this.treatedpatientbfr;
	}

	public void setTreatedpatientbfr(BigDecimal treatedpatientbfr) {
		this.treatedpatientbfr = treatedpatientbfr;
	}

	public BigDecimal getTypekeyext() {
		return this.typekeyext;
	}

	public void setTypekeyext(BigDecimal typekeyext) {
		this.typekeyext = typekeyext;
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

	public BigDecimal getValidationlevel() {
		return this.validationlevel;
	}

	public void setValidationlevel(BigDecimal validationlevel) {
		this.validationlevel = validationlevel;
	}

	public String getVarcharext() {
		return this.varcharext;
	}

	public void setVarcharext(String varcharext) {
		this.varcharext = varcharext;
	}

	public BigDecimal getWeather() {
		return this.weather;
	}

	public void setWeather(BigDecimal weather) {
		this.weather = weather;
	}

	public BigDecimal getWeatherrelated() {
		return this.weatherrelated;
	}

	public void setWeatherrelated(BigDecimal weatherrelated) {
		this.weatherrelated = weatherrelated;
	}

	public String getWorkloadupdated() {
		return this.workloadupdated;
	}

	public void setWorkloadupdated(String workloadupdated) {
		this.workloadupdated = workloadupdated;
	}

	public BigDecimal getWorkloadweight() {
		return this.workloadweight;
	}

	public void setWorkloadweight(BigDecimal workloadweight) {
		this.workloadweight = workloadweight;
	}

	public CcPolicyDO getCcPolicy() {
		return this.ccPolicy;
	}

	public void setCcPolicy(CcPolicyDO ccPolicy) {
		this.ccPolicy = ccPolicy;
	}

}