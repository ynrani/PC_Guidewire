package com.tesda.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the REGISTEREDOWNERINFO database table.
 * 
 */
@Entity
@Table(name = "REGISTEREDOWNERINFO")
@NamedQuery(name = "RegisteredownerinfoDO.findAll", query = "SELECT r FROM RegisteredownerinfoDO r")
public class RegisteredownerinfoDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private BigDecimal driverseqno;

	private String dtype;

	private BigDecimal entitystatus;

	private String instancename;

	// bi-directional many-to-one association to AddressentityDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REGISTEREDOWNERADDRESS_ID")
	private AddressentityDO addressentity;

	// bi-directional many-to-one association to ContactentityDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESSCONTACT_ID")
	private ContactentityDO contactentity;

	// bi-directional many-to-one association to RiskitemDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLERISKITEM_ID")
	private RiskitemDO riskitem1;

	// bi-directional many-to-one association to RiskitemDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLEENTITY_ID")
	private RiskitemDO riskitem2;

	public RegisteredownerinfoDO()
	{
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getDriverseqno() {
		return driverseqno;
	}

	public void setDriverseqno(BigDecimal driverseqno) {
		this.driverseqno = driverseqno;
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

	public AddressentityDO getAddressentity() {
		return addressentity;
	}

	public void setAddressentity(AddressentityDO addressentity) {
		this.addressentity = addressentity;
	}

	public ContactentityDO getContactentity() {
		return contactentity;
	}

	public void setContactentity(ContactentityDO contactentity) {
		this.contactentity = contactentity;
	}

	public RiskitemDO getRiskitem1() {
		return riskitem1;
	}

	public void setRiskitem1(RiskitemDO riskitem1) {
		this.riskitem1 = riskitem1;
	}

	public RiskitemDO getRiskitem2() {
		return riskitem2;
	}

	public void setRiskitem2(RiskitemDO riskitem2) {
		this.riskitem2 = riskitem2;
	}

}