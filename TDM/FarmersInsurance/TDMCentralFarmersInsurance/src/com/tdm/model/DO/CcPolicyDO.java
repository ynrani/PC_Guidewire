package com.tdm.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the CC_POLICY database table.
 * 
 */
@Entity
@Table(name = "CC_POLICY")
@NamedQuery(name = "CcPolicyDO.findAll", query = "SELECT c FROM CcPolicyDO c")
public class CcPolicyDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String accountnumber;

	private BigDecimal archivepartition;

	private BigDecimal assignedrisk;

	private BigDecimal beanversion;

	private String cancellationdate;

	private BigDecimal coverageform;

	private String createtime;

	private BigDecimal createuserid;

	private BigDecimal currency;

	private BigDecimal customerservicetier;

	private String effectivedate;

	private String expirationdate;

	private String financialinterests;

	private BigDecimal foreigncoverage;

	private String insuredsiccode;

	@Column(name = "INSUREDVALIDIND_CGIC")
	private BigDecimal insuredvalidindCgic;

	@Column(name = "INSURERTAXID_CGIC")
	private String insurertaxidCgic;

	private BigDecimal loadcommandid;

	@Column(name = "MOSTRECENTLAPSEDDATE_CGIC")
	private String mostrecentlapseddateCgic;

	@Column(name = "NOLOSSPERIOD_CGIC")
	private BigDecimal nolossperiodCgic;

	@Column(name = "NONOWNERPOLICY_CGIC")
	private BigDecimal nonownerpolicyCgic;

	private String notes;

	private String origeffectivedate;

	private String otherinsinfo;

	private BigDecimal otherinsurance;

	private BigDecimal participation;

	private String policynumber;

	private BigDecimal policyratingplan;

	private BigDecimal policysource;

	@Column(name = "POLICYSTATE_CGIC")
	private BigDecimal policystateCgic;

	private String policysuffix;

	private BigDecimal policysystemperiodid;

	private BigDecimal policytype;

	@Column(name = "PREMIUMSTATUS_CGIC")
	private BigDecimal premiumstatusCgic;

	private String producercode;

	private String publicid;

	@Column(name = "REINSTATEMENTDATE_CGIC")
	private String reinstatementdateCgic;

	private String reportingdate;

	@Column(name = "REPORTINGDESC_CGIC")
	private String reportingdescCgic;

	private BigDecimal retired;

	private String retroactivedate;

	private BigDecimal returntoworkprgm;

	@Column(name = "SITEID_CGIC")
	private String siteidCgic;

	private BigDecimal status;

	private BigDecimal totalproperties;

	private BigDecimal totalvehicles;

	private BigDecimal underwritingco;

	private BigDecimal underwritinggroup;

	private String updatetime;

	private BigDecimal updateuserid;

	private BigDecimal validationlevel;

	private BigDecimal verified;

	private String wcotherstates;

	private String wcstates;

	// bi-directional many-to-one association to CcClaimDO
	@OneToMany(mappedBy = "ccPolicy", fetch = FetchType.LAZY)
	private List<CcClaimDO> ccClaims;

	public CcPolicyDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountnumber() {
		return this.accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public BigDecimal getArchivepartition() {
		return this.archivepartition;
	}

	public void setArchivepartition(BigDecimal archivepartition) {
		this.archivepartition = archivepartition;
	}

	public BigDecimal getAssignedrisk() {
		return this.assignedrisk;
	}

	public void setAssignedrisk(BigDecimal assignedrisk) {
		this.assignedrisk = assignedrisk;
	}

	public BigDecimal getBeanversion() {
		return this.beanversion;
	}

	public void setBeanversion(BigDecimal beanversion) {
		this.beanversion = beanversion;
	}

	public String getCancellationdate() {
		return this.cancellationdate;
	}

	public void setCancellationdate(String cancellationdate) {
		this.cancellationdate = cancellationdate;
	}

	public BigDecimal getCoverageform() {
		return this.coverageform;
	}

	public void setCoverageform(BigDecimal coverageform) {
		this.coverageform = coverageform;
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

	public BigDecimal getCustomerservicetier() {
		return this.customerservicetier;
	}

	public void setCustomerservicetier(BigDecimal customerservicetier) {
		this.customerservicetier = customerservicetier;
	}

	public String getEffectivedate() {
		return this.effectivedate;
	}

	public void setEffectivedate(String effectivedate) {
		this.effectivedate = effectivedate;
	}

	public String getExpirationdate() {
		return this.expirationdate;
	}

	public void setExpirationdate(String expirationdate) {
		this.expirationdate = expirationdate;
	}

	public String getFinancialinterests() {
		return this.financialinterests;
	}

	public void setFinancialinterests(String financialinterests) {
		this.financialinterests = financialinterests;
	}

	public BigDecimal getForeigncoverage() {
		return this.foreigncoverage;
	}

	public void setForeigncoverage(BigDecimal foreigncoverage) {
		this.foreigncoverage = foreigncoverage;
	}

	public String getInsuredsiccode() {
		return this.insuredsiccode;
	}

	public void setInsuredsiccode(String insuredsiccode) {
		this.insuredsiccode = insuredsiccode;
	}

	public BigDecimal getInsuredvalidindCgic() {
		return this.insuredvalidindCgic;
	}

	public void setInsuredvalidindCgic(BigDecimal insuredvalidindCgic) {
		this.insuredvalidindCgic = insuredvalidindCgic;
	}

	public String getInsurertaxidCgic() {
		return this.insurertaxidCgic;
	}

	public void setInsurertaxidCgic(String insurertaxidCgic) {
		this.insurertaxidCgic = insurertaxidCgic;
	}

	public BigDecimal getLoadcommandid() {
		return this.loadcommandid;
	}

	public void setLoadcommandid(BigDecimal loadcommandid) {
		this.loadcommandid = loadcommandid;
	}

	public String getMostrecentlapseddateCgic() {
		return this.mostrecentlapseddateCgic;
	}

	public void setMostrecentlapseddateCgic(String mostrecentlapseddateCgic) {
		this.mostrecentlapseddateCgic = mostrecentlapseddateCgic;
	}

	public BigDecimal getNolossperiodCgic() {
		return this.nolossperiodCgic;
	}

	public void setNolossperiodCgic(BigDecimal nolossperiodCgic) {
		this.nolossperiodCgic = nolossperiodCgic;
	}

	public BigDecimal getNonownerpolicyCgic() {
		return this.nonownerpolicyCgic;
	}

	public void setNonownerpolicyCgic(BigDecimal nonownerpolicyCgic) {
		this.nonownerpolicyCgic = nonownerpolicyCgic;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOrigeffectivedate() {
		return this.origeffectivedate;
	}

	public void setOrigeffectivedate(String origeffectivedate) {
		this.origeffectivedate = origeffectivedate;
	}

	public String getOtherinsinfo() {
		return this.otherinsinfo;
	}

	public void setOtherinsinfo(String otherinsinfo) {
		this.otherinsinfo = otherinsinfo;
	}

	public BigDecimal getOtherinsurance() {
		return this.otherinsurance;
	}

	public void setOtherinsurance(BigDecimal otherinsurance) {
		this.otherinsurance = otherinsurance;
	}

	public BigDecimal getParticipation() {
		return this.participation;
	}

	public void setParticipation(BigDecimal participation) {
		this.participation = participation;
	}

	public String getPolicynumber() {
		return this.policynumber;
	}

	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}

	public BigDecimal getPolicyratingplan() {
		return this.policyratingplan;
	}

	public void setPolicyratingplan(BigDecimal policyratingplan) {
		this.policyratingplan = policyratingplan;
	}

	public BigDecimal getPolicysource() {
		return this.policysource;
	}

	public void setPolicysource(BigDecimal policysource) {
		this.policysource = policysource;
	}

	public BigDecimal getPolicystateCgic() {
		return this.policystateCgic;
	}

	public void setPolicystateCgic(BigDecimal policystateCgic) {
		this.policystateCgic = policystateCgic;
	}

	public String getPolicysuffix() {
		return this.policysuffix;
	}

	public void setPolicysuffix(String policysuffix) {
		this.policysuffix = policysuffix;
	}

	public BigDecimal getPolicysystemperiodid() {
		return this.policysystemperiodid;
	}

	public void setPolicysystemperiodid(BigDecimal policysystemperiodid) {
		this.policysystemperiodid = policysystemperiodid;
	}

	public BigDecimal getPolicytype() {
		return this.policytype;
	}

	public void setPolicytype(BigDecimal policytype) {
		this.policytype = policytype;
	}

	public BigDecimal getPremiumstatusCgic() {
		return this.premiumstatusCgic;
	}

	public void setPremiumstatusCgic(BigDecimal premiumstatusCgic) {
		this.premiumstatusCgic = premiumstatusCgic;
	}

	public String getProducercode() {
		return this.producercode;
	}

	public void setProducercode(String producercode) {
		this.producercode = producercode;
	}

	public String getPublicid() {
		return this.publicid;
	}

	public void setPublicid(String publicid) {
		this.publicid = publicid;
	}

	public String getReinstatementdateCgic() {
		return this.reinstatementdateCgic;
	}

	public void setReinstatementdateCgic(String reinstatementdateCgic) {
		this.reinstatementdateCgic = reinstatementdateCgic;
	}

	public String getReportingdate() {
		return this.reportingdate;
	}

	public void setReportingdate(String reportingdate) {
		this.reportingdate = reportingdate;
	}

	public String getReportingdescCgic() {
		return this.reportingdescCgic;
	}

	public void setReportingdescCgic(String reportingdescCgic) {
		this.reportingdescCgic = reportingdescCgic;
	}

	public BigDecimal getRetired() {
		return this.retired;
	}

	public void setRetired(BigDecimal retired) {
		this.retired = retired;
	}

	public String getRetroactivedate() {
		return this.retroactivedate;
	}

	public void setRetroactivedate(String retroactivedate) {
		this.retroactivedate = retroactivedate;
	}

	public BigDecimal getReturntoworkprgm() {
		return this.returntoworkprgm;
	}

	public void setReturntoworkprgm(BigDecimal returntoworkprgm) {
		this.returntoworkprgm = returntoworkprgm;
	}

	public String getSiteidCgic() {
		return this.siteidCgic;
	}

	public void setSiteidCgic(String siteidCgic) {
		this.siteidCgic = siteidCgic;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public BigDecimal getTotalproperties() {
		return this.totalproperties;
	}

	public void setTotalproperties(BigDecimal totalproperties) {
		this.totalproperties = totalproperties;
	}

	public BigDecimal getTotalvehicles() {
		return this.totalvehicles;
	}

	public void setTotalvehicles(BigDecimal totalvehicles) {
		this.totalvehicles = totalvehicles;
	}

	public BigDecimal getUnderwritingco() {
		return this.underwritingco;
	}

	public void setUnderwritingco(BigDecimal underwritingco) {
		this.underwritingco = underwritingco;
	}

	public BigDecimal getUnderwritinggroup() {
		return this.underwritinggroup;
	}

	public void setUnderwritinggroup(BigDecimal underwritinggroup) {
		this.underwritinggroup = underwritinggroup;
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

	public BigDecimal getVerified() {
		return this.verified;
	}

	public void setVerified(BigDecimal verified) {
		this.verified = verified;
	}

	public String getWcotherstates() {
		return this.wcotherstates;
	}

	public void setWcotherstates(String wcotherstates) {
		this.wcotherstates = wcotherstates;
	}

	public String getWcstates() {
		return this.wcstates;
	}

	public void setWcstates(String wcstates) {
		this.wcstates = wcstates;
	}

	public List<CcClaimDO> getCcClaims() {
		return this.ccClaims;
	}

	public void setCcClaims(List<CcClaimDO> ccClaims) {
		this.ccClaims = ccClaims;
	}

	public CcClaimDO addCcClaim(CcClaimDO ccClaim) {
		getCcClaims().add(ccClaim);
		ccClaim.setCcPolicy(this);

		return ccClaim;
	}

	public CcClaimDO removeCcClaim(CcClaimDO ccClaim) {
		getCcClaims().remove(ccClaim);
		ccClaim.setCcPolicy(null);

		return ccClaim;
	}

}