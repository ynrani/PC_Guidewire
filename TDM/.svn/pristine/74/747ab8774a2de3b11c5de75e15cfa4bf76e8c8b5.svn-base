package com.tesda.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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
 * The persistent class for the GENERALPARTYINFOENTITY database table.
 * 
 */
@Entity
@Table(name = "GENERALPARTYINFOENTITY")
@NamedQuery(name = "GeneralpartyinfoentityDO.findAll", query = "SELECT g FROM GeneralpartyinfoentityDO g")
public class GeneralpartyinfoentityDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private BigDecimal isdriver;

	// bi-directional many-to-one association to GeneralpartyinfoentityDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PREFERREDCONTACT_ID")
	private GeneralpartyinfoentityDO generalpartyinfoentity;

	// bi-directional many-to-one association to GeneralpartyinfoentityDO
	@OneToMany(mappedBy = "generalpartyinfoentity", fetch = FetchType.LAZY)
	private List<GeneralpartyinfoentityDO> generalpartyinfoentities;

	// bi-directional many-to-one association to PolicydetailDO
	@ManyToOne(fetch = FetchType.LAZY)
	private PolicydetailDO policydetail;

	public GeneralpartyinfoentityDO()
	{
	}

	public GeneralpartyinfoentityDO getGeneralpartyinfoentity() {
		return this.generalpartyinfoentity;
	}

	public void setGeneralpartyinfoentity(GeneralpartyinfoentityDO generalpartyinfoentity) {
		this.generalpartyinfoentity = generalpartyinfoentity;
	}

	public List<GeneralpartyinfoentityDO> getGeneralpartyinfoentities() {
		return this.generalpartyinfoentities;
	}

	public void setGeneralpartyinfoentities(List<GeneralpartyinfoentityDO> generalpartyinfoentities) {
		this.generalpartyinfoentities = generalpartyinfoentities;
	}

	public GeneralpartyinfoentityDO addGeneralpartyinfoentity(
			GeneralpartyinfoentityDO generalpartyinfoentity) {
		getGeneralpartyinfoentities().add(generalpartyinfoentity);
		generalpartyinfoentity.setGeneralpartyinfoentity(this);

		return generalpartyinfoentity;
	}

	public GeneralpartyinfoentityDO removeGeneralpartyinfoentity(
			GeneralpartyinfoentityDO generalpartyinfoentity) {
		getGeneralpartyinfoentities().remove(generalpartyinfoentity);
		generalpartyinfoentity.setGeneralpartyinfoentity(null);

		return generalpartyinfoentity;
	}

	public PolicydetailDO getPolicydetail() {
		return this.policydetail;
	}

	public void setPolicydetail(PolicydetailDO policydetail) {
		this.policydetail = policydetail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getIsdriver() {
		return isdriver;
	}

	public void setIsdriver(BigDecimal isdriver) {
		this.isdriver = isdriver;
	}

}