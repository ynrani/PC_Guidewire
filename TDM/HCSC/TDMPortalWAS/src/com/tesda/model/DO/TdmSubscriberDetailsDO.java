package com.tesda.model.DO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the SUBSCRIBER_DETAILS database table.
 * 
 */
@Entity
@Table(name = "SBUSCRIBER_DETAILS")
@NamedQuery(name = "TdmSubscriberDetailsDO.findAll", query = "SELECT t FROM TdmSubscriberDetailsDO t")
public class TdmSubscriberDetailsDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SUBS_ID")
	private int subscriberId;

	@Column(name = "ACCOUNT_NAME")
	private String accountName;

	@Column(name = "ACCOUNT_NUMBER")
	private int accountNum;

	@Column(name = "AGE")
	private int age;

	@Column(name = "COVRG_AGRMT_ID")
	private int covrgAgrmtID;

	@Column(name = "COVRG_ELE_CD")
	private String covrgELeCD;

	@Column(name = "COVRG_ELE_NM")
	private String covrgEleName;

	@Column(name = "DENT_COVG_IND")
	private String dentCovgInd;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "LGCY_SYS_NM")
	private String lgcySysNum;

	@Column(name = "LOB_CD")
	private String lobCD;

	@Column(name = "LOC_ID")
	private int locId;

	@Temporal(TemporalType.DATE)
	@Column(name = "DOB")
	private Date dob;

	@Column(name = "MBR_CAT")
	private String membrCat;

	@Temporal(TemporalType.DATE)
	@Column(name = "MBR_EFF_DT")
	private Date membrEffectiveDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "MBR_END_DT")
	private Date membrEndDate;

	@Column(name = "MBR_ID")
	private int membrId;

	@Temporal(TemporalType.DATE)
	@Column(name = "MBR_SUB_ID_EFF_DT")
	private Date membrSubIdEffctDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "MBR_SUB_ID_END_DT")
	private Date membrSubIdEndDate;

	@Column(name = "MED_COVG_IND")
	private String medCoverInd;

	@Column(name = "PRESC_COVG_IND")
	private String prescCovgInd;

	@Column(name = "PROD_CD")
	private String prodCD;

	@Column(name = "RELSHP_CD")
	private String reltionShipCd;

	@Column(name = "RELSHP_NM")
	private String relationShipName;

	@Column(name = "STATE")
	private String state;

	@Column(name = "SUB_PTY_ID")
	private String subscrPtyId;

	@Column(name = "SUB_STATUS")
	private String subscrStatus;

	@Column(name = "VISION_COVG_IND")
	private String visionCoverId;

	@Column(name = "ZIPCODE")
	private String zipCode;

	// @OneToOne(mappedBy = "tdmSubscrDtls")
	// TdmClaimTypeDetailsDO tdmClaimdetails;

	@OneToMany(mappedBy = "membrId")
	private List<TdmClaimTypeDetailsDO> tdmClaimdetails;

	public String getCovrgELeCD()
	{
		return covrgELeCD;
	}

	public void setCovrgELeCD(String covrgELeCD)
	{
		this.covrgELeCD = covrgELeCD;
	}

	public List<TdmClaimTypeDetailsDO> getTdmClaimdetails()
	{
		return tdmClaimdetails;
	}

	public void setTdmClaimdetails(List<TdmClaimTypeDetailsDO> tdmClaimdetails)
	{
		this.tdmClaimdetails = tdmClaimdetails;
	}

	public int getSubscriberId()
	{
		return subscriberId;
	}

	public void setSubscriberId(int subscriberId)
	{
		this.subscriberId = subscriberId;
	}

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public int getAccountNum()
	{
		return accountNum;
	}

	public void setAccountNum(int accountNum)
	{
		this.accountNum = accountNum;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getCovrgAgrmtID()
	{
		return covrgAgrmtID;
	}

	public void setCovrgAgrmtID(int covrgAgrmtID)
	{
		this.covrgAgrmtID = covrgAgrmtID;
	}

	public String getCovrgEleCD()
	{
		return covrgELeCD;
	}

	public void setCovrgElemtCD(String covrgELeCD)
	{
		this.covrgELeCD = covrgELeCD;
	}

	public String getCovrgEleName()
	{
		return covrgEleName;
	}

	public void setCovrgEleName(String covrgEleName)
	{
		this.covrgEleName = covrgEleName;
	}

	public String getDentCovgInd()
	{
		return dentCovgInd;
	}

	public void setDentCovgInd(String dentCovgInd)
	{
		this.dentCovgInd = dentCovgInd;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getLgcySysNum()
	{
		return lgcySysNum;
	}

	public void setLgcySysNum(String lgcySysNum)
	{
		this.lgcySysNum = lgcySysNum;
	}

	public String getLobCD()
	{
		return lobCD;
	}

	public void setLobCD(String lobCD)
	{
		this.lobCD = lobCD;
	}

	public int getLocId()
	{
		return locId;
	}

	public void setLocId(int locId)
	{
		this.locId = locId;
	}

	public Date getDob()
	{
		return dob;
	}

	public void setDob(Date dob)
	{
		this.dob = dob;
	}

	public String getMembrCat()
	{
		return membrCat;
	}

	public void setMembrCat(String membrCat)
	{
		this.membrCat = membrCat;
	}

	public Date getMembrEffectiveDate()
	{
		return membrEffectiveDate;
	}

	public void setMembrEffectiveDate(Date membrEffectiveDate)
	{
		this.membrEffectiveDate = membrEffectiveDate;
	}

	public Date getMembrEndDate()
	{
		return membrEndDate;
	}

	public void setMembrEndDate(Date membrEndDate)
	{
		this.membrEndDate = membrEndDate;
	}

	public int getMembrId()
	{
		return membrId;
	}

	public void setMembrId(int membrId)
	{
		this.membrId = membrId;
	}

	public Date getMembrSubIdEffctDate()
	{
		return membrSubIdEffctDate;
	}

	public void setMembrSubIdEffctDate(Date membrSubIdEffctDate)
	{
		this.membrSubIdEffctDate = membrSubIdEffctDate;
	}

	public Date getMembrSubIdEndDate()
	{
		return membrSubIdEndDate;
	}

	public void setMembrSubIdEndDate(Date membrSubIdEndDate)
	{
		this.membrSubIdEndDate = membrSubIdEndDate;
	}

	public String getMedCoverInd()
	{
		return medCoverInd;
	}

	public void setMedCoverInd(String medCoverInd)
	{
		this.medCoverInd = medCoverInd;
	}

	public String getPrescCovgInd()
	{
		return prescCovgInd;
	}

	public void setPrescCovgInd(String prescCovgInd)
	{
		this.prescCovgInd = prescCovgInd;
	}

	public String getProdCD()
	{
		return prodCD;
	}

	public void setProdCD(String prodCD)
	{
		this.prodCD = prodCD;
	}

	public String getReltionShipCd()
	{
		return reltionShipCd;
	}

	public void setReltionShipCd(String reltionShipCd)
	{
		this.reltionShipCd = reltionShipCd;
	}

	public String getRelationShipName()
	{
		return relationShipName;
	}

	public void setRelationShipName(String relationShipName)
	{
		this.relationShipName = relationShipName;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getSubscrPtyId()
	{
		return subscrPtyId;
	}

	public void setSubscrPtyId(String subscrPtyId)
	{
		this.subscrPtyId = subscrPtyId;
	}

	public String getSubscrStatus()
	{
		return subscrStatus;
	}

	public void setSubscrStatus(String subscrStatus)
	{
		this.subscrStatus = subscrStatus;
	}

	public String getVisionCoverId()
	{
		return visionCoverId;
	}

	public void setVisionCoverId(String visionCoverId)
	{
		this.visionCoverId = visionCoverId;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
}
