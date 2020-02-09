package com.tdm.model.DO;


import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the TDM_SUBSC_TYPE_MAST database table.
 * 
 */
@Entity
@Table(name="TDM_SUBSC_TYPE_MAST")
@NamedQuery(name="TdmSubscTypeMastDO.findAll", query="SELECT t FROM TdmSubscTypeMastDO t")
public class TdmSubscTypeMastDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private BigDecimal id;

	@Column(name="SUBSC_TYPE_DESC")
	private String subscTypeDesc;

	public TdmSubscTypeMastDO() {
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getSubscTypeDesc() {
		return this.subscTypeDesc;
	}

	public void setSubscTypeDesc(String subscTypeDesc) {
		this.subscTypeDesc = subscTypeDesc;
	}

}