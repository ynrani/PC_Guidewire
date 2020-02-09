package com.tdm.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_PROVIDER_CONT_MAS database table.
 * 
 */
@Entity
@Table(name = "TDM_PROVIDER_CONT_MAS")
@NamedQuery(name = "TdmProviderContMaDO.findAll", query = "SELECT t FROM TdmProviderContMaDO t")
public class TdmProviderContMaDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CONTRACT_ID")
	private String contractId;

	@Column(name = "CONTRACT_NAME")
	private String contractName;

	public TdmProviderContMaDO()
	{
	}

	public String getContractId()
	{
		return this.contractId;
	}

	public void setContractId(String contractId)
	{
		this.contractId = contractId;
	}

	public String getContractName()
	{
		return this.contractName;
	}

	public void setContractName(String contractName)
	{
		this.contractName = contractName;
	}

}