package com.tesda.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TDM_RESERVATION database table.
 * 
 */
@Entity
@Table(name = "CSAA_POL_LIST")
@NamedQuery(name = "CassPolListDO.findAll", query = "SELECT t FROM CassPolListDO t")
public class CassPolListDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "POLICYNUMBER")
	private String policyNumber;

	@Column(name = "LOB")
	private String lob;

	@Column(name = "FLAG")
	private String flag;

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

}