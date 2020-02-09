package com.tesda.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the CONSTRUCTIONINFO database table.
 * 
 */
@Entity
@Table(name = "CONSTRUCTIONINFO")
@NamedQuery(name = "ConstructioninfoDO.findAll", query = "SELECT c FROM ConstructioninfoDO c")
public class ConstructioninfoDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private BigDecimal aaamasonryveneer;

	@Temporal(TemporalType.DATE)
	private Date closeofescrowdate;

	private BigDecimal cocind;

	private String componentinstancename;

	private String condomcoveragedwellingreqstd;

	private String connectedtoinstancename;

	private String constructiondescription;

	private String constructiontypecd;

	private BigDecimal distancetobrush;

	private String dtype;

	private String effectivenessgradetypecd;

	private BigDecimal entitystatus;

	@Column(name = "\"FLOOR\"")
	private BigDecimal floor;

	private String hailrestrating;

	private String instancename;

	private BigDecimal isaccessallyr;

	private BigDecimal isassmbbylincconstructor;

	private BigDecimal ishistorichome;

	private BigDecimal isoreplacementcost;

	private BigDecimal lastcomponentinfoseqno;

	private BigDecimal livingarea;

	private BigDecimal marketvalue;

	private String numberofstories;

	private String numofempl;

	private String oid;

	private String openingprotectioncd;

	private String otherreason;

	private String owned;

	private BigDecimal personalpropertyvalue;

	private String producercomponentname;

	private double producercomponentversion;

	private Timestamp purchasedate;

	private BigDecimal replacementcost;

	private String replacementcostdiffersreason;

	private String roofcondition;

	private String roofdeckattachmentcd;

	private String roofdeckmaterialcd;

	private String roofdescription;

	private String roofgeometrytypecd;

	private String roofshape;

	private String rooftype;

	private String roofwallattachmentcd;

	private String securitybar;

	private String shutterscd;

	private BigDecimal trackcocind;

	private String windowwindresistancecd;

	private BigDecimal yearbuilt;

	private String yearbuiltadd;

	private BigDecimal yearupdated;

	// bi-directional many-to-one association to DwelldetailDO
	@OneToMany(mappedBy = "constructioninfo", fetch = FetchType.LAZY)
	private List<DwelldetailDO> dwelldetails;

	public ConstructioninfoDO()
	{
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAaamasonryveneer() {
		return this.aaamasonryveneer;
	}

	public void setAaamasonryveneer(BigDecimal aaamasonryveneer) {
		this.aaamasonryveneer = aaamasonryveneer;
	}

	public Date getCloseofescrowdate() {
		return this.closeofescrowdate;
	}

	public void setCloseofescrowdate(Date closeofescrowdate) {
		this.closeofescrowdate = closeofescrowdate;
	}

	public BigDecimal getCocind() {
		return this.cocind;
	}

	public void setCocind(BigDecimal cocind) {
		this.cocind = cocind;
	}

	public String getComponentinstancename() {
		return this.componentinstancename;
	}

	public void setComponentinstancename(String componentinstancename) {
		this.componentinstancename = componentinstancename;
	}

	public String getCondomcoveragedwellingreqstd() {
		return this.condomcoveragedwellingreqstd;
	}

	public void setCondomcoveragedwellingreqstd(String condomcoveragedwellingreqstd) {
		this.condomcoveragedwellingreqstd = condomcoveragedwellingreqstd;
	}

	public String getConnectedtoinstancename() {
		return this.connectedtoinstancename;
	}

	public void setConnectedtoinstancename(String connectedtoinstancename) {
		this.connectedtoinstancename = connectedtoinstancename;
	}

	public String getConstructiondescription() {
		return this.constructiondescription;
	}

	public void setConstructiondescription(String constructiondescription) {
		this.constructiondescription = constructiondescription;
	}

	public String getConstructiontypecd() {
		return this.constructiontypecd;
	}

	public void setConstructiontypecd(String constructiontypecd) {
		this.constructiontypecd = constructiontypecd;
	}

	public BigDecimal getDistancetobrush() {
		return this.distancetobrush;
	}

	public void setDistancetobrush(BigDecimal distancetobrush) {
		this.distancetobrush = distancetobrush;
	}

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getEffectivenessgradetypecd() {
		return this.effectivenessgradetypecd;
	}

	public void setEffectivenessgradetypecd(String effectivenessgradetypecd) {
		this.effectivenessgradetypecd = effectivenessgradetypecd;
	}

	public BigDecimal getEntitystatus() {
		return this.entitystatus;
	}

	public void setEntitystatus(BigDecimal entitystatus) {
		this.entitystatus = entitystatus;
	}

	public BigDecimal getFloor() {
		return this.floor;
	}

	public void setFloor(BigDecimal floor) {
		this.floor = floor;
	}

	public String getHailrestrating() {
		return this.hailrestrating;
	}

	public void setHailrestrating(String hailrestrating) {
		this.hailrestrating = hailrestrating;
	}

	public String getInstancename() {
		return this.instancename;
	}

	public void setInstancename(String instancename) {
		this.instancename = instancename;
	}

	public BigDecimal getIsaccessallyr() {
		return this.isaccessallyr;
	}

	public void setIsaccessallyr(BigDecimal isaccessallyr) {
		this.isaccessallyr = isaccessallyr;
	}

	public BigDecimal getIsassmbbylincconstructor() {
		return this.isassmbbylincconstructor;
	}

	public void setIsassmbbylincconstructor(BigDecimal isassmbbylincconstructor) {
		this.isassmbbylincconstructor = isassmbbylincconstructor;
	}

	public BigDecimal getIshistorichome() {
		return this.ishistorichome;
	}

	public void setIshistorichome(BigDecimal ishistorichome) {
		this.ishistorichome = ishistorichome;
	}

	public BigDecimal getIsoreplacementcost() {
		return this.isoreplacementcost;
	}

	public void setIsoreplacementcost(BigDecimal isoreplacementcost) {
		this.isoreplacementcost = isoreplacementcost;
	}

	public BigDecimal getLastcomponentinfoseqno() {
		return this.lastcomponentinfoseqno;
	}

	public void setLastcomponentinfoseqno(BigDecimal lastcomponentinfoseqno) {
		this.lastcomponentinfoseqno = lastcomponentinfoseqno;
	}

	public BigDecimal getLivingarea() {
		return this.livingarea;
	}

	public void setLivingarea(BigDecimal livingarea) {
		this.livingarea = livingarea;
	}

	public BigDecimal getMarketvalue() {
		return this.marketvalue;
	}

	public void setMarketvalue(BigDecimal marketvalue) {
		this.marketvalue = marketvalue;
	}

	public String getNumberofstories() {
		return this.numberofstories;
	}

	public void setNumberofstories(String numberofstories) {
		this.numberofstories = numberofstories;
	}

	public String getNumofempl() {
		return this.numofempl;
	}

	public void setNumofempl(String numofempl) {
		this.numofempl = numofempl;
	}

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOpeningprotectioncd() {
		return this.openingprotectioncd;
	}

	public void setOpeningprotectioncd(String openingprotectioncd) {
		this.openingprotectioncd = openingprotectioncd;
	}

	public String getOtherreason() {
		return this.otherreason;
	}

	public void setOtherreason(String otherreason) {
		this.otherreason = otherreason;
	}

	public String getOwned() {
		return this.owned;
	}

	public void setOwned(String owned) {
		this.owned = owned;
	}

	public BigDecimal getPersonalpropertyvalue() {
		return this.personalpropertyvalue;
	}

	public void setPersonalpropertyvalue(BigDecimal personalpropertyvalue) {
		this.personalpropertyvalue = personalpropertyvalue;
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

	public Timestamp getPurchasedate() {
		return this.purchasedate;
	}

	public void setPurchasedate(Timestamp purchasedate) {
		this.purchasedate = purchasedate;
	}

	public BigDecimal getReplacementcost() {
		return this.replacementcost;
	}

	public void setReplacementcost(BigDecimal replacementcost) {
		this.replacementcost = replacementcost;
	}

	public String getReplacementcostdiffersreason() {
		return this.replacementcostdiffersreason;
	}

	public void setReplacementcostdiffersreason(String replacementcostdiffersreason) {
		this.replacementcostdiffersreason = replacementcostdiffersreason;
	}

	public String getRoofcondition() {
		return this.roofcondition;
	}

	public void setRoofcondition(String roofcondition) {
		this.roofcondition = roofcondition;
	}

	public String getRoofdeckattachmentcd() {
		return this.roofdeckattachmentcd;
	}

	public void setRoofdeckattachmentcd(String roofdeckattachmentcd) {
		this.roofdeckattachmentcd = roofdeckattachmentcd;
	}

	public String getRoofdeckmaterialcd() {
		return this.roofdeckmaterialcd;
	}

	public void setRoofdeckmaterialcd(String roofdeckmaterialcd) {
		this.roofdeckmaterialcd = roofdeckmaterialcd;
	}

	public String getRoofdescription() {
		return this.roofdescription;
	}

	public void setRoofdescription(String roofdescription) {
		this.roofdescription = roofdescription;
	}

	public String getRoofgeometrytypecd() {
		return this.roofgeometrytypecd;
	}

	public void setRoofgeometrytypecd(String roofgeometrytypecd) {
		this.roofgeometrytypecd = roofgeometrytypecd;
	}

	public String getRoofshape() {
		return this.roofshape;
	}

	public void setRoofshape(String roofshape) {
		this.roofshape = roofshape;
	}

	public String getRooftype() {
		return this.rooftype;
	}

	public void setRooftype(String rooftype) {
		this.rooftype = rooftype;
	}

	public String getRoofwallattachmentcd() {
		return this.roofwallattachmentcd;
	}

	public void setRoofwallattachmentcd(String roofwallattachmentcd) {
		this.roofwallattachmentcd = roofwallattachmentcd;
	}

	public String getSecuritybar() {
		return this.securitybar;
	}

	public void setSecuritybar(String securitybar) {
		this.securitybar = securitybar;
	}

	public String getShutterscd() {
		return this.shutterscd;
	}

	public void setShutterscd(String shutterscd) {
		this.shutterscd = shutterscd;
	}

	public BigDecimal getTrackcocind() {
		return this.trackcocind;
	}

	public void setTrackcocind(BigDecimal trackcocind) {
		this.trackcocind = trackcocind;
	}

	public String getWindowwindresistancecd() {
		return this.windowwindresistancecd;
	}

	public void setWindowwindresistancecd(String windowwindresistancecd) {
		this.windowwindresistancecd = windowwindresistancecd;
	}

	public BigDecimal getYearbuilt() {
		return this.yearbuilt;
	}

	public void setYearbuilt(BigDecimal yearbuilt) {
		this.yearbuilt = yearbuilt;
	}

	public String getYearbuiltadd() {
		return this.yearbuiltadd;
	}

	public void setYearbuiltadd(String yearbuiltadd) {
		this.yearbuiltadd = yearbuiltadd;
	}

	public BigDecimal getYearupdated() {
		return this.yearupdated;
	}

	public void setYearupdated(BigDecimal yearupdated) {
		this.yearupdated = yearupdated;
	}

	public List<DwelldetailDO> getDwelldetails() {
		return this.dwelldetails;
	}

	public void setDwelldetails(List<DwelldetailDO> dwelldetails) {
		this.dwelldetails = dwelldetails;
	}

	public DwelldetailDO addDwelldetail(DwelldetailDO dwelldetail) {
		getDwelldetails().add(dwelldetail);
		dwelldetail.setConstructioninfo(this);

		return dwelldetail;
	}

	public DwelldetailDO removeDwelldetail(DwelldetailDO dwelldetail) {
		getDwelldetails().remove(dwelldetail);
		dwelldetail.setConstructioninfo(null);

		return dwelldetail;
	}

}