package com.tesda.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the CLAIM_TYPE_DETAILS database table.
 * 
 */
@Entity
@Table(name = "CLAIM_TYPE_DETAILS")
@NamedQuery(name = "TdmClaimTypeDetailsDO.findAll", query = "SELECT t FROM TdmClaimTypeDetailsDO t")
public class TdmClaimTypeDetailsDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SUBS_ID")
	private int subscrId;

	@Column(name = "MBR_ID")
	private int membrId;

	@Column(name = "SUB_PTY_ID")
	private int subPtyId;

	@Column(name = "DEPT_PTY_ID")
	private int deptPtyId;

	@Column(name = "CLAIM_TYPE")
	private String claimType;

	@Column(name = "EOB_SPPRESS_IND")
	private String eobSupressInd;

	@Column(name = "DENTAL_CLAIM_IND")
	private String dentalClaimInd;

	@Column(name = "MED_CLAIM_IND")
	private String medClaimInd;

	@Column(name = "PRES_CLAIM_IND")
	private String prescrCliamInd;

	@Column(name = "OTHER_CLAIM_IND")
	private String otherClaimInd;

	@OneToOne
	@JoinColumn(name = "SUBS_ID", insertable = false, updatable = false)
	private TdmSubscriberDetailsDO tdmSubscrDtls;

	public String getClaimType()
	{
		return claimType;
	}

	public void setClaimType(String claimType)
	{
		this.claimType = claimType;
	}

	public String getDentalClaimInd()
	{
		return dentalClaimInd;
	}

	public void setDentalClaimInd(String dentalClaimInd)
	{
		this.dentalClaimInd = dentalClaimInd;
	}

	public int getDeptPtyId()
	{
		return deptPtyId;
	}

	public void setDeptPtyId(int deptPtyId)
	{
		this.deptPtyId = deptPtyId;
	}

	public String getEobSupressInd()
	{
		return eobSupressInd;
	}

	public void setEobSupressInd(String eobSupressInd)
	{
		this.eobSupressInd = eobSupressInd;
	}

	public int getMembrId()
	{
		return membrId;
	}

	public void setMembrId(int membrId)
	{
		this.membrId = membrId;
	}

	public String getMedClaimInd()
	{
		return medClaimInd;
	}

	public void setMedClaimInd(String medClaimInd)
	{
		this.medClaimInd = medClaimInd;
	}

	public String getOtherClaimInd()
	{
		return otherClaimInd;
	}

	public void setOtherClaimInd(String otherClaimInd)
	{
		this.otherClaimInd = otherClaimInd;
	}

	public String getPrescrCliamInd()
	{
		return prescrCliamInd;
	}

	public void setPrescrCliamInd(String prescrCliamInd)
	{
		this.prescrCliamInd = prescrCliamInd;
	}

	public int getSubscrId()
	{
		return subscrId;
	}

	public void setSubscrId(int subscrInd)
	{
		this.subscrId = subscrInd;
	}

	public int getSubPtyId()
	{
		return subPtyId;
	}

	public void setSubPtyId(int subPtyId)
	{
		this.subPtyId = subPtyId;
	}
}
