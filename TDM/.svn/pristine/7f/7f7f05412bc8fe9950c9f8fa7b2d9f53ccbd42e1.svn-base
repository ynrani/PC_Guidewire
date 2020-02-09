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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the LOCATION database table.
 * 
 */
@Entity
@Table(name = "LOCATION")
@NamedQuery(name = "LocationDO.findAll", query = "SELECT l FROM LocationDO l")
public class LocationDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ADDRESSCONTACTENTITY_ID")
	private BigDecimal addresscontactentityId;

	private String addressline1;

	private String addressline2;

	private String addressline3;

	private String city;

	private String componentinstancename;

	private String connectedtoinstancename;

	private String countrycd;

	private String county;

	private String description;

	private String dtype;

	private BigDecimal entitystatus;

	private String instancename;

	private BigDecimal lastcomponentinfoseqno;

	private String locationname;

	private String numberoffamilies;

	private String oid;

	private String postalcode;

	private String producercomponentname;

	private double producercomponentversion;

	private String reflocationoid;

	private String regioncd;

	private BigDecimal rentedtoothersind;

	private String risklocationcd;

	private BigDecimal sameaddressind;

	private BigDecimal seasonalsecondaryusageind;

	private BigDecimal seqidx;

	private BigDecimal standartized;

	private String stateprovcd;

	private String streetname;

	private String streetnumber;

	private String streettype;

	private String underlyingpolicynumber;

	private String unitnumber;

	private BigDecimal usagetype;

	// bi-directional many-to-one association to AddressentityDO
	@ManyToOne(fetch = FetchType.LAZY)
	private AddressentityDO addressentity;

	// bi-directional many-to-one association to LocationDO
	@ManyToOne(fetch = FetchType.LAZY)
	private LocationDO location;

	// bi-directional many-to-one association to LocationDO
	@OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
	private List<LocationDO> locations;

	// bi-directional many-to-one association to OtherorpriorpolicyDO
	@ManyToOne(fetch = FetchType.LAZY)
	private OtherorpriorpolicyDO otherorpriorpolicy;

	public LocationDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAddresscontactentityId() {
		return this.addresscontactentityId;
	}

	public void setAddresscontactentityId(BigDecimal addresscontactentityId) {
		this.addresscontactentityId = addresscontactentityId;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public BigDecimal getEntitystatus() {
		return this.entitystatus;
	}

	public void setEntitystatus(BigDecimal entitystatus) {
		this.entitystatus = entitystatus;
	}

	public String getInstancename() {
		return this.instancename;
	}

	public void setInstancename(String instancename) {
		this.instancename = instancename;
	}

	public BigDecimal getLastcomponentinfoseqno() {
		return this.lastcomponentinfoseqno;
	}

	public void setLastcomponentinfoseqno(BigDecimal lastcomponentinfoseqno) {
		this.lastcomponentinfoseqno = lastcomponentinfoseqno;
	}

	public String getLocationname() {
		return this.locationname;
	}

	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}

	public String getNumberoffamilies() {
		return this.numberoffamilies;
	}

	public void setNumberoffamilies(String numberoffamilies) {
		this.numberoffamilies = numberoffamilies;
	}

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
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

	public String getReflocationoid() {
		return this.reflocationoid;
	}

	public void setReflocationoid(String reflocationoid) {
		this.reflocationoid = reflocationoid;
	}

	public String getRegioncd() {
		return this.regioncd;
	}

	public void setRegioncd(String regioncd) {
		this.regioncd = regioncd;
	}

	public BigDecimal getRentedtoothersind() {
		return this.rentedtoothersind;
	}

	public void setRentedtoothersind(BigDecimal rentedtoothersind) {
		this.rentedtoothersind = rentedtoothersind;
	}

	public String getRisklocationcd() {
		return this.risklocationcd;
	}

	public void setRisklocationcd(String risklocationcd) {
		this.risklocationcd = risklocationcd;
	}

	public BigDecimal getSameaddressind() {
		return this.sameaddressind;
	}

	public void setSameaddressind(BigDecimal sameaddressind) {
		this.sameaddressind = sameaddressind;
	}

	public BigDecimal getSeasonalsecondaryusageind() {
		return this.seasonalsecondaryusageind;
	}

	public void setSeasonalsecondaryusageind(BigDecimal seasonalsecondaryusageind) {
		this.seasonalsecondaryusageind = seasonalsecondaryusageind;
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

	public String getUnderlyingpolicynumber() {
		return this.underlyingpolicynumber;
	}

	public void setUnderlyingpolicynumber(String underlyingpolicynumber) {
		this.underlyingpolicynumber = underlyingpolicynumber;
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

	public AddressentityDO getAddressentity() {
		return this.addressentity;
	}

	public void setAddressentity(AddressentityDO addressentity) {
		this.addressentity = addressentity;
	}

	public LocationDO getLocation() {
		return this.location;
	}

	public void setLocation(LocationDO location) {
		this.location = location;
	}

	public List<LocationDO> getLocations() {
		return this.locations;
	}

	public void setLocations(List<LocationDO> locations) {
		this.locations = locations;
	}

	public LocationDO addLocation(LocationDO location) {
		getLocations().add(location);
		location.setLocation(this);

		return location;
	}

	public LocationDO removeLocation(LocationDO location) {
		getLocations().remove(location);
		location.setLocation(null);

		return location;
	}

	public OtherorpriorpolicyDO getOtherorpriorpolicy() {
		return this.otherorpriorpolicy;
	}

	public void setOtherorpriorpolicy(OtherorpriorpolicyDO otherorpriorpolicy) {
		this.otherorpriorpolicy = otherorpriorpolicy;
	}

}