package com.tdm.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_POS_MAST database table.
 * 
 */
@Entity
@Table(name = "TDM_POS_MAST")
@NamedQuery(name = "TdmPosMastDO.findAll", query = "SELECT t FROM TdmPosMastDO t")
public class TdmPosMastDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private BigDecimal id;

	@Column(name = "POS_DESC")
	private String posDesc;

	public TdmPosMastDO()
	{
	}

	public BigDecimal getId()
	{
		return this.id;
	}

	public void setId(BigDecimal id)
	{
		this.id = id;
	}

	public String getPosDesc()
	{
		return this.posDesc;
	}

	public void setPosDesc(String posDesc)
	{
		this.posDesc = posDesc;
	}

}