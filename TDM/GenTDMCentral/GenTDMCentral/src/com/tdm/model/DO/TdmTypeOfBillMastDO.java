package com.tdm.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_TYPE_OF_BILL_MAST database table.
 * 
 */
@Entity
@Table(name = "TDM_TYPE_OF_BILL_MAST")
@NamedQuery(name = "TdmTypeOfBillMastDO.findAll", query = "SELECT t FROM TdmTypeOfBillMastDO t")
public class TdmTypeOfBillMastDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "BILL_TYPE_DESC")
	private String billTypeDesc;

	@Id
	private String id;

	public TdmTypeOfBillMastDO()
	{
	}

	public String getBillTypeDesc()
	{
		return this.billTypeDesc;
	}

	public void setBillTypeDesc(String billTypeDesc)
	{
		this.billTypeDesc = billTypeDesc;
	}

	public String getId()
	{
		return this.id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

}