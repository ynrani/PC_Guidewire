package com.tdm.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_CLAIM_SRC_MAST database table.
 * 
 */
@Entity
@Table(name = "TDM_CLAIM_SRC_MAST")
@NamedQuery(name = "TdmClaimSrcMastDO.findAll", query = "SELECT t FROM TdmClaimSrcMastDO t")
public class TdmClaimSrcMastDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "CLAIM_SRC_DESC")
	private String claimSrcDesc;

	@Id
	private BigDecimal id;

	public TdmClaimSrcMastDO()
	{
	}

	public String getClaimSrcDesc()
	{
		return this.claimSrcDesc;
	}

	public void setClaimSrcDesc(String claimSrcDesc)
	{
		this.claimSrcDesc = claimSrcDesc;
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