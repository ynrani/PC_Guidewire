package com.tesda.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
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
 * The persistent class for the DWELLDETAIL database table.
 * 
 */
@Entity
@Table(name = "DWELLDETAIL")
@NamedQuery(name = "DwelldetailDO.findAll", query = "SELECT d FROM DwelldetailDO d")
public class DwelldetailDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String aaatenantpolicynumber;

	@Column(name = "COC_ID")
	private BigDecimal cocId;

	@Column(name = "RATINGINFO_ID")
	private BigDecimal ratinginfoId;

	// bi-directional many-to-one association to BrushfiresurchargeDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRUSHFIRE_ID")
	private BrushfiresurchargeDO brushfiresurcharge;

	// bi-directional many-to-one association to ConstructioninfoDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONSTRINFO_ID")
	private ConstructioninfoDO constructioninfo;

	public DwelldetailDO()
	{
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAaatenantpolicynumber() {
		return aaatenantpolicynumber;
	}

	public void setAaatenantpolicynumber(String aaatenantpolicynumber) {
		this.aaatenantpolicynumber = aaatenantpolicynumber;
	}

	public BigDecimal getCocId() {
		return cocId;
	}

	public void setCocId(BigDecimal cocId) {
		this.cocId = cocId;
	}

	public BigDecimal getRatinginfoId() {
		return ratinginfoId;
	}

	public void setRatinginfoId(BigDecimal ratinginfoId) {
		this.ratinginfoId = ratinginfoId;
	}

	public BrushfiresurchargeDO getBrushfiresurcharge() {
		return brushfiresurcharge;
	}

	public void setBrushfiresurcharge(BrushfiresurchargeDO brushfiresurcharge) {
		this.brushfiresurcharge = brushfiresurcharge;
	}

	public ConstructioninfoDO getConstructioninfo() {
		return constructioninfo;
	}

	public void setConstructioninfo(ConstructioninfoDO constructioninfo) {
		this.constructioninfo = constructioninfo;
	}

}