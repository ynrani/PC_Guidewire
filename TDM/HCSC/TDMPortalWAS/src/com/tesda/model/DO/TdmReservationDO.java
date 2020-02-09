package com.tesda.model.DO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TDM_RESERVATION database table.
 * 
 */
@Entity
@Table(name = "RESERVATION")
@NamedQuery(name = "TdmReservationDO.findAll", query = "SELECT t FROM TdmReservationDO t")
public class TdmReservationDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	// @Id
	// @SequenceGenerator(name = "RESERVATION_1_ID_SEQ", sequenceName =
	// "ID_SEQ", allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "RESERVATION_1_ID_SEQ")
	// @Column(name = "RECORD_ID")
	// private long recordId;

	@Id
	@Column(name = "USER_ID")
	private String userId;

	@Temporal(TemporalType.DATE)
	@Column(name = "REC_CREATE_DATE")
	private Date recCreateDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "RESV_DATE")
	private Date reserveDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "UNRESV_DATE")
	private Date unreservDate;

	@Column(name = "TEST_CASE_ID")
	private String testCaseId;

	@Column(name = "TEST_CASE_NAME")
	private String testCaseName;

	@Column(name = "PROJECT_ID")
	private String projectId;

	@Column(name = "LOCKED")
	private String locked;

	@Column(name = "SUB_ID")
	private String subscrId;

	@Column(name = "MBR_TYPE")
	private String membrType;

	@Column(name = "FIRST_NM")
	private String firstName;

	@Column(name = "LAST_NM")
	private String lastName;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "HOME_ZIP_CD")
	private String homeZipCode;

	@Column(name = "ACCNT_NUM")
	private String accountNum;

	@Column(name = "ACCNT_NM")
	private String accountName;

	@Column(name = "SUPP_EOB_IND")
	private String suppressEOBInd;

	@Column(name = "BLENDED_GOV")
	private String blendedGov;

	@Column(name = "BLENDED_CAT")
	private String blendedCat;

	@Column(name = "COVERAGE")
	private String coverage;

	@Column(name = "EXISTING_CLAIM_TYPE")
	private String extClaimType;

	@Column(name = "GRP_NUM")
	private String groupNum;

	public TdmReservationDO()
	{
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public Date getRecCreateDate()
	{
		return recCreateDate;
	}

	public void setRecCreateDate(Date recCreateDate)
	{
		this.recCreateDate = recCreateDate;
	}

	public Date getReserveDate()
	{
		return reserveDate;
	}

	public void setReserveDate(Date reserveDate)
	{
		this.reserveDate = reserveDate;
	}

	public Date getUnreservDate()
	{
		return unreservDate;
	}

	public void setUnreservDate(Date unreservDate)
	{
		this.unreservDate = unreservDate;
	}

	public String getTestCaseId()
	{
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId)
	{
		this.testCaseId = testCaseId;
	}

	public String getTestCaseName()
	{
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName)
	{
		this.testCaseName = testCaseName;
	}

	public String getProjectId()
	{
		return projectId;
	}

	public void setProjectId(String projectId)
	{
		this.projectId = projectId;
	}

	public String getLocked()
	{
		return locked;
	}

	public void setLocked(String locked)
	{
		this.locked = locked;
	}

	public String getSubscrId()
	{
		return subscrId;
	}

	public void setSubscrId(String subscrId)
	{
		this.subscrId = subscrId;
	}

	public String getMembrType()
	{
		return membrType;
	}

	public void setMembrType(String membrType)
	{
		this.membrType = membrType;
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

	public String getDob()
	{
		return dob;
	}

	public void setDob(String dob)
	{
		this.dob = dob;
	}

	public String getHomeZipCode()
	{
		return homeZipCode;
	}

	public void setHomeZipCode(String homeZipCode)
	{
		this.homeZipCode = homeZipCode;
	}

	public String getAccountNum()
	{
		return accountNum;
	}

	public void setAccountNum(String accountNum)
	{
		this.accountNum = accountNum;
	}

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public String getSuppressEOBInd()
	{
		return suppressEOBInd;
	}

	public void setSuppressEOBInd(String suppressEOBInd)
	{
		this.suppressEOBInd = suppressEOBInd;
	}

	public String getBlendedGov()
	{
		return blendedGov;
	}

	public void setBlendedGov(String blendedGov)
	{
		this.blendedGov = blendedGov;
	}

	public String getBlendedCat()
	{
		return blendedCat;
	}

	public void setBlendedCat(String blendedCat)
	{
		this.blendedCat = blendedCat;
	}

	public String getCoverage()
	{
		return coverage;
	}

	public void setCoverage(String coverage)
	{
		this.coverage = coverage;
	}

	public String getExtClaimType()
	{
		return extClaimType;
	}

	public void setExtClaimType(String extClaimType)
	{
		this.extClaimType = extClaimType;
	}

	public String getGroupNum()
	{
		return groupNum;
	}

	public void setGroupNum(String groupNum)
	{
		this.groupNum = groupNum;
	}
}