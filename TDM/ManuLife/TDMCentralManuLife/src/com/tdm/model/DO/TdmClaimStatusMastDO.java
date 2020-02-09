package com.tdm.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_CLAIM_STATUS_MAST database table.
 * 
 */
@Entity
@Table(name = "TDM_CLAIM_STATUS_MAST")
@NamedQuery(name = "TdmClaimStatusMastDO.findAll", query = "SELECT t FROM TdmClaimStatusMastDO t")
public class TdmClaimStatusMastDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "CLAIM_STATUS_DESC")
	private String claimStatusDesc;

	@Id
	private BigDecimal id;

	public TdmClaimStatusMastDO()
	{
	}

	public String getClaimStatusDesc()
	{
		return this.claimStatusDesc;
	}

	public void setClaimStatusDesc(String claimStatusDesc)
	{
		this.claimStatusDesc = claimStatusDesc;
	}

	public BigDecimal getId()
	{
		return this.id;
	}

	public void setId(BigDecimal id)
	{
		this.id = id;
	}

}