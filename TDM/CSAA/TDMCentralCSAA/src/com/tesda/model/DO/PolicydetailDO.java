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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

/**
 * The persistent class for the POLICYDETAIL database table.
 * 
 */
@Entity
@Table(name = "POLICYDETAIL")
@NamedQuery(name = "PolicydetailDO.findAll", query = "SELECT p FROM PolicydetailDO p")
public class PolicydetailDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private BigDecimal addresschanged;

	private String cardlanguagecd;

	private String city;

	private String coveragetypecd;

	private String dtype;

	private BigDecimal employersliabilityind;

	private BigDecimal entitystatus;

	private String excesstypecd;

	private String insuranceexplanation;

	private String liabilitycoveragetypecd;

	private String mailpolicyto;

	private BigDecimal namednonownedpolicyind;

	private BigDecimal numaddlocations;

	private BigDecimal numberofhouseholdpeople;

	private BigDecimal numcollectorvehicles;

	private BigDecimal numcorporatevehicles;

	private BigDecimal numofpools;

	private BigDecimal numprivatevehicles;

	private BigDecimal numunregistredvehicles;

	private BigDecimal numvehicles;

	private BigDecimal numvessels26;

	private BigDecimal numvessels27;

	private BigDecimal numvessels31;

	private BigDecimal numvessels36;

	private BigDecimal numvessels43;

	private BigDecimal numvessels55;

	private BigDecimal numvesselspersonal;

	private BigDecimal numvesselsunder26;

	private BigDecimal numvesselsupto26;

	private BigDecimal numyouthfuldrivers;

	private String oid;

	@Column(name = "OTHERORPRIORPOLICY_ID")
	private BigDecimal otherorpriorpolicyId;

	@Column(name = "POLICYADDITIONALINFO_ID")
	private BigDecimal policyadditionalinfoId;

	@Column(name = "POLICYDETAIL_ID")
	private BigDecimal policydetailId;

	private String policyindicatorcd;

	private String postalcode;

	private String presentcompanycd;

	private BigDecimal proffessionalliabilityind;

	private String ratingterritorycd;

	private String regioncd;

	@Column(name = "SELECTEDQUOTEVARIATION_ID")
	private BigDecimal selectedquotevariationId;

	private BigDecimal stuninsuredmotoristsind;

	@Column(name = "SUP_INFO_FK")
	private BigDecimal supInfoFk;

	private String typeofbusinesscd;

	private String typeofpolicycd;

	private String umcoveragetypecd;

	private String underlyinglimitcd;

	private String untype;

	private BigDecimal vehiclesind;

	private BigDecimal watercraftsind;

	// bi-directional many-to-one association to GeneralpartyinfoentityDO
	@OneToMany(mappedBy = "policydetail", fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	private List<GeneralpartyinfoentityDO> generalpartyinfoentities;

	// bi-directional many-to-one association to OtherorpriorpolicyDO
	@OneToMany(mappedBy = "policydetail", fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	private List<OtherorpriorpolicyDO> otherorpriorpolicies;

	public PolicydetailDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAddresschanged() {
		return this.addresschanged;
	}

	public void setAddresschanged(BigDecimal addresschanged) {
		this.addresschanged = addresschanged;
	}

	public String getCardlanguagecd() {
		return this.cardlanguagecd;
	}

	public void setCardlanguagecd(String cardlanguagecd) {
		this.cardlanguagecd = cardlanguagecd;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCoveragetypecd() {
		return this.coveragetypecd;
	}

	public void setCoveragetypecd(String coveragetypecd) {
		this.coveragetypecd = coveragetypecd;
	}

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public BigDecimal getEmployersliabilityind() {
		return this.employersliabilityind;
	}

	public void setEmployersliabilityind(BigDecimal employersliabilityind) {
		this.employersliabilityind = employersliabilityind;
	}

	public BigDecimal getEntitystatus() {
		return this.entitystatus;
	}

	public void setEntitystatus(BigDecimal entitystatus) {
		this.entitystatus = entitystatus;
	}

	public String getExcesstypecd() {
		return this.excesstypecd;
	}

	public void setExcesstypecd(String excesstypecd) {
		this.excesstypecd = excesstypecd;
	}

	public String getInsuranceexplanation() {
		return this.insuranceexplanation;
	}

	public void setInsuranceexplanation(String insuranceexplanation) {
		this.insuranceexplanation = insuranceexplanation;
	}

	public String getLiabilitycoveragetypecd() {
		return this.liabilitycoveragetypecd;
	}

	public void setLiabilitycoveragetypecd(String liabilitycoveragetypecd) {
		this.liabilitycoveragetypecd = liabilitycoveragetypecd;
	}

	public String getMailpolicyto() {
		return this.mailpolicyto;
	}

	public void setMailpolicyto(String mailpolicyto) {
		this.mailpolicyto = mailpolicyto;
	}

	public BigDecimal getNamednonownedpolicyind() {
		return this.namednonownedpolicyind;
	}

	public void setNamednonownedpolicyind(BigDecimal namednonownedpolicyind) {
		this.namednonownedpolicyind = namednonownedpolicyind;
	}

	public BigDecimal getNumaddlocations() {
		return this.numaddlocations;
	}

	public void setNumaddlocations(BigDecimal numaddlocations) {
		this.numaddlocations = numaddlocations;
	}

	public BigDecimal getNumberofhouseholdpeople() {
		return this.numberofhouseholdpeople;
	}

	public void setNumberofhouseholdpeople(BigDecimal numberofhouseholdpeople) {
		this.numberofhouseholdpeople = numberofhouseholdpeople;
	}

	public BigDecimal getNumcollectorvehicles() {
		return this.numcollectorvehicles;
	}

	public void setNumcollectorvehicles(BigDecimal numcollectorvehicles) {
		this.numcollectorvehicles = numcollectorvehicles;
	}

	public BigDecimal getNumcorporatevehicles() {
		return this.numcorporatevehicles;
	}

	public void setNumcorporatevehicles(BigDecimal numcorporatevehicles) {
		this.numcorporatevehicles = numcorporatevehicles;
	}

	public BigDecimal getNumofpools() {
		return this.numofpools;
	}

	public void setNumofpools(BigDecimal numofpools) {
		this.numofpools = numofpools;
	}

	public BigDecimal getNumprivatevehicles() {
		return this.numprivatevehicles;
	}

	public void setNumprivatevehicles(BigDecimal numprivatevehicles) {
		this.numprivatevehicles = numprivatevehicles;
	}

	public BigDecimal getNumunregistredvehicles() {
		return this.numunregistredvehicles;
	}

	public void setNumunregistredvehicles(BigDecimal numunregistredvehicles) {
		this.numunregistredvehicles = numunregistredvehicles;
	}

	public BigDecimal getNumvehicles() {
		return this.numvehicles;
	}

	public void setNumvehicles(BigDecimal numvehicles) {
		this.numvehicles = numvehicles;
	}

	public BigDecimal getNumvessels26() {
		return this.numvessels26;
	}

	public void setNumvessels26(BigDecimal numvessels26) {
		this.numvessels26 = numvessels26;
	}

	public BigDecimal getNumvessels27() {
		return this.numvessels27;
	}

	public void setNumvessels27(BigDecimal numvessels27) {
		this.numvessels27 = numvessels27;
	}

	public BigDecimal getNumvessels31() {
		return this.numvessels31;
	}

	public void setNumvessels31(BigDecimal numvessels31) {
		this.numvessels31 = numvessels31;
	}

	public BigDecimal getNumvessels36() {
		return this.numvessels36;
	}

	public void setNumvessels36(BigDecimal numvessels36) {
		this.numvessels36 = numvessels36;
	}

	public BigDecimal getNumvessels43() {
		return this.numvessels43;
	}

	public void setNumvessels43(BigDecimal numvessels43) {
		this.numvessels43 = numvessels43;
	}

	public BigDecimal getNumvessels55() {
		return this.numvessels55;
	}

	public void setNumvessels55(BigDecimal numvessels55) {
		this.numvessels55 = numvessels55;
	}

	public BigDecimal getNumvesselspersonal() {
		return this.numvesselspersonal;
	}

	public void setNumvesselspersonal(BigDecimal numvesselspersonal) {
		this.numvesselspersonal = numvesselspersonal;
	}

	public BigDecimal getNumvesselsunder26() {
		return this.numvesselsunder26;
	}

	public void setNumvesselsunder26(BigDecimal numvesselsunder26) {
		this.numvesselsunder26 = numvesselsunder26;
	}

	public BigDecimal getNumvesselsupto26() {
		return this.numvesselsupto26;
	}

	public void setNumvesselsupto26(BigDecimal numvesselsupto26) {
		this.numvesselsupto26 = numvesselsupto26;
	}

	public BigDecimal getNumyouthfuldrivers() {
		return this.numyouthfuldrivers;
	}

	public void setNumyouthfuldrivers(BigDecimal numyouthfuldrivers) {
		this.numyouthfuldrivers = numyouthfuldrivers;
	}

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public BigDecimal getOtherorpriorpolicyId() {
		return this.otherorpriorpolicyId;
	}

	public void setOtherorpriorpolicyId(BigDecimal otherorpriorpolicyId) {
		this.otherorpriorpolicyId = otherorpriorpolicyId;
	}

	public BigDecimal getPolicyadditionalinfoId() {
		return this.policyadditionalinfoId;
	}

	public void setPolicyadditionalinfoId(BigDecimal policyadditionalinfoId) {
		this.policyadditionalinfoId = policyadditionalinfoId;
	}

	public BigDecimal getPolicydetailId() {
		return this.policydetailId;
	}

	public void setPolicydetailId(BigDecimal policydetailId) {
		this.policydetailId = policydetailId;
	}

	public String getPolicyindicatorcd() {
		return this.policyindicatorcd;
	}

	public void setPolicyindicatorcd(String policyindicatorcd) {
		this.policyindicatorcd = policyindicatorcd;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getPresentcompanycd() {
		return this.presentcompanycd;
	}

	public void setPresentcompanycd(String presentcompanycd) {
		this.presentcompanycd = presentcompanycd;
	}

	public BigDecimal getProffessionalliabilityind() {
		return this.proffessionalliabilityind;
	}

	public void setProffessionalliabilityind(BigDecimal proffessionalliabilityind) {
		this.proffessionalliabilityind = proffessionalliabilityind;
	}

	public String getRatingterritorycd() {
		return this.ratingterritorycd;
	}

	public void setRatingterritorycd(String ratingterritorycd) {
		this.ratingterritorycd = ratingterritorycd;
	}

	public String getRegioncd() {
		return this.regioncd;
	}

	public void setRegioncd(String regioncd) {
		this.regioncd = regioncd;
	}

	public BigDecimal getSelectedquotevariationId() {
		return this.selectedquotevariationId;
	}

	public void setSelectedquotevariationId(BigDecimal selectedquotevariationId) {
		this.selectedquotevariationId = selectedquotevariationId;
	}

	public BigDecimal getStuninsuredmotoristsind() {
		return this.stuninsuredmotoristsind;
	}

	public void setStuninsuredmotoristsind(BigDecimal stuninsuredmotoristsind) {
		this.stuninsuredmotoristsind = stuninsuredmotoristsind;
	}

	public BigDecimal getSupInfoFk() {
		return this.supInfoFk;
	}

	public void setSupInfoFk(BigDecimal supInfoFk) {
		this.supInfoFk = supInfoFk;
	}

	public String getTypeofbusinesscd() {
		return this.typeofbusinesscd;
	}

	public void setTypeofbusinesscd(String typeofbusinesscd) {
		this.typeofbusinesscd = typeofbusinesscd;
	}

	public String getTypeofpolicycd() {
		return this.typeofpolicycd;
	}

	public void setTypeofpolicycd(String typeofpolicycd) {
		this.typeofpolicycd = typeofpolicycd;
	}

	public String getUmcoveragetypecd() {
		return this.umcoveragetypecd;
	}

	public void setUmcoveragetypecd(String umcoveragetypecd) {
		this.umcoveragetypecd = umcoveragetypecd;
	}

	public String getUnderlyinglimitcd() {
		return this.underlyinglimitcd;
	}

	public void setUnderlyinglimitcd(String underlyinglimitcd) {
		this.underlyinglimitcd = underlyinglimitcd;
	}

	public String getUntype() {
		return this.untype;
	}

	public void setUntype(String untype) {
		this.untype = untype;
	}

	public BigDecimal getVehiclesind() {
		return this.vehiclesind;
	}

	public void setVehiclesind(BigDecimal vehiclesind) {
		this.vehiclesind = vehiclesind;
	}

	public BigDecimal getWatercraftsind() {
		return this.watercraftsind;
	}

	public void setWatercraftsind(BigDecimal watercraftsind) {
		this.watercraftsind = watercraftsind;
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
		generalpartyinfoentity.setPolicydetail(this);

		return generalpartyinfoentity;
	}

	public GeneralpartyinfoentityDO removeGeneralpartyinfoentity(
			GeneralpartyinfoentityDO generalpartyinfoentity) {
		getGeneralpartyinfoentities().remove(generalpartyinfoentity);
		generalpartyinfoentity.setPolicydetail(null);

		return generalpartyinfoentity;
	}

	public List<OtherorpriorpolicyDO> getOtherorpriorpolicies() {
		return this.otherorpriorpolicies;
	}

	public void setOtherorpriorpolicies(List<OtherorpriorpolicyDO> otherorpriorpolicies) {
		this.otherorpriorpolicies = otherorpriorpolicies;
	}

	public OtherorpriorpolicyDO addOtherorpriorpolicy(OtherorpriorpolicyDO otherorpriorpolicy) {
		getOtherorpriorpolicies().add(otherorpriorpolicy);
		otherorpriorpolicy.setPolicydetail(this);

		return otherorpriorpolicy;
	}

	public OtherorpriorpolicyDO removeOtherorpriorpolicy(OtherorpriorpolicyDO otherorpriorpolicy) {
		getOtherorpriorpolicies().remove(otherorpriorpolicy);
		otherorpriorpolicy.setPolicydetail(null);

		return otherorpriorpolicy;
	}

}