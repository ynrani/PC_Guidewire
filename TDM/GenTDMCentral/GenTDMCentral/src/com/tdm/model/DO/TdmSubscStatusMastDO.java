package com.tdm.model.DO;


import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the TDM_SUBSC_STATUS_MAST database table.
 * 
 */
@Entity
@Table(name="TDM_SUBSC_STATUS_MAST")
@NamedQuery(name="TdmSubscStatusMastDO.findAll", query="SELECT t FROM TdmSubscStatusMastDO t")
public class TdmSubscStatusMastDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private BigDecimal id;

	@Column(name="SUBSC_STATUS_DESC")
	private String subscStatusDesc;

	public TdmSubscStatusMastDO() {
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getSubscStatusDesc() {
		return this.subscStatusDesc;
	}

	public void setSubscStatusDesc(String subscStatusDesc) {
		this.subscStatusDesc = subscStatusDesc;
	}

}