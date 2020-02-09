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
 * The persistent class for the OTHERORPRIORPOLICY database table.
 * 
 */
@Entity
@Table(name = "OTHERORPRIORPOLICY")
@NamedQuery(name = "OtherorpriorpolicyDO.findAll", query = "SELECT o FROM OtherorpriorpolicyDO o")
public class OtherorpriorpolicyDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String aaaautobilimit;

	private String aaaautoinsurancescore;

	private BigDecimal aaaautopolicypending;

	private String aaaautopolicytier;

	@Column(name = "AAACOVERAGE_E")
	private BigDecimal aaacoverageE;

	private String dtype;

	private BigDecimal entitystatus;

	private String instancename;

	private String lob;

	private String policycd;

	private String policynumber;

	// bi-directional many-to-one association to LocationDO
	@OneToMany(mappedBy = "otherorpriorpolicy", fetch = FetchType.LAZY)
	private List<LocationDO> locations;

	// bi-directional many-to-one association to InsuredprincipalDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INSUREDPRINCIPALENTITY_ID")
	private InsuredprincipalDO insuredprincipal;

	// bi-directional many-to-one association to PolicydetailDO
	@ManyToOne(fetch = FetchType.LAZY)
	private PolicydetailDO policydetail;

	public OtherorpriorpolicyDO()
	{
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAaaautobilimit() {
		return aaaautobilimit;
	}

	public void setAaaautobilimit(String aaaautobilimit) {
		this.aaaautobilimit = aaaautobilimit;
	}

	public String getAaaautoinsurancescore() {
		return aaaautoinsurancescore;
	}

	public void setAaaautoinsurancescore(String aaaautoinsurancescore) {
		this.aaaautoinsurancescore = aaaautoinsurancescore;
	}

	public BigDecimal getAaaautopolicypending() {
		return aaaautopolicypending;
	}

	public void setAaaautopolicypending(BigDecimal aaaautopolicypending) {
		this.aaaautopolicypending = aaaautopolicypending;
	}

	public String getAaaautopolicytier() {
		return aaaautopolicytier;
	}

	public void setAaaautopolicytier(String aaaautopolicytier) {
		this.aaaautopolicytier = aaaautopolicytier;
	}

	public BigDecimal getAaacoverageE() {
		return aaacoverageE;
	}

	public void setAaacoverageE(BigDecimal aaacoverageE) {
		this.aaacoverageE = aaacoverageE;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public BigDecimal getEntitystatus() {
		return entitystatus;
	}

	public void setEntitystatus(BigDecimal entitystatus) {
		this.entitystatus = entitystatus;
	}

	public String getInstancename() {
		return instancename;
	}

	public void setInstancename(String instancename) {
		this.instancename = instancename;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getPolicycd() {
		return policycd;
	}

	public void setPolicycd(String policycd) {
		this.policycd = policycd;
	}

	public String getPolicynumber() {
		return policynumber;
	}

	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}

	public List<LocationDO> getLocations() {
		return locations;
	}

	public void setLocations(List<LocationDO> locations) {
		this.locations = locations;
	}

	public InsuredprincipalDO getInsuredprincipal() {
		return insuredprincipal;
	}

	public void setInsuredprincipal(InsuredprincipalDO insuredprincipal) {
		this.insuredprincipal = insuredprincipal;
	}

	public PolicydetailDO getPolicydetail() {
		return policydetail;
	}

	public void setPolicydetail(PolicydetailDO policydetail) {
		this.policydetail = policydetail;
	}

}