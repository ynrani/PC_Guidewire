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
 * The persistent class for the PC_POLICY database table.
 * 
 */
@Entity
@Table(name = "PC_POLICY")
@NamedQuery(name = "PcPolicyDO.findAll", query = "SELECT p FROM PcPolicyDO p")
public class PcPolicyDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal accountid;

	private String archivedate;

	private BigDecimal archivefailuredetailsid;

	private BigDecimal archivefailureid;

	private BigDecimal archivepartition;

	private BigDecimal archiveschemainfo;

	private BigDecimal archivestate;

	private BigDecimal beanversion;

	private String createtime;

	private BigDecimal createuserid;

	private BigDecimal donotarchive;

	private BigDecimal donotpurge;

	private BigDecimal excludedfromarchive;

	private String excludereason;

	private String issuedate;

	private BigDecimal losshistorytype;

	private BigDecimal movedpolicysourceaccountid;

	@Column(name = "NONOWNER_CGIC")
	private BigDecimal nonownerCgic;

	private BigDecimal numpriorlosses;

	private String originaleffectivedate;

	private BigDecimal packagerisk;

	@Column(name = "POLICYSTATE_CGIC")
	private BigDecimal policystateCgic;

	@Column(name = "PREMIUMSTATUS_CGIC")
	private BigDecimal premiumstatusCgic;

	private BigDecimal primarylanguage;

	private BigDecimal primarylocale;

	private BigDecimal priorpremiums;

	@Column(name = "PRIORPREMIUMS_CUR")
	private BigDecimal priorpremiumsCur;

	private BigDecimal priortotalincurred;

	@Column(name = "PRIORTOTALINCURRED_CUR")
	private BigDecimal priortotalincurredCur;

	private BigDecimal producercodeofserviceid;

	private String productcode;

	private String publicid;

	private BigDecimal retired;

	@Column(name = "RRE_CGIC")
	private String rreCgic;

	@Column(name = "SITEID_CGIC")
	private String siteidCgic;

	@Column(name = "SR22_CGIC")
	private BigDecimal sr22Cgic;

	private String updatetime;

	private BigDecimal updateuserid;

	// bi-directional one-to-one association to TdmProviderCategoryDO
	@OneToMany(mappedBy = "pcPolicyDO", fetch = FetchType.LAZY)
	private List<PcPolicyperiodDO> pcPolicyperiodDOs;

	public PcPolicyDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAccountid() {
		return this.accountid;
	}

	public void setAccountid(BigDecimal accountid) {
		this.accountid = accountid;
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

	public BigDecimal getBeanversion() {
		return this.beanversion;
	}

	public void setBeanversion(BigDecimal beanversion) {
		this.beanversion = beanversion;
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

	public BigDecimal getDonotarchive() {
		return this.donotarchive;
	}

	public void setDonotarchive(BigDecimal donotarchive) {
		this.donotarchive = donotarchive;
	}

	public BigDecimal getDonotpurge() {
		return this.donotpurge;
	}

	public void setDonotpurge(BigDecimal donotpurge) {
		this.donotpurge = donotpurge;
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

	public String getIssuedate() {
		return this.issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public BigDecimal getLosshistorytype() {
		return this.losshistorytype;
	}

	public void setLosshistorytype(BigDecimal losshistorytype) {
		this.losshistorytype = losshistorytype;
	}

	public BigDecimal getMovedpolicysourceaccountid() {
		return this.movedpolicysourceaccountid;
	}

	public void setMovedpolicysourceaccountid(BigDecimal movedpolicysourceaccountid) {
		this.movedpolicysourceaccountid = movedpolicysourceaccountid;
	}

	public BigDecimal getNonownerCgic() {
		return this.nonownerCgic;
	}

	public void setNonownerCgic(BigDecimal nonownerCgic) {
		this.nonownerCgic = nonownerCgic;
	}

	public BigDecimal getNumpriorlosses() {
		return this.numpriorlosses;
	}

	public void setNumpriorlosses(BigDecimal numpriorlosses) {
		this.numpriorlosses = numpriorlosses;
	}

	public String getOriginaleffectivedate() {
		return this.originaleffectivedate;
	}

	public void setOriginaleffectivedate(String originaleffectivedate) {
		this.originaleffectivedate = originaleffectivedate;
	}

	public BigDecimal getPackagerisk() {
		return this.packagerisk;
	}

	public void setPackagerisk(BigDecimal packagerisk) {
		this.packagerisk = packagerisk;
	}

	public BigDecimal getPolicystateCgic() {
		return this.policystateCgic;
	}

	public void setPolicystateCgic(BigDecimal policystateCgic) {
		this.policystateCgic = policystateCgic;
	}

	public BigDecimal getPremiumstatusCgic() {
		return this.premiumstatusCgic;
	}

	public void setPremiumstatusCgic(BigDecimal premiumstatusCgic) {
		this.premiumstatusCgic = premiumstatusCgic;
	}

	public BigDecimal getPrimarylanguage() {
		return this.primarylanguage;
	}

	public void setPrimarylanguage(BigDecimal primarylanguage) {
		this.primarylanguage = primarylanguage;
	}

	public BigDecimal getPrimarylocale() {
		return this.primarylocale;
	}

	public void setPrimarylocale(BigDecimal primarylocale) {
		this.primarylocale = primarylocale;
	}

	public BigDecimal getPriorpremiums() {
		return this.priorpremiums;
	}

	public void setPriorpremiums(BigDecimal priorpremiums) {
		this.priorpremiums = priorpremiums;
	}

	public BigDecimal getPriorpremiumsCur() {
		return this.priorpremiumsCur;
	}

	public void setPriorpremiumsCur(BigDecimal priorpremiumsCur) {
		this.priorpremiumsCur = priorpremiumsCur;
	}

	public BigDecimal getPriortotalincurred() {
		return this.priortotalincurred;
	}

	public void setPriortotalincurred(BigDecimal priortotalincurred) {
		this.priortotalincurred = priortotalincurred;
	}

	public BigDecimal getPriortotalincurredCur() {
		return this.priortotalincurredCur;
	}

	public void setPriortotalincurredCur(BigDecimal priortotalincurredCur) {
		this.priortotalincurredCur = priortotalincurredCur;
	}

	public BigDecimal getProducercodeofserviceid() {
		return this.producercodeofserviceid;
	}

	public void setProducercodeofserviceid(BigDecimal producercodeofserviceid) {
		this.producercodeofserviceid = producercodeofserviceid;
	}

	public String getProductcode() {
		return this.productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getPublicid() {
		return this.publicid;
	}

	public void setPublicid(String publicid) {
		this.publicid = publicid;
	}

	public BigDecimal getRetired() {
		return this.retired;
	}

	public void setRetired(BigDecimal retired) {
		this.retired = retired;
	}

	public String getRreCgic() {
		return this.rreCgic;
	}

	public void setRreCgic(String rreCgic) {
		this.rreCgic = rreCgic;
	}

	public String getSiteidCgic() {
		return this.siteidCgic;
	}

	public void setSiteidCgic(String siteidCgic) {
		this.siteidCgic = siteidCgic;
	}

	public BigDecimal getSr22Cgic() {
		return this.sr22Cgic;
	}

	public void setSr22Cgic(BigDecimal sr22Cgic) {
		this.sr22Cgic = sr22Cgic;
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

	public List<PcPolicyperiodDO> getPcPolicyperiodDOs() {
		return pcPolicyperiodDOs;
	}

	public void setPcPolicyperiodDOs(List<PcPolicyperiodDO> pcPolicyperiodDOs) {
		this.pcPolicyperiodDOs = pcPolicyperiodDOs;
	}

}