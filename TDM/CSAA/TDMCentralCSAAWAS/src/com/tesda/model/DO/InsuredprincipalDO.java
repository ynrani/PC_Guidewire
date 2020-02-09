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

/**
 * The persistent class for the INSUREDPRINCIPAL database table.
 * 
 */
@Entity
@Table(name = "INSUREDPRINCIPAL")
@NamedQuery(name = "InsuredprincipalDO.findAll", query = "SELECT i FROM InsuredprincipalDO i")
public class InsuredprincipalDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String dtype;

	private BigDecimal groupsponsorind;

	private String instancename;

	private Timestamp insuredbasedt;

	@Column(name = "INSUREDINFO_ID")
	private BigDecimal insuredinfoId;

	@Column(name = "POLICYDETAIL_ID")
	private BigDecimal policydetailId;

	@Column(name = "POLICYPRIORCARRIER_ID")
	private BigDecimal policypriorcarrierId;

	private String postalcode;

	@Column(name = "PRIMARYADDRESSENTITY_ID")
	private BigDecimal primaryaddressentityId;

	private BigDecimal primaryinsured;

	private String principalrolecd;

	@Column(name = "PRIORADDRESS_ID")
	private BigDecimal prioraddressId;

	// bi-directional many-to-one association to OtherorpriorpolicyDO
	@OneToMany(mappedBy = "insuredprincipal", fetch = FetchType.LAZY)
	private List<OtherorpriorpolicyDO> otherorpriorpolicies;

	public InsuredprincipalDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OtherorpriorpolicyDO addOtherorpriorpolicy(OtherorpriorpolicyDO otherorpriorpolicy) {
		getOtherorpriorpolicies().add(otherorpriorpolicy);
		otherorpriorpolicy.setInsuredprincipal(this);

		return otherorpriorpolicy;
	}

	public OtherorpriorpolicyDO removeOtherorpriorpolicy(OtherorpriorpolicyDO otherorpriorpolicy) {
		getOtherorpriorpolicies().remove(otherorpriorpolicy);
		otherorpriorpolicy.setInsuredprincipal(null);

		return otherorpriorpolicy;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public BigDecimal getGroupsponsorind() {
		return groupsponsorind;
	}

	public void setGroupsponsorind(BigDecimal groupsponsorind) {
		this.groupsponsorind = groupsponsorind;
	}

	public String getInstancename() {
		return instancename;
	}

	public void setInstancename(String instancename) {
		this.instancename = instancename;
	}

	public Timestamp getInsuredbasedt() {
		return insuredbasedt;
	}

	public void setInsuredbasedt(Timestamp insuredbasedt) {
		this.insuredbasedt = insuredbasedt;
	}

	public BigDecimal getInsuredinfoId() {
		return insuredinfoId;
	}

	public void setInsuredinfoId(BigDecimal insuredinfoId) {
		this.insuredinfoId = insuredinfoId;
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

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public BigDecimal getPrimaryaddressentityId() {
		return primaryaddressentityId;
	}

	public void setPrimaryaddressentityId(BigDecimal primaryaddressentityId) {
		this.primaryaddressentityId = primaryaddressentityId;
	}

	public BigDecimal getPrimaryinsured() {
		return primaryinsured;
	}

	public void setPrimaryinsured(BigDecimal primaryinsured) {
		this.primaryinsured = primaryinsured;
	}

	public String getPrincipalrolecd() {
		return principalrolecd;
	}

	public void setPrincipalrolecd(String principalrolecd) {
		this.principalrolecd = principalrolecd;
	}

	public BigDecimal getPrioraddressId() {
		return prioraddressId;
	}

	public void setPrioraddressId(BigDecimal prioraddressId) {
		this.prioraddressId = prioraddressId;
	}

	public List<OtherorpriorpolicyDO> getOtherorpriorpolicies() {
		return otherorpriorpolicies;
	}

	public void setOtherorpriorpolicies(List<OtherorpriorpolicyDO> otherorpriorpolicies) {
		this.otherorpriorpolicies = otherorpriorpolicies;
	}

}