package com.tdm.model.DO;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TDM_SUBSC_LOB_MAST database table.
 * 
 */
@Entity
@Table(name="TDM_SUBSC_LOB_MAST")
@NamedQuery(name="TdmSubscLobMastDO.findAll", query="SELECT t FROM TdmSubscLobMastDO t")
public class TdmSubscLobMastDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private BigDecimal id;

	@Column(name="SUBSC_LOB_DESC")
	private String subscLobDesc;

	public TdmSubscLobMastDO() {
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getSubscLobDesc() {
		return this.subscLobDesc;
	}

	public void setSubscLobDesc(String subscLobDesc) {
		this.subscLobDesc = subscLobDesc;
	}

}