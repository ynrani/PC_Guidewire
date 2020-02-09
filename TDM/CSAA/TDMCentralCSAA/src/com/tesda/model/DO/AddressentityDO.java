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
 * The persistent class for the ADDRESSENTITY database table.
 * 
 */
@Entity
@Table(name = "ADDRESSENTITY")
@NamedQuery(name = "AddressentityDO.findAll", query = "SELECT a FROM AddressentityDO a")
public class AddressentityDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "COMMUNICATIONINFO_ID")
	private BigDecimal communicationinfoId;

	private String dtype;

	private String predirectioncd;

	// bi-directional many-to-one association to AaadwellscoreDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PPCREPORT_ID")
	private AaadwellscoreDO aaadwellscore;

	// bi-directional many-to-one association to ContactentityDO
	@ManyToOne(fetch = FetchType.LAZY)
	private ContactentityDO contactentity;

	// bi-directional many-to-one association to LocationDO
	@OneToMany(mappedBy = "addressentity", fetch = FetchType.LAZY)
	private List<LocationDO> locations;

	// bi-directional many-to-one association to RegisteredownerinfoDO
	@OneToMany(mappedBy = "addressentity", fetch = FetchType.LAZY)
	private List<RegisteredownerinfoDO> registeredownerinfos;

	public AddressentityDO()
	{
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCommunicationinfoId() {
		return communicationinfoId;
	}

	public void setCommunicationinfoId(BigDecimal communicationinfoId) {
		this.communicationinfoId = communicationinfoId;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getPredirectioncd() {
		return predirectioncd;
	}

	public void setPredirectioncd(String predirectioncd) {
		this.predirectioncd = predirectioncd;
	}

	public AaadwellscoreDO getAaadwellscore() {
		return aaadwellscore;
	}

	public void setAaadwellscore(AaadwellscoreDO aaadwellscore) {
		this.aaadwellscore = aaadwellscore;
	}

	public ContactentityDO getContactentity() {
		return contactentity;
	}

	public void setContactentity(ContactentityDO contactentity) {
		this.contactentity = contactentity;
	}

	public List<LocationDO> getLocations() {
		return locations;
	}

	public void setLocations(List<LocationDO> locations) {
		this.locations = locations;
	}

	public List<RegisteredownerinfoDO> getRegisteredownerinfos() {
		return registeredownerinfos;
	}

	public void setRegisteredownerinfos(List<RegisteredownerinfoDO> registeredownerinfos) {
		this.registeredownerinfos = registeredownerinfos;
	}

}