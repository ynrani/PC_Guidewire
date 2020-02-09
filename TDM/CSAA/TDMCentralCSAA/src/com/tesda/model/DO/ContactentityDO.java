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

/**
 * The persistent class for the CONTACTENTITY database table.
 * 
 */
@Entity
@Table(name = "CONTACTENTITY")
@NamedQuery(name = "ContactentityDO.findAll", query = "SELECT c FROM ContactentityDO c")
public class ContactentityDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String aaapobox;

	private String addressline1;

	private String addressline2;

	private String addressline3;

	private String addresstype;

	private String addressvalidatedind;

	private String building;

	private String city;

	private String componentinstancename;

	private String connectedtoinstancename;

	private String countrycd;

	private String county;

	private String dtype;

	private String email;

	private String emailtypecd;

	private BigDecimal entitystatus;

	@Column(name = "GENERALPARTYINFOENTITY_ID")
	private BigDecimal generalpartyinfoentityId;

	private String instancename;

	private String isoterritorycode;

	private String isoterritoryname;

	private BigDecimal lastcomponentinfoseqno;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String nationaladdressid;

	private String oid;

	private String otherretirement;

	private String phonenumber;

	private String phonetypecd;

	private BigDecimal poboxind;

	private String postalcode;

	private String postdirectioncd;

	private String predirectioncd;

	private BigDecimal preferredind;

	private String producercomponentname;

	private double producercomponentversion;

	private String region;

	private String regioncd;

	private String retirementcommunity;

	private BigDecimal sameinsuredaddressind;

	private BigDecimal seqidx;

	private BigDecimal standartized;

	private String stateprovcd;

	private String streetname;

	private String streetnumber;

	private String streettype;

	private String suburb;

	private String township;

	private String unitnumber;

	private BigDecimal usagetype;

	// bi-directional many-to-one association to AccidentviolationDO
	@OneToMany(mappedBy = "contactentity", fetch = FetchType.LAZY)
	private List<AccidentviolationDO> accidentviolations;

	// bi-directional many-to-one association to AddressentityDO
	@OneToMany(mappedBy = "contactentity", fetch = FetchType.LAZY)
	private List<AddressentityDO> addressentities;

	// bi-directional many-to-one association to RegisteredownerinfoDO
	@OneToMany(mappedBy = "contactentity", fetch = FetchType.LAZY)
	private List<RegisteredownerinfoDO> registeredownerinfos;

	// bi-directional many-to-one association to RiskitemDO
	@OneToMany(mappedBy = "contactentity", fetch = FetchType.LAZY)
	private List<RiskitemDO> riskitems;

	public ContactentityDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAaapobox() {
		return this.aaapobox;
	}

	public void setAaapobox(String aaapobox) {
		this.aaapobox = aaapobox;
	}

	public String getAddressline1() {
		return this.addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return this.addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getAddressline3() {
		return this.addressline3;
	}

	public void setAddressline3(String addressline3) {
		this.addressline3 = addressline3;
	}

	public String getAddresstype() {
		return this.addresstype;
	}

	public void setAddresstype(String addresstype) {
		this.addresstype = addresstype;
	}

	public String getAddressvalidatedind() {
		return this.addressvalidatedind;
	}

	public void setAddressvalidatedind(String addressvalidatedind) {
		this.addressvalidatedind = addressvalidatedind;
	}

	public String getBuilding() {
		return this.building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getCountrycd() {
		return this.countrycd;
	}

	public void setCountrycd(String countrycd) {
		this.countrycd = countrycd;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailtypecd() {
		return this.emailtypecd;
	}

	public void setEmailtypecd(String emailtypecd) {
		this.emailtypecd = emailtypecd;
	}

	public BigDecimal getEntitystatus() {
		return this.entitystatus;
	}

	public void setEntitystatus(BigDecimal entitystatus) {
		this.entitystatus = entitystatus;
	}

	public BigDecimal getGeneralpartyinfoentityId() {
		return this.generalpartyinfoentityId;
	}

	public void setGeneralpartyinfoentityId(BigDecimal generalpartyinfoentityId) {
		this.generalpartyinfoentityId = generalpartyinfoentityId;
	}

	public String getInstancename() {
		return this.instancename;
	}

	public void setInstancename(String instancename) {
		this.instancename = instancename;
	}

	public String getIsoterritorycode() {
		return this.isoterritorycode;
	}

	public void setIsoterritorycode(String isoterritorycode) {
		this.isoterritorycode = isoterritorycode;
	}

	public String getIsoterritoryname() {
		return this.isoterritoryname;
	}

	public void setIsoterritoryname(String isoterritoryname) {
		this.isoterritoryname = isoterritoryname;
	}

	public BigDecimal getLastcomponentinfoseqno() {
		return this.lastcomponentinfoseqno;
	}

	public void setLastcomponentinfoseqno(BigDecimal lastcomponentinfoseqno) {
		this.lastcomponentinfoseqno = lastcomponentinfoseqno;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getNationaladdressid() {
		return this.nationaladdressid;
	}

	public void setNationaladdressid(String nationaladdressid) {
		this.nationaladdressid = nationaladdressid;
	}

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOtherretirement() {
		return this.otherretirement;
	}

	public void setOtherretirement(String otherretirement) {
		this.otherretirement = otherretirement;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPhonetypecd() {
		return this.phonetypecd;
	}

	public void setPhonetypecd(String phonetypecd) {
		this.phonetypecd = phonetypecd;
	}

	public BigDecimal getPoboxind() {
		return this.poboxind;
	}

	public void setPoboxind(BigDecimal poboxind) {
		this.poboxind = poboxind;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getPostdirectioncd() {
		return this.postdirectioncd;
	}

	public void setPostdirectioncd(String postdirectioncd) {
		this.postdirectioncd = postdirectioncd;
	}

	public String getPredirectioncd() {
		return this.predirectioncd;
	}

	public void setPredirectioncd(String predirectioncd) {
		this.predirectioncd = predirectioncd;
	}

	public BigDecimal getPreferredind() {
		return this.preferredind;
	}

	public void setPreferredind(BigDecimal preferredind) {
		this.preferredind = preferredind;
	}

	public String getProducercomponentname() {
		return this.producercomponentname;
	}

	public void setProducercomponentname(String producercomponentname) {
		this.producercomponentname = producercomponentname;
	}

	public double getProducercomponentversion() {
		return this.producercomponentversion;
	}

	public void setProducercomponentversion(double producercomponentversion) {
		this.producercomponentversion = producercomponentversion;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRegioncd() {
		return this.regioncd;
	}

	public void setRegioncd(String regioncd) {
		this.regioncd = regioncd;
	}

	public String getRetirementcommunity() {
		return this.retirementcommunity;
	}

	public void setRetirementcommunity(String retirementcommunity) {
		this.retirementcommunity = retirementcommunity;
	}

	public BigDecimal getSameinsuredaddressind() {
		return this.sameinsuredaddressind;
	}

	public void setSameinsuredaddressind(BigDecimal sameinsuredaddressind) {
		this.sameinsuredaddressind = sameinsuredaddressind;
	}

	public BigDecimal getSeqidx() {
		return this.seqidx;
	}

	public void setSeqidx(BigDecimal seqidx) {
		this.seqidx = seqidx;
	}

	public BigDecimal getStandartized() {
		return this.standartized;
	}

	public void setStandartized(BigDecimal standartized) {
		this.standartized = standartized;
	}

	public String getStateprovcd() {
		return this.stateprovcd;
	}

	public void setStateprovcd(String stateprovcd) {
		this.stateprovcd = stateprovcd;
	}

	public String getStreetname() {
		return this.streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public String getStreetnumber() {
		return this.streetnumber;
	}

	public void setStreetnumber(String streetnumber) {
		this.streetnumber = streetnumber;
	}

	public String getStreettype() {
		return this.streettype;
	}

	public void setStreettype(String streettype) {
		this.streettype = streettype;
	}

	public String getSuburb() {
		return this.suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getTownship() {
		return this.township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public String getUnitnumber() {
		return this.unitnumber;
	}

	public void setUnitnumber(String unitnumber) {
		this.unitnumber = unitnumber;
	}

	public BigDecimal getUsagetype() {
		return this.usagetype;
	}

	public void setUsagetype(BigDecimal usagetype) {
		this.usagetype = usagetype;
	}

	public List<AccidentviolationDO> getAccidentviolations() {
		return this.accidentviolations;
	}

	public void setAccidentviolations(List<AccidentviolationDO> accidentviolations) {
		this.accidentviolations = accidentviolations;
	}

	public AccidentviolationDO addAccidentviolation(AccidentviolationDO accidentviolation) {
		getAccidentviolations().add(accidentviolation);
		accidentviolation.setContactentity(this);

		return accidentviolation;
	}

	public AccidentviolationDO removeAccidentviolation(AccidentviolationDO accidentviolation) {
		getAccidentviolations().remove(accidentviolation);
		accidentviolation.setContactentity(null);

		return accidentviolation;
	}

	public List<AddressentityDO> getAddressentities() {
		return this.addressentities;
	}

	public void setAddressentities(List<AddressentityDO> addressentities) {
		this.addressentities = addressentities;
	}

	public AddressentityDO addAddressentity(AddressentityDO addressentity) {
		getAddressentities().add(addressentity);
		addressentity.setContactentity(this);

		return addressentity;
	}

	public AddressentityDO removeAddressentity(AddressentityDO addressentity) {
		getAddressentities().remove(addressentity);
		addressentity.setContactentity(null);

		return addressentity;
	}

	public List<RegisteredownerinfoDO> getRegisteredownerinfos() {
		return this.registeredownerinfos;
	}

	public void setRegisteredownerinfos(List<RegisteredownerinfoDO> registeredownerinfos) {
		this.registeredownerinfos = registeredownerinfos;
	}

	public RegisteredownerinfoDO addRegisteredownerinfo(RegisteredownerinfoDO registeredownerinfo) {
		getRegisteredownerinfos().add(registeredownerinfo);
		registeredownerinfo.setContactentity(this);

		return registeredownerinfo;
	}

	public RegisteredownerinfoDO removeRegisteredownerinfo(RegisteredownerinfoDO registeredownerinfo) {
		getRegisteredownerinfos().remove(registeredownerinfo);
		registeredownerinfo.setContactentity(null);

		return registeredownerinfo;
	}

	public List<RiskitemDO> getRiskitems() {
		return this.riskitems;
	}

	public void setRiskitems(List<RiskitemDO> riskitems) {
		this.riskitems = riskitems;
	}

	public RiskitemDO addRiskitem(RiskitemDO riskitem) {
		getRiskitems().add(riskitem);
		riskitem.setContactentity(this);

		return riskitem;
	}

	public RiskitemDO removeRiskitem(RiskitemDO riskitem) {
		getRiskitems().remove(riskitem);
		riskitem.setContactentity(null);

		return riskitem;
	}

}