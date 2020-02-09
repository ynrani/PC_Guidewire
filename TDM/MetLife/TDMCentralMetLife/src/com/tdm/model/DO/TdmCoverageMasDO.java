package com.tdm.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_COVERAGE_MAS database table.
 * 
 */
@Entity
@Table(name = "TDM_COVERAGE_MAS")
@NamedQuery(name = "TdmCoverageMasDO.findAll", query = "SELECT t FROM TdmCoverageMasDO t")
public class TdmCoverageMasDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "COVERAGE_DESC")
	private String coverageDesc;

	@Id
	@Column(name = "COVERAGE_ID")
	private BigDecimal coverageId;

	public TdmCoverageMasDO()
	{
	}

	public String getCoverageDesc()
	{
		return this.coverageDesc;
	}

	public void setCoverageDesc(String coverageDesc)
	{
		this.coverageDesc = coverageDesc;
	}

	public BigDecimal getCoverageId()
	{
		return this.coverageId;
	}

	public void setCoverageId(BigDecimal coverageId)
	{
		this.coverageId = coverageId;
	}

}