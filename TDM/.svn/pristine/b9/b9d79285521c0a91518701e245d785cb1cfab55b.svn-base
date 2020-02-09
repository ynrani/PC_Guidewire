package com.tdm.model.DO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TDM_CLAIM_LINE_DETAILS database table.
 * 
 */
@Entity
@Table(name = "TDM_CLAIM_LINE_DETAILS")
@NamedQuery(name = "TdmClaimLineDetailDO.findAll", query = "SELECT t FROM TdmClaimLineDetailDO t")
public class TdmClaimLineDetailDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String dx;

	@Temporal(TemporalType.DATE)
	private Date fromdt;

	private String modifier;

	private String pos;

	@Column(name = "\"PROC\"")
	private String proc;

	private String tin;

	@Temporal(TemporalType.DATE)
	private Date todt;

	private String units;

	@Id
	@ManyToOne
	@JoinColumn(name = "CLAIM_ID")
	private TdmClaimDO tdmClaim;

	public TdmClaimLineDetailDO()
	{
	}

	public String getDx()
	{
		return this.dx;
	}

	public void setDx(String dx)
	{
		this.dx = dx;
	}

	public Date getFromdt()
	{
		return this.fromdt;
	}

	public void setFromdt(Date fromdt)
	{
		this.fromdt = fromdt;
	}

	public String getModifier()
	{
		return this.modifier;
	}

	public void setModifier(String modifier)
	{
		this.modifier = modifier;
	}

	public String getPos()
	{
		return this.pos;
	}

	public void setPos(String pos)
	{
		this.pos = pos;
	}

	public String getProc()
	{
		return this.proc;
	}

	public void setProc(String proc)
	{
		this.proc = proc;
	}

	public String getTin()
	{
		return this.tin;
	}

	public void setTin(String tin)
	{
		this.tin = tin;
	}

	public Date getTodt()
	{
		return this.todt;
	}

	public void setTodt(Date todt)
	{
		this.todt = todt;
	}

	public String getUnits()
	{
		return this.units;
	}

	public void setUnits(String units)
	{
		this.units = units;
	}

	public TdmClaimDO getTdmClaim()
	{
		return this.tdmClaim;
	}

	public void setTdmClaim(TdmClaimDO tdmClaim)
	{
		this.tdmClaim = tdmClaim;
	}

}